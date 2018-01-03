package com.example.zengersoong.uptilldawn;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;


public class DrawerRecycleMap extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private EditText budgetinput, locationinput;


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<String> planner = new ArrayList<>();
    private PlannerDbHelper plannerDbHelper;
    private SQLiteDatabase plannerDb;
    private Button travelNow;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_recycle_map);

        LayoutInflater factory = getLayoutInflater();
//        View v = factory.inflate(R.menu.drawer_recycle_map,null);

        final ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setBackgroundColor(Color.WHITE);
        recyclerView = findViewById(R.id.drawer_recycler_view);
        adapter = new DrawerAdapter(planner);
        LinearLayoutManager layoutManager = new LinearLayoutManager(DrawerRecycleMap.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        prepareLocationData();


        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(), recyclerView, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                String myAttraction = planner.get(position);
                final String attractionName = myAttraction;
                String SQL_DELETE_ENTRY = "DELETE FROM " + AttractionsContract.AttractionsEntry.TABLE_NAME + " WHERE " + AttractionsContract.AttractionsEntry.COL_LOCATION + "= '" + attractionName + "'";
                plannerDb.execSQL(SQL_DELETE_ENTRY);
                Toast.makeText(DrawerRecycleMap.this, "Deleted " + attractionName + " from Planner", Toast.LENGTH_SHORT).show();

                planner.remove(position);
                adapter.notifyItemRemoved(position);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //----------------------------switch-----------------------------------//
        final Switch bruteswitch = (Switch)findViewById(R.id.bruteSwitch);
        bruteswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(),"Brute algorithm selected",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Fast algorithm selected",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //----------------------------switch-----------------------------------//
        //----------------------------budgetInput-----------------------------//
        budgetinput = (EditText) findViewById(R.id.budgetInput);

        //----------------------------budgetInput-----------------------------//


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    //------------------------Go to next Page -----------------------------------//
        travelNow = (Button) findViewById(R.id.travelnow);


        travelNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final double Budget;

                try {
                    String budget = budgetinput.getText().toString(); // use the budget here for algo part
                    Budget = Double.parseDouble(budget);
                } catch( NumberFormatException e) {
                    Toast.makeText(DrawerRecycleMap.this, "Budget entry invalid", Toast.LENGTH_SHORT).show();
                    return;
                }

                if ( planner.size() == 0 ) {
                    Toast.makeText(DrawerRecycleMap.this, "No Attraction was selected", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                if(bruteswitch.isChecked()){
                    String SQL_QUERY_TABLE = "SELECT _id FROM " + AttractionsContract.AttractionsEntry.TABLE_NAME;
                    int total = plannerDb.rawQuery(SQL_QUERY_TABLE,null).getCount();
                    if (total > 4){
                        AlertDialog.Builder builder = new AlertDialog.Builder(DrawerRecycleMap.this);
                        builder.setTitle("Warning");
                        builder.setMessage("Calculating this may take a while with Brute Force, we recommend that you disable Brute Force");
                        builder.setPositiveButton("Carry On", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                new TravelSelectionAsyncTask().execute(new MyTaskParam(planner, TASK.BRUTE, Budget));
                                dialog.dismiss();
                            }
                        });
                        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                progressBar.setVisibility(View.INVISIBLE);
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }else{
                        new TravelSelectionAsyncTask().execute(new MyTaskParam(planner, TASK.BRUTE, Budget));
                    }

                }else{

                    new TravelSelectionAsyncTask().execute(new MyTaskParam(planner, TASK.ALGO, Budget));

                }
                travelNow.setText("Wait !");
            }


        });
    }

    static enum TASK { ALGO, BRUTE }; //an enum to represents the TASK Type

    private class MyTaskParam { //A class to store the task parameters

        ArrayList<String> planner;
        double budget;
        TASK tasktype;

        public MyTaskParam(ArrayList<String> planner, TASK tasktype, double budget) {
            this.planner = planner;
            this.budget = budget;
            this.tasktype = tasktype;
        }
    }

    private class TravelSelectionAsyncTask extends AsyncTask<MyTaskParam, Integer, ArrayList<ArrayList<String>>> {

        @Override
        protected ArrayList<ArrayList<String>> doInBackground(MyTaskParam... myTaskParams) {

            MyTaskParam taskparam = myTaskParams[0];
            TravelSelection travelSelection = new TravelSelection();
            ArrayList<ArrayList<String>> arrayResult = null;

            if ( taskparam.tasktype ==TASK.BRUTE) {
                arrayResult = travelSelection.brute(taskparam.planner,taskparam.budget);
            } else if ( taskparam.tasktype == TASK.ALGO) {
                arrayResult = travelSelection.Algo(taskparam.planner,taskparam.budget);
            }
            return arrayResult;
        }

        @Override
        protected void onPostExecute(ArrayList<ArrayList<String>> arrayLists) {
            super.onPostExecute(arrayLists);

            travelNow.setText("Travel Now");
            final ProgressBar progressBar = findViewById(R.id.progressBar);
            progressBar.setBackgroundColor(Color.WHITE);
            progressBar.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(DrawerRecycleMap.this, TravelNowPage.class);
            AppContext.getInstance().arrayResult = arrayLists; //store in the AppContext
            startActivity(intent);

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareLocationData(){
        //TODO: Implement this EXTRACT SQL DATA
        plannerDbHelper = new PlannerDbHelper(this);
        plannerDb = plannerDbHelper.getWritableDatabase();
        String SQL_QUERY_TABLE = "SELECT * FROM " + AttractionsContract.AttractionsEntry.TABLE_NAME;
        Cursor cursor = plannerDb.rawQuery(SQL_QUERY_TABLE,null);
        int indexLocation = cursor.getColumnIndex(AttractionsContract.AttractionsEntry.COL_LOCATION);
        String myLocation;
        while(cursor.moveToNext()){

            myLocation = cursor.getString(indexLocation);

            planner.add(myLocation);

        }

    }
}

package com.example.zengersoong.uptilldawn;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecyclePage extends AppCompatActivity {
    private List<Attractions> attractionsList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    AlertDialog.Builder builder;
    private PlannerDbHelper plannerDbHelper;
    private SQLiteDatabase plannerDb;
    Button btn, btnRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_page);
        plannerDbHelper = new PlannerDbHelper(this);
        plannerDb = plannerDbHelper.getWritableDatabase();
        btn = findViewById(R.id.dbBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SQL_QUERY_TABLE = "SELECT * FROM " + AttractionsContract.AttractionsEntry.TABLE_NAME;
                Cursor cursor = plannerDb.rawQuery(SQL_QUERY_TABLE,null);

                String outstring = "";

                int indexID = cursor.getColumnIndex(AttractionsContract.AttractionsEntry._ID);
                int indexLocation = cursor.getColumnIndex(AttractionsContract.AttractionsEntry.COL_LOCATION);

                String myID;
                String myLocation;

                while(cursor.moveToNext()){

                    myLocation = cursor.getString(indexLocation);
                    myID = cursor.getString(indexID);

                    //format the output string and add it to outstring
                    outstring = outstring + myLocation + "\n";

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(RecyclePage.this);
                builder.setTitle("Where you plan to go!");
                builder.setMessage(outstring);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        btnRoute = findViewById(R.id.routeBtn);
        btnRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclePage.this, DrawerRecycleMap.class);
                startActivity(intent);
            }
        });

        mRecyclerView = findViewById(R.id.my_recycler_view);



        mAdapter = new MyAdapter(attractionsList);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Toast.makeText(RecyclePage.this, "on Move", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                final int position = viewHolder.getAdapterPosition();
                String myAttraction = attractionsList.get(position).getName();
                final String attractionName = myAttraction;
                if (swipeDir == ItemTouchHelper.LEFT){
                    String SQL_DELETE_ENTRY = "DELETE FROM " + AttractionsContract.AttractionsEntry.TABLE_NAME + " WHERE " + AttractionsContract.AttractionsEntry.COL_LOCATION + "= '" + attractionName + "'";
                    plannerDb.execSQL(SQL_DELETE_ENTRY);
                    Toast.makeText(RecyclePage.this, "Deleted "+ attractionName + " from Planner", Toast.LENGTH_SHORT).show();
                }else if (swipeDir == ItemTouchHelper.RIGHT){
                    String query = "SELECT * FROM " + AttractionsContract.AttractionsEntry.TABLE_NAME + " WHERE " + AttractionsContract.AttractionsEntry.COL_LOCATION + "= '" + attractionName + "'";
                    Cursor c = plannerDb.rawQuery(query, null);
                    if (c.getCount() <=0 && ! attractionName.equals("Marina Bay Sands")) { //Marina Bay Sands is the starting point
                        ContentValues cv = new ContentValues();
                        cv.put(AttractionsContract.AttractionsEntry.COL_LOCATION, attractionName.trim());
                        plannerDb.insert(AttractionsContract.AttractionsEntry.TABLE_NAME, null, cv);
                        Toast.makeText(RecyclePage.this, "Added " + attractionName + " to Planner", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RecyclePage.this, attractionName + " already exist", Toast.LENGTH_SHORT).show();
                    }
                    c.close();
                }

                mAdapter.notifyItemRemoved(position);
                mAdapter.notifyItemInserted(position);

            }
            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                Paint p = new Paint();
                Bitmap icon;
                if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){

                    View itemView = viewHolder.itemView;
                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
                    float width = height / 3;

                    if(dX > 0){
                        p.setColor(Color.parseColor("#388E3C"));
                        RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX,(float) itemView.getBottom());
                        c.drawRect(background,p);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_edit_white);
                        RectF icon_dest = new RectF((float) itemView.getLeft() + width ,(float) itemView.getTop() + width,(float) itemView.getLeft()+ 2*width,(float)itemView.getBottom() - width);
                        c.drawBitmap(icon,null,icon_dest,p);
                    } else {
                        p.setColor(Color.parseColor("#D32F2F"));
                        RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(),(float) itemView.getRight(), (float) itemView.getBottom());
                        c.drawRect(background,p);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_delete_white);
                        RectF icon_dest = new RectF((float) itemView.getRight() - 2*width ,(float) itemView.getTop() + width,(float) itemView.getRight() - width,(float)itemView.getBottom() - width);
                        c.drawBitmap(icon,null,icon_dest,p);
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);


        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);


        prepareAttractionData();
        mRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(), mRecyclerView, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                String myLocation = attractionsList.get(position).getLocation();

                Uri.Builder builder = new Uri.Builder();
                builder.scheme("geo").opaquePart("0,0").appendQueryParameter("q",myLocation);

                Uri geoLocation = builder.build();

                Intent mapIntent = new Intent(Intent.ACTION_VIEW,geoLocation);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }

            @Override
            public void onLongClick(View view, int position) {
                String myAttraction = attractionsList.get(position).getName();
                final String attractionName = myAttraction;
                myAttraction = myAttraction.toLowerCase();
                myAttraction = myAttraction.replaceAll(" ", "-");
                String file = myAttraction + ".jpg";

                AssetManager am = getAssets();
                InputStream is = null;
                try{
                    is = am.open(file);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

                Bitmap bitmap = BitmapFactory.decodeStream(is);
                View dView = getLayoutInflater().inflate(R.layout.dialog_custom, null);
                ImageView dImage = dView.findViewById(R.id.imageHolder);
                dImage.setImageBitmap(bitmap);

                builder = new AlertDialog.Builder(RecyclePage.this);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                Dialog d = builder.setView(dView).create();


                d.show();





            }
        }));
    }


    private void prepareAttractionData(){
        Attractions attractions = new Attractions("Marina Bay Sands", "10 Bayfront Avenue, Singapore", "The opulent Marina Bay Sands resort complex includes a hotel, high-end luxury brands, a mall with a canal running through it, the ArtScience Museum, and the Marina Bay Sands Skypark - a vantage point for taking in the entire city. ");
        attractionsList.add(attractions);

        attractions = new Attractions("Singapore Flyer", "30 Raffles Ave, Singapore", "If the observation deck at the Marina Bay Sands doesn't quite do it for you, try taking in high tea while looking out over the city from the Singapore Flyer, the world's largest giant observation wheel.");
        attractionsList.add(attractions);

        attractions = new Attractions("Gardens by the Bay", "18 Marina Gardens Drive, Singapore", "Once you've glimpsed this beautifully designed green space (from the top of the Marina Bay Sands, perhaps) you won't be able to stay away. ");
        attractionsList.add(attractions);

        attractions = new Attractions("Singapore Zoo", "80 Mandai Lake Rd, Singapore", "The facility is clean and inviting, and the animals appear well treated with plenty of lush vegetation and habitat space.");
        attractionsList.add(attractions);

        attractions = new Attractions("Resorts World Sentosa", "Sentosa Gateway, Singapore", "Singapore isn't exactly known as a beach destination, but if you're really craving some fun in the sun, Sentosa Island is the place to find it. ");
        attractionsList.add(attractions);

        attractions = new Attractions("Orchard Road", "Orchard Road, Singapore", "The Orchard Road area is a great place to start a shopping spree, as there are high-end stores at every turn.");
        attractionsList.add(attractions);

        attractions = new Attractions("Buddha Tooth Relic Temple and Museum", "288 South Bridge Road, Singapore", "The Temple is dedicated to the Maitreya Buddha, which means 'The Compassionate One', and also called 'The Future Buddha'");
        attractionsList.add(attractions);

        attractions = new Attractions("VivoCity", "1 Harbourfront Walk, Singapore", "Largest Shopping Mall in Singapore located in Harbourfront precinct of Bukit Merah, designed by Japanese architect Toyo Ito");
        attractionsList.add(attractions);
    }



}


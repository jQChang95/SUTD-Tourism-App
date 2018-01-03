package com.example.zengersoong.uptilldawn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;


public class TravelNowPage extends AppCompatActivity {


    private TextView totalCost;
    private TextView totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_now_page);
        //----------------------------grabbing the intent from previous activity---------------------------//
//        Bundle bundle = getIntent().getExtras();
//        ArrayList<String[]> resultArray = (ArrayList<String[]>) getIntent().getSerializableExtra("arrayResult");
//        if (bundle == null) {
//            Toast.makeText(getApplicationContext(),"result array failed",Toast.LENGTH_SHORT).show();
//        }

        ArrayList<ArrayList<String>> resultArray = AppContext.getInstance().arrayResult;
        //----------------------------grabbing the intent from previous activity---------------------------//
        ArrayList<String> resultLocations = resultArray.get(0);
        ArrayList<String> resultTransport = resultArray.get(1);
        ArrayList<String> resultTimeAndMoney = resultArray.get(2);

               //---------------------------Convert the stringResult to something useful--------------------//
        ArrayList<LocationTrans> resultLocationList  = new ArrayList<>();

        // TODO: break the string up and add the strings into a new string array and call it "resultList"
        // A class LocationTrans stores the result
        for ( int n = 0; n < resultLocations.size(); n++) {
            resultLocationList.add(new LocationTrans(resultLocations.get(n), resultTransport.get(n)));
        }

        //---------------------------Convert the stringResult to something useful--------------------//


//--------------------------------------recycle view input --------------------------------------------//
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.resultsRoute);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerResultAdapter adapter = new RecyclerResultAdapter(resultLocationList);

        adapter.setClickListener();
        recyclerView.setAdapter(adapter);

        totalCost = (TextView) findViewById(R.id.result_totalcost);
        totalTime = (TextView) findViewById(R.id.result_totaltime);

        double totalcost = Double.parseDouble(resultTimeAndMoney.get(1));
        double totaltime = Double.parseDouble(resultTimeAndMoney.get(0));
        totalCost.setText(String.format("Total Cost: %.2f", totalcost));
        totalTime.setText(String.format("Total Time: %.2f", totaltime));
    }

}

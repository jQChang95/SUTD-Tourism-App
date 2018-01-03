package com.example.zengersoong.uptilldawn;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zenger Soong on 23/11/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Attractions> attractionsList;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }
    private boolean isPositionHeader(int position) {
        return position == 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, location, description;
        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            location = v.findViewById(R.id.location);
            description = v.findViewById(R.id.description);
        }
    }

    public MyAdapter(List<Attractions> myDataset) {
        this.attractionsList = myDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v;

        v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.attractions_list, parent, false);
        return new MyAdapter.ViewHolder(v);



    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Attractions attractions = attractionsList.get(position);
        holder.name.setText(attractions.getName());
        holder.location.setText(attractions.getLocation());
        holder.description.setText(attractions.getDescription());


    }

    @Override
    public int getItemCount() {
        return attractionsList.size();
    }



}
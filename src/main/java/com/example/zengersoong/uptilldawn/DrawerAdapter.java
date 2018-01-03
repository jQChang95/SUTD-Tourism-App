package com.example.zengersoong.uptilldawn;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jun Qing on 11/28/2017.
 */

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder>{
    List<String> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView location;
        public ViewHolder(View v) {
            super(v);
            location = v.findViewById(R.id.drawer_location);
        }
    }
    public DrawerAdapter(List<String> data){
        this.dataSet = data;
    }

    @Override
    public DrawerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v;

        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.planner_list, parent, false);
        return new DrawerAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(DrawerAdapter.ViewHolder holder, int position) {

        holder.location.setText(dataSet.get(position));

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}

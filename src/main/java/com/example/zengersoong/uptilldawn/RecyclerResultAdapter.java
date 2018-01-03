package com.example.zengersoong.uptilldawn;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zenger Soong on 29/11/2017.
 */


public class RecyclerResultAdapter extends RecyclerView.Adapter<RecyclerResultAdapter.ViewHolder> {

    private List<LocationTrans> mData;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public RecyclerResultAdapter(List<LocationTrans> data) {
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlocationresult_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    // binds the data to the textview in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LocationTrans result = mData.get(position);
        TextView locView = (TextView) holder.itemView.findViewById(R.id.result_location);
        TextView tansView = (TextView) holder.itemView.findViewById(R.id.result_trans_text);
        ImageView img = (ImageView) holder.itemView.findViewById(R.id.result_trans_img);
        CardView cardView = (CardView) holder.itemView.findViewById(R.id.mycard);

        locView.setText(result.getLocation());
        tansView.setText(result.getTransport());
        cardView.setElevation(50);
        cardView.setRadius(30);

        String transport = result.getTransport();
        switch (transport) {
            case "Starting":
                img.setImageResource(R.mipmap.ic_my_location_black_24dp);
                break;

            case "taxi":
                img.setImageResource(R.mipmap.ic_local_taxi_black_24dp);
                break;

            case "public_transport":
                img.setImageResource(R.mipmap.ic_train_black_24dp);
                break;

            case "foot":
                img.setImageResource(R.mipmap.ic_directions_walk_black_24dp);
                break;
        }
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setClickListener() {
    }

    // convenience method for getting data at click position
    public LocationTrans getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout myView;

        public ViewHolder(View itemView) {
            super(itemView);
            myView = (LinearLayout) itemView.findViewById(R.id.eachNode);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
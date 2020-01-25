package com.example.ufthack;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VapeEventRecyclerViewAdapter extends RecyclerView.Adapter<VapeEventRecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<VapeTime> mData;
    Dialog myDialog;

    public VapeEventRecyclerViewAdapter(Context mContext,List<VapeTime> mData){
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public VapeEventRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_vape_event,parent,false);
        final VapeEventRecyclerViewAdapter.MyViewHolder vHolder = new VapeEventRecyclerViewAdapter.MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VapeEventRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.time.setText("13:05");
        holder.amount.setText("0.05g");

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_VapeTime;
        private TextView time;
        private TextView amount;


        public MyViewHolder(View itemView){
            super(itemView);
            item_VapeTime = (LinearLayout) itemView.findViewById(R.id.vape_event_item);
            time = (TextView) itemView.findViewById(R.id.time_of_vape);
            amount = (TextView) itemView.findViewById(R.id.vape_nick);
        }
    }
}

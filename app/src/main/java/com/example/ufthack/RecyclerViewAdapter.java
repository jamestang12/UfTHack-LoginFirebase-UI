package com.example.ufthack;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    Context mContext;
    List<Contact> mData;
    Dialog myDialog;

    public RecyclerViewAdapter(Context mContext,List<Contact> mData){
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_contact,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_contact);



        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_name_tv = (TextView)myDialog.findViewById(R.id.dialog_name_id);
                TextView dialog_phone_tv = (TextView)myDialog.findViewById(R.id.dialog_phone_id);
                TextView dialog_call_tv = (TextView)myDialog.findViewById(R.id.dialog_btn_call);
                ImageView dialog_contact_img = (ImageView)myDialog.findViewById(R.id.dialog_img);
                dialog_name_tv.setText(mData.get(vHolder.getAdapterPosition()).getName());
                String xp = mData.get(vHolder.getAdapterPosition()).getXp();
                dialog_phone_tv.setText("User XP: " + xp);
                String days = mData.get(vHolder.getAdapterPosition()).getDays();
                dialog_call_tv.setText("SMOKE FREE " + days + " DAYS");
                dialog_contact_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());
                myDialog.show();

            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_xp.setText(mData.get(position).getXp());
        holder.img.setImageResource(mData.get(position).getPhoto());
        holder.rank.setText(mData.get(position).getRank());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_contact;
        private TextView tv_name;
        private TextView tv_xp;
        private ImageView img;
        private TextView rank;


        public MyViewHolder(View itemView){
            super(itemView);
            item_contact = (LinearLayout) itemView.findViewById(R.id.contact_item);
            tv_name = (TextView) itemView.findViewById(R.id.name_contact);
            tv_xp = (TextView) itemView.findViewById(R.id.xp);
            img = (ImageView)itemView.findViewById(R.id.img_contact);
            rank = (TextView) itemView.findViewById(R.id.rank);
        }
    }
}

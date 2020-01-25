package com.example.ufthack;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class VapeViewActivity extends AppCompatActivity {
    private RecyclerView myrecyclerview;
    private List<VapeTime> vapeTimeList;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vape_view);

        vapeTimeList = new ArrayList<>();
        vapeTimeList.add(new VapeTime("0.05", "15", "35"));
        vapeTimeList.add(new VapeTime("0.05", "16", "25"));
        vapeTimeList.add(new VapeTime("0.02", "17", "25"));

        Intent intent = getIntent();
        String message = intent.getStringExtra("date");
        String[] data = message.split("-");
        int day = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int year = Integer.parseInt(data[2]);
    }

    public VapeViewActivity(){

    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_notifications,container,false);
        myrecyclerview = (RecyclerView)v.findViewById(R.id.contact_recyclerview);
        VapeEventRecyclerViewAdapter recyclerViewAdapter2 = new VapeEventRecyclerViewAdapter(this.getApplicationContext(), vapeTimeList);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        myrecyclerview.setAdapter(recyclerViewAdapter2);
        return v;

    }
}

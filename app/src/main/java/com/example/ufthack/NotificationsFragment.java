package com.example.ufthack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Contact> lstContact;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstContact = new ArrayList<>();
        lstContact.add(new Contact("Person 1","222 XP",R.drawable.face,"1","2"));
        lstContact.add(new Contact("Person 2","222 XP",R.drawable.face,"2","12"));
        lstContact.add(new Contact("Person 3","222 XP",R.drawable.face,"3","4"));
        lstContact.add(new Contact("Person 4","222 XP",R.drawable.face,"4","3"));
        lstContact.add(new Contact("Person 5","222 XP",R.drawable.face,"5","5"));

    }

    public NotificationsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_notifications,container,false);
        myrecyclerview = (RecyclerView)v.findViewById(R.id.contact_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstContact);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;

    }
}

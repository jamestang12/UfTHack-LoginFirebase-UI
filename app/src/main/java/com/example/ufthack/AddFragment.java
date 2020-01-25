package com.example.ufthack;

// import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.sql.Time;
import java.util.ArrayList;

public class AddFragment extends Fragment implements TimePickerFragment.TimePickerLister {

    public static ArrayList<VapeTime> VAPE_TIMES;

    static {
        VAPE_TIMES = new ArrayList<>();
    }

    Button time,enter;
    View view;
    Context context;
    EditText text;
    String amount, Hour, Minutes;
    private FragmentActivity myContext;

    @Nullable

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add,container,false);
        time = view.findViewById(R.id.timebottom);
        text = view.findViewById(R.id.amount);
        enter = view.findViewById(R.id.enter);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePickerFragment = new TimePickerFragment();
                timePickerFragment.setCancelable(false);
                timePickerFragment.show(getFragmentManager(),"TimePicker");
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount = text.getText().toString();
                VapeTime vapeTime = new VapeTime(amount,Hour,Minutes);
                VAPE_TIMES.add(vapeTime);
            }
        });


        return view;



    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        time.setText("Hour = " + hour +" Minute = "+minute);
        Hour = String.valueOf(hour);
        Minutes = String.valueOf(minute);
    }
}

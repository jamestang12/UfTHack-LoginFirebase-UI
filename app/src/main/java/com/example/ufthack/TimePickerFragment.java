package com.example.ufthack;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


import java.util.Calendar;
import java.util.zip.DataFormatException;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    public interface TimePickerLister{
        void onTimeSet(TimePicker timePicker, int hour , int minute);
    }

    TimePickerLister mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // mListener = (TimePickerLister)context;
        try {
            mListener = (TimePickerLister)context;

        } catch (Exception e){
            throw new ClassCastException(getActivity().toString()+" must implements TimePicker");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this,hour,minute, DateFormat.is24HourFormat(getContext()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        mListener.onTimeSet(timePicker,i , i1);
    }
}

package com.example.ufthack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TimePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main2Activity extends AppCompatActivity implements TimePickerFragment.TimePickerLister {
    static AppCompatActivity ACTIVITY_HANDLE;
    private AddFragment add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        ACTIVITY_HANDLE = this;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment slectedFragment = null;
            switch (menuItem.getItemId()){
                case  R.id.navigation_add:
                    AddFragment f = new AddFragment();
                    add = f;
                    slectedFragment = f;
                    break;
                case R.id.navigation_home:
                    slectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_cal:
                    slectedFragment = new CalendarFragment();
                    break;
                case R.id.navigation_dashboard:
                    slectedFragment = new DashbordFragment();
                    break;
                case R.id.navigation_notifications:
                    slectedFragment = new NotificationsFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,slectedFragment).commit();

            return true;
        }
    };

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        add.onTimeSet(timePicker, hour, minute);
    }
}

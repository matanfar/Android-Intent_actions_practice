package com.example.hit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.view.View;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
    }

    public void onSetAlarm(View view){
        Intent intent = new Intent(this, AlarmActivity.class);
        startActivity(intent);
    }

    public void onSetTimer(View view){
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }
}
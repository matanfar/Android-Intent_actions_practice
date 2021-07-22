package com.example.hit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;

public class AlarmActivity extends AppCompatActivity {
private EditText hour;
private EditText minutes;
private EditText subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        subject = findViewById(R.id.alarm_title_text);
        hour = findViewById(R.id.alarm_hout_text);
        minutes = findViewById(R.id.alarm_min_text);

    }

    public void setAlarm(View view){
        String alarmTitle = subject.getText().toString();
        String alarmHour = hour.getText().toString();
        String alarmMin = minutes.getText().toString();
        int alarm_hour = Integer.parseInt(alarmHour);
        int alarm_min = Integer.parseInt(alarmMin);
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, alarmTitle)
                .putExtra(AlarmClock.EXTRA_HOUR, alarm_hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, alarm_min);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
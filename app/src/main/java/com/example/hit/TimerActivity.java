package com.example.hit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TimerActivity extends AppCompatActivity {
    private EditText secondes;
    private EditText subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        subject = findViewById(R.id.timer_title_text);
        secondes = findViewById(R.id.timer_sec_text);
    }


    public void setTimer(View view){
        String timerSubject = subject.getText().toString();
        String timerSeconds = secondes.getText().toString();
        int timer_seconds = Integer.parseInt(timerSeconds);
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, timerSubject)
                .putExtra(AlarmClock.EXTRA_LENGTH, timer_seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
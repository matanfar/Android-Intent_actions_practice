package com.example.hit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {
    private EditText title;
    private EditText msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        title = findViewById(R.id.text_title);
        msg = findViewById(R.id.text_msg);
    }


    public void SendMail(View view){

        String mailTitle = title.getText().toString();
        String mailMsg = msg.getText().toString();

        String[] TO = {"yulia_e@hit.ac.il"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, mailTitle);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mailMsg);
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MessageActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }
}


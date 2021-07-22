package com.example.hit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void showMap(View view) {
        Uri geoLocation = Uri.parse("geo:32.016802661033886, 34.77279880795125");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }

    public void callNumber(View view){
        String number = "*6404";
        Intent dialIntent = new Intent();
        dialIntent.setAction(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:"+number));
        startActivity(dialIntent);
    }

    public void showWebsite(View view){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.hit.ac.il"));
        startActivity(intent);
    }

    public void onSendMail(View view){
        Intent intent = new Intent(this, MessageActivity.class);
        startActivity(intent);
    }

    public void onSetEvent(View view){
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }

}
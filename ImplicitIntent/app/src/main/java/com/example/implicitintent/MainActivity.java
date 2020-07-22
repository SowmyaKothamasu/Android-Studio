package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view) {
        Uri u=Uri.parse("https//www.google.com");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void call(View view) {
        Uri uri=Uri.parse("tel:8184838222");
        Intent i=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);
    }

    public void location(View view) {
        Uri mapsuri=Uri.parse("geo:16.463054,80.506849");
        Intent m=new Intent(Intent.ACTION_VIEW,mapsuri);
        startActivity(m);
    }
}
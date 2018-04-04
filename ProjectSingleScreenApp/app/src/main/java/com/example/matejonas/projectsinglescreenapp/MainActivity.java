package com.example.matejonas.projectsinglescreenapp;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openWebsite(View view) {
        TextView textView = findViewById(view.getId());
        String link = textView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }

    public void sendEmail(View view) {
        TextView textView = findViewById(view.getId());
        String link = textView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + link));
        startActivity(intent);
    }

    public void callPhone(View view) {
        TextView textView = findViewById(view.getId());
        String link = textView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + link));
        startActivity(intent);
    }

    public void searchAddress(View view) {
        TextView textView = findViewById(view.getId());
        String link = textView.getText().toString();
        int cutFrom = link.indexOf("-") + 1;
        link = link.substring(cutFrom).trim();
        String maps = "https://maps.google.com/maps?daddr=";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(maps + Uri.encode(link)));
        startActivity(intent);
    }
}

package com.example.matejonas.userprofile;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nameView = findViewById(R.id.name);
        nameView.setText("Máté Jónás");
        nameView.setTextSize(34);
        nameView.setTypeface(null, Typeface.BOLD);

        TextView birthdayView = findViewById(R.id.birthday);
        birthdayView.setText("August 21, 1987");
        birthdayView.setTextSize(24);
        birthdayView.setTextColor(Color.RED);

        TextView countryView = findViewById(R.id.country);
        countryView.setText("Hungary");
        countryView.setTextSize(24);

        ImageView profileImageView = findViewById(R.id.profile_picture);
        profileImageView.setImageResource(R.drawable.profile_picture);
    }
}

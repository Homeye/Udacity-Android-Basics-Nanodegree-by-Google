package com.example.matejonas.projectmusicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("Metallica", "Ride the Lightning", "Fade to Black"));
        songs.add(new Song("KoRn", "KoRn", "Blind"));
        songs.add(new Song("Animals As Leaders", "The Madness Of Many", "Highway Tune"));
        songs.add(new Song("Greta Van Fleet", "From The Fires", "Fade to Black"));
        songs.add(new Song("Monster Truck", "Furiosity", "Sweet Mountain River"));
        songs.add(new Song("Otep", "The Ascension", "Confrontation"));
        songs.add(new Song("Hundred Suns", "Fractional", "Fractional"));

        SongAdapter songAdapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(songAdapter);
    }
}

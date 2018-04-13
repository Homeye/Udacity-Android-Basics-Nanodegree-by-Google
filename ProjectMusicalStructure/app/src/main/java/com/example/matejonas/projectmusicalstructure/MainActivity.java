package com.example.matejonas.projectmusicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SongAdapter songAdapter = new SongAdapter(this, getPlaylist());

        ListView listView = findViewById(R.id.playlist);

        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent = new Intent(MainActivity.this, PlayingActivity.class);
                playerIntent.putExtra("playlist", getPlaylist());
                playerIntent.putExtra("indexOfSong", position);
                startActivity(playerIntent);
            }
        });
    }

    private ArrayList<Song> getPlaylist() {
        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("Metallica", "Ride the Lightning", "Fade to Black"));
        songs.add(new Song("KoRn", "KoRn", "Blind"));
        songs.add(new Song("Animals As Leaders", "The Madness Of Many", "Highway Tune"));
        songs.add(new Song("Greta Van Fleet", "From The Fires", "Fade to Black"));
        songs.add(new Song("Monster Truck", "Furiosity", "Sweet Mountain River"));
        songs.add(new Song("Otep", "The Ascension", "Confrontation"));
        songs.add(new Song("Hundred Suns", "Fractional", "Fractional"));

        return songs;
    }
}

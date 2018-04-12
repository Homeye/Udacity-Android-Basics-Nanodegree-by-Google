package com.example.matejonas.projectmusicalstructure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(@NonNull Context context, @NonNull List<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View songView = convertView;
        if (songView == null) {
            songView = LayoutInflater.from(getContext()).inflate(R.layout.song, parent, false);
        }

        Song currentSong = getItem(position);

        TextView artist = songView.findViewById(R.id.artist);
        artist.setText(currentSong.getArtist());

        TextView album = songView.findViewById(R.id.album);
        album.setText(currentSong.getAlbum());

        TextView song = songView.findViewById(R.id.song);
        song.setText(currentSong.getSong());

        return songView;
    }
}

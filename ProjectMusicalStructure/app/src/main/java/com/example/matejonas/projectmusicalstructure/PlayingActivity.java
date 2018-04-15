package com.example.matejonas.projectmusicalstructure;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayingActivity extends AppCompatActivity {

    private ArrayList<Song> mPlaylist;

    private Song mCurrentSong;

    private TextView mArtist;

    private TextView mAlbum;

    private TextView mSong;

    private ImageView mPlayPauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        Intent intent = getIntent();

        mPlaylist = (ArrayList<Song>) intent.getSerializableExtra("playlist");

        mCurrentSong = mPlaylist.get(intent.getIntExtra("indexOfSong", 0));

        mArtist = findViewById(R.id.player_artist);
        mArtist.setText(mCurrentSong.getArtist());

        mAlbum = findViewById(R.id.player_album);
        mAlbum.setText(mCurrentSong.getAlbum());

        mSong = findViewById(R.id.player_song);
        mSong.setText(mCurrentSong.getSong());

        mPlayPauseButton = findViewById(R.id.play_pause_button);
        mPlayPauseButton.setOnClickListener(getPlayPauseButtonListener());

        ImageView previousButton = findViewById(R.id.previous_button);
        previousButton.setOnClickListener(getPreviousButtonListener());

        ImageView nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(getNextButtonListener());

        ImageView backButton = findViewById(R.id.back_to_playlist);
        backButton.setOnClickListener(getBackButtonListener());
    }

    @NonNull
    private View.OnClickListener getPlayPauseButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayPauseButton.getDrawable().getConstantState().equals(getDrawable(android.R.drawable.ic_media_play).getConstantState())) {
                    mPlayPauseButton.setImageResource(android.R.drawable.ic_media_pause);
                } else {
                    mPlayPauseButton.setImageResource(android.R.drawable.ic_media_play);
                }
            }
        };
    }

    @NonNull
    private View.OnClickListener getPreviousButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int indexOfSong = mPlaylist.indexOf(mCurrentSong);
                if (indexOfSong == 0) {
                    mCurrentSong = mPlaylist.get(mPlaylist.size() - 1);
                    mArtist.setText(mCurrentSong.getArtist());
                    mAlbum.setText(mCurrentSong.getAlbum());
                    mSong.setText(mCurrentSong.getSong());
                } else {
                    mCurrentSong = mPlaylist.get(indexOfSong - 1);
                    mArtist.setText(mCurrentSong.getArtist());
                    mAlbum.setText(mCurrentSong.getAlbum());
                    mSong.setText(mCurrentSong.getSong());
                }
            }
        };
    }

    @NonNull
    private View.OnClickListener getNextButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int indexOfSong = mPlaylist.indexOf(mCurrentSong);
                if (indexOfSong == mPlaylist.size() - 1) {
                    mCurrentSong = mPlaylist.get(0);
                    mArtist.setText(mCurrentSong.getArtist());
                    mAlbum.setText(mCurrentSong.getAlbum());
                    mSong.setText(mCurrentSong.getSong());
                } else {
                    mCurrentSong = mPlaylist.get(indexOfSong + 1);
                    mArtist.setText(mCurrentSong.getArtist());
                    mAlbum.setText(mCurrentSong.getAlbum());
                    mSong.setText(mCurrentSong.getSong());
                }
            }
        };
    }

    @NonNull
    private View.OnClickListener getBackButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(PlayingActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);
            }
        };
    }
}

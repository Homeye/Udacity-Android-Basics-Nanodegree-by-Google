package com.example.matejonas.projectmusicalstructure;

public class Song {

    private String mArtist;

    private String mAlbum;

    private String mSong;

    public Song(String artist, String album, String song) {
        mArtist = artist;
        mAlbum = album;
        mSong = song;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public String getSong() {
        return mSong;
    }
}

package com.example.compaq.feelmusic;

/**
 * Created by compaq on 25-02-2016.
 */
public class musicsong {
    private String songTitle;
    private String songPath;

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public String getSongPath() {

        return songPath;
    }

    public void setSongTitle(String songTitle) {

        this.songTitle = songTitle;
    }

    public String getSongTitle() {

        return songTitle;
    }
}

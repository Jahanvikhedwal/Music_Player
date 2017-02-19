package com.example.compaq.feelmusic;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by compaq on 25-02-2016.
 */
public class LawlControls {

    Random r1 = new Random();
   public int getRandom(){
        int rs = r1.nextInt(songsList.size());
        return rs;
    }
    private HashMap<String, musicsong> songsMap = new HashMap<>();
    private String curTitle=null;
    public ArrayList<String> recentsongsList=new ArrayList<>();
    public ArrayList<String> songsList = new ArrayList<>();
    public ArrayList<String> allSongsList = new ArrayList<>();public MediaPlayer mp;
private boolean random=false;
    public HashMap<String, musicsong> getSongsMap() {
        return songsMap;
    }

    public int cs = 0;

    public void setSongsMap(HashMap<String, musicsong> songsMap) {
        this.songsMap = songsMap;
    }

    public void setCs(int cs) {
        this.cs = cs;
    }

    public void playNext(Context ctx) {
        if (isRandom()) {
            cs = getRandom();
        } else {
            if (songsList.size() != cs + 1) {
                cs = cs + 1;
            } else {
                cs = 0;
            }
        }
        startSong(ctx, songsList.get(cs));
        mudicPlay.tvv.setText(" "+songsList.get(cs)+"!!!");
    }public void stopSong(){
        if(mp!=null){
            try {
                mp.stop();
                mp.release();
                mp=null;
            }
            catch (Exception e){
            }
        }
    }

    public   void startSong(final Context ctx, String title){
        stopSong();
        musicsong s1 = songsMap.get(title);
        Uri u1 = Uri.parse(s1.getSongPath());
        mp = MediaPlayer.create(ctx, u1);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                playNext(ctx);
            }
        });recentsongsList.add(s1.getSongTitle());

    }
    public void playPause(Context ctx){
        if(mp!=null){
            if(mp.isPlaying()){
                mp.pause();
            }
            else {
                mp.start();
            }
        }
        else {
            musicsong s1;
            if(curTitle!=null && !curTitle.equals("")){
                s1 = songsMap.get(curTitle);
            }
            else {
                s1 = songsMap.get(getRandom());
            }
            if(s1!=null){
                startSong(ctx, s1.getSongTitle());
            }
        }}
    public void playPre(Context ctx){
        if(isRandom()){
            cs = getRandom();
        }
        else {
            if (cs != 0) {
                cs = cs - 1;
            } else {
                cs = songsList.size() - 1;
            }
        }
        startSong(ctx, songsList.get(cs));
    }






    public MediaPlayer getMp() {
        return mp;
    }

    public void setMp(MediaPlayer mp) {
        this.mp = mp;
    }  public String getCurTitle() {
        return curTitle;
    }

    public void setCurTitle(String curTitle) {
        this.curTitle = curTitle;
    }

    public boolean isRandom() {
        return random;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }


}

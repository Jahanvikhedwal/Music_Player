package com.example.compaq.feelmusic;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by compaq on 25-02-2016.
 */
public class musicscan {

 private  static  LinkedList<String> exts=new LinkedList<String >();
    static {
        exts.add(".mp3");

    }
public  static ArrayList<musicsong> scanAllSongs(){
ArrayList<musicsong> songsList=new ArrayList<musicsong>();
    songsList.addAll(scanSongs("/storage"));

    return songsList;
}

    private static ArrayList<musicsong> scanSongs(String path) {

        ArrayList<musicsong> songsList = new ArrayList<musicsong>();
        if (path != null) {
            File home = new File(path);
            File[] listFiles = home.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    System.out.println(file.getAbsolutePath());
                    if (file.isDirectory()) {
                        scanDirectory(file, songsList);
                    } else {
                        addSongToList(file, songsList);
                    }
                }
            }
        }
        // return songs list array
        return songsList;
    }

    private static void scanDirectory(File directory, ArrayList<musicsong> songsList) {
        if (directory != null) {
            File[] listFiles = directory.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        scanDirectory(file, songsList);
                    } else {
                        addSongToList(file, songsList);
                    }

                }
            }
        }
    }

    private static void addSongToList(File song, ArrayList<musicsong> songsList) {
        if(song.getName()!=null && song.getName().length()>4) {
            String ext = song.getName().substring((song.getName().length() - 4));
            if (exts.contains(ext)) {
               musicsong s1 = new musicsong();
                s1.setSongTitle(song.getName().substring(0, (song.getName().length() - 4)));
                s1.setSongPath(song.getPath());
                songsList.add(s1);

        }
    }
}





    }
package com.example.compaq.feelmusic;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimerTask tt=new TimerTask() {
            @Override
            public void run() {
                Intent i1=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i1);
                 MainActivity.this.finish();
            }
        };
        Timer t1=new Timer();
        t1.schedule(tt, 1000);
        SQLiteDatabase db = openOrCreateDatabase("mydb", MODE_PRIVATE, null);
        String sql = " create table if not exists play_list(" +
                " id  INTEGER PRIMARY KEY," +
                " sname varchar(100)," +
                " spath varchar(400)," +
                " pname varchar(100)" +
                " )";
        db.execSQL(sql);
        db.close();
    }
}

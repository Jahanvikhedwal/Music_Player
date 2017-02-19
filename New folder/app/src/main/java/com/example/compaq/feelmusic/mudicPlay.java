package com.example.compaq.feelmusic;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class mudicPlay extends AppCompatActivity {
    public static TextView txtCur, txtDur;
    public static TextView tvv = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mudic_play);
        Intent i1 = getIntent();

        if (i1.hasExtra("song")) {
            tvv   = (TextView) findViewById(R.id.textView7);

            tvv  .setText(" " + i1.getStringExtra("song") + "!!!");
        }
        final NotificationManager nm = (NotificationManager) getSystemService (NOTIFICATION_SERVICE);
        nm.cancel(0);
        ImageButton btnNext = (ImageButton) findViewById(R.id.btnNext);
        ImageButton btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        ImageButton btnPre = (ImageButton) findViewById(R.id.btnPre);
        ImageButton b=(ImageButton)findViewById(R.id.imageButton2);
        txtCur= (TextView) findViewById(R.id.txtCur);
        txtDur= (TextView) findViewById(R.id.txtDur);
        final SeekBar sb1= (SeekBar) findViewById(R.id.seekBar);
        updateSeekBar(sb1);
        sb1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                Main2Activity.ctrls.getMp().seekTo(sb1.getProgress());
                return false;
            }
        });
        final ImageView ivShfl = (ImageView) findViewById(R.id.btnShfl);
        if(Main2Activity.ctrls.isRandom()){
            ivShfl.setImageResource(R.drawable.on);
        }
        else {
            ivShfl.setImageResource(R.drawable.off);
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main2Activity.ctrls.playNext(mudicPlay.this);
            }
        });
        btnPre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main2Activity.ctrls.playPre(mudicPlay.this);
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main2Activity.ctrls.playPause(mudicPlay.this);
            }
        });
        ivShfl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Main2Activity.ctrls.setRandom(!Main2Activity.ctrls.isRandom());
                if(Main2Activity.ctrls.isRandom()){
                    ivShfl.setImageResource(R.drawable.on);
                }
                else {
                    ivShfl.setImageResource(R.drawable.off);
                }
            }
        });
    }

    private void updateSeekBar(final SeekBar sb1) {
        Timer t1 =new Timer();
        TimerTask tt = new TimerTask() {
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        if(Main2Activity.ctrls.getMp()!=null){
                            sb1.setMax(Main2Activity.ctrls.getMp().getDuration());
                            sb1.setProgress(Main2Activity.ctrls.getMp().getCurrentPosition());
                            txtCur.setText(" "+Main2Activity.ctrls.getMp().getCurrentPosition()/1000);
                            txtDur.setText(" "+Main2Activity.ctrls.getMp().getDuration()/1000);
                        }
                    }
                });
            }
        };
        t1.scheduleAtFixedRate(tt, 0, 1000);
    }




    @Override
    public void onBackPressed() {
        final NotificationManager nm = (NotificationManager) getSystemService (NOTIFICATION_SERVICE);
        Notification.Builder nb1 = new Notification.Builder(mudicPlay.this);
        RemoteViews rv = new RemoteViews(getPackageName(), R.layout.cust1);
        nb1.setContent(rv);
        nb1.setTicker("MainActivity");
        nb1.setContentTitle("MainActivity");
        nb1.setContentText("MainActivity");nb1.setSmallIcon(R.mipmap.ic_launcher);

        Intent i1 = new Intent(mudicPlay.this, mudicPlay.class);
        PendingIntent pi =  PendingIntent.getActivity(mudicPlay.this, 0, i1, PendingIntent.FLAG_UPDATE_CURRENT);
        nb1.setContentIntent(pi);

        Intent iNxt = new Intent(mudicPlay.this, MyService.class);
        iNxt.putExtra("cmd", "nxt");
        PendingIntent piNxt =  PendingIntent.getService(mudicPlay.this , 1, iNxt, PendingIntent.FLAG_UPDATE_CURRENT);
        rv.setOnClickPendingIntent(R.id.btnNext, piNxt);

        Intent iPrv = new Intent(mudicPlay.this, MyService.class);
        iPrv.putExtra("cmd", "prv");
        PendingIntent piPrv =  PendingIntent.getService(mudicPlay.this, 2, iPrv, PendingIntent.FLAG_UPDATE_CURRENT);
        rv.setOnClickPendingIntent(R.id.btnPre, piPrv);

        Intent iPause = new Intent(mudicPlay.this, MyService.class);
        iPause.putExtra("cmd", "pause");
        PendingIntent piPause =  PendingIntent.getService(mudicPlay.this, 3, iPause, PendingIntent.FLAG_UPDATE_CURRENT);
        rv.setOnClickPendingIntent(R.id.btnPlay, piPause);


        Notification n1 = nb1.build();
        n1.flags |= Notification.FLAG_ONGOING_EVENT;
        nm.notify(0, n1);
        super.onBackPressed();
    }


}








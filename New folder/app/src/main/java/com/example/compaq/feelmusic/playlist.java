package com.example.compaq.feelmusic;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class playlist extends AppCompatActivity {
ArrayList<String> ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        TextView tv=(TextView)findViewById(R.id.textView);
        tv.setTypeface(null, Typeface.BOLD_ITALIC);
        tv.setTextColor(Color.BLACK);

ab=Myutil.getPLNames(playlist.this);
        ListView lv2=(ListView)findViewById(R.id.listView2);
      adp2 bbb=new adp2(playlist.this,R.id.textView2,ab);
        lv2.setAdapter(bbb);
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i=new Intent(playlist.this, playlistitem.class);

                startActivity(i);


            }
        });

}}

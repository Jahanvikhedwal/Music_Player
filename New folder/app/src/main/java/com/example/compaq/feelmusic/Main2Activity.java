package com.example.compaq.feelmusic;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.compaq.feelmusic.musicscan.scanAllSongs;

/**
 * Created by compaq on 20-02-2016.
 */
public class Main2Activity extends AppCompatActivity {
    ListView lv1;
    static ArrayList<musicsong> aa;
    ArrayList<String> cc = new ArrayList<String>();
    static LawlControls ctrls = new LawlControls();
    static HashMap<String, musicsong> m1 = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2activity);


        aa = scanAllSongs();
        ArrayList<String> bb = new ArrayList<String>();
        m1.clear();
        for (musicsong ce : aa) {
            bb.add(ce.getSongTitle());
            m1.put(ce.getSongTitle(), ce);
        }
        ctrls.setSongsMap(m1);
        ctrls.allSongsList = bb;
        ctrls.songsList = ctrls.allSongsList;
        lv1 = (ListView) findViewById(R.id.listView);
        adp1 bbb = new adp1(Main2Activity.this, R.id.textView2, aa);
        lv1.setAdapter(bbb);

        final Button b1 = (Button) findViewById(R.id.button);
        assert b1 != null;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lv1 = (ListView) findViewById(R.id.listView);
                adp1 bbb = new adp1(Main2Activity.this, R.id.textView2, aa);
                lv1.setAdapter(bbb);
            }
        });

        final Button b3 = (Button) findViewById(R.id.button3);
        assert b3 != null;

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv1 = (ListView) findViewById(R.id.listView);
                ctrls.songsList = ctrls.recentsongsList;
                ArrayAdapter<String> bbb = new ArrayAdapter<String>(Main2Activity.this, android.R.layout.simple_list_item_1, ctrls.songsList);
                lv1.setAdapter(bbb);
                lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView tv1 = (TextView) view;
                        tv1.setTypeface(null, Typeface.BOLD_ITALIC);
                        tv1.setTextColor(Color.BLUE);
                        ctrls.setCs(position);
                        ctrls.startSong(Main2Activity.this, tv1.getText().toString());
                        Intent i2 = new Intent(Main2Activity.this, mudicPlay.class);
                        startActivity(i2);
                    }
                });

            }
        });
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Main2Activity.this, playlist.class);
                startActivity(i2);
            }
        });}
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;


    }

}







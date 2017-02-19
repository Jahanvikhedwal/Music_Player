package com.example.compaq.feelmusic;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searcchh);
        handleIntent(getIntent());
    }
    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            tv = (TextView) findViewById(R.id.textView6);
            String query = intent.getStringExtra(SearchManager.QUERY);
            ListView lv=(ListView)findViewById(R.id.listView4);
            ArrayList<musicsong> oo = new ArrayList<musicsong>();
            oo = Main2Activity.aa;
            ArrayList<musicsong> listClone= new ArrayList<musicsong>();

            for (musicsong ok : oo) {
                if (ok.getSongTitle().toString().contains( (query))) {
                    listClone.add(ok);
                }
               }
               if(listClone.isEmpty()!=true)
               {tv.setText("Search Results..");
                   adp1 yy=new adp1(SearchResultsActivity.this,R.id.textView2,listClone);
                   lv.setAdapter(yy);}
            else{tv.setText("No result found");
               }

            }


        }}


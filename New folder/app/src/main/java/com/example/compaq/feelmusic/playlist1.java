package com.example.compaq.feelmusic;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by compaq on 20-03-2016.
 */
public class playlist1 extends AppCompatActivity {  String s =null;
    ArrayList<String> bc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist1);
        Intent ie = getIntent();

        if (ie.hasExtra("namee")){
            s  =(String)ie.getStringExtra("namee") ;
        }
        Button b=(Button)findViewById(R.id.button41);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(playlist1.this, playlistfragment1.class);
                i.putExtra("key",s);
                startActivity(i);

            }

            ;
        });
        ListView lv2=(ListView)findViewById(R.id.listView241);
        bc=Myutil.getPLNames(playlist1.this);
        ArrayAdapter<String> aaa = new ArrayAdapter<String>(playlist1.this, android.R.layout.simple_list_item_1, bc);
        lv2.setAdapter(aaa);


        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v=(TextView)view;
                v.setTypeface(null, Typeface.ITALIC);
                Toast.makeText(playlist1.this,"Song added to Playlist",Toast.LENGTH_SHORT).show();
                Myutil.insertIntoPL(playlist1.this,v.getText().toString(), s,Main2Activity.ctrls.getSongsMap().get(s).getSongPath());



            }
        });



    }


}

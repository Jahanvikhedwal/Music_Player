package com.example.compaq.feelmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class playlistitem extends AppCompatActivity {String uv=null;String u=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlistitem);
        ListView lv = (ListView) findViewById(R.id.listView3);
        TextView tvv= (TextView)findViewById(R.id.textView4);
        TextView tvvv= (TextView)findViewById(R.id.textView5);

        ArrayList<String> bb = new ArrayList<String>();
        Intent iio=getIntent();
        if (iio.hasExtra("keyy")) {
            uv = (String) iio.getStringExtra("keyy");
            tvv.setText(uv);
        }
        if(iio.hasExtra("myk")) {
            uv = (String) iio.getStringExtra("myk");
            tvv.setText(uv);

        }
        Intent i=getIntent();
        if(i.hasExtra("myk1")){
            u=(String)i.getStringExtra("myk1");
            tvvv.setText(u);
        }
        bb=Myutil.getPL(playlistitem.this,uv);
        adp3 bbb = new adp3(playlistitem.this, android.R.layout.simple_list_item_1, bb);
        lv.setAdapter(bbb);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(playlistitem.this, mudicPlay.class);
                startActivity(i);
            }
        });



            TextView tv1 = (TextView) findViewById(R.id.textView5);

       final ImageButton button = (ImageButton)  findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(playlistitem.this, button);
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu2, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().toString().equals("Edit Playlist")) {
                            Toast.makeText(playlistitem.this, "hdhjg", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(playlistitem.this, playlistfragment.class);
                            startActivity(i);
                        }
                        if (item.getTitle().toString().equals("Play next")) {
                            Toast.makeText(playlistitem.this, "hdg", Toast.LENGTH_SHORT).show();
                        }
                        if (item.getTitle().toString().equals("Share")) {
                            Toast.makeText(playlistitem.this, "hvdg", Toast.LENGTH_SHORT).show();
                        }
                        if (item.getTitle().toString().equals("Delete")) {
                            Toast.makeText(playlistitem.this, "hgdg", Toast.LENGTH_SHORT).show();
                        }
                        if (item.getTitle().toString().equals("Add songs")) {
                            Toast.makeText(playlistitem.this, "hgggdg", Toast.LENGTH_SHORT).show();
                        }

                        return true;

                    }
                });
                popup.show();
            }


        });}}

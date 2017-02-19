package com.example.compaq.feelmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by compaq on 20-03-2016.
 */
public class playlistfragment1
        extends AppCompatActivity {String u=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlistfragment1);
        final EditText et = (EditText) findViewById(R.id.editText21);

        Button button = (Button) findViewById(R.id.button7);
        Intent ii = getIntent();
        if (ii.hasExtra("key")){
            u =(String)ii.getStringExtra("key") ;
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(playlistfragment1.this, "Song added to the new Playlist!!", Toast.LENGTH_SHORT).show();
                Myutil.insertIntoPL(playlistfragment1.this, et.getText().toString(), u, Main2Activity.ctrls.getSongsMap().get(u).getSongPath());









            }
        });


    }
}

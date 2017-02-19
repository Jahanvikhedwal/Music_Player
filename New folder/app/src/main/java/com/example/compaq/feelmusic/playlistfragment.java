package com.example.compaq.feelmusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class playlistfragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlistfragment);
        final EditText et = (EditText) findViewById(R.id.editText21);
        final EditText et2 = (EditText) findViewById(R.id.editText22);
        Button button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(playlistfragment.this,"Playlist edited successfully!!!",Toast.LENGTH_SHORT).show();
            }
        });}
      public void onBackPressed(){

    }

}

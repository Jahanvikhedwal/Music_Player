package com.example.compaq.feelmusic;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by compaq on 22-03-2016.
 */
public class adp3 extends ArrayAdapter<String> {Context ctxx;

    public adp3(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        ctxx=context;}
    public View getView(final int position,View convertView, ViewGroup parent){
        LayoutInflater lo= (LayoutInflater) getContext().getSystemService(ctxx.LAYOUT_INFLATER_SERVICE);
        final View row=lo.inflate(R.layout.cust,parent,false);
        final TextView tv=(TextView) row.findViewById(R.id.textView2);

        final String ms1=getItem(position);

        tv.setText(ms1 );
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tv.getText().toString();
                Main2Activity.ctrls.setCs(getPosition(ms1));
                Main2Activity.ctrls.startSong(ctxx, text);
                Intent i1 = new Intent(ctxx, mudicPlay.class);
                i1.putExtra("song",text);
                ctxx.startActivity(i1);





            }
        });
        final ImageButton button = (ImageButton) row.findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(ctxx, button);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().toString().equals("Remove from Playlist")) {
                            Toast.makeText(ctxx, "hdg", Toast.LENGTH_SHORT).show();
                        }

                        if (item.getTitle().toString().equals("Play next")) {
                            Toast.makeText(ctxx, "hvdg", Toast.LENGTH_SHORT).show();
                        }



                        return true;

                    }
                });
                popup.show();
            }
        });
        return row;
    }




}


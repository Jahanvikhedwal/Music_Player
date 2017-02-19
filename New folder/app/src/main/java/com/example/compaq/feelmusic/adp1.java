package com.example.compaq.feelmusic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

/**
 * Created by compaq on 05-03-2016.
 */
public class adp1 extends ArrayAdapter<musicsong> {Context ctxx;



    public adp1(Context context, int resource, List<musicsong>objects) {
        super(context, resource, objects);
        ctxx=context;

    }
        public View getView(final int position,View convertView, ViewGroup parent){
            LayoutInflater lo= (LayoutInflater) getContext().getSystemService(ctxx.LAYOUT_INFLATER_SERVICE);
            final View row=lo.inflate(R.layout.cust,parent,false);
            final TextView tv=(TextView) row.findViewById(R.id.textView2);
tv.setTypeface(null, Typeface.NORMAL);
            tv.setTextColor(Color.BLACK);

            final musicsong m1=getItem(position);

            tv.setText(m1.getSongTitle());
tv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String text = tv.getText().toString();
        Main2Activity.ctrls.setCs(getPosition(m1));
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
                                if (item.getTitle().toString().equals("Add to Playlist")) {

                                    Intent ie = new Intent(ctxx, playlist1.class);
                                    TextView tv = (TextView) row.findViewById(R.id.textView2);
                                    String s1 = tv.getText().toString();
                                    ie.putExtra("namee", s1);
                                    ctxx.startActivity(ie);
                                }
                                if (item.getTitle().toString().equals("Share")) {
                                    String path = m1.getSongPath();
                                    Uri u = Uri.parse(path);
                                    Intent i7 = new Intent(Intent.ACTION_SEND);
                                    i7.setType("audio/*");
                                    i7.putExtra(Intent.EXTRA_STREAM, u);
                                    ctxx.startActivity(i7.createChooser(i7, "Share via.."));
                                }
                                if (item.getTitle().toString().equals("Play next")) {
                                    Toast.makeText(ctxx,"hjhjh",Toast.LENGTH_SHORT).show();}

                                        if (item.getTitle().toString().equals("Delete")) {
                                            Toast.makeText(ctxx, "hgdg", Toast.LENGTH_SHORT).show();
                                            File file = new File(m1.getSongPath());
                                            boolean deleted = file.delete();
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
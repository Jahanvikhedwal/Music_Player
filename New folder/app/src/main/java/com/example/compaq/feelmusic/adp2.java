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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by compaq on 21-03-2016.
 */
public class adp2 extends ArrayAdapter<String> {
    public static  TextView tv;Context ctx1;
    public adp2(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        ctx1=context;
    }

    @Override
    public View getView(final int position,   View convertView, ViewGroup parent) {
        LayoutInflater lo= (LayoutInflater) getContext().getSystemService(ctx1.LAYOUT_INFLATER_SERVICE);
        final View row=lo.inflate(R.layout.cust,parent,false);
        final TextView tv=(TextView) row.findViewById(R.id.textView2);
        tv.setTypeface(null, Typeface.ITALIC);
        tv.setTextColor(Color.BLACK);

        String pl=getItem(position);
        tv.setText(pl);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so=tv.getText().toString();
                Intent io=new Intent(ctx1,playlistitem.class);
                io.putExtra("keyy",so);
                ctx1.startActivity(io);
            }
        });
        final ImageButton button = (ImageButton) row.findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(ctx1, button);
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu1, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().toString().equals("Share")) {
                            Toast.makeText(ctx1, "hvdg", Toast.LENGTH_SHORT).show();
                            ArrayList<Uri> Uris=new ArrayList<Uri>();
                            ArrayList<String> bb = new ArrayList<String>();
                            bb=Myutil.getPL(ctx1,tv.getText().toString());
                            int n=bb.size();
                            int i;
                            for( i=0;i<n;i++){
                                String m=bb.get(i);
                                String p = String.valueOf(Main2Activity.ctrls.getSongsMap().get(m).getSongPath());
                                Uris.add(i, (Uri.parse(p)));
                            }
                            Intent shareIntent = new Intent();
                            shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
                            shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, Uris);
                            shareIntent.setType("audio/*");
                            ctx1.startActivity(Intent.createChooser(shareIntent, "Share with..."));
                        }
                        if (item.getTitle().toString().equals("Delete")) {
                            Toast.makeText(ctx1, "hgdg", Toast.LENGTH_SHORT).show();
                            Myutil.deleteFromPL(ctx1,tv.getText().toString());
                        }
                        if (item.getTitle().toString().equals("Add songs")) {
                            Toast.makeText(ctx1, "hgggdg", Toast.LENGTH_SHORT).show();
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

package com.example.compaq.feelmusic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by computer on 2/20/2016.
 */
public class Myutil {
/*
    public static ArrayList<LawlSong> getPL(Context ctx, String pl) {
        ArrayList<LawlSong> res = new ArrayList<LawlSong>();
        SQLiteDatabase db = ctx.openOrCreateDatabase("mydb", ctx.MODE_PRIVATE, null);
        String sql = "select * from play_list where pname = ? ";
        String sa[] = {pl};
        Cursor c1 = db.rawQuery(sql, sa);
        int in1 = c1.getColumnIndex("sname");
        int in2 = c1.getColumnIndex("spath");
        LinkedList<LawlSong> a1 = new LinkedList<LawlSong>();
        while (c1.moveToNext()) {
            LawlSong s1 = new LawlSong();
            s1.setTitle(c1.getString(in1));
            s1.setPath(c1.getString(in2));
            res.add(s1);
        }
        db.close();
        return res;
    }
*/

    public static ArrayList<String> getPLNames(Context ctx) {
        ArrayList<String> res = new ArrayList<String>();
        SQLiteDatabase db = ctx.openOrCreateDatabase("mydb", ctx.MODE_PRIVATE, null);
        String sql = "select distinct pname from play_list ";
        String sa[] = {};
        Cursor c1 = db.rawQuery(sql, sa);
        int in1 = c1.getColumnIndex("pname");
        LinkedList<String> a1 = new LinkedList<String>();
        while (c1.moveToNext()) {
            res.add(c1.getString(in1));
        }
        db.close();
        return res;
    }

    public static ArrayList<String> getPL(Context ctx, String pl) {
        ArrayList<String> res = new ArrayList<String>();
        SQLiteDatabase db = ctx.openOrCreateDatabase("mydb", ctx.MODE_PRIVATE, null);
        String sql = "select * from play_list where pname = ? ";
        String sa[] = {pl};
        Cursor c1 = db.rawQuery(sql, sa);
        int in1 = c1.getColumnIndex("sname");
        LinkedList<String> a1 = new LinkedList<String>();
        while (c1.moveToNext()) {
            res.add(c1.getString(in1));
        }
        db.close();
        return res;
    }

    public static void insertIntoPL(Context ctx, String pl, String sname, String spath) {
        SQLiteDatabase db = ctx.openOrCreateDatabase("mydb", ctx.MODE_PRIVATE, null);
        String sql = "insert into play_list(sname, spath, pname) values (?, ?, ?)";
        Object oa[] = new Object[3];
        oa[0]=sname;
        oa[1]=spath;
        oa[2]=pl;
        db.execSQL(sql , oa);
        db.close();
    }

    public static void deleteFromPL(Context ctx, String pl) {
        SQLiteDatabase db = ctx.openOrCreateDatabase("mydb", ctx.MODE_PRIVATE, null);
        String sql = "delete from play_list where  pname = ? ";
        Object oa[] = new Object[1];
        oa[0]=pl;
        db.execSQL(sql , oa);
        db.close();
    }

}

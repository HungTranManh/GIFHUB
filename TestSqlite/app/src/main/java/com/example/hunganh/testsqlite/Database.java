package com.example.hunganh.testsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Database {
    private Context context;
    private static final String NAME_DATA="truyencuoi2016";
    private SQLiteDatabase database;
    private String path;
    private static final String TAG=Database.class.getSimpleName();

    public Database(Context context) {
        this.context = context;
        copyDatabase();
    }

    private void copyDatabase(){
        String pathDirectorry= Environment.getDataDirectory()+"/data/"+context.getPackageName();
        String pathFodelData=pathDirectorry+"/database";
        new File(pathFodelData).mkdir();
        path=pathFodelData+"/"+NAME_DATA;
        File file=new File(path);
        if(file.exists()){
            return;
        }
        try {
            InputStream in=context.getAssets().open(NAME_DATA);
            FileOutputStream out=new FileOutputStream(path);
            byte[] b=new byte[1024];
            int le=in.read(b);
            while (le>=0){
                out.write(b,0,le);
                le=in.read(b);
            }
            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void openDatabase(){
        if(database!=null&&database.isOpen()){
            return;
        }
        database=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);
    }
    private void closeDatabase(){
        if (database!=null&&database.isOpen()){
            database.close();
            database=null;
        }
    }
    public void selectTableCategories(){
        openDatabase();
        String query="select * from categories  ";
        Cursor c=database.rawQuery(query,null);
        int indexId=c.getColumnIndex("id");
        int indexName=c.getColumnIndex("name");
        int indexCount=c.getColumnIndex("count");
        int indexOrdering=c.getColumnIndex("ordering");
        c.moveToFirst();
        while (!c.isAfterLast()){
            int id=c.getInt(indexId);
            String name=c.getString(indexName);
            int count=c.getInt(indexCount);
            int ordering=c.getInt(indexOrdering);
            Log.d(TAG, "id:"+id);
            Log.d(TAG, "Name:"+name);
            Log.d(TAG, "count:"+count);
            Log.d(TAG, "ordering:"+ordering);
        }
        closeDatabase();
    }

}

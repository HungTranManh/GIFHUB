package com.t3h.demodiaplayer;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.os.Binder;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MusicService extends Service {
    private List<ItemSong> itemSongs;
    private PlayManager playManager;
    private MyBind myBind;


    public List<ItemSong> getItemSongs() {
        return itemSongs;
    }


    @Override
    public void onCreate() {
        playManager = new PlayManager();
        myBind=new MyBind(this);
        init();
        initData();
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBind;
    }
    private void init(){
        itemSongs = new ArrayList<>();
    }
    private void initData() {
        itemSongs.clear();
        Cursor c =
                getContentResolver().query(
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        null, null, null,
                        MediaStore.MediaColumns.DATE_ADDED + " DESC"
                );
        if (c != null) {
            int indexPath = c.getColumnIndex(
                    MediaStore.MediaColumns.DATA
            );
            int indexDuration = c.getColumnIndex(
                    MediaStore.Audio.Media.DURATION
            );
            int indexArtist = c.getColumnIndex(
                    MediaStore.Audio.Media.ARTIST_ID
            );
            int indexTitle = c.getColumnIndex(
                    MediaStore.Audio.Media.TITLE
            );
            c.moveToFirst();
            while (!c.isAfterLast()) {
                String path = c.getString(indexPath);
                long duration = c.getLong(indexDuration) * 1000;
                String artist = c.getString(indexArtist);
                String title = c.getString(indexTitle);
                itemSongs.add(new ItemSong(path, title, duration, artist));
                c.moveToNext();
            }
            c.close();
        }
    }
    public void openPlay(int position){
        playManager.init(
                itemSongs.get(position).getPath()
        );
        if (playManager.getMediaPlayer() != null) {
            playManager.prepare();
            playManager.start();
        }
    }

}

package com.t3h.demodiaplayer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducnd on 5/11/18.
 */

public class MusicService extends Service {
    private List<ItemSong> itemSongs;
    private PlayManager playManager;

    @Override
    public void onCreate() {
        super.onCreate();
        playManager = new PlayManager();
        itemSongs = new ArrayList<>();
        initData();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder(this);
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

    public void playMusic(int position) {
        playManager.init(
                itemSongs.get(position).getPath()
        );
        if (playManager.getMediaPlayer() != null) {
            playManager.prepare();
            playManager.start();
        }
        createNotification(itemSongs.get(position));
    }


    public int getCount() {
        if (itemSongs == null) {
            return 0;
        }
        return itemSongs.size();
    }

    public ItemSong getData(int position) {
        return itemSongs.get(position);
    }

    private void createNotification(ItemSong itemSong) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);
        builder.setLargeIcon(BitmapFactory.decodeResource(
                getResources(), R.mipmap.ic_launcher));
        builder.setSmallIcon(R.drawable.ic_notifications_white_24dp);
        builder.setContentTitle(itemSong.getName());
        builder.setContentText(itemSong.getArtis());

        //PendingIntent de cho xu ly tac vu khi xay ra mot su kien
        Intent intent = new Intent();
        intent.putExtra("id", 1);
        intent.setClass(this, MainActivity.class);
        PendingIntent pendingIntent=
                PendingIntent.getActivity(this, 1, intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
        //neu activity dang song thi roi vao onNewIntent khi click vao notification
        //neu activity chet thi roi vao onCreate cua Activity do
        builder.setContentIntent(pendingIntent);

//        NotificationManager manager =
//                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.notify(1, builder.build());

        //cho service song dua bao notification
        startForeground(1, builder.build());
    }
}

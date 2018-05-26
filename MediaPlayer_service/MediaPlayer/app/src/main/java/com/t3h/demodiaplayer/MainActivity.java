package com.t3h.demodiaplayer;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements SongAdapter.ISongAdapter, SwipeRefreshLayout.OnRefreshListener {

    private ListView lvMusic;
    private SongAdapter adapter;
    private SwipeRefreshLayout refresh;
    private MusicService musicService;
    private ServiceConnection conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService();
        initViews();
        connectMusicService();
    }

    private void startService(){
        Intent intent = new Intent();
        intent.setClass(this, MusicService.class);
        startService(intent);

    }

    private void connectMusicService() {
        //tao ra cau ket noi den service
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name,
                                           IBinder service) {
                MyBinder myBinder = (MyBinder) service;
                musicService = myBinder.getService();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
               musicService = null;
            }
        };
        Intent intent = new Intent();
        intent.setClass(this, MusicService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    private void initViews() {

        lvMusic = (ListView) findViewById(R.id.lv_music);
        refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        refresh.setOnRefreshListener(this);
        adapter = new SongAdapter(this);
        lvMusic.setAdapter(adapter);
    }


    @Override
    public void clickItem(int position) {
        musicService.playMusic(position);
    }


    @Override
    public void onRefresh() {

        refresh.setRefreshing(false);
    }

    @Override
    public int getCount() {
        if (musicService == null) {
            return 0;
        }
        return musicService.getCount();
    }

    @Override
    public ItemSong getData(int position) {
        return musicService.getData(position);
    }

    @Override
    protected void onDestroy() {
        if ( conn != null ) {
            unbindService(conn);
        }
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        //neu activity dang song
        musicService.stopForeground(true);
        NotificationManager manager =
                (NotificationManager)getSystemService(
                        Context.NOTIFICATION_SERVICE
                );
        manager.cancel(1);
    }
}

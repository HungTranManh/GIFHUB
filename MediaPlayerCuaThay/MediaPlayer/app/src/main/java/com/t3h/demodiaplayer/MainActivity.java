package com.t3h.demodiaplayer;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.Environment;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity implements SongAdapter.ISongAdapter, SwipeRefreshLayout.OnRefreshListener {

    private ListView lvMusic;
    private SwipeRefreshLayout refresh;
    private MusicService musicService;
    private ServiceConnection conn;
    private SongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initViews();
//        connetMusicService();
    }

    private void initViews() {
        adapter = new SongAdapter(this);
        lvMusic = (ListView) findViewById(R.id.lv_music);
        refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        refresh.setOnRefreshListener(this);
        lvMusic.setAdapter(adapter);
    }

    private void connetMusicService() {
        //tao ra connetion ket noi toi service
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MyBind myBind = (MyBind) iBinder;
                musicService = myBind.getMusicService();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                musicService = null;
            }
        };
        Intent intent = new Intent();
        intent.setClass(this, MusicService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    @Override
    public void clickItem(int position) {
        musicService.openPlay(position);
    }

    @Override
    public int getCount() {
        if (musicService == null) {
            return 0;
        } else {
            return musicService.getItemSongs().size();
        }
    }

    @Override
    public ItemSong getItem(int position) {
        if (musicService.getItemSongs() == null) {
            return null;
        }
        return musicService.getItemSongs().get(position);
    }


    @Override
    public void onRefresh() {
        refresh.setRefreshing(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}

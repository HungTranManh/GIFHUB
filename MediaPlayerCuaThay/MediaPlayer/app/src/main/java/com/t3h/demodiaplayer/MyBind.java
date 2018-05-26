package com.t3h.demodiaplayer;

import android.os.Binder;

import java.text.Bidi;

public class MyBind extends Binder {
    private MusicService musicService;

    public MyBind(MusicService musicService) {
        this.musicService = musicService;
    }

    public MusicService getMusicService() {
        return musicService;
    }
}

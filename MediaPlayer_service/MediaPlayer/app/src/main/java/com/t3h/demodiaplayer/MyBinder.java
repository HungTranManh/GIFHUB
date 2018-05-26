package com.t3h.demodiaplayer;

import android.os.Binder;

/**
 * Created by ducnd on 5/11/18.
 */

public class MyBinder extends Binder{
    private MusicService service;

    public MyBinder(MusicService service) {
        this.service = service;
    }

    public MusicService getService(){
        return service;
    }
}

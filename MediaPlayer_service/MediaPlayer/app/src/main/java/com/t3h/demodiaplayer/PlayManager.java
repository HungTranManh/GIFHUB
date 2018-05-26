package com.t3h.demodiaplayer;

import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by Lap trinh on 4/27/2018.
 */

public class PlayManager {
    private MediaPlayer mediaPlayer;

    public void init(String path){
        if ( mediaPlayer != null ) {
            mediaPlayer.release();
        }
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(path);
        } catch (IOException e) {
            mediaPlayer = null;
            //xay ra khi duong dang khong hop le
            e.printStackTrace();
        }
    }

    public void prepare(){
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        mediaPlayer.start();
    }
    public void pause(){
        mediaPlayer.pause();
    }
    public void release(){
        if ( mediaPlayer != null ) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
}

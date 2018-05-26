package com.t3h.demodiaplayer;

/**
 * Created by Lap trinh on 4/27/2018.
 */

public class ItemSong  {
    private String path;
    private String name;
    private long duration;
    private String artis;

    public ItemSong(String path, String name, long duration, String artis) {
        this.path = path;
        this.name = name;
        this.duration = duration;
        this.artis = artis;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }
}

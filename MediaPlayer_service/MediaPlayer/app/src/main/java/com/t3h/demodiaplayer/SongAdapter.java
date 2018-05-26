package com.t3h.demodiaplayer;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lap trinh on 4/27/2018.
 */

public class SongAdapter extends BaseAdapter {
    private ISongAdapter inter;
    private SimpleDateFormat format = new SimpleDateFormat("mm:ss");

    public SongAdapter(ISongAdapter inter) {
        this.inter = inter;
    }

    @Override
    public int getCount() {
      return inter.getCount();
    }

    @Override
    public Object getItem(int position) {
        return inter.getData(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view,
                        ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_music, viewGroup, false);
        }
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        TextView tvDuration = (TextView) view.findViewById(R.id.tv_duration);
        TextView tvArtis = (TextView) view.findViewById(R.id.tv_name);
        ItemSong itemSong = inter.getData(position);
        tvArtis.setText(itemSong.getArtis());
        tvDuration.setText(format.format(
                new Date(itemSong.getDuration())));
        tvName.setText(itemSong.getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inter.clickItem(position);
            }
        });
        return view;
    }

    public interface ISongAdapter{
        void clickItem(int position);
        int getCount();
        ItemSong getData(int position);
    }
}

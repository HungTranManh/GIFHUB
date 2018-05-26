package com.t3h.storemanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

/**
 * Created by Lap trinh on 4/22/2018.
 */

public class GalleryAdapter extends BaseAdapter {
    private List<ItemGallery> itemGalleries;
    private IGalleryAdapter inter;

    public GalleryAdapter(List<ItemGallery> itemGalleries,
                          IGalleryAdapter inter) {
        this.itemGalleries = itemGalleries;
        this.inter = inter;
    }

    public void setItemGalleries(List<ItemGallery> itemGalleries) {
        this.itemGalleries = itemGalleries;
    }

    @Override
    public int getCount() {
        if ( itemGalleries == null ) {
            return 0;
        }
        return itemGalleries.size();
    }

    @Override
    public Object getItem(int position) {
        return itemGalleries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View contentView, ViewGroup viewGroup) {
        if (contentView == null ){
            contentView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_image, viewGroup, false);
        }
        ItemGallery item = itemGalleries.get(position);
        ImageView ivImg = contentView.findViewById(R.id.iv_img);
        ///cach dung picaso
        Picasso
                .with(viewGroup.getContext())
                //neu link o tren internet, thif truyen vao link anh
                //link o trong dien thoai, truyen vao file
                .load(new File(item.getPath()))
                //placeholder khi dang loanding thi hien thi anh nay
                .placeholder(R.drawable.ao_dai)
                .error(R.drawable.ao_dai)
                .into(ivImg);
        ivImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inter.onClickItem(position);
            }
        });
        return contentView;
    }
    public interface IGalleryAdapter{
        void onClickItem(int position);
    }
}

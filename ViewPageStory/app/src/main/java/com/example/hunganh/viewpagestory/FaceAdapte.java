package com.example.hunganh.viewpagestory;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FaceAdapte extends PagerAdapter {
    List<FaceData> faceDatas;

    public FaceAdapte(List<FaceData> faceDatas) {
        this.faceDatas = faceDatas;
    }

    @Override
    public int getCount() {
        return faceDatas.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        //phương thức kiểm tra view có thể bị xóa hay không ở vị trí -2 và 2
        return view==object;
        //khi pt trả về true thì hệ thống tự gọi destroyItem để xóa nó đi
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //phương thức này tương ứng với phương thức getView() trong baseAdapter
        //+tạo ra ItemView
        LayoutInflater inflater=LayoutInflater.from(container.getContext());
        View view=inflater.inflate(R.layout.item_viewpager,container,false);
        ImageView ivFace=view.findViewById(R.id.iv_icon);
        TextView tvFace=view.findViewById(R.id.tv_icon);
        ivFace.setImageResource(faceDatas.get(position).getIdImageFace());
        tvFace.setText(faceDatas.get(position).getNameFace());
        container.addView(view);
        return view;
    }
}

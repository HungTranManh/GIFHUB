package com.t3h.storemanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by Lap trinh on 4/22/2018.
 */

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private ImageView ivAvatar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        ivAvatar = view.findViewById(R.id.iv_avatar);
        ivAvatar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        ((MainActivity)getContext()).openGalleryFragment();
    }

    public void chooseFile(ItemGallery itemGallery) {
        Picasso.with(getContext())
                .load(new File(itemGallery.getPath()))
                .placeholder(R.drawable.ao_dai)
                .error(R.drawable.ao_dai)
                .into(ivAvatar);
    }
}

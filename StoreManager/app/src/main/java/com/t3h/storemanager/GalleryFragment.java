package com.t3h.storemanager;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lap trinh on 4/22/2018.
 */

public class GalleryFragment extends Fragment implements
        GalleryAdapter.IGalleryAdapter{
    private static final String TAG = GalleryFragment.class.getSimpleName();
    private List<ItemGallery> itemGalleries;
    private GridView grid;
    private GalleryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallary, container, false);
        loadGallery();
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        grid = view.findViewById(R.id.grid);
        adapter = new GalleryAdapter(itemGalleries, this);
        grid.setAdapter(adapter);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {

    }

    private void loadGallery() {
        //lay dia chi cua co so du lieu
        // MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        //la dia chi bang anh
        Cursor c =
                getContext().getContentResolver()
                        .query(
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                new String[]{"_data"},
                                null,
                                null,
                                "date_modified DESC limit 20 offset 1"
                        );

        itemGalleries = new ArrayList<>();
        if ( c != null ) {
            int indexData = c.getColumnIndex("_data");
            c.moveToFirst();
            while (!c.isAfterLast()) {
                String path = c.getString(indexData);
                itemGalleries.add(new ItemGallery(path));
                c.moveToNext();
            }
            c.close();
        }

    }

    @Override
    public void onClickItem(int position) {
        ((MainActivity)getActivity()).chooseImage(
                itemGalleries.get(position)
        );
        getActivity().onBackPressed();
    }
}

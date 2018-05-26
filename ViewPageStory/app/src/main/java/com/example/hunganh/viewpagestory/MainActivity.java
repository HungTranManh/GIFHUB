package com.example.hunganh.viewpagestory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private ViewPager viewPager;
    private List<FaceData> faceDatas;
    FaceAdapte faceAdapte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initsData();
        viewPager=findViewById(R.id.viewpage_face);
        faceAdapte=new FaceAdapte(faceDatas);
        viewPager.setAdapter(faceAdapte);
        ViewPager viewpager = (ViewPager) viewPager.findViewById(R.id.viewpage_face);


    }
    private void initsData(){
        faceDatas=new ArrayList<>();
        faceDatas.add(new FaceData(R.drawable.im_7,false,"Smile"));
        faceDatas.add(new FaceData(R.drawable.im_7,false,"Smile"));
        faceDatas.add(new FaceData(R.drawable.im_1,false,"Smile"));
        faceDatas.add(new FaceData(R.drawable.im_2,false,"Smile"));
        faceDatas.add(new FaceData(R.drawable.im_7,false,"Smile"));
        faceDatas.add(new FaceData(R.drawable.im_1,false,"Smile"));
    }
}

package circleindicator.hungtm.com.testcircleindicator;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
   private List<ItemFaceData> itemFaceDatas;
   private AdapteViewPager adapteViewPager;
   private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemFaceDatas=new ArrayList<>();
        initData();
        adapteViewPager=new AdapteViewPager(itemFaceDatas);
        viewPager=findViewById(R.id.view_pager);
        CircleIndicator indicator =  findViewById(R.id.indicator);
        viewPager.setAdapter(adapteViewPager);
        indicator.setViewPager(viewPager);

    }
    private void initData(){
        itemFaceDatas.add(new ItemFaceData(R.drawable.big_smile,"Big Smile",false));
        itemFaceDatas.add(new ItemFaceData(R.drawable.boss,"boss",false));
        itemFaceDatas.add(new ItemFaceData(R.drawable.too_sad,"Too Sad",false));
        itemFaceDatas.add(new ItemFaceData(R.drawable.victory,"Victory",false));
        itemFaceDatas.add(new ItemFaceData(R.drawable.confuse,"Confuse",false));
        itemFaceDatas.add(new ItemFaceData(R.drawable.the_iron_man,"Iron Man",false));
    }
}

package circleindicator.hungtm.com.tablayoutdemo.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import circleindicator.hungtm.com.tablayoutdemo.AdapteViewPager;
import circleindicator.hungtm.com.tablayoutdemo.FragmentFavotite;
import circleindicator.hungtm.com.tablayoutdemo.R;
import circleindicator.hungtm.com.tablayoutdemo.Topic.FragmentTopic;

public class MainFragment extends Fragment{
    private TabLayout tab;
    private List<Fragment> fragments;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        tab=view.findViewById(R.id.tab_layout);
        ViewPager viewPager=view.findViewById(R.id.view_pager);
        fragments=new ArrayList<>();
        addFragment();
        AdapteViewPager adapteViewPager=new AdapteViewPager(getChildFragmentManager(),fragments);
        viewPager.setAdapter(adapteViewPager);
        tab.setupWithViewPager(viewPager);
        return view;
    }

    private void addFragment(){
        fragments.add(new FragmentTopic());
        fragments.add(new FragmentFavotite());
    }


}

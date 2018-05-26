package circleindicator.hungtm.com.tablayoutdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import circleindicator.hungtm.com.tablayoutdemo.Story.FragmentStory;
import circleindicator.hungtm.com.tablayoutdemo.main.MainFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
        .replace(R.id.content, new MainFragment(), MainFragment.class.getName())
        .commit();
    }

    public void openStore(String name) {
        FragmentStory fragmentStore = new FragmentStory();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("NAME", name);
        fragmentStore.setArguments(bundle);
//        transaction.setCustomAnimations(R.anim.exit_left_to_right, R.anim.enter_left_to_right,R.anim.exit_right_to_left,R.anim.enter_right_to_left);
        transaction.replace(R.id.content, fragmentStore, FragmentStory.class.getName());
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void openDetail(String title,String detail){
        FragmentDetail fragmentDetail=new FragmentDetail();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        Bundle bundle=new Bundle();
        bundle.putString("TITLE",title);
        bundle.putString("DETAIL",detail);
        fragmentDetail.setArguments(bundle);
//        transaction.setCustomAnimations(R.anim.exit_left_to_right, R.anim.enter_left_to_right,R.anim.exit_right_to_left,R.anim.enter_right_to_left);
        transaction.replace(R.id.content,fragmentDetail,FragmentDetail.class.getName());
        transaction.addToBackStack(null);
        transaction.commit();

    }

}

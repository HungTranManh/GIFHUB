package ailatrieuphu.hungtm.com.sqliteoperatingsystem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addRegisterFragment();
    }
    private void addRegisterFragment(){
        FragmentManager manager=getSupportFragmentManager();
        RegisterFragment registerFragment=new RegisterFragment();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.conten,registerFragment,RegisterFragment.class.getName());
        transaction.commit();
    }
    public  void openGalaryFragment(){
        GalaryFragment fragment=new GalaryFragment();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.hide(getcurrentFragment());
        transaction.add(R.id.conten,fragment,GalaryFragment.class.getName());
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public Fragment getcurrentFragment(){
        List<Fragment> fragments=getSupportFragmentManager().getFragments();
        for(Fragment fragment:fragments){
            if (fragment!=null&&fragment.isVisible()){
                return fragment;
            }
        }
        return null;
    }
    public  void chooseImage(ItemGalary itemGalary){
        Fragment fragment=getSupportFragmentManager().findFragmentByTag(RegisterFragment.class.getName());
        if(fragment!=null){
            ((RegisterFragment)fragment).chooseImage(itemGalary);
        }
    }
}

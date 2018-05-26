package com.t3h.storemanager;

import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addRegisterFragment();
    }

    private void addRegisterFragment() {
        RegisterFragment fragment = new RegisterFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.content, fragment,
                RegisterFragment.class.getName());
        transaction.commit();
    }

    public void openGalleryFragment() {
        GalleryFragment fragment = new GalleryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(getCurrentFragment());
        transaction.add(
                R.id.content,
                fragment,
                GalleryFragment.class.getName()
        );
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public Fragment getCurrentFragment() {
        List<Fragment> fragments =
                getSupportFragmentManager()
                        .getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != null && fragment.isVisible()) {
                return fragment;
            }
        }
        return null;
    }

    public void chooseImage(ItemGallery itemGallery) {
        Fragment f  =getSupportFragmentManager().findFragmentByTag(
                RegisterFragment.class.getName()
        );
        if ( f != null ) {
            ((RegisterFragment)f).chooseFile(itemGallery);
        }
    }
}

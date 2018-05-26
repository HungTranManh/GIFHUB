package ailatrieuphu.hungtm.com.mediaplayer;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ailatrieuphu.hungtm.com.mediaplayer.main.fragment_music.MusicFragment;
import ailatrieuphu.hungtm.com.mediaplayer.main.fragment_music.itemsong.ListMusicFragment;
import ailatrieuphu.hungtm.com.mediaplayer.service_music.MusicService;

import static android.support.v4.view.MenuItemCompat.getActionView;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
private DrawerLayout drawerLayout;
private ActionBar actionBar;
private  static final String TAG=MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout
                , R.string.open, R.string.close);
        actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        drawerToggle.syncState();
        init();
        startService();
        addFragmentMenu();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView)getActionView(searchItem);
       searchView.setOnQueryTextListener(this);
        return true;
    }
    private void init(){
        drawerLayout=findViewById(R.id.drawer_layout);
    }
    public void addFragmentMenu(){
        MusicFragment fragment=new MusicFragment();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.content,fragment,MusicFragment.class.getName());
        transaction.commit();
    }
    public  void openActivityPlayMusic(int position){
        Intent intent=new Intent(MainActivity.this,PlayMusicActivity.class);
        intent.putExtra("POSITION",position);
        startActivity(intent);
        finish();

    }
    private void startService(){
        Intent intent=new Intent();
        intent.setClass(this,MusicService.class);
        startService(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        NotificationManager notification=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notification.cancel(Constant.FOREGROUND_SERVICE);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d(TAG, "onQueryTextSubmit: ________"+query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(TAG, "onQueryTextChange2: _____"+newText);
        if(TextUtils.isEmpty(newText)){
            Log.d(TAG, "onQueryTextChange1: _____"+newText);
        }
        else {
            Log.d(TAG, "onQueryTextChange: _____"+newText);
        }
        return true;
    }
}

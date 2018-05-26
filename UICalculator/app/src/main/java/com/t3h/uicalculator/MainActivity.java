package com.t3h.uicalculator;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.databinding.DataBindingUtil;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.t3h.uicalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    private MyBroadcast myBroadcast;
    private ServiceConnection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        initViews();
//        registerBroadcast();
    }

//    private void registerBroadcast(){
//        myBroadcast = new MyBroadcast();
//        IntentFilter filter = new IntentFilter();
//        filter.addAction("Ahihi_Do_Ngoc");
//        registerReceiver(myBroadcast, filter);
//    }

//   private void unregister(){
//        unregisterReceiver(myBroadcast);
//    }

    @Override
    protected void onDestroy() {
      //  unregister();
        super.onDestroy();
    }
    private void connectionService(){
        conn=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }

        };
    }
    private void initViews() {
        binding.btnSub.setOnClickListener(this);
        binding.btnSum.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int numberA =
                Integer.parseInt(
                        binding.edtNumberA.getText()
                                .toString()
                );
        int numberB =
                Integer.parseInt(
                        binding.edtNumberB.getText()
                                .toString()
                );
        switch (view.getId()) {
            case R.id.btn_sub:
                Intent intent = new Intent();
                //par1: package name cua ung dung muon den
                //part2: package + ten class cua service trong ung dung
                intent.setClassName("caculatorservice.hungtm.com.caculatorservice",
                        "caculatorservice.hungtm.com.caculatorservice.ServiceCaculator");
                intent.putExtra("NUMBER_A", numberA);
                intent.putExtra("NUMBER_B", numberB);
                intent.putExtra("KEY", "SUB");
                //cho intent chay den service
                startService(intent);
                break;
            case R.id.btn_sum:
                intent = new Intent();
                intent.setClassName("caculatorservice.hungtm.com.caculatorservice",
                        "caculatorservice.hungtm.com.caculatorservice.ServiceCaculator");
                intent.putExtra("NUMBER_A", numberA);
                intent.putExtra("NUMBER_B", numberB);
                intent.putExtra("KEY", "SUM");
                startService(intent);
                break;
            default:
                break;
        }
    }

    private class MyBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                case "Ahihi_Do_Ngoc":
                    int result = intent.getIntExtra("RESULT", 0);
                    binding.tvResult.setText(
                            result + ""
                    );
                    break;
                default:
                    break;
            }
        }
    }
}

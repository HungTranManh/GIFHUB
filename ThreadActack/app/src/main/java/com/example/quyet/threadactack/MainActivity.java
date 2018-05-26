package com.example.quyet.threadactack;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.quyet.threadactack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {
    private ActivityMainBinding binding;
    private Handler handler;
    private static final  int MES1 = 1;
    private static final int MES2 = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btRun.setOnClickListener(this);
        initHandler();
        initNumber();
    }

    private  void  initNumber() {
        Thread thread = new  Thread(this);
        thread.start();
    }

    private  void initHandler() {
        handler = new  Handler() {
            @Override
            public    void handleMessage(Message msg) {

                switch (msg.what) {
                    case 1:
                        binding.tvNumber.setText(msg.arg1 + "");
                        break;
                    case 2:
                        binding.tvTwo.setText(msg.obj + "");
                        break;
                }

            }
        };

    }


    @Override
    public  void run() {
        for (int i = 0; i < 100; i++) {
            Message mes = new Message();
            mes.what = MES1;
//                    đưa dữ liệu vào mes
            mes.arg1 = i;
//                    truyền mes vào handler
            mes.setTarget(handler);
            mes.sendToTarget();
            if (i % 2 == 0) {
                Message mes2 = new Message();
                mes2.what = MES2;
                mes2.obj = i + "ahihi";
                mes2.setTarget(handler);

                mes2.sendToTarget();
            }
            SystemClock.sleep(1000);
        }
    }

    @Override
    public  void onClick(View view) {
        switch (view.getId()){
            case R.id.btRun:
                initNumber();
                break;
                default:
                    break;
        }
    }
}





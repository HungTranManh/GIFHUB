package caculatorservice.hungtm.com.uiserviceredo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UICaculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNumA,edtNumB;
    private TextView tvResult;
    private MyBroadCast myBroadCast;
    private Button btnSub,btnSum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculator);
        inits();
        registerBroadCast();
    }

    private void inits() {
        edtNumA=findViewById(R.id.edt_num_a);
        edtNumB=findViewById(R.id.edt_num_b);
        tvResult=findViewById(R.id.tv_result);
        btnSub=findViewById(R.id.btn_sub);
        btnSum=findViewById(R.id.btn_sum);
        btnSub.setOnClickListener(this);
        btnSum.setOnClickListener(this);


    }
    private void registerBroadCast(){
        myBroadCast=new MyBroadCast();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("HeHe");
        intentFilter.addAction("HiHi");
        registerReceiver(myBroadCast,intentFilter);
    }
    private void unRegisterBroadCast(){
        unregisterReceiver(myBroadCast);
    }

    @Override
    public void onClick(View v) {
        int numA=Integer.parseInt(edtNumA.getText().toString());
        int numB=Integer.parseInt(edtNumB.getText().toString());
        switch (v.getId()){
            case R.id.btn_sub:
                Intent intent=new Intent();
                intent.setClassName("caculatorservice.hungtm.com.caculatorservice",
                        "caculatorservice.hungtm.com.caculatorservice.ServiceCaculator");
                intent.putExtra("NUMBER_A",numA);
                intent.putExtra("NUMBER_B",numB);
                intent.putExtra("KEY","SUB");
                startService(intent);
                break;
            case R.id.btn_sum:
                Intent intent1=new Intent();
                intent1.setClassName("caculatorservice.hungtm.com.caculatorservice",
                        "caculatorservice.hungtm.com.caculatorservice.ServiceCaculator");
                intent1.putExtra("NUMBER_A",numA);
                intent1.putExtra("NUMBER_B",numB);
                intent1.putExtra("KEY","SUM");
                startService(intent1);
                break;
                default:
                    break;
        }
    }
private class MyBroadCast extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case "HeHe":
                tvResult.setText(intent.getIntExtra("RESULT",0)+"");
                break;
            case "HiHi":
                tvResult.setText(intent.getIntExtra("RESULT",0)+"");
                break;
                default:
                    break;
        }
    }
}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterBroadCast();
    }
}

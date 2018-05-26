package uiservice.hungtm.com.uiservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSub, btnSum;
    private EditText edtA, edtB;
    private TextView tvResult;
    private  MyBroadCast myBroadCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initsView();
        registerBroadCast();


    }
    private void registerBroadCast(){
        myBroadCast=new MyBroadCast();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("CALCULATOR_SUB");
        intentFilter.addAction("CALCULATOR_SUM");
        registerReceiver(myBroadCast,intentFilter);

    }
private void unRegister(){
    unregisterReceiver(myBroadCast);
}
    private void initsView() {
        btnSub = findViewById(R.id.btn_Sub);
        btnSum = findViewById(R.id.btn_Sum);
        edtA = findViewById(R.id.edt_num_a);
        edtB = findViewById(R.id.edt_num_b);
        tvResult=findViewById(R.id.tv_result);
        btnSub.setOnClickListener(this);
        btnSum.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int numA = Integer.parseInt(edtA.getText().toString());
        int numB = Integer.parseInt(edtB.getText().toString());
        switch (v.getId()) {
            case R.id.btn_Sub:
                Intent intent = new Intent();
                //para1:packageName cuar  ung dung muon ket noi toi
                //para2:packageName +ten class cua Service trong ung dung
                intent.setClassName("caculatorservice.hungtm.com.caculatorservice", "caculatorservice.hungtm.com.caculatorservice.ServiceDemo");
                intent.putExtra("NUMBER_A", numA);
                intent.putExtra("NUMBER_B", numB);
                intent.putExtra("KEY", "SUB");
                startService(intent);
                break;
            case R.id.btn_Sum:
                Intent intent1 = new Intent();
                intent1.setClassName("caculatorservice.hungtm.com.caculatorservice", "caculatorservice.hungtm.com.caculatorservice.ServiceDemo");
                intent1.putExtra("NUMBER_A", numA);
                intent1.putExtra("NUMBER_B", numB);
                intent1.putExtra("KEY", "SUM");
                startService(intent1);
                break;
            default:
                break;
        }
    }

    private class MyBroadCast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                case "CALCULATOR_SUB":
                    tvResult.setText(intent.getIntExtra("RESULT", 0)+"");
                    break;
                case "CALCULATOR_SUM":
                    tvResult.setText(intent.getIntExtra("RESULT", 0)+"");
                    break;
                default:
                    break;
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegister();
    }
}

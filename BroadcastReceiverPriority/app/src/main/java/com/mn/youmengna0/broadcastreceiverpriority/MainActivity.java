package com.mn.youmengna0.broadcastreceiverpriority;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start;
    private Button regiter;
    private Button unregiter;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.startBtn);
        regiter=(Button)findViewById(R.id.registerBtn);
        unregiter=(Button)findViewById(R.id.unregisterBtn);
        start.setOnClickListener(this);
        regiter.setOnClickListener(this);
        unregiter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startBtn:
                intent=new Intent(MyReceiver1.ACTION);
                sendBroadcast(intent);
                break;
            case R.id.registerBtn:
                if(myReceiver1==null)
                {
                    myReceiver1=new MyReceiver1();
                    registerReceiver(myReceiver1,new IntentFilter(MyReceiver1.ACTION));
                }
                break;
            case R.id.unregisterBtn:
                if(myReceiver1!=null)
                {
                    unregisterReceiver(myReceiver1);
                    myReceiver1=null;
                }
               break;
        }
    }
    private MyReceiver1 myReceiver1;
}

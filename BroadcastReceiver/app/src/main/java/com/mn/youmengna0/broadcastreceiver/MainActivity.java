package com.mn.youmengna0.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendBtn;
    private Button registerBtn;
    private Button unregisterBtn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn=(Button) findViewById(R.id.sendBtn);
        registerBtn=(Button)findViewById(R.id.registerBtn);
        unregisterBtn=(Button)findViewById(R.id.unregisterBtn);
        sendBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        unregisterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sendBtn:
                intent=new Intent(MyReceiver.ACTION);
                intent.putExtra("data","Hello");
                sendBroadcast(intent);
                break;
            case R.id.registerBtn:
                if(myReceiver==null)
                {
                    myReceiver=new MyReceiver();
                    registerReceiver(myReceiver,new IntentFilter(MyReceiver.ACTION));
                }
                break;
            case R.id.unregisterBtn:
                if(myReceiver!=null){
                    unregisterReceiver(myReceiver);
                    myReceiver=null;
                }
                break;

        }
    }
    private MyReceiver myReceiver=null;
}

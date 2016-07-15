package com.mn.youmengna0.learnservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, MyService.class);
        findViewById(R.id.startService).setOnClickListener(this);
        findViewById(R.id.stopService).setOnClickListener(this);
        findViewById(R.id.bindService).setOnClickListener(this);
        findViewById(R.id.unbindService).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startService:
                startService(intent);
                break;
            case R.id.stopService:
                stopService(intent);
                break;
            case R.id.bindService:
                bindService(intent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unbindService:
                unbindService(this);
                break;
        }

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.e("info","service connected");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}

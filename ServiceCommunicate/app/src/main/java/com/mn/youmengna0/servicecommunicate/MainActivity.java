package com.mn.youmengna0.servicecommunicate;

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
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Button startBtn;
    private Button stopBtn;
    private Button bindBtn;
    private Button unbindBtn;
    private Button synhro;
    private EditText editText;
    private Intent intent;
    private MyService.Binder binder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit);
        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        bindBtn = (Button) findViewById(R.id.bindBtn);
        unbindBtn = (Button) findViewById(R.id.unbindBtn);
        synhro = (Button) findViewById(R.id.synchro);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        bindBtn.setOnClickListener(this);
        unbindBtn.setOnClickListener(this);
        synhro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startBtn:
                intent = new Intent(MainActivity.this, MyService.class);
                intent.putExtra("data", editText.getText().toString());
                startService(intent);
                break;
            case R.id.stopBtn:
                stopService(intent);
                break;
            case R.id.bindBtn:
                bindService(intent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unbindBtn:
                unbindService(this);
            case R.id.synchro:
                if (binder != null) {
                    binder.setData(editText.getText().toString());
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        binder = (MyService.Binder) service;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}

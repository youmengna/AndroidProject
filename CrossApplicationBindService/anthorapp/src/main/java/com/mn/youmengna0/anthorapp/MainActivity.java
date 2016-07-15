package com.mn.youmengna0.anthorapp;
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

    private Button bindBtn;
    private Button unbindBtn;
    Intent intent=new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindBtn=(Button)findViewById(R.id.bindBtn);
        unbindBtn=(Button)findViewById(R.id.unbindBtn);
        bindBtn.setOnClickListener(this);
        unbindBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bindBtn:
                bindService(intent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.unbindBtn:
                unbindService(this);
        }

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.e("info","service bind");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}

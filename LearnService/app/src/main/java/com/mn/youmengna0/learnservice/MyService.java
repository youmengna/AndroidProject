package com.mn.youmengna0.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
       // System.out.print("service create");
        Log.e("info","service create");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // System.out.print("service start");
        Log.e("info","service start");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("info","service destroy");
        //System.out.print("service destroy");
    }
}

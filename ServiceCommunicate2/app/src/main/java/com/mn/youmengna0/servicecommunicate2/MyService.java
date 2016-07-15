package com.mn.youmengna0.servicecommunicate2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    boolean running = false;
    String data;

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    public class Binder extends android.os.Binder{
        public void setData(String data)
        {
            MyService.this.data=data;
        }
        public MyService getService(){
            return MyService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        running = true;
        Thread thread = new Thread(new Runnable() {
            int i=0;
            @Override
            public void run() {
                while (running) {
                    i++;
                    if(callback!=null){
                        String str=i+data;
                        callback.onDataChange(str);
                        Log.e("info", str);
                    }
                }
            }
        });
        thread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        data=intent.getExtras().getString("data");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        running = false;
        super.onDestroy();
    }

    private Callback callback;
    public void setCallback(Callback callback) {
        this.callback = callback;
    }
    public Callback getCallback() {
        return callback;
    }
    public static interface Callback{
        void onDataChange(String data);
    }
}

package com.mn.youmengna0.broadcastreceiverpriority;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver3 extends BroadcastReceiver {
    public MyReceiver3() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("info","Myservice3 接收到信息");
    }
}

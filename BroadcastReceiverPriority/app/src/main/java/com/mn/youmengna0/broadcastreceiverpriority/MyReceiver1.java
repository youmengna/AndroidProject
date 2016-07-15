package com.mn.youmengna0.broadcastreceiverpriority;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver1 extends BroadcastReceiver {

    public static final String ACTION="com.mn.youmengna0.broadcastreceiverpriority.intent.action.RECEIVE";
    public MyReceiver1() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("info","Myservice1 接收到信息");
    }
}

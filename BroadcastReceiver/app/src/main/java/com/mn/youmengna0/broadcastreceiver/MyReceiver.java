package com.mn.youmengna0.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public static final String ACTION="com.mn.youmengna0.broadcastreceiver.intent.action.MyReceiver";
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String data=intent.getExtras().getString("data");
        Log.e("info","MyReceiver 接收到了消息"+data);
    }
}

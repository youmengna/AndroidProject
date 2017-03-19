package com.mn.youmengna0.fragmentdemo;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null)
        {
            getFragmentManager().beginTransaction().add(R.id.mainAty,new MyFragment1()).commit();
        }
    }
}

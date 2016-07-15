package com.example.xc.learncallback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyFragment myfragment=new MyFragment();
        getFragmentManager().beginTransaction().add(R.id.container,myfragment).commit();
        textView=(TextView)findViewById(R.id.tv);
        Callback callback=new Callback() {
            @Override
            public void changeData(String s) {
                textView.setText(s);
            }
        };
        myfragment.setCallback(callback);
    }

    public interface Callback{
         void changeData(String s);
    }
}

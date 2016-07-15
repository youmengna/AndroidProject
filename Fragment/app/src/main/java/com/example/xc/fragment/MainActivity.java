package com.example.xc.fragment;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        if(savedInstanceState==null)
        {
            MyFragment myFragment = new MyFragment();
            control cont=new control(){

                @Override
                public void settext(String str) {
                    tv.setText(str);
                }
            };
            myFragment.setControl(cont);
            getFragmentManager().beginTransaction().add(R.id.activity, myFragment).commit();
        }


    }
    public interface control{
        public void settext(String str);
    }
}

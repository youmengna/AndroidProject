package com.mn.youmengna0.radiobtn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        radioButton1= (RadioButton) findViewById(R.id.female);
        radioButton2= (RadioButton) findViewById(R.id.male);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(radioButton1.getId()==checkedId){
                    Log.e("info","女");
                }if(radioButton2.getId()==checkedId){
                    Log.e("info","男");
                }
            }
        });
    }
}

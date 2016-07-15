package com.example.xc.learnlinerlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class LinerLayoutAty extends AppCompatActivity {

    private LinearLayout root;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root=new LinearLayout(this);
        setContentView(root);
        button=new Button(this);
        button.setText("I am a girl");
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        root.addView(button,lp);
    }
}

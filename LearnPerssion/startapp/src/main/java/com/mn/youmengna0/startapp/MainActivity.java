package com.mn.youmengna0.startapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startMyAty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startMyAty = (Button) findViewById(R.id.startAty);
        startMyAty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.mn.youmengna0.learnperssion.intent.action.MyAty");
                startActivity(intent);
            }
        });
    }

}

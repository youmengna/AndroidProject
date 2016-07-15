package com.mn.youmengna0.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ShowMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);
        Intent i=getIntent();
        String name=i.getExtras().getString("name");
        TextView textView=(TextView) findViewById(R.id.showMessage);
        textView.setText(name);
        Toast.makeText(ShowMessage.this,"成功显示",Toast.LENGTH_SHORT).show();
    }
}

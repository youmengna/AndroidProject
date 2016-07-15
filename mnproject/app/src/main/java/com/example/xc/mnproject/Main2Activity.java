package com.example.xc.mnproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e("B", "B onCreate" );
        Intent i=getIntent();
//        User user= (User) i.getSerializableExtra("uesr");
//       TextView text2=(TextView) findViewById(R.id.text2);
//        text2.setText(i.getStringExtra("data"));
//        Bundle bundle=i.getExtras();
//        text2.setText(String.format("AS=%s,DF=%d",bundle.getString("AS"),bundle.getInt("DF")));
//        text2.setText(String.format("name=%s,age=%d",user.getName(),user.getAge()));
        final EditText editText= (EditText) findViewById(R.id.editview);
        Button button= (Button) findViewById(R.id.backbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent();
                a.putExtra("data",editText.getText().toString());
               setResult(1,a);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("B", "B onStart" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("B", "B onRestart" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("B", "B onResume" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("B", "B onPause" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("B", "B onStop" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("B", "B onDestroy" );
    }
}

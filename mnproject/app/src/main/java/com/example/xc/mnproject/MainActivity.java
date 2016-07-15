package com.example.xc.mnproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("A", "A onCreate" );
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,Main2Activity.class);
//                i.putExtra("data","I am a girl");
//                Bundle a=new Bundle();
//                a.putString("AS","aaaaaaaa");
//                a.putInt("DF",12);
//                i.putExtras(a);
//                User user=new User("you",22);
//                i.putExtra("uesr",user);
//                startActivity(i);
                startActivityForResult(i,0);
                 }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView textView= (TextView) findViewById(R.id.textView);
        if(requestCode==resultCode)
            textView.setText(data.getStringExtra("data"));

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("A", "A onStart" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("A", "A onRestart" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("A", "A onResume" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("A", "A onPause" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("A", "A onStop" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("A", "A onDestroy" );
    }
}

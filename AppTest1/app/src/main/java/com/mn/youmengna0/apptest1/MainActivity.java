package com.mn.youmengna0.apptest1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.saveBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.main1);
                EditText editText=(EditText)findViewById(R.id.editText1);
                ((APP)getApplicationContext()).setShare(editText.getText().toString());
                String share = ((APP) getApplicationContext()).getShare().toString();
                textView.setText("共享数据为"+share);
            }
        });


    }
}

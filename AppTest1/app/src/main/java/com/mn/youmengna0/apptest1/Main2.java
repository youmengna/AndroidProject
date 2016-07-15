package com.mn.youmengna0.apptest1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.saveBtn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=(TextView)findViewById(R.id.main2);
                EditText editText=(EditText)findViewById(R.id.editText2);
                String share=editText.getText().toString();
                ((APP)(getApplicationContext())).setShare(share);
                textView.setText("Main2:"+share);
            }
        });
    }
}

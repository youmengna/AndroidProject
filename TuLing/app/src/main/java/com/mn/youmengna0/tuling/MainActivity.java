package com.mn.youmengna0.tuling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HttpGetDataListener, View.OnClickListener {

    private HttpData httpData;
    private List<ListData> list;
    private EditText editText;
    private Button button;
    private ListView listView;
    private String info;
    private String [] welcome;
    private TextAdapter textAdapter;
    private double currentTime,oldTime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void getDataUrl(String data) {
        Log.e("info",data);
        paseText(data);
    }
    public void initView(){
        listView= (ListView) findViewById(R.id.listview);
        editText= (EditText) findViewById(R.id.sendEdit);
        button= (Button) findViewById(R.id.sendBtn);
        button.setOnClickListener(this);
        list=new ArrayList<ListData>();
        textAdapter=new TextAdapter(list,this);
        Log.e("info","textAdapter");
        listView.setAdapter(textAdapter);
        Log.e("info","textAdapter11");
        ListData listData;
        listData=new ListData(getRandomTips(),ListData.RECEIVE,getTime());
        list.add(listData);
    }
    public void paseText(String str){
        try {
            JSONObject jb=new JSONObject(str);
            ListData listData;
            listData=new ListData(jb.getString("text"),ListData.RECEIVE,getTime());
            list.add(listData);
            textAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        getTime();
        info=editText.getText().toString();
        editText.setText("");
        ListData listData;
        listData=new ListData(info,ListData.SEND,getTime());
        list.add(listData);
        textAdapter.notifyDataSetChanged();
        httpData= (HttpData) new HttpData("http://www.tuling123.com/openapi/api?key=74b0da792ff1b3326faa48b17cab36a2&&info="+info,this).execute();
    }
    public String getRandomTips(){
        String welcometip;
        welcome=this.getResources().getStringArray(R.array.welcome_tips);
        int index= (int) (Math.random()*(welcome.length-1));
        welcometip=welcome[index];
        return welcometip;
    }
    public String getTime(){
        currentTime=System.currentTimeMillis();
        SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curData=new Date();
        String str=simple.format(curData);
        if(currentTime-oldTime>5*60*1000){
            oldTime=currentTime;
            return str;
        }
        else {
            return "";
        }
    }
}

package com.mn.youmengna0.listviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listView);
        list=getData();
        MyAdapter myAdapter=new MyAdapter(this);
        listView.setAdapter(myAdapter);
    }


    public List<String> getData(){
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        return list;
    }

    public class MyAdapter extends BaseAdapter{
        private LayoutInflater inflater;
        private Context context;
        private MyAdapter(Context context){
            inflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public String getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView=inflater.inflate(R.layout.listview_layout,null);
            }else {
                TextView titletext=(TextView)convertView.findViewById(R.id.titleText);
                titletext.setText(list.get(position));
            }
            return convertView;
        }
    }
}

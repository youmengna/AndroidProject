package com.mn.youmengna0.tuling;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by youmengna0 on 2016/7/13.
 */
public class TextAdapter extends BaseAdapter{
    private List<ListData> list;
    private Context context;
    private RelativeLayout layout;
    TextAdapter(List<ListData> list,Context context){
        this.list=list;
        this.context=context;
    }

    //
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        if(list.get(position).getFlag()==ListData.RECEIVE){
            Log.e("info","TextAdapter left");
           layout= (RelativeLayout) inflater.inflate(R.layout.leftitem,null);
        }
        if(list.get(position).getFlag()==ListData.SEND){
            layout= (RelativeLayout) inflater.inflate(R.layout.rightitem,null);
            Log.e("info","TextAdapter rightitem");
        }
        TextView tv= (TextView) layout.findViewById(R.id.tv);
        TextView time= (TextView) layout.findViewById(R.id.time);
        tv.setText(list.get(position).getContent());
        time.setText(list.get(position).getTime());
        return layout;
    }
}

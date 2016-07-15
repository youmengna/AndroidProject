package com.mn.youmengna0.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by youmengna0 on 2016/7/14.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    public MyAdapter(Context context){
        this.context=context;
    }

    public Context getContext() {
        return context;
    }

    private ListData[] data = new ListData[]{
            new ListData("title1", "评估", R.drawable.aa),
            new ListData("title2", "橡胶", R.drawable.bb),
            new ListData("title3", "安卓", R.drawable.cc)
    };
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public ListData getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder= new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView= (LinearLayout) inflater.inflate(R.layout.listview_layout,null);
            viewHolder.title= (TextView) convertView.findViewById(R.id.titleTv);
            viewHolder.content= (TextView) convertView.findViewById(R.id.contentTv);
            viewHolder.imageView=(ImageView)convertView.findViewById(R.id.myimage);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }


        viewHolder.title.setText(getItem(position).getTitle());
        viewHolder.content.setText(getItem(position).getContent());
        viewHolder.imageView.setImageResource(getItem(position).getImageId());
        return convertView;
            /*TextView tv;
            if(convertView!=null){
                tv= (TextView) convertView;
            }else {
                tv=new TextView(MainActivity.this);
            }
            tv.setText(getItem(position));
            return tv;*/
    }
}

package com.example.xc.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by XC on 2016/7/9.
 */
public class MyFragment extends Fragment{

    private MainActivity.control control;
    Button btn;
public  static  MainActivity ttt;
    @Nullable
    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.myfragment,container,false);

        btn = (Button) root.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.settext("123");
//                ttt.tv.setText("");
            }
        });
        return root;
        }

    public void setControl(MainActivity.control control) {
        this.control = control;
    }

    public void setControl(MainActivity mainActivity) {
        ttt=mainActivity;
    }
}

package com.example.xc.learncallback;

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
public class MyFragment extends Fragment {
    private Button button;
    private MainActivity.Callback callback;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.myfragment,container,false);
        button=(Button)root.findViewById(R.id.changeBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.changeData("123");
            }
        });
        return root;
    }

    public void setCallback(MainActivity.Callback callback) {
        this.callback = callback;
    }
}

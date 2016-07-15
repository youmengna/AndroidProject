package com.mn.youmengna0.apptest1;

import android.app.Application;

/**
 * Created by youmengna0 on 2016/7/6.
 */
public class APP extends Application {
    private String share = "share";

    public void setShare(String share) {
        this.share = share;
    }

    public String getShare() {
        return share;
    }
}

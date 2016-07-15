package com.mn.youmengna0.baseadapter;

/**
 * Created by youmengna0 on 2016/7/14.
 */
public class ListData {


    private String title;
    private String content;
    private int imageId;
    public ListData(String title,String content,int imageId){
        this.title=title;
        this.content=content;
        this.imageId=imageId;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}

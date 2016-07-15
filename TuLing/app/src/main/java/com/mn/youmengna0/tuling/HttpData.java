package com.mn.youmengna0.tuling;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by youmengna0 on 2016/7/12.
 */
public class HttpData extends AsyncTask<String,Void,String>{
    private HttpClient httpClient;
    private HttpGet httpGet;
    private HttpResponse httpResponse;
    private HttpEntity httpEntity;
    private InputStream is;
    private HttpGetDataListener listener;
    private String url;
    public HttpData(String url,HttpGetDataListener listener){
        this.url=url;
        this.listener=listener;
    }
    @Override
    protected String doInBackground(String... params) {
        httpClient=new DefaultHttpClient();
        httpGet=new HttpGet(url);
        try {

            httpResponse=httpClient.execute(httpGet);
            httpEntity=httpResponse.getEntity();
            is=httpEntity.getContent();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String line=null;
            StringBuilder sb=new StringBuilder();
            while((line=br.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        listener.getDataUrl(s);
        super.onPostExecute(s);
    }
}

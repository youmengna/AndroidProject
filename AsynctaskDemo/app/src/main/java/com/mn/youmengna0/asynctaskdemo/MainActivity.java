package com.mn.youmengna0.asynctaskdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.showBtn);
        textView = (TextView) findViewById(R.id.showTv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadURL("http://fanyi.youdao.com/openapi.do");
            }
        });
    }

    public void ReadURL(String url) {
        new AsyncTask<String,Void,String>(){
            @Override
            protected String doInBackground(String... params) {
                try {
                    URL url=new URL(params[0]);
                    HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestMethod("POST");
                    OutputStream os = urlConnection.getOutputStream();
                    OutputStreamWriter osw=new OutputStreamWriter(os);
                    BufferedWriter bw=new BufferedWriter(osw);
                    bw.write("keyfrom=HttpGetDemoByMn&key=563582089&type=data&doctype=json&version=1.1&q=good");
                    bw.flush();

                    InputStream inputStream=urlConnection.getInputStream();
                    InputStreamReader isr=new InputStreamReader(inputStream,"utf-8");
                    BufferedReader br=new BufferedReader(isr);
                    String line;
                    StringBuilder sb=new StringBuilder();
                    while((line=br.readLine())!=null){
                        sb.append(line);
                    }
                    br.close();
                    isr.close();
                    return sb.toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(String s) {
                textView.setText(s);
                super.onPostExecute(s);
            }
        }.execute(url);

    }
}

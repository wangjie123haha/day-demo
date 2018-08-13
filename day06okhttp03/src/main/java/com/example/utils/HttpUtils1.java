package com.example.utils;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lenovo on 2018/8/12.
 */

public class HttpUtils1  {

  private static HttpUtils1 httpUtils1;
  private getjsondata getjsondata;
    //单例
   public static HttpUtils1 getinstance(){
       if(httpUtils1 ==null){
           httpUtils1  =new HttpUtils1();
       }
       return  httpUtils1;
   }

    //执行方法
    public  void  getdata(String url){
        Myasync myasync = new Myasync();
        myasync.execute(url);

    }
    //继承async
    public  class  Myasync extends AsyncTask<String,Integer,String> {
        @Override
        protected String doInBackground(String... params) {
            String path=params[0];
            try {
                URL url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestMethod("GET");
                if(connection.getResponseCode()==200){
                    InputStream inputStream = connection.getInputStream();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] bytes = new byte[1024];
                    int len =0;
                    while ((len=inputStream.read(bytes))!=-1){
                        bos.write(bytes,0,len);
                    }
                    inputStream.close();
                    bos.close();
                    String s = bos.toString();
                    return  s;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            getjsondata.getshuju(s);
        }
    }
    //创建一个接口
    public  interface  getjsondata{
        //创建一个方法
        void  getshuju(String json);
    }
    //向外提供接口
    public  void  setjsondata(getjsondata getjsondata){
        this.getjsondata =getjsondata;
    }
}

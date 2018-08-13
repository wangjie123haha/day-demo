package com.example.utils;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by lenovo on 2018/8/12.
 */

public class HttpUtils {

    private static HttpUtils httpUtils;
    private OkHttpClient okHttpClient;
    private  HttpUtils(){
         if(okHttpClient==null){
             okHttpClient = new OkHttpClient();
         }
    }
    //单例
    public  static  HttpUtils getinstance(){
        if(httpUtils==null){
            synchronized (HttpUtils.class){
                if(httpUtils==null){
                    httpUtils = new HttpUtils();
                }

            }
        }
        return  httpUtils;
    }

    //post请求
    public  void  postdata(String path, FormBody formBody, Callback callback){
        Request request = new Request.Builder().method("POST", formBody).url(path).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    //get请求
    public  void  getdata(String path2,Callback callback){
        Request request = new Request.Builder().url(path2).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }

}

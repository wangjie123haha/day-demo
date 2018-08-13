package com.example.day06okhttp03.di;

import com.example.bean.news;
import com.example.utils.HttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/8/12.
 */

public class moudlimp implements icontract.imoudle {
    private String path ="https://www.zhaoapi.cn/user/reg" ;
    private  String path1="https://www.zhaoapi.cn/user/login ";
    private String path2="http://www.xieast.com/api/news/news.php?page=";
    @Override
    public void requestdata(String name, String pwd, final oncalllisten oncalllisten) {
        if(name.equals("")||pwd.equals("")){
         oncalllisten.responsemsg("用户名或者密码不能为空");
         return;
        }
        FormBody formBody = new FormBody.Builder()
                .add("msg","")
                .add("code","")
                .build();
        //网络请求
        HttpUtils httpUtils = HttpUtils.getinstance();
        httpUtils.postdata(path, formBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                oncalllisten.responsemsg(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String msg = response.body().string();
                oncalllisten.responsemsg("注册成功");
            }
        });

    }

    @Override
    public void requestdatadl(String sname, String spwd, final oncalllisten oncalllisten) {
        if(sname.equals("")||spwd.equals("")){
            oncalllisten.responsemsg("输入的账号密码不能为空");
            return;
        }
        HttpUtils httpUtils = HttpUtils.getinstance();
        FormBody formBody = new FormBody.Builder()
                .add("msg","")
                .add("code","")
                .build();
        httpUtils.postdata(path1, formBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                oncalllisten.responsemsg(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responsemsg = response.body().string();
                oncalllisten.responsemsg("登录成功");
            }
        });

    }



}

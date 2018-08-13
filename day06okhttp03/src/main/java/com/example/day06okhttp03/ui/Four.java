package com.example.day06okhttp03.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.example.adapter.myadapter;
import com.example.bean.news;
import com.example.day06okhttp03.R;
import com.example.utils.HttpUtils1;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import view.XListView;

public class Four extends AppCompatActivity {

    private XListView xlist_view;
    private int page = 1;
    private String path = "http://www.xieast.com/api/news/news.php?page=";
    private myadapter myadapter;
    private List<news.DataBean> list =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        xlist_view = findViewById(R.id.xlist_view);
        getfromid();
        getfromnet();
    }

    private void getfromid() {
        //初始化
        xlist_view = findViewById(R.id.xlist_view);
        xlist_view.setPullRefreshEnable(true);
        xlist_view.setPullLoadEnable(true);
        xlist_view.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                page = 1;
                getfromnet();

            }

            @Override
            public void onLoadMore() {
                page += 1;
                getfromnet();
            }
        });
        //创建适配器
        myadapter = new myadapter(Four.this, list);
        xlist_view.setAdapter(myadapter);
        //点击跳转
       xlist_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(Four.this, Five.class);
               startActivity(intent);
               finish();
           }
       });
    }

    private void getfromnet() {
        String url = path + page;
        //接口回调
        HttpUtils1 httpUtils1 = HttpUtils1.getinstance();
        httpUtils1.getdata(url);
        httpUtils1.setjsondata(new HttpUtils1.getjsondata() {
            @Override
            public void getshuju(String json) {
                //gson解析
                Gson gson = new Gson();
                news news = gson.fromJson(json, news.class);
                List<com.example.bean.news.DataBean> data = news.getData();
                if (page == 1) {
                    //清除
                    list.clear();
                }
                //添加
                list.addAll(data);
                //刷新适配器
                myadapter.notifyDataSetChanged();
                //判断
                if (page == 1) {
                    xlist_view.stopRefresh();
                } else {
                    xlist_view.stopLoadMore();
                }
            }
        });

    }
}
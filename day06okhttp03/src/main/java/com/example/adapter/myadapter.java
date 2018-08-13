package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bean.news;
import com.example.day06okhttp03.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by lenovo on 2018/8/12.
 */

public class myadapter  extends BaseAdapter{
    private Context context;
    private List<com.example.bean.news.DataBean> list;

    public myadapter(Context context, List<news.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        viewholder h =null;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.include1, null);
            h =new viewholder();
            h.title1 = convertView.findViewById(R.id.title1);
            h.img01 = convertView.findViewById(R.id.img01);
            convertView.setTag(h);
        }else {
             h = (viewholder) convertView.getTag();
        }
        h.title1.setText(list.get(i).getTitle());
        ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),h.img01);
        return convertView;
    }
    public  class  viewholder{
        TextView title1;
        ImageView img01;
    }
}

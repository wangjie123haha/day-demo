package com.example.day06okhttp03.di;

/**
 * Created by lenovo on 2018/8/12.
 */

public interface icontract {
    /**
     * iview层
     */
    public  interface  iview{
       void   showdata(String message);
    }
    /**
     * ipresenetr
     */
    public  interface  ipresenter<iview>{

        //关联
        void  attachview(iview iview);
        //解绑
        void  detachview(iview iview);
        //创建请求方法
        void  requestinfo(String name, String pwd);
        //创建一个登录的方法
        void  requestdl(String name, String pwd);


    }
    /**
     * imoudle
     */
    public  interface  imoudle{
        //回调
        public   interface  oncalllisten{
            void responsemsg(String message);
        }
        //实现方法
        void  requestdata(String name, String pwd, oncalllisten oncalllisten);
        //登录方法
        void  requestdatadl(String name, String pwd, oncalllisten oncalllisten);

    }
}

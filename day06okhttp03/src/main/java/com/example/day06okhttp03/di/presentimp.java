package com.example.day06okhttp03.di;

import java.lang.ref.WeakReference;

/**
 * Created by lenovo on 2018/8/12.
 */

public class presentimp implements icontract.ipresenter<icontract.iview> {

   private icontract.iview  iview;
    private WeakReference<icontract.iview> weakReference;
    private moudlimp moudlimp;
    private WeakReference<icontract.imoudle> weakReference1;

    @Override
    public void attachview(icontract.iview iview) {
        this.iview =iview;
        //创建弱引用
        moudlimp = new moudlimp();
        weakReference = new WeakReference<icontract.iview>(iview);
        weakReference1 = new WeakReference<icontract.imoudle>(moudlimp);
    }

    @Override
    public void detachview(icontract.iview iview) {
        weakReference.clear();
        weakReference1.clear();
    }

    @Override
    public void requestinfo(String name, String pwd) {
        moudlimp.requestdata(name,pwd,new icontract.imoudle.oncalllisten() {
            @Override
            public void responsemsg(String message) {
                 iview.showdata(message);
            }
        });
    }

    @Override
    public void requestdl(String sname, String spwd) {
         moudlimp.requestdatadl(sname,spwd,new icontract.imoudle.oncalllisten() {
             @Override
             public void responsemsg(String message) {
                 iview.showdata(message);
             }
         });
    }


}

package com.example.app;

import android.app.Application;

import com.bwei.imageloaderlibrary.utils.ImageLoaderUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by lenovo on 2018/8/12.
 */

public class imageloader extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration = ImageLoaderUtils.getConfiguration(this);
        ImageLoader.getInstance().init(configuration);
    }
}

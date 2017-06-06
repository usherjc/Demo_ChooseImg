package com.usher.demo_imgchoose.main;

import android.app.Application;
import android.graphics.Bitmap;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * Created by UsherChen on 2017/4/12.
 * Details MainApplication
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFresco();
    }

    /**
     * 初始化Fresco
     * 使用ImagePipelineConfig的原因是为了支持不同格式图片的压缩
     */
    private void initFresco() {
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(this, config);
    }

}

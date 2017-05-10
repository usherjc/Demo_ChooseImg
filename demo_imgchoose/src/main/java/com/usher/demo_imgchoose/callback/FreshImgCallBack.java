package com.usher.demo_imgchoose.callback;

/**
 * Created by UsherChen on 2017/4/12.
 * Details 用于对适配器进行刷新
 */

public interface FreshImgCallBack {

    void previewImg(int position);//用于预览图片

    void updateGvImgShow(int position);//用于刷新GridView

    void openGallery();//用于打开相册

}

package com.usher.demo_imgchoose.callback;

/**
 * Created by Administrator on 2017/4/12.
 */

public interface FreshImgCallBack {

    void previewImg(int position);//用于预览图片

    void updateGvImgShow(int position);//用于刷新GridView

    void openGallery();//用于打开相册

}

package com.usher.demo_imgchoose.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.usher.demo_imgchoose.R;
import com.usher.demo_imgchoose.adapter.ImgGridAdapter;
import com.usher.demo_imgchoose.callback.FreshImgCallBack;
import com.yanzhenjie.album.Album;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements FreshImgCallBack {

    private static final int REQUEST_CODE_GALLERY = 100;//打开相册
    private static final int REQUEST_CODE_PREVIEW = 101;//预览图片

    private GridView gvImage;
    private ImgGridAdapter adapter;
    private ArrayList<String> imgList = new ArrayList<>();
    private final static int maxImgSize = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gvImage = (GridView) findViewById(R.id.gvImage);
        adapter = new ImgGridAdapter(this, imgList, maxImgSize);
        adapter.setImgShowFresh(this);//实现刷新接口
        gvImage.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_GALLERY:
                if (resultCode == RESULT_OK) {
                    imgList.clear();//不可直接指向
                    for (int i = Album.parseResult(data).size() - 1; i >= 0; i--) {
                        imgList.add(Album.parseResult(data).get(i));//控制图片顺序
                    }
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }

    //更新图片：当前用于删除
    @Override
    public void updateGvImgShow(int position) {
        imgList.remove(position);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openGallery() {
        Album.album(this)//打开相册
                .requestCode(REQUEST_CODE_GALLERY)
                .toolBarColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .statusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
                .selectCount(maxImgSize)
                .columnCount(3)
                .camera(true)
                .start();
    }

    @Override
    public void previewImg(int position) {
        Album.gallery(this)//预览图片
                .requestCode(REQUEST_CODE_PREVIEW)
                .toolBarColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .statusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
                .currentPosition(position)
                .checkFunction(false)
                .start();
    }

}

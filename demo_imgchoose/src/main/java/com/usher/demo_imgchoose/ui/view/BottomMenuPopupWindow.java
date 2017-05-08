package com.usher.demo_imgchoose.ui.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.usher.demo_imgchoose.R;
import com.usher.demo_imgchoose.callback.PopupWindowCallBack;

/**
 * Created by Administrator on 2017/4/13.
 */

public class BottomMenuPopupWindow extends PopupWindow {

    private View rootView;
    private TextView tvMenu1, tvMenu2, tvMenu3;

    public BottomMenuPopupWindow(Context context, final PopupWindowCallBack callBack) {
        super(context);

        rootView = LayoutInflater.from(context).inflate(R.layout.popupwindow_bottom_menu, null);
        tvMenu1 = (TextView) rootView.findViewById(R.id.tvMenu1);
        tvMenu2 = (TextView) rootView.findViewById(R.id.tvMenu2);
        tvMenu3 = (TextView) rootView.findViewById(R.id.tvMenu3);

        //btn1
        tvMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.item1Opera();
                dismiss();
            }
        });
        //btn2
        tvMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.item2Opera();
                dismiss();
            }
        });
        //btn3
        tvMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.item3Opera();
                dismiss();
            }
        });

        //初始化PopupWindow属性
        this.setContentView(rootView);                            //设置PopupWindow的View
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);       //设置PopupWindow弹出窗体的宽
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);      //设置PopupWindow弹出窗体的高
        this.setFocusable(true);                                  //设置PopupWindow弹出窗体可点击
        this.setAnimationStyle(R.style.Animation);                //设置SelectPicPopupWindow弹出窗体动画效果
        this.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.black_transparent)));//实例化一个ColorDrawable颜色为半透明遮盖层
    }

    public void setTvMenu1Text(String string) {
        if (tvMenu1 != null)
            tvMenu1.setText(string);
    }

    public void setTvMenu2Text(String string) {
        if (tvMenu2 != null)
            tvMenu2.setText(string);
    }

    public void setTvMenu3Text(String string) {
        if (tvMenu3 != null)
            tvMenu3.setText(string);
    }

}

package com.yobo.studying_view.lsn11_palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.yobo.studying_view.R;

/**
 * Created by YoBo on 2018/5/11.
 * 1
 */

public class J_Palette_Activity extends AppCompatActivity {


    private TextView tv_content;
    private TextView tv_content0;
    private TextView tv_content1;
    private TextView tv_content2;
    private TextView tv_content3;
    private TextView tv_content4;
    private TextView tv_content5;
    private TextView tv_content6;


    private ImageView iv_pic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.j_palette_activity);

        initView();


        BitmapDrawable drawable = (BitmapDrawable) iv_pic.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int color = palette.getMutedColor(Color.BLUE);   //柔和
                //鲜艳
                int color0 = palette.getVibrantColor(Color.BLUE);
                //暗、柔和
                int color1 = palette.getDarkMutedColor(Color.BLUE);
                int color2 = palette.getDominantColor(Color.BLUE);
                //暗，鲜艳
                int color3 = palette.getDarkVibrantColor(Color.BLUE);
                //亮、柔和
                int color4 = palette.getLightMutedColor(Color.BLUE);
                //亮、鲜艳
                int color5 = palette.getLightVibrantColor(Color.BLUE);
                //获取谷歌推荐的主题色调rgb
                Palette.Swatch swatch = palette.getVibrantSwatch();
                if (swatch != null) {
                    int titleColor = swatch.getTitleTextColor();
                    int bodyColor = swatch.getBodyTextColor();
                    int bgColor = swatch.getRgb();
                    tv_content3.setBackgroundColor(getTranslucentColor(0.6f, bgColor));
                    tv_content3.setTextColor(bodyColor);
                }
                tv_content.setBackgroundColor(color);
                tv_content0.setBackgroundColor(color0);
                tv_content1.setBackgroundColor(color1);
                tv_content2.setBackgroundColor(color2);
                tv_content4.setBackgroundColor(color4);
                tv_content5.setBackgroundColor(color5);
            }
        });
    }


    //将颜色半透明化
    private int getTranslucentColor(float percent, int rgb) {
        int blue = rgb & 0xff;//方式二 int blue=Color.blue(rgb);
        int green = rgb >> 8 & 0xff;
        int red = rgb >> 16 & 0xff;
        int alpha = rgb >>> 24;
        float alpha1 = alpha * percent;
        return Color.argb((int) alpha1, red, green, blue);
    }

    private void initView() {
        tv_content = (TextView) findViewById(R.id.j_content);
        tv_content0 = (TextView) findViewById(R.id.j_content0);
        tv_content1 = (TextView) findViewById(R.id.j_content1);
        tv_content2 = (TextView) findViewById(R.id.j_content2);
        tv_content3 = (TextView) findViewById(R.id.j_content3);
        tv_content4 = (TextView) findViewById(R.id.j_content4);
        tv_content5 = (TextView) findViewById(R.id.j_content5);
        iv_pic = (ImageView) findViewById(R.id.j_pic);
    }


}

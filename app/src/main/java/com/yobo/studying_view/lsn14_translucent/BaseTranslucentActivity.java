package com.yobo.studying_view.lsn14_translucent;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;

/**
 * 沉浸式布局封装类
 */

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class BaseTranslucentActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//如果是4.4-5.0的版本之间，就将状态栏和底部导航栏设置为透明颜色
		if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT
				&& Build.VERSION.SDK_INT< Build.VERSION_CODES.LOLLIPOP){
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}
	}

	/**
	 *
	 * @param toolbar
	 * @param bottomNavigationBar //设置一个高度只有0.1dp位于窗口底部的View ，
	 *                               然后在底部导航栏设置为透明时，将自己的高度设置为底部导航栏的高度
	 *                            将自身的颜色当做底部导航栏的背景色
	 * @param translucentPrimaryColor
	 */
	@SuppressLint("NewApi")
	public void setOrChangeTranslucentColor(Toolbar toolbar,View bottomNavigationBar, int translucentPrimaryColor){
		//在4.4-5.0之间需要根据状态栏和底部导航栏的高度来重新调整内容View的高度和大小
		if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT
				&& Build.VERSION.SDK_INT< Build.VERSION_CODES.LOLLIPOP){
			if(toolbar!=null){
				//1.获取状态栏的高度，设置toolbar的高度为状态栏和自身高度的和
//				LayoutParams params = toolbar.getLayoutParams();
//				int statusBarHeight = getStatusBarHeight(this);
//				params.height += statusBarHeight ;
//				toolbar.setLayoutParams(params );
				//2.将toolbar的paddingTop设置为状态栏的高度
				toolbar.setPadding(
						toolbar.getPaddingLeft(),
						toolbar.getPaddingTop()+getStatusBarHeight(this), 
						toolbar.getPaddingRight(),
						toolbar.getPaddingBottom());
				//设置toolbar的背景颜色
				toolbar.setBackgroundColor(translucentPrimaryColor);
			}
			if(bottomNavigationBar!=null){
				//如果有底部导航栏，
				if(hasNavigationBarShow(getWindowManager())){
					LayoutParams p = bottomNavigationBar.getLayoutParams();
					p.height += getNavigationBarHeight(this);
					bottomNavigationBar.setLayoutParams(p);
					bottomNavigationBar.setBackgroundColor(translucentPrimaryColor);
				}
			}
		}else if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
			getWindow().setNavigationBarColor(translucentPrimaryColor);
			getWindow().setStatusBarColor(translucentPrimaryColor);
		}else{
			//<4.4不做处理
		}
	}
	

	private int getNavigationBarHeight(Context context) {
		return getSystemComponentDimen(this, "navigation_bar_height");
	}

	/**
	 * @param context
	 * @return
	 */
	private int getStatusBarHeight(Context context) {
		// 反射获取到状态栏的高度android.R.dimen.status_bar_height.
		return getSystemComponentDimen(this, "status_bar_height");
	}
	
	private static int getSystemComponentDimen(Context context, String dimenName){
		// 反射获取到ࣺandroid.R.dimen.status_bar_height.
		int statusHeight = -1;
		try {
			Class<?> clazz = Class.forName("com.android.internal.R$dimen");
			Object object = clazz.newInstance();
			String heightStr = clazz.getField(dimenName).get(object).toString();
			int height = Integer.parseInt(heightStr);
			//dp--->px
			statusHeight = context.getResources().getDimensionPixelSize(height);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusHeight;
	}
	
	private static boolean hasNavigationBarShow(WindowManager wm){

		Display display = wm.getDefaultDisplay();
		DisplayMetrics outMetrics = new DisplayMetrics();
		display.getRealMetrics(outMetrics);//获取整个屏幕的大小
		int heightPixels = outMetrics.heightPixels;
		int widthPixels = outMetrics.widthPixels;


		outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);//获取内容View的大小
		int heightPixels2 = outMetrics.heightPixels;
		int widthPixels2 = outMetrics.widthPixels;
		int w = widthPixels-widthPixels2;
		int h = heightPixels-heightPixels2;
		System.out.println("~~~~~~~~~~~~~~~~h:"+h);
		return  w>0||h>0;//判断宽高，是有横竖屏的情况
	}
	
}

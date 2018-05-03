package com.yobo.studying_view.lsn08_snackbar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yobo.studying_view.R;

/**
 * Created by YoBo on 2018/4/30.
 * snackBar
 */

public class F_SnackBar_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f_snack_activity);

    }


    public void showToast(View v) {

        showMyToast("你好啊，自定义Toast");

    }

    /**
     */
    public void showSnack(View v) {
        //     * Snackbar.LENGTH_INDEFINITE :无限期
        Snackbar snackbar = Snackbar.make(v, "是否喜欢我?", Snackbar.LENGTH_INDEFINITE);
        snackbar.addCallback(new Snackbar.Callback() {
            @Override
            public void onShown(Snackbar sb) {
                super.onShown(sb);
                showMyToast("SnackBar显示出来了");
            }
            @Override
            public void onDismissed(Snackbar transientBottomBar, int event) {
                super.onDismissed(transientBottomBar, event);
                showMyToast("SnackBar要隐藏了");
            }
        });
        //添加按钮
        snackbar.setAction("Yes", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMyToast("我喜欢你！");
            }
        });
        snackbar.show();

    }

    //利用Toast.makeText中的源码，实现自定义Toast
    private void showMyToast(String msg) {
        Toast result = new Toast(this);
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.f_toast_my, null);
        TextView content = view.findViewById(R.id.f_toast_content);
        content.setText(msg);

        result.setView(view);
        result.setDuration(Toast.LENGTH_SHORT);
        result.show();

    }


}

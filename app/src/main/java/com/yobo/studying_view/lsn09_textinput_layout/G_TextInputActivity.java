package com.yobo.studying_view.lsn09_textinput_layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import com.yobo.studying_view.R;

/**
 * Created by YoBo on 2018/5/3.
 * 1
 */

public class G_TextInputActivity extends AppCompatActivity implements TextWatcher {

    TextInputLayout textInputLayout;
    TextInputEditText et_1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g_textinput_activity);
        textInputLayout = (TextInputLayout) findViewById(R.id.g_input_layout);
        et_1 = (TextInputEditText) textInputLayout.getEditText();
        if (et_1 != null) {
            et_1.addTextChangedListener(this);
        }

    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable.toString().length() > 6) {
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("请输入小于六位数的账号！");
        } else {
            textInputLayout.setErrorEnabled(false);

        }

    }
}

package com.rajesh.loadingproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * 用于第三方唤醒
 *
 * @author zhufeng on 2018/2/23
 */
public class ThirdUseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void buttonClick1(View view) {
        Toast.makeText(getApplicationContext(), "点击1", Toast.LENGTH_SHORT).show();
    }
}

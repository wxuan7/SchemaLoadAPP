package com.rajesh.loadingproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

/**
 * desc
 *
 * @author zhufeng on 2018/2/23
 */
public class SplashActivity extends AppCompatActivity {
    private JumpHandler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler = new JumpHandler(this);
        mHandler.sendEmptyMessageDelayed(0, 2000);
    }

    private void jumpToMainActivity() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

    private static class JumpHandler extends Handler {
        private final WeakReference<SplashActivity> mActivity;

        public JumpHandler(SplashActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (mActivity.get() == null) {
                return;
            }
            switch (msg.what) {
                case 0: {
                    mActivity.get().jumpToMainActivity();
                    break;
                }
                default:
                    break;
            }
        }
    }
}

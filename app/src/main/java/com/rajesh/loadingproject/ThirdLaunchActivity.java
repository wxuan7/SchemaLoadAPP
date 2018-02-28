package com.rajesh.loadingproject;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * 用于第三方唤醒
 *
 * @author zhufeng on 2018/2/23
 */
public class ThirdLaunchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        if (!isOtherUIExisting(getApplicationContext())) {
            startActivity(new Intent(ThirdLaunchActivity.this, SplashActivity.class));
        }
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /**
     * 判断是否有别的页面存在
     *
     * @param context
     * @return
     */
    private boolean isOtherUIExisting(Context context) {
        boolean existing = false;
        try {
            String currClassName = getClass().getName();
            String currPackageName = getPackageName();
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(10);
            if (list.size() <= 0) {
                existing = false;
            }
            for (ActivityManager.RunningTaskInfo info : list) {
                String activityName = info.baseActivity.getClassName();
                if (activityName.equals(currClassName)) {
                    continue;
                }
                if (info.baseActivity.getPackageName().equals(currPackageName)) {
                    existing = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            existing = false;
        }
        return existing;
    }
}

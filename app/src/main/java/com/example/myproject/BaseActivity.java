package com.example.myproject;

import android.support.v4.app.FragmentActivity;

import com.example.myproject.utils.ActivitysUtils;

/**
 * Created by wangbs on 16/5/12.
 */
public class BaseActivity extends FragmentActivity{
    public void addActivityTag(String activityTag, FragmentActivity activity){
        ActivitysUtils.getInstance().addActivity(activityTag, activity);
    }
    public void finishTagActivity(String activityTag, FragmentActivity activity){
        ActivitysUtils.getInstance().removeActivity(activityTag);
        activity.finish();
    }
}

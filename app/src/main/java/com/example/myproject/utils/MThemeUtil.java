package com.example.myproject.utils;

import android.app.Activity;

import com.example.myproject.R;


/**
 * Created by zkw on 16/3/24.
 */
public class MThemeUtil {

    public static void changeTheme(Activity activity, int theme) {
        switch (theme) {
            case 1:
                activity.setTheme(R.style.SetTheme1);
                break;
            case 2:
                activity.setTheme(R.style.SetTheme2);
                break;
            case 3:
                activity.setTheme(R.style.SetTheme3);
                break;
            case 4:
                activity.setTheme(R.style.SetTheme4);
                break;
            case 5:
                activity.setTheme(R.style.SetTheme5);
                break;
            case 6:
                activity.setTheme(R.style.SetTheme6);
                break;
            case 7:
                activity.setTheme(R.style.SetTheme7);
                break;
            default:
                activity.setTheme(R.style.SetTheme1);
                break;
        }
    }
}

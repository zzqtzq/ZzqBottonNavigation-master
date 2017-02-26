package com.zzq.zzqbottonnavigation_master.utils;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.zzq.zzqbottonnavigation_master.R;

public class StatusBarUtils {

    public static Context mContext;

    public static void noTificationBar2(final Context context) {
        mContext = context;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(
                (Activity) context);
        tintManager.setStatusBarTintEnabled(true);
        // 通知栏所需颜色
        tintManager.setStatusBarTintResource(R.color.tm);

    }

    public static void noTificationBar(final Context context) {
        mContext = context;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(
                (Activity) context);
        tintManager.setStatusBarTintEnabled(true);
        // 通知栏所需颜色
        tintManager.setStatusBarTintResource(R.color.colorAccent);

    }

    @TargetApi(19)
    private static void setTranslucentStatus(boolean on) {
        Window win = ((Activity) mContext).getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}

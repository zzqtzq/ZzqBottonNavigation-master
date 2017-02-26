package com.zzq.zzqbottonnavigation_master.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by 志强 on 2016.10.25.
 */
public class MyAlertDialogUtil {
    /**
     * @param mContext
     * @param title
     */
    public static void myAlertDialog(final Activity mContext, String title, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        dialog.setTitle(title);
        dialog.setMessage(message);
//        dialog.setCancelable(false);

        dialog.setPositiveButton("继续", null);
        dialog.setNegativeButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mContext.finish();
            }
        });
//        dialog.getButton(dialog.BUTTON_POSITIVE).setTextColor(neededColor);
        dialog.show();
    }
}

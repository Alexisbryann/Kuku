package com.alexis.kuku;

import android.content.Context;
import android.net.ConnectivityManager;
import android.view.View;

public class Utils {
    public static boolean checkAppConnectionStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public static void setLayoutInvisible(View viewName) {
        if (viewName.getVisibility() == View.VISIBLE) {
            viewName.setVisibility(View.GONE);
        }
    }
    public static void setLayoutVisible(View viewName) {
        if (viewName.getVisibility() == View.GONE ) {
            viewName.setVisibility(View.VISIBLE);
        }
    }
}

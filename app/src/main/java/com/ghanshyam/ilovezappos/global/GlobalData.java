package com.ghanshyam.ilovezappos.global;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

import com.ghanshyam.ilovezappos.R;

/**
 * Created by GHANSHYAM on 08-Feb-17.
 */

public class GlobalData
{
    static int globalCartSize=0;
    static Context context;
    static TextView cartBadge;
    static boolean responseOkay=false;

    public static  boolean isResponseOkay() {
        return responseOkay;
    }

    public static void setResponseOkay(boolean responseOkay) {
        GlobalData.responseOkay = responseOkay;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        GlobalData.context = context;
    }

    public  static int getGlobalCartSize() {
        return globalCartSize;
    }

    public   static TextView getCartBadge() {
        return cartBadge;
    }

    public static void setGlobalCartSize(int globalCartSize) {
        GlobalData.globalCartSize = globalCartSize;
    }

    public static void setCartBadge(TextView cartBadge) {
        GlobalData.cartBadge = cartBadge;
    }
    public  static void updateCart()
    {
        globalCartSize++;
        cartBadge= (TextView) ((Activity)context).findViewById(R.id.actionbar_notifcation_textview);
        cartBadge.setText(globalCartSize+"");
    }
}

package com.djcanadastudio.demo_android.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by desenguo on 2016-04-16.
 */
public class Navigator {
    public static void navigate(final Context from, final Class<?> to) {
        Intent newIntent = new Intent(from, to);
        from.startActivity(newIntent);
        ((Activity)from).finish();
    }
    public static void navigate(final Context from, Intent newIntent) {
        from.startActivity(newIntent);
        ((Activity)from).finish();
    }
}

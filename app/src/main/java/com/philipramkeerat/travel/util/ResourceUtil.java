package com.philipramkeerat.travel.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable returnDrawable(Context context, String drawableInText) {
        Resources resources = context.getResources();
        int idOfDrawable = resources.getIdentifier(drawableInText
                , DRAWABLE, context.getPackageName());
        return resources.getDrawable(idOfDrawable);
    }
}

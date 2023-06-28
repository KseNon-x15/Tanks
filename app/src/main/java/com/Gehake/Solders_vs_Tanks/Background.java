package com.Gehake.Solders_vs_Tanks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {

    int x = 0, y = 0;
    Bitmap background;

    Background (int screenX, int screenY, Resources res) {
        if(ShopActivity.bg==1) {
            background = BitmapFactory.decodeResource(res, R.drawable.background);
        }
        if(ShopActivity.bg==2) {
            background = BitmapFactory.decodeResource(res, R.drawable.background2);
        }
        if(ShopActivity.bg==3) {
            background = BitmapFactory.decodeResource(res, R.drawable.background3);
        }
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);

    }

}

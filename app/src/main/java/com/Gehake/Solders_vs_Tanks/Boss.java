package com.Gehake.Solders_vs_Tanks;

import static com.Gehake.Solders_vs_Tanks.GameView.screenRatioX;
import static com.Gehake.Solders_vs_Tanks.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Boss {

    public int speed = 5;
    public boolean wasShot = true;
    int x = 0, y, width, height, bossCounter = 1;
    Bitmap boss1;

    Boss(Resources res) {

        boss1 = BitmapFactory.decodeResource(res, R.drawable.soldier);


        width = boss1.getWidth();
        height = boss1.getHeight();

        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        boss1 = Bitmap.createScaledBitmap(boss1, width, height, false);


        y = -height;
    }

    Bitmap getBoss () {

        if (bossCounter == 1) {
            bossCounter++;
            return boss1;
        }


        bossCounter = 1;

        return boss1;
    }

    Rect getCollisionShape () {
        return new Rect(x, y, x + width, y + height);
    }

}



package com.Gehake.Solders_vs_Tanks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.Gehake.Solders_vs_Tanks.GameView.screenRatioX;
import static com.Gehake.Solders_vs_Tanks.GameView.screenRatioY;
import static com.Gehake.Solders_vs_Tanks.GameView.startTime;

public class Soldier {

    public int speed = 20;
    public boolean wasShot = true;
    int x = 0, y, width, height, solderCounter = 1;
    Bitmap soldier1, soldier2;

    Soldier(Resources res) {

        soldier1 = BitmapFactory.decodeResource(res, R.drawable.soldier);
        soldier2 = BitmapFactory.decodeResource(res, R.drawable.soldier2);

        width = soldier1.getWidth();
        height = soldier1.getHeight();

        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        soldier1 = Bitmap.createScaledBitmap(soldier1, width, height, false);
        soldier2 = Bitmap.createScaledBitmap(soldier2, width, height, false);

        y = -height;
    }
    Timer timer = new Timer();
    Bitmap getSolder () {
        long time = System.currentTimeMillis() - startTime;
        long time2 = time / 1000;


        if (solderCounter == 1) {
            if (timer.hasSecondPassed()) {
                solderCounter++;
            }
            return soldier1;
        }

        if (solderCounter == 2) {
            if (timer.hasSecondPassed()) {
                solderCounter++;
            }
            return soldier2;
        }

        solderCounter = 1;

        return soldier1;
    }

    Rect getCollisionShape () {
        return new Rect(x, y, x + width, y + height);
    }

}

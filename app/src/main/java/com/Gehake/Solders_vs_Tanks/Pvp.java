package com.Gehake.Solders_vs_Tanks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.Gehake.Solders_vs_Tanks.GameView.screenRatioX;
import static com.Gehake.Solders_vs_Tanks.GameView.screenRatioY;

public class Pvp {

    int toShoot = 0;
    boolean isGoingUp = false;
    int x, y, width, height, wingCounter = 0, shootCounter = 1;
    Bitmap tank1, shoot1, dead;
    private GameView gameView;

    Pvp(GameView gameView, int screenY, Resources res) {

        this.gameView = gameView;

        if(ShopActivity2.skin==1) {
            tank1 = BitmapFactory.decodeResource(res, R.drawable.tank1);
        }
        if(ShopActivity2.skin==2) {
            tank1 = BitmapFactory.decodeResource(res, R.drawable.tank2);
        }
        if(ShopActivity2.skin==3) {
            tank1 = BitmapFactory.decodeResource(res, R.drawable.tank3);
        }
        if(ShopActivity2.skin==4) {
            tank1 = BitmapFactory.decodeResource(res, R.drawable.tank4);
        }

        width = tank1.getWidth();
        height = tank1.getHeight();

        width /= 4;
        height /= 4;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        tank1 = Bitmap.createScaledBitmap(tank1, width, height, false);


        shoot1 = tank1;


        shoot1 = Bitmap.createScaledBitmap(shoot1, width, height, false);


        dead = BitmapFactory.decodeResource(res, R.drawable.dead);
        dead = Bitmap.createScaledBitmap(dead, width, height + 60, false);

        y = screenY / 2;
        x = (int) (64 * screenRatioX);

    }

    Bitmap getFlight () {

        if (toShoot != 0) {

            if (shootCounter == 1) {
                shootCounter++;
                return shoot1;
            }


            shootCounter = 1;
            toShoot--;
            gameView.newBullet();

            return shoot1;
        }

        if (wingCounter == 0) {
            wingCounter++;
            return tank1;
        }
        wingCounter--;

        return tank1;
    }

    Rect getCollisionShape () {
        return new Rect(x, y, x + width, y + height);
    }

    Bitmap getDead () {
        return dead;
    }

}

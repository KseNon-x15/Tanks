package com.Gehake.Solders_vs_Tanks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.view.SurfaceView;

public class ShopView  extends SurfaceView  implements Runnable{
    private Background background1;
    private int screenX, screenY;
    private Paint paint;
    public static float screenRatioX, screenRatioY;
    private Thread thread;
    private ShopActivity activity;
    private SharedPreferences prefs;



    public ShopView(ShopActivity activity, int screenX, int screenY) {
        super(activity);
        this.activity = activity;

        prefs = activity.getSharedPreferences("game", Context.MODE_PRIVATE);

        background1 = new Background(screenX, screenY, getResources());
        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;
        background1.x = (int) screenRatioX;
        paint = new Paint();
        paint.setTextSize(48);
        paint.setColor(Color.WHITE);
    }




    @Override
    public void run() {
        draw ();
        sleep ();
        update ();
    }


    private void update () {
        background1.x = (int) screenRatioX;
        if (background1.x + background1.background.getWidth() < 0) {
            background1.x = screenX;
        }
    }
    private void draw () {

        if (getHolder().getSurface().isValid()) {

            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
            canvas.drawText("Shop", 10, 50, paint);

//            getHolder().unlockCanvasAndPost(canvas);
        }
    }



    public void resume () {

        thread = new Thread(this);
        thread.start();
    }



    private void sleep () {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public void pause () {

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

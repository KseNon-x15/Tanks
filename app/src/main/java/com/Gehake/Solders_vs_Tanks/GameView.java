package com.Gehake.Solders_vs_Tanks;

import static com.Gehake.Solders_vs_Tanks.MainActivity.gamePlay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying, isGameOver = false;
    private int screenX, screenY, score = 0;
    public static int hp = 10;
    public static int bossHp = 3;
    public static float screenRatioX, screenRatioY;
    private Paint paint;
    public static long startTime = System.currentTimeMillis();
    private Soldier[] soldiers;
    private Boss[] bosses;
    private SharedPreferences prefs;
    private Random random;
    private SoundPool soundPool;
    private List<Bullet> bullets;
    private int sound, sound2;
    private Pvp flight;
    private GameActivity activity;
    private Background background1, background2;

    public GameView(GameActivity activity, int screenX, int screenY) {
        super(activity);

        this.activity = activity;

        prefs = activity.getSharedPreferences("game", Context.MODE_PRIVATE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .build();

        } else
            soundPool = new SoundPool(60, AudioManager.STREAM_MUSIC, 0);

        sound = soundPool.load(activity, R.raw.shoot, 1);
        sound2 = soundPool.load(activity, R.raw.song, 1);

        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        background1 = new Background(screenX, screenY, getResources());
        background2 = new Background(screenX, screenY, getResources());

        flight = new Pvp(this, screenY, getResources());

        bullets = new ArrayList<>();


        background2.x = screenX;

        paint = new Paint();
        paint.setTextSize(48);
        paint.setColor(Color.WHITE);

        soldiers = new Soldier[3];
        bosses = new Boss[1];
        if(gamePlay==3) {
            for (int i = 0; i < 1; i++) {
                Boss boss = new Boss(getResources());
                bosses[i] = boss;
            }
        }
        if(gamePlay==1 || gamePlay==2) {
            for (int i = 0; i < 3; i++) {
                Soldier soldier = new Soldier(getResources());
                soldiers[i] = soldier;
            }
        }

        random = new Random();

    }

    @Override
    public void run() {

        while (isPlaying) {

            update ();
            draw ();
            sleep ();

        }

    }

    private void update () {
        if (gamePlay == 2){
            hp=10;
        }


//        background1.x -= 10 * screenRatioX;
//        background2.x -= 10 * screenRatioX;
        background1.x = (int) screenRatioX;
        background2.x = (int) screenRatioX;


        if (background1.x + background1.background.getWidth() < 0) {
            background1.x = screenX;
        }

        if (background2.x + background2.background.getWidth() < 0) {
            background2.x = screenX;
        }

        if (flight.isGoingUp)
            flight.y -= 30 * screenRatioY;
        else
            flight.y += 30 * screenRatioY;

        if (flight.y < 0)
            flight.y = 0;

        if (flight.y >= screenY - flight.height)
            flight.y = screenY - flight.height;

        List<Bullet> trash = new ArrayList<>();

        for (Bullet bullet : trash)
            bullets.remove(bullet);

        for (Bullet bullet : bullets) {

            if (bullet.x > screenX)
                trash.add(bullet);

            bullet.x += 50 * screenRatioX;
            if(gamePlay==1 || gamePlay==2) {
                for (Soldier soldier : soldiers) {

                    if (Rect.intersects(soldier.getCollisionShape(),
                            bullet.getCollisionShape())) {

                        score++;
                        soldier.x = -500;
                        bullet.x = screenX + 500;
                        soldier.wasShot = true;

                    }

                }
            }
            if (gamePlay == 3) {
                for (Boss boss : bosses) {

                    if (Rect.intersects(boss.getCollisionShape(),
                            bullet.getCollisionShape())) {

                        bossHp--;
                        score++;
                        bullet.x = screenX + 500;
                        if (bossHp <= 0) {
                            boss.x = -500;
                            bossHp = 5;
                            boss.wasShot = true;
                        }

                    }

                }
            }
        }


        if(gamePlay==1 || gamePlay==2) {
            for (Soldier soldier : soldiers) {

                soldier.x -= soldier.speed;

                if (soldier.x + soldier.width < 0) {

                    if (!soldier.wasShot) {
                        hp--;
                        if (hp <= 0) {
                            hp = 0;
                            isGameOver = true;
                            return;
                        }
                    }

                    int bound = (int) (30 * screenRatioX);
                    soldier.speed = random.nextInt(bound);

                    if (soldier.speed < 10 * screenRatioX) {
                        soldier.speed = (int) (10 * screenRatioX);
                    }

                    soldier.x = screenX;
                    soldier.y = random.nextInt(screenY - soldier.height);

                    soldier.wasShot = false;
                }

                if (Rect.intersects(soldier.getCollisionShape(), flight.getCollisionShape())) {

                    hp--;
                    if (gamePlay == 2){
                        score--;
                    }
                    score++;
                    soldier.x = -500;
                    soldier.wasShot = true;
                    if (hp <= 0) {
                        hp = 0;
                        isGameOver = true;
                        return;
                    }


                }

            }
        }
        if(gamePlay==3) {
            for (Boss boss : bosses) {

                boss.x -= boss.speed;

                if (boss.x + boss.width < 0) {


                    if (!boss.wasShot) {
                        hp--;
                        hp--;
                        if (hp <= 0) {
                            hp = 0;
                            isGameOver = true;
                            return;
                        }

                    }

                    int bound = (int) (30 * screenRatioX);
                    boss.speed = random.nextInt(bound);

                    if (boss.speed < 10 * screenRatioX) {
                        boss.speed = (int) (10 * screenRatioX);
                    }

                    boss.x = screenX;
                    boss.y = random.nextInt(screenY - boss.height);

                    boss.wasShot = false;
                }

                if (Rect.intersects(boss.getCollisionShape(), flight.getCollisionShape())) {

                    hp--;
                    hp--;
                    score++;
                    boss.x = -500;
                    boss.wasShot = true;
                    if (hp <= 0) {
                        hp = 0;
                        isGameOver = true;
                        return;
                    }


                }

            }
        }

    }

    private void draw () {

        if (getHolder().getSurface().isValid()) {

            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
            canvas.drawBitmap(background2.background, background2.x, background2.y, paint);


            if (gamePlay == 1 || gamePlay == 2) {
                for (Soldier soldier : soldiers) {
                    canvas.drawBitmap(soldier.getSolder(), soldier.x, soldier.y, paint);
                }
            }
            if (gamePlay == 3) {
                for (Boss boss : bosses) {
                    canvas.drawBitmap(boss.getBoss(), boss.x, boss.y, paint);
                }
            }

            canvas.drawText("Счёт: " + score + "      Жизни: " + hp, 10, 50, paint);
//            StringBuilder builder = new StringBuilder();
            long time = System.currentTimeMillis() - startTime;
//            builder.append("Time: ").append(time);
            long time2 = time / 1000;
            int timeall = 60;
            if (gamePlay==2) {
                canvas.drawText("Время: " + (timeall - time2) + " сек", 10, 100, paint);
            } else {
//                canvas.drawText("Время: " + time2 + " сек", 10, 100, paint);
            }
            if (gamePlay == 2 && time2 == 60) {
                isPlaying = false;
                canvas.drawBitmap(flight.getDead(), flight.x, flight.y, paint);
                getHolder().unlockCanvasAndPost(canvas);
                saveIfHighScore();
                waitBeforeExiting();
                hp = 10;
                startTime = System.currentTimeMillis();
                bossHp = 3;
                isGameOver = true;
                return;
            }

            if (isGameOver) {
                isPlaying = false;
                canvas.drawBitmap(flight.getDead(), flight.x, flight.y, paint);
                getHolder().unlockCanvasAndPost(canvas);
                saveIfHighScore();
                waitBeforeExiting();
                hp = 10;
                startTime = System.currentTimeMillis();
                bossHp = 3;
                return;
            }

            canvas.drawBitmap(flight.getFlight(), flight.x, flight.y, paint);

            for (Bullet bullet : bullets)
                canvas.drawBitmap(bullet.bullet, bullet.x, bullet.y, paint);

            getHolder().unlockCanvasAndPost(canvas);


        }

    }

    private void waitBeforeExiting() {
//        if (!prefs.getBoolean("isMute", false)) {
//            soundPool.play(sound2, 1, 1, 0, 0, 1);
//        }
        try {
            Thread.sleep(3000);

            activity.startActivity(new Intent(activity, MainActivity.class));
            activity.finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void saveIfHighScore() {

        if (prefs.getInt("highscore", 0) < score) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("highscore", score);
            editor.apply();
        }

    }

    private void sleep () {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume () {

        isPlaying = true;
        thread = new Thread(this);
        if (!prefs.getBoolean("isMute", false)) {
            soundPool.play(sound2, 1, 1, 0, 0, 1);
        }
        thread.start();

    }

    public void pause () {

        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < screenX / 2) {
                    flight.isGoingUp = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                flight.isGoingUp = false;
                if (event.getX() > screenX / 2)
                    flight.toShoot++;
                break;
        }

        return true;
    }

    public void newBullet() {

        if (!prefs.getBoolean("isMute", false)) {
            soundPool.play(sound, 1, 1, 0, 0, 1);
        }

        Bullet bullet = new Bullet(getResources());
        bullet.x = flight.x + flight.width;
        bullet.y = flight.y + (flight.height / 2);
        bullets.add(bullet);

    }
}

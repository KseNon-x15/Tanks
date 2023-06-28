package com.Gehake.Solders_vs_Tanks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static boolean isMute;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView4;
    ImageView imageView5;
    ImageView rank1;
    ImageView rank2;
    ImageView rank3;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    ImageView imageView7;
    ImageView button5;
    ImageView button6;
    ImageView button7;
    Button buttonBg1;
    Button buttonBg2;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    String[] names = new String[] {"Обычный", "На время", "Бой с босом"};
    public static int gamePlay = 1;



    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences prefs = getSharedPreferences("game", MODE_PRIVATE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.bg1);
        imageView2 = findViewById(R.id.bg2);
        imageView4 = findViewById(R.id.shop);
        imageView5 = findViewById(R.id.bg3);
        rank1 = findViewById(R.id.rank1);
        rank2 = findViewById(R.id.rank2);
        rank3 = findViewById(R.id.rank3);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button1q);
        button6 = findViewById(R.id.button2q);
        button7 = findViewById(R.id.button3q);
        buttonBg1 = findViewById(R.id.button1bg);
        buttonBg2 = findViewById(R.id.button2bg);
        textView1 = findViewById(R.id.exit);
        textView2 = findViewById(R.id.play);
        textView3 = findViewById(R.id.shopT);
        textView4 = findViewById(R.id.r30);
        textView5 = findViewById(R.id.r70);
        textView6 = findViewById(R.id.skin);
        imageView7 = findViewById(R.id.shopI);
        //////////////////////
        buttonBg1.setVisibility(View.GONE);
        buttonBg2.setVisibility(View.GONE);
        textView1.setVisibility(View.GONE);
        button5.setVisibility(View.VISIBLE);
        button6.setVisibility(View.VISIBLE);
        button7.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        textView3.setVisibility(View.VISIBLE);
        textView4.setVisibility(View.GONE);
        textView5.setVisibility(View.GONE);
        textView6.setVisibility(View.GONE);
        imageView7.setVisibility(View.VISIBLE);
        button4.setVisibility(View.GONE);
        ///////////////////////////
        findViewById(R.id.shopT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShopActivity.class));
            }
        });

        if(ShopActivity.bg==1){
            imageView.setVisibility(View.GONE);
            imageView2.setVisibility(View.VISIBLE);
            imageView5.setVisibility(View.GONE);
        }
        if(ShopActivity.bg==2){
            imageView2.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
            imageView5.setVisibility(View.GONE);
        }
        if(ShopActivity.bg==3){
            imageView2.setVisibility(View.GONE);
            imageView.setVisibility(View.GONE);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(prefs.getInt("highscore", 0) >= 100 && prefs.getInt("highscore", 0) < 200){
            rank1.setVisibility(View.VISIBLE);
        } else {
            rank1.setVisibility(View.GONE);
        }
        if(prefs.getInt("highscore", 0) >= 200 && prefs.getInt("highscore", 0) < 300){
            rank2.setVisibility(View.VISIBLE);
        } else {
            rank2.setVisibility(View.GONE);
        }
        if(prefs.getInt("highscore", 0) >= 300){
            rank3.setVisibility(View.VISIBLE);
        } else {
            rank3.setVisibility(View.GONE);
        }
        findViewById(R.id.button1bg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.GONE);
                imageView2.setVisibility(View.VISIBLE);
                imageView5.setVisibility(View.GONE);
                ShopActivity.bg=1;
            }
        });
        findViewById(R.id.button2bg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                imageView5.setVisibility(View.GONE);
                ShopActivity.bg=2;
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.setVisibility(View.GONE);
                imageView.setVisibility(View.GONE);
                imageView5.setVisibility(View.VISIBLE);
                ShopActivity.bg=3;
            }
        });
        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamePlay=1;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    button1.setBackground(getResources().getDrawable(R.drawable.test7));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    button2.setBackground(getResources().getDrawable(R.drawable.test));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    button3.setBackground(getResources().getDrawable(R.drawable.test));
                }
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamePlay=2;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    button1.setBackground(getResources().getDrawable(R.drawable.test));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    button2.setBackground(getResources().getDrawable(R.drawable.test7));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    button3.setBackground(getResources().getDrawable(R.drawable.test));
                }
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamePlay=3;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    button1.setBackground(getResources().getDrawable(R.drawable.test));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    button2.setBackground(getResources().getDrawable(R.drawable.test));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    button3.setBackground(getResources().getDrawable(R.drawable.test7));
                }
            }
        });

        if(gamePlay==1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                button1.setBackground(getResources().getDrawable(R.drawable.test7));
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                button1.setBackground(getResources().getDrawable(R.drawable.test));
            }
        }
        if(gamePlay==2) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                button2.setBackground(getResources().getDrawable(R.drawable.test7));
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                button2.setBackground(getResources().getDrawable(R.drawable.test));
            }
        }
        if(gamePlay==3) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                button3.setBackground(getResources().getDrawable(R.drawable.test7));
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                button3.setBackground(getResources().getDrawable(R.drawable.test));
            }
        }


        TextView highScoreTxt = findViewById(R.id.highScoreTxt);
        Log.d("MYMYMY", String.valueOf(gamePlay));

        highScoreTxt.setText("Рекорд: " + prefs.getInt("highscore", 0));

        isMute = prefs.getBoolean("isMute", false);

        final ImageView volumeCtrl = findViewById(R.id.volumeCtrl);

        if (isMute)
            volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
        else
            volumeCtrl.setImageResource(R.drawable.ic_volume_up_black_24dp);

        volumeCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isMute = !isMute;
                if (isMute)
                    volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
                else
                    volumeCtrl.setImageResource(R.drawable.ic_volume_up_black_24dp);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute", isMute);
                editor.apply();

            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();

        TextView textView = findViewById(R.id.play);

        Animation start = AnimationUtils.loadAnimation(this, R.anim.anim);

        textView.startAnimation(start);

    }

}

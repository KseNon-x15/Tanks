package com.Gehake.Solders_vs_Tanks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShopActivity2 extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView5;


    ImageView skinn1;
    ImageView skinn2;
    ImageView skinn3;
    ImageView skinn4;
    TextView textView1;
    public static int skin = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences prefs = getSharedPreferences("game", MODE_PRIVATE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_shop);



        imageView = findViewById(R.id.bg1q);
        imageView2 = findViewById(R.id.bg2q);
        imageView5 = findViewById(R.id.bg3q);
        textView1 = findViewById(R.id.exitq);

        skinn1 = findViewById(R.id.skin1);
        skinn2 = findViewById(R.id.skin2);
        skinn3 = findViewById(R.id.skin3);
        skinn4 = findViewById(R.id.skin4);


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


        findViewById(R.id.skin1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skin=1;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn1.setBackground(getResources().getDrawable(R.drawable.test6));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn2.setBackground(getResources().getDrawable(R.drawable.test4));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn3.setBackground(getResources().getDrawable(R.drawable.test4));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn4.setBackground(getResources().getDrawable(R.drawable.test4));
                }
            }
        });
        findViewById(R.id.skin2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skin=2;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn1.setBackground(getResources().getDrawable(R.drawable.test4));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn2.setBackground(getResources().getDrawable(R.drawable.test6));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn3.setBackground(getResources().getDrawable(R.drawable.test4));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn4.setBackground(getResources().getDrawable(R.drawable.test4));
                }
            }
        });
        findViewById(R.id.skin3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skin=3;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn1.setBackground(getResources().getDrawable(R.drawable.test4));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn2.setBackground(getResources().getDrawable(R.drawable.test4));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn3.setBackground(getResources().getDrawable(R.drawable.test6));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn4.setBackground(getResources().getDrawable(R.drawable.test4));
                }
            }
        });
        findViewById(R.id.skin4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skin=4;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn1.setBackground(getResources().getDrawable(R.drawable.test4));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn2.setBackground(getResources().getDrawable(R.drawable.test4));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn3.setBackground(getResources().getDrawable(R.drawable.test4));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    skinn4.setBackground(getResources().getDrawable(R.drawable.test6));
                }
            }
        });




        if(skin==1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                skinn1.setBackground(getResources().getDrawable(R.drawable.test6));
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                skinn1.setBackground(getResources().getDrawable(R.drawable.test4));
            }
        }
        if(skin==2) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                skinn2.setBackground(getResources().getDrawable(R.drawable.test6));
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                skinn2.setBackground(getResources().getDrawable(R.drawable.test4));
            }
        }
        if(skin==3) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                skinn3.setBackground(getResources().getDrawable(R.drawable.test6));
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                skinn4.setBackground(getResources().getDrawable(R.drawable.test4));
            }
        }
        if(skin==4) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                skinn4.setBackground(getResources().getDrawable(R.drawable.test6));
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                skinn4.setBackground(getResources().getDrawable(R.drawable.test4));
            }
        }




        findViewById(R.id.exitq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopActivity2.this, MainActivity.class));
            }
        });
        TextView highScoreTxt = findViewById(R.id.highScoreTxtq);

        highScoreTxt.setText("Рекорд: " + prefs.getInt("highscore", 0));



    }
}

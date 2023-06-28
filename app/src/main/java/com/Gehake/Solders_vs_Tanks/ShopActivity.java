package com.Gehake.Solders_vs_Tanks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShopActivity extends AppCompatActivity {

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
    ImageView imageView7;
    ImageView button5;
    ImageView button6;
    ImageView button7;
    Button buttonBg3;
    Button buttonBg1;
    Button buttonBg2;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    public static int bg = 1;


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
        imageView5 = findViewById(R.id.bg3);
        imageView4 = findViewById(R.id.shop);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button5 = findViewById(R.id.button1q);
        button6 = findViewById(R.id.button2q);
        button7 = findViewById(R.id.button3q);
        buttonBg3 = findViewById(R.id.button4);
        buttonBg1 = findViewById(R.id.button1bg);
        buttonBg2 = findViewById(R.id.button2bg);
        textView1 = findViewById(R.id.exit);
        textView2 = findViewById(R.id.play);
        textView3 = findViewById(R.id.shopT);
        textView4 = findViewById(R.id.r30);
        textView5 = findViewById(R.id.r70);
        textView6 = findViewById(R.id.skin);
        rank1 = findViewById(R.id.rank1);
        rank2 = findViewById(R.id.rank2);
        rank3 = findViewById(R.id.rank3);
        imageView7 = findViewById(R.id.shopI);
        //////////////////////
        buttonBg1.setVisibility(View.VISIBLE);
        buttonBg2.setVisibility(View.VISIBLE);
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        button6.setVisibility(View.GONE);
        button7.setVisibility(View.GONE);
        textView1.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.GONE);
        textView3.setVisibility(View.GONE);
        imageView7.setVisibility(View.GONE);
        textView4.setVisibility(View.VISIBLE);
        textView5.setVisibility(View.VISIBLE);
        textView6.setVisibility(View.VISIBLE);
        ///////////////////////////

        if(prefs.getInt("highscore", 0) < 30){
            buttonBg2.setVisibility(View.GONE);
            textView4.setVisibility(View.VISIBLE);
        } else {
            buttonBg2.setVisibility(View.VISIBLE);
            textView4.setVisibility(View.GONE);
        }
        if(prefs.getInt("highscore", 0) < 70){
            buttonBg3.setVisibility(View.GONE);
            textView5.setVisibility(View.VISIBLE);
        } else {
            buttonBg3.setVisibility(View.VISIBLE);
            textView5.setVisibility(View.GONE);
        }

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
        if(prefs.getInt("highscore", 0) >= 50 && prefs.getInt("highscore", 0) < 100){
            rank1.setVisibility(View.VISIBLE);
        } else {
            rank1.setVisibility(View.GONE);
        }
        if(prefs.getInt("highscore", 0) >= 100 && prefs.getInt("highscore", 0) < 150){
            rank2.setVisibility(View.VISIBLE);
        } else {
            rank2.setVisibility(View.GONE);
        }
        if(prefs.getInt("highscore", 0) >= 150){
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
                bg=1;
            }
        });
        findViewById(R.id.button2bg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                imageView5.setVisibility(View.GONE);
                bg=2;
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.setVisibility(View.GONE);
                imageView.setVisibility(View.GONE);
                imageView5.setVisibility(View.VISIBLE);
                bg=3;
            }
        });
        findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopActivity.this, MainActivity.class));
            }
        });
        findViewById(R.id.skin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopActivity.this, ShopActivity2.class));
            }
        });
        TextView highScoreTxt = findViewById(R.id.highScoreTxt);


        highScoreTxt.setText("Рекорд: " + prefs.getInt("highscore", 0));
        MainActivity.isMute = prefs.getBoolean("isMute", false);

        final ImageView volumeCtrl = findViewById(R.id.volumeCtrl);

        if (MainActivity.isMute)
            volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
        else
            volumeCtrl.setImageResource(R.drawable.ic_volume_up_black_24dp);

        volumeCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.isMute = !MainActivity.isMute;
                if (MainActivity.isMute)
                    volumeCtrl.setImageResource(R.drawable.ic_volume_off_black_24dp);
                else
                    volumeCtrl.setImageResource(R.drawable.ic_volume_up_black_24dp);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute", MainActivity.isMute);
                editor.apply();

            }
        });



    }
}

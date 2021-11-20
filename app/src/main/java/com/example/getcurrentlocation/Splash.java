package com.example.getcurrentlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Splash extends AppCompatActivity {

    ImageView top,bottom,pic,iv_beat;
    TextView text;
    CharSequence charSequence;
    int index;
    long delay=200;
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        top=findViewById(R.id.top);
        bottom=findViewById(R.id.bottom);
        pic=findViewById(R.id.pic);
        text=findViewById(R.id.textt);
        iv_beat=findViewById(R.id.iv_beat);

        // Set Full Screen

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Animation animation1= AnimationUtils.loadAnimation(this,R.anim.top_wave);
        top.setAnimation(animation1);

//        ObjectAnimator objectAnimator=ObjectAnimator.ofPropertyValuesHolder(pic,
//                PropertyValuesHolder.ofFloat("scaleX",1.2f),
//                PropertyValuesHolder.ofFloat("scaleY",1.2f));
//
//        objectAnimator.setDuration(500);
//        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        objectAnimator.start();

        animateText("FARMA....");
//        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/demoapp-ae96a.appspot.com/o/heart_beat.gif?alt=media&token=b21dddd8-782c-457c-babd-f2e922ba172b")
//             .asGif().diskCacheStrategy(DiskCacheStrategy.ALL).into(iv_beat);

        Animation animation2= AnimationUtils.loadAnimation(this,R.anim.bottom_wave);
        bottom.setAnimation(animation2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        }, 4100);


    }

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            text.setText(charSequence.subSequence(0,index++));
            if(index<=charSequence.length())
                handler.postDelayed(runnable,delay);
        }
    };

    public void animateText(CharSequence cs)
    {
        charSequence=cs;
        index=0;
        text.setText("");
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable,delay);
    }
}
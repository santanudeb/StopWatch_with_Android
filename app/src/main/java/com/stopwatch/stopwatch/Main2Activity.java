package com.stopwatch.stopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView icanchor;
    Animation rounding;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);
        icanchor = findViewById(R.id.icanchor);
        timer = findViewById(R.id.timer);

        //Optional Animation
        //btnstop.setAlpha(1);

        //Load Animation
        rounding = AnimationUtils.loadAnimation(this, R.anim.rounding);

        //stop
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                icanchor.clearAnimation();
                timer.stop();
            }
        });

        //start
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passing amimation
                icanchor.startAnimation(rounding);
                //btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                //btnstart.animate().alpha(0).setDuration(300).start();
                //Start Timer
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
         //

        });
    }
}

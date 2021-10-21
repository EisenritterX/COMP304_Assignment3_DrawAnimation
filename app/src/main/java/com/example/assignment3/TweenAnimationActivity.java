package com.example.assignment3;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TweenAnimationActivity extends AppCompatActivity {

    ImageView sun = null;
    ImageView earth = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tweenanimation);
        // Debug showing activiity
        Toast.makeText(this, "Task 3 Tween Animation Activity ", Toast.LENGTH_SHORT).show();

        //Set Buttons
        final Button StartButton = (Button) findViewById(R.id.TweenButtonStart);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTweenAnimation();
            }
        });

        final Button StopButton = (Button) findViewById(R.id.TweenButtonStop);
        StopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTweenAnimation();
            }
        });

        sun = (ImageView) findViewById((R.id.imgSun));
        earth = (ImageView) findViewById((R.id.imgEarth));
    }


    public void startTweenAnimation() {
        performAnimation(sun, R.anim.shakennotstirred);
        performAnimation(earth, R.anim.shakennotstirred);

    }

    private void performAnimation(ImageView imgView, int animationResourceID) {
        Animation an = AnimationUtils.loadAnimation(this, animationResourceID);
        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());
        // Start the animation
        imgView.startAnimation(an);
    }


    public void stopTweenAnimation() {
        sun.clearAnimation();
        earth.clearAnimation();
    }

    private void toggleButtons(boolean clickableState) {

        final Button StartButton = (Button) findViewById(R.id.TweenButtonStart);
        StartButton.setClickable(clickableState);

    }

    class MyAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            // Enable all buttons once animation is over
            toggleButtons(true);

        }

        public void onAnimationRepeat(Animation animation) {
            // what to do when animation loops
        }

        public void onAnimationStart(Animation animation) {
            // Disable all buttons while animation is running
            toggleButtons(false);

        }
    }
}

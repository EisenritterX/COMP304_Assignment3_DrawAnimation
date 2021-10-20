package com.example.assignment3;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FrameAnimationActivity extends AppCompatActivity {

    AnimationDrawable mframeAnimation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.frameanimation);
        // Debug showing activiity
        Toast.makeText(this, "Task 2 Frame Animation Activity ", Toast.LENGTH_SHORT).show();

        final Button onButton = (Button) findViewById(R.id.ButtonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.ButtonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });


    }

    private void startAnimation() {

        ImageView img = (ImageView) findViewById(R.id.ImageViewMyAnimation);

        List<BitmapDrawable> frames = new ArrayList<BitmapDrawable>();

        for (int i = 0; i < 29; i++) {
            int id = getResources().getIdentifier("frame_" + i, "drawable", getPackageName());
            BitmapDrawable frame = (BitmapDrawable) getResources().getDrawable(id);
            frames.add(frame);
            // your code here
        }


        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 6;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);    // loop continuously

        for (BitmapDrawable b : frames
        ) {
            mframeAnimation.addFrame(b, reasonableDuration);

        }

        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true, true);
        mframeAnimation.start();
    }

    private void stopAnimation() {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false, false);

    }
}

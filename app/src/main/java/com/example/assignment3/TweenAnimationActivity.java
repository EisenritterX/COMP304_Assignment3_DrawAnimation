package com.example.assignment3;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TweenAnimationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tweenanimation);
        // Debug showing activiity
        Toast.makeText(this, "Task 3 Tween Animation Activity ", Toast.LENGTH_SHORT).show();
    }
}

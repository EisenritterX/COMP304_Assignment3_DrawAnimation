package com.example.assignment3;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FrameAnimationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.frameanimation);
        // Debug showing activiity
        Toast.makeText(this, "Task 2 Frame Animation Activity ", Toast.LENGTH_SHORT).show();
    }
}

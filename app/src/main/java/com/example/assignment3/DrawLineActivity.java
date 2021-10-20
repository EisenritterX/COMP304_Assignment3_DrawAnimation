package com.example.assignment3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DrawLineActivity extends AppCompatActivity {
    private ImageView reusableImageView;
    //
    private int startx = 10;
    private int starty = 10;
    private int endx=10;
    private int endy=10;
    //
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;
    private Color color;
    private int StrokeWidth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.drawline);
        // Debug showing activiity
        Toast.makeText(this, "Task 1 DrawLine Activity ", Toast.LENGTH_SHORT).show();

        //
        //creating a bitmap as content view for the image
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        //set the background for your drawings
        canvas.drawColor(Color.BLACK); //background
        //setup the image view
        reusableImageView = (ImageView)findViewById(R.id.ImageViewForDrawing);
        //tell image view for the bitmap format/content
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);

        RadioGroup colorChoices = (RadioGroup) findViewById(R.id.radgColor);
        colorChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radRed = (RadioButton) findViewById(R.id.radRed);
            }
        });
    }

    public void clearCanvas(View v)
    {
        canvas.drawColor(Color.BLACK);
        startx = 10;
        starty = 10;
        endx = 10;
        endy = 10;
    }
}


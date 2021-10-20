package com.example.assignment3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DrawLineActivity extends AppCompatActivity {
    private ImageView reusableImageView;
    //
    private int startx = 10;
    private int starty = 10;
    private int endx = 10;
    private int endy = 10;
    //
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;
    private int color;
    private int strokeWidth;


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
        reusableImageView = (ImageView) findViewById(R.id.ImageViewForDrawing);
        //tell image view for the bitmap format/content
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);

        // Set Default Paint
        paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(30);

        //Spinner stroke size listener
        Spinner spinStroke = (Spinner) findViewById(R.id.spinLineSize);
        spinStroke.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Spinner spinStroke = (Spinner) findViewById(R.id.spinLineSize);
                strokeWidth = Integer.parseInt(parent.getItemAtPosition(position).toString());
                SetPaint();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Set Color Selection Radio Group Event Handler
        RadioGroup colorChoices = (RadioGroup) findViewById(R.id.radgColor);
        colorChoices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radRed = (RadioButton) findViewById(R.id.radRed);
                RadioButton radGreen = (RadioButton) findViewById(R.id.radGreen);
                RadioButton radYellow = (RadioButton) findViewById(R.id.radYellow);
                if (radRed.isChecked()) {
                    color = Color.RED;
                    SetPaint();
                } else if (radGreen.isChecked()) {
                    color = Color.GREEN;
                    SetPaint();
                } else if (radYellow.isChecked()) {
                    color = Color.YELLOW;
                    SetPaint();
                }
            }
        });

        startDrawing();

    }


    // Resets the canvas
    public void clearCanvas(View v) {
        canvas.drawColor(Color.WHITE);
        startx = 10;
        starty = 10;
        endx = 10;
        endy = 10;
    }

    // Set Paint
    public void SetPaint() {
        paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(strokeWidth);
    }

    // Initialize starting point
    public void startDrawing() {
        canvas.drawPoint(15, 15, paint);
    }

    public void drawLine(Canvas canvas) {
        //textView.setText(String.valueOf(endy));
        //canvas.drawLine(100,100,300,300,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx = endx;
        starty = endy;

    }

    //DPAD Emulator
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                //reusableImageView.setVisibility(View.VISIBLE);
                //reusableImageView.setFocusable(true);
                //reusableImageView.requestFocus();
                endy = endy + 5;
                drawLine(canvas);
                //moveRect(canvas);
                //reusableImageView.invalidate();

                return true;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx = endx + 5;
                drawLine(canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;
        }
        return false;
    }
}


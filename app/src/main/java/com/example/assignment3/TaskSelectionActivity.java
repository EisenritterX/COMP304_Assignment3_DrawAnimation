package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TaskSelectionActivity extends AppCompatActivity {

    ListView listTask;
    Class[] classes ={DrawLineActivity.class, FrameAnimationActivity.class,
            TweenAnimationActivity.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_main);
        listTask= (ListView) findViewById(R.id.listTaskSelection);

        // Attaching event listener onto list item
        listTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),classes[position]);
                startActivity(intent);
            }
        });
    }

}
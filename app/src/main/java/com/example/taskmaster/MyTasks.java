package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tasks);
        Intent myIntent = getIntent();
        ((TextView)findViewById(R.id.textView8)).setText(myIntent.getExtras().getString("task"));
    }


}

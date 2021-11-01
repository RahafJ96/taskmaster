package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tasks);

    }

    public void add(View view) {
        Intent intent=new Intent(MyTasks.this, AddTask.class);
        startActivity(intent);
    }

    public void all(View view) {
        Intent intent=new Intent(MyTasks.this,MainActivity.class);
        startActivity(intent);
    }
}

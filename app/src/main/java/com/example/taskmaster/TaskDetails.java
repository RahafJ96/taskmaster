package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class TaskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        TextView title = (TextView) findViewById(R.id.title);
        TextView bodies = (TextView) findViewById(R.id.text);
        TextView st = (TextView) findViewById(R.id.status);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String t = extras.getString("titles");
            String body = extras.getString("body");
            String status = extras.getString("status");


            if (status.equalsIgnoreCase("completed"))
                st.setTextColor(Color.GREEN);
            else if (status.equalsIgnoreCase("in progress"))
                st.setTextColor(Color.YELLOW);
            else if (status.equalsIgnoreCase("assigned"))
                st.setTextColor(Color.RED);
            else
                st.setTextColor(Color.CYAN);
            bodies.setText(body);
            st.setText(status);
            title.setText(t);
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                Intent i=new Intent(TaskDetails.this,AllTasks.class);
                startActivity(i);
                Toast.makeText(this,"Back button pressed!",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
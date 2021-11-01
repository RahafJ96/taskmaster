package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            String title = extras.getString("edit1");
//            String description = extras.getString("edit2");
//
//            TextView textView=(TextView)findViewById(R.id.text1);
//            textView.setText(title +"\n"+description);
//
//        }
//
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void toAddTask(View view) {
        Intent addIntent = new Intent(this , AddTask.class);
        startActivity(addIntent);
    }

    public void toAllTasks(View view) {
        Intent allIntent = new Intent(this , AllTasks.class);
        startActivity(allIntent);
    }

    public void toSettings(View view) {
        Intent settingsIntent = new Intent(this , Settings.class);
        startActivity(settingsIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView homeText = findViewById(R.id.textView);
        homeText.setText(sharedPreferences.getString("username" , "User's") + " Tasks");
    }

    public void onEat(View view) {
        Intent detailIntent = new Intent(this , MyTasks.class);
        detailIntent.putExtra("task" , "Eat task");
        startActivity(detailIntent);
    }

    public void onCode(View view) {
        Intent detailIntent = new Intent(this , MyTasks.class);
        detailIntent.putExtra("task" , "Code task");
        startActivity(detailIntent);
    }

    public void onSleep(View view) {
        Intent detailIntent = new Intent(this , MyTasks.class);
        detailIntent.putExtra("task" , "Sleep task");
        startActivity(detailIntent);
    }
}
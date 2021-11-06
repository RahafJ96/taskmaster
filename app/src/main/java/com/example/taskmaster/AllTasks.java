package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AllTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            String title = extras.getString("edit1");
//            String description = extras.getString("edit2");
//            TextView textView=(TextView)findViewById(R.id.text1);
//
//            textView.setText(title +"\n"+description);
//        }
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    protected void onResume() {

        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String title = prefs.getString("title","title");
        String desc = prefs.getString("description","description");
        String counter = prefs.getString("counter","total:0");
        int number=prefs.getInt("number",0);
        TextView textView=(TextView)findViewById(R.id.text1);
        TextView counterText=(TextView)findViewById(R.id.counter);
        textView.setText(title +"\n"+desc);
        counterText.setText(counter);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i=new Intent(AllTasks.this,MyTasks.class);
                startActivity(i);
                Toast.makeText(this,"Button pressed!",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void intentHelper(View view){
        Intent intent =new Intent(AllTasks.this,TaskDetails.class);

        Button b = (Button)view;
        String buttonText = b.getText().toString();
        System.out.println(buttonText);
        intent.putExtra("title",buttonText);
        startActivity(intent);
    }
    public void ctf(View view) {intentHelper(view);}

    public void code(View view) {intentHelper(view);}

    public void sleep(View view) {intentHelper(view);}
}
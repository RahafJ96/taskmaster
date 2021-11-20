package com.example.taskmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.*;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Taskmaster;
import com.amplifyframework.datastore.generated.model.Team;
import com.example.taskmaster.Database.TaskDatabase;
import com.example.taskmaster.Entity.TaskEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AllTasks extends AppCompatActivity {

    Handler handler;
    List<TaskEntity> allTasks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);
        MainActivity.sendAnalytic();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

//        if(name.split(".")[1].equals("png")){
//            ImageView imageView=(ImageView)findViewById(R.id.img);
//            imageView.setVisibility(View.VISIBLE);
//        }
//        else{
//            TextView textView=(TextView) findViewById(R.id.file);
//            textView.setVisibility(View.VISIBLE);
//        }
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                Intent i=new Intent(AllTasks.this,MyTasks.class);
                startActivity(i);
                Toast.makeText(this,"Back button pressed!",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();
        getTasks();

        RecyclerView recyclerView = findViewById(R.id.recTask);

        TaskAdapter newAdapter = new TaskAdapter( getApplicationContext(), (ArrayList<TaskEntity>) allTasks);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(newAdapter);

        handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                newAdapter.setTaskOGList(allTasks);
                Log.i("Async", allTasks.toString());
                recyclerView.getAdapter().notifyDataSetChanged();
                return false;
            }
        });

    }

    private void getTasks() {


        List<Taskmaster> listOfTasks = new ArrayList<>();

        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", 0);
        String settingsTeamID = sharedPreferences.getString("teamName",null);
        Log.i("TeamID", "Settings Team ID ===> " + settingsTeamID);

        if (settingsTeamID == null) {

            Amplify.API.query(
                    ModelQuery.list(Taskmaster.class),
                    response -> {
                        for (Taskmaster task : response.getData()) {
                            listOfTasks.add(task);
                        }
                        Collections.sort(listOfTasks, new Comparator<Taskmaster>() {
                            @Override
                            public int compare(Taskmaster task, Taskmaster t1) {
                                return Long.compare(task.getCreatedAt().toDate().getTime(), t1.getCreatedAt().toDate().getTime());
                            }
                        });

                        for (Taskmaster task : listOfTasks
                        ) {
                            allTasks.add(new TaskEntity(task.getTitle(), task.getBody(), task.getStatus().name(),task.getTeamId(),task.getS3ImageKey()));

                        }

                        handler.sendEmptyMessage(1);
                    },
                    error -> Log.e("MyAmplifyApp", "Query failure", error)
            );
        } else {
            Log.v("inside else =>",settingsTeamID);
            Amplify.API.query(
                    ModelQuery.list(Taskmaster.class, Taskmaster.TEAM_ID.contains(settingsTeamID)),
                    response -> {
                        for (Taskmaster task : response.getData()) {
                            listOfTasks.add(task);
                        }
                        Collections.sort(listOfTasks, new Comparator<Taskmaster>() {
                            @Override
                            public int compare(Taskmaster task, Taskmaster t1) {
                                return Long.compare(task.getCreatedAt().toDate().getTime(), t1.getCreatedAt().toDate().getTime());
                            }
                        });

                        for (Taskmaster task : listOfTasks
                        ) {
                            allTasks.add(new TaskEntity(task.getTitle(), task.getBody(), task.getStatus().name(),task.getTeamId(),task.getS3ImageKey()));
                        }

                        handler.sendEmptyMessage(1);
                    },
                    error -> Log.e("MyAmplifyApp", "Query failure", error)
            );


        }


    }
}
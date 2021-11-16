package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;

import com.amplifyframework.datastore.generated.model.Status;
import com.amplifyframework.datastore.generated.model.Taskmaster;

public class MyTasks extends AppCompatActivity {
    private static final String TAG ="MyTasks" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tasks);
        /**AWS stuff**/

        configureAmplify();
        /**end here**/
    }


    public void add(View view) {
        Intent intent=new Intent(MyTasks.this, AddTask.class);
        startActivity(intent);
    }
    /***AWS**/
    private void configureAmplify() {
        try {
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.configure(getApplicationContext());
            Log.i("Tutorial", "Initialized Amplify");
        } catch (AmplifyException failure) {
            Log.e("Tutorial", "Could not initialize Amplify", failure);
        }
        Amplify.DataStore.observe(Taskmaster.class,
                started -> Log.i("Tutorial", "Observation began."),
                change -> Log.i("Tutorial", change.item().toString()),
                failure -> Log.e("Tutorial", "Observation failed.", failure),
                () -> Log.i("Tutorial", "Observation complete.")
        );
    }
    /********/

    public void all(View view) {
        Intent intent=new Intent(MyTasks.this,AllTasks.class);
        startActivity(intent);
    }
    @Override
    protected void onResume() {

        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String user = prefs.getString("username","guest");
        String mail = prefs.getString("email",null);
        TextView username=(TextView)findViewById(R.id.username);
        TextView email=(TextView)findViewById(R.id.email);
        username.setText("Hello, "+user);
        email.setText(mail);
    }

    public void setting(View view) {
        Intent i=new Intent(MyTasks.this,Settings.class);
        startActivity(i);

    }
}
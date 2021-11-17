package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Team;
import com.example.taskmaster.ui.auth.SignUp;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {
    Spinner spinner ;
    ArrayList<String> allTeams=new ArrayList<>();
    String team="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setTitle(getTitle());
        getTeams();
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                Intent i=new Intent(Settings.this,AllTasks.class);
                startActivity(i);
                Toast.makeText(this,"Back button pressed!",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void click(View view) {
        EditText username =(EditText) findViewById(R.id.username) ;
        String user=username.getText().toString();

        EditText email =(EditText) findViewById(R.id.email) ;
        String mail=email.getText().toString();


        if(user.isEmpty() && mail.isEmpty()){
            Intent i=new Intent(Settings.this,AllTasks.class);
            startActivity(i);

            Toast message= Toast.makeText(getBaseContext(),"you should fill both fields first!",Toast.LENGTH_LONG);
            message.show();
        }
        else{
            Intent i=new Intent(Settings.this,MyTasks.class);
            i.putExtra("username",user);
            i.putExtra("email",mail);
            Toast message= Toast.makeText(getBaseContext(),"you have successfully added to my App as a user!",Toast.LENGTH_LONG);
            startActivity(i);
            message.show();

            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor2 = pref.edit();
            editor2.putString("username", user); // Storing string
            editor2.putString("email", mail); // Storing string

            editor2.commit();
        }


    }
    private void getTeams() {
        Amplify.DataStore.query(Team.class,
                todos -> {
                    while (todos.hasNext()) {
                        Team todo = todos.next();

                        Log.i("Tutorial", "==== Teams ====");
                        Log.i("Tutorial", "Name: " + todo.getName());
                        allTeams.add(todo.getName());
                    }
                    spinner= (Spinner)findViewById(R.id.planets_spinner);
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, allTeams);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(arrayAdapter);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String tutorialsName = parent.getItemAtPosition(position).toString();
                            Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,Toast.LENGTH_LONG).show();
                            team=tutorialsName;
                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("teamName", team); // Storing string
                            editor.commit();
                        }
                        @Override
                        public void onNothingSelected(AdapterView <?> parent) {
                        }
                    });
                    System.out.println("all teams list"+allTeams);

                },
                failure -> Log.e("Tutorial", "Could not query DataStore", failure)
        );


    }

    public void logout(View view) {
        Amplify.Auth.signOut(
                () -> {Log.i("AuthQuickstart", "Signed out successfully");
                    Intent i = new Intent(Settings.this, SignUp.class);
                    startActivity(i);
                },
                error -> {
                    Log.e("AuthQuickstart", error.toString());
                    Toast toast=Toast.makeText(getApplicationContext(),"error happened when trying to logout",Toast.LENGTH_LONG);
                    toast.show();
                }
        );
    }
}
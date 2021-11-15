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
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                Intent i=new Intent(Settings.this,AllTasks.class);
                startActivity(i);
                Toast.makeText(this,"Button pressed!",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void click(View view) {
        EditText username =(EditText) findViewById(R.id.username) ;
        String user=username.getText().toString();

        EditText email =(EditText) findViewById(R.id.email) ;
        String mail=email.getText().toString();
//        EditText editText=(EditText)findViewById(R.id.editText);
//        int number=Integer.parseInt(editText.getText().toString());

//        if(user.isEmpty() && mail.isEmpty() && (editText.getText().toString().isEmpty() || editText.getText().toString() =="") ){
//            Toast message= Toast.makeText(getBaseContext(),"Please fill the fields before submit!",Toast.LENGTH_LONG);
//            message.show();
//        }
//        else{
//            Intent i=new Intent(Settings.this,MyTasks.class);
//            i.putExtra("username",user);
//            i.putExtra("email",mail);
//            i.putExtra("number",number);
//            Toast message= Toast.makeText(getBaseContext(),"you have successfully been added to the App!",Toast.LENGTH_LONG);
//            startActivity(i);
//            message.show();
//            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("username",user );
//            editor.putString("email",mail );
//            editor.putInt("number",number);
//            editor.apply();
//        }
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
}
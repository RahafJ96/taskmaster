package com.example.taskmaster;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Taskmaster;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;
import com.example.taskmaster.ui.auth.SignIn;
import com.example.taskmaster.ui.auth.SignUp;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends OnboarderActivity {

    List<OnboarderPage> onboarderPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        try {
//            // Add this line to add the AWSApiPlugin plugins
//            Amplify.addPlugin(new AWSApiPlugin());
//            Amplify.configure(getApplicationContext());
//            Log.i("MyAmplifyApp", "Initialized Amplify");
//        } catch (AmplifyException error) {
//            Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
//        }
        super.onCreate(savedInstanceState);
        onboarderPages = new ArrayList<OnboarderPage>();
        configureAmplify();

        // Create your first page
        OnboarderPage onboarderPage1 = new OnboarderPage("Manage Your Tasks", "This app will let manage your tasks!",R.drawable.pic2);
        OnboarderPage onboarderPage2 = new OnboarderPage("Make it fast to add and organize tasks", "Organize all your To-Do's lists. tag them and manage your time!",R.drawable.pic4);

        // You can define title and description colors (by default white)
        onboarderPage1.setTitleColor(R.color.white);
        onboarderPage1.setDescriptionColor(R.color.white);

        // Don't forget to set background color for your page
        onboarderPage1.setBackgroundColor(R.color.purple);
        // You can define title and description colors (by default white)
        onboarderPage2.setTitleColor(R.color.white);
        onboarderPage2.setDescriptionColor(R.color.white);
        setDividerColor(Color.BLACK);
        // Don't forget to set background color for your page
        onboarderPage2.setBackgroundColor(R.color.purple);
        setActiveIndicatorColor(android.R.color.white);
        setInactiveIndicatorColor(android.R.color.darker_gray);
        shouldDarkenButtonsLayout(true);
        // Add your pages to the list
        onboarderPages.add(onboarderPage1);
        onboarderPages.add(onboarderPage2);
        shouldUseFloatingActionButton(true);

        // And pass your pages to 'setOnboardPagesReady' method
        setOnboardPagesReady(onboarderPages);

    }

    @Override
    public void onSkipButtonPressed() {
        super.onSkipButtonPressed();
        Intent i =new Intent(MainActivity.this, SignIn.class);
        startActivity(i);
    }

    @Override
    public void onFinishButtonPressed() {
        Intent i =new Intent(MainActivity.this, SignIn.class);
        startActivity(i);    }
    private void configureAmplify() {
        try {
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.addPlugin(new AWSS3StoragePlugin());
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

}
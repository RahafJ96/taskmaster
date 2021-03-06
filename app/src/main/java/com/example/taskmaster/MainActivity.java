package com.example.taskmaster;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.analytics.AnalyticsEvent;
import com.amplifyframework.analytics.pinpoint.AWSPinpointAnalyticsPlugin;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Taskmaster;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;
import com.example.taskmaster.data.service.PushListenerService;
import com.example.taskmaster.ui.auth.SignIn;
import com.example.taskmaster.ui.auth.SignUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends OnboarderActivity {
    List<OnboarderPage> onboarderPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNotificationChannel();
        onboarderPages = new ArrayList<OnboarderPage>();
        configureAmplify();
        // Create your first page
        OnboarderPage onboarderPage1 = new OnboarderPage("Manage Your Tasks", "Organize all your To-Do's lists. tag them and manage your time!",R.drawable.pic1);
        OnboarderPage onboarderPage2 = new OnboarderPage("Saving Time and Money", "Time is money: use this advice to get the most from every job you do.",R.drawable.pic2);

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
//eventRecord2();
//eventRecord3();
    }

    @Override
    public void onSkipButtonPressed() {
        // Optional: by default it skips onboarder to the end
        super.onSkipButtonPressed();
        Intent i =new Intent(MainActivity.this, SignIn.class);
        startActivity(i);
        // Define your actions when the user press 'Skip' button
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
            Amplify.addPlugin(new AWSPinpointAnalyticsPlugin(getApplication()));

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


    private void eventRecord2() {
        String userName = getSharedPreferences("pref", MODE_PRIVATE).getString("userInfo", "no user info");
        AnalyticsEvent event = AnalyticsEvent.builder()
                .name("User Launched Add task activity")
                .addProperty("UserName", userName)
                .build();

        Amplify.Analytics.recordEvent(event);

    }

    private void eventRecord3() {
        String userName = getSharedPreferences("pref", MODE_PRIVATE).getString("userInfo", "no user info");
        AnalyticsEvent event = AnalyticsEvent.builder()
                .name("User Launched All tasks activity")
                .addProperty("UserName", userName)
                .build();

        Amplify.Analytics.recordEvent(event);

    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(PushListenerService.CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
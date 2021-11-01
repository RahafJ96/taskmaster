package com.example.taskmaster;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends OnboarderActivity{
    List<OnboarderPage> onboarderPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onboarderPages = new ArrayList<OnboarderPage>();
        OnboarderPage onboarderPage1 = new OnboarderPage("The Task Master", "Organize all your To-Do's lists!",R.drawable.pic1);
        OnboarderPage onboarderPage2 = new OnboarderPage("Saving Time and Money", "Time is money: use this advice to get the most from every job you do.",R.drawable.pic2);

        onboarderPage1.setDescriptionColor(R.color.white);

        onboarderPage1.setBackgroundColor(R.color.purple);
        onboarderPage2.setTitleColor(R.color.white);
        onboarderPage2.setDescriptionColor(R.color.white);
        setDividerColor(Color.BLACK);
        onboarderPage2.setBackgroundColor(R.color.purple);
        setActiveIndicatorColor(android.R.color.white);
        setInactiveIndicatorColor(android.R.color.darker_gray);
        shouldDarkenButtonsLayout(true);
        onboarderPages.add(onboarderPage1);
        onboarderPages.add(onboarderPage2);
        shouldUseFloatingActionButton(true);
        setOnboardPagesReady(onboarderPages);

    }

    @Override
    public void onSkipButtonPressed() {
        super.onSkipButtonPressed();
        Intent i =new Intent(IntroActivity.this, MyTasks.class);
        startActivity(i);
    }

    @Override
    public void onFinishButtonPressed() {
        Intent i =new Intent(IntroActivity.this, MyTasks.class);
        startActivity(i);    }
}

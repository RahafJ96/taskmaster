package com.example.taskmaster;
//
//import androidx.test.core.app.ActivityScenario;
//import androidx.test.espresso.Espresso;
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.action.ViewActions.click;
//import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
//import static androidx.test.espresso.action.ViewActions.typeText;
//import static androidx.test.espresso.assertion.ViewAssertions.matches;
//
//import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//import static androidx.test.espresso.matcher.ViewMatchers.withText;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//@RunWith(AndroidJUnit4.class)
//public class EspressoTest {
//
//    @Rule
//    public ActivityScenarioRule<Settings> rule2 = new ActivityScenarioRule<>(Settings.class);
//
//    @Test
//    public void userNameChange() {
//     //  try (ActivityScenario<MainActivity> ignored = ActivityScenario.launch(MainActivity.class)) {
//        onView(withId(R.id.username)).perform(typeText("Bob star"), closeSoftKeyboard());
//        onView(withId(R.id.email)).perform(typeText("star@gmail.com"), closeSoftKeyboard());
//        onView(withId(R.id.editText)).perform(typeText("2"), closeSoftKeyboard());
//        onView(withId(R.id.button)).perform(click());
//        }
//
// //   }
//
//
//}

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EspressoTestApp{

    @Rule
    public ActivityScenarioRule<Settings> rule2 = new ActivityScenarioRule<>(Settings.class);
    @Test
    public void userNameChange() {
//        try (ActivityScenario<MainActivity> ignored = ActivityScenario.launch(MainActivity.class)) {
        onView(withId(R.id.username)).perform(typeText("Severus Snap"), closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("sev-snap@hogwarts.mag"), closeSoftKeyboard());
        onView(withId(R.id.editText)).perform(typeText("3"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
//        }

    }

}
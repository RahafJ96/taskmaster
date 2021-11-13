//package com.example.taskmaster;
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
//    public ActivityScenarioRule<AddTask> rule = new ActivityScenarioRule<>(AddTask.class);
//
//    @Test
//    public void assertTextChanged() {
////        try (ActivityScenario<MainActivity> ignored = ActivityScenario.launch(MainActivity.class)) {
//        // type text and then press change text button
//        onView(withId(R.id.edit1)).perform(typeText("Hello"), closeSoftKeyboard());
//        onView(withId(R.id.edit2)).perform(typeText("App"), closeSoftKeyboard());
//        onView(withId(R.id.in_progress))
//                .perform(click());
//
//        onView(withId(R.id.new_task))
//                .check(matches(isNotChecked()));
//
//        onView(withId(R.id.completed))
//                .check(matches(isNotChecked()));
//
//        onView(withId(R.id.assigned))
//                .check(matches(isNotChecked()));
//        onView(withId(R.id.button)).perform(click());
//
//        // check that the text was changed when the button was clicked
////        }
//
//    }
//
//
//}
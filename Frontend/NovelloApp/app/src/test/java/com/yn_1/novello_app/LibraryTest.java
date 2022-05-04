package com.yn_1.novello_app;


import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class LibraryTest {

    private static final int SIMULATED_DELAY_MS = 500;

    @Rule   // needed to launch the activity
    public ActivityTestRule<NavBarActivity> activityRule = new ActivityTestRule<>(NavBarActivity.class);

    @Test
    public void fetchBooks() {
        onView(withId(R.id.currentlyReading));
        onView(hasMinimumChildCount(0));
    }

    @Test
    public void moveBookToCategory() {

    }

    @Test
    public void addBookToCart() {

    }
}

package com.yn_1.novello_app;

import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.yn_1.novello_app.account.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringEndsWith.endsWith;

import android.os.Looper;


//Mock the RequestServerForService class
@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest  //large execution time
public class LoginActivityTest {

    private static final int SIMULATED_DELAY_MS = 500;

    @Rule   //needed to launch the activity
    public ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule<>(LoginActivity.class);

    /**
     * Tests loginResult
     */
    @Test
    public void login() {

        //login failed
        Looper.prepare();
        ((LoginActivity)activityRule.getActivity()).loginResult(0);
        onView(withText("Login failed. Try again!")).check(matches(isDisplayed()));

    }

}
package com.yn_1.novello_app;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.rule.ActivityTestRule;

import com.yn_1.novello_app.account.LoginActivity;

import org.junit.Rule;
import org.junit.Test;

public class FriendsTest {

    private static final int SIMULATED_DELAY_MS = 500;

    @Rule   //needed to launch the activity
    public ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule<>(LoginActivity.class);

    /**
     * Tests friends
     */
    @Test
    public void friends() {
        onView(withId(R.id.inputUsername)).perform(typeText("Scottie"), closeSoftKeyboard());
        onView(withId(R.id.inputPassword)).perform(typeText("6969"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.profile)).perform(click());
        onView(withId(R.id.friendsList)).perform(click());
        onView(withId(R.id.addFriendSearch)).perform(typeText("Scottie"), closeSoftKeyboard());
        onView(withId(R.id.addFriendButton)).check(matches(withText("Add Friend")));
    }

}

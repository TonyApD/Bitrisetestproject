package flitsmeister.nl.bitrisetestproject;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by tonylopar on 29/03/17.
 */

@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule(LoginActivity.class);

    @Test
    public void testLogin() {
        onView(withId(R.id.email)).perform(typeText("fooexample.com"), closeSoftKeyboard());
        onView(withId(R.id.email_sign_in_button)).perform(click());
        String error = InstrumentationRegistry.getTargetContext().getString(R.string.error_invalid_email);
        onView(withId(R.id.email)).check(matches(hasErrorText(error)));
    }

    @Test
    public void testButtonVisible() {
        onView(withId(R.id.email_sign_in_button)).check(matches(isDisplayed()));
    }

}

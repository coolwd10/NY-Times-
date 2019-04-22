package info.com.NyTimes;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.test.InstrumentationTestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import info.com.NyTimes.android.mvp.main.home.HomeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class HomeActivityViewTest extends InstrumentationTestCase {

    RecyclerView recyclerView;
    private Activity activity;

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule =
            new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void testCase1(){
        assertNotNull(mActivityTestRule);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.recycler_view)).perform(click());
    }

}

package com.lateron.mvp_template;

import android.support.design.widget.BottomNavigationView;
import android.widget.TextView;

import com.lateron.mvp_template.robolectric.ShadowBottomNavigationView;
import com.lateron.mvp_template.ui.activities.HomeActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,
        shadows = {ShadowBottomNavigationView.class})
public class HomeActivityTest {

    private HomeActivity homeActivity;

    @Before
    public void setUp() {
        homeActivity = Robolectric.setupActivity(HomeActivity.class);
    }

    @Test
    public void testHasContent() {
        TextView messageText = (TextView) homeActivity.findViewById(R.id.message);
        assertEquals("Home", messageText.getText());
        homeActivity.hasContent("Test");
        assertEquals("Test", messageText.getText());
    }

    @Test
    public void testNavigation() {
        TextView messageText = (TextView) homeActivity.findViewById(R.id.message);
        BottomNavigationView bottomNavigation = (BottomNavigationView) homeActivity.findViewById(R.id.navigation);
        ((ShadowBottomNavigationView) Shadows.shadowOf(bottomNavigation)).selectMenuItem(1);
        assertEquals("Home", messageText.getText());
    }

}

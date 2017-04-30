package com.lateron.mvp_template;

import android.widget.EditText;

import com.lateron.mvp_template.ui.fragments.LoginFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class LoginFragmentTest {

    private final String sampleEmail = "sample@user.com";
    private final String samplePassword = "password1";

    private LoginFragment loginFragment;

    @Before
    public void setUp() {
        loginFragment = LoginFragment.newInstance();
        SupportFragmentTestUtil.startVisibleFragment(loginFragment);
    }

    @Test
    public void testFormFunctionality() {
        EditText emailEditText = (EditText) loginFragment.getView().findViewById(R.id.email_edittext);
        emailEditText.setText(sampleEmail);
        assertEquals(loginFragment.userEntity.getEmail(), sampleEmail);
        EditText passwordEditText = (EditText) loginFragment.getView().findViewById(R.id.password_edittext);
        passwordEditText.setText(samplePassword);
        assertEquals(loginFragment.userEntity.getPassword(), samplePassword);
    }

}

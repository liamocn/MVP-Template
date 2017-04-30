package com.lateron.mvp_template.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.lateron.mvp_template.R;
import com.lateron.mvp_template.ui.base.BaseActivity;
import com.lateron.mvp_template.ui.fragments.LoginFragment;

import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setUpToolbar();

        initFragment(LoginFragment.TAG);
    }

    @Override
    public void setUpToolbar() {

    }

    private void initFragment(String fragmentTag) {
        Fragment fragment = getFragment(fragmentTag);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();

        fragmentTransaction
                .replace(R.id.main_container, fragment)
                .commit();
    }

    private Fragment getFragment(String fragmentTag) {

        if (fragmentTag.equals(LoginFragment.TAG)) {
            return LoginFragment.newInstance();
        }
        return null;
    }

}

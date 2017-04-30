package com.lateron.mvp_template.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.lateron.mvp_template.App;
import com.lateron.mvp_template.R;
import com.lateron.mvp_template.di.ContentComponent;
import com.lateron.mvp_template.di.ContentModule;
import com.lateron.mvp_template.di.DaggerContentComponent;
import com.lateron.mvp_template.di.DaggerUserComponent;
import com.lateron.mvp_template.di.UserComponent;
import com.lateron.mvp_template.di.UserModule;
import com.lateron.mvp_template.ui.base.BaseActivity;
import com.lateron.mvp_template.ui.presenters.HomePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomePresenter.View {

    public static final String TAG = HomeActivity.class.getName();

    @BindView(R.id.icon)
    ImageView icon;

    @BindView(R.id.navigation)
    BottomNavigationView bottomNavigation;

    @BindView(R.id.message)
    TextView textMessage;
    @Inject
    HomePresenter presenter;
    ContentComponent contentComponent;
    UserComponent userComponent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    presenter.getHomeContent();
                    return true;
                case R.id.navigation_dashboard:
                    presenter.getDashboardContent();
                    return true;
                case R.id.navigation_notifications:
                    presenter.getNotificationContent();
                    return true;
            }
            return false;
        }

    };

    public static void start(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setUpToolbar();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        injectDependencies();
        attachToPresenter();

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        presenter.getHomeContent();
    }

    @Override
    protected void onPause() {
        super.onPause();
        detachFromPresenter();
    }

    @Override
    public void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_action, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                presenter.logUserOut();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void injectDependencies() {
        if (contentComponent == null) {
            contentComponent = DaggerContentComponent.builder()
                    .appComponent(App.get(getContext()).getComponent())
                    .contentModule(new ContentModule())
                    .build();
            contentComponent.inject(this);
        }
        if (userComponent == null) {
            userComponent = DaggerUserComponent.builder()
                    .appComponent(App.get(getContext()).getComponent())
                    .userModule(new UserModule())
                    .build();
            userComponent.inject(this);
        }
    }

    @Override
    public void attachToPresenter() {
        presenter.attachView(this);
    }

    @Override
    public void detachFromPresenter() {
        presenter.detachView();
    }

    @Override
    public void onLandscape() {

    }

    @Override
    public void onPortrait() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void hasContent(String content) {
        textMessage.setText(content);
    }

    @Override
    public void userLoggedOut() {
        presenter.goToLogin(this);
        finish();
    }
}

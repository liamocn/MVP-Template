package com.lateron.mvp_template.ui.presenters;

import android.content.Context;
import android.content.SharedPreferences;

import com.lateron.mvp_template.analytics.AnalyticsInterface;
import com.lateron.mvp_template.model.user.UserEntity;
import com.lateron.mvp_template.tasks.user.LogUserInTask;
import com.lateron.mvp_template.ui.activities.HomeActivity;
import com.lateron.mvp_template.ui.base.BaseView;
import com.lateron.mvp_template.ui.presenters.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class LoginPresenter extends BasePresenter<LoginPresenter.View> {

    private final LogUserInTask logUserInTask;
    private final AnalyticsInterface analyticsInterface;
    private SharedPreferences sharedPreferences;

    @Inject
    public LoginPresenter(LogUserInTask logUserInTask,
                          AnalyticsInterface analyticsInterface,
                          SharedPreferences sharedPreferences) {
        this.logUserInTask = logUserInTask;
        this.analyticsInterface = analyticsInterface;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void attachView(View view) {
        super.attachView(view);
        analyticsInterface.trackPageView(AnalyticsInterface.VIEW_LOGIN);
    }

    @Override
    public void detachView() {
        logUserInTask.dispose();
        super.detachView();
    }

    public void logUserIn(UserEntity entity) {
        analyticsInterface.trackUserAction(AnalyticsInterface.ACTION_LOGIN);
        logUserInTask.execute(new CheckUserObserver(), entity);
    }

    public void goToDashBoard(Context context) {
        HomeActivity.start(context);
    }

    public interface View extends BaseView {
        void userLoggedIn();
    }

    private final class CheckUserObserver extends DisposableObserver<Boolean> {

        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Boolean value) {
            if (value) {
                view.userLoggedIn();
            }
        }
    }

}

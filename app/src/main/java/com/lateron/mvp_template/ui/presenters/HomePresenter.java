package com.lateron.mvp_template.ui.presenters;

import android.content.Context;
import android.content.SharedPreferences;

import com.lateron.mvp_template.analytics.AnalyticsInterface;
import com.lateron.mvp_template.tasks.content.GetDashboardContentTask;
import com.lateron.mvp_template.tasks.content.GetHomeContentTask;
import com.lateron.mvp_template.tasks.content.GetNotificationContentTask;
import com.lateron.mvp_template.tasks.user.LogUserOutTask;
import com.lateron.mvp_template.ui.activities.HomeActivity;
import com.lateron.mvp_template.ui.activities.LoginActivity;
import com.lateron.mvp_template.ui.base.BaseView;
import com.lateron.mvp_template.ui.presenters.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class HomePresenter extends BasePresenter<HomePresenter.View> {

    private final GetHomeContentTask getHomeContentTask;
    private final GetDashboardContentTask getDashboardContentTask;
    private final GetNotificationContentTask getNotificationContentTask;
    private final LogUserOutTask logUserOutTask;
    private final AnalyticsInterface analyticsInterface;
    private SharedPreferences sharedPreferences;

    @Inject
    public HomePresenter(GetHomeContentTask getHomeContentTask,
                         GetDashboardContentTask getDashboardContentTask,
                         GetNotificationContentTask getNotificationContentTask,
                         LogUserOutTask logUserOutTask,
                         AnalyticsInterface analyticsInterface,
                         SharedPreferences sharedPreferences) {
        this.getHomeContentTask = getHomeContentTask;
        this.getDashboardContentTask = getDashboardContentTask;
        this.getNotificationContentTask = getNotificationContentTask;
        this.logUserOutTask = logUserOutTask;
        this.analyticsInterface = analyticsInterface;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void attachView(View view) {
        super.attachView(view);
        analyticsInterface.trackPageView(AnalyticsInterface.VIEW_HOME);
    }

    @Override
    public void detachView() {
        getHomeContentTask.dispose();
        getDashboardContentTask.dispose();
        getNotificationContentTask.dispose();
        super.detachView();
    }

    public void getHomeContent() {
        analyticsInterface.trackPageView(AnalyticsInterface.VIEW_HOME);
        getHomeContentTask.execute(new ContentObserver(), null);
    }

    public void getDashboardContent() {
        analyticsInterface.trackPageView(AnalyticsInterface.VIEW_DASHBOARD);
        getDashboardContentTask.execute(new ContentObserver(), null);
    }

    public void getNotificationContent() {
        analyticsInterface.trackPageView(AnalyticsInterface.VIEW_NOTIFICATION);
        getNotificationContentTask.execute(new ContentObserver(), null);
    }

    public void logUserOut() {
        analyticsInterface.trackUserAction(AnalyticsInterface.ACTION_LOGOUT);
        logUserOutTask.execute(new LogUserOutObserver(), null);
    }

    public void goToDashBoard(Context context) {
        HomeActivity.start(context);
    }

    public void goToLogin(Context context) {
        LoginActivity.start(context);
    }

    public interface View extends BaseView {
        void hasContent(String content);

        void userLoggedOut();
    }

    public final class ContentObserver extends DisposableObserver<String> {

        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String content) {
            view.hasContent(content);
        }
    }

    public final class LogUserOutObserver extends DisposableObserver<Boolean> {

        @Override
        public void onNext(Boolean value) {
            if (value) {
                view.userLoggedOut();
            }
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }

}

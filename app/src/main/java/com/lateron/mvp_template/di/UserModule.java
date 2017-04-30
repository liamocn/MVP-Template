package com.lateron.mvp_template.di;

import android.content.SharedPreferences;

import com.lateron.mvp_template.analytics.AnalyticsInterface;
import com.lateron.mvp_template.model.user.UserDataSourceRemote;
import com.lateron.mvp_template.model.user.UserRepository;
import com.lateron.mvp_template.tasks.content.GetDashboardContentTask;
import com.lateron.mvp_template.tasks.content.GetHomeContentTask;
import com.lateron.mvp_template.tasks.content.GetNotificationContentTask;
import com.lateron.mvp_template.tasks.user.LogUserInTask;
import com.lateron.mvp_template.tasks.user.LogUserOutTask;
import com.lateron.mvp_template.ui.presenters.HomePresenter;
import com.lateron.mvp_template.ui.presenters.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides
    LoginPresenter provideLoginPresenter(LogUserInTask logUserInTask,
                                         AnalyticsInterface analyticsInterface,
                                         SharedPreferences sharedPreferences) {
        return new LoginPresenter(logUserInTask,
                analyticsInterface,
                sharedPreferences);
    }

    @Provides
    HomePresenter provideHomePresenter(GetHomeContentTask getHomeContentTask,
                                       GetDashboardContentTask getDashboardContentTask,
                                       GetNotificationContentTask getNotificationContentTask,
                                       LogUserOutTask logUserOutTask,
                                       AnalyticsInterface analyticsInterface,
                                       SharedPreferences sharedPreferences) {
        return new HomePresenter(getHomeContentTask,
                getDashboardContentTask,
                getNotificationContentTask,
                logUserOutTask,
                analyticsInterface,
                sharedPreferences);
    }

    @Provides
    LogUserInTask provideLogUserInTask(UserRepository repository) {
        return new LogUserInTask(repository);
    }

    @Provides
    LogUserOutTask provideLogUserOutTask(UserRepository repository) {
        return new LogUserOutTask(repository);
    }

    @Provides
    UserDataSourceRemote provideUserDataSource() {
        return new UserDataSourceRemote();
    }

    @Provides
    UserRepository provideUserRepository(UserDataSourceRemote dataSource) {
        return new UserRepository(dataSource);
    }
}

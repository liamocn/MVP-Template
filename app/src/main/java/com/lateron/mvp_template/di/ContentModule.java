package com.lateron.mvp_template.di;

import android.content.SharedPreferences;

import com.lateron.mvp_template.analytics.AnalyticsInterface;
import com.lateron.mvp_template.model.content.ContentDataSourceRemote;
import com.lateron.mvp_template.model.content.ContentRespository;
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
public class ContentModule {

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
    ContentDataSourceRemote provideContentDataSource() {
        return new ContentDataSourceRemote();
    }

    @Provides
    ContentRespository provideContentRepository(ContentDataSourceRemote dataSource) {
        return new ContentRespository(dataSource);
    }
}

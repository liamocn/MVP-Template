package com.lateron.mvp_template.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.lateron.mvp_template.App;
import com.lateron.mvp_template.analytics.AnalyticsHelper;
import com.lateron.mvp_template.analytics.AnalyticsInterface;
import com.lateron.mvp_template.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @ApplicationScope
    public App provideApplication() {
        return app;
    }

    @Provides
    @ApplicationScope
    public Context provideContext() {
        return app;
    }

    @Provides
    @ApplicationScope
    public Gson provideGSON() {
        return new Gson();
    }

    @Provides
    @ApplicationScope
    public AnalyticsInterface provideAnalyticsHelper(Context context) {
        return new AnalyticsHelper();
    }

    @Provides
    @ApplicationScope
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}

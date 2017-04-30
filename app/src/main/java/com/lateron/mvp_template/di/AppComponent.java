package com.lateron.mvp_template.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.lateron.mvp_template.App;
import com.lateron.mvp_template.analytics.AnalyticsInterface;
import com.lateron.mvp_template.di.scope.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(
        modules = {AppModule.class}
)
public interface AppComponent {

    void inject(App app);

    Context context();

    App app();

    Gson gson();

    AnalyticsInterface analyticsHelper();

    SharedPreferences sharedPreferences();
}

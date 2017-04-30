package com.lateron.mvp_template;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.lateron.mvp_template.di.AppComponent;
import com.lateron.mvp_template.di.AppModule;
import com.lateron.mvp_template.di.DaggerAppComponent;

public class App extends Application {

    AppComponent component;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public AppComponent getComponent() {
        return component;
    }

    public AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = createAppComponent();

        if (BuildConfig.DEBUG) {
            enableStrictMode();
        }

        initRemoteConfig();
    }

    private void enableStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());
    }

    private void initRemoteConfig() {

    }
}

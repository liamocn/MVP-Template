package com.lateron.mvp_template.model.content;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ContentDataSourceRemote {

    @Inject
    public ContentDataSourceRemote() {

    }

    public Observable<String> getHomeContent() {
        return Observable.just("Home");
    }

    public Observable<String> getDashboardContent() {
        return Observable.just("Dashboard");
    }

    public Observable<String> getNotificationContent() {
        return Observable.just("Notifications");
    }

}

package com.lateron.mvp_template.model.content;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ContentRespository {

    private final ContentDataSourceRemote contentDataSourceRemote;

    @Inject
    public ContentRespository(ContentDataSourceRemote contentDataSourceRemote) {
        this.contentDataSourceRemote = contentDataSourceRemote;
    }

    public Observable<String> getHomeContent() {
        return contentDataSourceRemote.getHomeContent();
    }

    public Observable<String> getDashboardContent() {
        return contentDataSourceRemote.getDashboardContent();
    }

    public Observable<String> getNotificationContent() {
        return contentDataSourceRemote.getNotificationContent();
    }

}

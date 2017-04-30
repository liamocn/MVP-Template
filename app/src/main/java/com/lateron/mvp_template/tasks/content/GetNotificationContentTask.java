package com.lateron.mvp_template.tasks.content;

import com.lateron.mvp_template.model.content.ContentRespository;
import com.lateron.mvp_template.tasks.base.BaseTask;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetNotificationContentTask extends BaseTask {

    private final ContentRespository contentRespository;

    @Inject
    public GetNotificationContentTask(ContentRespository contentRespository) {
        this.contentRespository = contentRespository;
    }

    @Override
    protected Observable getObservable(Object params) {
        return contentRespository.getNotificationContent();
    }
}

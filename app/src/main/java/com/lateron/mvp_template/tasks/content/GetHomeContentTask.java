package com.lateron.mvp_template.tasks.content;

import com.lateron.mvp_template.model.content.ContentRespository;
import com.lateron.mvp_template.tasks.base.BaseTask;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetHomeContentTask extends BaseTask {

    private final ContentRespository contentRespository;

    @Inject
    public GetHomeContentTask(ContentRespository contentRespository) {
        this.contentRespository = contentRespository;
    }

    @Override
    public Observable getObservable(Object params) {
        return contentRespository.getHomeContent();
    }
}

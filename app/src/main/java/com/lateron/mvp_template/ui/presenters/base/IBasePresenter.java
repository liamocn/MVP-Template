package com.lateron.mvp_template.ui.presenters.base;

import com.lateron.mvp_template.ui.base.BaseView;

public interface IBasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

    boolean isViewAttached();

    void checkViewAttached();
}

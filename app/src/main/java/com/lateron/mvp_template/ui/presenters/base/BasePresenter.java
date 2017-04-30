package com.lateron.mvp_template.ui.presenters.base;

import com.lateron.mvp_template.ui.base.BaseView;

public class BasePresenter<T extends BaseView> implements IBasePresenter<T> {

    protected T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void checkViewAttached() throws ViewNotAttachedException {
        if (!isViewAttached()) throw new ViewNotAttachedException();
    }

    public static class ViewNotAttachedException extends RuntimeException {
        public ViewNotAttachedException() {
            super("Presenter has no view attached!");
        }
    }
}

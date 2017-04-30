package com.lateron.mvp_template.ui.base;

public interface BaseView {
    void injectDependencies();

    void attachToPresenter();

    void detachFromPresenter();

    void onLandscape();

    void onPortrait();

    void showLoading();

    void hideLoading();
}

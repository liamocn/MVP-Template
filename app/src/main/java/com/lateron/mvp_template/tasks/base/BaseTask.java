package com.lateron.mvp_template.tasks.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;

public abstract class BaseTask {

    private final CompositeDisposable disposables;

    public BaseTask() {
        this.disposables = new CompositeDisposable();
    }

    public CompositeDisposable getDisposables() {
        return disposables;
    }

    protected abstract <T> Observable getObservable(T params);

    @SuppressWarnings("unchecked")
    public <T> void execute(DisposableObserver observer, T params) {
        final Observable<?> observable = getObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        addDisposable(observable.subscribeWith(observer));
    }

    public <T> void execute(DisposableObserver observer, TestScheduler scheduler, T params) {
        final Observable<?> observable = getObservable(params)
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread());
        addDisposable(observable.subscribeWith(observer));
    }

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    public void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

}

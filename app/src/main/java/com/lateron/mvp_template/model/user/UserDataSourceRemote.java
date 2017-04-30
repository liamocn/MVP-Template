package com.lateron.mvp_template.model.user;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

public class UserDataSourceRemote {

    @Inject
    public UserDataSourceRemote() {

    }

    public Observable<Boolean> register(final UserEntity userEntity) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return true;
            }
        });
    }

    public Observable<Boolean> login(final UserEntity userEntity) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return true;
            }
        });
    }

    public Observable<Boolean> isUserLoggedIn() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return true;
            }
        });
    }

    public Observable<Boolean> logoutUser() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return true;
            }
        });
    }

}

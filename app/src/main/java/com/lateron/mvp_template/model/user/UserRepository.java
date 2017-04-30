package com.lateron.mvp_template.model.user;

import javax.inject.Inject;

import io.reactivex.Observable;

public class UserRepository {

    private final UserDataSourceRemote userDataSourceRemote;

    @Inject
    public UserRepository(UserDataSourceRemote userDataSourceRemote) {
        this.userDataSourceRemote = userDataSourceRemote;
    }

    public Observable<Boolean> register(UserEntity entity) {
        return this.userDataSourceRemote.register(entity);
    }

    public Observable<Boolean> login(UserEntity entity) {
        return this.userDataSourceRemote.login(entity);
    }

    public Observable<Boolean> isUserLoggedIn() {
        return this.userDataSourceRemote.isUserLoggedIn();
    }

    public Observable<Boolean> logoutUser() {
        return this.userDataSourceRemote.logoutUser();
    }

}

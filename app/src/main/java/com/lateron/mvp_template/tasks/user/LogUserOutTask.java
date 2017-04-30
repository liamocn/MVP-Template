package com.lateron.mvp_template.tasks.user;

import com.lateron.mvp_template.model.user.UserRepository;
import com.lateron.mvp_template.tasks.base.BaseTask;

import javax.inject.Inject;

import io.reactivex.Observable;

public class LogUserOutTask extends BaseTask {

    private final UserRepository userRepository;

    @Inject
    public LogUserOutTask(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected Observable getObservable(Object params) {
        return userRepository.logoutUser();
    }
}

package com.lateron.mvp_template.tasks.user;

import com.lateron.mvp_template.model.user.UserEntity;
import com.lateron.mvp_template.model.user.UserRepository;
import com.lateron.mvp_template.tasks.base.BaseTask;

import javax.inject.Inject;

import io.reactivex.Observable;

public class LogUserInTask extends BaseTask {

    private final UserRepository userRepository;

    @Inject
    public LogUserInTask(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public <T> Observable getObservable(T params) {
        if (params instanceof UserEntity) {
            return this.userRepository.login((UserEntity) params);
        }
        return null;
    }

}

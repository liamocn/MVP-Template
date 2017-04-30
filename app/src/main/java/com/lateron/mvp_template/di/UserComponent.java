package com.lateron.mvp_template.di;

import com.lateron.mvp_template.di.scope.ActivityScope;
import com.lateron.mvp_template.model.user.UserDataSourceRemote;
import com.lateron.mvp_template.model.user.UserRepository;
import com.lateron.mvp_template.tasks.user.LogUserInTask;
import com.lateron.mvp_template.tasks.user.LogUserOutTask;
import com.lateron.mvp_template.ui.activities.HomeActivity;
import com.lateron.mvp_template.ui.fragments.LoginFragment;
import com.lateron.mvp_template.ui.presenters.HomePresenter;
import com.lateron.mvp_template.ui.presenters.LoginPresenter;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = UserModule.class
)

public interface UserComponent {

    //Activities
    void inject(HomeActivity view);

    //Fragments
    void inject(LoginFragment view);

    // Presenters
    void inject(LoginPresenter presenter);

    void inject(HomePresenter presenter);

    // Tasks
    void inject(LogUserInTask useCase);

    void inject(LogUserOutTask useCase);

    // Repositories
    void inject(UserRepository repository);

    // DataSources
    void inject(UserDataSourceRemote dataSource);

}

package com.lateron.mvp_template.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lateron.mvp_template.App;
import com.lateron.mvp_template.R;
import com.lateron.mvp_template.di.DaggerUserComponent;
import com.lateron.mvp_template.di.UserComponent;
import com.lateron.mvp_template.di.UserModule;
import com.lateron.mvp_template.model.user.UserEntity;
import com.lateron.mvp_template.ui.base.BaseFragment;
import com.lateron.mvp_template.ui.presenters.LoginPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment implements LoginPresenter.View {

    public static final String TAG = LoginFragment.class.getName();
    public UserEntity userEntity;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.email_edittext)
    EditText emailEditText;
    @BindView(R.id.password_edittext)
    EditText passwordEditText;
    @BindView(R.id.register_button)
    Button registerButton;
    @Inject
    LoginPresenter presenter;
    UserComponent component;

    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.register_button)
    public void clickRegisterButton() {
        presenter.logUserIn(userEntity);
    }

    @Override
    public void injectDependencies() {
        if (component == null) {
            component = DaggerUserComponent.builder()
                    .appComponent(App.get(getContext()).getComponent())
                    .userModule(new UserModule())
                    .build();
            component.inject(this);
        }
    }

    @Override
    public void attachToPresenter() {
        this.presenter.attachView(this);
    }

    @Override
    public void detachFromPresenter() {
        this.presenter.detachView();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, v);

        userEntity = new UserEntity();
        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                userEntity.setEmail(s.toString());
            }
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                userEntity.setPassword(s.toString());
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        injectDependencies();
        attachToPresenter();
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        detachFromPresenter();
        super.onDetach();
    }

    @Override
    public void onLandscape() {

    }

    @Override
    public void onPortrait() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void userLoggedIn() {
        presenter.goToDashBoard(getContext());
        getActivity().finish();
    }

}

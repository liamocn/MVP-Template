package com.lateron.mvp_template.ui.base;

import android.content.Context;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment implements BaseView {

    @SuppressWarnings("unchecked")
    public <T extends BaseActivity> T getAssociatedActivity() {
        return (T) getActivity();
    }

    public Context getContext() {
        return getAssociatedActivity().getContext();
    }

}

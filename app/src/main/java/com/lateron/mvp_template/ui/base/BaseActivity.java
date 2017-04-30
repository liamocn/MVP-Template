package com.lateron.mvp_template.ui.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public abstract void setUpToolbar();

    public Context getContext() {
        return this;
    }

}

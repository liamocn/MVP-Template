package com.lateron.mvp_template.analytics;

import android.support.annotation.NonNull;

public interface AnalyticsInterface {

    String VIEW_LOGIN = "view_login";
    String VIEW_HOME = "view_home";
    String VIEW_DASHBOARD = "view_dashboard";
    String VIEW_NOTIFICATION = "view_notification";

    String ACTION_LOGIN = "action_login";
    String ACTION_LOGOUT = "action_logout";

    void trackPageView(@NonNull String view);

    void trackUserAction(@NonNull String action);
}

package com.it;

import com.it.helpers.CommonHelper;
import com.it.helpers.DashboardHelper;
import com.it.helpers.EmailHelper;
import com.it.helpers.LoginHelper;

public class App {
    public CommonHelper commonHelper;
    public LoginHelper login;
    public DashboardHelper dashboard;
    public EmailHelper email;

    public App() {
        commonHelper = new CommonHelper();
        login = new LoginHelper();
        dashboard = new DashboardHelper();
        email = new EmailHelper();
    }
}


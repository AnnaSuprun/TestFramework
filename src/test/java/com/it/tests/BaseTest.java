package com.it.tests;

import com.it.App;
import com.it.email.Email;
import com.it.email.EmailFactory;
import com.it.users.User;
import com.it.users.UserFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected App app = new App();
    protected User validUser = UserFactory.getValidUser();
    protected Email validEmail = EmailFactory.getValidEmail();

    @BeforeSuite
    public void beforeSuite() {
        app.login.login(validUser);
        app.commonHelper.takeScreenShot();
        Assert.assertEquals(app.dashboard.getLbUserEmail(), validUser.email);
    }

    @AfterSuite
    public void afterSuite() {
        app.commonHelper.appStop();
    }

}

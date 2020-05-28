package com.it.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest extends BaseTest{

    @Test
    public void sendEmailTest(){
        app.email.sendEmail(validEmail);
        app.commonHelper.takeScreenShot();
        app.commonHelper.addLogToAllure();

        Assert.assertEquals(app.dashboard.getLbConfirmSendEmail(), "Письмо успешно отправлено адресатам");
        Assert.assertTrue(app.email.checkLastInputEmail(validUser.getUserName()));
    }
}

package com.it.helpers;

import com.it.pages.LoginPage;
import com.it.users.User;

public class LoginHelper extends LoginPage {

    public void login (String login, String pass){
        setInputLogin(login);
        setInputPassword(pass);
        btnClickLogin();
    }

    public void login (User user){
        log.info(String.format("Login user name - %s, password - %s", user.userName, user.password));
        driver.scrollDown();
        try {
            Thread.sleep(2000);
            driver.scrollUp();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        login(user.email, user.password);
    }
}

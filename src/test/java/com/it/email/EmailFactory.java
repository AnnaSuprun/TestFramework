package com.it.email;

import java.util.ResourceBundle;

public class EmailFactory {
    public static ResourceBundle emailProperty = ResourceBundle.getBundle("email");

    public static Email getValidEmail() {
        return new Email(emailProperty.getString("recipient")
                , emailProperty.getString("subject")
                , emailProperty.getString("message"));
    }
}

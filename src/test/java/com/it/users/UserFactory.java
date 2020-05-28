package com.it.users;

import com.it.utils.QAUtils;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserFactory {
    public static ResourceBundle user = ResourceBundle.getBundle("user");

    public static User getValidUser() {
        return new User(user.getString("userName")
                , user.getString("password")
                , user.getString("email"));
    }

    public static List<User> getRandomUsers(int strLength) {
        return Stream.generate(
                () -> new User(
                        QAUtils.getRandomString(10),
                        QAUtils.getRandomString(15),
                        QAUtils.getRandomString(10) + "@gmail.com"))
                .limit(strLength)
                .collect(Collectors.toList());
    }
}

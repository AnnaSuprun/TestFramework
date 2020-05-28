package com.it.utils;

import java.util.Random;
import java.util.stream.Collectors;

public class QAUtils {

    public static String getRandomString(int strLength){
        return new Random()
                .ints('a','z')
                .limit(strLength)
                .mapToObj(s -> "" + (char)s)
                .collect(Collectors.joining());
    }
}

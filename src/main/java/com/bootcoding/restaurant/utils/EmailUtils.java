package com.bootcoding.restaurant.utils;

import java.util.Random;

public class EmailUtils {
    private static final String EMAIL_SUFFIX = "@gmail.com";
    private static final int MIN = 2000;
    private static final int MAX = 2022;
    public static String getEmail(String name) {
        Random random=new Random();
        int randomNumber =random.nextInt(MAX-MIN);
        int year = MIN + randomNumber;
        String emailId = name + year + EMAIL_SUFFIX;
        return emailId;

    }
}

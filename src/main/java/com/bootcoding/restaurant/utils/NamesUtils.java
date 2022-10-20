package com.bootcoding.restaurant.utils;

import java.util.Random;

public class NamesUtils {
    private static String[] name={"Rajesh","Suresh","Raju","Dilip","Pintu"};
    public static String getNames(){
        Random random=new Random();
        int i=random.nextInt(name.length);
        return name[i];
    }
}

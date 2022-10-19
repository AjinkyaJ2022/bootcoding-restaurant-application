package com.bootcoding.restaurant.utils;

import java.util.Random;

public class NumberGenerator {
    public static int getRandomNumber(){
        Random random=new Random();
       int r= random.nextInt(100);
        System.out.println("The random number;"+r);
        return r;
    }
}

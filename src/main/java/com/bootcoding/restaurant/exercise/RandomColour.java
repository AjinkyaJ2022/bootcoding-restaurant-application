package com.bootcoding.restaurant.exercise;

import java.util.Random;

public class RandomColour {
    public static void main(String[] args) {
        String[] colours={"Black","Blue","Red","Green"};
        Random random=new Random();
        int c=random.nextInt(colours.length);
        System.out.println(colours[c]);
    }
}

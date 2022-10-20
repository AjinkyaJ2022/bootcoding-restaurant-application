package com.bootcoding.restaurant.utils;

import java.util.Random;

public class CityUtils {
    private static String[] city={"Nagpur","Mumbai","Pune","Delhi","Hydrabad","Indore","Lakhnow","Nashik","Nodia"};
    public static String getCity() {

        Random random=new Random();
        int i=random.nextInt(city.length);
        System.out.println(city[i]);
        return city[i];

    }

}

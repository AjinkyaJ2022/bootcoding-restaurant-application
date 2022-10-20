package com.bootcoding.restaurant.utils;

import java.util.HashMap;
import java.util.Random;

public class StateUtils {
    public static String[] state={"Maharashtra","Punjab","Hariyana","Delhi","Madhya pradesh","Utter prdesh"};

    /*
    *
    *
    *
    * */
    public static String getstate(){

        Random random=new Random();
        int i=random.nextInt(state.length);
        System.out.println(state[i]);
        return state[i];

    }

}

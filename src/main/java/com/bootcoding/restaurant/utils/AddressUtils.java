package com.bootcoding.restaurant.utils;

import java.util.Random;

public class AddressUtils {
    private static String[] address={"Nandanvan","Sakkardara","Omnagar","Ramnagar","ChatrapatiNagar"};
    public static String getAddress() {

        Random random=new Random();
        int i=random.nextInt(address.length);
        System.out.println(address[i]);
        return address[i];

    }

}

package com.bootcoding.restaurant.exception;

import java.util.Scanner;

public class VendorDAO {
    public void testException() throws Exception{
            Scanner sc=new Scanner(System.in);
            System.out.println("Provide Input: ");
            String data= sc.next();
            int a[]={10,20};
            a[2]=30;
            Integer number=Integer.parseInt(data);
            System.out.println("Input Number is " + number);

    }
}

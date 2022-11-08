package com.bootcoding.restaurant.exception;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ExceptionExample1 {
    public static void main(String[] args) {
        ExceptionExample1 exceptionExample1=new ExceptionExample1();
        exceptionExample1.testException();
    }
    private void testException(){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Provide Input: ");
            String data= sc.next();
            int a[]={10,20};
            a[2]=30;
            Integer number=Integer.parseInt(data);
            System.out.println("Input Number is " + number);
        }catch (NumberFormatException ex){
            System.out.println("Invalid Number Provided!");
            ex.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Array size exceeds");
        }
    }
}

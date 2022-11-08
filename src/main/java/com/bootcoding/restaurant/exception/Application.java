package com.bootcoding.restaurant.exception;

public class Application {
    public static void main(String[] args) {
        VendorService vendorService = new VendorService();
        try {
            vendorService.test();
        } catch (Exception e) {
            e.printStackTrace();
            throw new VendorServiceException(e.getMessage());
        }
    }
}

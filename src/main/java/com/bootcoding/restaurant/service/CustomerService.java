package com.bootcoding.restaurant.service;

import com.bootcoding.restaurant.dao.CustomerDAO;
import com.bootcoding.restaurant.model.Customer;
import com.bootcoding.restaurant.utils.AddressUtils;

import java.util.Date;

public class CustomerService {
    private CustomerDAO customerDAO;
    public CustomerService(){
        customerDAO=new CustomerDAO();
    }
    public void createDummyCustomers(){

        for (int i=1; i<=100;i++){
            Customer customer=new Customer();
            customer.setCustomerId(i);
            customer.setName("customer"+i);
            customer.setAddress(AddressUtils.getAddress());
            customer.setPhoneNumber(8698607379l+i);
            customer.setCity("Nagpur"+i);
            customer.setState("Maharashtra"+i);
            customer.setEmailId("customer"+i+"@gmail.com");
            customer.setCreatedAt(new Date());
            customerDAO.insertCustomer(customer);

        }
    }


}

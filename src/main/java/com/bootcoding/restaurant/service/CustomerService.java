package com.bootcoding.restaurant.service;

import com.bootcoding.restaurant.dao.CustomerDAO;
import com.bootcoding.restaurant.model.Customer;
import com.bootcoding.restaurant.utils.*;

import java.util.Date;

public class CustomerService {
    private CustomerDAO customerDAO;
    public CustomerService(){
        customerDAO=new CustomerDAO();
    }

    public void createTable(){
        customerDAO.createTable();
    }
    public void createDummyCustomers(){

        for (int i=1; i<=100;i++){
            Customer customer=new Customer();
            customer.setCustomerId(i);
            customer.setName(NamesUtils.getNames());
            customer.setAddress(AddressUtils.getAddress());
            customer.setPhoneNumber(8698607379l+i);
            customer.setCity(CityUtils.getCity());
            customer.setState("Maharashtra");
            customer.setEmailId(EmailUtils.getEmail(customer.getName()));
            customer.setCreatedAt(new Date());
            customerDAO.insertCustomer(customer);

        }
    }


}

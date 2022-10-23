package com.bootcoding.restaurant.app;

import com.bootcoding.restaurant.dao.*;
import com.bootcoding.restaurant.model.Customer;
import com.bootcoding.restaurant.model.MenuItem;
import com.bootcoding.restaurant.model.Order;
import com.bootcoding.restaurant.model.Vendor;
import com.bootcoding.restaurant.service.CustomerService;
import com.bootcoding.restaurant.utils.EmailUtils;
import com.bootcoding.restaurant.utils.NamesUtils;
import com.bootcoding.restaurant.utils.NumberGenerator;

import javax.lang.model.element.Name;
import java.util.Date;

public class Application {


    public static void main(String[] args) {

        CustomerService customerService=new CustomerService();

        customerService.createTable();
        customerService.createDummyCustomers();

//        VendorDAO vendorDAO=new VendorDAO();
//        vendorDAO.createTable();

//        MenuItemDAO menuItemDAO=new MenuItemDAO();
//        menuItemDAO.createTable();

//        OrderDAO orderDAO=new OrderDAO();
//        orderDAO.createTable();

//        OrderMenuItemDAO orderMenuItemDAO=new OrderMenuItemDAO();
//        orderMenuItemDAO.createTable();

    }







    public void testData() {
        Customer customer1 = new Customer();
        customer1.setName(NamesUtils.getNames());
        customer1.setCity("Nagpur");
        customer1.setAddress("New Nandanwan, Nagpur");
        customer1.setState("Maharashtra");
        customer1.setEmailId(EmailUtils.getEmail(NamesUtils.getNames()));
        customer1.setPhoneNumber(9090909090L);

        System.out.println(" Customer Details: ");
        System.out.println("Name : " + customer1.getName());
        System.out.println("City : " + customer1.getCity());
        System.out.println("Address : " + customer1.getAddress());
        System.out.println("State : " + customer1.getState());
        System.out.println("Email Id : " + customer1.getEmailId());
        System.out.println("Phone : " + customer1.getPhoneNumber());

        Vendor haldiram = new Vendor();
        haldiram.setName("Haldiram Veg Restaurant");
        haldiram.setAddress("Ajni Square, Nagpur");
        haldiram.setCategory("VEG");
        haldiram.setPhoneNumber(0712223344);
        haldiram.setRating(5.0);
        haldiram.setState("Maharashtra");
        haldiram.setCity("Nagpur");

        System.out.println("Vendor Details:");
        System.out.println("Name: " + haldiram.getName());
        System.out.println("Address : " + haldiram.getAddress());
        System.out.println("Category : " + haldiram.getCategory());
        System.out.println("Phone : " + haldiram.getPhoneNumber());
        System.out.println("Rating : " + haldiram.getRating());
        System.out.println("State : " + haldiram.getState());
        System.out.println("City : " + haldiram.getCity());

        Order order = new Order();
        order.setCustomer(customer1);
        order.setVendor(haldiram);
        order.setTotalAmount(999.00);
        order.setOrderDate(new Date());
        order.setDeliveryAddress("101, Civil Lines, Nagpur");

        System.out.println("Order Details: ");
        System.out.println("Total Amount: " + order.getTotalAmount());
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Order Delivery Address : " + order.getDeliveryAddress());

    }
}



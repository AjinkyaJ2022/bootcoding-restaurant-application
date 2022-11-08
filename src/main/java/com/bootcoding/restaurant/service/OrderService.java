package com.bootcoding.restaurant.service;

import com.bootcoding.restaurant.dao.OrderDAO;
import com.bootcoding.restaurant.model.Order;
import com.bootcoding.restaurant.model.Vendor;

public class OrderService {
    private OrderDAO orderDAO;
    public OrderService(){
        orderDAO=new OrderDAO();
    }
    public void createTable(){
        orderDAO.createTable();
    }
    public void createDummyOrder(){
        /*for (int i=1;i<=100; i++){
            Order order=new Order();
            order.setOrderId(i + 1);
            order.setVendor(Vendor.build());
            order.setCustomer(CustomerBuilder.build());
            order.setOrderDate(new Date());
            order.setOrderStatus(OrderStatusGenerator.getStatus());
            order.setDeliveryAddress(order.getCustomer().getAddress());
        }*/
    }
}

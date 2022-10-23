package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.Order;

import java.sql.*;

public class OrderDAO {
    private DAOService daoService;
    public static final String TABLE_NAME="app_order";
    public void createTable() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            Statement stmt=con.createStatement();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("CREATE TABLE IF NOT EXISTS ");
            queryBuilder.append(TABLE_NAME);
            queryBuilder.append(" ( id int8 NOT NULL, ");
            queryBuilder.append(" total_amount decimal , ");
            queryBuilder.append(" vendor_id int8 , ");
            queryBuilder.append( " customer_id int8, ");
            queryBuilder.append(" delivery_address text, ");
            queryBuilder.append(" order_date timestamp, ");
            queryBuilder.append(" order_status text, ");
            queryBuilder.append(" CONSTRAINT app_order_pkey PRIMARY KEY (id)) ");
            System.out.println(queryBuilder.toString());
            stmt.executeUpdate(queryBuilder.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        }
        public void insertOrder(Order order){
            try{
                Connection con=daoService.getConnection();
                Statement stmt=con.createStatement();
                PreparedStatement ps = con.prepareStatement("INSERT INTO "+TABLE_NAME+" VALUES(?,?,?,?,?,?,?,?)");
                ps.setLong(1,order.getOrderId());
                ps.setDouble(2,order.getTotalAmount());
                ps.setLong(3,order.getVendor().getVendorId());
                ps.setLong(4,order.getCustomer().getCustomerId());
                ps.setString(5,order.getDeliveryAddress());
                ps.setTimestamp(6,new Timestamp(order.getOrderDate().getTime()));
                ps.setString(7,order.getOrderStatus());
                ps.executeUpdate();
                con.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
}

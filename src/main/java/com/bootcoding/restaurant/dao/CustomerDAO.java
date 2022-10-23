package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.Customer;

import java.sql.*;

public class CustomerDAO {
    private DAOService daoService;
    private static final String TABLE_NAME = "app_customer";
    public CustomerDAO(){
        daoService=new DAOService();
    }


    public void createTable(){
        try{
            Connection con = daoService.getConnection();
            Statement stmt= con.createStatement();

//            String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
//                    + " ( id int8 NOT NULL, "
//                    + " name text , "
//                    + " address text , "
//                    + " phone_number text, "
//                    + " city text, "
//                    + " state text, "
//                    + " email_id text, "
//                    + " CONSTRAINT customer_pkey PRIMARY KEY (id)) ";
//            System.out.println(" Query : " + query);
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("CREATE TABLE IF NOT EXISTS ");
            queryBuilder.append(TABLE_NAME);
            queryBuilder.append(" ( id int8 NOT NULL, ");
            queryBuilder.append(" name text , ");
            queryBuilder.append(" address text , ");
            queryBuilder.append( " phone_number text, ");
            queryBuilder.append(" city text, ");
            queryBuilder.append(" state text, ");
            queryBuilder.append(" email_id text, ");
            queryBuilder.append("created_At timestamp, ");
            queryBuilder.append(" CONSTRAINT app_customer_pkey PRIMARY KEY (id)) ");
            System.out.println(queryBuilder.toString());
            stmt.executeUpdate(queryBuilder.toString());
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void insertCustomer(Customer customer){
        try {
            Connection con = daoService.getConnection();
            if (!daoService.exists(con, TABLE_NAME, customer.getCustomerId())) {
                Statement stmt = con.createStatement();
                PreparedStatement ps = con.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES(?,?,?,?,?,?,?,?)");
                ps.setLong(1, customer.getCustomerId());
                ps.setString(2, customer.getName());
                ps.setString(3, customer.getAddress());
                ps.setLong(4, customer.getPhoneNumber());
                ps.setString(5, customer.getCity());
                ps.setString(6, customer.getState());
                ps.setString(7, customer.getEmailId());
                ps.setTimestamp(8, new Timestamp(customer.getCreatedAt().getTime()));
                ps.executeUpdate();
                System.out.println(customer.getCustomerId() + " inserted into DB!");
            }else{
                System.out.println(customer.getCustomerId() + " already exists!");
            }
                con.close();

            }catch(Exception e){
                e.printStackTrace();
            }
        }

}

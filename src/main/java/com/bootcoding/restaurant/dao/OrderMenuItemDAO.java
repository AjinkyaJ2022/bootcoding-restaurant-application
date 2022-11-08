package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.OrderMenuItem;

import java.sql.*;

public class OrderMenuItemDAO {
    private DAOService daoService;
    public static final String TABLE_NAME="app_order_Menu_Item";

    public void createTable(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            Statement stmt=con.createStatement();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("CREATE TABLE IF NOT EXISTS ");
            queryBuilder.append(TABLE_NAME);
            queryBuilder.append(" ( id int8 NOT NULL, ");
            queryBuilder.append(" menu_item text, ");
            queryBuilder.append(" quantity int8 , ");
            queryBuilder.append(" price decimal, ");
            queryBuilder.append(" is_veg bool, ");
            queryBuilder.append(" CONSTRAINT app_order_Menu_Item_pkey PRIMARY KEY (id)) ");
            System.out.println(queryBuilder.toString());
            stmt.executeUpdate(queryBuilder.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        }
        public void insertOrderMenuItem(OrderMenuItem orderMenuItem){
        try {
            Connection con = daoService.getConnection();
            /*if (!daoService.exists(con, TABLE_NAME, orderMenuItem.getOrderMenuItemId())) {
                Statement stmt = con.createStatement();
                PreparedStatement ps = con.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES(?,?,?,?,?,?,?,?)");
                ps.setLong(1, orderMenuItem.getOrderMenuItemId());
                ps.setString(2, orderMenuItem.getMenuItem());
                ps.setLong(3, orderMenuItem.getQuantity());
                ps.setDouble(4, orderMenuItem.getPrice());
                ps.setString(5, orderMenuItem.);
                //ps.setTimestamp(6, new Timestamp(orderMenuItem.getCreatedAt().getTime()));
                ps.executeUpdate();
                System.out.println(orderMenuItem.getOrderMenuItemId() + " inserted into DB!");
            }else{
                System.out.println(orderMenuItem.getOrderMenuItemId() + " already exists!");
            }*/
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        }

}

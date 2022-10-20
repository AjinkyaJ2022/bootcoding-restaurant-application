package com.bootcoding.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class VendorDAO {
    public static final String TABLE_NAME = "app_vendor";
    public void createTable(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            Statement stmt=con.createStatement();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("CREATE TABLE IF NOT EXISTS ");
            queryBuilder.append(TABLE_NAME);
            queryBuilder.append(" ( id int8 NOT NULL, ");
            queryBuilder.append(" name text, ");
            queryBuilder.append(" address text , ");
            queryBuilder.append( " phone_no int8, ");
            queryBuilder.append(" email_id text, ");
            queryBuilder.append(" city text, ");
            queryBuilder.append(" state text, ");
            queryBuilder.append("pure veg int8, ");
            queryBuilder.append("category text, ");
            queryBuilder.append("rating int8, ");
            queryBuilder.append(" CONSTRAINT order_pkey PRIMARY KEY (id)) ");
            System.out.println(queryBuilder.toString());
            stmt.executeUpdate(queryBuilder.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        }
}

package com.bootcoding.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MenuItemDAO {

    private DAOService daoService;
    public static final String TABLE_NAME="app_Menu_Item";

    public void createTable(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            Statement stmt=con.createStatement();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("CREATE TABLE IF NOT EXISTS ");
            queryBuilder.append(TABLE_NAME);
            queryBuilder.append(" ( id int8 NOT NULL, ");
            queryBuilder.append(" menu_item text, ");
            queryBuilder.append(" price decimal, ");
            queryBuilder.append(" category text, ");
            queryBuilder.append(" is_veg bool, ");
            queryBuilder.append(" CONSTRAINT app_Menu_Item_pkey PRIMARY KEY (id)) ");
            System.out.println(queryBuilder.toString());
            stmt.executeUpdate(queryBuilder.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

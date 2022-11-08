package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.MenuItem;

import java.sql.*;

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
    public void insertMenuItem(MenuItem menuItem){
        try{
            Connection con = daoService.getConnection();
            if (!daoService.exists(con, TABLE_NAME, menuItem.getMenuItemId())) {
                Statement stmt = con.createStatement();
                PreparedStatement ps = con.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES(?,?,?,?,?,?,?,?)");
                ps.setLong(1, menuItem.getMenuItemId());
                ps.setString(2, menuItem.getMenuItem());
                ps.setDouble(3, menuItem.getPrice());
                ps.setString(4, menuItem.getCategory());
                //ps.setString(5, menuItem.get));
                //ps.setTimestamp(6, new Timestamp(menuItem.getCreatedAt().getTime()));
                ps.executeUpdate();
                System.out.println(menuItem.getMenuItemId() + " inserted into DB!");
            }else{
                System.out.println(menuItem.getMenuItemId() + " already exists!");
            }
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
    //}
//}

package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.Vendor;

import java.sql.*;

public class VendorDAO {
    private DAOService daoService;
    public static final String TABLE_NAME = "app_vendor";
    public VendorDAO(){
        daoService=new DAOService();
    }
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
            queryBuilder.append("pure_veg bool, ");
            queryBuilder.append("category text, ");
            queryBuilder.append("rating int8, ");
            queryBuilder.append(" CONSTRAINT app_vendor_pkey PRIMARY KEY (id)) ");
            System.out.println(queryBuilder.toString());
            stmt.executeUpdate(queryBuilder.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        }
        public void insertVendor(Vendor vendor){
        try {
            Connection con = daoService.getConnection();
            if (!daoService.exists(con, TABLE_NAME, vendor.getVendorId())) {
            Statement stmt = con.createStatement();
            PreparedStatement ps = con.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES(?,?,?,?,?,?,?,?)");
            ps.setLong(1, vendor.getVendorId());
            ps.setString(2, vendor.getName());
            ps.setString(3, vendor.getAddress());
            ps.setLong(4, vendor.getPhoneNumber());
            ps.setString(5, vendor.getEmailId());
            ps.setString(6, vendor.getCity());
            ps.setString(7, vendor.getState());
            ps.setString(8, vendor.getCategory());
            ps.setDouble(9, vendor.getRating());
            //ps.setTimestamp(10, new Timestamp(vendor.getCreateAt().getTime()));
            ps.executeUpdate();
                System.out.println(vendor.getVendorId() + " inserted into DB!");
            }else{
                System.out.println(vendor.getVendorId() + " already exists!");
            }
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        }

}

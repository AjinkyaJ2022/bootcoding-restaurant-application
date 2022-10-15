package com.bootcoding.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOService {
    public static void main(String[] args) {
        DAOService d1=new DAOService();
        d1.getEmp();
    }

    public void getEmp(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            Statement stmt=con.createStatement();
               ResultSet resultSet = stmt.executeQuery("select * from emp");
               while(resultSet.next()){
                  String name= resultSet.getString("ename");
                   System.out.println(name);
               }
        }
        catch (Exception e){
            e.printStackTrace();
        }







    }
}

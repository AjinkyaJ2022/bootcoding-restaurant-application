package com.bootcoding.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOService {
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            return con;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean exists(Connection con, String tableName, long id) {
        try {
            Statement stmt = con.createStatement();
            String sql = "Select * from " + tableName + " where id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

//    public void getEmp(){
//        try{
//            Class.forName("org.postgresql.Driver");
//            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
//            Statement stmt=con.createStatement();
//               ResultSet resultSet = stmt.executeQuery("select * from emp");
//               while(resultSet.next()){
//                  String name= resultSet.getString("ename");
//                   int employno= resultSet.getInt("empno");
//                   String job= resultSet.getString("job");
//                   int manager= resultSet.getInt("manager");
//                   int salary= resultSet.getInt("sal");
//                   int commision= resultSet.getInt("comm");
//                   int deptno= resultSet.getInt("deptno");
//
//                   System.out.println("Employee Name :"+name);
//                   System.out.println(employno);
//                   System.out.println(job);
//                   System.out.println(manager);
//                   System.out.println(salary);
//                   System.out.println(commision);
//                   System.out.println(deptno);
//               }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

    //    }
//    public void getsal(){
//        try{
//            Class.forName("org.postgresql.Driver");
//            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
//            Statement stmt=con.createStatement();
//            ResultSet resultSet = stmt.executeQuery("select * from emp where sal>=1000 and sal<=3000");
//            while(resultSet.next()){
//                String name= resultSet.getString("ename");
//                int employno= resultSet.getInt("empno");
//                String job= resultSet.getString("job");
//                int manager= resultSet.getInt("manager");
//                int salary= resultSet.getInt("sal");
//                int commision= resultSet.getInt("comm");
//                int deptno= resultSet.getInt("deptno");
//
//                System.out.println("Employee Name :"+name);
//                System.out.println(employno);
//                System.out.println(job);
//                System.out.println(manager);
//                System.out.println(salary);
//                System.out.println(commision);
//                System.out.println(deptno);
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
    public void getdeptno() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from emp where deptno =10 or deptno =20;");
            while (resultSet.next()) {
                String name = resultSet.getString("ename");
                int employno = resultSet.getInt("empno");
                String job = resultSet.getString("job");
                int manager = resultSet.getInt("manager");
                int salary = resultSet.getInt("sal");
                int commision = resultSet.getInt("comm");
                int deptno = resultSet.getInt("deptno");

                System.out.println("Employee Name :" + name);
                System.out.println(employno);
                System.out.println(job);
                System.out.println(manager);
                System.out.println(salary);
                System.out.println(commision);
                System.out.println(deptno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

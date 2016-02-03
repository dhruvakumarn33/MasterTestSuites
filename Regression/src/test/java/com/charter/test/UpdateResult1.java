package com.charter.test;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class UpdateResult1 {
 
     public boolean InsertStatus(String s) throws Exception
     {
         
         try {
                              Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e)
            {
                              System.out.println("Where is your Oracle JDBC Driver?");
                              e.printStackTrace();
                              return false;
            }
           
            System.out.println("Oracle JDBC Driver Registered!");
            Connection connection = null;
 
                              try {
                                             connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.27.42:1521:cmnty01d_1", "automation","Charter#123");
 
                    } catch (SQLException e) 
                    {
                        System.out.println("Connection Failed! Check output console");
                                             e.printStackTrace();
                                             return false;
                    }
 
                              if (connection != null) {
                                             System.out.println("DB connection is successful");
                        return true;
                              } else {
                                             System.out.println("Failed to make connection!");
                        return false;
                              }
     }
    public static void main(String[] argv)
    {
        UpdateResult1 u=new UpdateResult1();
         try {
             if (u.InsertStatus("str"))
             {
                 System.out.println("Passed");
             }} catch (Exception ex) {
             Logger.getLogger(UpdateResult.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}


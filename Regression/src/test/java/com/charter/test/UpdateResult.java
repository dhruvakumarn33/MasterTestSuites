package com.charter.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Simple Java Program to connect Oracle database by using Oracle JDBC thin driver
 * Make sure you have Oracle JDBC thin driver in your classpath before running this program
 * @author
 */
public class UpdateResult {
	
	private static boolean UpdateTestResult(char[] sql1) throws SQLException
	{
		System.out.println("Current");
		//URL of Oracle database server
        String url = "jdbc:oracle:thin:@192.168.27.42:1521:cmnty01d_1"; 
      
        //properties for creating connection to Oracle database
        Properties props = new Properties();
        props.setProperty("user", "automation");
        props.setProperty("password", "Charter#123");
        try
        {
        	//creating connection to Oracle database using JDBC
            Connection conn = DriverManager.getConnection(url,props);

            String sql ="select sysdate as current_day from dual";

            //creating PreparedStatement object to execute query
            PreparedStatement preStatement = conn.prepareStatement(sql);
        
            ResultSet result = preStatement.executeQuery();
          
            while(result.next()){
                System.out.println("Current Date from Oracle : " +  result.getString("current_day"));
            }
    		return true;

        } catch (Exception e)
        {
        	return false;
        }
	}

    public static void main(String args[]) throws SQLException {
        //URL of Oracle database server
        String url = "jdbc:oracle:thin:@192.168.27.42:1521:cmnty01d_1"; 
      
        //properties for creating connection to Oracle database
        Properties props = new Properties();
  /*      props.setProperty("user", "test");
        props.setProperty("password", "Deloitte#123");*/
        props.setProperty("user", "automation");
        props.setProperty("password", "Charter#123");
      
        //creating connection to Oracle database using JDBC
        Connection conn = DriverManager.getConnection(url,props);

        String sql ="select sysdate as current_day from dual";

        //creating PreparedStatement object to execute query
        PreparedStatement preStatement = conn.prepareStatement(sql);
    
        ResultSet result = preStatement.executeQuery();
      
        while(result.next()){
            System.out.println("Current Date from Oracle : " +  result.getString("current_day"));
        }
        System.out.println("done");
      
    }
}

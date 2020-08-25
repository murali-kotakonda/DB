package com.mnp.jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestOracleDBConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection = null;
		try {
			//1. Loading the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.get the connection obj
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName= "scott";
			String password = "tiger";
			  connection = DriverManager.getConnection(dbUrl, userName, password);
			
			if(connection==null){
				System.out.println("DB connectn failed");
			}else{
				System.out.println("DB connectn success");
			}
			
		} catch (Exception e) {
			System.out.println("Errr  :"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				connection.close();
				System.out.println("DB Release success");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}

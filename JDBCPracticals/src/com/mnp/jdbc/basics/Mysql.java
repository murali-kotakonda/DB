package com.mnp.jdbc.basics;

package com.mnp.jdbc.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {

	static Connection con = null;

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName();  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sonoo","root","root");
			
			String driverClassName = "com.mysql.jdbc.Driver";
			String connStr = "jdbc:mysql://localhost:3306/db";
			String userName = "root";
			String password = "root";
			
			//load class using driverClassName
			Class.forName(driverClassName);
			//get conn obj using connStr + userName +password
			con = DriverManager.getConnection(connStr, userName, password);
			
			// C R U D 
			System.out.println("connection success");
		} catch (Exception e) {
			System.out.println("error  :" + e.getMessage());
		}
		if(con==null){
			System.out.println("conn failed");
		}else{
			System.out.println("conn sucess");
		}
		con.close();
	}

	public static Connection getConnection() {
		// 1. Loading the Driver
		try {
			String driverClassName = "oracle.jdbc.driver.OracleDriver";
			String connStr = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "scott";
			String password = "oracle";
			
			//load class using driverClassName
			Class.forName(driverClassName);
			//get conn obj using connStr + userName +password
			con = DriverManager.getConnection(connStr, userName, password);
		} catch (Exception e) {
			System.out.println("error  :" + e.getMessage());
		}
		return con;
	}
	  
	public static int executeQuery(String sql) {
		int res = 0;
		try {
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			res = st.executeUpdate(sql);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return res;
	}

	public static ResultSet getResult(String sql) {
		ResultSet rs = null;
		try {
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static void closeConnection() {
		// 1. Loading the Driver
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("error  :" + e.getMessage());
		}
	}

}

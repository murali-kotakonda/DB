package com.mnp.jdbc.basics;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestReadAll {
	public static void main(String[] args) {
		String readByNameQuery = 
				 "Select * from Employee";
		ResultSet rs = JDBCUtils.getResult(readByNameQuery);
		try {
			if(rs!=null){
				System.out.println("-------\n Printing ALL rows--------------");
				while(rs.next()){
					//get columns for every row
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int salary = rs.getInt("salary");
					System.out.println(id +", " + name +", "+salary);
				}
				System.out.println("\n -----------  Printing ALL rows end ---------------");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtils.closeConnection();
		}
	}
}

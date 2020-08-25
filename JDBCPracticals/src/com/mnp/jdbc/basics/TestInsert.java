package com.mnp.jdbc.basics;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestInsert {
	public static void main(String[] args) {
		String insertQuery = 
				 "  <insert query here> ";
		int res = JDBCUtils.executeQuery(insertQuery);
		if(res==0){
			System.out.println("insert failed");
		}else{
			System.out.println("insert succes");
		}
		
	}
}
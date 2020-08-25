package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestDelete {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("enter employee details to sva einto db");

				System.out.println("enter currenet id:");
				int id = sc.nextInt();

				//1. loading driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2. get conn obj
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"scott",
						"oracle");
				 
				String sql ="DELETE FROM USERINFODEMO WHERE ID= ?";
				//3. get statement obj
				PreparedStatement st = con.prepareStatement(sql);

				st.setInt(1, id);
				
				//5. delete
				int count =st.executeUpdate();
				if(count>0){
					System.out.println("deleted");
				}else{
					System.out.println("delete failed");
				}
				
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException ");
			}
			 catch (SQLException ex) {
				 System.out.println("SQLException :"+ex.getMessage());
			}

	}

}

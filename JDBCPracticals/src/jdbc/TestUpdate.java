package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;
			try {
				Scanner sc = new Scanner(System.in);

				System.out.println("enter id:");
				int id = sc.nextInt();

				System.out.println("enter new name:");
				String name = sc.next();
				
				//1. loading driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2. get conn obj
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"scott",
						"oracle");
				 
				String sql ="Update USERINFODEMO SET NAME=? WHERE ID=?";
				
				//3. get statement obj
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, name);
				st.setInt(2, id);
				
				//5. update
				int count =st.executeUpdate();
				if(count>0){
					System.out.println("updated");
				}else{
					System.out.println("update failed");
				}
				
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException ");
			}
			 catch (SQLException ex) {
				 System.out.println("SQLException :"+ex.getMessage());
			}finally{
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						System.out.println("error while closing conn");
					}
				}
			
			}
	}

}

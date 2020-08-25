package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestTransactionInsert {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		testMultiInsert();

	}

	private static void testMultiInsert() throws SQLException {
		Connection con = null;
			try {
				//1. loading driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2. get conn obj
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"scott",
						"tiger");
				con.setAutoCommit(false);
				//3. get statement obj
				Statement st = con.createStatement();
				
				Scanner sc = new Scanner(System.in);
				System.out.println("enter employee details to sva einto db");
				System.out.println("enter name:");
				String name = sc.next();
				
				
				System.out.println("enter id:");
				int id = sc.nextInt();
				
				System.out.println("enter sal:");
				int sal = sc.nextInt();
				
				//query:1
				
				st.executeUpdate("insert into " +
						"employee " +
						"values" +
						"("+id+",'"+name+"',"+sal+")");
				//query:2
				
				st.executeUpdate("insert into " +
						"employee " +
						"values" +
						"(12345,'testuser1',1234)");
				
				//query:3
				
				st.executeUpdate("insert into " +
						"employee " +
						"values" +
						"(123445,'testuser2',1234)");
				
				con.commit();
			 
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException ");
			}
			 catch (SQLException ex) {
				 System.out.println("SQLException :"+ex.getMessage());
				 try {
					con.rollback();
				} catch (SQLException e) {
				}
			}finally{
				if(con!=null){
					try {
						con.close();
					} catch (SQLException e) {
						System.out.println("error while closing conn");
					}
				}
			}
			CallableStatement prepareCall = con.prepareCall("{call performRegistration(?,?)}");
			prepareCall.setString(1, "krish");
			prepareCall.setString(2, "adada");
			
			prepareCall.execute();
			
	}

}

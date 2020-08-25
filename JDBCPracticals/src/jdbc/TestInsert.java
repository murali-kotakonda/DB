package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestInsert {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
	//insertWithStatementObj();
	insertWithPreparedStatementObj();

	}

	private static void insertWithPreparedStatementObj() throws SQLException {
		Connection con = null;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter employee details ");
			System.out.println("enter name:");
			String name = sc.next();

			System.out.println("enter id:");
			int id = sc.nextInt();

			System.out.println("enter age:");
			int age = sc.nextInt();
			
			// 1. loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. get conn obj
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"tiger");

			// 3. get statement obj
			String sql = "INSERT INTO USERINFODEMO(ID, NAME, AGE) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);


			//3-a provide data to query
			st.setInt(1, id);
			st.setString(2, name);
			st.setInt(3, age);

			// 4. insert
			int count = st.executeUpdate();
			if (count ==1) {
				System.out.println("data inserted");
			} else {
				System.out.println("insertion failed");
			}

			con.commit();

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException ");
		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
			}
			System.out.println("SQLException :" + ex.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("error while closing conn");
				}
			}
		}
	}

	private static void insertWithStatementObj() {
		Connection con = null;
		Statement st = null;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter user details to save into db");
			System.out.println("enter name:");
			String name = sc.next();

			System.out.println("enter id:");
			int id = sc.nextInt();

			System.out.println("enter age:");
			int age = sc.nextInt();
			
			
			// 1. loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. get conn obj
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "oracle");
			
			// 3. get statement obj
			st = con.createStatement();

			// 4. insert
			String sql = "INSERT INTO USERINFODEMO (ID, NAME, AGE)"
					+ "VALUES ('"+id+"', '"+name+"', "+age+")";
			

			int count = st.executeUpdate(sql);
			if (count > 0) {
				System.out.println("data inserted");
			} else {
				System.out.println("insertion failed");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException ");
		} catch (SQLException ex) {
			System.out.println("SQLException :" + ex.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				System.out.println("error while closing conn");
			}
		}
	}

}

package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestSingleSelect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id:");
		int id = sc.nextInt();

		User user = null;
		Connection con = null;
		try {
			// 1. loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. get conn obj
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "scott", "oracle");
			// 3. get statement obj
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM  USERINFODEMO WHERE id=?");

			st.setInt(1, id);

			// 4. select
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setName(rs.getString("name"));
				user.setId(rs.getInt("id"));
				user.setAge(rs.getInt("age"));
				System.out.println(user);
			} else {
				System.out.println("userid not exists");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException ");
		} catch (SQLException ex) {
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

}

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestMultipleSelect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<User> emps = selectAll();
		
		/*if(emps.isEmpty()){
			System.out.println("no employess");
		}else{
			 for(Employee emp : emps){
				 System.out.println(emp);
			 }
		}
*/
	}

	private static List<User> selectAll() {
		
		Connection con = null;
		try {
			//1. loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. get conn obj
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott",
					"oracle");
			//3. get statement obj
			PreparedStatement st = con.prepareStatement
					("select * from USERINFODEMO");
			//4. select
			ResultSet rs = st.executeQuery();
			
			//create list
			List<User> users = new LinkedList<User>();
			
			//get every row
			while(rs.next()){
				//convert every row to java obj
				User user = new User();
				user.setName(rs.getString("name"));
				user.setId(rs.getInt("id"));
				user.setAge(rs.getInt("age"));
				
				//add java obj to list
				users.add(user);
			} 
			
			if(users.isEmpty()){
				System.out.println("no employess");
			}else{
				 for(User emp : users){
					 System.out.println(emp);
				 }
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException ");
		}
		 catch (SQLException ex) {
			 System.out.println("SQLException :"+ex.getMessage());
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("error while closing conn");
				}
			}
		}
		return null;
}

}

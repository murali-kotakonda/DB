1.Load the driver jar class
2.Create connection object
3.create statement obj
//statement obj is used to execute queries (insert/update/delete/read)
call executeUpdate() method for -->insert/update/delete
call executeQuery() method for --> select staements
4.Create ResultSet obj only for Read queries
5.close connection , statement, resultset




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestPostgresDBConnection {

	public static void main(String[] args) {
  
  //1. Loading the driver
		Class.forName("org.postgresql.Driver"); //driver class name
  
  //2.get the connection obj
			String dbUrl = "jdbc:postgresql://localhost:5432/postgres"; //db connection string 
			String userName= "postgres";
			String password = "Mani@4965";
			Connection  connection = DriverManager.getConnection(dbUrl, userName, password);
			
			if(connection==null){
				System.out.println("DB connectn failed");
			}else{
				System.out.println("DB connectn success");
			}
			
  }
}


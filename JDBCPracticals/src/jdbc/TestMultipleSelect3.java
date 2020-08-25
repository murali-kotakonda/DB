package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestMultipleSelect3 {

	public static void main(String[] args) throws SQLException {
		 ResultSet data1 = selectAll("select * from employeeinfo");
		 ResultSet data2 = selectAll("select * from employee");
		 compare(data1, data2);
	}

	private static ResultSet selectAll(String sql) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "oracle");
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			return rs;
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException ");
		} catch (SQLException ex) {
			System.out.println("SQLException :" + ex.getMessage());
		} finally {
		}
		return null;
	}
	

	public static void compare(ResultSet rs1, ResultSet rs2) throws SQLException {
		List<String> columns1 = getColumns(rs1);
		List<String> columns2 = getColumns(rs2);
		printDifference("employeeinfo", columns1, columns2);
		printDifference("employee", columns2, columns1);
	}

	public static List<String> getColumns(ResultSet rs) throws SQLException {
		List<String> columns = new ArrayList<String>();
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int numberOfColumns = rsMetaData.getColumnCount();

		for (int i = 1; i < numberOfColumns + 1; i++) {
			String columnName = rsMetaData.getColumnName(i);
			columns.add(columnName);
		}
		return columns;
	}

	private static void printDifference(String from, List<String> dbColumns, List<String> excelColumns) {
		List<String> missing = new ArrayList<String>();
		excelColumns.forEach(data -> {
			if (!dbColumns.contains(data)) {
				missing.add(data);
			}
		});

		if (missing.isEmpty()) {
			System.out.println("No Missing Columns from " + from);
		} else {
			System.out.println(" Missing Columns from " + from + " are:");
			missing.forEach(data -> System.out.println(data));
		}
	}


}

package com.mnp.jdbc.basics;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestCRUDOperations {
	public static void main(String[] args) {
		// 1. insert query
		Person insertPerson = new Person("krish", 45, "admin", "testDesc", "hyd");
		insertPerson(insertPerson);
		
		// 2. update query
		Person updatePerson = new Person("testuser2", 45, "admin", "testDescHyd", "hyd");
		updatePerson(updatePerson);

		// 3. read query by name
		String name = "testuser2";
		Person readPersonByName = readPersonByName(name);
		System.out.println(readPersonByName);
		
		// 4. read all
		List<Person> readAllPersons = readAllPersons();
		for(Person p : readAllPersons){
			System.out.println(p);
		}

		// 5. delete
		String delteName = "testuser1";
		
		deletePersonByName(delteName);

	}

	private static List<Person> readAllPersons() {
		List<Person> pList = new ArrayList<Person>();
		String readByNameQuery = 
				 "Select * from person";
		ResultSet rs = JDBCUtils.getResult(readByNameQuery);
		try {
			if(rs!=null){
				System.out.println("-------\n Printing ALL rows--------------");
				while(rs.next()){
					pList.add(mapResultToPerson(rs));
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
		return pList	;
	}

	private static void deletePersonByName(String name) {
		String deleteSQL = 
				 "delete from  person where name = '"+name+"' ";
		int delRes = JDBCUtils.executeQuery(deleteSQL);
		if(delRes==0){
			System.out.println("delete failed");
		}else{
			System.out.println("delete success");
		}
	}

	private static void updatePerson(Person p) {
		String updateQuery = 
				 "update person set  age = "+p.getAge()+","
				 		+ " usertype= '"+p.getUserType()+"',"
				 		+ " city='"+p.getCity()+"' ,"
				 		+ "description ='"+p.getDesc()+"' "
				 		+ " where name = '"+p.getName()+"'";
		int updateRes = JDBCUtils.executeQuery(updateQuery);
		if(updateRes==0){
			System.out.println("UPDATE failed");
		}else{
			System.out.println("update succes");
		}
	}

	private static void insertPerson(Person p) {
		String insertQuery = 
				 " insert into person values("
						+ "'"+p.getName()+"',"
				 		+ ""+p.getAge()+"    ,"
				 		+ "'"+p.getUserType()+"' ,"
				 		+ "'"+p.getDesc()+"' ,"
				 		+ "'"+p.getCity()+"') ";
		int res = JDBCUtils.executeQuery(insertQuery);
		if(res==0){
			System.out.println("insert failed");
		}else{
			System.out.println("insert succes");
		}
	}

	private static Person readPersonByName(String name) {
		Person p = null;
		String readByNameQuery = 
				 "Select * from person where name = '"+name+"'";
		ResultSet rs =JDBCUtils. getResult(readByNameQuery);
		try {
			if(rs!=null && rs.next()){
				System.out.println("\n Printing the get person by name ");
				p =  mapResultToPerson(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JDBCUtils.closeConnection();
		}
		return p;
	}

	private static Person mapResultToPerson(ResultSet rs) throws SQLException {
		Person p = new Person();
		p.setName(rs.getString("NAME"));
		p.setAge(rs.getInt("AGE"));
		p.setUserType(rs.getString("USERTYPE"));
		p.setDesc(rs.getString("DESCRIPTION"));
		p.setCity(rs.getString("CITY"));
		return p;
	}

}

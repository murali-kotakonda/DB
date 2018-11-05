package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestJoin2 {
public static void main(String[] args) {
	
	Session sessionObj = HibernateUtil.getSessionFactory().openSession();
	
	//get name, sal for the selceted employee by username
			Query listQuery = sessionObj.createQuery(
					"select userName, usersalary from Employee ");
			List<Object[]> namesAndSals = listQuery.list();
			
			for(Object[] row: namesAndSals){
				System.out.println(row[0] + "-" +row[1]);
			}
			sessionObj.close();
			
}
/*for (Object[] e : namesAndSallistByName) {
String name = (String) e[0];
int sal = (Integer) e[1];
System.out.println(name + " , " + sal);
}
*/
}

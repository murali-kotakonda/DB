package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestJoin {
public static void main(String[] args) {
	
	Session sessionObj = HibernateUtil.getSessionFactory().openSession();
	
	//get name, sal for the selceted employee by username
			int input= 2;
			Query listQuery = sessionObj.createQuery(
					"select userName, usersalary from Employee "
					+ "where Id =:id");
			listQuery.setParameter("id",2 );
			Object[] namesAndSal = (Object[])listQuery.uniqueResult();
			System.out.println(namesAndSal[0]);
			System.out.println(namesAndSal[1]);
			
			sessionObj.close();
			
}
/*for (Object[] e : namesAndSallistByName) {
String name = (String) e[0];
int sal = (Integer) e[1];
System.out.println(name + " , " + sal);
}
*/
}

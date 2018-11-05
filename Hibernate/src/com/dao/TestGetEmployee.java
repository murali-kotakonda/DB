package com.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestGetEmployee {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
			//get employee whose primary key id value = 21
			Employee emp = (Employee) session.load(Employee.class, 33);
			System.out.println(emp);
			
			Employee emp1 = (Employee) session.get(Employee.class,32 );
			System.out.println(emp1);
			 
		session.close();
	
	 
	}
}

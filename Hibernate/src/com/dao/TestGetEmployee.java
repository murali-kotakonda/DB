package com.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestGetEmployee {
	
	public static void main(String[] args) {
			// 1 +2 
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
		
			//take input
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id::");
			int id =sc.nextInt();

			//approach 1get employee whose primary key id value = id
			Employee emp = (Employee) session.load(Employee.class, id);
			if(emp==null){
		        System.out.println("invalid id");
		      }else{
		      System.out.println(emp);  
		      }
			
			//approach 2
			Employee emp1 = (Employee) session.get(Employee.class, id);
			System.out.println(emp1);
			
			session.close();
	}
}

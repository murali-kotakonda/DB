package com.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestInsertEmployee {
	public static void main(String[] args) {
		// read inputs
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name::");
		String name = sc.next();

		System.out.println("Enter sal::");
		int sal = sc.nextInt();

		
		// create entity obj with data
		Employee empObj = new Employee();
		empObj.setUserName(name);
		empObj.setUsersalary(sal);
		
		// create sf obj
		SessionFactory sf = HibernateUtil.getSessionFactory();

		// crate session obj
		Session sessionObj = sf.openSession();

	
		//create transaction obj
		Transaction transaction = sessionObj.getTransaction();
		
		//open txn
		transaction.begin();
		//save the entity obj in table
		sessionObj.save(empObj);
		//commit txn
		transaction.commit();
		
		System.out.println("data saved");
		sessionObj.close();

	}
}

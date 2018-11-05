package com.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestBulkInsertEmployee {
	public static void main(String[] args) {

		// create sf obj
		SessionFactory sf = HibernateUtil.getSessionFactory();

		// crate session obj
		Session sessionObj = sf.openSession();


		for (int i = 1; i <= 10; i++) {
			// read inputs
			String name = "user"+i;
			int sal = 1000+i;
			// create entity obj with data
			Employee empObj = new Employee();
			empObj.setUserName(name);
			empObj.setUsersalary(sal);
			// create transaction obj
			Transaction transaction = sessionObj.getTransaction();

			// open txn
			transaction.begin();
			// save the entity obj in table
			sessionObj.save(empObj);
			// commit txn
			transaction.commit();

		}
		
		System.out.println("data saved");
		sessionObj.close();

	}
}

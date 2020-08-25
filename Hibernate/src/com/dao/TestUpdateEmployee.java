package com.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestUpdateEmployee {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// 3.read inputs
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name::");
		String name = sc.next();

		System.out.println("Enter sal::");
		int sal = sc.nextInt();

		// create emp obj
		System.out.println("enter id");
		int id = sc.nextInt();

		Employee emp = new Employee(id, name, sal);

		// perform update operation
		session.getTransaction().begin();
		session.update(emp); // merge will update only if the state is changed
		session.getTransaction().commit();
		session.close();
	}
}

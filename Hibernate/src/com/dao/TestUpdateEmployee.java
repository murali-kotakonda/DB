package com.dao;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestUpdateEmployee {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		// create emp obj
		String name = "krishna2";
		int id = 67;
		Employee emp = new Employee(id, name);
		
		
		//perform update operation
		session.getTransaction().begin();
		session.update(emp); // merge will update only if the state is changed
		session.getTransaction().commit();
		session.close();
	}
}

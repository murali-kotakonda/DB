package com.dao;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestDeleteEmployee {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		// create emp obj
		String name = "muralidhar";
		int id = 67;
		Employee emp = new Employee(id, name);
		
		//perform update operation
		session.getTransaction().begin();
		session.delete(emp);// update only if it is chnaged
		session.getTransaction().commit();
		session.close();
	}
}

/*
 * Query updateQuery = s.createQuery(
 * "update Employee  set usersalary =:inputsal where userName=:inputUser");
 * updateQuery.setParameter("inputsal",inputSal );
 * updateQuery.setParameter("inputUser",inputUser ); int updateRes =
 * updateQuery.executeUpdate(); System.out.println(updateRes);
 */
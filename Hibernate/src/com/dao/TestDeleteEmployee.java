package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestDeleteEmployee {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// create emp obj
		String name = "xyz";
		int id = 461;
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
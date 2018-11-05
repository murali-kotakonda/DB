package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestHQL {
	public static void main(String[] args) {
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		 //getAllEmps();
		//getAllEmpNames(sessionObj);
		//getAllSals(sessionObj);
		//getNameById(sessionObj);
		 //printEmpsBysal();
		// printMaxSal();
	//printNameAndSalById();
		printAllNamesAndSal();
		sessionObj.close();
	}

	private static void printAllNamesAndSal() {
		// get session obj
		Session sOj = HibernateUtil.getSessionFactory().openSession();
		// create query obj
		Query query = sOj
				.createQuery("select userName,usersalary from Employee");
		
		List<Object[]> list = (List<Object[]>) query.list();
		for (Object[] data : list) {
			String name = (String) data[0]; // userName
			Integer sal = (Integer) data[1]; // usersalary
			System.out.println(name + " - " + sal);
		}
		// close sesion obj
		sOj.close();
	}

	private static void printNameAndSalById() {
		// get session obj
		Session sOj = HibernateUtil.getSessionFactory().openSession();
		int id = 32;
		// create query obj
		Query query = sOj
	    .createQuery("select userName,usersalary from Employee where id=:inputId ");
		query.setParameter("inputId", id);
		Object[] data = (Object[]) query.uniqueResult();
		String name = (String) data[0]; // userName
		Integer sal = (Integer) data[1]; // usersalary
		System.out.println(name);
		System.out.println(sal);
		// close sesion obj
		sOj.close();
	}

	public static void printMaxSal() {
		// get session obj
		Session sOj = HibernateUtil.getSessionFactory().openSession();

		// create query obj
		Query query = sOj.createQuery("select max(usersalary) from Employee");
		Integer maxSal = (Integer) query.uniqueResult();
		System.out.println(maxSal);

		// close sesion obj
		sOj.close();
	}

	public static void printEmpsBysal() {
		// get session obj
		Session sOj = HibernateUtil.getSessionFactory().openSession();
		// input value
		int minSal = 1006;

		// create query obj
		Query query = sOj
				.createQuery("select userName from Employee where usersalary >= :myInput");
		query.setParameter("myInput", minSal);
		// execute query
		List<String> myData = (List<String>) query.list();

		for (String name : myData) {
			System.out.println(name);
		}

		// close sesion obj
		sOj.close();
	}

	private static void getNameById(Session sessionObj) {
		// get name for a given empid
		int id = 26;
		Query query = sessionObj
				.createQuery("select userName from Employee where Id=:inputEmpId");
		query.setParameter("inputEmpId", id);
		String userName = (String) query.uniqueResult();
		System.out.println(userName);
	}

	private static void getAllEmpNames(Session sessionObj) {
		// get all names from employeee
		Query query = sessionObj.createQuery("select userName from Employee");
		List<String> names = query.list();
		for (String name : names) {
			System.out.println(name);
		}
	}

	private static void getAllSals(Session sessionObj) {
		// get all names from employeee
		Query query = sessionObj.createQuery("select usersalary from Employee");
		List<Integer> names = query.list();
		for (Integer name : names) {
			System.out.println(name);
		}
	}

	private static void getAllEmps() {
		// get all employees in table
		Session sessionObj = HibernateUtil.
				getSessionFactory().openSession();
		Query query = sessionObj.createQuery("from Employee");
		List<Employee> list = query.list();
		for (Employee e : list) {
			System.out.println(e);
		}
		sessionObj.close();
	}
}

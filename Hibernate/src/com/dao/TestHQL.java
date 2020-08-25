package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
//get sal by id
//get name by id
//get all sal
//get all names

public class TestHQL {
	public static void main(String[] args) {
		
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		//getAllEmps();
		//getAllEmpNames();
		//getAllSals();
		//getNameById();
		 //printEmpsBysal();
		printMaxSal();
		//printNameAndSalById();
		//printAllNamesAndSal();
		sessionObj.close();
	}
	
	private static void getAllEmps() {

		// get all employees in table
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		// create query objecet
		Query query = sessionObj.createQuery("from Employee");

		// call list() method as we need to retrieve multiple rows
		// hibernate converts every row to employee object
		// every employee obj is added to the arrylist.
		List<Employee> list = query.list();

		// use for loop to show all emps
		for (Employee e : list) {
			System.out.println(e);
		}

		// close session
		sessionObj.close();

	}
	
	
	private static void getAllEmpNames() {
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		// get all names from employeee
		Query query = sessionObj.createQuery("select userName from Employee");
		List<String> names = query.list();
		for (String name : names) {
			System.out.println(name);
		}
		sessionObj.close();
	}
	
	
	private static void getAllSals() {
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		// get all names from employeee
		Query query = sessionObj.createQuery("select usersalary from Employee");
		List<Integer> salaries = query.list();
		for (Integer salary : salaries) {
			System.out.println(salary);
		}
		sessionObj.close();
	}
	
	private static void getEmpById() {
		// get name for a given empid
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		Query query = sessionObj
				.createQuery(" from Employee where Id=60");
		Employee emp = (Employee) query.uniqueResult();
		System.out.println(emp);
		sessionObj.close();
	}
	private static void getEmpById1() {
		// get name for a given empid
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		int id = 60;
		Query query = sessionObj
				.createQuery(" from Employee where Id=:inputEmpId");
		query.setParameter("inputEmpId", id);
		Employee emp = (Employee) query.uniqueResult();
		System.out.println(emp);
		sessionObj.close();
	}
	
	private static void getNameById0() {
		// get name for a given empid
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		Query query = sessionObj
				.createQuery("select userName from Employee where Id=60");
		String userName = (String) query.uniqueResult();
		System.out.println(userName);
		sessionObj.close();
	}
	
	
	private static void getNameById() {
		// get name for a given empid
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		int id = 60;
		Query query = sessionObj
				.createQuery("select userName from Employee where Id=:inputEmpId");
		query.setParameter("inputEmpId", id);
		String userName = (String) query.uniqueResult();
		System.out.println(userName);
		sessionObj.close();
		
		/*
		 SQL: SELECT NAME FROM EMPLOYEE WHERE ID=90
how many rows? 1 row     -> use uniqueResult()
how many columns? 1 column  (name)
what is the column datatype --> string
the return type of uniqueResult() method is integer
		 */
	}

	private static void getNameById2() {
		// get name for a given empid
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		int id = 181;
		Query query = sessionObj
				.createQuery("select userName from Employee where Id=?");
		query.setParameter(0, id);
		String userName = (String) query.uniqueResult();
		System.out.println(userName);
		sessionObj.close();
	}
	
	//get salary based on id
	//get salary based on name
	//get emp names whose salary >5000
	//get employee name who has max salary
	//get employee name who has main salary

	public static void printEmpsBysal() {
		Session sOj = HibernateUtil.getSessionFactory().openSession();
		int minSal = 5000;
		Query query = sOj
				.createQuery("select userName from Employee where usersalary >= :myInput");
		query.setParameter("myInput", minSal);
		List<String> myData = (List<String>) query.list();
		for (String name : myData) {
			System.out.println(name);
		}
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
		/*
		 
	SQL: SELECT max(salary) FROM EMPLOYEE 
	how many rows? 1 row     -> use uniqueResult()
	how many columns? 1 column  (name)
	what is the column datatype --> integer
	the return type of uniqueResult() method is integer
		 */
	}
	
	public static void printMinSal() {
		// get session obj
		Session sOj = HibernateUtil.getSessionFactory().openSession();

		// create query obj
		Query query = sOj.createQuery("select min(usersalary) from Employee");
		Integer maxSal = (Integer) query.uniqueResult();
		System.out.println(maxSal);

		// close sesion obj
		sOj.close();
	}
	
	private static void printNameAndSalById() {
		// get session obj
		Session sOj = HibernateUtil.getSessionFactory().openSession();
		int id = 189;
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

/*
		 
	SQL: select userName,usersalary from Employee
	how many rows? multi row     -> use list()
	how many columns in every row? 2 columns  (name, salary)
	what is the column datatype --> string + integer 
	the return type of list() method is 
	List of Object[] array,
	every row is converted to Object[]
  			where objec[0] contains name
  			object[1] contain ssalary
		 */
	
	
	
	
	
}

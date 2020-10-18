package com.dao.hqlEx;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
//get sal by id
//get name by id
//get all sal
//get all names

import com.dao.Employee;
import com.dao.HibernateUtil;

public class TestHQL {
	public static void main(String[] args) {
		
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		//getAllEmps();
		//getAllEmpNames();
		//getAllSals();
		//getEmpById() ;
		// getEmpById1();
		//getNameById();
		 //printEmpsBysal();
		//printMaxSal();
		//printNameAndSalById();
		printAllNameAndSalNewwwwww();
		
		//printAllNamesAndSal();
		sessionObj.close();
	}
	
	/**
	 Req :   get all employees from EmployeeDetails table
	 HQL :from Employee
	 use q.list()  
	 */
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

	}
	
	/**
	 Req :   get all employee names from EmployeeDetails table
	 HQL :select userName from Employee
	 use q.list()  
	 */
	
	private static void getAllEmpNames() {
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		Query query = sessionObj.createQuery("select userName from Employee");
		List<String> names = query.list();
		for (String name : names) {
			System.out.println(name);
		}
		sessionObj.close();
	}
	
	
	/**
	 Req :   get all employee salaries from EmployeeDetails table
	 HQL :select usersalary from Employee
	 use q.list()  
	 */
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
	
	/**
	 Req :   get employee by id = 60 
	 HQL :   from Employee where Id=60
	   use query.uniqueResult()
	 */
	private static void getEmpById() {
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		Query query = sessionObj
				.createQuery(" from Employee where id=50");
		Employee emp = (Employee) query.uniqueResult();
		System.out.println(emp);
	}
	/**
	 Req :   get employee by taking id as input
	 HQL :   from Employee where Id=inputid
	   use query.uniqueResult()
	   
	    //dont provide input ; provide using the place holders : use this appraoch to avoid sql injection
  Query query = sessionObj
				.createQuery(" from Employee where Id=:inputEmpId");
		query.setParameter("inputEmpId", id);
		
   
   //provide input directly to query   : Dont use this approach as this can lead to sql injection
		Query query1 = sessionObj
				.createQuery(" from Employee where Id="+id);
       
	 */
       
	private static void getEmpById1() {
		// get name for a given empid
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id::");
		int id = sc.nextInt();
		
		Query query = sessionObj
				.createQuery(" from Employee where id=:inputEmpId");
		query.setParameter("inputEmpId", id);
		
		// Query query1 = sessionObj.createQuery(" from Employee where id="+id);
		
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
	

	/**
	 Req :   get employee name  by taking id as input
	 HQL :    select userName from Employee where id = <input>
    USE  String userName = (String) query.uniqueResult(); -> fetches single column
	    
	*/
	
	private static void getNameById() {
		// get name for a given empid
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		System.out.println("enter id::");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		Query query = sessionObj
				.createQuery("select userName from Employee where id=:inputEmpId");
		query.setParameter("inputEmpId", id);
		String userName = (String) query.uniqueResult();
		System.out.println(userName);
		sessionObj.close();
	}
	
	
	/*
	 SQL: SELECT NAME FROM EMPLOYEE WHERE ID=90
how many rows? 1 row     -> use uniqueResult()
how many columns? 1 column  (name)
what is the column datatype --> string
the return type of uniqueResult() method is integer
	 */
	
	

	public static void getNameById2() {
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
	
	/**
	 Return of uniqueResult:
   ---------------------------
   1 column (varchar)  -> String
   1 column (Number)  -> Integer/Long
   all columns    -> Employee obj
   >1 column but < all columns   -> Object array
   
    Return of list:
   ---------------------------
   1 column (varchar)  -> List<String>
   1 column (Number)  -> List<Integer>/List<Long>
   all columns    -> List<Employee? obj
   >1 column but < all columns   -> List<Object> array
   
	 Req :   get employee name  and salary  by taking id as input
     HQL :    select userName,usersalary from Employee where id=:inputId
     use uniqueResult()
     returnType of uniqueResult() : Object row[] array
                          row[0]  -> contain name
                          row[1] -> contain salary
                          
  */
  
	
	private static void printNameAndSalById() {
		// get session obj
		Session sOj = HibernateUtil.getSessionFactory().openSession();
		System.out.println("enter id::");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		// create query obj
		Query query = sOj
	    .createQuery("select userName,usersalary from Employee where id=:inputId ");
		query.setParameter("inputId", id);
		
		Object[] row = (Object[]) query.uniqueResult();
		
		String name = (String) row[0]; // userName
		Integer sal = (Integer) row[1]; // usersalary
		System.out.println(name);
		System.out.println(sal);
	}
	
	private static void printAllNameAndSalNewwwwww() {
		// get session obj
		Session sOj = HibernateUtil.getSessionFactory().openSession();
		// create query obj
		Query query = sOj
	    .createQuery("select userName,usersalary from Employee ");
		List<Object[]> rows = (List<Object[]>) query.list();
		for(Object[] row : rows) {
			String name = (String) row[0]; // userName
			Integer sal = (Integer) row[1]; // usersalary
			System.out.println(name);
			System.out.println(sal);
		}
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

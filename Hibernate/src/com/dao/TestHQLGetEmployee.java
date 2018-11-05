package com.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestHQLGetEmployee {
	
	public static void main(String[] args) {
		
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		
		//Get all emps
		Query query = sessionObj.createQuery("from Employee");
		List<Employee> list = query.list();
		for(Employee e : list){
			System.out.println(e);
		}
		
//			//get employee whose primary key id value = 1
//			Employee emp = (Employee) 
//					sessionObj.load(Employee.class, 21);
//			System.out.println(emp);
//			
//			Employee emp1 = (Employee) sessionObj.get(Employee.class, 22);
//			System.out.println(emp1);
//			 
		/*Query query = sessionObj.createQuery("select userName,usersalary from Employee ");
		List<Object[]> datas= (List<Object[]>)query.list();
		for(Object[] data: datas){
			System.out.println(data[0] + "--"+data[1]);
		}*/
		
		
		 //get all employees in table
			/*Query query = sessionObj.createQuery("from Employee");
			List<Employee> employees = query.list();
			for(Employee e  : employees){
				System.out.println(e);
			}*/ 
		
		//get all names frok employeee
		/*Query query = sessionObj.createQuery("select userName from Employee");
		List<String> names = query.list();
		for(String name: names){
			System.out.println(name);
		}*/
		
		
		//get name for a given empid
		/*Scanner sc = new Scanner(System.in);
		System.out.println("enter the id to search:");
		int id = Integer.parseInt(sc.next()); 
		Query query = sessionObj.createQuery("select userName from Employee "
				+ "where Id=:inputEmpId");
		query.setParameter("inputEmpId", id);
		String userName= (String)query.uniqueResult();
		System.out.println(userName);
		*/
		
		//get max sal
		/*		Query query = sessionObj.createQuery("select max(usersalary) from Employee ");
		int maxsal= (int)query.uniqueResult();
		System.out.println(maxsal);
		 */		
		
		//get employee whose primary key id value = 1
	/*	Employee emp = (Employee) sessionObj.load(Employee.class, 1);
		System.out.println(emp);
		
		
		Employee emp1 = (Employee) sessionObj.get(Employee.class, 2);
		System.out.println(emp1);
	*/	 
		
	/*	
		 //get only names for all employees
		List<String> nameslist = sessionObj.createQuery("select e.userName from Employee e").list();
		for(String e  : nameslist){
			System.out.println(e);
		}
		
		
		//get name, sal for all employees
		List<Object[]> namesAndSallist = sessionObj.createQuery(
				"select userName, usersalary from Employee ").list();
		for (Object[] e : namesAndSallist) {
			String name = (String) e[0];
			int sal = (Integer) e[1];
			System.out.println(name + " , " + sal);
		}
		
	
		
		
	 	
		
		//get max salary
		Query maxQuery = sessionObj.createQuery(
				"select min(usersalary) from Employee");
		Integer maxSal = (Integer)maxQuery.uniqueResult();
		System.out.println(maxSal); 
		
*/		
		sessionObj.close();
	
	 
	}
}

package com.dao.hqlEx;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;

public class TestNamedQuery {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		//Query listQuery = s.createQuery("select userName from Employee");
		Query listQuery =s.getNamedQuery("getEmpNames");
		List<String> names = listQuery.list();
		for (String name: names) {
			System.out.println(name);
		}

		
		
		
		
		
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		//Query listEmps = s.createQuery(" from Employee");
		Query listEmps = s.getNamedQuery("empSal");
		List<Integer> emps = (List<Integer>)listEmps.list();
		for (Integer emp: emps) {
			System.out.println(emp);
		}
		s.close();
		
		
		getNamed3();
	}

	private static void getNamed3() {
		Session s = HibernateUtil.getSessionFactory().openSession();
				
				//Query listEmps = s.createQuery(" from Employee");
				Query listEmps = s.getNamedQuery("getALLEmps");
				List<Employee> emps = (List<Employee>)listEmps.list();
				for (Employee emp: emps) {
					System.out.println(emp);
				}
				s.close();
	}
}

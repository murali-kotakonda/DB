package com.dao.hqlEx;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;

public class TestNamedQuery3 {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		// Query listEmps = s.createQuery(" from Employee");//using hql
		Query listEmps = s.getNamedQuery("getALLEmps");// using named query
		List<Employee> emps = (List<Employee>) listEmps.list();
		for (Employee emp : emps) {
			System.out.println(emp);
		}
		s.close();
	}
}

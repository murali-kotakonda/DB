package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class TestNamedQuery {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		//Query listQuery = s.createQuery("select userName from Employee");
		Query listQuery =s.getNamedQuery(Employee.GET_EMP_NAMES);
		List<String> names = listQuery.list();
		for (String name: names) {
			System.out.println(name);
		}

		//Query listEmps = s.createQuery(" from Employee");
		Query listEmps = s.getNamedQuery(Employee.GET_All_EMPS);
		List<Employee> emps = (List<Employee>)listEmps.list();
		for (Employee emp: emps) {
			System.out.println(emp);
		}
		s.close();
	}
}

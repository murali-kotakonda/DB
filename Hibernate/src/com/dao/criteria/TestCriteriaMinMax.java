package com.dao.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dao.Employee;
import com.dao.HibernateUtil;


/**
 get whose salary is between 5000 and 10000
 
 steps:
 1.create criteria obj
 Criteria empCriteria = s.createCriteria(Employee.class);
 
 2. add restriction uisng betwen method
 	  empCriteria.add(Restrictions.between("usersalary", 5000, 10000));
 
 */

public class TestCriteriaMinMax {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		Criteria empCriteria = s.createCriteria(Employee.class);
		
		empCriteria.add(Restrictions.between("usersalary", 5000, 10000));
		 
		List<Employee> employees = empCriteria.list();

		for (Employee e : employees) {
			System.out.println(e);
		}
		s.close();
	}
}
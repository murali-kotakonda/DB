package com.dao.criteria;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dao.Employee;
import com.dao.HibernateUtil;


/**
 get employee whose name contains 'kumar'
 
 
 steps:
 1.create criteria obj
 Criteria empCriteria = s.createCriteria(Employee.class);
 
 2. add restriction using like method
 		String userNameLike ="kumar ;
 	  empCriteria.add(Restrictions.like("userName", "%"+userNameLike+"%"));
 
 */
public class TestCriteriaLike {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String userNameLike="kumar";

		Criteria empCriteria = session.createCriteria(Employee.class);

		 empCriteria.add(Restrictions.like("userName", "%"+userNameLike+"%"));
		// select * from EmployeeDetails where userName like '%testuser87%'

		List<Employee> employees = empCriteria.list();
		for(Employee e  : employees){
			System.out.println(e);
		}
		session.close();
	}
}
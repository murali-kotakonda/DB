package com.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
public class TestCriteriaUserNameeq {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String name="testuser87";

		Criteria empCriteria = session.createCriteria(Employee.class);

		if(name!=null  && !name.equals("") ){
			empCriteria.add(Restrictions.eq("userName", name));
			// select * from EmployeeDetails where userName ='testuser87'
		}
		
		List<Employee> employees = empCriteria.list();
		for(Employee e  : employees){
			System.out.println(e);
		}
		session.close();
	}
}
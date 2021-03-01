package com.dao.criteria;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dao.Employee;
import com.dao.HibernateUtil;
public class TestCriteriaUserNameeq {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria empCriteria = session.createCriteria(Employee.class);

		empCriteria.add(Restrictions.eq("userName", "murali"));
		// select * from EmployeeDetails where userName ='murali'
		
		List<Employee> employees = empCriteria.list();
		for(Employee e  : employees){
			System.out.println(e);
		}
		session.close();
	}
}


 class Ex5 {
	public static void main(String[] args) {
		String userName ="shanvi1";

		// get session obj
		Session s = HibernateUtil.getSessionFactory().openSession();

		// get criteria obj
		Criteria empCriteria = s.createCriteria(Employee.class);

		if(userName!=null && !userName.equals("")) {
			empCriteria.add(Restrictions.eq("userName", userName));
		}
		
		// call list method
		List<Employee> list = empCriteria.list();
		System.out.println("size = "+ list.size());
		for(Employee e: list) {
			System.out.println(e.getId() + "-"+ e.getUserName() +"-"+ e.getUsersalary());
		}
		s.close();
	}
}
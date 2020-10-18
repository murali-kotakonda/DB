package com.dao.criteria;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.dao.Employee;
import com.dao.HibernateUtil;
/**

 sort in descending order:
  ----------------------------
  pass the instance variable names not the db column names
  empCriteria.addOrder(Order.desc("id")); -> sort based on id
  empCriteria.addOrder(Order.desc("userName")); -> sort based on userName
  empCriteria.addOrder(Order.desc("usersalary")); -> sort based on usersalary
 
 
 */
public class TestCriteriaOrderBy2 {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//input can be Id , userName , usersalary
		String orderParm = "id";
		
		Criteria empCriteria = session.createCriteria(Employee.class);
		empCriteria.addOrder(Order.asc(orderParm));

		List<Employee> employees = empCriteria.list();
		for(Employee e  : employees){
			System.out.println(e);
		}
		session.close();
	}
}
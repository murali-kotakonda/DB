package com.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
public class TestCriteriaOrderBy {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//input can be Id , userName , usersalary
		String orderParm = "Id";
		String orderBy = "desc";
		Criteria empCriteria = session.createCriteria(Employee.class);

		if(!orderParm.equals(""))
		{
			if ("asc".equals(orderBy)) {
				empCriteria.addOrder(Order.asc(orderParm));
			} else if ("desc".equals(orderBy)) {
				empCriteria.addOrder(Order.desc(orderParm));
			}
		}
		List<Employee> employees = empCriteria.list();
		for(Employee e  : employees){
			System.out.println(e);
		}
		session.close();
	}
}
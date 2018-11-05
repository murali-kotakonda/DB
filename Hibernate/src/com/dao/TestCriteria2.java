package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TestCriteria2 {

	public static void main(String[] args) {
		Session  s = HibernateUtil.getSessionFactory().openSession();
		//input from customer
		String name = "";
		int minSal =0;
		int maxSal =0;
		String nameLike = "user";
		
		Criteria c1 = s.createCriteria(Employee.class);
		
		if(name!=null && !name.equals("")){
			c1.add(Restrictions.eq("userName", name));// where userName = name
		}
		
		if(nameLike!=null && !nameLike.equals("")){
			c1.add(Restrictions.like("userName", "%"+name+"%"));
			// 	where userName like '%user%';
		}
		if(minSal!=0 && maxSal!=0){
			c1.add(Restrictions.between("usersalary", minSal, maxSal));
			//userSalary >= minSal and userSalary<= maxSal
		}
		
		List<Employee> list = c1.list();
		for(Employee e: list){
			System.out.println(e);
		}
		s.close();		
	}
}

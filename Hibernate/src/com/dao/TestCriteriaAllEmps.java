package com.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
public class TestCriteriaAllEmps {
	//orderby ,username, minsal, max sal are optional
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String name="";
		String salOrderBy = "";
		String userNameLike="testuser7";
		int minSal=5575;
		int maxSal=6000;

		Criteria empCriteria = session.createCriteria(Employee.class);

		if("asc".equals(salOrderBy) ){
			empCriteria.addOrder(Order.asc("usersalary"));
		}else if("desc".equals(salOrderBy) ){
			empCriteria.addOrder(Order.desc("usersalary"));
		}
		
		if(userNameLike!=null  && !userNameLike.equals("") ){
			empCriteria.add(Restrictions.like("userName", "%"+userNameLike+"%"));
		}
		
		if(name!=null  && !name.equals("") ){
			empCriteria.add(Restrictions.eq("userName", name));
		}
		
		if (minSal != 0 && maxSal!=0) {
			empCriteria.add(Restrictions.between("usersalary", minSal, maxSal));
		}
		
		//name = 'krishna' or name is null
		empCriteria.add(Restrictions.eqOrIsNull("userName","krishna"));
		
		List<Employee> employees = empCriteria.list();
		for(Employee e  : employees){
			System.out.println(e);
		}
		session.close();
	}
}
package com.dao.criteria;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dao.Employee;
import com.dao.HibernateUtil;
/**
 Req:
	search employees 
	
	search by:
	exact username
	similar username
	salary between minsal and  maxsal
	
	orderby:
	id
	username
	usersalary

 */
public class TestCriteriaAllEmps {
	//orderby ,username, minsal, max sal are optional
	public static void main(String[] args) {
	  //inputs
		
		String name="murali"; //exact name
		String userNameLike=""; // similar name
		String salOrderBy = "desc"; //order by asc or desc
		int minSal=0; //min sal
		int maxSal=0;//max sal
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria empCriteria = session.createCriteria(Employee.class);

		if(name!=null  && !name.equals("") ){
			empCriteria.add(Restrictions.eq("userName", name));
		}
		
		
		if(userNameLike!=null  && !userNameLike.equals("") ){
			empCriteria.add(Restrictions.like("userName", "%"+userNameLike+"%"));
		}

		
		if("asc".equals(salOrderBy) ){
			empCriteria.addOrder(Order.asc("usersalary"));
		}else if("desc".equals(salOrderBy) ){
			empCriteria.addOrder(Order.desc("usersalary"));
		}

		
		if (minSal != 0 && maxSal!=0) {
			empCriteria.add(Restrictions.between("usersalary", minSal, maxSal));
		}
		
		List<Employee> employees = empCriteria.list();

		for(Employee e  : employees){
			System.out.println(e);
		}
		System.out.println(employees.size());
		session.close();
	}
}
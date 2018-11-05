package com.mnp.states;

import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;

public class TestHibStates {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();
		//Transiant state
		Employee e = new Employee();
		e.setUserName("krishnakumar123");
		e.setUsersalary(11111);
		s.save(e);	//state changes to persistance state. triggers insert query
		
		e.setUserName("krishna1564");//change the obj value during persistenc state
		s.getTransaction().commit(); // one insert query + 1 update query 
		
		s.close();//state changes to detached
		
		//transcations on the detached obj
		Session s1 = HibernateUtil.getSessionFactory().openSession();
		s1.getTransaction().begin();
		e.setUserName("krishna2");
		s1.saveOrUpdate(e);
		e.setUserName("krishna3");
		s1.getTransaction().commit();
		s1.close();
	}

}

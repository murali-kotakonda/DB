package com.mnp.inherit.manytomany;

import java.util.List;

import org.hibernate.Session;

import com.dao.HibernateUtil;
import com.mnp.oneToOne.AddressDetails;
import com.mnp.oneToOne.EmployeeWithAddress;

public class TestManyToMany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//cascade value is   all, persist
		Student st1 = new Student("krishna","employee");
		Student st2 = new Student("shyam","student");
		
		Cource c1 = new Cource("python");
		Cource c2 = new Cource("selenium");
		
		st1.getCources().add(c1);
		st1.getCources().add(c2);
		
		st2.getCources().add(c1);
		st2.getCources().add(c2);
		 
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();
		 s.save(st1);
		 s.save(st2);
		s.getTransaction().commit();
		s.close();
		
		
		
	}

}

package com.mnp.inherit.manytomany;

import java.util.ArrayList;
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
		Student st1 = new Student("belssy","employee");
		Student st2 = new Student("uma","student");
		
		Cource c1 = new Cource("hybris");
		Cource c2 = new Cource("angularjs");
		
		List<Cource> list1 = new ArrayList<>();
		list1.add(c1);
		list1.add(c2);
		st1.setCources(list1);

		List<Cource> list2 = new ArrayList<>();
		list2.add(c1);
		list2.add(c2);
		st2.setCources(list2);
		 
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();
		 s.save(st1);
		 s.save(st2);
		s.getTransaction().commit();
		s.close();
		
		
		
	}

}

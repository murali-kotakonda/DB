package com.dao.composition;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestPersonWithAddress {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();

		//create person obj
		PersonWithAddress personWithAddress = new PersonWithAddress();
		personWithAddress.setAge(28);
		personWithAddress.setName("shyam");
		
		
		//create addr obj 
		Address add = new Address();
		add.setCity("hyd");
		add.setCountry("IN");
		add.setPin(12345);
		add.setState("AP");
		add.setStreetNo("asrsf");

	
		//set the relationship between objs
		personWithAddress.setCurAddress(add);

		s.save(personWithAddress);
		s.getTransaction().commit();
		s.close();
	}
}

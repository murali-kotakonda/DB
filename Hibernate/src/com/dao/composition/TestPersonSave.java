package com.dao.composition;

import org.hibernate.Session;

import com.dao.HibernateUtil;

/**
  How to insert row in the PersonWithAddess table?
steps:
  1. Create sf
  2.create session
  3.create trasaction
  
  4.create person obj with data
  5.create addres obj with data
  6.keep address inside the person obj
  7.save person obj // one row is created in PersonWithAddess table
  
  8.commit txn
  9.close session

 
 */
public class TestPersonSave {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();

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

		session.save(personWithAddress);
		session.getTransaction().commit();
		session.close();
	}
}

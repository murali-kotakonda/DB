package com.dao.composition;

import org.hibernate.Session;

import com.dao.HibernateUtil;


/**
  How to read row from the PersonWithAddess table using person id?
steps:
  1. Create sf
  2.create session
  3.create trasaction
  
  4.call load() method for fetching the person details using the person id
    returns PersonWithAddress object
    and PersonWithAddress object internally contains address obj
  5.close session
 
 */
public class TestGetPerson {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		//make db call to fetch the person details
		PersonWithAddress person = (PersonWithAddress)s.load(PersonWithAddress.class, 1);
		System.out.println(person);

		//get the address and print
		Address curAddress = person.getCurAddress();
		curAddress.displayAddress();
		s.close();
	}

}

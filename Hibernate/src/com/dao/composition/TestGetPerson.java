package com.dao.composition;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestGetPerson {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		PersonWithAddress person = (PersonWithAddress)s.load(PersonWithAddress.class, 1);
		System.out.println(person);
		
		Address curAddress = person.getCurAddress();
		curAddress.displayAddress();
		s.close();
	}

}

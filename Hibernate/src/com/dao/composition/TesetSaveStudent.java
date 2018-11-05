package com.dao.composition;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TesetSaveStudent {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();

		StudentWithAddress student = new StudentWithAddress();
		student.setAge(28);
		student.setName("vamsi");
		student.setBranch("cse");
		
		Address add2 = new Address();
		add2.setCity("bangalore");
		add2.setCountry("INDIA");
		add2.setPin(560037);
		add2.setState("ka");
		add2.setStreetNo("Marathahhali");

		//relate objs
		student.setCurAddress(add2);
		
		s.save(student);
		
		s.getTransaction().commit();
		s.close();
	}

}

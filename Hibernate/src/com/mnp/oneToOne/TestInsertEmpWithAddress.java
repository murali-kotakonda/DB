package com.mnp.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.HibernateUtil;

public class TestInsertEmpWithAddress {
	public static void main(String[] args) {
		//withoutCascadePersist();
		withCascadePersist();
	}

	private static void withCascadePersist() {//create session factory
		SessionFactory sf = 	 new Configuration().configure().buildSessionFactory();

		//create session obj
		Session s = sf.openSession();
		
		// create address obj with data
		AddressDetails add = new AddressDetails();
		add.setCity("Hyd");
		add.setCountry("INDIA");
		add.setPin(123456);
		add.setState("TS1");
		add.setStreetNo("YUSAF GUDA12");
		
	 	// create emp obj with data
		EmployeeWithAddress emp = new EmployeeWithAddress();
		emp.setAge(34);
		emp.setName("krishna kumar12");

		// keep address obj inside emp
		emp.setCurAddress(add);

		//save employee obj
		s.getTransaction().begin();
		s.save(emp);  //1 row created in employee table  + 1 row is inserted in address table
		s.getTransaction().commit();

		s.close();}

	private static void withoutCascadePersist() {

		//create session factory
		SessionFactory sf = 	 new Configuration().configure().buildSessionFactory();

		//create session obj
		Session s = sf.openSession();
		
		// create address obj with data
		AddressDetails add = new AddressDetails();
		add.setCity("Hyd");
		add.setCountry("IN");
		add.setPin(12345);
		add.setState("TS");
		add.setStreetNo("YUSAF GUDA");
		
		// save the address obj
		s.getTransaction().begin();
		s.save(add);
		s.getTransaction().commit();

		// create emp obj with data
		EmployeeWithAddress emp = new EmployeeWithAddress();
		emp.setAge(34);
		emp.setName("krishna kumar");

		// keep address obj inside emp
		emp.setCurAddress(add);

		//save employee obj
		s.getTransaction().begin();
		s.save(emp);
		s.getTransaction().commit();

		s.close();
	}
}

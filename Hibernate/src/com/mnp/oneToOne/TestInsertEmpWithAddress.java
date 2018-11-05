package com.mnp.oneToOne;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestInsertEmpWithAddress {
	public static void main(String[] args) {
		withoutCascadePersist();
		// withCascadePersist();
	}

	private static void withCascadePersist() {
		// cascade value is all, persist
		EmployeeWithAddress emp = new EmployeeWithAddress();
		emp.setAge(28);
		emp.setName("RAMANA");

		AddressDetails address = new AddressDetails();
		address.setCity("bang");
		address.setCountry("IN");
		address.setPin(12345);
		address.setState("KA");
		address.setStreetNo("MARATHAHLLI tulasi theatre road");

		// set relatn between emp obj and address obj
		emp.setCurAddress(address);

		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();
		s.save(emp);
		s.getTransaction().commit();
		s.close();
	}

	private static void withoutCascadePersist() {
		// SAVE THE ADDRESS OBJ
		AddressDetails add = new AddressDetails();
		add.setCity("Hyd");
		add.setCountry("IN");
		add.setPin(12345);
		add.setState("UP");
		add.setStreetNo("asrsf");

		Session s = HibernateUtil.getSessionFactory().openSession();

		// SAVE ADDR DATA
		s.getTransaction().begin();
		s.save(add);
		s.getTransaction().commit();

		// cascade value is anyother other than all, persist
		// create emp obj with data
		EmployeeWithAddress emp = new EmployeeWithAddress();
		emp.setAge(28);
		emp.setName("muralidhar");

		// SET RELATNSHIP
		emp.setCurAddress(add);

		s.getTransaction().begin();
		s.save(emp);
		s.getTransaction().commit();

		s.close();
	}
}

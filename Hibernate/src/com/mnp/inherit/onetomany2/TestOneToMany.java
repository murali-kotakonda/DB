package com.mnp.inherit.onetomany2;

import java.util.List;

import org.hibernate.Session;

import com.dao.HibernateUtil;

import oneToOne.AddressDetails;
import oneToOne.EmployeeWithAddress;

public class TestOneToMany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//cascade value is   all, persist
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();

		 Customer1 cust1= new Customer1("user1",25);
		 cust1.getAccounts().add(new Accounts1("savings", "savings desc"));
		 cust1.getAccounts().add(new Accounts1("current", "current desc"));
		 cust1.getAccounts().add(new Accounts1("loan", "loan desc"));
		 
		 
		 Customer1 cust2= new Customer1("user2",25);
		 cust2.getAccounts().add(new Accounts1("loan", "loan desc"));
		 
		 s.save(cust1);
		 s.save(cust2);
		 
		s.getTransaction().commit();
		s.close();
		
		
		Session s1= HibernateUtil.getSessionFactory().openSession();
		Customer1 c =(Customer1) s1.load(Customer1.class, 1);
		c.getAge();
		 List<Accounts1> accounts = c.getAccounts();
		 System.out.println(accounts);
		s1.close();
		
	}

}

package com.mnp.inherit.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.dao.HibernateUtil;
import com.mnp.oneToOne.AddressDetails;
import com.mnp.oneToOne.EmployeeWithAddress;

public class TestOneToMany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		insertCust();
		//readCust();
	}

	private static void insertCust() {
		// cascade value is all, persist
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();

		Customer cust1 = new Customer("John", 25);
		Accounts a1 = new Accounts("savings", "John savings desc", cust1);
		Accounts a2 = new Accounts("current", "John vcurrent desc", cust1);
		Accounts a3 = new Accounts("loan", "John loan desc", cust1);

		//add accounts
		List<Accounts> accounts = new ArrayList<Accounts>();
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);

		cust1.setAccounts(accounts);
		s.save(cust1);

		s.getTransaction().commit();
		s.close();

	}

	private static void readCust() {
		Session s1 = HibernateUtil.getSessionFactory().openSession();

		Customer c = (Customer) s1.load(Customer.class, 107);// hit db for fetching customer details
		System.out.println(c.getCustomerName());
		System.out.println(c.getAccounts());// hit db for fetching account details.
		s1.close();
		List<Accounts> accounts = c.getAccounts();
		for (Accounts acc : accounts) {
			System.out.println(acc);
		}

	}

}

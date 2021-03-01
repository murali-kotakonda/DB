package onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestOneToMany {

	public static void main(String[] args) {
		insertCust();
		// readCust();
	}

/**
1. create session factory
2. create session obj
3. create customer obj with data
4. create 3 accounts objs with data
5. keep all  3 accounts objs inside customer obj
6. save customer obj
*/

	private static void insertCust() {

		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();

		// create cust obj
		Customer cust1 = new Customer("John", 25);

		// create acc objs
		Accounts a1 = new Accounts("savings", "John savings desc", cust1);
		Accounts a2 = new Accounts("current", "John vcurrent desc", cust1);
		Accounts a3 = new Accounts("loan", "John loan desc", cust1);

		// add accounts to list
		List<Accounts> accounts = new ArrayList<>();
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);

		// add list to customer obj
		cust1.setAccounts(accounts);

		// save cust obj
		s.save(cust1); // 1 row is inserted in customer table and 3 rows are inserted in accounts
						// table.

		// commit
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

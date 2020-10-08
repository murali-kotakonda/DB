package com.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author I335484
 
 Bulk queries:
----------------
Req: insert 5000 rows

solution:
1. WILL YOU MAKE 5000 DB calls??  -> increase load
2.execute in batch and with managed transaction 
either 5000 rows are inserted or nothing is inserted.

lets push every 100 rows 
	sessionObj.flush();
	sessionObj.clear(); //memory/load/perf 


	transaction.rollback();  -> in catch block if there is an exception then dont insert any row
  transaction.commit();   -> in try block , if there is no exception then insert all 5000 rows.
  

 */
public class TestBulkInsertEmployee {
	public static void main(String[] args) {

		// create sf obj
		SessionFactory sf = HibernateUtil.getSessionFactory();

		// crate session obj
		Session sessionObj = sf.openSession();

		// create transaction obj
		Transaction transaction = sessionObj.getTransaction();

		transaction.begin();
		try {
			for (int i = 1; i <= 5000; i++) {
				// read inputs
				String name = "testuser" + i;
				int sal = 5000 + i;
				// create entity obj with data
				Employee empObj = new Employee();
				empObj.setUserName(name);
				empObj.setUsersalary(sal);
				// open txn

				// save the entity obj in table
				sessionObj.save(empObj);
				// commit txn

				if (i % 100 == 0) {
					sessionObj.flush();
					sessionObj.clear();
				}
			}
			transaction.commit();
			System.out.println("data saved");
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			sessionObj.close();
		}
	}
}

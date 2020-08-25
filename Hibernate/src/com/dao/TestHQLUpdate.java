package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
//update name of employee based on id
//update salary of every employee; add 5000 for every employee

public class TestHQLUpdate {
	// 	assignment : give hike of 5000 fro every employee
	public static void main(String[] args) {
		Session  sObj = HibernateUtil.getSessionFactory().openSession();
		int id =22;
		int sal = 20000;
		Transaction transaction = sObj.getTransaction();
		
		transaction.begin();
		//Query  q = sObj.createQuery("update Employee set usersalary=:mySal where id=:myId");
		Query  q = sObj.createQuery("update Employee set usersalary=usersalary+500 ");
		//q.setParameter("myId", id);
		//q.setParameter("mySal", sal);
		int rowsAffected = q.executeUpdate();
		transaction.commit();
		
		
		if(rowsAffected >=1){
			System.out.println("update succesful");
		}else{
			System.out.println("update fail");
		}
		sObj.close();
	}
}

package com.dao.hqlEx;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
//update name of employee based on id
//update salary of every employee; add 5000 for every employee

import com.dao.HibernateUtil;

public class TestHQLUpdateByName {
	// 	assignment : update employee salary 
	public static void main(String[] args) {
		Session  sObj = HibernateUtil.getSessionFactory().openSession();
		int id =22;
		int sal = 20000;
		Transaction transaction = sObj.getTransaction();
		
		transaction.begin();
		Query  q = sObj.createQuery("update Employee set usersalary=:mySal where id=:myId");
		q.setParameter("myId", id);
		q.setParameter("mySal", sal);
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

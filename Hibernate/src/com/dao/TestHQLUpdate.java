package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestHQLUpdate {

	public static void main(String[] args) {
		Session  sObj = HibernateUtil.getSessionFactory().openSession();
		int id =33;
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

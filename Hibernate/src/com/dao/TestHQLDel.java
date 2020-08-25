package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

//delete emp by id
//delete emp by name


public class TestHQLDel {

	public static void main(String[] args) {
		Session  sObj = HibernateUtil.getSessionFactory().openSession();
		String name ="krishna3";
		Transaction transaction = sObj.getTransaction();
		
		transaction.begin();
	Query  q = sObj.createQuery("delete from Employee where userName=:myName");
		q.setParameter("myName", name);
		int res = q.executeUpdate();
		transaction.commit();
		
		
		if(res >=1){
			System.out.println("delete succesful");
		}else{
			System.out.println("delet fail");
		}
		sObj.close();
	}
}

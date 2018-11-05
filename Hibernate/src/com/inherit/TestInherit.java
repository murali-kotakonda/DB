package com.inherit;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestInherit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//1.create user obj with data
		User user = new User();
		user.setAge(12);
		user.setCorrId("99999");
		user.setInitials("mr");
		user.setUpdatedBy("admin");
		user.setUserName("muralidhar1");
		
		//2.create activity obj with data
		Activity activity = new Activity();
		activity.setActivityName("login1");
		activity.setPageName("comment");
		activity.setCorrId("888888");
		activity.setUpdatedBy("kmr");
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();
		//3.save user obj and activity obj
		s.save(user);
		s.save(activity);
		s.getTransaction().commit();
		s.close();
		
	}

}

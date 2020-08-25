package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestConn {
	public static void main(String[] args) {
		//1.create session factory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//2.open session
		Session s = sf.openSession();
		System.out.println("got conn");
		// 3.C R U D
	
		//4. close session
		s.close();
	}
}

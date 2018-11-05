package com.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return sf;
	}
}

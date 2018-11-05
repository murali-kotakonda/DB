package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestConn {
public static void main(String[] args) {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session s = sf.openSession();
	
	
	System.out.println("got conn");
	
	s.close();
}
}

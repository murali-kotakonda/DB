package com.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Menu {
	public static void main(String[] args) {
		  sf = new Configuration().configure().buildSessionFactory();
		menu();
	}
	static Scanner m = new Scanner(System.in);
	static SessionFactory sf ;
	private static void menu() {
		
		System.out.println(" type 1 for insert");
		System.out.println("type 2 for update");
		System.out.println("type 3 for delete");
		System.out.println("type 4 for read all the data from table");
		int input = m.nextInt();
		if(input == 1) {
			insert();
		}
		else if(input == 2) {
			update();
		}
		if(input == 3) {
			delete();
		}
		else if(input == 4) {
			read();
		}
		
	}
	
	private static void insert() {
		Session s = sf.openSession();
		
		System.out.println("enter name");
		String name = m.nextLine();
		
		System.out.println("enter id");
		int id = m.nextInt();
		
		Student m1 = new Student();
		m1.setName(name);
		m1.setId(id);
		
	
		Transaction transaction = s.getTransaction();
		transaction.begin();
		s.save(m1);
		transaction.commit();
		s.close();
		
	}

	private static void read() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		System.out.println("enter name");
		String name = m.next();
		System.out.println("enter id");
		int id = m.nextInt();
		
		Student m1 = (Student) s.get(Student.class, id);
		System.out.println(m1);
		
		s.close();
		
	}

	private static void delete() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		System.out.println("enter name");
		String name = m.next();
		System.out.println("enter id");
		int id = m.nextInt();
		
		Student m1 = new Student();
		m1.setName(name);
		m1.setId(id);
		
	
		Transaction transaction = s.getTransaction();
		transaction.begin();
		s.delete(m1);
		transaction.commit();
		s.close();
		
		
	}

	private static void update() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		//what if it is a state name
		System.out.println("enter name");
		String name = m.next();
		System.out.println("enter id");
		int id = m.nextInt();
		
		Student m1 = new Student();
		m1.setName(name);
		m1.setId(id);	
		

		Transaction transaction = s.getTransaction();
		transaction.begin();
		s.update(m1);
		transaction.commit();
		s.close();
		
		
	}

	
}


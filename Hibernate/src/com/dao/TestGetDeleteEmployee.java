package com.dao;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestGetDeleteEmployee {
public static void main(String[] args) {
	Session s = HibernateUtil.getSessionFactory().openSession();
	
	Scanner sc = new Scanner(System.in);
	System.out.println("enter name:");
	String inputUser =sc.next();
	
	s.getTransaction().begin();
	Query deleteQuery = s.createQuery(
			"delete from Employee where userName =:inputuserName");
	deleteQuery.setParameter("inputuserName",inputUser );
	int delRes = deleteQuery.executeUpdate();
	if(delRes>0){
		System.out.println("delete succes");
	}else{
		System.out.println("user name not found");
	}
	System.out.println(delRes);
	s.getTransaction().commit();
	
	s.close();
}
}

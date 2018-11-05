package com.mnp.oneToOne;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;

public class TestGetEmployee {
	
	public static void main(String[] args) {
	
		//get employee whose primary key id value = 4
		Session s = HibernateUtil.getSessionFactory().openSession();
		EmployeeWithAddress emp = (EmployeeWithAddress) 
				s.load(EmployeeWithAddress.class, 103);
		System.out.println(emp.getAge());
		System.out.println(emp.getCurAddress());
		s.close();
		System.out.println(emp.getCurAddress());
	}
}

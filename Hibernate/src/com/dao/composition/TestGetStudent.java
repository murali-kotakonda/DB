package com.dao.composition;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestGetStudent {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();

		StudentWithAddress student = (StudentWithAddress)s.load(StudentWithAddress.class, 101);
		student.displayStudentInfo();
		
		Address curAddress = student.getCurAddress();
		curAddress.displayAddress();
		
		s.close();
		
	}

}

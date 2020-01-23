package com.dao.tablePerConcreteClass;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestHier {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();
		Person1 p = new Person1();
		p.setAge(23);
		p.setUserName("per2");

		s.save(p);

		EmployeeDetails1 emp = new EmployeeDetails1();
		emp.setAge(24);
		emp.setUserName("emp2");
		emp.setProjId("pro123");
		emp.setDeptId("dept11");

		s.save(emp);

		Student1 st = new Student1();
		st.setAge(25);
		st.setUserName("stu2");
		st.setBranchId("csc");
		st.setSemId("4");

		s.save(st);

		s.getTransaction().commit();
		s.close();

	}

}

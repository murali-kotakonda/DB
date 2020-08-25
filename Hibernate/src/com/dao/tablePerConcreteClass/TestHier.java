package com.dao.tablePerConcreteClass;

import org.hibernate.Session;

import com.dao.HibernateUtil;

/**
 * @author I335484
  1.create sf
2.create session
3.create persn obj with data
4.create employee obj with data
5.create student obj with data
6.save person    -> 1 row in PersonDetails
7.save employee   -> 1 row in PersonDetails
8.save student   -> 1 row in PersonDetails


 */
public class TestHier {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();
		Person2 p = new Person2();
		p.setAge(23);
		p.setUserName("per2");

		s.save(p);

		Employee2 emp = new Employee2();
		emp.setAge(24);
		emp.setUserName("emp2");
		emp.setProjId("pro123");
		emp.setDeptId("dept11");

		s.save(emp);

		Student2 st = new Student2();
		st.setAge(25);
		st.setUserName("stu2");
		st.setBranchId("csc");
		st.setSemId("4");

		s.save(st);

		s.getTransaction().commit();
		s.close();

	}

}

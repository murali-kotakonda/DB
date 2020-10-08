package com.dao.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dao.Employee;
import com.dao.HibernateUtil;

public class TestCriteriaMinMax {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		int minSal = 5000;
		int maxSal = 10000;

		Criteria empCriteria = s.createCriteria(Employee.class);

		if (minSal != 0 && maxSal != 0) {
			empCriteria.add(Restrictions.between("usersalary", minSal, maxSal));
		}
		List<Employee> employees = empCriteria.list();

		for (Employee e : employees) {
			System.out.println(e);
		}
		s.close();
	}
}
package com.dao.criteria;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.dao.Employee;
import com.dao.HibernateUtil;

public class AllCriteria {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Criteria empCriteria = s.createCriteria(Employee.class);

		//order by salaryinfo
		empCriteria.addOrder(Order.asc("usersalary"));

		//name = 'krishna'
		empCriteria.add(Restrictions.eq("userName", "krishna"));

		// name like '%kumar%'
		empCriteria.add(Restrictions.like("userName", "%kumar%"));

		// salaryInfo between (5000, 10000)
		empCriteria.add(Restrictions.between("usersalary", 5000, 10000));

		// name = 'krishna' or name is null
		empCriteria.add(Restrictions.eqOrIsNull("userName", "krishna"));

		// Id = 2000
		empCriteria.add(Restrictions.idEq("2000"));

		// name = 'krishna' or name = 'ram' or name = 'ramesh'
		empCriteria.add(Restrictions.in("userName", 
				Arrays.asList("krishna", "ram", "ramesh")));
		
		//name = ''
		empCriteria.add(Restrictions.isEmpty("userName"));
		
		//name != ''
		empCriteria.add(Restrictions.isNotEmpty("userName"));

		// name is NULL
		empCriteria.add(Restrictions.isNull("userName"));
		
		//name is NOT NULL
		empCriteria.add(Restrictions.isNotNull("userName"));
		
		//salaryInfo > 10000
		empCriteria.add(Restrictions.gt("usersalary", 10000));
		
		//salaryInfo >= 10000
		empCriteria.add(Restrictions.ge("usersalary", 10000));
		
		//salaryInfo < 10000
		empCriteria.add(Restrictions.lt("usersalary", 10000));
		
		//salaryInfo <= 10000
		empCriteria.add(Restrictions.le("usersalary", 10000));
		
		
		empCriteria.add(Restrictions.neProperty(propertyName, otherPropertyName)
		
		
		//Join conditions 
		//name = 'krishna'
		Criterion nameCondition = Restrictions.like("userName","krishna");

		//salaryInfo < 5000
		Criterion salaryCondition = Restrictions.lt("usersalary", 5000);
		
		
		
		
		
		//name = 'krishna' or  salaryInfo < 5000
		LogicalExpression joinOr = Restrictions.or(salaryCondition, nameCondition);
		empCriteria.add( joinOr );

		//name = 'krishna' and  salaryInfo < 5000
		LogicalExpression joinAnd = Restrictions.and(salaryCondition, nameCondition);
		empCriteria.add( joinAnd );

		//Projections : meant to include selected columns in the response

		//get paricular column
		empCriteria.setProjection(Projections.property("userName"));
				
		// To get maximum usersalary.
		empCriteria.setProjection(Projections.max("usersalary"));

		// To get minimum usersalary
		empCriteria.setProjection(Projections.min("usersalary"));

		// To get sum of usersalary
		empCriteria.setProjection(Projections.sum("usersalary"));
		
		// To get average usersalary
		empCriteria.setProjection(Projections.avg("usersalary"));
		
		// To get total count
		empCriteria.setProjection(Projections.rowCount());

		// To get distinct count of a property.
		empCriteria.setProjection(Projections.countDistinct("userName"));

		
		
		empCriteria.add(Restrictions.in("userName", 
				Arrays.asList("krishna", "ram", "ramesh")))
	    .add(Restrictions.lt("usersalary", 5000))
	    .add(Restrictions.gt("usersalary", 10000))
	    .add(Restrictions.eqOrIsNull("userName", "krishna"))
	    .add(Restrictions.idEq("2000"))
	    .list();
	    
		List<Employee> list = empCriteria.list();
		System.out.println(list.size());
		for (Employee e : list) {
			System.out.println(e);
		}
		s.close();
	}
}

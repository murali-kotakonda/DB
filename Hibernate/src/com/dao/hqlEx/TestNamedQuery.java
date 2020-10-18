package com.dao.hqlEx;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;

/**
-Named queries:
--------------
-helps to define the HQL queries in a common place.
-if the hql queries requires any changes we can change only in place.
- helps to simplify writing the code for  CRUD operations.

-where to write the named queries?
 we need to write named queries in the entity classes.
 
- what does a named query will contain?
  Query name and query value [HQL]
  
- How to write named queries?
  Use annotations @NamedQueries , which has multiple @NamedQuery annotations
  EVERY @NamedQuery Contains name and query
  
  We can use HQL or namedQuery to get the Query Object
  
  Ex: 
  1.get all employee details
  HQL : from Employee
  Named Query :  @NamedQuery(name ="getALLEmps",query = "from Employee")
  Query listQuery =s.createQuery("from Employee");//using HQL
  Query listQuery =s.getNamedQuery("getALLEmps");//UISNG NAMED query
  
  
  2.get only emp names
  HQL : select userName from Employee
  Named Query :@NamedQuery(name ="getEmpNames",query = "select userName from Employee")
  Query listQuery =s.createQuery("select userName from Employee");//using HQL
  Query listQuery =s.getNamedQuery("getEmpNames");//USING  NAMED query
  
  
  3.GET ALL emp salaries
  HQL :select usersalary from Employee
  Named Query: @NamedQuery(name ="empSal",query = "select usersalary from Employee")
   Query listQuery =s.createQuery("select usersalary from Employee");//using HQL
  Query listQuery =s.getNamedQuery("empSal");//USING  NAMED query

  changes in Employee.java:
  --------------------------------
  
  import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(
		value =
{
 @NamedQuery(name ="getEmpNames",query = "select userName from Employee"),
 @NamedQuery(name ="getALLEmps",query = "from Employee"),
 @NamedQuery(name ="empSal",query = "select usersalary from Employee")
}
)
@Entity
@Table(name = "EmployeeDetails")
public class Employee {

   <No chages >

}

 */

public class TestNamedQuery {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		//Query listQuery = s.createQuery("select userName from Employee"); //using hql
		Query listQuery = s.getNamedQuery("getEmpNames"); //using named query
		
		 
		List<String> names = listQuery.list();
		for (String name: names) {
			System.out.println(name);
		}
	}
}

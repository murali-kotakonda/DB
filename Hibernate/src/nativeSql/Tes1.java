package nativeSql;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;

/**
HQL: uses instance varibales and class name, use createQuery() method.
SQL : uses column names and tabke names, use createSQLQuery() method.

  Req: get all employee
  sql: SELECT * FROM EMPLOYEEDETAILS
  as this retuns multiple rows, use list() method
 */
public class Tes1 {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String sql = "SELECT * FROM EMPLOYEEDETAILS";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);// mention the entity class name
		
		List<Employee> results = query.list();

		for(Employee emp: results) {
			System.out.println(emp.getId() + " " + emp.getUserName() + " "+emp.getUsersalary());
		}
		session.close();
	}
}

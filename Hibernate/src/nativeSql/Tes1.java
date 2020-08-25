package nativeSql;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;

public class Tes1 {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT * FROM EMPLOYEEDETAILS";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		List<Employee> results = query.list();
		System.out.println(results);
		session.close();
	}
}

package nativeSql;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;

public class Tes2 {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT * FROM EMPLOYEEDETAILS WHERE userid = :id";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		query.setParameter("id", 11);
		Employee emp = (Employee)query.uniqueResult();
		System.out.println(emp);
		session.close();
	}
}

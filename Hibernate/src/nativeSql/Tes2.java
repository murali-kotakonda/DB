package nativeSql;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;
/**

Req: get all employee details using id
sql: SELECT * FROM EMPLOYEEDETAILS where userid =<>
as this retuns multiple rows, use list() method
*/
public class Tes2 {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT * FROM EMPLOYEEDETAILS ";
		
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		
		Employee emp = (Employee)query.uniqueResult();
		System.out.println(emp);
		session.close();
	}
}

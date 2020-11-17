package nativeSql;
import java.util.List;

import org.hibernate.Session;

import com.dao.HibernateUtil;

/**
HQL: uses instance varibales and class name, use createQuery() method.
SQL : uses column names and tabke names, use createSQLQuery() method.

  Req: get all employee
  sql: SELECT * FROM EMPLOYEEDETAILS
  as this retuns multiple rows, use list() method
 */
public class Tes4 {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String sql = "SELECT * FROM EMPLOYEEDETAILS";
		List<Object[]>list = session.createQuery(sql).list();
		for (Object[] objects : list) {
            
            System.out.println(objects[0]  + "-" + objects[1]);
         }
		session.close();
	}
}

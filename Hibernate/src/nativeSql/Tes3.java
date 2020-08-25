package nativeSql;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.dao.HibernateUtil;

public class Tes3 {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT userid,name FROM EMPLOYEEDETAILS";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List  rows = query.list();

		 for(Object object : rows) {
	            Map row = (Map)object;
			System.out.print("USERID : " + row.get("USERID"));
			System.out.println(" , NAME : " + row.get("NAME"));
		}
		session.close();
	}
}

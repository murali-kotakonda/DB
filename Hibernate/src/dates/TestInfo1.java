package dates;

import java.sql.Timestamp;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestInfo1 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Info1 info = new Info1();
		
		info.setSqlDate(java.sql.Date.valueOf("2017-11-15"));
		info.setSqlTime(java.sql.Time.valueOf("15:30:14"));
		info.setSqlTimestamp(Timestamp.valueOf("2017-11-15 15:30:14.332"));
		
		session.getTransaction().begin();
		session.save(info);
		session.getTransaction().commit();
		
		session.close();
		
	}
}

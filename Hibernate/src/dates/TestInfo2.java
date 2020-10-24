package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestInfo2 {

	public static void main(String[] args) throws ParseException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Info2 temporalValues = new Info2();
		
		temporalValues.setUtilDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-15"));
		temporalValues.setUtilTime(new SimpleDateFormat("HH:mm:ss").parse("15:30:14"));
		temporalValues.setUtilTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2017-11-15 15:30:14.332"));
		
		session.getTransaction().begin();
		session.save(temporalValues);
		session.getTransaction().commit();
		
		session.close();
	}
}

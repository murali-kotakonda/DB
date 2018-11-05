package setup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.HibernateUtil;

public class TestGetConn {
public static void main(String[] args) {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	//getting session obj
	Session session = sf.openSession();
	session.close();
}
}

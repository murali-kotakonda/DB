package basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestConn {

	public static void main(String[] args) {
				SessionFactory sf = new Configuration().configure().buildSessionFactory(); 
				Session session = sf.openSession();
				System.out.println("Connection success");
				session.close();
	}
	
}

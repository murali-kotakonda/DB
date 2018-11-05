package selfJoin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.HibernateUtil;

public class TestSelfJoin {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		EmpWithManager manager1 = new EmpWithManager("user1", "Norris");
		EmpWithManager employee1 = new EmpWithManager("user2", "Brin");
		EmpWithManager employee2 = new EmpWithManager("user3", "Page");

		employee1.setManager(manager1);
		employee2.setManager(manager1);

		session.save(manager1);
		session.save(employee1);
		session.save(employee2);

		session.getTransaction().commit();
		session.close();

	}
}

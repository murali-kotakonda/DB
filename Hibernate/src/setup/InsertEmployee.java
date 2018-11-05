package setup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.HibernateUtil;

public class InsertEmployee {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		//getting session obj
		Session session = sf.openSession();
		session.getTransaction().begin();
		//create entity obj
		int defult = 20000;
		for(int i=1;i<=10;i++){
			MyEmployee emp = new MyEmployee();
			emp.setLname("kumar"+i);
			emp.setFname("raj"+i);
			emp.setSal(defult+i );
			session.save(emp);
		}
		//save entity obj
		
		session.getTransaction().commit();
		session.close();
	}
}

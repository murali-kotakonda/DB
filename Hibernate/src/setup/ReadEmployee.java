package setup;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.HibernateUtil;

public class ReadEmployee {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		//getting session obj
		Session session = sf.openSession();
		Scanner  sc = new Scanner(System.in);
		System.out.println("enter ur emp Id");
		int id = sc.nextInt();
		MyEmployee obj = null;
		try{
			obj = (MyEmployee)session.get(MyEmployee.class, id);
			System.out.println(obj);	
		}catch(HibernateException ex){
			System.out.println("id not found");
		}
		
	//	System.out.println("enter new name:");
		String name = "ramKumar1";
		obj.setFname(name);
		obj.setLname(null);
		session.getTransaction().begin();
		session.delete(obj);
		session.getTransaction().commit();
		session.close();
	}
}

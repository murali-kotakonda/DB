package selfJoin;

import java.util.Set;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestGetEmployee {

	public static void main(String[] args) {
		Session sessionObj = HibernateUtil.getSessionFactory().openSession();
		// get employee whose primary key id value = 4		
		EmpWithManager emp1 = (EmpWithManager)
				sessionObj.load(EmpWithManager.class, 61L);
		System.out.println(emp1.getFirstname());
		Set<EmpWithManager> subordinates = emp1.getSubordinates();
		for(EmpWithManager emp:subordinates){
			System.out.println(emp.getFirstname());
		}
		sessionObj.close();	
	}
}

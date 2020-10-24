package oneToOne;

import org.hibernate.Session;

import com.dao.HibernateUtil;
 
/**
 if the code emp.getCurAddress() is called after closing the session then we will get 
org.hibernate.LazyInitializationException

 Exception in thread "main" org.hibernate.LazyInitializationException: 
 could not initialize proxy - no Session
 
 when do you encounter LazyInitializationException?
 solution:
 -----------------
 employee has one address
 and we are using fetch type as lazy
 1.open sf and session
 2.call the load method ; // fetchs only emp details
 3.close session
 4.call emp.getAddress() ; // we will get exception
 
 because address details are not retrieved before closing the session
 
 */
public class TestGetEmployeeLazyLoad {
	
	public static void main(String[] args) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		EmployeeWithAddress emp = (EmployeeWithAddress) 
				s.load(EmployeeWithAddress.class, 1);// 1st query
		System.out.println(emp);
		System.out.println(emp.getCurAddress());
		s.close();
		
		System.out.println(emp);
		System.out.println(emp.getCurAddress());
	}
}
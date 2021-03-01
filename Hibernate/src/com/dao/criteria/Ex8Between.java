package criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import basics.Employee;
import basics.HibernateUtil;
 
/**
   - get employees whose salary between input1 and input2 
	 
	
 */
public class Ex8Between {
	public static void main(String[] args) {
		int min=5050;
		int max=5100;

		// get session obj
		Session s = HibernateUtil.getSessionFactory().openSession();

		// get criteria obj
		Criteria empCriteria = s.createCriteria(Employee.class);

		if(min!=0 && max!=0) {
			empCriteria.add(Restrictions.between("usersalary", min,max));  
		}
		
		// call list method
		List<Employee> list = empCriteria.list();
		System.out.println("size = "+ list.size());
		for(Employee e: list) {
			System.out.println(e.getId() + "-"+ e.getUserName() +"-"+ e.getUsersalary());
		}
		s.close();
	}
}

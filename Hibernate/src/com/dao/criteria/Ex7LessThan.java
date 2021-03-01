package criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import basics.Employee;
import basics.HibernateUtil;
 
/**
   - get employees whose salary less than input userName
   [select * from EmployeeDetails where userName< 5100]
	 
	
 */
public class Ex7LessThan {
	public static void main(String[] args) {
		int salary=5100;

		// get session obj
		Session s = HibernateUtil.getSessionFactory().openSession();

		// get criteria obj
		Criteria empCriteria = s.createCriteria(Employee.class);

		if(salary!=0) {
			//empCriteria.add(Restrictions.le("usersalary", salary));//less than equal to
			empCriteria.add(Restrictions.lt("usersalary", salary)); //less than
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

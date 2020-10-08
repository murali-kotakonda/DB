package com.dao.criteria;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dao.Employee;
import com.dao.HibernateUtil;
public class TestCriteriaQuery {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		int salOrderBy = -1;
		String userName="";
		String userNameMatch="";
		int minSal=0;
		int maxSal =0;
		
		Criteria empCriteria = s.createCriteria(Employee.class);
		
		//order based on sal from higher to lower
		if(salOrderBy==1)
		{empCriteria.addOrder(Order.asc("usersalary"));}
		
		if(salOrderBy==2)
		{empCriteria.addOrder(Order.desc("usersalary"));}
		
		 if (userName != null && !userName.isEmpty()) {
			empCriteria.add(Restrictions.eq("userName", userName));
		}
		 
		if (userNameMatch != null && !userNameMatch.isEmpty()) {
			empCriteria.add(
					Restrictions.like("userName", "%"+userNameMatch+"%"));
		}
		
		if (minSal != 0 && maxSal!=0) {
			empCriteria.add(Restrictions.between("usersalary", minSal, maxSal));
		}
		
		/*int recordsPerPage = 4;
		int pageNo =3;//input from customer
		
		int firstRecord = (pageNo-1)*recordsPerPage;
    	*/
		empCriteria.setFirstResult(2);//which row number
		empCriteria.setMaxResults(5);//how many row numbers

		List<Employee> employees = empCriteria.list();
	
		for(Employee e  : employees){
			System.out.println(e);
		}
		s.close();
	}
}
package com.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
public class TestCriteriaQuery {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		String salOrderBy = "";
		String userName="";
		String userNameiike="";
		int minSal=0;
		int maxSal=0;

		Criteria empCriteria = s.createCriteria(Employee.class);
		
		//order based on sal from higher to lower
		if(salOrderBy.equals("asc"))
		{empCriteria.addOrder(Order.asc("usersalary"));}
		
		if(salOrderBy.equals("desc"))
		{empCriteria.addOrder(Order.desc("usersalary"));}
	
		 if (userName != null && !userName.isEmpty()) {
			//e.userName = <input>
			empCriteria.add(Restrictions.eq("userName", userName));
		} 
		if (userNameiike != null && !userNameiike.isEmpty()) {
			//like operation
			empCriteria.add(Restrictions.like("userName", "%"+userNameiike+"%"));
		}
		if (minSal != 0 && maxSal!=0) {
			//like operation
			empCriteria.add(Restrictions.between("usersalary", minSal, maxSal));
		}
		int recordsPerPage = 4;
		int pageNo =3;//input from customer
		
		int firstRecord = (pageNo-1)*recordsPerPage;
    	empCriteria.setFirstResult(firstRecord);//which row number
		empCriteria.setMaxResults(recordsPerPage);//how many row numbers
		List<Employee> employees = empCriteria.list();
	
		for(Employee e  : employees){
			System.out.println(e);
		}
		s.close();
	}
}
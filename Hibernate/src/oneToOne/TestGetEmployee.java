package oneToOne;

import org.hibernate.Session;

import com.dao.HibernateUtil;

/**
 fetch= FetchType.LAZY
---------------------

EmployeeWithAddress emp = (EmployeeWithAddress) s.load(EmployeeWithAddress.class, 1);
//fetchs only employee details
        
Hibernate: select employeewi0_.id as id1_1_0_, employeewi0_.age as age2_1_0_, employeewi0_.curAddId as curAddId4_1_0_, employeewi0_.userName as userName3_1_0_ 
from EmployeeWithAddress employeewi0_ where employeewi0_.id=?

Hibernate: select addressdet0_.id as id1_0_0_, addressdet0_.city as city2_0_0_, addressdet0_.country as country3_0_0_, addressdet0_.pin as pin4_0_0_, addressdet0_.state as state5_0_0_, addressdet0_.streetNo as streetNo6_0_0_ 
from AddressDetails addressdet0_ where addressdet0_.id=?

here two db calls required to fetch employee and address

fetch= FetchType.EAGER
-------------------------

EmployeeWithAddress emp = (EmployeeWithAddress)s.load(EmployeeWithAddress.class, 1);
//fetches employee and address details


Hibernate: select employeewi0_.id as id1_1_1_, employeewi0_.age as age2_1_1_, employeewi0_.curAddId as curAddId4_1_1_, employeewi0_.userName as userName3_1_1_, addressdet1_.id as id1_0_0_, addressdet1_.city as city2_0_0_, addressdet1_.country as country3_0_0_, addressdet1_.pin as pin4_0_0_, addressdet1_.state as state5_0_0_, addressdet1_.streetNo as streetNo6_0_0_
from EmployeeWithAddress employeewi0_ left outer join AddressDetails addressdet1_ 
on employeewi0_.curAddId=addressdet1_.id where employeewi0_.id=?


here only one db call that fetches both emp and address

 
 */
public class TestGetEmployee {
	
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		EmployeeWithAddress emp = (EmployeeWithAddress) 
				s.load(EmployeeWithAddress.class, 1);// 1st query
		System.out.println(emp);
		
		System.out.println(emp.getCurAddress());//2nd query
		
		s.close();
		
		
		//System.out.println(emp);
		//System.out.println(emp.getCurAddress());
	}
}
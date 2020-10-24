package tablejoinInherit;

/**
Req: save person , employee , student

steps:
1.create sf
2.create session
3.create persn obj with data
4.create employee obj with data
5.create student obj with data
6. start transaction
7.save person    -> 1 row created in Person3, 
8.save employee   -> 1 row created in Person3 + 1 row is created in Employee3
9.save student   -> 1 row created in Person3 + 1 row is created in Student3 
10.commit
11.close session
 */

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestHier {

	
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		// create person obj with data
		Person3 p = new Person3();
		p.setAge(23);
		p.setUserName("test1");

		// create emp obj with data
		Employee3 emp = new Employee3();
		emp.setAge(24);
		emp.setUserName("test2");
		emp.setProjId("pro123");
		emp.setDeptId("dept11");

		// create student obhj with data
		Student3 st = new Student3();
		st.setAge(25);
		st.setUserName("test3");
		st.setBranchId("csc");
		st.setSemId("4");
		
		s.getTransaction().begin();
		
		// save objs
		s.save(p);// 1 row in person table
		s.save(emp);// 1 row in person table + 1 row in emp table
		s.save(st);// 1 row in person table and 1 row in student table

		s.getTransaction().commit();
		s.close();
	}
}

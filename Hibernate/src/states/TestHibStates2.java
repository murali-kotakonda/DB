package states;

import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;

/*
 Employee.java is a entity class

Hibernate States or Entity obj states
------------------------------------------
-> Transient
-> Persistent
-> Detached

Transient:
-> create new obj for Entity class then we term the state as transient state.
  ex: Employee e = new Employee()

Persistent:
-> if the session is associated with the entity obj , then the state changes from transient to persistence..
-> while in session if the object is changed then the row will be changed.
  ex:
     session.save(e); // use for create
     session.saveOrUpdate(e); // use for create or update
     session.persist(e);
     session.merge(e);

the following methods retuns the enity objs in persistece state:

    Employee e1 = session.get(Employee.class, 23); // e1 is in pers state
    Employee e2 = session.load(Employee.class, 23); // e2 is in pers state
  
    List<Employee> emps= query.list();
    Employee e3 = query.uniqueResult();

    List<Employee> emps=criteria.list();
    Employee e4 = criteria.uniqueResult();

   
Detached:
-> if the entity obj is no longer associated with session , then the state changes from persistenc to detached.
  
  ex:
     session.close()
     session.clear()
     session.evict()
       
       
how to convert entity obj in detached state to persistenc state:
--------------------------------------------------------------------
  session2.update(e)
  session2.merge(e)
  session2.saveOrUpdate(e)
  
 */
public class TestHibStates2 {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		Employee e = new Employee();//Transiant state
		e.setUserName("krishnakumar1238");
		e.setUsersalary(11111);
		
		s.getTransaction().begin();
		s.save(e);	//state changes to persistence state. triggers insert query
		s.getTransaction().commit();  
		
		s.close();//state changes to detached
		
		//transcations on the detached obj
		Session s1 = HibernateUtil.getSessionFactory().openSession();
		e.setUserName("krishna9898");
		
		s1.getTransaction().begin();
		s1.merge(e);//state will Change to persistence
		s1.getTransaction().commit();
		
		s1.close();//state changes to detached
	}
}

package com.mnp.states;

import org.hibernate.Session;

import com.dao.Employee;
import com.dao.HibernateUtil;

/*
 * Employee.java is a entity class
  


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
  
    query.list();
    query.uniqueResult();

    criteria.list();
    criteria.uniqueResult();

   
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
public class TestHibStates {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.getTransaction().begin();
		//Transiant state
		Employee e = new Employee();
		e.setUserName("krishna1");
		e.setUsersalary(11111);
		
		s.save(e);	//state changes to persistance state. triggers insert query
		
		e.setUserName("krishna2");//change the obj value during persistenc state
		s.getTransaction().commit(); // one insert query + 1 update query 
		
		s.close();//state changes to detached
	}

}

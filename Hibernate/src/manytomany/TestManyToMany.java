package manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
  Req: 
  there are two students
  there are two cources
  both the students attends all the cources
  save the data to db.
  
   solution)
   1.Create student1(s1) with data
   2.Create student2(s2) with data
   3.Create  cource1(c1) with data
   4.Create  cource2(c2) with data
   5.add c1 and c2 to s1
   6.add c1 and c2 to s2
   7.save s1
   8.save s2
   9.commit txn
   10.close session
 */
public class TestManyToMany {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();;
		
		Session s = sf.openSession();
		
		//create s1 & s2
		Student st1 = new Student("raju","employee");
		Student st2 = new Student("uma","student");
		
		//create c1 & c2
		Cource c1 = new Cource("core");
		Cource c2 = new Cource("adv");
		
		// add c1 & c2 for s1
		List<Cource> list1 = new ArrayList<>();
		list1.add(c1);
		list1.add(c2);
		st1.setCources(list1);

		//add c1 & c2 for s2
		List<Cource> list2 = new ArrayList<>();
		list2.add(c1);
		list2.add(c2);
		st2.setCources(list2);
		 
		s.getTransaction().begin();
		s.save(st1); //save s1
		s.save(st2); //save s2
		s.getTransaction().commit();
		s.close();
	}
}


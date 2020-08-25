package com.mnp.inherit.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dao.HibernateUtil;
import com.mnp.oneToOne.AddressDetails;
import com.mnp.oneToOne.EmployeeWithAddress;
/*
 * ManytoMany:
-----------
  EX1: Pages , likes ,customer
  
  One customer can like multiple Pages   ( customer -> Pages   OneToMany)
  one Page can be liked by multiple customer .  ( page -> customer   OneToMany)
  
  ==> Relation between customer and pages is manytomany
  
    
OneToMany from both tables....
we need three tables.
Course , Student and MappingTable

   
scenario:
---------------
Course
Student
    
    
1 course has many students
1 student can attend many courses.
  
 DB design:
---------------
three tables
1.Course
2.Student
3.StudentCourceMap

Course
---------
courceId (PK)
courseName

Student
--------------
stuId (PK)
studentName
Description

StudentCourceMap
----------------
stuId (FK)  -> refers Student
courceId(FK) -> refers Course 

  
Write
@ManyToMany   --> for any of the two entity classes...



explaination:
1.we have written @manytomany for student.java

@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  // relationshop between student and course
	@JoinTable(name = "StudentCourceMap",   // 3rd table details
	joinColumns = { @JoinColumn(name = "stuId") },  // stuId column is refering from the student.java
	inverseJoinColumns = { @JoinColumn(name = "courceId") }) //courceId is referring to course.java
	private List<Cource> cources;  //as multple courses as attended, so keep as list


joinColumns -->column mapping   for the same class  ex: student
inverseJoinColumns -> column mapping for the associated class  ex: course

add entries in hibernate.cfg.xml:
---------------------------------------------
<mapping class="manytomany.Student" />
<mapping class="manytomany.Cource" />
		
		
 */


public class TestManyToMany {

	/**
	 * @param args
	 */
	
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

/*

course:
---------
courseid  coursename
--  			---------
8	  			core
9	  			adv



student:
stuid   desc      name
7	   employee	  raju
10	   student	  uma


studentcourseMap:
---------------------
  stuid    courseid
   7          8
   7          9
  10          8
  10          9
*/
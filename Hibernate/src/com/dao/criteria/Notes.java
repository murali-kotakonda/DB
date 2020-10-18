package com.dao.criteria;

public class Notes {
/*
		 Criteria:
		------------
		- used for select queries
		- HQL - WE can perform all CRUD opeartions.
		Scenarios
		---------
		1.[static query] where inputs are already known     - USE hql
		search by emp id : select * from employee where id=<input>
		passing emp id is mandatory
		
		2.[dynamic query] where inputs are are fixed.   -- use Criteria filtering the data 
		product search:
		you can search by size , brand , color, price , gender [ optional ]
		customer can give input for any serach criteria..
		
		size = 38 ==> select * from product where size = 38
		color=Red  ==>select * from product where color= 'Red'
		size =38 and gender =M  ===>select * from product where size = 38 and gender ='M'
		size=38
		brand=Reebok
		color=Red
		price <5000
		gender= M    ===> select * from Prodcut where size=38
											and brand=Reebok
											and color=Red
											ane price <5000
											and gender= M
											
	  
	  
		steps for criteria:
		-------------------------
		1.session factory
		2.session obj
		3.get the criteria object for entity class
		Criteria empCriteria = s.createCriteria(Employee.class);
		4.apply the filters using the Criteria methods
		5.call the list method ,
		list method returns list of employee Objs
		List<Employee> list = empCriteria.list();
		 
 * */
	}

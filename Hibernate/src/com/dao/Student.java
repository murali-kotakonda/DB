package com.dao;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	//@id is used for the primary key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // value for id is auto generated
	@Column(name = "userId")
	private int Id;

	@Column(name = "name", nullable = false, length = 30, unique = true)
	private String userName;

	@Column(name = "salaryInfo", nullable = true)
	private Integer usersalary;
	
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", userName=" + userName
				+ ", usersalary=" + usersalary + "]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Integer getUsersalary() {
		return usersalary;
	}
	public void setsalary(Integer usersalary) {
		this.usersalary = usersalary;
	}
	public String getName() {
		return userName;
	}
	
	public Student(int id, String userName) {
		super();
		Id = id;
		this.userName = userName;
	}
	public void setName(String userName) {
		this.userName = userName;
	}

	public Student() {
		super();
	}
	public Student(int id, String userName, int usersalary) {
		super();
		Id = id;
		this.userName = userName;
		this.usersalary = usersalary;
	}

}
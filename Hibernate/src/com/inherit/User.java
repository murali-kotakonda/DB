package com.inherit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SystemUsers")
public class User extends DefaultParams{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;
	
	@Column(name = "initials")
	private String initials;

	@Column(name = "name", nullable = false, length = 30, unique = true)
	private String userName;
 
	@Column(name = "age")
	private int age;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}

package com.mnp.jdbc.basics;


public class Person {
	
	String name;
	int age;
	String userType;
	String desc;
	public Person() {
		super();
	}
	String city;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", userType=" + userType + ", desc=" + desc + ", city=" + city
				+ "]";
	}
	public Person(String name, int age, String userType, String desc, String city) {
		super();
		this.name = name;
		this.age = age;
		this.userType = userType;
		this.desc = desc;
		this.city = city;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}

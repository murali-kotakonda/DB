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

@NamedQueries(
		value =
{
 @NamedQuery(name ="getEmpNames",query = "select userName from Employee"),
 @NamedQuery(name ="getALLEmps",query = "from Employee"),
 @NamedQuery(name ="empSal",query = "select usersalary from Employee")
}
)
@Entity
@Table(name = "EmployeeDetails")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private int Id;

	@Column(name = "name", nullable = false, length = 30, unique = true)
	private String userName;

	@Column(name = "salaryInfo", nullable = true)
	private Integer usersalary;
	
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", userName=" + userName
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
	public void setUsersalary(Integer usersalary) {
		this.usersalary = usersalary;
	}
	public String getUserName() {
		return userName;
	}
	
	public Employee(int id, String userName) {
		super();
		Id = id;
		this.userName = userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Employee() {
		super();
	}
	public Employee(int id, String userName, int usersalary) {
		super();
		Id = id;
		this.userName = userName;
		this.usersalary = usersalary;
	}

}
package com.mnp.inherit.onetomany2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer1")
public class Customer1 implements Serializable {

	@Override
	public String toString() {
		return "Customer [Id=" + custId + ", customerName=" + customerName
				+ ", age=" + age + "]";
	}

	public Customer1( String customerName, int age) {
		super();
		this.customerName = customerName;
		this.age = age;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "custId")
	private int custId;

	@Column(name = "customerName", nullable = false)
	private String customerName;

	@Column(name = "age", nullable = false)
	private int age;
	
	@OneToMany(cascade= CascadeType.ALL , fetch= FetchType.LAZY )
	@JoinTable(name = "Customer_Account", 
	joinColumns =
				{ 	@JoinColumn(name = "custId") },
					inverseJoinColumns = { @JoinColumn(name = "accId")
			}
	)
	private List<Accounts1> accounts;
	
	public List<Accounts1> getAccounts() {
		if(accounts==null){
			accounts =  new ArrayList<Accounts1>();
		}
		return accounts;
	}

	public Customer1() {
		super();
	}

	public void setAccounts(List<Accounts1> accounts) {
		this.accounts = accounts;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

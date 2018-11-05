package com.mnp.inherit.onetomany;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;


@Entity
@Table(name = "Accounts")
public class Accounts  implements  Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;

	@Column(name = "accountName", nullable = false)
	private String accountName;

	
	@Column(name = "description", nullable = false)
	private String description;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "custId", nullable = false)
	private Customer customer;


	public Accounts() {
		super();
	}

	public Accounts(String accountName, String description) {
		super();
		this.accountName = accountName;
		this.description = description;
	}

	public Accounts(String accountName, String description, Customer customer) {
		super();
		this.accountName = accountName;
		this.description = description;
		this.customer = customer;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Accounts [Id=" + Id + ", accountName=" + accountName
				+ ", description=" + description + ", customer=" + customer
				+ "]";
	}

}

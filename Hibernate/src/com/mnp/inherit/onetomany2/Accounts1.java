package com.mnp.inherit.onetomany2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Accounts1")
public class Accounts1  implements  Serializable {

	public Accounts1() {
		super();
	}

	public Accounts1(String accountName, String description) {
		super();
		this.accountName = accountName;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accId")
	private int accId;

	@Column(name = "accountName", nullable = false)
	private String accountName;

	
	@Column(name = "description", nullable = false)
	private String description;


	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
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


	 


}

package com.dao.inherit.joinTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity  
@Table(name = "Student2")
@PrimaryKeyJoinColumn(name="ID")
public class Student2 extends Person2{

	@Column(name = "semId")
 private String semId;
 
	@Column(name = "branchId")
 private String branchId;

public String getSemId() {
	return semId;
}

public void setSemId(String semId) {
	this.semId = semId;
}

public String getBranchId() {
	return branchId;
}

public void setBranchId(String branchId) {
	this.branchId = branchId;
}
 
}

package com.dao.tablePerHier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity  
@DiscriminatorValue(value = "employee")
public class EmployeeDetails extends Person{
 
	@Column(name = "projId")
	private String projId;
	
	@Column(name = "deptId")
	private String deptId;

	public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	
	
	
}

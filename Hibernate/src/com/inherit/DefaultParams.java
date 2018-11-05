package com.inherit;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DefaultParams implements Serializable{

	@Column(name = "updatedBy", nullable = false)
	private String updatedBy;
	
	@Column(name = "corrId", nullable = false)
	private String corrId;

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCorrId() {
		return corrId;
	}

	public void setCorrId(String corrId) {
		this.corrId = corrId;
	}
	

}

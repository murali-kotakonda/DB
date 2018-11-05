package com.inherit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Activities")
public class Activity extends DefaultParams{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;

	@Column(name = "activityName", nullable = false)
	private String activityName;

	
	@Column(name = "pageName", nullable = false)
	private String pageName;


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getActivityName() {
		return activityName;
	}


	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}


	public String getPageName() {
		return pageName;
	}


	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	

}

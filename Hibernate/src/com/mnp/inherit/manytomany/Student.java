package com.mnp.inherit.manytomany;

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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stuId")
	private int stuId;

	@Column(name = "studentName", nullable = false)
	private String studentName;

	@Column(name = "description", nullable = false)
	private String description;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "StudentCourceMap", 
	joinColumns = { @JoinColumn(name = "stuId") }, 
	inverseJoinColumns = { @JoinColumn(name = "courceId") })
	private List<Cource> cources;

	public Student() {
		super();
	}

	public Student(String studentName, String description) {
		super();
		this.studentName = studentName;
		this.description = description;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Cource> getCources() {
		if (cources == null) {
			cources = new ArrayList<Cource>();
		}
		return cources;
	}

	public void setCources(List<Cource> cources) {
		this.cources = cources;
	}
}

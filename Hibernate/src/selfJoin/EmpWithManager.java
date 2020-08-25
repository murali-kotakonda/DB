package selfJoin;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EmpWithManager")
public class EmpWithManager {
	
	@Id
	@Column(name="EMPLOYEE_ID")
	@GeneratedValue
	private Long employeeId;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="designation")
	private String designation;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="manager_id")
	private EmpWithManager manager;

	@OneToMany(mappedBy="manager",fetch=FetchType.LAZY)
   //@OrderBy("firstname")
	private Set<EmpWithManager> subordinates =new HashSet<EmpWithManager>();

	
	
	public EmpWithManager() {
	}

	public EmpWithManager(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public EmpWithManager getManager() {
		return manager;
	}

	public void setManager(EmpWithManager manager) {
		this.manager = manager;
	}

	public Set<EmpWithManager> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<EmpWithManager> subordinates) {
		this.subordinates = subordinates;
	}
		
	// Getter and Setter methods
}


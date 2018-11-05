package setup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Info")
public class MyEmployee {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="userId")
	private int id;
	
	@Column(name="userFirstName")
	private String fname;

	@Column(name="userLastName")
	private String lname;

	@Column(name="userSal")
	private int sal;

	@Override
	public String toString() {
		return "MyEmployee [id=" + id + ", fname=" + fname + ", lname=" + lname
				+ ", sal=" + sal + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
}

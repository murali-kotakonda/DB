package onetomany;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;

	@Column(name = "customerName", nullable = false)
	private String customerName;

	@Column(name = "age", nullable = false)
	private int age;
	
	@OneToMany(cascade= CascadeType.ALL , fetch= FetchType.LAZY , 
			mappedBy="customer")
	private List<Accounts> accounts;
	
	public List<Accounts> getAccounts() {
		if(accounts==null){
			accounts =  new ArrayList<Accounts>();
		}
		return accounts;
	}


	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", customerName=" + customerName
				+ ", age=" + age + "]";
	}

	public Customer( String customerName, int age) {
		super();
		this.customerName = customerName;
		this.age = age;
	}

	public Customer() {
		super();
	}

	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

package dates;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 The java.sql package contains JDBC types that are aligned with the types defined by the SQL standard:
 
Date corresponds to the DATE SQL type, which is only a date without time
Time corresponds to the TIME SQL type, which is a time of the day specified in hours, minutes and seconds
Timestamp includes information about date and time with precision up to nanoseconds and corresponds to the TIMESTAMP SQL type
 
 As these types are in line with SQL, so their mapping is relatively straight-forward. 
 We can use either the @Basic or the @Column annotation:
 
 */
@Entity
@Table(name = "Info1")
public class Info1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "dateInfo")  //or @Basic
	private  Date sqlDate;

	@Column(name = "timeInfo")
	private  Time sqlTime;

	@Column(name = "timeStampInfo")
	private  Timestamp sqlTimestamp;

	public  Date getSqlDate() {
		return sqlDate;
	}

	public void setSqlDate(java.sql.Date sqlDate) {
		this.sqlDate = sqlDate;
	}

	public  Time getSqlTime() {
		return sqlTime;
	}

	public void setSqlTime(java.sql.Time sqlTime) {
		this.sqlTime = sqlTime;
	}

	public  Timestamp getSqlTimestamp() {
		return sqlTimestamp;
	}

	public void setSqlTimestamp(java.sql.Timestamp sqlTimestamp) {
		this.sqlTimestamp = sqlTimestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
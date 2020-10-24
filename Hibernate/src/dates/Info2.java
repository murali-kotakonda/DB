package dates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 The type java.util.Date contains both date and time information, up to millisecond precision. But it doesn't directly relate to any SQL type.

This is why we need another annotation to specify the desired SQL type:
 
 */
@Entity
@Table(name = "Info2")
public class Info2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name="dateInfo")
	@Temporal(TemporalType.DATE)
	private java.util.Date utilDate;
	 
	@Column(name="timeInfo")
	@Temporal(TemporalType.TIME)
	private java.util.Date utilTime;
	 
	@Column(name="timeStampInfo")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date utilTimestamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}

	public java.util.Date getUtilTime() {
		return utilTime;
	}

	public void setUtilTime(java.util.Date utilTime) {
		this.utilTime = utilTime;
	}

	public java.util.Date getUtilTimestamp() {
		return utilTimestamp;
	}

	public void setUtilTimestamp(java.util.Date utilTimestamp) {
		this.utilTimestamp = utilTimestamp;
	}
	
}
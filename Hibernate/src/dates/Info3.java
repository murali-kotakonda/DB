package dates;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**

Since Java 8, the new Java Date and Time API is available for dealing with temporal values. This API fixes many of the problems of java.util.Date and java.util.Calendar classes.

The types from the java.time package are directly mapped to corresponding SQL types. So there's no need to explicitly specify @Temporal annotation:
LocalDate is mapped to DATE
LocalTime and OffsetTime are mapped to TIME
Instant, LocalDateTime, OffsetDateTime and ZonedDateTime are mapped to TIMESTAMP
 
 */
@Entity
@Table(name = "Info2")
public class Info3 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Basic
	private java.time.LocalDate localDate;
	 
	@Basic
	private java.time.LocalTime localTime;
	 
	@Basic
	private java.time.OffsetTime offsetTime;
	 
	@Basic
	private java.time.Instant instant;
	 
	@Basic
	private java.time.LocalDateTime localDateTime;
	 
	@Basic
	private java.time.OffsetDateTime offsetDateTime;
	 
	@Basic
	private java.time.ZonedDateTime zonedDateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.time.LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(java.time.LocalDate localDate) {
		this.localDate = localDate;
	}

	public java.time.LocalTime getLocalTime() {
		return localTime;
	}

	public void setLocalTime(java.time.LocalTime localTime) {
		this.localTime = localTime;
	}

	public java.time.OffsetTime getOffsetTime() {
		return offsetTime;
	}

	public void setOffsetTime(java.time.OffsetTime offsetTime) {
		this.offsetTime = offsetTime;
	}

	public java.time.Instant getInstant() {
		return instant;
	}

	public void setInstant(java.time.Instant instant) {
		this.instant = instant;
	}

	public java.time.LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(java.time.LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public java.time.OffsetDateTime getOffsetDateTime() {
		return offsetDateTime;
	}

	public void setOffsetDateTime(java.time.OffsetDateTime offsetDateTime) {
		this.offsetDateTime = offsetDateTime;
	}

	public java.time.ZonedDateTime getZonedDateTime() {
		return zonedDateTime;
	}

	public void setZonedDateTime(java.time.ZonedDateTime zonedDateTime) {
		this.zonedDateTime = zonedDateTime;
	}
	

}
package com.mnp.sharan;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Session;

import com.dao.HibernateUtil;
@Entity
@Table(name = "Activities")
public class Activities {

	@Temporal(TemporalType.DATE)
	@Column(name = "createdDate")
	private java.util.Date dateCol;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Calendar createDate;

	
	public java.util.Date getDateCol() {
		return dateCol;
	}

	public void setDateCol(java.util.Date dateCol) {
		this.dateCol = dateCol;
	}

	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	/*public static void main(String[] args) {
		User user = new User();
		Session s = HibernateUtil.getSessionFactory().openSession();

		s.beginTransaction();

		user.setUserId(1);
		user.setName("Ram");
		user.setCreateDate(Calendar.getInstance());
		s.save(user);
		s.getTransaction().commit();
		s.close();
	}*/
	
	public static void main(String[] args) {
		Person p = new Person();
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		p.setCreateDate(Calendar.getInstance());
		p.setDateCol(new Date());
		s.save(p);
		s.getTransaction().commit();
		s.close();
	}
	}

class Person{
	/**
	 * @param args
	 */

	@Temporal(TemporalType.DATE)
	@Column(name = "createdDate")
	private java.util.Date dateCol;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Calendar createDate;


	public java.util.Date getDateCol() {
		return dateCol;
	}





	public void setDateCol(java.util.Date dateCol) {
		this.dateCol = dateCol;
	}





	public Calendar getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}


}

/*
@Basic
@Temporal(TemporalType.DATE)
private java.util.Date utilDate;
 
@Basic
@Temporal(TemporalType.TIME)
private java.util.Date utilTime;
 
@Basic
@Temporal(TemporalType.TIMESTAMP)
private java.util.Date utilTimestamp;

@Basic
@Temporal(TemporalType.DATE)
private java.util.Calendar calendarDate;
 
@Basic
@Temporal(TemporalType.TIMESTAMP)
private java.util.Calendar calendarTimestamp;


temporalValues.setUtilDate(
  new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-15"));
temporalValues.setUtilTime(
  new SimpleDateFormat("HH:mm:ss").parse("15:30:14"));
temporalValues.setUtilTimestamp(
  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
    .parse("2017-11-15 15:30:14.332"));
    
    Calendar calendarDate = Calendar.getInstance(
  TimeZone.getTimeZone("UTC"));
calendarDate.set(Calendar.YEAR, 2017);
calendarDate.set(Calendar.MONTH, 10);
calendarDate.set(Calendar.DAY_OF_MONTH, 15);
temporalValues.setCalendarDate(calendarDate);




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


temporalValues.setLocalDate(LocalDate.parse("2017-11-15"));
 
temporalValues.setLocalTime(LocalTime.parse("15:30:18"));
temporalValues.setOffsetTime(OffsetTime.parse("08:22:12+01:00"));
 
temporalValues.setInstant(Instant.parse("2017-11-15T08:22:12Z"));
temporalValues.setLocalDateTime(
  LocalDateTime.parse("2017-11-15T08:22:12"));
temporalValues.setOffsetDateTime(
  OffsetDateTime.parse("2017-11-15T08:22:12+01:00"));
temporalValues.setZonedDateTime(
  ZonedDateTime.parse("2017-11-15T08:22:12+01:00[Europe/Paris]"));
  
  
*/
package com.mnp.sharan;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class dateandtime {

	/**
	 * @param args
	 */

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_COL")
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

	public static void main(String[] args) {
		User user = new User();
		Session s = HibernateUtil.getSessionFactory().openSession();

		s.beginTransaction();

		user.setUserId(1);
		user.setName("Ram");
		user.setCreateDate(Calendar.getInstance());
		s.save(user);
		s.getTransaction().commit();
		s.close();
	}

}

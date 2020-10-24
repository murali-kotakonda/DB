package dates;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Calendar createDate;

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
		Activities p = new Activities();
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		p.setCreateDate(Calendar.getInstance());
		s.save(p);
		s.getTransaction().commit();
		s.close();
	}
}

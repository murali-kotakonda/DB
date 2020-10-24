package dates;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;

import org.hibernate.Session;

import com.dao.HibernateUtil;

public class TestInfo3 {

	public static void main(String[] args) throws ParseException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Info3 temporalValues = new Info3();

		temporalValues.setLocalDate(LocalDate.parse("2017-11-15"));
		temporalValues.setLocalTime(LocalTime.parse("15:30:18"));
		temporalValues.setOffsetTime(OffsetTime.parse("08:22:12+01:00"));
		temporalValues.setInstant(Instant.parse("2017-11-15T08:22:12Z"));
		temporalValues.setLocalDateTime(LocalDateTime.parse("2017-11-15T08:22:12"));
		temporalValues.setOffsetDateTime(OffsetDateTime.parse("2017-11-15T08:22:12+01:00"));
		temporalValues.setZonedDateTime(ZonedDateTime.parse("2017-11-15T08:22:12+01:00[Europe/Paris]"));
		
		
		session.getTransaction().begin();
		session.save(temporalValues);
		session.getTransaction().commit();

		session.close();
	}
}

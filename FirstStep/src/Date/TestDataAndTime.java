package Date;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TestDataAndTime {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());

		Date d = new Date();
		System.out.println(d);
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());

		String s = "1970-12-30 08:24:37.0";
		Timestamp ts = Timestamp.valueOf(s);
		System.out.println(ts);

		Calendar cJapan = new GregorianCalendar(TimeZone.getTimeZone("Beijing"));
		System.out.println(cJapan.get(Calendar.HOUR_OF_DAY) + 1);

		for (String str : TimeZone.getAvailableIDs()) {
			//
			
			
			
			
			System.out.println(str);
		}

	}

}

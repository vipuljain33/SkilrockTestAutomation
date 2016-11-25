package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getDateInExpectedFormat(String format, String dateInString, String returnformat) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = formatter.parse(dateInString);
			formatter = new SimpleDateFormat(returnformat);
			return formatter.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}

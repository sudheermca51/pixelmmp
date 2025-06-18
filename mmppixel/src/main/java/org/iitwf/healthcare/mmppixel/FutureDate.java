package org.iitwf.healthcare.mmppixel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class FutureDate {

	public static void main(String[] args) {

		String expectedOutput = generateFutureDate(0, "dd/MMMM/YYYY");
		String outputArray[] = expectedOutput.split("/");
		System.out.println(outputArray[0]);
		System.out.println(outputArray[1]);
		System.out.println(outputArray[2]);
		System.out.println("Expected Output" + expectedOutput);

		String stockName = "123";
		double d = Double.parseDouble(stockName.replace("$", ""));
		System.out.println(d);
		System.out.println(getPastDate(10,"dd/MM/yyyy","Asia/Kolkata")+"**********");

	}

	public static String generateFutureDate(int n, String format) {
		Calendar cal = Calendar.getInstance();
		System.out.println("Calendar's TimeZone: " + cal.getTimeZone().getDisplayName());
		cal.add(Calendar.DAY_OF_MONTH, n);
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String formattedDate = sdf.format(date);
		return formattedDate;

	}

	public static String generateFutureDate(int n, String format, String timeZone) {
		Calendar cal = Calendar.getInstance();
		TimeZone indianTimeZone = TimeZone.getTimeZone(timeZone);
		cal.setTimeZone(indianTimeZone);
		System.out.println("Calendar's TimeZone: " + cal.getTimeZone().getDisplayName());
		cal.add(Calendar.DAY_OF_MONTH, n);
		Date date = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone((cal.getTimeZone()));
		String formattedDate = sdf.format(date);
		return formattedDate;

	}
	
	public static String getPastDate(int yearsBack, String timeFormat, String timeZone) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -yearsBack);
		TimeZone tz = TimeZone.getTimeZone(timeZone);
		calendar.setTimeZone(tz);
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		sdf.setTimeZone(tz);
		return sdf.format(calendar.getTime());
	}
	
	
}

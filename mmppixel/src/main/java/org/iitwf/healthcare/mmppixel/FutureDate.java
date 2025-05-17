package org.iitwf.healthcare.mmppixel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FutureDate {

	public static void main(String[] args) {
		
		String expectedOutput= generateFutureDate(30,"dd/MMMM/YYYY");
		String outputArray[] = expectedOutput.split("/");
		System.out.println(outputArray[0]);
		System.out.println(outputArray[1]);
		System.out.println(outputArray[2]);
		System.out.println("Expected Output"+ expectedOutput);
		 
		String stockName="123";
		double d = Double.parseDouble(stockName.replace("$",""));
		System.out.println(d);
		 
		 
	 
	}
	public static String generateFutureDate(int n,String format)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, n);
		Date date= cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String formattedDate = sdf.format(date);
		return formattedDate;
		
	}
	 
}

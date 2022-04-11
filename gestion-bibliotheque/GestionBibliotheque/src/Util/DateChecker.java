package Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateChecker {

	public static long differenceInDays(Date d1, Date d2) throws Exception{
		
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
//		String inputString1 = "23 01 1997";
//		String inputString2 = "27 04 1997";

		try {
		    Date date1 = d1;
		    Date date2 = d2;
		    long diff = date2.getTime() - date1.getTime();
		    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 
		} catch (Exception e) {
		    e.printStackTrace();
		    throw new Exception(); 
		}
		
	}
	
	public static int compareDates(Date d1, Date d2) {
		
	      SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	      
	      System.out.println("The date 1 is: " + sdformat.format(d1));
	      System.out.println("The date 2 is: " + sdformat.format(d2));
	      
	      if(d1.compareTo(d2) > 0) {
	    	  return 1; 
	      } else if(d1.compareTo(d2) < 0) {
	         return -1; 
	      } else if(d1.compareTo(d2) == 0) {
	         return 0; 
	      }
	      
	      return Integer.MAX_VALUE; 
		
	}
	
	public static Date getSysDate() {
		
		Calendar c = Calendar.getInstance(); 
		Date sysDate = c.getTime(); 
		return sysDate; 
		
	}
	
	
	
}

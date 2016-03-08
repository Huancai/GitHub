/**
 * @author 吴焕才
 * @time 2011-11-12 15:57:06
 * @function 获得当前时间
 */
package com.exam.tools;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GetTime {

	/**
	 * 
	 * @return time
	 */
	public static String getTime() 
	{
		Calendar c = new GregorianCalendar();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int week = c.get(Calendar.DAY_OF_WEEK);
		String w = null ;
		
		switch(week)
		{
		case 2 :
			w = "星期一" ;
			break ;
		case 3 :
			w = "星期二";
			break ;
		case 4 :
			w = "星期三" ;
			break ;
		case 5 :
			w = "星期四";
			break ;
		case 6 :
			w = "星期五" ;
			break ;
		case 7 :
			w = "星期六";
			break ;
		default :
			w = "星期日" ;
				
		}
		return year + "/" + month + "/" + day + "  " + hour + ":" + minute
				+ ":" + second + " \r\n" + w + "      ";
	}
	
	
}
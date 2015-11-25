package com.tmh.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * className:DateUtils
 * @Description:TODO (文件说明：  功能，函数）
 * @author TianMengHua 
 * @CreateTime:2015年10月17日-上午10:41:58
 * @Remark 备注说明
 */
public class DateUtils {

	static String dateFormat1 = "yyyy-MM-dd HH:mm:ss";
	static String dateFormat2 = "yyyy-MM-dd HH:mm";
	static String dateFormat3 = "yyyy-MM-dd";
	static String dateFormat4 = "yyyyMMdd";
	static String dateFormat5 = "yyyy-MM";
	static String dateFormat6 = "HH:mm";
	static String dateFormat7 = "HHmm";
	static String dateFormat8 = "yyyyMMddHHmmss";
	/**
	 * 将字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 *
	 * @param strDate
	 * @return
	 */
	public static Date string2DateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat1);
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		return date;
	}
	/**
	 * 将字符串转换为时间 HH:mm
	 *
	 * @param strDate
	 * @return
	 */
	public static Date string2Date1(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat6);
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		return date;
	}
	/**
	 * 将字符串转换为时间 yyyy-MM-dd
	 *
	 * @param strDate
	 * @return
	 */
	public static Date string2Date(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat3);
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		return date;
	}

	/**
	 * 将字符串转换为时间 yyyy-MM-dd
	 *
	 * @param strDate
	 * @return
	 */
	public static Date string2Dates(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat4);
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		return date;
	}
	/**
	 * 将时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 *
	 * @param date
	 * @return
	 */
	public static String date2StrLong(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat1);
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 将时间转换为字符串 yyyyMMddHHmmss
	 *
	 * @param date
	 * @return
	 */
	public static String date2StrLongNo(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat8);
		String dateString = formatter.format(date);
		return dateString;
	}
	/**
	 * 将时间转换为字符串 HHmm
	 *
	 * @param date
	 * @return
	 */
	public static String date2String2(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat7);
		String dateString = formatter.format(date);
		return dateString;
	}
	/**
	 * 将时间转换为字符串 yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 */
	public static String date2String(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat3);
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 将字符串转换为时间 yyyyMMdd
	 *
	 * @param strDate
	 * @return
	 */
	public static String date2String0(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat4);
		String dateString = formatter.format(date);
		return dateString;
	}
	/**
	 * 将字符串转换为时间 yyyy-MM
	 *
	 * @param strDate
	 * @return
	 */
	public static String date2String1(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat5);
		String dateString = formatter.format(date);
		return dateString;
	}
	
	/**
	 * 将字符串转换为时间 yyyy-MM-dd HH:mm
	 *
	 * @param strDate
	 * @return
	 */
	public static String date2String3(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat2);
		String dateString = formatter.format(date);
		return dateString;
	}
	/**
	 * 根据一个字符串形式的日期，返回是星期1,2,3。。。的字符串
	 *
	 * @param sdate
	 * @return
	 */
	public static int getWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week = c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return week;
	}

	/**
	 * 根据一个字符串形式的日期，返回是星期1,2,3。。。的字符串
	 *
	 * @param sdate
	 * @return
	 */
	public static int getCWeek(Date date) {
		int w = getWeek(date);
		if(w==1) return 7;
		w--;
		return w;
	}

	/**
	 * 根据一个字符串形式的日期，返回是星期1,2,3。。。的字符串
	 *
	 * @param sdate
	 * @return
	 */
	public static String getWeek(String sdate) {
		// 再转换为时间
		Date date = DateUtils.string2DateLong(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	/**
	 * 根据一个字符串形式的日期，返回是星期一、二、三...的字符串
	 *
	 * @param sdate
	 * @return
	 */
	public static String getWeekStr(String sdate) {
		String str = "";
		str = DateUtils.getWeek(sdate);
		if ("1".equals(str)) {
			str = "星期日";
		} else if ("2".equals(str)) {
			str = "星期一";
		} else if ("3".equals(str)) {
			str = "星期二";
		} else if ("4".equals(str)) {
			str = "星期三";
		} else if ("5".equals(str)) {
			str = "星期四";
		} else if ("6".equals(str)) {
			str = "星期五";
		} else if ("7".equals(str)) {
			str = "星期六";
		}
		return str;
	}

	public static Date dateAddMinutes(Date date, int minutes) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	public static Date dateAddHours(Date date, int hours) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hours);
		return cal.getTime();
	}
	 /**
     * 获得当前时间一小时前的开始时间，格式化成yyyy-MM-dd HH:mm:ss<br>
     * 
     * @return 当前时间一小时前的时间
     */
	public static String currentHoursAgoStartTime() {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat1);
		String dateString = formatter.format(new Date());
		String[] ds = dateString.split(" ");
		String string = ds[1].split(":")[0];
		Integer time = Integer.valueOf(string)-1;
		if(string!=null && Integer.valueOf(string)==0){
			time = 23;
			dateString = formatter.format(DateUtils.dateAddDays(new Date(), -1));
			ds = dateString.split(" ");
		}
		if(time<10){
			return ds[0].concat(" 0"+time.toString()+":00:00");
		}
        return ds[0].concat(" "+time.toString()+":00:00");
	}
	
	 /**
     * 获得当前时间一小时前的结束时间，格式化成yyyy-MM-dd HH:mm:ss<br>
     * 
     * @return 当前时间一小时前的时间
     */
	public static String currentHoursAgoEndTime() {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat1);
		String dateString = formatter.format(new Date());
		String[] ds = dateString.split(" ");
		String string = ds[1].split(":")[0];
		Integer time = Integer.valueOf(string);
		if(time<10){
			return ds[0].concat(" 0"+time.toString()+":00:00");
		}
        return ds[0].concat(" "+time.toString()+":00:00");
//        return ds[0].concat(":00:00");
	}

	public static Date dateAddDays(Date date, int addDays) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, addDays);
		return cal.getTime();
	}

	public static Date dateAddMonths(Date date, int addMonths) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, addMonths);
		return cal.getTime();
	}

	public static Date dateAddMonths(Date date, double months) {
		if (date == null)
			return null;
		int addMonths = (int) Math.ceil(months);
		int addDays = (int) Math.round((months - addMonths) * 31);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, addMonths);
		cal.add(Calendar.DATE, addDays);
		return cal.getTime();
	}

	public static Date dateAddYears(Date date, int addYears) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, addYears);
		return cal.getTime();
	}

	public static boolean isDate(String strDate, String pattern) {
		if (strDate == null || strDate.trim().length() <= 0)
			return false;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			sdf.parse(strDate);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static int getIntervalOfDay(Date d1, Date d2) {
		int elapsed = 0;
		boolean isAfter = false;
		Date temp;
		if (d1.after(d2)) {
			temp = d1;
			d1 = d2;
			d2 = temp;
			isAfter = true;
		}

		while (d1.before(d2)) {
			d1 = dateAddDays(d1, 1);
			elapsed++;
		}
		if (isAfter)
			elapsed = 0 - elapsed;
		return elapsed;
	}

	/**
	 * Elapsed days based on current time
	 *
	 * @param date
	 *            Date
	 *
	 * @return int number of days
	 */
	public static int getElapsedDays(Date date) {
		return elapsed(date, Calendar.DATE);
	}

	/**
	 * Elapsed days based on two Date objects
	 *
	 * @param d1
	 *            Date
	 * @param d2
	 *            Date
	 *
	 * @return int number of days
	 */
	public static int getElapsedDays(Date d1, Date d2) {
		return elapsed(d1, d2, Calendar.DATE);
	}

	/**
	 * Elapsed months based on current time
	 *
	 * @param date
	 *            Date
	 *
	 * @return int number of months
	 */
	public static int getElapsedMonths(Date date) {
		return elapsed(date, Calendar.MONTH);
	}

	/**
	 * Elapsed months based on two Date objects
	 *
	 * @param d1
	 *            Date
	 * @param d2
	 *            Date
	 *
	 * @return int number of months
	 */
	public static int getElapsedMonths(Date d1, Date d2) {
		return elapsed(d1, d2, Calendar.MONTH);
	}

	/**
	 * Elapsed years based on current time
	 *
	 * @param date
	 *            Date
	 *
	 * @return int number of years
	 */
	public static int getElapsedYears(Date date) {
		return elapsed(date, Calendar.YEAR);
	}

	/**
	 * Elapsed years based on two Date objects
	 *
	 * @param d1
	 *            Date
	 * @param d2
	 *            Date
	 *
	 * @return int number of years
	 */
	public static int getElapsedYears(Date d1, Date d2) {
		return elapsed(d1, d2, Calendar.YEAR);
	}

	/**
	 * All elaspsed types
	 *
	 * @param g1
	 *            GregorianCalendar
	 * @param g2
	 *            GregorianCalendar
	 * @param type
	 *            int (Calendar.FIELD_NAME)
	 *
	 * @return int number of elapsed "type"
	 */
	private static int elapsed(GregorianCalendar g1, GregorianCalendar g2,
			int type) {
		GregorianCalendar gc1, gc2;
		int elapsed = 0;
		// Create copies since we will be clearing/adding
		if (g2.after(g1)) {
			gc2 = (GregorianCalendar) g2.clone();
			gc1 = (GregorianCalendar) g1.clone();
		} else {
			gc2 = (GregorianCalendar) g1.clone();
			gc1 = (GregorianCalendar) g2.clone();
		}
		if (type == Calendar.MONTH || type == Calendar.YEAR) {
			gc1.clear(Calendar.DATE);
			gc2.clear(Calendar.DATE);
		}
		if (type == Calendar.YEAR) {
			gc1.clear(Calendar.MONTH);
			gc2.clear(Calendar.MONTH);
		}
		while (gc1.before(gc2)) {
			gc1.add(type, 1);
			elapsed++;
		}
		return elapsed;
	}

	/**
	 * All elaspsed types based on date and current Date
	 *
	 * @param date
	 *            Date
	 * @param type
	 *            int (Calendar.FIELD_NAME)
	 *
	 * @return int number of elapsed "type"
	 */
	private static int elapsed(Date date, int type) {
		return elapsed(date, new Date(), type);
	}

	/**
	 * All elaspsed types
	 *
	 * @param d1
	 *            Date
	 * @param d2
	 *            Date
	 * @param type
	 *            int (Calendar.FIELD_NAME)
	 *
	 * @return int number of elapsed "type"
	 */
	private static int elapsed(Date d1, Date d2, int type) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		GregorianCalendar g1 = new GregorianCalendar(cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		cal.setTime(d2);
		GregorianCalendar g2 = new GregorianCalendar(cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		return elapsed(g1, g2, type);
	}

	/**
	 * 计算月的开始时间(2006-08-01 00:00:00)
	 *
	 * @param when
	 * @return
	 */
	public static Date getStartOfMonth(Date when) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(when);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 计算月份的结束时间(2006-08-31 23:59:59)
	 *
	 * @param when
	 * @return
	 */
	public static Date getEndOFMonth(Date when) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(when);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.SECOND, -1);
		return cal.getTime();
	}

	/**
	 * 计算天的开始时间(2006-08-02 00:00:00)
	 *
	 * @param when
	 * @return
	 */
	public static Date getStartOfDay(Date when) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(when);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 计算天的结束时间(2006-08-02 23:59:59)
	 *
	 * @param when
	 * @return
	 */
	public static Date getEndOfDay(Date when) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getStartOfDay(when));
		cal.add(Calendar.DATE, 1);
		cal.add(Calendar.SECOND, -1);
		return cal.getTime();
	}

	public static  String[] convertWeekByDate(Date time) {
		         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
		           Calendar cal = Calendar.getInstance();
		          cal.setTime(time);
		         //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
	         int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
		         if(1 == dayWeek) {
		             cal.add(Calendar.DAY_OF_MONTH, -1);
		         }
		         System.out.println("要计算日期为:"+sdf.format(cal.getTime())); //输出要计算日期
		          cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		        int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
		         cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		        String imptimeBegin = sdf.format(cal.getTime());
		         System.out.println("所在周星期一的日期："+imptimeBegin);
//		         List<String> stenList = new LinkedList<String>();
//		         stenList.add(imptimeBegin);
		         cal.add(Calendar.DATE, 6);
		         String imptimeEnd = sdf.format(cal.getTime());
		         System.out.println("所在周星期日的日期："+imptimeEnd);
//		         stenList.add(imptimeEnd);
		         String[] result = {imptimeBegin,imptimeEnd};
		         return result;
		      }
	
	public static void main(String[] args) {
		System.err.println("convertWeekByDate"+convertWeekByDate(new Date()));
	}
	
	
	/**
	 * 取得制定日期的月最后一天
	 * @param date
	 * @return
	 */

	@SuppressWarnings("deprecation")
	public static String getMonthEndDate(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(GregorianCalendar.MONTH,1);
		gc.add(GregorianCalendar.DATE,-date.getDate());
		Date dateTemp = gc.getTime();
		return date2String(dateTemp);
	}
 
	private static final Map<String, DateFormat> DFS = new HashMap<String, DateFormat>();

	public static DateFormat getFormat(String pattern) {
		DateFormat format = DFS.get(pattern);
		if (format == null) {
			format = new SimpleDateFormat(pattern);
			DFS.put(pattern, format);
		}
		return format;
	}

	public static Date parse(String source, String pattern) {
		if (source == null) {
			return null;
		}
		Date date;
		try {
			date = getFormat(pattern).parse(source);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	public static String format(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		return getFormat(pattern).format(date);
	}

 
	
	public static String toHour(int hour){
		if(hour<10){
			return "0"+hour+":00";
		}else{
			return hour+":00";
		}
	}
	
	public static String toTimeSlot(int hour){
		if(hour<9){
			return "0"+hour+":00-0"+(hour+1)+":00";
		}else if(hour==9){
			return "0"+hour+":00-"+(hour+1)+":00";
		}else{
			return hour+":00-"+(hour+1)+":00";
		}
	}
	
	 /**
     * 获得当前时间一天前的开始时间，格式化成yyyy-MM-dd HH:mm:ss<br>
     * 
     * @return 当前时间一小时前的时间
     */
	public static String yesterday(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat1);
		String dateString = formatter.format(date);
		dateString = formatter.format(DateUtils.dateAddDays(new Date(), -1));
        return dateString.split(" ")[0];
	}
	
	public static List<Integer> getIntervalDate(Date start,Date end) {
		double between=(end.getTime()-start.getTime())/1000;//除以1000是为了转换成秒      
		double day=between/(24*3600);
		List<Integer> dateList = new ArrayList<Integer>();
		for(int i = 0;i<=day;i++){
         Calendar cd = Calendar.getInstance();
         cd.setTime(start);
         cd.add(Calendar.DATE, i);//增加一天   
        //cd.add(Calendar.MONTH, n);//增加一个月
        dateList.add(Integer.parseInt(date2String0(cd.getTime())));
	    }
		return dateList;
	}
}

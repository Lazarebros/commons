package com.d2l2c.common.util.date;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 
 * @author dayanlazare
 *
 */
public class DateUtil {

	public static final String DATE_PATTERN_ISO = "yyyy-MM-dd";

	public static final String DATE_PATTERN_US_YYYY = "MM/dd/yyyy";

	public static final String DATE_PATTERN_US_YY = "MM/dd/yy";
	
	public static Date stringToDate(String sDate, String pattern) {
		Date date = null;
		DateTime dt = stringToDateTime(sDate, pattern);
		if (dt != null) {
			date = dt.toDate();
		}
		return date;
	}

	public static DateTime stringToDateTime(String sDate, String pattern) {
		DateTime dateTime = null;
		if (StringUtils.isNotBlank(sDate)) {
			DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
			dateTime = formatter.parseDateTime(sDate);
		}
		return dateTime;
	}
	
	public static String getMonth(int monthIndex) {
		return DateTime.now().withMonthOfYear(monthIndex).toString("MMM");
	}

}

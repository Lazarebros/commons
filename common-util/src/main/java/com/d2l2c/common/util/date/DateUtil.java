package com.d2l2c.common.util.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author dayanlazare
 *
 */
public class DateUtil {

	public static final String DATE_PATTERN_ISO = "yyyy-MM-dd";

	public static final String DATE_PATTERN_US_YYYY = "MM/dd/yyyy";

	public static final String DATE_PATTERN_US_YY = "MM/dd/yy";
	
	public static LocalDate stringToLocalDate(String sDate, String pattern) {
		LocalDate localDate = null;
		if (StringUtils.isNotBlank(sDate)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			localDate = LocalDate.parse(sDate, formatter);
		}
		return localDate;
	}
	
//	public static String getMonth(int monthIndex) {
//		return DateTime.now().withMonthOfYear(monthIndex).toString("MMM");
//	}

}

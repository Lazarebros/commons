package com.d2l2c.common.util.date;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	
	public static LocalDateTime stringToLocalDateTime(String sDate, String pattern) {
		LocalDateTime localDate = null;
		if (StringUtils.isNotBlank(sDate)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			localDate = LocalDateTime.parse(sDate, formatter);
		}
		return localDate;
	}
	
	public static Timestamp stringToSqlTimestamp(String sDate, String pattern) {
		Timestamp timestamp = null;
		LocalDateTime localDate = stringToLocalDateTime(sDate, pattern);
		if(localDate != null) {
			timestamp = Timestamp.valueOf(localDate);
		}
		return timestamp;
	}
	
	public static void main(String[] args) {
		System.out.println(stringToSqlTimestamp("2018/08/16 14:09:28", "yyyy/MM/dd HH:mm:ss"));
	}

}

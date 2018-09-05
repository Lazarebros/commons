/**
 * 
 */
package com.d2l2c.paycheck.scanner.util.parser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.d2l2c.common.util.date.DateUtil;
import com.d2l2c.paycheck.scanner.util.constants.RegexConstant;

/**
 * @author dayanlazare
 *
 */
public class ParserUtil {

	public static List<LocalDate> getDates(String content, String pattern) {
		List<LocalDate> dates = new ArrayList<LocalDate>();
		Matcher m = Pattern.compile(RegexConstant.DATE).matcher(content);
		while (m.find()) {
			dates.add(DateUtil.stringToLocalDate(m.group(), pattern));
		}
		return dates;
	}

	public static List<BigDecimal> getBigDecimals(String content) {
		List<BigDecimal> numbers = new ArrayList<BigDecimal>();
		Matcher m = Pattern.compile(RegexConstant.NUMBER).matcher(content);
		while (m.find()) {
			numbers.add(new BigDecimal(m.group()));
		}
		return numbers;
	}

}

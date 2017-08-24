/**
 * 
 */
package com.d2l2c.paycheck.scanner.util.extractor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.d2l2c.paycheck.scanner.util.bean.Paycheck;
import com.d2l2c.paycheck.scanner.util.parser.ParserUtil;

/**
 * @author dayanlazare
 *
 */
public abstract class AbstractPaycheckExtractor {
	
	public abstract Paycheck parse(String content);
	
	protected void setDates(Paycheck paycheck, String line, String pattern) {
		List<Date> dates = ParserUtil.getDates(line, pattern);
		paycheck.setStartDate(dates.get(0));
		paycheck.setEndDate(dates.get(1));
	}

	protected void setNumberOfHours(Paycheck paycheck, String line) {
		List<BigDecimal> numbers = ParserUtil.getBigDecimals(line);
		paycheck.setNumberOfHours(numbers.get(0).longValue());
	}

	protected void setHourlyRate(Paycheck paycheck, String line, int index) {
		if(paycheck.getHourlyRate() == null) {
			List<BigDecimal> numbers = ParserUtil.getBigDecimals(line);
			paycheck.setHourlyRate(numbers.get(index));
		}
	}

	protected void setGrossAmount(Paycheck paycheck, String line, int index) {
		List<BigDecimal> numbers = ParserUtil.getBigDecimals(line);
		paycheck.setGrossAmount(numbers.get(index));
	}
	
	protected void setNetPay(Paycheck paycheck, String line) {
		List<BigDecimal> numbers = ParserUtil.getBigDecimals(line);
		paycheck.setNetPay(numbers.get(0));
	}
	
	protected void setReimbursement(Paycheck paycheck, String line) {
		List<BigDecimal> numbers = ParserUtil.getBigDecimals(line);
		paycheck.setReimbursement(numbers.get(0));
	}

}

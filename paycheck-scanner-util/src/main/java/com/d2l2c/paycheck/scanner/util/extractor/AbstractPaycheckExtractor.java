/**
 * 
 */
package com.d2l2c.paycheck.scanner.util.extractor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.d2l2c.paycheck.scanner.util.bean.PaycheckScan;
import com.d2l2c.paycheck.scanner.util.parser.ParserUtil;

/**
 * @author dayanlazare
 *
 */
public abstract class AbstractPaycheckExtractor {
	
	public abstract PaycheckScan parse(String content);
	
	protected void setDates(PaycheckScan paycheck, String line, String pattern) {
		List<LocalDate> dates = ParserUtil.getDates(line, pattern);
		if(dates.size() > 1) {
			paycheck.setStartDate(dates.get(0));
			paycheck.setEndDate(dates.get(1));
		}
	}
	
	protected void setPayDate(PaycheckScan paycheck, String line, String pattern) {
		List<LocalDate> dates = ParserUtil.getDates(line, pattern);
		if(!dates.isEmpty()) {
			LocalDate localDate = dates.get(0);
			paycheck.setPayDate(localDate);
			paycheck.setYear(localDate.getYear());
			paycheck.setMonth(localDate.getMonthValue());
			paycheck.setBiWeek((localDate.getDayOfMonth() < 16) ? 1 : 2);
		}
	}

	protected void setNumberOfHours(PaycheckScan paycheck, String line) {
		List<BigDecimal> numbers = ParserUtil.getBigDecimals(line);
		paycheck.setNumberOfHours(numbers.get(0).longValue());
	}

	protected void setHourlyRate(PaycheckScan paycheck, String line, int index) {
		if(paycheck.getHourlyRate() == null) {
			List<BigDecimal> numbers = ParserUtil.getBigDecimals(line);
			paycheck.setHourlyRate(numbers.get(index));
		}
	}

	protected void setGrossAmount(PaycheckScan paycheck, String line, int index) {
		List<BigDecimal> numbers = ParserUtil.getBigDecimals(line);
		paycheck.setGrossAmount(numbers.get(index));
	}
	
	protected void setNetPay(PaycheckScan paycheck, String line) {
		List<BigDecimal> numbers = ParserUtil.getBigDecimals(line);
		paycheck.setNetPay(numbers.get(0));
	}
	
	protected void setReimbursement(PaycheckScan paycheck, String line) {
		List<BigDecimal> numbers = ParserUtil.getBigDecimals(line);
		paycheck.setReimbursement(numbers.get(0));
	}

}

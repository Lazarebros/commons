/**
 * 
 */
package com.d2l2c.paycheck.scanner.util.extractor;

import java.io.BufferedReader;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.d2l2c.common.util.date.DateUtil;
import com.d2l2c.paycheck.scanner.util.bean.PaycheckScan;
import com.d2l2c.paycheck.scanner.util.constants.Constants;
import com.d2l2c.paycheck.scanner.util.constants.RegexConstant;

/**
 * @author dayanlazare
 *
 */
public class MS3PaycheckExtractor extends AbstractPaycheckExtractor {

	private static final Logger logger = LoggerFactory.getLogger(MS3PaycheckExtractor.class);

	@Override
	public PaycheckScan parse(String content) {
		PaycheckScan paycheck = new PaycheckScan(Constants.MS3_COMPANY_CODE, Constants.MS3_COMPANY_NAME);
		try (BufferedReader reader = new BufferedReader(new StringReader(content));
				LineNumberReader lineReader = new LineNumberReader(reader);) {

			String line = null;
			while ((line = lineReader.readLine()) != null) {
				if (Pattern.compile(RegexConstant.PAY_PERIOD, Pattern.CASE_INSENSITIVE).matcher(line).find()) {
					setDates(paycheck, line, DateUtil.DATE_PATTERN_US_YYYY);
				} else if (Pattern.compile(RegexConstant.PAY_DATE, Pattern.CASE_INSENSITIVE).matcher(line).find()) {
					setPayDate(paycheck, line, DateUtil.DATE_PATTERN_US_YYYY);
				} else if (Pattern.compile(RegexConstant.REGULAR_PAY, Pattern.CASE_INSENSITIVE).matcher(line).find()) {
					setNumberOfHours(paycheck, line);
					setHourlyRate(paycheck, line, 1);
					setGrossAmount(paycheck, line, 2);
				} else if (Pattern.compile(RegexConstant.NET_PAY).matcher(line).find()) {
					setNetPay(paycheck, line);
				} else if (Pattern.compile(RegexConstant.REIMBURSEMENT, Pattern.CASE_INSENSITIVE).matcher(line).find()) {
					setReimbursement(paycheck, line);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return paycheck;
	}

}

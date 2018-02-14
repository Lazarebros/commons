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
public class MMIPaycheckExtractor extends AbstractPaycheckExtractor {
	
	private static final Logger logger = LoggerFactory.getLogger(MMIPaycheckExtractor.class);

	@Override
	public PaycheckScan parse(String content) {
		PaycheckScan paycheck = new PaycheckScan(Constants.MMI_COMPANY_CODE, Constants.MMI_COMPANY_NAME);
		try (BufferedReader reader = new BufferedReader(new StringReader(content));
				LineNumberReader lineReader = new LineNumberReader(reader);) {

			String line = null;
			while ((line = lineReader.readLine()) != null) {
				if (Pattern.compile(RegexConstant.PAY_PERIOD, Pattern.CASE_INSENSITIVE).matcher(line).find()) {
					setDates(paycheck, line, DateUtil.DATE_PATTERN_US_YY);
				} else if (Pattern.compile(RegexConstant.PAY_DATE, Pattern.CASE_INSENSITIVE).matcher(line).find()) {
					setPayDate(paycheck, line, DateUtil.DATE_PATTERN_US_YY);
				} else if (Pattern.compile(RegexConstant.GROSS_EARNINGS, Pattern.CASE_INSENSITIVE).matcher(line).find()) {
					setNumberOfHours(paycheck, line);
					setGrossAmount(paycheck, line, 1);
				} else if (Pattern.compile(RegexConstant.WEIGHTWATCHE_REGULAR).matcher(line).find()) {
					setHourlyRate(paycheck, line, 3);
				} else if (Pattern.compile(RegexConstant.NET_PAY).matcher(line).find()) {
					setNetPay(paycheck, line);
				} else if (line.contains("IExp") || line.contains("CBEx")) {
					setReimbursement(paycheck, line);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return paycheck;
	}

}

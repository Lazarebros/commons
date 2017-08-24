/**
 * 
 */
package com.d2l2c.paycheck.scanner.util.extractor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;

import com.d2l2c.common.util.date.DateUtil;
import com.d2l2c.common.util.scanner.ScannerUtil;
import com.d2l2c.paycheck.scanner.util.bean.Paycheck;

/**
 * @author dayanlazare
 *
 */
public class PaycheckExtractorTest {

	private static final String MS3_FILE_NAME = "MS3-2017-08-15.pdf";

	private static final String MMI_FILE_NAME = "MMI-2015-05-29.pdf";

	@Test
	public void testMS3Parse() {
		Paycheck paycheck = this.getPaycheck(MS3_FILE_NAME);

		assertThat(paycheck.getCompanyName(), is(MS3PaycheckExtractor.COMPANY_NAME));
		assertThat(paycheck.getStartDate(), is(DateUtil.stringToDate("07/16/2017", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheck.getEndDate(), is(DateUtil.stringToDate("07/31/2017", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheck.getNumberOfHours(), is(119L));
		assertThat(paycheck.getHourlyRate(), is(new BigDecimal("100.00")));
		assertThat(paycheck.getGrossAmount(), is(new BigDecimal("11900.00")));
		assertThat(paycheck.getNetPay(), is(new BigDecimal("15665.16")));
		assertThat(paycheck.getReimbursement(), is(new BigDecimal("7092.02")));
	}

	@Test
	public void testMMIParse() {
		Paycheck paycheck = this.getPaycheck(MMI_FILE_NAME);
		
		assertThat(paycheck.getCompanyName(), is(MMIPaycheckExtractor.COMPANY_NAME));
		assertThat(paycheck.getStartDate(), is(DateUtil.stringToDate("05/11/2015", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheck.getEndDate(), is(DateUtil.stringToDate("05/24/2015", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheck.getNumberOfHours(), is(106L));
		assertThat(paycheck.getHourlyRate(), is(new BigDecimal("81.0000")));
		assertThat(paycheck.getGrossAmount(), is(new BigDecimal("8586.00")));
		assertThat(paycheck.getNetPay(), is(new BigDecimal("5664.67")));
		assertThat(paycheck.getReimbursement(), is(new BigDecimal(0)));
	}
	
	private Paycheck getPaycheck(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		String content = ScannerUtil.scanFileToText(file);

		AbstractPaycheckExtractor extractor = PaycheckExtractorFactory.getInstance(content);
		return extractor.parse(content);
	}

}

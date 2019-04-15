/**
 * 
 */
package com.d2l2c.paycheck.scanner.util.extractor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.d2l2c.common.util.date.DateUtil;
import com.d2l2c.common.util.scanner.ScannerUtil;
import com.d2l2c.paycheck.scanner.util.bean.PaycheckScan;
import com.d2l2c.paycheck.scanner.util.constants.Constants;

/**
 * @author dayanlazare
 *
 */
public class PaycheckExtractorTest {

	private static final Logger logger = LoggerFactory.getLogger(PaycheckExtractorTest.class);

	private static final String MS3_FILE_NAME = "MS3-2017-08-15.pdf";

	private static final String MMI_FILE_NAME = "MMI-2015-05-29.pdf";

	@Test
	public void testMS3Parse() {
		PaycheckScan paycheckScan = this.getPaycheck(MS3_FILE_NAME);

		assertThat(paycheckScan.getCompanyCode(), is(Constants.MS3_COMPANY_CODE));
		assertThat(paycheckScan.getBiWeek(), is(1));
		assertThat(paycheckScan.getPayDate(), is(DateUtil.stringToLocalDate("08/15/2017", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheckScan.getStartDate(), is(DateUtil.stringToLocalDate("07/16/2017", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheckScan.getEndDate(), is(DateUtil.stringToLocalDate("07/31/2017", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheckScan.getNumberOfHours(), is(119L));
		assertThat(paycheckScan.getHourlyRate(), is(new BigDecimal("100.00")));
		assertThat(paycheckScan.getGrossAmount(), is(new BigDecimal("11900.00")));
		assertThat(paycheckScan.getNetPay(), is(new BigDecimal("15665.16")));
		assertThat(paycheckScan.getReimbursement(), is(new BigDecimal("7092.02")));
		assertThat(paycheckScan.getFederalTax(), is(new BigDecimal("2441.31")));
		assertThat(paycheckScan.getStateTax(), is(new BigDecimal("713.00")));
		assertThat(paycheckScan.getSocialSecurity(), is(new BigDecimal("0.00")));
		assertThat(paycheckScan.getMedicare(), is(new BigDecimal("172.55")));
		
		BigDecimal expectedGross = paycheckScan.getHourlyRate().multiply(new BigDecimal(paycheckScan.getExpectedNumberOfHours())).setScale(Constants.COMPUTE_SCALE, BigDecimal.ROUND_HALF_UP);
		BigDecimal expectedNetPay = expectedGross.multiply(paycheckScan.getNetPercentageOfGross()).setScale(Constants.COMPUTE_SCALE, BigDecimal.ROUND_HALF_UP);
		
		assertThat(expectedGross, is(new BigDecimal("8000.00")));
		assertThat(expectedNetPay, is(new BigDecimal("5360.00")));
	}

	@Test
	public void testMMIParse() {
		PaycheckScan paycheckScan = this.getPaycheck(MMI_FILE_NAME);
		
		assertThat(paycheckScan.getCompanyCode(), is(Constants.MMI_COMPANY_CODE));
		assertThat(paycheckScan.getBiWeek(), is(2));
		assertThat(paycheckScan.getPayDate(), is(DateUtil.stringToLocalDate("05/29/2015", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheckScan.getStartDate(), is(DateUtil.stringToLocalDate("05/11/2015", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheckScan.getEndDate(), is(DateUtil.stringToLocalDate("05/24/2015", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheckScan.getNumberOfHours(), is(106L));
		assertThat(paycheckScan.getHourlyRate(), is(new BigDecimal("81.0000")));
		assertThat(paycheckScan.getGrossAmount(), is(new BigDecimal("8586.00")));
		assertThat(paycheckScan.getNetPay(), is(new BigDecimal("5664.67")));
		assertThat(paycheckScan.getReimbursement(), is(new BigDecimal(0)));
		assertThat(paycheckScan.getFederalTax(), is(new BigDecimal("1684.21")));
		assertThat(paycheckScan.getStateTax(), is(new BigDecimal("580.29")));
		assertThat(paycheckScan.getSocialSecurity(), is(new BigDecimal("532.33")));
		assertThat(paycheckScan.getMedicare(), is(new BigDecimal("124.50")));

		BigDecimal expectedGross = paycheckScan.getHourlyRate().multiply(new BigDecimal(paycheckScan.getExpectedNumberOfHours())).setScale(Constants.COMPUTE_SCALE, BigDecimal.ROUND_HALF_UP);
		BigDecimal expectedNetPay = expectedGross.multiply(paycheckScan.getNetPercentageOfGross()).setScale(Constants.COMPUTE_SCALE, BigDecimal.ROUND_HALF_UP);
		
		assertThat(expectedGross, is(new BigDecimal("6480.00")));
		assertThat(expectedNetPay, is(new BigDecimal("4341.60")));
	}
	
	private PaycheckScan getPaycheck(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		String content = ScannerUtil.scanFileToText(file);
		
		logger.info(content);

		AbstractPaycheckExtractor extractor = PaycheckExtractorFactory.getInstance(content);
		return extractor.parse(content);
	}

}

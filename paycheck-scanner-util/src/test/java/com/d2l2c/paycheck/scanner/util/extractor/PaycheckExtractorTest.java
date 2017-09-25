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
import com.d2l2c.paycheck.scanner.util.bean.PaycheckScan;

/**
 * @author dayanlazare
 *
 */
public class PaycheckExtractorTest {

	private static final String MS3_FILE_NAME = "MS3-2017-08-15.pdf";

	private static final String MMI_FILE_NAME = "MMI-2015-05-29.pdf";

	@Test
	public void testMS3Parse() {
		PaycheckScan paycheckScan = this.getPaycheck(MS3_FILE_NAME);

		assertThat(paycheckScan.getCompanyCode(), is(MS3PaycheckExtractor.COMPANY_CODE));
		assertThat(paycheckScan.getYear(), is(2017));
		assertThat(paycheckScan.getMonth(), is(8));
		assertThat(paycheckScan.getBiWeek(), is(1));
		assertThat(paycheckScan.getStartDate(), is(DateUtil.stringToDate("07/16/2017", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheckScan.getEndDate(), is(DateUtil.stringToDate("07/31/2017", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheckScan.getNumberOfHours(), is(119L));
		assertThat(paycheckScan.getHourlyRate(), is(new BigDecimal("100.00")));
		assertThat(paycheckScan.getGrossAmount(), is(new BigDecimal("11900.00")));
		assertThat(paycheckScan.getNetPay(), is(new BigDecimal("15665.16")));
		assertThat(paycheckScan.getReimbursement(), is(new BigDecimal("7092.02")));
	}

	@Test
	public void testMMIParse() {
		PaycheckScan paycheckScan = this.getPaycheck(MMI_FILE_NAME);
		
		assertThat(paycheckScan.getCompanyCode(), is(MMIPaycheckExtractor.COMPANY_CODE));
		assertThat(paycheckScan.getYear(), is(2015));
		assertThat(paycheckScan.getMonth(), is(5));
		assertThat(paycheckScan.getBiWeek(), is(2));
		assertThat(paycheckScan.getStartDate(), is(DateUtil.stringToDate("05/11/2015", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheckScan.getEndDate(), is(DateUtil.stringToDate("05/24/2015", DateUtil.DATE_PATTERN_US_YYYY)));
		assertThat(paycheckScan.getNumberOfHours(), is(106L));
		assertThat(paycheckScan.getHourlyRate(), is(new BigDecimal("81.0000")));
		assertThat(paycheckScan.getGrossAmount(), is(new BigDecimal("8586.00")));
		assertThat(paycheckScan.getNetPay(), is(new BigDecimal("5664.67")));
		assertThat(paycheckScan.getReimbursement(), is(new BigDecimal(0)));
	}
	
	private PaycheckScan getPaycheck(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		String content = ScannerUtil.scanFileToText(file);

		AbstractPaycheckExtractor extractor = PaycheckExtractorFactory.getInstance(content);
		return extractor.parse(content);
	}

}

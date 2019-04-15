package com.d2l2c.paycheck.scanner.util.bean;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.d2l2c.paycheck.scanner.util.constants.Constants;

/**
 * @author dayanlazare
 *
 */
public class PaycheckScan {

	private static final Long EXPECTED_NUMBER_OF_HOURS = 80L;

	private static final BigDecimal DEFAULT_NET_PERCENTAGE_OF_GROSS = new BigDecimal("0.67");

	private Long id;
	private String companyCode;
	private String companyName;
	private int year;
	private int month;
	private int biWeek;
	private LocalDate payDate;
	private LocalDate startDate;
	private LocalDate endDate;
	private Long numberOfHours;
	private BigDecimal hourlyRate;
	private BigDecimal grossAmount;
	private BigDecimal netPay;
	private BigDecimal reimbursement = new BigDecimal(0);
	private BigDecimal federalTax;
	private BigDecimal stateTax = new BigDecimal(0);
	private BigDecimal socialSecurity;
	private BigDecimal medicare;

	public PaycheckScan(String companyCode, String companyName) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getBiWeek() {
		return biWeek;
	}

	public void setBiWeek(int biWeek) {
		this.biWeek = biWeek;
	}

	public LocalDate getPayDate() {
		return payDate;
	}

	public void setPayDate(LocalDate payDate) {
		this.payDate = payDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Long getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(Long numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(BigDecimal rate) {
		this.hourlyRate = rate;
	}

	public BigDecimal getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(BigDecimal gross) {
		this.grossAmount = gross;
	}

	public BigDecimal getNetPay() {
		return netPay;
	}

	public void setNetPay(BigDecimal netPay) {
		this.netPay = netPay;
	}

	public BigDecimal getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(BigDecimal reimbursement) {
		this.reimbursement = this.reimbursement.add(reimbursement);
	}

	public BigDecimal getFederalTax() {
		return federalTax;
	}

	public void setFederalTax(BigDecimal federalTax) {
		this.federalTax = federalTax;
	}

	public BigDecimal getStateTax() {
		return stateTax;
	}

	public void setStateTax(BigDecimal stateTax) {
		this.stateTax = this.stateTax.add(stateTax);
	}

	public BigDecimal getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(BigDecimal socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public BigDecimal getMedicare() {
		return medicare;
	}

	public void setMedicare(BigDecimal medicare) {
		this.medicare = medicare;
	}

	public BigDecimal getExpectedGross() {
		return hourlyRate.multiply(new BigDecimal(EXPECTED_NUMBER_OF_HOURS)).setScale(Constants.COMPUTE_SCALE,
				BigDecimal.ROUND_HALF_UP);
	}

	public Long getExpectedNumberOfHours() {
		return EXPECTED_NUMBER_OF_HOURS;
	}

	public BigDecimal getNetPercentageOfGross() {
		return DEFAULT_NET_PERCENTAGE_OF_GROSS;
	}

	@Override
	public String toString() {
		return "PaycheckScan [id=" + id + ", companyName=" + companyCode + ", startDate=" + startDate + ", endDate="
				+ endDate + ", numberOfHours=" + numberOfHours + ", hourlyRate=" + hourlyRate + ", grossAmount="
				+ grossAmount + ", netPay=" + netPay + ", reimbursement=" + reimbursement + "]";
	}

}

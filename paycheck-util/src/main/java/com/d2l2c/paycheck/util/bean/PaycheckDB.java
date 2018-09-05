/**
 * 
 */
package com.d2l2c.paycheck.util.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dlazare
 *
 */
public class PaycheckDB {

	private Long id;
	private String companyCode;
	private int year;
	private int month;
	private int biWeek;
	private Date payDate;
	private Date startDate;
	private Date endDate;
	private Long numberOfHours;
	private Long expectedNumberOfHours;
	private BigDecimal netPercentageOfGross;
	private BigDecimal hourlyRate;
	private BigDecimal grossAmount;
	private BigDecimal netPay;
	private BigDecimal reimbursement;

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

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(Long numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public Long getExpectedNumberOfHours() {
		return expectedNumberOfHours;
	}

	public void setExpectedNumberOfHours(Long expectedNumberOfHours) {
		this.expectedNumberOfHours = expectedNumberOfHours;
	}

	public BigDecimal getNetPercentageOfGross() {
		return netPercentageOfGross;
	}

	public void setNetPercentageOfGross(BigDecimal netPercentageOfGross) {
		this.netPercentageOfGross = netPercentageOfGross;
	}

	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public BigDecimal getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(BigDecimal grossAmount) {
		this.grossAmount = grossAmount;
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
		this.reimbursement = reimbursement;
	}

}

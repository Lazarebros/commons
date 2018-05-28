package com.d2l2c.paycheck.util.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author dlazare
 *
 */
public class PaycheckDetail {

	private int month;
	private Long numberOfHours;
	private BigDecimal hourlyRate;
	private BigDecimal expectedGrossAmount;
	private BigDecimal grossAmount;
	private BigDecimal expectedNetPay;
	private BigDecimal netPay;
	private BigDecimal reimbursement;

	private Collection<PaycheckUnit> paychecks = new ArrayList<PaycheckUnit>();

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
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

	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public BigDecimal getExpectedGrossAmount() {
		return expectedGrossAmount;
	}

	public void setExpectedGrossAmount(BigDecimal expectedGrossAmount) {
		this.expectedGrossAmount = expectedGrossAmount;
	}

	public BigDecimal getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(BigDecimal grossAmount) {
		this.grossAmount = grossAmount;
	}

	public BigDecimal getExpectedNetPay() {
		return expectedNetPay;
	}

	public void setExpectedNetPay(BigDecimal expectedNetPay) {
		this.expectedNetPay = expectedNetPay;
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

	public Collection<PaycheckUnit> getPaychecks() {
		return paychecks;
	}

	public void setPaychecks(Collection<PaycheckUnit> paychecks) {
		this.paychecks = paychecks;
	}

	public void add(PaycheckUnit paycheckUnit) {
		paychecks.add(paycheckUnit);
	}

}

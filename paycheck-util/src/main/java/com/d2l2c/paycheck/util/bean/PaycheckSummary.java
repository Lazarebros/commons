/**
 * 
 */
package com.d2l2c.paycheck.util.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author dlazare
 *
 */
public class PaycheckSummary implements Comparable<PaycheckSummary> {

	private int year;
	private int yearProgress;
	private Long numnerOfPaychecks;
	private BigDecimal expectedGrossAmount;
	private BigDecimal grossAmount;
	private BigDecimal grossAmountRemain;
	private BigDecimal reimbursement;
	private BigDecimal expectedNetPay;
	private BigDecimal netPay;
	private BigDecimal netPayReal;
	private BigDecimal netPayRemain;
	private BigDecimal netPayRealMean;

	private List<PaycheckDetail> paycheckDetails = null;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYearProgress() {
		return yearProgress;
	}

	public void setYearProgress(int yearProgress) {
		this.yearProgress = yearProgress;
	}

	public Long getNumnerOfPaychecks() {
		return numnerOfPaychecks;
	}

	public void setNumnerOfPaychecks(Long numnerOfPaychecks) {
		this.numnerOfPaychecks = numnerOfPaychecks;
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

	public BigDecimal getGrossAmountRemain() {
		return grossAmountRemain;
	}

	public void setGrossAmountRemain(BigDecimal grossAmountRemain) {
		this.grossAmountRemain = grossAmountRemain;
	}

	public BigDecimal getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(BigDecimal reimbursement) {
		this.reimbursement = reimbursement;
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

	public BigDecimal getNetPayReal() {
		return netPayReal;
	}

	public void setNetPayReal(BigDecimal netPayReal) {
		this.netPayReal = netPayReal;
	}

	public BigDecimal getNetPayRemain() {
		return netPayRemain;
	}

	public void setNetPayRemain(BigDecimal netPayRemain) {
		this.netPayRemain = netPayRemain;
	}

	public BigDecimal getNetPayRealMean() {
		return netPayRealMean;
	}

	public void setNetPayRealMean(BigDecimal netPayRealMean) {
		this.netPayRealMean = netPayRealMean;
	}

	public List<PaycheckDetail> getPaycheckDetails() {
		return paycheckDetails;
	}

	public void setPaycheckDetails(List<PaycheckDetail> paycheckDetail) {
		this.paycheckDetails = paycheckDetail;
	}

	public void add(PaycheckDetail paycheckDetail) {
		paycheckDetails.add(paycheckDetail);
	}

	@Override
	public int compareTo(PaycheckSummary o) {
		return this.year - o.getYear();
	}

}

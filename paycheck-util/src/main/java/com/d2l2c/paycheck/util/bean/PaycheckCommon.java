/**
 * 
 */
package com.d2l2c.paycheck.util.bean;

import java.math.BigDecimal;

/**
 * @author dlazare
 *
 */
public class PaycheckCommon {

	private Long numberOfHours;
	private BigDecimal grossAmount;
	private BigDecimal netPay;
	private BigDecimal reimbursement;
	private BigDecimal federalTax;
	private BigDecimal stateTax;
	private BigDecimal socialSecurity;
	private BigDecimal medicare;

	public Long getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(Long numberOfHours) {
		this.numberOfHours = numberOfHours;
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
		this.stateTax = stateTax;
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

}

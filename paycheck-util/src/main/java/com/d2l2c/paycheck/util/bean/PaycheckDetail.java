package com.d2l2c.paycheck.util.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author dlazare
 *
 */
public class PaycheckDetail extends PaycheckCommon implements Comparable<PaycheckDetail> {

	private int month;
	private BigDecimal hourlyRate;
	private BigDecimal expectedGrossAmount;
	private BigDecimal expectedNetPay;
	private BigDecimal netPayReal;

	private List<PaycheckUnit> paychecks = new ArrayList<PaycheckUnit>();

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
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

	public BigDecimal getExpectedNetPay() {
		return expectedNetPay;
	}

	public void setExpectedNetPay(BigDecimal expectedNetPay) {
		this.expectedNetPay = expectedNetPay;
	}

	public Collection<PaycheckUnit> getPaychecks() {
		return paychecks;
	}

	public void setPaychecks(List<PaycheckUnit> paychecks) {
		this.paychecks = paychecks;
	}

	public void add(PaycheckUnit paycheckUnit) {
		paychecks.add(paycheckUnit);
	}

	public BigDecimal getNetPayReal() {
		return netPayReal;
	}

	public void setNetPayReal(BigDecimal netPayReal) {
		this.netPayReal = netPayReal;
	}

	@Override
	public int compareTo(PaycheckDetail o) {
		return this.month - o.getMonth();
	}

}

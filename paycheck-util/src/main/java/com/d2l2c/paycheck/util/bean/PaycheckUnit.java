/**
 * 
 */
package com.d2l2c.paycheck.util.bean;

import java.math.BigDecimal;

/**
 * @author dlazare
 *
 */
public class PaycheckUnit extends PaycheckCommon {

	private Long id;
	private String companyCode;
	private int biWeek;
	private String payDate;
	private String startDate;
	private String endDate;
	private BigDecimal netPayReal;

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

	public int getBiWeek() {
		return biWeek;
	}

	public void setBiWeek(int biWeek) {
		this.biWeek = biWeek;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getNetPayReal() {
		return netPayReal;
	}

	public void setNetPayReal(BigDecimal netPayReal) {
		this.netPayReal = netPayReal;
	}

}

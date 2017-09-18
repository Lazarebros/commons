/**
 * 
 */
package com.d2l2c.paycheck.scanner.util.bean;

/**
 * @author dayanlazare
 *
 */
public class CompanyScan {

	private Long id;
	private String code;
	private String name;

	public CompanyScan(String code) {
		super();
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

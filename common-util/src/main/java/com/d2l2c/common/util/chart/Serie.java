package com.d2l2c.common.util.chart;

import java.util.List;

/**
 * @author dayanlazare
 */
public class Serie {
	
	public static final String LINE_TYPE = "line";
	public static final String BAR_TYPE = "bar";
	
	private String name;
	private String type;
	private List<String> data;
	
	public Serie(String name, String type, List<String> data) {
		this.name = name;
		this.type = type;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

}
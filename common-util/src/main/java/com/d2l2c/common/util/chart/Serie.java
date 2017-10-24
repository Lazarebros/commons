package com.d2l2c.common.util.chart;

import java.util.List;

/**
 * @author dayanlazare
 */
public class Serie {

	private String name;
	private String type;
	private Integer barMaxWidth;
	private boolean smooth = true;
	private List<Object> data;

	public Serie(String name, String type, Integer barMaxWidth, List<Object> data) {
		this.name = name;
		this.type = type;
		this.barMaxWidth = barMaxWidth;
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

	public Integer getBarMaxWidth() {
		return barMaxWidth;
	}

	public void setBarMaxWidth(Integer barMaxWidth) {
		this.barMaxWidth = barMaxWidth;
	}

	public boolean isSmooth() {
		return smooth;
	}

	public void setSmooth(boolean smooth) {
		this.smooth = smooth;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

}
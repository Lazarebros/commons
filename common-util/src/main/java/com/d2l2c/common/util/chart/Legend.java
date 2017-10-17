package com.d2l2c.common.util.chart;

import java.util.Collection;

/**
 * @author dayanlazare
 */
public class Legend {

	private Collection<String> data;

	private String left = ChartConstants.Position.CENTER;

	private TextStyle textStyle;

	public Legend(TextStyle textStyle) {
		this.textStyle = textStyle;
	}

	public Legend(Collection<String> data) {
		this.data = data;
	}

	public Legend(Collection<String> data, String left, TextStyle textStyle) {
		this.data = data;
		this.left = left;
		this.textStyle = textStyle;
	}

	public Collection<String> getData() {
		return data;
	}

	public void setData(Collection<String> data) {
		this.data = data;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public TextStyle getTextStyle() {
		return textStyle;
	}

	public void setTextStyle(TextStyle textStyle) {
		this.textStyle = textStyle;
	}

}

/**
 * 
 */
package com.d2l2c.common.util.chart;

/**
 * @author dayanlazare
 *
 */
public class TextStyle {

	private String color;
	private int fontSize;
	
	public TextStyle() {
		super();
	}
	
	public TextStyle(String color, int fontSize) {
		super();
		this.color = color;
		this.fontSize = fontSize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

}

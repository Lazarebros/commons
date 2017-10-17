/**
 * 
 */
package com.d2l2c.common.util.chart;

/**
 * @author dayanlazare
 *
 */
public class Title {

	private String text;

	private String left = ChartConstants.Position.LEFT;

	private TextStyle textStyle = new TextStyle("#00FFFF", 24);

	public Title(String text, TextStyle textStyle) {
		this.text = text;
		this.textStyle = textStyle;
	}

	public Title(String text, String left) {
		this.text = text;
		this.left = left;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

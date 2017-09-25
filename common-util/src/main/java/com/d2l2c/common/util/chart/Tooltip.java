/**
 * 
 */
package com.d2l2c.common.util.chart;

/**
 * @author dayanlazare
 *
 */
public class Tooltip {

	public static final String AXIS = "axis";

	private String trigger;
	
	public Tooltip(String trigger) {
		this.trigger = trigger;
	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}

}

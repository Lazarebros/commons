/**
 * 
 */
package com.d2l2c.common.util.chart;

import java.util.List;

/**
 * @author dayanlazare
 */
public class Axis {

	private boolean boundaryGap;
	private List<String> data;

	public Axis() {
		super();
	}

	public Axis(boolean boundaryGap, List<String> data) {
		super();
		this.boundaryGap = boundaryGap;
		this.data = data;
	}

	public boolean isBoundaryGap() {
		return boundaryGap;
	}

	public void setBoundaryGap(boolean boundaryGap) {
		this.boundaryGap = boundaryGap;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

}

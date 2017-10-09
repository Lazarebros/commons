package com.d2l2c.common.util.chart;

import java.util.Collection;

/**
 * @author dayanlazare
 */
public class Legend {

	private Collection<String> data;

	public Legend(Collection<String> data) {
		this.data = data;
	}

	public Collection<String> getData() {
		return data;
	}

	public void setData(Collection<String> data) {
		this.data = data;
	}

}

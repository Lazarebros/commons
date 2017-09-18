package com.d2l2c.common.util.chart;

import java.util.ArrayList;
import java.util.List;

public class Chart {

	private Title title;
	private Tooltip tooltip;
	private Legend legend;
	private Axis xAxis;
	private Axis yAxis;
	private List<Serie> series = new ArrayList<Serie>();

	public Chart(Title title, Legend legend, Axis xAxis, Axis yAxis) {
		super();
		this.title = title;
		this.legend = legend;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Tooltip getTooltip() {
		return tooltip;
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public Axis getxAxis() {
		return xAxis;
	}

	public void setxAxis(Axis xAxis) {
		this.xAxis = xAxis;
	}

	public Axis getyAxis() {
		return yAxis;
	}

	public void setyAxis(Axis yAxis) {
		this.yAxis = yAxis;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public void addSerie(Serie serie) {
		series.add(serie);
	}

}
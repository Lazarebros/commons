package com.d2l2c.common.util.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chart {
	private String backgroundColor = "transparent";
	private List<String> color = Arrays.asList("#FDFE53","#FF395A", "#40D994", "#d48265", "#91c7ae","#749f83",  "#ca8622", "#bda29a","#6e7074", "#546570", "#c4ccd3");
	private Title title;
	private Tooltip tooltip;
	private Legend legend;
	private Axis xAxis;
	private Axis yAxis;
	private Grid grid;
	private List<Serie> series = new ArrayList<Serie>();

	public Chart() {
		super();
	}

	public Chart(Grid grid) {
		super();
		this.grid = grid;
	}

	public Chart(Title title, Legend legend, Axis xAxis, Axis yAxis) {
		super();
		this.title = title;
		this.legend = legend;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}
	
	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
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
	
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
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
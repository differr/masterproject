package com.bsd.masterproject.vo;

public class BoxVO {
	private String name;
	
	private double width;
	private double length;
	private double height;
	private double thickness;
	private double widthInner;
	private double lengthInner;
	private double heightInner;
	private double capacity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getThickness() {
		return thickness;
	}
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	public double getWidthInner() {
		return this.width - this.thickness;
	}
	
	public double getLengthInner() {
		return this.length - this.thickness;
	}
	public double getHeightInner() {
		return this.height - this.thickness;
	}
	public double getCapacity() {
		return this.getHeightInner() * this.getLengthInner() * this.getWidthInner();
	}
	
}

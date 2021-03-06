package com.bsd.masterproject.vo;

public class BoxVO {
	private String name;
	
	private double width;
	private double length;
	private double height;
	private double capacity;
	
	public BoxVO() {}
	
	public BoxVO(String name, double width, double length, double height, double capacity) {
		setName( name );
		setWidth( width );
		setLength( length );
		setHeight( height );
		setCapacity( capacity );
	}
	
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
	public double getCapacity() {
		return this.capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	
}

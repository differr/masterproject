package com.bsd.masterproject.vo;

import java.util.List;

public class ProductVO {
	private String prodCode;
	private String name;
	private String packageType;
	private String prodType;
	private double weight;
	private double capacity;
	private String status;
	private List<ColorVO> colorList;
	
	//For wrap plastic
	private double width;
	private double length;
	private double height;
	
	
	//For packagingType
	private String boxForCapacity;
	private int fillAmt;
	
	
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ColorVO> getColorList() {
		return colorList;
	}
	public void setColorList(List<ColorVO> colorList) {
		this.colorList = colorList;
	}
	public String getBoxForCapacity() {
		return boxForCapacity;
	}
	public void setBoxForCapacity(String boxForCapacity) {
		this.boxForCapacity = boxForCapacity;
	}
	public int getFillAmt() {
		return fillAmt;
	}
	public void setFillAmt(int fillAmt) {
		this.fillAmt = fillAmt;
	}
	
}

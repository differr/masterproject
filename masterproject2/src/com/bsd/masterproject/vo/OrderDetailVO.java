package com.bsd.masterproject.vo;

public class OrderDetailVO {
	private String prodCode;
	private String colorCode;
	private int leastAmt;
	private int orderAmt;
	
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public int getLeastAmt() {
		return leastAmt;
	}
	public void setLeastAmt(int leastAmt) {
		this.leastAmt = leastAmt;
	}
	public int getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(int orderAmt) {
		this.orderAmt = orderAmt;
	}
}

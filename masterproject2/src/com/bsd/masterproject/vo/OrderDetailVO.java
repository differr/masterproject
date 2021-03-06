package com.bsd.masterproject.vo;

import java.io.Serializable;

public class OrderDetailVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1389758616401095468L;
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

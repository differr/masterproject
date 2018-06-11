package com.bsd.masterproject.vo;

import java.util.List;

public class OrderVO {
	private String orderCode;
	private String custCode;
	private AddressVO destination;
	//soap list
	private List<OrderDetailVO> orderDetailList;
	
	//Transport Detail
	private String transportCode;
	private List<TransAddServiceVO> transAdd;
	private double transCost;
	private double totalCost;
	private double callCost;
	private double discount;
	
	private String receiveName;
	private String receiveTel;
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public AddressVO getDestination() {
		return destination;
	}
	public void setDestination(AddressVO destination) {
		this.destination = destination;
	}
	public List<OrderDetailVO> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<OrderDetailVO> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	public String getTransportCode() {
		return transportCode;
	}
	public void setTransportCode(String transportCode) {
		this.transportCode = transportCode;
	}
	public List<TransAddServiceVO> getTransAdd() {
		return transAdd;
	}
	public void setTransAdd(List<TransAddServiceVO> transAdd) {
		this.transAdd = transAdd;
	}
	public double getTransCost() {
		return transCost;
	}
	public void setTransCost(double transCost) {
		this.transCost = transCost;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double getCallCost() {
		return callCost;
	}
	public void setCallCost(double callCost) {
		this.callCost = callCost;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getReceiveTel() {
		return receiveTel;
	}
	public void setReceiveTel(String receiveTel) {
		this.receiveTel = receiveTel;
	}
	
	
	
}

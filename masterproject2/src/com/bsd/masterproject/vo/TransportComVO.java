package com.bsd.masterproject.vo;

import java.util.List;

public class TransportComVO {
	private String transportCode;
	private String name;
	private int normalDeliverDT;
	private List<TransConditionCostVO> condCostList;
	private List<TransAddServiceVO> transAddServList;
	private List<TransPeriodVO> transPeriodList;
	public String getTransportCode() {
		return transportCode;
	}
	public void setTransportCode(String transportCode) {
		this.transportCode = transportCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNormalDeliverDT() {
		return normalDeliverDT;
	}
	public void setNormalDeliverDT(int normalDeliverDT) {
		this.normalDeliverDT = normalDeliverDT;
	}
	public List<TransConditionCostVO> getCondCostList() {
		return condCostList;
	}
	public void setCondCostList(List<TransConditionCostVO> condCostList) {
		this.condCostList = condCostList;
	}
	public List<TransAddServiceVO> getTransAddServList() {
		return transAddServList;
	}
	public void setTransAddServList(List<TransAddServiceVO> transAddServList) {
		this.transAddServList = transAddServList;
	}
	public List<TransPeriodVO> getTransPeriodList() {
		return transPeriodList;
	}
	public void setTransPeriodList(List<TransPeriodVO> transPeriodList) {
		this.transPeriodList = transPeriodList;
	}
	
	
	
	
}

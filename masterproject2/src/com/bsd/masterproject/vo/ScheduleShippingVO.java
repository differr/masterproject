package com.bsd.masterproject.vo;

import java.sql.Date;
import java.sql.Time;

public class ScheduleShippingVO {
	private String dayShipping;
	private Date cutOffDT;
	private Time cutOffTime;
	public String getDayShipping() {
		return dayShipping;
	}
	public void setDayShipping(String dayShipping) {
		this.dayShipping = dayShipping;
	}
	public Date getCutOffDT() {
		return cutOffDT;
	}
	public void setCutOffDT(Date cutOffDT) {
		this.cutOffDT = cutOffDT;
	}
	public Time getCutOffTime() {
		return cutOffTime;
	}
	public void setCutOffTime(Time cutOffTime) {
		this.cutOffTime = cutOffTime;
	}
	
	
	
}

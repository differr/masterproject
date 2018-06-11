package com.bsd.masterproject.vo;

import java.util.List;

public class CustomerVO {
	private String custCode;
	private String name;
	private String surName;
	private String email;
	private String tel;
	private List<AddressVO> addList;
	
	public String getId() {
		return custCode;
	}
	public void setId(String id) {
		this.custCode = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<AddressVO> getAddList() {
		return addList;
	}
	public void setAddList(List<AddressVO> addList) {
		this.addList = addList;
	}
	
	
}

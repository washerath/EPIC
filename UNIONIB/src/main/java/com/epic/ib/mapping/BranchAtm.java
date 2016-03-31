package com.epic.ib.mapping;

/**
*@author : Saminda Peramuna
*@Date Time : Mar 23, 2016:2:23:45 PM
*@Class :BranchAtm.java
**/
import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BranchAtm implements Serializable {
	private static final long serialVersionUID = 1L;

	private String branchCode;
	private String address;
	private Object closeTime;
	private String contactNo;
	private Date createdTime;
	private String description;
	private String email;
	private Date lastUpdatedTime;
	private String lastUpdatedUser;
	private double latitude;
	private double longitude;
	private Object openTime;
	private BranchType branchtypeBean;

	public BranchAtm() {
	}

	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Object getCloseTime() {
		return this.closeTime;
	}

	public void setCloseTime(Object closeTime) {
		this.closeTime = closeTime;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastUpdatedTime() {
		return this.lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getLastUpdatedUser() {
		return this.lastUpdatedUser;
	}

	public void setLastUpdatedUser(String lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Object getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Object openTime) {
		this.openTime = openTime;
	}

	public BranchType getBranchtypeBean() {
		return this.branchtypeBean;
	}

	public void setBranchtypeBean(BranchType branchtypeBean) {
		this.branchtypeBean = branchtypeBean;
	}
}

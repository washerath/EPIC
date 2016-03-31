package com.epic.ib.mapping;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/***
 * @author : Saminda Peramuna
 * @Date Time : Mar 27, 2016:10:56:35 AM
 * @Class :FundTransferDAO.java
 **/
@Component
@Scope("prototype")
public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String bankCode;
	private Date createdTime;
	private String description;
	private Date lastUpdatedTime;
	private String lastUpdatedUser;
	private String status;

	public Bank() {
	}

	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
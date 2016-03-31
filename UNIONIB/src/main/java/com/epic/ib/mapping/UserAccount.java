package com.epic.ib.mapping;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

/***
 * @author : Saminda Peramuna
 * @Date Time : Mar 27, 2016:10:56:35 AM
 * @Class :FundTransferDAO.java
 **/
@Component
public class UserAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userId;
	private String accountNumber;
	private Date createdTime;
	private Date lastUpdatedTime;
	private String lastUpdatedUser;
	private String status;
	private AccountType accounttype;
	private Bank bank;

	public AccountType getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(AccountType accounttype) {
		this.accounttype = accounttype;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public UserAccount() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
		
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
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
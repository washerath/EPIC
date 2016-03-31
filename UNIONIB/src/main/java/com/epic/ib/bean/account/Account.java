package com.epic.ib.bean.account;
/**
*@author : Shalika Weerasinghe
*@Date Time : Mar 27, 2016:3:18:58 PM
*@Class :Account.java
**/
public class Account {
	private String accountnumber;
	private String accounttype;
	
	/**
	 * @return the accountnumber
	 */
	public String getAccountnumber() {
		return accountnumber;
	}
	/**
	 * @param accountnumber the accountnumber to set
	 */
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	/**
	 * @return the accounttype
	 */
	public String getAccounttype() {
		return accounttype;
	}
	/**
	 * @param accounttype the accounttype to set
	 */
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
}

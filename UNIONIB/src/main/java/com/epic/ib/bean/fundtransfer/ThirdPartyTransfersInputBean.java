package com.epic.ib.bean.fundtransfer;

import com.epic.ib.mapping.Bank;

/**
 * @author : Saminda Peramuna
 * @Date Time : Mar 27, 2016:12:00:44 PM
 * @Class :ThirdPartyFundTransfersInputBean.java
 **/
public class ThirdPartyTransfersInputBean {
	private String fromAccount;
	private String beneficiaryName;
	private Bank bank;
	private String remarks;

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}

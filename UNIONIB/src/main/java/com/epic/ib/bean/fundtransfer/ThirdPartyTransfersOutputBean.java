package com.epic.ib.bean.fundtransfer;

import java.util.List;

import com.epic.ib.mapping.Bank;
import com.epic.ib.mapping.UserAccount;

/**
 * @author : Saminda Peramuna
 * @Date Time : Mar 29, 2016:9:43:39 AM
 * @Class :ThirdPartyTransfersOutputBean.java
 **/
public class ThirdPartyTransfersOutputBean {
	private List<Bank> banks;
	private List<UserAccount> ownAccounts;
	private List<UserAccount> thirdPartyAccounts;

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public List<UserAccount> getOwnAccounts() {
		return ownAccounts;
	}

	public void setOwnAccounts(List<UserAccount> ownAccounts) {
		this.ownAccounts = ownAccounts;
	}

	public List<UserAccount> getThirdPartyAccounts() {
		return thirdPartyAccounts;
	}

	public void setThirdPartyAccounts(List<UserAccount> thirdPartyAccounts) {
		this.thirdPartyAccounts = thirdPartyAccounts;
	}
}

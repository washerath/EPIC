package com.epic.ib.mapping;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/***
 * @author : Saminda Peramuna
 * @Date Time : Mar 27, 2016:10:56:35 AM
 * @Class :FundTransferDAO.java
 **/
@Component
@Scope("prototype")
public class AccountType implements Serializable {
	private static final long serialVersionUID = 1L;

	private String accTypeCode;
	private String description;

	public AccountType() {
	}

	public String getAccTypeCode() {
		return this.accTypeCode;
	}

	public void setAccTypeCode(String accTypeCode) {
		this.accTypeCode = accTypeCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
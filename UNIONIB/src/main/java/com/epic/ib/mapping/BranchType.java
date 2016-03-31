package com.epic.ib.mapping;

/**
*@author : Saminda Peramuna
*@Date Time : Mar 23, 2016:2:24:16 PM
*@Class :BranchType.java
**/
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BranchType implements Serializable {
	private static final long serialVersionUID = 1L;

	private String typeCode;
	private Date createdTime;
	private String description;
	private Date lastUpdatedTime;
	private String lastUpdatedUser;
	private List<BranchAtm> branchatms;

	public BranchType() {
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
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

	public List<BranchAtm> getBranchatms() {
		return this.branchatms;
	}

	public void setBranchatms(List<BranchAtm> branchatms) {
		this.branchatms = branchatms;
	}

	public BranchAtm addBranchatm(BranchAtm branchatm) {
		getBranchatms().add(branchatm);
		branchatm.setBranchtypeBean(this);

		return branchatm;
	}

	public BranchAtm removeBranchatm(BranchAtm branchatm) {
		getBranchatms().remove(branchatm);
		branchatm.setBranchtypeBean(null);

		return branchatm;
	}
}

package com.epic.ib.bean.branchlocator;

import java.util.List;

import com.epic.ib.mapping.BranchAtm;

/**
 * @author : Saminda Peramuna
 * @Date Time : Mar 23, 2016:10:52:47 AM
 * @Class :BranchLocatorInputBean.java
 **/
public class BranchLocatorInputBean {

	private List<BranchAtm> branches;

	/**
	 * @return the branches
	 */
	public List<BranchAtm> getBranches() {
		return branches;
	}

	/**
	 * @param branches the branches to set
	 */
	public void setBranches(List<BranchAtm> branches) {
		this.branches = branches;
	}
}
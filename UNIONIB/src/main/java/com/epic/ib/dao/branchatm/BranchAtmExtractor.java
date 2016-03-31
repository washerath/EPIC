package com.epic.ib.dao.branchatm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.epic.ib.mapping.BranchAtm;

/**
*@author : Saminda Peramuna
*@Date Time : Mar 23, 2016:2:39:57 PM
*@Class :BranchAtmExtractor.java
**/
public class BranchAtmExtractor implements ResultSetExtractor<BranchAtm> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.ResultSet)
	 */
	
	public BranchAtm extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		BranchAtm branch = new BranchAtm();
		branch.setBranchCode(resultSet.getString(1));
		branch.setDescription(resultSet.getString(2));
		branch.setLongitude(resultSet.getFloat(3));
		branch.setLatitude(resultSet.getFloat(4));
		branch.setOpenTime(resultSet.getTimestamp(5));
		branch.setCloseTime(resultSet.getTimestamp(6));
		branch.setAddress(resultSet.getString(7));
		branch.setContactNo(resultSet.getString(8));
		branch.setEmail(resultSet.getString(9));
		// Need to set a bean object.
		branch.setBranchtypeBean(null);
		branch.setLastUpdatedUser(resultSet.getString(11));
		branch.setLastUpdatedTime(resultSet.getDate(12));
		branch.setCreatedTime(resultSet.getDate(13));
		
		return branch;
	}

}

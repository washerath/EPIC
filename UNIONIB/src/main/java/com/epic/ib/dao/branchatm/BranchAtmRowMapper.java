package com.epic.ib.dao.branchatm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epic.ib.mapping.BranchAtm;

/**
*@author : Saminda Peramuna
*@Date Time : Mar 24, 2016:11:43:35 AM
*@Class :BranchAtmRowMapper.java
**/
public class BranchAtmRowMapper implements RowMapper<BranchAtm> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	
	public BranchAtm mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		BranchAtmExtractor branchExtractor =  new BranchAtmExtractor();
		
		return branchExtractor.extractData(resultSet);
	}

}

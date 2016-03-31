package com.epic.ib.dao.fundtransfer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.RowMapper;

import com.epic.ib.mapping.UserAccount;

/**
*@author : Saminda Peramuna
*@Date Time : Mar 27, 2016:3:27:25 PM
*@Class :UserAccountRowMapper.java
**/
public class UserAccountRowMapper implements RowMapper<UserAccount> {

	private final Log logger = LogFactory.getLog(getClass());
	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	
	public UserAccount mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		UserAccountExtractor userAccountExtractor = new UserAccountExtractor();
		logger.info("Executing the UserAccount extractor ...");
		return userAccountExtractor.extractData(resultSet);
	}

}

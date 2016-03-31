package com.epic.ib.dao.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epic.ib.mapping.AccountType;

/**
*@author : Saminda Peramuna
*@Date Time : Mar 27, 2016:4:07:04 PM
*@Class :AccTypeRowMapper.java
**/
public class AccountTypeRowMapper implements RowMapper<AccountType> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	
	public AccountType mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		AccountTypeExtractor accountTypeExtractor = new AccountTypeExtractor();
		
		return accountTypeExtractor.extractData(resultSet);
	}

}

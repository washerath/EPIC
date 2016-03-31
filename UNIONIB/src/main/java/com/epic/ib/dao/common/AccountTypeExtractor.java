package com.epic.ib.dao.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.epic.ib.mapping.AccountType;

/**
*@author : Saminda Peramuna
*@Date Time : Mar 27, 2016:4:07:15 PM
*@Class :AccTypeExtractor.java
**/
public class AccountTypeExtractor implements ResultSetExtractor<AccountType> {
	private final Log logger = LogFactory.getLog(getClass());
	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.ResultSet)
	 */
	public AccountType extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		AccountType accountType = new AccountType();
		logger.info("Accessing account type extractor ...");
		accountType.setAccTypeCode(resultSet.getString(1));
		accountType.setDescription(resultSet.getString(2));
		
		return accountType;
	}

}

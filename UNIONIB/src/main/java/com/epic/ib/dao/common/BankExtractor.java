package com.epic.ib.dao.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.epic.ib.mapping.Bank;

/**
*@author : Saminda Peramuna
*@Date Time : Mar 27, 2016:4:05:24 PM
*@Class :BankExtractor.java
**/
public class BankExtractor implements ResultSetExtractor<Bank> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.ResultSet)
	 */
	
	public Bank extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		Bank bank = new Bank();
		bank.setBankCode(resultSet.getString(1));
		bank.setDescription(resultSet.getString(2));
		bank.setStatus(resultSet.getString(3));
		bank.setLastUpdatedUser(resultSet.getString(4));
		bank.setLastUpdatedTime(resultSet.getDate(5));
		bank.setCreatedTime(resultSet.getDate(6));
		
		return bank;
	}
	
}

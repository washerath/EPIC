package com.epic.ib.dao.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epic.ib.mapping.Bank;

/**
*@author : Saminda Peramuna
*@Date Time : Mar 27, 2016:4:06:53 PM
*@Class :BankRowMapper.java
**/
public class BankRowMapper implements RowMapper<Bank> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	
	public Bank mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		BankExtractor bankExtractor = new BankExtractor();
		return bankExtractor.extractData(resultSet);
	}
}

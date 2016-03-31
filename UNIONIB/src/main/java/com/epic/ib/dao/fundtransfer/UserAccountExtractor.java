package com.epic.ib.dao.fundtransfer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.epic.ib.dao.common.CommonDAO;
import com.epic.ib.mapping.UserAccount;

/**
 * @author : Saminda Peramuna
 * @Date Time : Mar 27, 2016:3:27:01 PM
 * @Class :UserAccountExtractor.java
 **/
public class UserAccountExtractor implements ResultSetExtractor<UserAccount> {

	@Autowired
	CommonDAO commonDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.
	 * ResultSet)
	 */
	
	public UserAccount extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		UserAccount userAccount = new UserAccount();
		userAccount.setUserId(resultSet.getInt(1));
		userAccount.setAccountNumber(resultSet.getString(2));
		
		// Hope this works 
		userAccount.setAccounttype(commonDao.getAccountType(resultSet.getString(3)));
		
		// This too :)
		userAccount.setBank(commonDao.getBank(resultSet.getString(4)));
		
		userAccount.setStatus(resultSet.getString(5));
		userAccount.setLastUpdatedUser(resultSet.getString(6));
		userAccount.setLastUpdatedTime(resultSet.getDate(7));
		userAccount.setCreatedTime(resultSet.getDate(8));

		return userAccount;
	}

}

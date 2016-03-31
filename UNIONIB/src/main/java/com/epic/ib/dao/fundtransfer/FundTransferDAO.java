package com.epic.ib.dao.fundtransfer;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epic.ib.mapping.UserAccount;

/***
 * @author : Saminda Peramuna
 * @Date Time : Mar 27, 2016:10:56:35 AM
 * @Class :FundTransferDAO.java
 **/
public class FundTransferDAO {
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Value("${unionbank.bankcode}")
	private String unionbankBankCode;

	/**
	 * Get all the user accounts from the table.
	 * 
	 * @return
	 */
	public List<UserAccount> getUserAccountCollection() {
		String sql = "select * from useraccounts";

		return getUserAccountCollectionFromQuery(sql, new Object[] {});
	}

	/**
	 * Get all the accounts belonging to a specific user.
	 * 
	 * @param userId
	 * @return
	 */
	public List<UserAccount> getUserAccountCollection(String userId) {
		String sql = "select * from useraccounts where userid = '?'";

		return getUserAccountCollectionFromQuery(sql, new Object[] { userId });
	}

	/**
	 * Get a list of bank accounts per user and per bank.
	 * 
	 * @param userId
	 * @param bankCode
	 * @return
	 */
	public List<UserAccount> getUserAccountCollection(String userId, String bankCode) {
		List<UserAccount> userAccounts = getUserAccountCollection(userId);

		for (UserAccount userAccount : userAccounts) {
			if (!userAccount.getBank().getBankCode().equals("")) {
				userAccounts.remove(userAccount);
			}
		}

		return userAccounts;
	}

	/**
	 * Get a specfic account belonging to a specific user.
	 * 
	 * @param userId
	 * @param accountNo
	 * @return
	 */
	public UserAccount getUserAccount(int userId, String accountNo) {
		String sql = "select * from useraccounts where (userid = '?') AND (accountno = '?')";

		return getUserAccountFromQuery(sql, new Object[] { userId, accountNo });
	}

	/**
	 * Get a single UserAccount object from the table.
	 * 
	 * @param sqlQuery
	 * @param queryParameters
	 * @return
	 */
	private UserAccount getUserAccountFromQuery(String sqlQuery, Object[] queryParameters) {
		List<UserAccount> userAccounts;
		UserAccount userAccount = null;

		userAccounts = getUserAccountCollectionFromQuery(sqlQuery, queryParameters);

		try {
			if (userAccounts.size() < 2) {
				userAccount = userAccounts.get(0);
				logger.info("Retrieval of user account successful !");
			} else {
				logger.info("Data inconsistency in the useraccounts table !");
			}
		} catch (Exception ex) {
			logger.info("Retrieval of user the specific user account failed : " + ex.getMessage());
		}

		return userAccount;
	}

	/**
	 * Generic method used to retrieve userAccounts as a list according to the
	 * given query.
	 * 
	 * @param sqlQuery
	 * @param parameters
	 * @return
	 */
	private List<UserAccount> getUserAccountCollectionFromQuery(String sqlQuery, Object[] queryParameters) {
		List<UserAccount> userAccounts = null;

		try {
			userAccounts = jdbcTemplate.query(sqlQuery, new UserAccountRowMapper(), queryParameters);

			if (!userAccounts.isEmpty()) {
				logger.info("Retrieval of user accounts is successful !");
			} else {
				logger.info("There are no user accounts in the database !");
			}
		} catch (Exception ex) {
			logger.info("Retrieval of user accounts failed : " + ex.getMessage());
		}

		return userAccounts;
	}
}

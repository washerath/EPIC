package com.epic.ib.dao.common;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epic.ib.mapping.AccountType;
import com.epic.ib.mapping.Bank;

/**
 * @author : Saminda Peramuna
 * @Date Time : Mar 27, 2016:4:42:31 PM
 * @Class :CommonDAO.java
 **/
@Repository
public class CommonDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final Log logger = LogFactory.getLog(getClass());

	/**
	 * Retreive all the banks in the database.
	 * 
	 * @return
	 */
	public List<Bank> getBankCollection() {
		List<Bank> banks = null;
		String sql = "select * from bank";

		try {
			banks = jdbcTemplate.query(sql, new BankRowMapper());
			if (!banks.isEmpty()) {
				logger.info("Retrieval of banks is successful !");
			} else {
				logger.info("Retrieval of banks failed !");
			}
		} catch (Exception ex) {
			logger.info("Cannot retrieve bank info : " + ex.getMessage());
		}
		return banks;
	}

	/**
	 * Retrieval of bank info using the bankCode
	 * 
	 * @param bankCode
	 * @return
	 */
	public Bank getBank(String bankCode) {
		List<Bank> banks;
		Bank bank = null;
		String sql = "select * from bank where (bankcode = '?')";

		try {
			banks = jdbcTemplate.query(sql, new BankRowMapper(), bankCode);
			if (!banks.isEmpty() && banks.size() > 1) {
				bank = banks.get(0);
				logger.info("Bank info successfully retrieved !");
			} else {
				logger.info("Bank info cannot be retrieved retrieved. Table has no data !");
			}
		} catch (Exception ex) {
			logger.info("Cannot Retrieve the specific bank info : " + ex.getMessage());
		}

		return bank;
	}

	/**
	 * Retrieve all the accout type info from the database.
	 * 
	 * @return
	 */
	public List<AccountType> getAccountTypeCollection() {
		List<AccountType> accountTypes = null;
		String sql = "select * from accounttype";

		try {
			accountTypes = jdbcTemplate.query(sql, new AccountTypeRowMapper());
			if (!accountTypes.isEmpty()) {
				logger.info("Successfully retrieved account types.");
			} else {
				logger.info("Retrieval of accounttypes failed or there are no records in the table ! ");
			}
		} catch (Exception ex) {
			logger.info("Cannot retrieve accounttypes : " + ex.getMessage());
		}

		return accountTypes;
	}

	/**
	 * Get account type according to the provided typecode.
	 * 
	 * @param typeCode
	 * @return
	 */
	public AccountType getAccountType(String typeCode) {
		List<AccountType> accountTypes;
		AccountType accountType = null;
		String sql = "select * from accounttype where (acctypecode = '?')";

		try {
			accountTypes = jdbcTemplate.query(sql, new AccountTypeRowMapper(), typeCode);
			if (!accountTypes.isEmpty()) {
				accountType = accountTypes.get(0);
				logger.info("Retrieval of account type info succeeded ! ");
			} else {
				logger.info("Account type info cannot be retrieved retrieved. Table has no data !");
			}
			logger.info("Retrieval of account type info succeeded ! ");
		} catch (Exception ex) {
			logger.info("Retrieval of account type info failed : " + ex.getMessage());
		}

		return accountType;
	}
}

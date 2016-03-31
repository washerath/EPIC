package com.epic.ib.dao.branchatm;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epic.ib.mapping.BranchAtm;

/**
 * @author : Saminda Peramuna
 * @Date Time : Mar 24, 2016:11:35:56 AM
 * @Class :BranchAtmDAO.java
 **/
@Repository
public class BranchAtmDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private final Log logger = LogFactory.getLog(getClass());

	/**
	 * Method which returns all the branches in the database.
	 * 
	 * @return
	 */
	public List<BranchAtm> getBranchAtmCollection() {
		List<BranchAtm> branches = null;
		String query = "select * from branchatm";

		try {
			branches = jdbcTemplate.query(query, new BranchAtmRowMapper());
			if (branches.isEmpty()) {
				logger.info("There are no branches in the database !");
			} else {
				logger.info("All branch data retrieved successfully !");
			}
		} catch (Exception ex) {
			logger.info("Retrieval of branches failed ! " + ex.getMessage());
		}

		return branches;
	}

	/**
	 * Overriden method which returns the branches whose description matches the
	 * search pattern. (THIS METHOD IS NOT USED ANYMORE BY BRANCH_ATM_LOCATOR)
	 * 
	 * @param searchQuery
	 * @return
	 */
	public List<BranchAtm> getBranchAtmCollection(String searchQuery) {
		List<BranchAtm> branches = null;
		String query = "select * from branchatm where description like '%A%'";

		try {
			branches = jdbcTemplate.query(query, new BranchAtmRowMapper());
			if (!branches.isEmpty()) {
				logger.info("Retrieval of search query successful !");
			} else {
				logger.info("Retrieval of search query failed !");
			}
		} catch (Exception ex) {
			logger.info("Retrieval of branches failed ! " + ex.getMessage());
		}

		return branches;
	}

	/**
	 * Retrieve the branch info using the branch code.
	 * 
	 * @param branchCode
	 * @return
	 */
	public BranchAtm getBranchAtm(String branchCode) {
		List<BranchAtm> branches;
		BranchAtm branch = null;
		String query = "select * from branchatm where branchcode = ?";

		try {
			branches = jdbcTemplate.query(query, new BranchAtmRowMapper(), branchCode);
			if (!branches.isEmpty() && branches.size() > 1) {
				branch = branches.get(0);
				logger.info("Retrieval of branch info successful !");
			} else {
				logger.info("Multiple key values in \"branchatm\". Data integrity error !");
			}
		} catch (Exception ex) {
			logger.info("Retrieval of branch info failed ! " + ex.getMessage());
		}

		return branch;
	}
}

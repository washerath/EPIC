package commonDAO;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.epic.ib.dao.common.CommonDAO;
import com.epic.ib.mapping.Bank;

/**
 * @author : Saminda Peramuna
 * @Date Time : Mar 27, 2016:6:08:57 PM
 * @Class :CommonDAO.java
 **/
public class CommonDAOTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		JdbcTemplate jdbcTemplate;
		System.out.println("Setting up tests ...");
		jdbcTemplate = new JdbcTemplate();

		try {
			Assert.notNull(jdbcTemplate);
			System.out.println("JDBC templete initialised ...");
		} catch (AssertionError err) {
			System.out.println("JDBC templete initialisation error ..." + err.getMessage());
		} finally {
			// Delete the object.
			jdbcTemplate = null;
		}

		System.out.println("Asserting JDBCTemplate ...");

		System.out.println("Setting up tests complete ...");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.epic.ib.dao.common.CommonDAO#getBankCollection()}.
	 */
	@Test
	public void testGetBankCollection() {
		System.out.println("Tryting to retireve the banks collection ..");

		try {
			CommonDAO commonDao = new CommonDAO();
			List<Bank> items = commonDao.getBankCollection();

			Assert.notEmpty(items, "There are no banks in the collection ...");
			System.out.println("There were " + items.size() + " records found for banks.");
		} catch (Exception ex) {
			System.out.println("There were errors in the test. " + ex.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.epic.ib.dao.common.CommonDAO#getBank(java.lang.String)}.
	 */
	@Test
	public void testGetBank() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.epic.ib.dao.common.CommonDAO#getAccountTypeCollection()}.
	 */
	@Test
	public void testGetAccountTypeCollection() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.epic.ib.dao.common.CommonDAO#getAccountType(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetAccountType() {
		fail("Not yet implemented");
	}

}

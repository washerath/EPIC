package commonDAO;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
*@author : Saminda Peramuna
*@Date Time : Mar 27, 2016:6:09:21 PM
*@Class :AllTests.java
**/
@RunWith(Suite.class)
@SuiteClasses({ CommonDAOTest.class })
public class AllTests {

	public static void main(String args[]) {
		CommonDAOTest commonDAOTest = new CommonDAOTest();
		commonDAOTest.testGetBankCollection();
		System.out.println("All tests were completed.");
	}
}

package testscripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import common.RestCallHelper;
/**
 * This is the Base Test class which is the parent of all test classes. This should contains all the common prerequisite methods for test classes.
 * @author Suranga J
 *
 */
public class BaseTest {

	
	private static String baseURI = "https://api.tmsandbox.co.nz/v1";// Host url of the REST API
	
	
	/**
	 * This is the Before Test method which will trigger before every test method.
	 * Here it will set the baseURI and print a console log to notify the beginning of  the test
	 */
	@BeforeTest
	public void setUp() {
		RestCallHelper.setBaseURI(baseURI);
		System.out.println("============ Begining of the Test =============");
		
	}
	
	
	/**
	 * This is the After Test method which will trigger after every test method.
	 * Here it will reset the baseURI to null and print a console log to notify the end of  the test
	 */
	@AfterTest
	public void tearDown() {
		RestCallHelper.resetBaseURI();
		System.out.println("============== End of the Test ================");
	}
}

package testscripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import common.RestCallHelper;

public class BaseTest {

	private static String baseURI = "https://api.tmsandbox.co.nz/v1";
	
	@BeforeTest
	public void setUp() {
		RestCallHelper.setBaseURI(baseURI);
		System.out.println("============ Begining of the Test =============");
		
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("============== End of the Test ================");
	}
}

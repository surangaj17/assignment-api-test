package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.net.UnknownHostException;

import common.RestCallHelper;
import common.Utils;
import services.*;

/**
 * This is the Categories details verification test class 
 * which includes the verification of categories for given category id and catalouge flag.
 * @author Suranga J
 *
 */
public class VerifyCategoriesTest extends BaseTest{
	
	RestCallHelper RestCall = new RestCallHelper();
	CategoriesHelper CategoriesRes = new  CategoriesHelper();
	private SoftAssert assertion = new SoftAssert();
	
	
	 @Test
	 public void TC1_VerifyCateegoriesDetailsForNameCanListAndDescription()
	 {   
		 System.out.println("### Test Script : TC1_VerifyCateegoriesDetailsForNameCanListAndDescription ###");

		 String path = CategoriesRes.getCategoriesPath("6327","false"); // Dynamically construct and set resource path.  
		 String keyName ="Name"; // This variable contains the name of the 'Name' key
		 String expectedName = "Carbon credits"; // This variable contains the value of the 'Name" key.
		 String keyCanRelist = "CanRelist"; // This variable contains the name of the 'CanRelist' key
		 boolean expectedCanRelist = true; // This variable contains the boolean value of the 'CanRelist' key
		 String promotionName = "Gallery"; // This variable contains the value of the 'Name" key of Promotions.
		 String expectedDescriptionContains = "2x larger image"; // This variable contains the expected test portion of description of Gallery promotion.
	 
		try {

		 	 Response response =  RestCallHelper.getResponse(path); // Generates and set response in the response object
		 
		 	 // Verification of 1st acceptance criterion.
		 	 String actualName = RestCall.getJsonElementStringValue(response, keyName);
			 Utils.Print("# Acceptance criterion 1 : Name received from Response -\nExpected is : " + expectedName + " | Actual is : " + actualName);
			 assertion.assertEquals(actualName, expectedName, "Expected Name has not recived.");
			 
			// Verification of 2nd acceptance criterion.
			 boolean actualCanRelist = RestCall.getJsonElementBooleanValue(response, keyCanRelist);
			 Utils.Print("# Acceptance criterion 2 : CanRelist received from Response -\nExpected is : " + expectedCanRelist + " | Actual is : " + actualCanRelist);
			 assertion.assertEquals(actualCanRelist, expectedCanRelist, "Expected CanRelist has not recived.");
	 
			// Verification of 3rd acceptance criterion.
			 String strDescription = CategoriesRes.getDescriptionOfPromotion(response, promotionName);
			 Utils.Print("# Acceptance criterion 3 : Description of " + promotionName + " is -\n" +strDescription );
			 assertion.assertEquals(strDescription.contains(expectedDescriptionContains) , true, "Description of " + promotionName + " doesn't contains expected text.");
	 
			 
			} catch (UnknownHostException e) {
				// Forced fail assertion in case of unreachable host
				assertion.fail(RestAssured.baseURI + " Host is unreachable");

			}
		// Collects all the assertions of the test
		assertion.assertAll();
	 }
	 
}
	 


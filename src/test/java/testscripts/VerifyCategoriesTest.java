package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.net.UnknownHostException;

import common.RestCallHelper;
import common.Utils;
import services.*;


public class VerifyCategoriesTest extends BaseTest{
	
	RestCallHelper RestCall = new RestCallHelper();
	CategoriesHelper CategoriesRes = new  CategoriesHelper();
	private SoftAssert assertion = new SoftAssert();
	
	
	 @Test
	 public void TC1_VerifyCateegoriesDetailsForNameCanListAndDescription()
	 {   
		 
		 String path = "/Categories/6327/Details.json?catalogue=false";
		 String keyName ="Name";
		 String expectedName = "Carbon credits";
		 String keyCanRelist = "CanRelist";
		 boolean expectedCanRelist = true;
		 String promotionName = "Gallery";
		 String expectedDescriptionContains = "2x larger image";
	 
		try {

		 	 Response response =  RestCallHelper.getResponse(path);
		 
		 	 String actualName = RestCall.getJsonElementStringValue(response, keyName);
			 Utils.Print("# Acceptance criterion 1 : Name received from Response -\nExpected is : " + expectedName + " | Actual is : " + actualName);
			 assertion.assertEquals(actualName, expectedName, "Expected Name has not recived.");
			 
			 boolean actualCanRelist = RestCall.getJsonElementBooleanValue(response, keyCanRelist);
			 Utils.Print("# Acceptance criterion 2 : CanRelist received from Response -\nExpected is : " + expectedCanRelist + " | Actual is : " + actualCanRelist);
			 assertion.assertEquals(actualCanRelist, expectedCanRelist, "Expected CanRelist has not recived.");
	 
			 String strDescription = CategoriesRes.getDescriptionOfPromotion(response, promotionName);
			 Utils.Print("# Acceptance criterion 3 : Description of " + promotionName + " is -\n" +strDescription );
			 assertion.assertEquals(strDescription.contains(expectedDescriptionContains) , true, "Description of " + promotionName + " doesn't contains expected text.");
	 
			 
			} catch (UnknownHostException e) {
				assertion.fail(RestAssured.baseURI + " Host is unreachable");

			}
		
		assertion.assertAll();
	 }
	 
}
	 


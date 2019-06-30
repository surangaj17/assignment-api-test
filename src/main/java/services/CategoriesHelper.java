package services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import common.RestCallHelper;
import io.restassured.response.Response;

/**
 * This is a helper class which contains Categories resource related domain specific methods.
 * @author Suranga J
 *
 */
public class CategoriesHelper {

	
	/**
	* This method will return description of given promotion among set of promotion JSON objects
	* @param response The Response object which holds the REST call response.
	* @param name The name of the promotion of required description
	* @return strDescription This will return the description of given promotion among set of promotion JSON objects.
	*/
	public String getDescriptionOfPromotion(Response response, String name ) {
		String strDescription = null;
		
		RestCallHelper RestCall = new RestCallHelper();
		
		 JSONObject obj = new JSONObject(RestCall.getResponceBody(response));

			 JSONArray arr = obj.getJSONArray("Promotions");
			 for (int i = 0; i < arr.length(); i++)
			 {
			     String strPromotionname = arr.getJSONObject(i).getString("Name");
			     if  (strPromotionname.equals(name)) {
			    	 strDescription = arr.getJSONObject(i).getString("Description");
			     	}
			 }
		
		return strDescription;
		
		
	}
	
	
	/**
	* This method will return resource path for Categories for the given category id and catalogue flag
	* @param categoryID ID of the category of the required request
	* @param catalogueFlag Catalogue flag of the required request 
	* @return path This will return resource path for Categories for the given category id and catalogue flag
	*/
	public String getCategoriesPath(String categoryID, String catalogueFlag) {
		
		String path="/Categories/"+categoryID+"/Details.json?catalogue=" + catalogueFlag;
		
		return path;
	}
}

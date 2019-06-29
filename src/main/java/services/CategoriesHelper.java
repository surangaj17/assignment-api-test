package services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import common.RestCallHelper;
import io.restassured.response.Response;

public class CategoriesHelper {

	
	public String getDescriptionOfPromotion(Response response, String name ) {
		String strDescription = null;
		
		RestCallHelper RestCall = new RestCallHelper();
		
		 JSONObject obj = new JSONObject(RestCall.getResponceBody(response));

			 JSONArray arr = obj.getJSONArray("Promotions");
			 for (int i = 0; i < arr.length(); i++)
			 {
			     String post_id = arr.getJSONObject(i).getString("Name");
			     if  (post_id.equals(name)) {
			    	 strDescription = arr.getJSONObject(i).getString("Description");
			     	}
			 }
		
		return strDescription;
		
		
	}
	
	public String getCategoriesPath(String categoryID, String catalogueFlag) {
		
		String path="/Categories/"+categoryID+"/Details.json?catalogue=" + catalogueFlag;
		
		return path;
	}
}

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
			// String pageName = obj.getJSONObject("pageInfo").getString("pageName");

			 JSONArray arr = obj.getJSONArray("Promotions");
			 for (int i = 0; i < arr.length(); i++)
			 {
			     String post_id = arr.getJSONObject(i).getString("Name");
			     //System.out.println("Promotion Name is : " + post_id);
			     //"Gallery"
			     if  (post_id.equals(name)) {
			    	 strDescription = arr.getJSONObject(i).getString("Description");

			    	 
			    	 //String bodyAsString = body.asString();
			    	 //Assert.assertEquals(strDescription.contains("2x larger image") , true, "Description of " + post_id + "  contains 2x larger image");
			    	}
			     }
		
		
		
		return strDescription;
		
		
	}
}

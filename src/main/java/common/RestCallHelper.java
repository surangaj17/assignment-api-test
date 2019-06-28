package common;

import java.net.UnknownHostException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestCallHelper {

    public static void setBaseURI (String baseURI) {
    	RestAssured.baseURI = baseURI;
    }
    


    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }
 

    public static Response getResponse(String path) throws UnknownHostException {
        
    	RequestSpecification httpRequest = RestAssured.given();
    	Response response = httpRequest.request(Method.GET, path);
    	
        return response;
    }
    
    
    public String getResponceBody(Response res) {
    	return res.getBody().asString();
    }
 
    public String getJsonElementStringValue(Response res,String key) {
    	
    	JsonPath jsonPathEvaluator = res.jsonPath();
    	String value = jsonPathEvaluator.get(key) ;
    	
		return value;
    }
    
    public boolean getJsonElementBooleanValue(Response res,String key) {
    	
    	JsonPath jsonPathEvaluator = res.jsonPath();
    	boolean value = jsonPathEvaluator.get(key) ;
    	
		return value;
    }
    
    

    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
        return new JsonPath(json);
    }
}


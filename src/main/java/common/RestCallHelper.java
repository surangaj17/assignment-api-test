package common;

import java.net.UnknownHostException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This is a helper class which contains REST request and  response related methods.
 * @author Suranga J
 *
 */
public class RestCallHelper {

	/**
	 * This will set the baseURI to the RestAssured baseURI variable
	 * @param baseURI This is the Host url of the Rest API
	 */
    public static void setBaseURI (String baseURI) {
    	RestAssured.baseURI = baseURI;
    }
    

    /**
     * This will reset theRestAssured baseURI variable to null.
     */
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }
 
    
    /**
     * This will trigger the GET API request to the given end point and retrieve the response.
     * @param path This is the resource path
     * @return response This will holds the GET response as an object
     * @throws UnknownHostException If the host is unreachable or incorrect
     */
    public static Response getResponse(String path) throws UnknownHostException {
        
    	RequestSpecification httpRequest = RestAssured.given();
    	Response response = httpRequest.request(Method.GET, path);
    	
        return response;
    }
    
    
    /**
     * This will get the response body as a string
     * @param res This is the REST response
     * @return Will return the response body as a string 
     */
    public String getResponceBody(Response res) {
    	return res.getBody().asString();
    }
    
    
    /**
     * This will get the String value of a given key in a JSON schema
     * @param res This is the REST response
     * @param key Name of the key 
     * @return value Will return the String value of the given key
     */
    public String getJsonElementStringValue(Response res,String key) {
    	
    	JsonPath jsonPathEvaluator = res.jsonPath();
    	String value = jsonPathEvaluator.get(key) ;
    	
		return value;
    }
    
    /**
     * This will get the boolean value of a given key in a JSON schema
     * @param res This is the REST response
     * @param key Name of the key 
     * @return value Will return the boolean value of the given key
     */
    public boolean getJsonElementBooleanValue(Response res,String key) {
    	
    	JsonPath jsonPathEvaluator = res.jsonPath();
    	boolean value = jsonPathEvaluator.get(key) ;
    	
		return value;
    }
    
    
    /**
     * This will give the JsonPath of a given response
     * @param res This is the REST response
     * @return Will return the JsonPath of a given response
     */
    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
        return new JsonPath(json);
    }
}


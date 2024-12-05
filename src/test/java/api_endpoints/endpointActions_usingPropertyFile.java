package api_endpoints;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.testng.annotations.Test;

import api_payloads.userPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//perform endpoint actions

public class endpointActions_usingPropertyFile {
	
	
	//to load property file
	static ResourceBundle geturl() {
      ResourceBundle prop = ResourceBundle.getBundle("prop");
      return prop;
	}
	
	
	public static Response createUser(userPojo payload) { //sending the payload
		

       String postURL = geturl().getString("base_url");
       
		Response res = given() 
		  .contentType(ContentType.JSON)   // refers what type of data we are going to pass in payload
		  .accept(ContentType.JSON)
		  .body(payload)
		  
		.when()
		  .post(postURL); //directly access the url from rootNodes by using class name since it is a static
		
		// getting the payload and stored it in res now returning the res to do some operations in api_tests
		return res;  // so the return type should be "Response"
		
//		.then()
//		  .statusCode(200);
	}
	
	
	
	public static Response getUser(String uname) {   // receive the parameter{username}
		

	     String getURL = geturl().getString("get_url");
		Response res = given() 
		  .pathParam("username", uname)
		 
		.when()
		  .get(getURL); //directly access the url from rootNodes by using class name since it is a static
		
		
		return res;  // returning the response
		
	}
	
	
	public static Response updateUser(userPojo payload, String uname) { 
		

	     String putURL = geturl().getString("put_url");
		Response res = given() 
		  .contentType(ContentType.JSON)   // refers what type of data we are going to pass in payload
		  .accept(ContentType.JSON)
		  .pathParam("username", uname)
		  .body(payload)
		  
		.when()
		  .put(putURL); //directly access the url from rootNodes by using class name since it is a static
		
		return res;  // returning the response
		
	}
	
	
	public static Response deleteUser(String uname) {
		
		String delURL = geturl().getString("del_url");
		Response res = given()
		  .pathParam("username", uname)
		  
		.when()
		  .delete(delURL); //directly access the url from rootNodes by using class name since it is a static
	
		return res;  // returning the response
		
	}


}

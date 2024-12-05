package api_endpoints;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.testng.annotations.Test;

import api_payloads.userPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//perform endpoint actions

public class endpointActions {
	
	@Test(priority=1)
	public static Response createUser(userPojo payload) { //sending the payload
		Response res = given() 
		  .contentType(ContentType.JSON)   // refers what type of data we are going to pass in payload
		  .accept(ContentType.JSON)
		  .body(payload)
		  
		.when()
		  .post(rootNodes.base_url); //directly access the url from rootNodes by using class name since it is a static
		
		// getting the payload and stored it in res now returning the res to do some operations in api_tests
		return res;  // so the return type should be "Response"
		
//		.then()
//		  .statusCode(200);
	}
	
	
	@Test(priority=2)
	public static Response getUser(String uname) {   // receive the parameter{username}
		Response res = given() 
		  .pathParam("username", uname)
		 
		.when()
		  .get(rootNodes.get_url); //directly access the url from rootNodes by using class name since it is a static
		
		
		return res;  // returning the response
		
	}
	
	@Test(priority=3)
	public static Response updateUser(userPojo payload, String uname) { 
		Response res = given() 
		  .contentType(ContentType.JSON)   // refers what type of data we are going to pass in payload
		  .accept(ContentType.JSON)
		  .pathParam("username", uname)
		  .body(payload)
		  
		.when()
		  .put(rootNodes.put_url); //directly access the url from rootNodes by using class name since it is a static
		
		return res;  // returning the response
		
	}
	
	@Test(priority=3)
	public static Response deleteUser(String uname) {
		Response res = given()
		  .pathParam("username", uname)
		  
		.when()
		  .delete(rootNodes.del_url); //directly access the url from rootNodes by using class name since it is a static
	
		return res;  // returning the response
		
	}


}

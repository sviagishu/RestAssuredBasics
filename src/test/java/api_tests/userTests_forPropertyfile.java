package api_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

//import api_endpoints.endpointActions;
import api_endpoints.endpointActions_usingPropertyFile;
import api_payloads.userPojo;
import io.restassured.response.Response;



public class userTests_forPropertyfile {

	Faker faker;
	userPojo pj;
	
	@BeforeClass
	public void setup() {
		 faker = new Faker(); // create a random data and send it to pojo
		 pj = new userPojo();
		
		pj.setId(faker.idNumber().hashCode());  //generate some random id and pass it to payload
		pj.setUsername(faker.name().username());
		pj.setFirstname(faker.name().firstName());
		pj.setLastname(faker.name().lastName());
		pj.setEmail(faker.internet().safeEmailAddress());
		pj.setPassword(faker.internet().password());
		pj.setPhone(faker.phoneNumber().cellPhone());
		
	
	}
	
	// pass the data to the endpontActions
	@Test(priority=1)
	// post
	public void testUser() {
		Response resp = endpointActions_usingPropertyFile.createUser(pj);   // save the respnse
		//System.out.println(resp);
		resp.then().log().all();
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
	
	
	//get
	@Test(priority=2)
	public void testGetUserByName() {
		Response resp = endpointActions_usingPropertyFile.getUser(this.pj.getUsername());
		resp.then().log().all();
		Assert.assertEquals(resp.getStatusCode(),200);
	}
	
	
	//put 
	@Test(priority=3)
	public void testputUser() {
		
		//update data in payload // by calling again it will regenerate the data again
	
		pj.setEmail(faker.internet().safeEmailAddress());
		
		Response resp = endpointActions_usingPropertyFile.updateUser(pj,this.pj.getUsername());   // 2 params - payload and username
		//System.out.println(resp);
		resp.then().log().all();
		Assert.assertEquals(resp.getStatusCode(), 200);
		
		//check data after update
		testGetUserByName();
//		(or)
//		Response resp1 = endpointActions.getUser(this.pj.getUsername());
//		resp1.then().log().all();
//		Assert.assertEquals(resp1.getStatusCode(),200);
//		
	}
	
	//Delete
	@Test(priority=4)
	public void testdeletebyUser() {

			Response resp = endpointActions_usingPropertyFile.deleteUser(this.pj.getUsername());
			resp.then().log().all();
			Assert.assertEquals(resp.getStatusCode(),200);
		}
	}


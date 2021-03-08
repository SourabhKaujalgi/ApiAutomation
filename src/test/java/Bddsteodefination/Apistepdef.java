package Bddsteodefination;


import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIresources;
import resources.TestDataBuild;
import resources.Utils;

public class Apistepdef extends Utils {
	
	
	
	RequestSpecification res;
	ResponseSpecification sreposec;
	Response response;
	static String PlaceId;
	TestDataBuild data=new TestDataBuild();
	
	@Given("Add Place Payload With {string} {string} {string}")
	public void add_Place_Payload_With(String name, String langauage, String Adress) throws IOException {
		
		
		
		
		
		RestAssured.useRelaxedHTTPSValidation();
		//Add Place
		
			    res=given().spec(requestspecification())
				.body(data.addPlacePayload(name,langauage,Adress));
			    
			    
	    
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String string, String method) {
		
		//Constructor will be called by value of resource 
		
		APIresources ap=APIresources.valueOf(string);
        
	 sreposec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	 
	 if(method.equalsIgnoreCase("Post"))
	 { 
	this.response =res.when().post(ap.getResource());
		       
	 }
	 else if(method.equalsIgnoreCase("Get"))
	 { 
		 { 
			 this.response =res.when().get(ap.getResource());
				       
			 }
	 }
	
	  
	}

	@Then("the API call is sucess with status code {int}")
	public void the_API_call_is_sucess_with_status_code(Integer int1) {
		assertEquals(this.response.getStatusCode(),200);
	   
	}

	@Then("{string} in reponse body is {string}")
	public void in_reponse_body_is(String att, String value) {
	  //  String reponsebody=response.asString();
	     
		System.out.println(value);
		
		System.out.println(value);
		
	    assertEquals(getJsonPath(this.response,att),value);
	    
	}
	
	@Then("verify place_id created maps to to {string} using {string}")
	public void verify_place_id_created_maps_to_to_using(String expectredname, String resource) throws IOException {
		 
	    this.PlaceId=getJsonPath(this.response,"place_id");
		res=given().spec(requestspecification()).queryParam("place_id",PlaceId);
		user_calls_with_http_request(resource,"Get");
		String ActualName=getJsonPath(this.response,"name");
		System.out.println(ActualName);
		  assertEquals(expectredname, ActualName);
	    
	}
	@Given("Delete Place Payload")
	public void delete_Place_Payload() throws IOException {
		
		 System.out.println(this.PlaceId);
	    res=given().spec(requestspecification())
	   	
	    .body(data.deleteplace(this.PlaceId));		
	}


	
}

package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_CommonSteps {
	
	public Response response;
	
	public API_CommonSteps (Response response) {
		this.response = response ; 
	}
	
	public API_CommonSteps () {
		
	}
	
	@Given("I set the base URI to {string}")
    public void i_set_the_base_uri(String baseUri) {
		RestAssured.baseURI = baseUri;
		
    }
	
	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer statusCode) {
		response.then().statusCode(statusCode) ;
	    
	}

}

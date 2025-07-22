package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pages.LoginApi;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class login {
	
	public LoginApi loginAPI;
	public Response response;

	
	
	@When("I login with valid credentials")
	public void i_login_with_valid_credentials() {
		//response = loginAPI.sendLoginRequest("eve.holt@reqres.in", "cityslicka") ;
		LoginApi loginAPI = new LoginApi() ;
		response  = loginAPI.sendLoginRequest("eve.holt@reqres.in", "cityslicka") ;
		
	}

	

	@Then("the response should contain a token")
	public void the_response_should_contain_a_token() {
		String token = response.jsonPath().getString("token") ; 

		assertNotNull("token should not be null", token);
		System.out.println("token is "+ token);
		
		
	    
	}
}

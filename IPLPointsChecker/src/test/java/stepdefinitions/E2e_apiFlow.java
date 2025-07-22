package stepdefinitions;

import api.pojo.Resource;
import api.service.AuthService;
import api.service.ResourceService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class E2e_apiFlow {
	
	Resource requestBody = new Resource ("Pranav","SDET");
	
	String bearerToken,  csrfToken ;
	
	AuthService authService = new AuthService();
	
	ResourceService actualPost = new ResourceService();
	
	
	
	
	@Given("the user retrieves a bearer token")
	public void the_user_retrieves_a_bearer_token() {
		
		bearerToken = authService.getBearerToken();
	}

	@Given("the user retrieves a CSRF token")
	public void the_user_retrieves_a_csrf_token() {
		csrfToken = authService.getCsrfToken(bearerToken);
	}

	@When("the user sends a POST request with a nested JSON payload")
	public void the_user_sends_a_post_request_with_a_nested_json_payload() {
		
		Resource requestBody = new Resource (bearerToken,csrfToken);
		
		actualPost.createResource(requestBody, bearerToken, csrfToken) ;
	}

	@Then("the response body should match the request payload")
	public void the_response_body_should_match_the_request_payload() {
	}

}

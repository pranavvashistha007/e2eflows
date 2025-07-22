package stepdefinitions;


import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetUserSteps {
	
	
	@When("I retrieve user details for ID {int}")
	public void i_retrieve_user_details_for_id(Integer userID1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the response should contain the user's email")
	public void the_response_should_contain_the_user_s_email() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}

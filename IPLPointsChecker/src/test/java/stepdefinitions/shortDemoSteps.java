package stepdefinitions;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ShortDemo;

public class shortDemoSteps extends BaseClass{
	//public WebDriver driver ; 
	
	@Given("User opens site")
	public void user_opens_site() {
	    
	    launchBrowser ("https://www.iplt20.com/points-table/men/2023") ;
	}

	@When("User get data")
	public void user_get_data() {
		ShortDemo page = new ShortDemo (driver) ;
		page.getData();
		
	}

	@Then("User validate data")
	public void user_validate_data() {
		ShortDemo page = new ShortDemo (driver) ;
		page.validateData();
	    
	}


}

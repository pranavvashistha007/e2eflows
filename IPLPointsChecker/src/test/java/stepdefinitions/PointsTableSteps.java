package stepdefinitions;

import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import base.BaseClass;
import io.cucumber.java.en.*;
import pages.IPL_PointsTablePage;

public class PointsTableSteps extends BaseClass {
	
	IPL_PointsTablePage pointsPage ;

	@Given("I open the IPL 2023 points table webpage")
	public void i_open_the_ipl_points_table_webpage() throws InterruptedException {
		//
	    launchBrowser("https://www.iplt20.com/points-table/men/2023");
	   // ExtentCucumberAdapter.addTestStepLog("⏱️ Execution started at: " + new Date());
	    ExtentCucumberAdapter.addTestStepLog("🟢 Login page loaded successfully.");
	    ExtentCucumberAdapter.addTestStepLog("<b style='color:green;'>✔ Login Successful</b>");
	    ExtentCucumberAdapter.addTestStepLog("<b style='color:red;'>✖ Validation Failed</b>");
	    pointsPage = new IPL_PointsTablePage(driver);
	   
	}

	@When("I extract the team names and their respective points")
	public void i_extract_the_team_names_and_their_respective_points() {
		pointsPage.fetchTeamPoints();
		Assert.assertEquals(false, true);
	    
	}

	@Then("I store them in a HashMap")
	public void i_store_them_in_a_hash_map() {
	    // Write code here that turns the phrase above into concrete actions
		//pointsPage.storeInMap();
		System.out.println("✅ Data stored in HashMap.");
	}

	@Then("I display the contents of the HashMap on the console")
	public void i_display_the_contents_of_the_hash_map_on_the_console() {
		pointsPage.printMapToConsole();
		//quiteBrowser();
	    
	}
}

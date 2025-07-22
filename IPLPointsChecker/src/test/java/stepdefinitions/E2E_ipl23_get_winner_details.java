package stepdefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.en.*;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import utils.ExcelReader;
import base.BaseClass;

public class E2E_ipl23_get_winner_details extends BaseClass{
	
	IPL_HomePage homePage ;
	IPL_GenericPage genericPage ; 
	IPL_PointsTablePage pointsTablePage ;
	IPL_PlayoffPage playOffPage ;
	
	Logger logger = LoggerFactory.getLogger(PointsTableSteps.class);
	
	
	int row = 0; 
	String year,winner , location , date;
	int points , wins , loss ;
	
	@Given("I open the IPL website homepage")
	public void i_open_the_ipl_website_homepage() throws InterruptedException {
		launchBrowser("https://www.iplt20.com/");
		//Assert.assertEquals(false, true);
		homePage = new IPL_HomePage (driver);
		logger.info("Opening IPL 2023 points table webpage...");
		System.out.println("I open the IPL website homepage");
	}

	@Then("the IPL logo should be visible")
	public void the_ipl_logo_should_be_visible() {
		Assert.assertTrue (homePage.pageVisible()) ;
		
	}

	@Then("the page load should be complete")
	public void the_page_load_should_be_complete() {
		Assert.assertTrue (homePage.pageVisible()) ;
	}

	@When("I select the Points Table from the mega menu")
	public void i_select_the_points_table_from_the_mega_menu() {
		genericPage = new IPL_GenericPage(driver);
		Assert.assertTrue (genericPage.pageVisible()) ;
		genericPage.SelectMegaMenuCategory("POINTS TABLE");
		//breakpoint;
	    
	}

	@Then("the Points Table page is displayed")
	public void the_points_table_page_is_displayed() {
		pointsTablePage = new IPL_PointsTablePage(driver);
		Assert.assertTrue (pointsTablePage.pageVisible()) ;
		
	    
	}

	@When("I select the Playoffs tab from the Points Table page")
	public void i_select_the_playoffs_tab_from_the_points_table_page() {
		pointsTablePage.ClickPlayoff();
		
	}

	@Then("the latest Playoffs section is displayed")
	public void the_latest_playoffs_section_is_displayed() {
		playOffPage= new IPL_PlayoffPage(driver);
		Assert.assertTrue (playOffPage.pageVisible()) ;
		
	}

	@When("I select the year {string} from the dropdown")
	public void i_select_the_year_from_the_dropdown(String year) {
		Assert.assertTrue (genericPage.YearDropDownVisible()) ;
		String excelYear = ExcelReader.getDataByTestCaseAndColumn("Testdata", "TC_01","Year");
		System.out.println("excelYear " + excelYear);
		
		playOffPage.YearDropDownSelect(excelYear);
		this.year=year;
	}

	@Then("the Playoffs section for {string} is displayed")
	public void the_playoffs_section_for_is_displayed(String year) {
		//year = ExcelReader.getCellData("Testdata", "TC_01","Year");
		//String excelYear = ExcelReader.getDataByTestCaseAndColumn("Testdata", "TC_01","Year");
		Assert.assertTrue (playOffPage.pageVisible()) ;
	}

	@When("I extract the winning team name")
	public void i_extract_the_winning_team_name() {
	    
		winner=playOffPage.getWinner();
	}

	@When("I extract the final match location and date")
	public void i_extract_the_final_match_location_and_date() {
	    
		location = playOffPage.getLocation();
		date = playOffPage.getDate();
		
	}

	@When("I navigate to the Points Table section again")
	public void i_navigate_to_the_points_table_section_again() {
		playOffPage.ClickPointsTab();
	}

	@Then("the Points Table section is displayed")
	public void the_points_table_section_is_displayed() {
		Assert.assertTrue (pointsTablePage.pageVisible()) ;
		Assert.assertTrue (genericPage.YearDropDownVisible()) ;
		String excelYear = ExcelReader.getDataByTestCaseAndColumn("Testdata", "TC_01","Year");
		pointsTablePage.YearDropDownSelect(excelYear);
	}

	@When("I find the winning team's row from the table using the previously stored name")
	public void i_find_the_winning_team_s_row_from_the_table_using_the_previously_stored_name() {
	    row = pointsTablePage.findRow(winner);
	}

	@When("I extract the winning team's points, wins, and losses based on the row")
	public void i_extract_the_winning_team_s_points_wins_and_losses_based_on_the_row() {
	    points = pointsTablePage.getPoints(row);
	    wins = pointsTablePage.getWins(row);
	    loss=pointsTablePage.getLoss(row);
	}

	@Then("the validation is complete")
	public void the_validation_is_complete() {
	   System.out.println("the validation is complete the Winner for Year " + year );
	   System.out.println("is - "+ winner + " they scored "+points + " points with " + wins + " wins and "+ loss + " losses" );
	}

}

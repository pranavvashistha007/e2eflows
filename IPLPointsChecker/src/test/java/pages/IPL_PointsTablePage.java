package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//import locators.PointsTableLocators;
import base.*;

public class IPL_PointsTablePage {

	WebDriver driver;
	Map<String, String> teamPointsMap = new HashMap<>();

	public IPL_PointsTablePage(WebDriver driver) {
		this.driver = driver;
	}

	By teamNamesLocator = By.xpath("//h2[@class='ih-pt-cont mb-0 ng-binding']");
	By teamPointsLocator = By.xpath("//td[@class='bt ng-binding']");
	By playoffTab = By.xpath("//a[@class='nav-link bracket-f ' and text()='Playoffs']");
	By dropDwonSeason = By.xpath("(//div[@class='cSBDisplay ng-binding'])[2]");
	By dropDwonSeasonYear = By.xpath("//div[@class='cSBListItems ng-binding ng-scope' and text()='SEASON 2023']");

	// By dynteamPointsLocator = By.xpath("(//td[@class='bt
	// ng-binding'])[replaceme]");
	String dynteamPointsLocator = " (//td[@class='bt ng-binding'])[replaceme] ";
	String dynteamWinsLocator = "//tr[@class='team0 ng-scope'][replaceme]//td[5]";
	String dynteamLossLocator = "//tr[@class='team0 ng-scope'][replaceme]//td[6]";
	
	String dyndropbox = "//div[@class='cSBListItems ng-binding ng-scope' and text()='SEASON replaceme']" ;

	int row;
	String winnerShortName;

	public boolean pageVisible() {
		return driver.findElement(teamPointsLocator).isDisplayed();
	}

	public void YearDropDownSelect(String text) {
		// Thread.sleep(1000);
		driver.findElement(dropDwonSeason).click();

		String temp = dyndropbox.replaceFirst("replaceme", text);

		dropDwonSeasonYear = By.xpath(temp);

		driver.findElement(dropDwonSeasonYear).click();

	}

	public int findRow(String team) {
		// this.row = 0;
		String[] temp = team.split(" ");
		winnerShortName = "";
		for (String word : temp) {
			winnerShortName = winnerShortName + word.substring(0, 1);
		}

		List<WebElement> teamNames = driver.findElements(teamNamesLocator);
		for (int i = 0; i < teamNames.size(); i++) {
			String name = teamNames.get(i).getText().trim();
			if (name.equalsIgnoreCase(winnerShortName)) {
				this.row = i;
				return i; // 🔹 Found match, return index
			}
		}
		return -1;

	}

	public int getPoints(int row) {

		String temp = dynteamPointsLocator.replaceFirst("replaceme", Integer.toString(row + 1));

		By dtpl = By.xpath(temp);

		WebElement dteam = driver.findElement(dtpl);

		String points = dteam.getText().trim();
		System.out.println("getPoints points " + points);
		return Integer.parseInt(points);
	}

	public int getWins(int row) {

		String temp = dynteamWinsLocator.replaceFirst("replaceme", Integer.toString(row + 1));

		By dtpl = By.xpath(temp);

		WebElement dteam = driver.findElement(dtpl);

		String points = dteam.getText().trim();
		System.out.println("getPoints points " + points + " row " + row);
		return Integer.parseInt(points);
		// return 0;
	}

	public int getLoss(int row) {
		String temp = dynteamLossLocator.replaceFirst("replaceme", Integer.toString(row + 1));

		By dtpl = By.xpath(temp);

		WebElement dteam = driver.findElement(dtpl);

		String points = dteam.getText().trim();
		System.out.println("getPoints points " + points);
		return Integer.parseInt(points);
	}

	public void fetchTeamPoints() {
		List<WebElement> teamNames = driver.findElements(teamNamesLocator);
		List<WebElement> teamPoints = driver.findElements(teamPointsLocator);

		for (int i = 0; i < teamNames.size(); i++) {
			String team = teamNames.get(i).getText().trim();
			String points = teamPoints.get(i).getText().trim();
			teamPointsMap.put(team, points);
		}
	}

	public void printMapToConsole() {
		System.out.println("🏏 IPL 2023 Points Table:");
		teamPointsMap.forEach((team, points) -> System.out.println("Team " + team + " -> points " + points));
		Assert.assertEquals(false, true);
	}

	public void storeInMap() {

	}

	public void ClickPlayoff() {
		driver.findElement(playoffTab).click();

	}
}

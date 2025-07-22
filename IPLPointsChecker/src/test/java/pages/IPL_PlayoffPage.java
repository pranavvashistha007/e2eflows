package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import base.*;

public class IPL_PlayoffPage {

	WebDriver driver;
	By winner = By.xpath("//div[@class='quali-1 quali-common after-dot team-gradient-bg']");
	By date = By.xpath("//div[@class='quali-2 quali-common after-unset']//h2");
	By location = By.xpath("//div[@class='quali-2 quali-common after-unset']//p");
	By pointsTab = By.xpath("//a[@class='nav-link points-t' and text()='Points Table']");
	By dropDwonSeason = By.xpath("//select[@id='ddlViewBy']");
	By dropDwonSeasonYear = By.xpath("//select[@id='ddlViewBy']//option[@value='2023']");
	
	String dyndropbox = "//select[@id='ddlViewBy']//option[@value='replaceme']" ;

	public IPL_PlayoffPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean pageVisible() {
		return driver.findElement(winner).isDisplayed();
	}

	public void YearDropDownSelect(String text) {
		BaseClass.hardWait(1000);
		driver.findElement(dropDwonSeason).click();
		BaseClass.hardWait(1000);
		
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(5));	
		
		String temp = dyndropbox.replaceFirst("replaceme", text);
		
		dropDwonSeasonYear = By.xpath(temp);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(dropDwonSeasonYear));
		
		driver.findElement(dropDwonSeasonYear).click();
		BaseClass.hardWait(1000);
	}

	public String getWinner() {

		System.out.println(driver.findElement(winner).getText());
		return driver.findElement(winner).getText();

	}

	public String getLocation() {
		System.out.println(driver.findElement(location).getText());

		return driver.findElement(location).getText();
	}

	public String getDate() {
		System.out.println(driver.findElement(date).getText());
		return driver.findElement(date).getText();
	}

	public void ClickPointsTab() {

		driver.findElement(pointsTab).click();
	}

}

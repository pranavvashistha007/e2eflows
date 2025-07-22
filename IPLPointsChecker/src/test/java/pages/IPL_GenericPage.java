package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class IPL_GenericPage {

	WebDriver driver;

	By megamenu_category = By.xpath("//nav//a[contains(text(),'POINTS TABLE')]");

	
	
	
	public IPL_GenericPage(WebDriver driver) {
		this.driver = driver;
	}
	

	public boolean pageVisible() {
		return driver.findElement(megamenu_category).isDisplayed() ;
	}

	public void SelectMegaMenuCategory(String text) {
		Actions actions = new Actions(driver);
		WebElement menu = driver.findElement(megamenu_category);
		actions.moveToElement(menu).click().perform();
		//driver.findElement(megamenu_category).click();
	}

	public boolean YearDropDownVisible() {
		System.out.println("YearDropDownVisible " );
		return true ;
		//return driver.findElement(dropDwonSeason).isDisplayed() ; 
	}

	

}

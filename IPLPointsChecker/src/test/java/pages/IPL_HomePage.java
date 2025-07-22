package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IPL_HomePage {
	
	WebDriver driver ;
	
	By megamenu_category = By.xpath("//nav//a[contains(text(),'POINTS TABLE')]");
	
	public IPL_HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean pageVisible() {
		return  driver.findElement(megamenu_category).isDisplayed() ;
	}
}

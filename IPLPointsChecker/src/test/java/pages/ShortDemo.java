package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ShortDemo {
	
	private WebDriver driver ;
	By team = By.cssSelector(".ih-pt-cont.mb-0.ng-binding") ;
	
	public ShortDemo(WebDriver driver) {
		this.driver=driver ;
	}
	
	public void getData() {
		System.out.println(driver.findElement(team).getText());  ;
		
		List <WebElement> list = driver.findElements(team) ;
		
		for (WebElement el : list) {
			System.out.println(el.getText()) ;
		}
		
		System.out.println("User get data");
	}
	
	public void validateData() {
		System.out.println("User validate data");
	}

}

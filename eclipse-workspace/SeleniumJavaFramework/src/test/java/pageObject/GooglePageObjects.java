package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePageObjects {

	WebDriver driver = null;
	
	public GooglePageObjects(WebDriver driver) {		
		this.driver = driver;
	}
	
	By searchBox = By.name("q");
	By searchBtn = By.name("btnK");
	
	public void googleSearchByText(String text) {
		driver.findElement(searchBox).sendKeys(text);
	}
	
	public void googleSearchClick() {
		driver.findElement(searchBtn).sendKeys(Keys.ENTER);
	}
}

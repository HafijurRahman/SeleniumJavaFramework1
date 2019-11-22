package PageObjectModelAdvance;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class googleSearchPageObjects {

	WebDriver driver = null;
	
	//defining locator
	By textbox_search = By.name("q");
		
	//Constructor
	public googleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//Inserting texts in the search box
	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	//Hitting Enter from the keyboard by selecting the search box
	public void pressingEnterButtonBySelectingTextSearchBox() {
		driver.findElement(textbox_search).sendKeys(Keys.RETURN);
	}
}

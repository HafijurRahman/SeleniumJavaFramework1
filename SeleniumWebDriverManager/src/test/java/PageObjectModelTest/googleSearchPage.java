package PageObjectModelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class googleSearchPage {
	
	private static WebElement element = null;
	
	public static WebElement textbox_search(WebDriver driver){
		
		//Inserting texts in the search box
		element = driver.findElement(By.name("q"));
		return element;
	}
	
}

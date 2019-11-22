package PageObjectModelTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleSearchTest {
	
	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		
		googleSearch();
	}
	
	
	public static void googleSearch() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		
		//Visiting google.com
		driver.get("https://google.com");
		
		//Inserting texts in the search box
		googleSearchPage.textbox_search(driver).sendKeys("Automation");
						
		//Hitting Enter from the keyboard by selecting the search box
		googleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);
				
		//Waiting for some seconds
		Thread.sleep(5000);
		
		//Closing the browser
		driver.close();
		
		//Printing the result
		System.out.println("Test Completed Successfully");
	}

}

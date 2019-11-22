package PageObjectModelAdvance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Properties_TestNG_Demo {

	private static WebDriver driver = null;
	
	public static String browserName = null;
	
	
	@BeforeTest
	public void setupTest() {
	
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}	
	}
	
	
	@Test
	public void googleSearchTest() throws InterruptedException {
		
		//Creating object class
		googleSearchPageObjects searchPageObj = new googleSearchPageObjects(driver);
		
		//Visiting google.com
		driver.get("https://google.com");
		
		//Inserting texts in the search box
		searchPageObj.setTextInSearchBox("Automation");
		
		//Hitting Enter from the keyboard by selecting the search box
		searchPageObj.pressingEnterButtonBySelectingTextSearchBox();
		
		//Waiting for some seconds
		Thread.sleep(5000);
	}
	
	
	@AfterTest
	public void tearDownTest() {
		
		//Closing the browser
		driver.close();
		
		//Printing the result
		System.out.println("Test Completed Successfully");
		
		PropertiesFile.setProperties();
	}

}

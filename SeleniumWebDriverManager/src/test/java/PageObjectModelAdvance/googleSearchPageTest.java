package PageObjectModelAdvance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleSearchPageTest {

	private static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		googleSearchTest();
	}
	
	public static void googleSearchTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
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
		
		//Closing the browser
		driver.close();
		
		//Printing the result
		System.out.println("Test Completed Successfully");
		
	}

}

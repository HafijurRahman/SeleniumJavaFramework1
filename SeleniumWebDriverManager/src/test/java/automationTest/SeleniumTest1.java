package automationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest1 {

	public static void main(String[] args) throws InterruptedException {
		
		googleSearch();
	}
	
	
	public static void googleSearch() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Visiting google.com
		driver.get("https://google.com");
		
		//Inserting texts in the search box
		driver.findElement(By.name("q")).sendKeys("Automation");
		
		
		//Hitting Enter from the keyboard by selecting the search box
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		//Clicking on the search button
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		//driver.findElement(By.xpath("//input[@name='btnK']")).click();
		
		//Waiting for some seconds
		Thread.sleep(5000);
		
		//Closing the browser
		driver.close();
		
		//Printing the result
		System.out.println("Test Completed Successfully");
		
	}

}

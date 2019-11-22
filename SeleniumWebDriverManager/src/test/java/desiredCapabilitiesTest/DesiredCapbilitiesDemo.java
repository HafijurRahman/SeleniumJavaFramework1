package desiredCapabilitiesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapbilitiesDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver(caps);
		
		//Visiting google.com
		driver.get("https://google.com");
		
		//Inserting texts in the search box
		driver.findElement(By.name("q")).sendKeys("Automation");
		
		//Hitting Enter from the keyboard by selecting the search box
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		//Waiting for some seconds
		//Thread.sleep(5000);
		
		//Closing the browser
		driver.close();
		driver.quit();
		
		//Printing the result
		System.out.println("Test Completed Successfully");
	}

}

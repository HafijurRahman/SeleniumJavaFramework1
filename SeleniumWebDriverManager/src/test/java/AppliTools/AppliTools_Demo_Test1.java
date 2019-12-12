package AppliTools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppliTools_Demo_Test1 {

	public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		// Initialize the eyes SDK
		Eyes eyes = new Eyes();

		// Change the APPLITOOLS_API_KEY API key with yours
		eyes.setApiKey("97qLgTHvSOWv108D3ytwN5sCKiKH1078y3z4X4p4eXWFfQt0110");

		try {
			// Start the test and set the browser's viewport size to 800 X 600
			eyes.open(driver, "Hello World!", "My first Selenium Java Test", new RectangleSize(800, 600));

			// Navigate the browser to the "Hello World" web-site URL#1
			//driver.get("https://applitools.com/helloworld");
			
			// Navigate the browser to the "Hello World" web-site URL#2
			//driver.get("https://applitools.com/helloworld?diff1");
			
			// Navigate the browser to the "Hello World" web-site URL#3
			driver.get("https://applitools.com/helloworld?diff2");

			// This line takes the screenshot
			// Visual checkpoint #1
			eyes.checkWindow("Hello!");

			// Click the 'Click me!' button
			driver.findElement(By.tagName("button")).click();

			// This line takes the screenshot
			// Visual checkpoint #2
			eyes.checkWindow("Click!");

			// End the test.
			eyes.close();

		} finally {

			// Close the browser.
			driver.quit();

			// If the test was aborted before eyes.close was called, ends the test aborted
			eyes.abortIfNotClosed();		
		}

	}
}

package SauceLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs_Demo_Test1{

	public static final String USERNAME = "hrahman";
	public static final String ACCESS_KEY = "84fc79b1-fef5-4d23-a9a5-5cc88a3cc6e2";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		
		caps.setCapability("platform", "Linux");
		//caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");
		caps.setCapability("name", "GoogleTest1");
		caps.setCapability("extendedDebugging", "true");
		caps.setCapability("buildNumber", "1.0");
		
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);

		driver.get("https://google.com/");
		System.out.println("Title of the page is: " + driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("abcd");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		System.out.println("Title of the page is: " + driver.getTitle());
		
		driver.quit();
		System.out.println("Test Completed!");
	}
	
}

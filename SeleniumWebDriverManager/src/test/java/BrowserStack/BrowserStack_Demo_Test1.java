package BrowserStack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStack_Demo_Test1 {
	public static final String USERNAME = "hafijurrahman3";
	public static final String AUTOMATE_KEY = "VqrRKy5dsysNhP9s4HS9";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "79.0 beta");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1366x768");
		caps.setCapability("name", "Test1");
		caps.setCapability("build", "Build1");
		caps.setCapability("project", "BrowserStackTest");
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browserstack.networkLogs", "true");
		caps.setCapability("browserstack.selenium_version", "3.5.2");

		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys("abcd");
		element.submit();

		System.out.println(driver.getTitle());
		driver.quit();
	}
}
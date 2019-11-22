package PageObjectModelAdvance;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReportsBasicDemo {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		//start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		//create ExtentReports and attach reporters
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("Google Search Test One", "This is a test to validate google search functionality ");

		//Google chrome setup
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		test1.log(Status.INFO,"Starting Test Case");
		driver.get("https://google.com");
		test1.pass("Navigating to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Inserting texts in the search box");
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test1.pass("Hitting Enter from the keyboard by selecting the search box");
		
		driver.close();
		driver.quit();
		test1.pass("Closing the browser");
		
		test1.info("Test Completed Successfully");
		
		//calling flush writes everything to the log file
		extent.flush();
		
	}

}

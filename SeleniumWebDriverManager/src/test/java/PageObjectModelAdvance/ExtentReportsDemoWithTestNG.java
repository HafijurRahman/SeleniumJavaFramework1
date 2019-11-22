package PageObjectModelAdvance;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1;

	private static WebDriver driver = null;

	@BeforeSuite
	public void setUp() {
		//start reporters
		htmlReporter = new ExtentHtmlReporter("extentReports.html");

		//create ExtentReports and attach reporters
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	
	
	@BeforeTest
	public void setupTest() {
		//Google Chrome setup
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}


	
	@Test
	public void test1() throws IOException {
		//creates a toggle for the given test, adds all log events under it
		test1 = extent.createTest("Google Search Test One", "This is a test to validate google search functionality ");

		test1.log(Status.INFO,"Starting Test Case");
		driver.get("https://google.com");
		test1.pass("Navigating to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Inserting texts in the search box");
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test1.pass("Hitting Enter from the keyboard by selecting the search box");
		
		//log with snapshot
		//test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		//test1.addScreenCaptureFromPath("screenshot.png");					
	}


	

	@AfterTest
	public void tearDownTest() {

		//Closing the browser
		driver.close();
		driver.quit();
		test1.pass("Closing the browser");
		
		test1.info("Test Completed Successfully");
	}

	

	
	@AfterSuite
	public void tearDown() {
		//calling flush writes everything to the log file
		extent.flush();
	}

}

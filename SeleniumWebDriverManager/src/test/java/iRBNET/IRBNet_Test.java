package iRBNET;

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

public class IRBNet_Test {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest LoginTest;

	private static WebDriver driver = null;

	@BeforeSuite
	public void setUp() {
		//Starts Reporter
		htmlReporter = new ExtentHtmlReporter("IRBNet_ExtentReport_LoginTest.html");

		//Creates ExtentReport and attach reporters
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
	public void IRBNet_Login_Test() throws InterruptedException {

		//Creates a toggle for the given test, adds all log events under it
		LoginTest = extent.createTest("IRBNet Login Test", "This is a test to validate IRBNet login functionality.");


		//Creating object class for IRBNetHomePageObjects
		IRBNetHomePageObjects IRBNetHomePageObj = new IRBNetHomePageObjects(driver);
		
		//Creating object class for IRBNet_UserLandingPageObjects
		IRBNet_UserLandingPageObjects IRBNet_UserLandingPageObj = new IRBNet_UserLandingPageObjects(driver);

		LoginTest.log(Status.INFO,"Starting Test Case");
		driver.get("https://validation.irbnet.org/release/index.html");
		LoginTest.pass("Visiting IRBNet portal");

		IRBNetHomePageObj.setLogin_Username("valresearch1");
		LoginTest.pass("Inserting login Username");

		IRBNetHomePageObj.setLogin_Password("validation");
		LoginTest.pass("Inserting login Password");

		IRBNetHomePageObj.click_LoginButton();
		LoginTest.pass("Clicking on 'Login' button");

		Thread.sleep(3000);
		LoginTest.pass("Waiting for some seconds");

		IRBNet_UserLandingPageObj.click_LogoutButton();
		LoginTest.pass("Clicking on 'Logout' button");

		Thread.sleep(3000);
		LoginTest.pass("Waiting for some seconds");
	}


	@AfterTest
	public void tearDownTest() {
		driver.close();
		LoginTest.pass("Closing the browser");

		LoginTest.info("Test Completed Successfully");
	}


	@AfterSuite
	public void tearDown() {
		//calling flush writes everything to the log file
		extent.flush();
	}

}

package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
import pageObjects.HomePageObjects;
import pageObjects.User_LandingPageObjects;

public class IRBNet_Test_Main_Class {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest LoginTest;

	private static WebDriver driver = null;

	@BeforeSuite
	public void setUp() {
		//Start Reporters
		htmlReporter = new ExtentHtmlReporter("IRBNet_ExtentReport_LoginTest2.html");

		//Create ExtentReport and attach Reporters
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
	public void IRBNet_Login_Test() throws Exception {

		//Creates a toggle for the given test, adds all log events under it
		LoginTest = extent.createTest("IRBNet Login Test", "This is a test to validate IRBNet login functionality.");

		//Creating object class for HomePageObjects
		HomePageObjects HomePageObj = new HomePageObjects(driver);
		
		//Creating object class for User_LandingPageObjects
		User_LandingPageObjects UserLandingPageObj = new User_LandingPageObjects(driver);
		

		LoginTest.log(Status.INFO,"Starting Test Case");
		
		driver.get(Utility.Constant.strURL);
		driver.manage().window().maximize();
		LoginTest.pass("Visiting IRBNet portal");
		
		Thread.sleep(10000);
		LoginTest.pass("Waiting for some seconds");
		
		
		Utility.ExcelUtils.setExcelFile(Utility.Constant.Path_TestData + Utility.Constant.File_TestData,"Sheet1");
		String sUserName = Utility.ExcelUtils.getCellData(1, 0);
		String sPassword = Utility.ExcelUtils.getCellData(1, 1);

		HomePageObj.setLogin_Username(sUserName);
		LoginTest.pass("Inserting login Username");

		HomePageObj.setLogin_Password(sPassword);
		LoginTest.pass("Inserting login Password");
		
		
		HomePageObj.click_LoginButton();
		LoginTest.pass("Clicking on 'Login' button");
		
		String message = UserLandingPageObj.getWelcomeMsg();
		System.out.println("The string is "+message);
		Assert.assertTrue(message.contains("Welcome to IRBNet"));
		LoginTest.pass("Validating left navigation column's Welcome text");
		
		Thread.sleep(5000);
		LoginTest.pass("Waiting for some seconds");

		UserLandingPageObj.click_LogoutButton();
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
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class User_LandingPageObjects {

	WebDriver driver = null;

	//defining locator(s)
	By logout_button = By.xpath("//*[@id=\"pagemenu\"]/td/map/area[2]");
	By welcomeMsg = By.xpath("//*[@id=\"mnav\"]/li[1]");


	//Constructor
	public User_LandingPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	//Clicking on 'Logout' button
	public void click_LogoutButton() {
		driver.findElement(logout_button).click();
	}


	//Validating UserLandingPage's left navigation column texts
	public String getWelcomeMsg(){
		return driver.findElement(welcomeMsg).getText();
	}

}

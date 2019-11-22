package iRBNET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IRBNet_UserLandingPageObjects {

	WebDriver driver = null;
	
	//defining locator(s)
	By logout_button = By.xpath("/html/body/table/tbody/tr[1]/td/map/area[2]");
	
	
	//Constructor
	public IRBNet_UserLandingPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Clicking on 'Logout' button
	public void click_LogoutButton() {
		driver.findElement(logout_button).click();
	}
	
}

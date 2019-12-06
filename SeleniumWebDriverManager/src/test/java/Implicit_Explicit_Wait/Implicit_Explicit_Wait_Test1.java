package Implicit_Explicit_Wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Implicit_Explicit_Wait_Test1 {
	
	private static WebDriver driver;
	
	
	public static void main(String[] args) {
		seleniumWaits();
	}
	
	public static void seleniumWaits() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    
	    //Implicit Wait
	    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcdef")));
		
		//driver.findElement(By.name("abcd")).click();
		
		
		driver.close();
		driver.quit();
	}
}

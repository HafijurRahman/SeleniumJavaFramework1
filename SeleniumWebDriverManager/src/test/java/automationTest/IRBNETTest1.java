package automationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRBNETTest1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Visiting IRBNET Site
		driver.get("https://validation.irbnet.org/release/index.html");
		
		//Inserting texts into Username & Password fields
		driver.findElement(By.name("j_username")).sendKeys("valresearch1");
		driver.findElement(By.name("j_password")).sendKeys("validation");
		
		//Clicking on the login button
		driver.findElement(By.name("login")).click();
		
		//Waiting for some seconds
		Thread.sleep(3000);
		
		//Clicking on the the logout button
		//driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/map/area[2]")).click();
		
		//driver.findElement(By.id("searchByTag"));
		driver.findElement(By.xpath("//*[@id=\"searchByTag\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[3]/div[5]/div/div/div/div/table/tbody[2]/tr[4]/td/div/a/div/div/div/div")).click();
		
		
		driver.findElement(By.name("search")).click();
		
		
		
		//Waiting for some seconds
		//Thread.sleep(3000);
		
		//Closing the browser
		//driver.close();
		
		//Printing the result
		//System.out.println("Test Completed Successfully");

	}

}

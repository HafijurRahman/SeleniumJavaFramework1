import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
							
		driver.get("https://google.com");
		
		WebElement textBox = driver.findElement(By.name("q"));
		textBox.sendKeys("Automation Step by Step");
		
		//driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation Step by Step");
		
		//List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		//int count = listOfInputElements.size();
		//System.out.println("Count of Input elements = "+count);
		
		
		Thread.sleep(5000);
		
		driver.close();
		//driver.quit();
	}
}

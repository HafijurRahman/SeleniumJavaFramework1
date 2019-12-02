package TestNG_Listeners_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(TestNG_Listeners_Demo.TestNGListeners.class)
public class TestNGListenerDemo {
	
	WebDriver driver = null;
	
	
	@Test
	public void test1() {
		System.out.println("I am inside test1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside test2");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		//Negative 
		driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("abcd");
		
		driver.close();
		
	}
	
	@Test
	public void test3() {
		System.out.println("I am inside test3");
		throw new SkipException("This test is skipped");
	}
	
}

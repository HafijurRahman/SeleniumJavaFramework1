package AutoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload_AutoIT_Test1 {


	public static void main(String[] args) throws Exception {
		test();
	}


	public static void test() throws Exception{

		WebDriver driver;
		String projectPath = System.getProperty("user.dir");	

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://www.tinyupload.com/");
		driver.manage().window().maximize();

		Thread.sleep(3000);

		//Clicking 'Choose File' button by Co-Ordinates
		Actions actions = new Actions(driver);
		actions.moveByOffset(670, 300).click().build().perform();

		Thread.sleep(3000);

		//Alternate Option of Uploading Files
		//driver.findElement(By.name("uploaded_file")).sendKeys(projectPath+ "/src/test/java/AutoIT/File1.txt");

		//AutoIT .exe file
		Runtime.getRuntime().exec(projectPath+ "/src/test/java/AutoIT/FileUpload_Script_AutoIT_Test1.exe");

		Thread.sleep(3000);

		//Clicking on Upload button
		driver.findElement(By.xpath("//img[@alt='Upload']")).click();

		Thread.sleep(5000);

		driver.close();
		driver.quit();

		System.out.println("Test Completed!");
	}

}



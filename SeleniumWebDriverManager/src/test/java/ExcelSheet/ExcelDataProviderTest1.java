package ExcelSheet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProviderTest1 {

	/*
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath +"/ExcelFile/testdata.xlsx";
		testData(excelPath, "Sheet1");
	} */

	
	WebDriver driver = null;
	
	@BeforeTest
	public void setupTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}



	
	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws InterruptedException {
		System.out.println(username+" | "+password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username); 
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(3000);
	}




	@DataProvider(name = "test1data")
	public Object[][] getData() {

		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath +"/ExcelFile/testdata.xlsx";

		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}





	public Object[][] testData(String excelPath, String sheetName) {

		ExcelUtilsTest1 excel = new ExcelUtilsTest1(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data [][] = new Object[rowCount-1][colCount];

		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {

				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;

			}
			//System.out.println();
		}
		return data;
	}

}

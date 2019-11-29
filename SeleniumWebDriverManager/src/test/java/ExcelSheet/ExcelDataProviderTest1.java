package ExcelSheet;

public class ExcelDataProviderTest1 {


	public static void main(String[] args) {
		String excelPath = "F:\\Backup (Hafij)\\Resources (Office)\\Projects\\SelfLearning\\Selenium\\GitHub Repo\\SeleniumJavaFramework1\\SeleniumWebDriverManager\\ExcelFile\\testdata.xlsx";
		testData(excelPath, "Sheet1");
	}


	public static void testData(String excelPath, String sheetName) {

		ExcelUtilsTest1 excel = new ExcelUtilsTest1(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {

				String cellData = excel.getCellDataString(i, j);
				System.out.println(cellData);
			}
		}	
	}



}

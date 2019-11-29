package ExcelSheet;

public class ExcelUtilsTest1Demo {
	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		ExcelUtilsTest1 excel = new ExcelUtilsTest1(projectPath+"/ExcelFile/testdata.xlsx", "Sheet1");
			
		excel.getRowCount();
		excel.getColCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);	
	}
}

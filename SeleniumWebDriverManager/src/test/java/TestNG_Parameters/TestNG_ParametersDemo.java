package TestNG_Parameters;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_ParametersDemo {

		@Test
		@Parameters({"MyName"})
		public void test(@Optional("Insert Data") String name) {
			System.out.println("Name is: " +name);
		}
		
}

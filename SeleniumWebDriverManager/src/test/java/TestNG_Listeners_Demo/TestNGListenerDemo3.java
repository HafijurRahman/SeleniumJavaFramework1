package TestNG_Listeners_Demo;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestNG_Listeners_Demo.TestNGListeners.class)
public class TestNGListenerDemo3 {
	
	@Test
	public void test7() {
		System.out.println("I am inside test7");
	}
	
	@Test
	public void test8() {
		System.out.println("I am inside test8");
	}
	
	@Test
	public void test9() {
		System.out.println("I am inside test9");
		throw new SkipException("This test is skipped");
	}
	
}

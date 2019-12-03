package TestNG_ReRunTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_ReRunTestsDemo {
	
	@Test
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	
	@Test
	public void test2() {
		System.out.println("I am inside Test 2");
		//int i = 1/0;
	}
	
	
	@Test(retryAnalyzer = TestNG_ReRunTests.RetryAnalyzer.class)
	public void test3() {
		System.out.println("I am inside Test 3");
		Assert.assertTrue(false);
	}
}

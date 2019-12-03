package TestNG_Dependencies;

import org.testng.annotations.Test;

public class TestNG_DependenciesDemo {
	
	/** Dependencies + Priorities
	@Test(dependsOnMethods = {"test2"}, priority = 1)
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	
	@Test(priority = 2)
	public void test2() {
		System.out.println("I am inside Test 2");
	}
	**/
	
	
	/** Multiple Dependencies
	@Test(dependsOnMethods = {"test4","test5"})
	public void test3() {
		System.out.println("I am inside Test 3");
	}
	
	
	
	@Test()
	public void test4() {
		System.out.println("I am inside Test 4");
	}
	
	
	@Test()
	public void test5() {
		System.out.println("I am inside Test 5");
	}
	**/ 
	
	
	
	/** Group Dependencies 
	@Test(dependsOnGroups = {"sanity1"})
	public void test6() {
		System.out.println("I am inside Test 6");
	}
	
	
	
	@Test(groups = {"sanity1"})
	public void test7() {
		System.out.println("I am inside Test 7");
	}
	
	
	@Test()
	public void test8() {
		System.out.println("I am inside Test 8");
	}
	**/
	
	
	/** Regular Expression **/ 
	@Test(dependsOnGroups = {"sanity.*"})
	public void test9() {
		System.out.println("I am inside Test 9");
	}
	
	
	
	@Test(groups = {"sanity1"})
	public void test10() {
		System.out.println("I am inside Test 10");
	}
	
	
	@Test(groups = {"sanity2"})
	public void test11() {
		System.out.println("I am inside Test 11");
	}
	
}

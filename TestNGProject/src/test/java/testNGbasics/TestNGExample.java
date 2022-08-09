package testNGbasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample {
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Beforemethod");
	}
	@Test
	public void Testcase1()
	{
		System.out.println("Testcase1");
	}
	
    @AfterMethod
    public void AfterMethod()
    {
    	System.out.println("AfterMethod");
    }
        @BeforeClass
     public void BeforeClass()
    {
	System.out.println("BeforeClass");
	
     }
     @AfterClass
    public void AfterClass()
    {
	System.out.println("AfterClass");
	
     }
    @BeforeTest
     public void BeforeTest()
       {
	System.out.println("BeforeTest");
	
      }
    @AfterTest
     public void AfterTest()
      {
	System.out.println("AfterTest");
	
      }
    @Test
    public void Testcase2()
    {
	System.out.println("Testcase2");
	
    }
    
    @Test
    public void Testcase3()
    {
	System.out.println("Testcase3");
	
    }
    @BeforeSuite
    public void Beforesuit()
    {
	System.out.println("Beforesuit");
	
    }
    @AfterSuite
    public void Aftersuit()
    {
	System.out.println("Aftersuit");
	
    }
}

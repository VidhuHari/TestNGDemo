package testNGbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestcaseDemo {
	WebDriver driver;
	SoftAssert softassert;
	@BeforeMethod
	public void beforemethod()
	{
   WebDriverManager.chromedriver().setup();
   driver=new ChromeDriver();
   driver.get("https://www.amazon.in/");
   driver.manage().window().maximize();
    }
	
	@Test
	public void verifyUrl_amazone()
	{
    String expectedUrl="https://www.amazon.in/";
    String actualUrl=driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl, actualUrl,"Url is not matching");
    }
	@Test
	public void verifytitle_amazone()
	{
	softassert=new SoftAssert();
    String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    String actualTitle=driver.getTitle();
    System.out.println("actualtitle:"+actualTitle);
    String expectedUrl="https://www.amazon.in/";
    String actualUrl=driver.getCurrentUrl();
   // Assert.assertEquals(expectedTitle, actualTitle,"title is not matching");
    softassert.assertEquals(expectedTitle, actualTitle);
    System.out.println("After assert");
    softassert.assertEquals(expectedUrl, actualUrl);
    softassert.assertAll();
    //System.out.println("print");
    
    }
	
}
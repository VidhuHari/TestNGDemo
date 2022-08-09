package testNGbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleCases {
WebDriver driver;

@BeforeMethod

public void beforemethod()
{
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	driver.manage().window().maximize();
}
@Test
public void test1()
{
	driver.get("https://www.flipkart.com/");
	String expectedTitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
    String actualTitle=driver.getTitle();
    Assert.assertEquals(expectedTitle, actualTitle,"Url is not matching");
}
@Test
public void test2()
{
	driver.get("https://www.amazon.in");
	String expectedUrl="https://www.amazon.in/";
    String actualUrl=driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl, actualUrl,"Url is not matching");
}
}

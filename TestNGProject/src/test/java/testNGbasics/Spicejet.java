package testNGbasics;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spicejet {
	WebDriver driver;

	@BeforeMethod
public void beforemethod()
{
		WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://www.spicejet.com/");
}
	@Test(priority = 3)
	public void currentTitle()
	{
		String expextedtitle="SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		String  actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(expextedtitle, actualtitle,"Title is not matching");
	}
	@Test(priority = 2)
	public void currentUrl()
	{
		String actualurl=driver.getCurrentUrl();
		System.out.println(actualurl);
		String expecturl="https://www.spicejet.com/";
		Assert.assertEquals(actualurl,expecturl,"Url is not matching");
	}
	@Test(priority = 1,enabled = false)//test case not executed
	
	public void searchButtoncolor()
	{
		WebElement searchbutton=driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']"));
		String actualMessage="rgba(17, 17, 17, 1)";
		String expectedMeaasage=searchbutton.getCssValue("color");
		System.out.println(expectedMeaasage);
		Assert.assertEquals(actualMessage,expectedMeaasage,"color is not matching");
	}
	
	
	
	}


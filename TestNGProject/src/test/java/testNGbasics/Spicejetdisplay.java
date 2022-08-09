package testNGbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spicejetdisplay {
WebDriver driver;
@BeforeMethod
public void beforemethod()
{
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.manage().window().maximize();
}
@Test
public void verifyUrl()
{
	driver.get("https://www.spicejet.com/");
	String actualurl=driver.getCurrentUrl();
	String expturl="https://www.spicejet.com/";
	System.out.println("currenturl:"+actualurl);
    Assert.assertEquals(expturl, actualurl,"Url not matching");
}
@Test
public void verifyTitle()
{
	driver.get("https://www.spicejet.com/");
	String actualtitle=driver.getTitle();
	String expextedtitle="SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
	System.out.println(expextedtitle);
	 Assert.assertEquals(expextedtitle,actualtitle,"title not matching");
	}
@Test
public void logo() throws InterruptedException
{
	  driver.get("https://www.spicejet.com/");
	  WebElement logo=driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-13awgt0 r-1mlwlqe r-1udh08x r-1otgn73 r-1lgpqti']"));
       Thread.sleep(2000);
		Boolean logostatus=logo.isDisplayed();
		System.out.println(logostatus+":logo displayed");
		Assert.assertTrue(logostatus);
}
@Test
public void roundtrip()
{ 
	driver.get("https://www.spicejet.com/");
	WebElement serchfligtbutton=driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']"));
	Boolean searchflightstatus=serchfligtbutton.isDisplayed();
	System.out.println(searchflightstatus+":searchflightdisplayed");
	Assert.assertTrue(searchflightstatus, "not working");
}
@AfterMethod
public void aftermethod()
{
	driver.close();
}
}



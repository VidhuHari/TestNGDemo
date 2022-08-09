package testNGbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Display {
WebDriver driver;
@BeforeMethod()
public void beforemethod()
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
}
@Test
public void verifyUrl()
{
	driver.get(" https://selenium.obsqurazone.com/index.php ");
	String actualUrl =driver.getCurrentUrl();
	System.out.println(actualUrl);
	String exptUrl="https://selenium.obsqurazone.com/index.php";
	Assert.assertEquals(actualUrl,exptUrl, "not matching");
}


@Test
public void verifyTitle()
{
	driver.get(" https://selenium.obsqurazone.com/index.php ");
	 String expextedtitle="Obsqura Testing";
      String actualtitle=driver.getTitle();
      System.out.println("title:"+actualtitle);
      Assert.assertEquals(actualtitle,expextedtitle, "not matching");
}
@Test
public void verifylogo()
{
	driver.get(" https://selenium.obsqurazone.com/index.php ");
	WebElement logo=driver.findElement(By.xpath("//img[@src='images/logo.png']"));
    Boolean logoStatus=logo.isDisplayed();
	System.out.println(logoStatus+":logo displayed");
    Assert.assertTrue(logoStatus);
}


}
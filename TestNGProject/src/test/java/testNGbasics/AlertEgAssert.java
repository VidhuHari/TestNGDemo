package testNGbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertEgAssert {
	WebDriver driver;
	SoftAssert softassert;
	@BeforeMethod
	public void beforemethod()
	{
   WebDriverManager.chromedriver().setup();
   driver=new ChromeDriver();
   driver.manage().window().maximize();
    }
	@Test
	public void verifyclickmebutton()
	{
		softassert=new SoftAssert();
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement clickme=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		clickme.click();
		String actualtext=driver.switchTo().alert().getText();
		System.out.println(actualtext);
		driver.switchTo().alert().accept();
		String expttext="I am a Javascript alert box!";
		softassert.assertEquals(actualtext,expttext,"error");
		softassert.assertAll();
	}
	@Test
	public void verifydismissalertbox() throws InterruptedException
	{
		
	softassert=new SoftAssert();
	driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
	WebElement clickme=driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
	clickme.click();
	String actualtext=driver.switchTo().alert().getText();
	System.out.println(actualtext);
	String expttext="Press a button!";
	Thread.sleep(2000);
    driver.switchTo().alert().dismiss();
    softassert.assertEquals(actualtext,expttext,"error");
	softassert.assertAll();
	}
	@Test
	public void verifysendtext() throws InterruptedException
	{
		
	softassert=new SoftAssert();
	driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
	WebElement clickmeforprompt=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	clickmeforprompt.click();
	Thread.sleep(2000);
	driver.switchTo().alert().sendKeys("welcome");
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
    WebElement showmessage=driver.findElement(By.xpath("//p[@id='prompt-demo']"));
    String actualtext=showmessage.getText();
    System.out.println(actualtext);
    String expttxt="You have entered 'welcome' !";
    System.out.println("actualtext:"+actualtext);
    softassert.assertEquals(actualtext, expttxt);
	softassert.assertAll();
	}
	@AfterMethod
		public void aftermethod()
		{
			driver.close();
		}
	}
	


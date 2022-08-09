package testNGbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudyTestNG {
	WebDriver driver;
	@BeforeMethod
	public void beforemethod()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(" https://selenium.obsqurazone.com/window-popup.php");
	}
	@Test
	public void likeusFacebook()
	{
		
		WebElement facebookbutton=driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
		String actualtooltip=facebookbutton.getAttribute("title");
		System.out.println(actualtooltip);
		String expecttooltip="Follow @obsqurazone on Facebook";
		Assert.assertEquals(actualtooltip,expecttooltip, "tooltip not matched");
	}@Test
	public void followAll()
	{
		
		WebElement followbutton=driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		String actualtooltip1=followbutton.getAttribute("title");
		System.out.println(actualtooltip1);
		String expecttooltip1="Follow @obsqurazone";
		Assert.assertEquals(actualtooltip1,expecttooltip1, "tooltip not matched");
		
	}
	
	@Test
	public void clickMe() throws InterruptedException
	{
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php ");
		WebElement clickmebutton=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		clickmebutton.click();
		Thread.sleep(2000);
		String actualMessage=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String expectMessage="I am a Javascript alert box!";
		System.out.println(actualMessage);
		Assert.assertEquals(expectMessage,actualMessage,"text not matched");
		}
  

	@Test
	public void form() throws InterruptedException
	{
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php ");
		WebElement showmebutton=driver.findElement(By.id("button-one"));
		WebElement input1=driver.findElement(By.id("single-input-field"));
		input1.sendKeys("welcome");
		showmebutton.click();
		Thread.sleep(2000);
		WebElement showmetext=driver.findElement(By.id("message-one"));
		String actualMessage=showmetext.getText();
		System.out.println("actualmessage:"+actualMessage);
		String expectMessage="Your Message : welcome";
		Assert.assertEquals(expectMessage,actualMessage,"text not matched");
	}
	 
	@AfterMethod
	public void aftertest()
	{
		driver.close();
	}
	 
	}



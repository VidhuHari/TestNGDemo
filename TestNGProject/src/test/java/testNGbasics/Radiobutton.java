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

public class Radiobutton {
	WebDriver driver;
	@BeforeMethod()
	public void beforemethod()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void radiobuttonmaleselected() throws InterruptedException
	{
		driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
		
		WebElement male=driver.findElement(By.id("inlineRadio1"));
		male.click();
		Thread.sleep(2000);
		WebElement showselectValue=driver.findElement(By.id("button-one"));
		showselectValue.click();
		boolean select1= male.isSelected();
		String exptMessage="Radio button 'Male' is checked";
		WebElement yourMessage=driver.findElement(By.xpath("//div[@id='message-one']"));
		String exptmessage1=yourMessage.getText();
		Assert.assertTrue(true);
		System.out.println("Male:"+exptmessage1);
		Assert.assertEquals(exptMessage, exptmessage1,"error");
						
}
	@Test
	public void radiobuttonfemaleselected() throws InterruptedException
	{
		         driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
				 WebElement female=driver.findElement(By.id("inlineRadio2"));
				 female.click();
				 WebElement showselectValue1=driver.findElement(By.id("button-one"));
				 showselectValue1.click();
				 boolean select2=female.isSelected();
				 WebElement yourMessage1=driver.findElement(By.xpath("//div[@id='message-one']"));
				 String exptMessage2="Radio button 'Female' is checked";
				 String actualMessage=yourMessage1.getText();	
				 Assert.assertTrue(select2);
				 System.out.println("FeMale:"+ exptMessage2);
				 Thread.sleep(2000);
				 Assert.assertEquals(exptMessage2, actualMessage,"error");
}
	@AfterMethod
	public void aftertest()
	{
		driver.close();
	}
}

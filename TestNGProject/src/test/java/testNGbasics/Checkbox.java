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

public class Checkbox {
	WebDriver driver;
	@BeforeMethod()
	public void beforemethod()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void Checkboxselect() throws InterruptedException
	{
		driver.get(" https://the-internet.herokuapp.com/checkboxes");
		WebElement checkboxes=driver.findElement(By.xpath("//form[@id='checkboxes']"));
		Boolean checkboxStatus=checkboxes.isDisplayed();
		System.out.println(checkboxStatus+":checkboxes displyed");
		Thread.sleep(2000);
		
		WebElement checkbox1=driver.findElement(By.xpath("//input[1]"));
		WebElement checkbox2=driver.findElement(By.xpath("//input[2]"));
		boolean select1=checkbox1.isSelected();
		boolean select2=checkbox2.isSelected();
		Assert.assertTrue(true);
		checkbox1.click();
		Assert.assertTrue(select2);
		checkbox2.click();
}
	@Test
	public void Login() throws InterruptedException
	   {
		driver.get("https://demo.guru99.com/test/newtours/index.php ");
		WebElement useName=driver.findElement(By.xpath("//input[@name='userName']"));
		useName.sendKeys("mercury");
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("mercury");
		WebElement submittButton=driver.findElement(By.xpath("//input[@name='submit']"));
		submittButton.click();
		WebElement loginsuccess=driver.findElement(By.xpath("//h3[text()='Login Successfully']"));
		String result=loginsuccess.getText();
		System.out.println(result);
		String expecttext="Login Successfully";
		String actualtext=loginsuccess.getText();
		Assert.assertEquals(expecttext,actualtext,"not matching");
}
	@Test
	public void Invalidlogin() throws InterruptedException
	   {
		driver.get("https://demo.guru99.com/V4/index.php ");
		WebElement uid=driver.findElement(By.xpath("//input[@name='uid']"));
		uid.sendKeys("vidhu");
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("Test");
		WebElement login=driver.findElement(By.xpath("//input[@name='btnLogin']"));
		login.click();
		String expecttext="User or Password is not valid";
		String actual=driver.switchTo().alert().getText();
		System.out.println(actual);
		driver.switchTo().alert().accept();
		Assert.assertEquals(actual,expecttext,"invalid login");
	   }
	
	@Test
	public void checkboxif() throws InterruptedException
	   {
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement selectAllButton=driver.findElement(By.id("button-two"));
        selectAllButton.click();
  
         Thread.sleep(3000);
         
         WebElement checkbox1=driver.findElement(By.id("check-box-one"));
          boolean select1= checkbox1.isSelected();
          Assert.assertTrue(select1);
         WebElement checkbox2=driver.findElement(By.id("check-box-two"));
         boolean select2=checkbox2.isSelected();
         Assert.assertTrue(select2);
         WebElement checkbox3=driver.findElement(By.id("check-box-three"));
         boolean select3=checkbox3.isSelected();
         Assert.assertTrue(select3);
         WebElement checkbox4=driver.findElement(By.id("check-box-four"));
         boolean select4= checkbox4.isSelected();
         Assert.assertTrue(select4);       
       	
 		
	   }
 		@AfterMethod
 		public void aftermethod()
 		{
 			driver.close();
 		}
}

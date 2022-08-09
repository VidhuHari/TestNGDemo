package testNGbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertasserteg {
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
	public void alerts() throws InterruptedException
	{
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		softassert =new SoftAssert();
		WebElement clickforjsalert=driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		clickforjsalert.click();
		Thread.sleep(2000);
		String actualtext=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(actualtext);
		String expttext="I am a JS Alert";
		softassert.assertEquals(actualtext, expttext,"error");
		
		WebElement clickforjsconfirm=driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		clickforjsconfirm.click();
		String actualtext1=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(actualtext1);
		String expttext1="I am a JS Confirm";
		softassert.assertEquals(actualtext1, expttext1,"error");
		softassert.assertAll();
}
	@Test
	public void checkboxverification() throws InterruptedException
	{
		 softassert=new SoftAssert();
		 driver.get(" https://selenium.obsqurazone.com/check-box-demo.php");
		 WebElement selectAllButton=driver.findElement(By.id("button-two"));
	        selectAllButton.click();
	         Thread.sleep(3000);
	         
	         WebElement checkbox1=driver.findElement(By.id("check-box-one"));
	         boolean select1= checkbox1.isSelected();
	         softassert.assertTrue(select1);
	         System.out.println("checkbox1:"+select1);
	         
	         WebElement checkbox2=driver.findElement(By.id("check-box-two"));
	         boolean select2=checkbox2.isSelected();
	         softassert.assertTrue(select2);
	         System.out.println("checkbox2:"+select2);
	         
	         WebElement checkbox3=driver.findElement(By.id("check-box-three"));
	         boolean select3=checkbox3.isSelected();
	         softassert.assertTrue(select3);
	         System.out.println("checkbox3:"+select3);
	         
	         WebElement checkbox4=driver.findElement(By.id("check-box-four"));
	         boolean select4= checkbox4.isSelected();
	         softassert.assertTrue(select4); 
	         System.out.println("checkbox4:"+select4);
	         softassert.assertAll();
	}
	}


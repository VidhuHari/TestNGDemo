package testNGbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	WebDriver driver;
	@BeforeMethod
	public void beforemethod()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void switchtoFrame()
	{
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		//driver.switchTo().frame(1);
		driver.switchTo().frame("frame-bottom");
		WebElement bottom=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
		System.out.println(bottom.getText());
		
	}
	@Test
	public void Switchtoframetop()
	{
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-right");
	    WebElement frameright=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
		System.out.println(frameright.getText());
	}
	@Test
	public void Switchtoframetopleft()
	{
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		WebElement frameleft=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
		System.out.println(frameleft.getText());

	}
	@Test
	public void Switchtoframetopmiddle()
	{
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		WebElement framemid=driver.findElement(By.id("content"));
		System.out.println(framemid.getText());
	}
	

	@AfterMethod
	public void aftertest()
	{
		driver.close();
	}
	}


package testNGbasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switchtowindoweg {
	WebDriver driver;
	@BeforeMethod
public void beforemethod()
{
		WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
}
	@Test
	public void exampleofswitchtonewwindow()
	{
		//driver.get("https://the-internet.herokuapp.com/windows");
		WebElement clickme=driver.findElement(By.xpath("//a[text()='Click Here']"));
		WebElement openwindow=driver.findElement(By.xpath("//div[@class='example']/h3"));
		String parentwindow=driver.getWindowHandle();
		
		System.out.println(parentwindow);
		System.out.println(openwindow.getText());
		clickme.click();
		//clickme.click();
		//clickme.click();
		Set<String> windows=driver.getWindowHandles();
		windows.size();
		System.out.println(windows.size());
		Iterator<String>Iterate=windows.iterator();
		while(Iterate.hasNext()) {
			
			String childWindow=Iterate.next();
			if(!parentwindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
				driver.close();
			}
		}
		WebElement newtext=driver.findElement(By.xpath("//h3[text()='New Window']"));	
		System.out.println(newtext);
		
	}
	@Test
	public void switchtowindow()
	{
		WebElement clickme=driver.findElement(By.xpath("//a[text()='Click Here']"));
		WebElement openwindow=driver.findElement(By.xpath("//div[@class='example']/h3"));
		String parentwindow=driver.getWindowHandle();
		
		System.out.println(parentwindow);
		System.out.println(openwindow.getText());
		clickme.click();
		Set<String> windows=driver.getWindowHandles();
		for(String w:windows)
		{
			if(parentwindow.equals(w))
			{
				driver.switchTo().window(w);
			}
		}
		WebElement newtext=driver.findElement(By.xpath("//h3[text()='New Window']"));	
		System.out.println(newtext);
	}
}
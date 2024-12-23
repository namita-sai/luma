package testBase;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import lumaPomDesign.createUserPage;

public class testBase 
{
	public static WebDriver driver;
	
	
	
	public static void initialization()
	{	 
		ArrayList<String> args=new ArrayList<String>();
		args.add("start-maximized");
		args.add("disable-notifications");
		args.add("disable-infobars");
		//args.add("headless");	

		
		 driver=new ChromeDriver();
		 WebDriverManager.chromedriver().setup();	 
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 
		 
		 
	}
	
	
	public static void quiteDriver()
	{
		driver.quit();
		
	}

	

}

package utilLuma;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import com.github.javafaker.Faker;

import testBase.testBase;

public class UtilAll  extends testBase 
{
	
	
	private static String email;
    
    static
    {
        generateEmail(); 
    }

   
    public static void generateEmail()
    {
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
    }

    
    public static String getEmail()
    {
        return email;
    }
	
	public void scrollDown(int val)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("scroll(0,"+val+")");
	}
	
	
	
	public void takeScreenShot(String name) 
	{
		
		String path=".//ScreenSHOT/"+name;
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des=new File(path+System.currentTimeMillis()+".png"	);		
		
		try 
		{
		FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	
}

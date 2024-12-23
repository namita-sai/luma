package lumaPomDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginLuma 
{
	//------------- Initializing --------------
		public loginLuma (WebDriver driver) 
		{
			PageFactory.initElements(driver,this);
		}
		
	//---------- declaration-------------------
		
	 @FindBy(xpath="//div[@class='panel header']//ul/li[@class='authorization-link']")
	 private WebElement signInBtn;
	 
	 @FindBy(xpath="//input[@id='email']")
	 private WebElement emailTxt;
	 
	 @FindBy(xpath="(//input[@id='pass'])[1]")
	 private WebElement paswrdTxt;
	 
	 @FindBy(xpath="(//form//button/span[text()='Sign In'])[1]")
	 private WebElement loginBtn;
	 
	 //------------ usage-----------------------
	 public void click_on_signIn_btn()
	 {
		 signInBtn.click();
	 }
	 
	 public void enter_email_for_login(String mailId)
	 {
		 emailTxt.sendKeys(mailId);
	 }
	 
	 public void enter_password_for_login(String pass)
	 {
		 paswrdTxt.sendKeys(pass);
	 }
	 
	 public void click_on_login_In_btn()
	 {
		 loginBtn.click();
	 }

}

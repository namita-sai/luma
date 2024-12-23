package lumaPomDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createUserPage
{
	//------------- Initializing --------------
	public createUserPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	//------------ Declaration ----------------
	@FindBy (xpath="//div[@class='panel header']//li/a[text()='Create an Account']")
	private WebElement createAcnt;
	
	@FindBy( xpath="//input[@id='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='email_address']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	 
	@FindBy(xpath="//input[@id='password-confirmation']")
	private WebElement confirmPass;
	
	@FindBy(xpath="//button/span[text()='Create an Account']")
	private WebElement clickButton;	
	
	@FindBy(xpath="//div[@class='panel header']//ul[@class='header links']//li/a")
	private WebElement logoutPanel;
	
	@FindBy(xpath="//div[@id='email_address-error']")
	private WebElement errorTxt;
	
	@FindBy(xpath="//header//ul/li[2]//button")
	private WebElement signOutdrop;
	
	@FindBy(xpath="//li[@class='customer-welcome active']//ul/li[3]")
	private WebElement signOut;
	
	@FindBy(xpath="//div[@id='password-error']")
	private WebElement passError;
	
	//--------------- Usage-------------
	
	
	public void click_On_Create_Acnt()
	{
		createAcnt.click();	
	}
	
	public void enter_fname(String fname)
	{
		firstName.sendKeys(fname);
	}
	public void enter_lastname(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	
	public void enter_email(String emai)
	{
		email.sendKeys(emai);		
	}
	
	public void enter_pass(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void enter_confirm_pass(String cpass)
	{		
		confirmPass.sendKeys(cpass);
	}
		
	
	public void click_on_create_acnt_btn()
	{
		clickButton.click();
	}
	
	public WebElement get_WebPoint_louOut_pannel()
	{
		  return logoutPanel;
	}
	
	public String get_error_email_msg()
	{
		return errorTxt.getText();
	}

	public void click_on_signOut_dropBox()
	{
		signOutdrop.click();
	}
	
	public void click_on_Sign_out_Account()
	{
		signOut.click();
	}
	public String get_Password_txt_error_msg()
	{
		return passError.getText();
		
	}

}

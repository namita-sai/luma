package stepdefination;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import lumaPomDesign.createUserPage;
import lumaPomDesign.loginLuma;
import testBase.testBase;
import utilLuma.UtilAll;

public class stepDefination extends testBase 
{
	
	public createUserPage luma;
	public testBase testB;
	public UtilAll util;
	public loginLuma login;
	
	public Logger logger;
	

	@Before
	public void startUp()
	{
		testBase.initialization();
		luma=new createUserPage(driver);
		login=new loginLuma(driver);
		
		util=new UtilAll();
		logger=Logger.getLogger("Luma Domain.");
		PropertyConfigurator.configure("Log4jfile.properties");
		
		logger.info("------------ ::  Execution Start  :: ------------");
		
	}
	
	@Given("the user is on the sign-up page")
	public void the_user_is_on_the_sign_up_page() throws InterruptedException
	{
	    driver.get("https://magento.softwaretestingboard.com/");
	    luma.click_On_Create_Acnt();
	    Thread.sleep(300);
	    
	    logger.info("the user is on the sign-up page :: Success");
	    
	    
	}

	@When("the user enters valid data: {string}, {string}, {string}, {string}")
	public void the_user_enters_valid_data(String fname, String lname, String pass, String cpass) throws InterruptedException 
	{
		driver.get(driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl());
		
		util.scrollDown(350);
		
		Thread.sleep(300);
		
		luma.enter_fname(fname);
		luma.enter_lastname(lname);
		
		luma.enter_email(UtilAll.getEmail());
		luma.enter_pass(pass);
		luma.enter_confirm_pass(cpass);
		
		util.takeScreenShot("ValidData");
		
		Thread.sleep(3000);
		   
		logger.info("the user enters valid data :: Success");
	}

	@When("clicks on the Create an Account button")
	public void clicks_on_the_create_an_account_button() throws InterruptedException
	{		
		luma.click_on_create_acnt_btn();		
		Thread.sleep(3000);		
		
		logger.info("clicks on the Create an Account button :: Success");
	}

	@Then("the user should be registered successfully and redirected to the dashboard")
	public void the_user_should_be_registered_successfully_and_redirected_to_the_dashboard() throws InterruptedException 
	{
		String actual = driver.getTitle();
		String expected="My Account";
		
		Assert.assertEquals(actual,expected);
		
		logger.info("Assertion passed...");
		
		luma.click_on_signOut_dropBox();
		luma.click_on_Sign_out_Account();
		
		Thread.sleep(3000);
		
		logger.info("the user should be registered successfully :: Success");
	}
	
	@When("the user navigates to the login page")
	public void the_user_navigates_to_the_login_page() 
	{
		driver.get("https://magento.softwaretestingboard.com/");		
		login.click_on_signIn_btn();
		
		logger.info("the user navigates to the login page :: Success");
	}

	@When("enters the valid credentials used for sign-up which is register now using email {string}")
	public void enters_the_valid_credentials_used_for_sign_up_which_is_register_now_using_email(String pass) throws InterruptedException 
	{
		driver.get(driver.getCurrentUrl());
		
		System.out.println(UtilAll.getEmail());
		login.enter_email_for_login(UtilAll.getEmail());
		login.enter_password_for_login(pass);
		
		util.takeScreenShot("LogInValid");
		Thread.sleep(3000);
		
		logger.info("enters the valid credentials used for sign-up :: Success");
	}

	@When("clicks on the Sign In button")
	public void clicks_on_the_sign_in_button() throws InterruptedException 
	{
		login.click_on_login_In_btn();
		Thread.sleep(300);
		
	
		
		logger.info("clicks on the Sign In button :: Success");
	}

	@Then("the user should be logged in successfully and redirected to the user dashboard")
	public void the_user_should_be_logged_in_successfully_and_redirected_to_the_user_dashboard() throws InterruptedException 
	{
		String expec="https://magento.softwaretestingboard.com/";
		Thread.sleep(300);
		
		String actual=driver.getCurrentUrl();		
		Assert.assertEquals(expec, actual);	
		
		logger.info("Assertion Passed...");
		
		logger.info("the user should be logged in successfully");
		
	}

	@When("the user enters an invalid email format and valid data for other fields: {string}, {string}, {string}, {string},{string}")
	public void the_user_enters_an_invalid_email_format_and_valid_data_for_other_fields(String fname, String lname, String email,String pass, String cpass) 
	{
		luma.enter_fname(fname);
		luma.enter_lastname(lname);
		
		util.scrollDown(350);
		
		luma.enter_email(email);
		luma.enter_pass(cpass);
		luma.enter_confirm_pass(cpass);	
		
		util.takeScreenShot("InvalidRegister");
		
		logger.info("the user enters an invalid email format :: Success");
	}

	@Then("an error message should be displayed for invalid email format")
	public void an_error_message_should_be_displayed_for_invalid_email_format() throws InterruptedException 
	{
		String expected="Please enter a valid email address (Ex: johndoe@domain.com).";
		
		String actual = luma.get_error_email_msg();	
		Thread.sleep(3000);
		
		Assert.assertEquals(expected, actual);
		
		logger.info("Assertion passed...");
		
		expected="Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";
		
		logger.info("an error message should be displayed :: Success");
	    
	}


	
	@After
	public void tearDown()
	{
		testBase.quiteDriver();
		
		logger.info("------------ ::  Done  :: ------------");
		
	}
	
}

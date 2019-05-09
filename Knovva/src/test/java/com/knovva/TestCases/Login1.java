package com.knovva.TestCases;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.knovva.utilities.Log;
import com.knovva.utilities.Utils;

public class Login1 extends TestBase_Knovva
{
	@BeforeSuite
	public void callSetup() {
		
		Login1.setUp();
	}
	
	
	@BeforeTest
	public void callBrowser() {
		
		Login1.browserLaunch();
	}

	
	@Test(enabled = true, 
    		description = "If email ID field is blank , given input for password field and then click on Signin button"
    		+ "|| Login button should not be enabled" )
    
    public void TC_L001() throws InterruptedException
    {	  	   
    	    	
    	Log.info("Login test case started !!!");
    	
    	extentlogger = extentreport.createTest("TC_L001");
		
    	extentlogger.info("Login_Test_Scenario===>: If email ID field is blank , given input for password field and then click on Signin button");
		
		extentlogger.info("Expected_Results===>:Login button should not be enabled");
    	    	
		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
		//clear the already enter value
		lg_password.clear();
		
		//Enter the password value
		lg_password.sendKeys(config.getProperty("password01"));  
		
		//Thread.sleep(2000);
		 wait = new WebDriverWait(driver,15);
		
		 //check the condition if sign button enable or not
		if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			//if signin button enable then click on the sign button
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
		}
		else
		{
			System.out.println("Login button is not enabled:");
		}
		driver.navigate().refresh();
		
     }
  
   
    @Test(enabled = false,
    		description = "If password ID field is blank, given input for email ID field and then click on signin button"
    				+ "|| Login button should not be enabled")
   
    public void TC_L002() throws InterruptedException
    {    	
    	extentlogger = extentreport.createTest("TC_L002");
    	
    	extentlogger.info("Login_Test_Scenario===>:If password ID field is blank, given input for email ID field and then click on signin button");
    	
    	extentlogger.info("Expected_Results===>:Login button should not be enabled");
    	
		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
		//clear the already enter value
		log_email.clear();
		
		//Enter the email 
		log_email.sendKeys(config.getProperty("email02"));
		
		Thread.sleep(2000);
		
		//check the condition if sign button enable or not
		if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			//Click on the sign button
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
		}
		else
		{
			System.out.println("Login button is not enabled:");
		}
    }
    
    
    @Test(enabled = false,
    		description = "In email ID text box, given email id @ is missing , password value given and click on signin button"
    				+ "|| Alert message should be given as Email ID is invalid, Please give a valid email ID with @ and domain name")
    
    public void TC_L003() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L003");
    	
    	extentlogger.info("Login_Test_Scenario===>:In email ID text box, given email id @ is missing , password value given and click on "
    			+ "signin button");
    	
    	extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid email ID with "
    			+ "@ and domain name.");
    			
		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
		log_email.clear();
		
		//Enter email id
		log_email.sendKeys(config.getProperty("email03"));
		
		//clear already enter value
		lg_password.clear();
		
		//Enter password
		lg_password.sendKeys(config.getProperty("password03"));
		
		//check the condition if sign button enable or not
		if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			//Click on the sign button
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			
			Thread.sleep(1000);
			
			//check the error message present or not
			if (isElementPresent(By.xpath(OR.getProperty("lgfalimsg_xpath")))) 
			{
                WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("lgfalimsg_xpath")));
				
                String lgfail_msg = lgfail_msg_ele.getText();
				
                //Print the error message
                System.out.println(lgfail_msg );
			}
		else
		{
			System.out.println("Please include @ in email ,@ is missing ");
		}
       }
		
       driver.navigate().refresh();
     } 
    
    
    @Test(enabled = false,
    		description = "In email ID text box, given email id domain information is missing after @ sign, password value given"
    				+ "and click on signin button || Alert message should be given as Email ID is invalid, Please give a valid "
    				+ "email ID with @ and domain name")
    
    public void TC_L004() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L004");
    	
    	extentlogger.info("Login_Test_Scenario===>:In email ID text box, given email id domain information is missing after @ sign, password "
    			+ "value given and click on signin button");
    	
    	extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid email ID with "
    			+ "@ and domain name. ");
    	
		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
		//clear already enter value if we have
		log_email.clear();
		
		//Enter the email
		log_email.sendKeys(config.getProperty("email04"));
		
		lg_password.clear();
		
		//Enter the password value
		lg_password.sendKeys(config.getProperty("password03"));
		
		Thread.sleep(1000);
		
		//check the condition if sign button enable or not
		if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			
			Thread.sleep(1000);
			
			if (isElementPresent(By.xpath(OR.getProperty("lgfalimsg_xpath")))) 
			{
                WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("lgfalimsg_xpath")));
				
                String lgfail_msg = lgfail_msg_ele.getText();
                
                System.out.println(lgfail_msg );
			}
		else
		{
			System.out.println("Login button is not enabled:");
		}
       }
		
		driver.navigate().refresh();
     } 
    
    
    @Test(enabled = false,
    		description="If the email Id value given as special character value other than @, dot and underscore symbol , with password "
    				+ "value and click on signin button || Alert message should be given as Email ID is invalid, Please give a valid "
    				+ "email ID with @ and domain name")
    
    public void TC_L005() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L005");
    	
    	extentlogger.info("Login_Test_Scenario===>:If the email Id value given as special character value other than @, dot and underscore "
    			+ "symbol , with password value and click on signin button");
    	
    	extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid email ID with "
    			+ "@ and domain name.");
    	
   		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
   		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
   		log_email.clear();
		
   		log_email.sendKeys(config.getProperty("email_L005"));
		
   		lg_password.clear();
		//Enter the password value
		
   		lg_password.sendKeys(config.getProperty("password03"));
		
   		Thread.sleep(2000);
		
   		//check the condition if sign button enable or not
		if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			
			Thread.sleep(2000);
			
			if (isElementPresent(By.xpath(OR.getProperty("lgfalimsg_xpath")))) 
			{
                WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("lgfalimsg_xpath")));
				
                String lgfail_msg = lgfail_msg_ele.getText().toString();
                
                System.out.println(lgfail_msg );
			}
		else
		{
			System.out.println("Alert message should be given as Email ID is invalid, Please give a valid email ID with @ and domain name.");
		}
       }
		
		driver.navigate().refresh();
     } 
    
    
    @Test(enabled = false,
    		description="If email ID value start with dot along with password value and click on signin button || Alert message should "
    				+ "be given as Email ID is invalid, Please give a valid email ID with @ and domain name")
    
    public void TC_L006() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L006");
    	
    	extentlogger.info("Login_Test_Scenario===>:If email ID value start with dot along with password value and click on signin button");
    	
    	extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid email ID with "
    			+ "@ and domain name.");    	
    	
		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
		log_email.clear();
		
		log_email.sendKeys(config.getProperty("email_L006"));
		
		lg_password.clear();
		
		lg_password.sendKeys(config.getProperty("password03"));
		
		Thread.sleep(2000);
		
		//check the condition if sign button enable or not
		if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			
			Thread.sleep(2000);
			
			//check the condition after clicking on sign btn error msg display or not 
			if (isElementPresent(By.xpath(OR.getProperty("lgfalimsg_xpath")))) 
			{
                WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("lgfalimsg_xpath")));
				
                String lgfail_msg = lgfail_msg_ele.getText();
                
                System.out.println(lgfail_msg );
			}
		else
		{
			System.out.println("Sign button is not enable, please enter valid mailid & password ");
		}
       }
		driver.navigate().refresh();
     } 
     
    
    @Test(enabled = false,
    		description="In email ID value kept only as number after @ symbol along with password value and click on signin button  || "
    				+ "Alert message should be given as Email ID is invalid, Please give a valid email ID with @ and domain name")
    
    public void TC_L007() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L007");
    	
    	extentlogger.info("Login_Test_Scenario===>:In email ID value kept only as number after @ symbol along with password value and click "
    			+ "on signin button");
    	
    	extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid email ID with "
    			+ "@ and domain name.");   	
    	
		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
		log_email.clear();
		
		log_email.sendKeys(config.getProperty("email_L007"));
		
		lg_password.clear();
		
		lg_password.sendKeys(config.getProperty("password03"));
		
		Thread.sleep(2000);
		
		if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			
			Thread.sleep(2000);
			
			if (isElementPresent(By.xpath(OR.getProperty("lgfalimsg_xpath")))) 
			{
                WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("lgfalimsg_xpath")));
				
                String lgfail_msg = lgfail_msg_ele.getText().toString();
                
                System.out.println(lgfail_msg );
			}
		else
		{
			System.out.println("Sign button is not enable, please enter valid mailid & password ");
		}
       }  
		driver.navigate().refresh();
     } 
    
   
    @Test(enabled = false,
    		description="In email ID value kept @ value twice along with the password value and click on the signin button || "
    				+ "Alert message should be given as Email ID is invalid, Please give a valid email ID with @ and domain name")
    
    public void TC_L008() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L008");
    	
    	extentlogger.info("Login_Test_Scenario===>:In email ID value kept @ value twice along with the password value and click on the signin "
    			+ "button");
    	
    	extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid email ID with "
    			+ "@ and domain name.");
    	   	
		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
		log_email.clear();
		
		log_email.sendKeys(config.getProperty("email_L008"));
		
		lg_password.clear();
		
		lg_password.sendKeys(config.getProperty("password03"));
		
		Thread.sleep(2000);
		
		if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			
			Thread.sleep(2000);
			
			if (isElementPresent(By.xpath(OR.getProperty("lgfalimsg_xpath")))) 
			{
                WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("lgfalimsg_xpath")));
				
                String lgfail_msg = lgfail_msg_ele.getText().toString();
                
                System.out.println(lgfail_msg );
			}
		else
		{
			System.out.println("Sign button is not enable, please enter valid mail format & password ");
		}
       }
		driver.navigate().refresh();
     } 

    
    @Test(enabled = false,
    		description="In email ID multiple dot value without any input in between as input along with password and click on signin "
    				+ "button || Alert message should be given as Email ID is invalid, Please give a valid email ID with @ and domain name")
    
    public void TC_L009() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L009");
    	
    	extentlogger.info("Login_Test_Scenario===>:In email ID multiple dot value without any input in between as input along with password "
    			+ "and click on signin button.");
    	
    	extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid email ID with "
    			+ "@ and domain name.");
    	
    	
		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
		log_email.clear();
		
		log_email.sendKeys(config.getProperty("email_L009"));
		
		lg_password.clear();
		
		lg_password.sendKeys(config.getProperty("password03"));
		
		if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			
			Thread.sleep(2000);
			
			if (isElementPresent(By.xpath(OR.getProperty("lgfalimsg_xpath")))) 
			{
                WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("lgfalimsg_xpath")));
				
                String lgfail_msg = lgfail_msg_ele.getText().toString();
                
                System.out.println(lgfail_msg );
			}
		else
		{
			System.out.println("Invalid mail format please include valid mail format");
		}
       }
		driver.navigate().refresh();
     } 
    
   
    @Test(enabled=false,
    		description="In email ID field , in case any unicode character value as address used along with password value and click on "
    				+ "sign in button || Alert message should be given as Email ID is invalid, Please give a valid email ID with @ "
    				+ "and domain name")
    
    public void TC_L010() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L010");
    	
    	extentlogger.info("Login_Test_Scenario===>:In email ID field , in case any unicode character value as address used along with password "
    			+ "value and click on sign in button");
    	
    	extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid email ID with "
    			+ "@ and domain name.");
    	    	
		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
		log_email.clear();
		
		log_email.sendKeys(config.getProperty("email_L010"));
		
		lg_password.clear();
		
		lg_password.sendKeys(config.getProperty("password03"));
		
		if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			Thread.sleep(2000);
			if (isElementPresent(By.xpath(OR.getProperty("lgfalimsg_xpath")))) 
			{
                WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("lgfalimsg_xpath")));
				String lgfail_msg = lgfail_msg_ele.getText().toString();
                System.out.println(lgfail_msg );
			}
		else
		{
			System.out.println("Please include an @ in the email id field ,Missing @ in email");
		}
       }  
		driver.navigate().refresh();
     } 
    
   
    @Test(enabled=false,
    		description="If the email ID value used is not been activated and along with password value and click on sign in button"
    				+ "|| Alert message should be given that user is not activated")
    public void TC_L011() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L011");
    	
    	extentlogger.info("Login_Test_Scenario===>:If the email ID value used is not been activated and along with password value and click "
    			+ "on sign in button");
    	
    	extentlogger.info("Expected_Results===>:Alert message should be given that user is not activated");
    	
    	WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
    	WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
    	log_email.clear();
		
    	log_email.sendKeys("automation@yopmail.com");
		
    	lg_password.clear();
		
    	lg_password.sendKeys(config.getProperty("password03"));
		
    	Thread.sleep(2000);
		
    	if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			
			Thread.sleep(2000);
			
			if (isElementPresent(By.xpath(OR.getProperty("lfmsgMNActive_xpath")))) 
			{
                WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("lfmsgMNActive_xpath")));
				
                String lgfail_msg = lgfail_msg_ele.getText().toString();
                
                System.out.println(lgfail_msg );
			}
		else
		{
			System.out.println("Active User Loged in successfully.");
		}
       } 
		driver.navigate().refresh();
     } 
    
      
    @Test(enabled=false,
    		description="If the password value length is more than what had been set in the registration page || User should not be "
    				+ "allowed to enter more than length character set in the registration page")
    
    public void TC_L013() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L013");
    	
    	extentlogger.info("Login_Test_Scenario===>:If the password value length is more than what had been set in the registration page");
    	
    	extentlogger.info("Expected_Results===>:User should not be allowed to enter more than length character set in the registration page.");
    	    	
		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
		log_email.clear();
		
		log_email.sendKeys(config.getProperty("Email"));
		
		lg_password.clear();
		
		lg_password.sendKeys(config.getProperty("password_L013"));
		
		Thread.sleep(2000);
		
		if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			
			Thread.sleep(2000);
			
			if (isElementPresent(By.xpath(OR.getProperty("lgfalimsg_xpath")))) 
			{
                WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("lgfalimsg_xpath")));
				
                String lgfail_msg = lgfail_msg_ele.getText();
                
                System.out.println("Login fails message is display==>:"+lgfail_msg);
			}
		else
		{
			System.out.println("Sign in button is not enable,please enter valid format data");
		}
       }  
		driver.navigate().refresh();
     } 
    
    
    @Test(enabled=false,
    		description="User clicks on Forgot Password Link || User should be redirected to the Forgot Password page")
    
    public void TC_L014() throws InterruptedException 
    {
    	extentlogger = extentreport.createTest("TC_L014");
    	
    	extentlogger.info("Login_Test_Scenario===>:User clicks on �Forgot Password?� link");
    	
    	extentlogger.info("Expected_Results===>:User should be redirected to the Forgot Password page");
    	
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();
		
		Thread.sleep(1000);
		
		String Url=driver.getCurrentUrl();
		
		Thread.sleep(1000);
		
		System.out.println("Forgot password page URL is ===>:" +Url);	
		
		driver.navigate().back();
     } 
    
    // .
    @Test(enabled=false,
    		description="User clicks on �Resend verification email link || User should be redirected to the respective resend "
    				+ "verification email page")
    
    public void TC_L015() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L015");
    	
    	extentlogger.info("Login_Test_Scenario===>:User clicks on �Resend verification email� link");
    	
    	extentlogger.info("Expected_Results===>:User should be redirected to the respective resend verification email page.");
    	
    	//click on the forgot password link
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();
		
		String Url=driver.getCurrentUrl();
			
		WebElement email_field= driver.findElement(By.id(OR.getProperty("forgot_email_id")));
		
		email_field.clear();
		
		email_field.sendKeys(config.getProperty("Email"));
		
		Thread.sleep(2000);
		
		if (driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath"))).isEnabled())
		{
			WebElement forgot_pwd_btn = driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath")));
			
			forgot_pwd_btn.click();
			
			Thread.sleep(1000);
			
			if (isElementPresent(By.xpath(OR.getProperty("email_not_regis_xpath")))) {

				WebElement error_msg = driver.findElement(By.xpath(OR.getProperty("email_not_regis_xpath")));
				
				String error_msg_txt = error_msg.getText();
				
				System.out.println(error_msg_txt);				
			}
			else
			{
				System.out.println("Successfully navigate to the new password page and url is===>:" +Url);
			}		
		}
		driver.navigate().back();
     } 
    
    
    @Test(enabled=false,
    		description="User clicks on 'Create Account!' link || User should be redirected to the user registration page")
    
    public void TC_L016() throws InterruptedException
    {	
    	extentlogger = extentreport.createTest("TC_L016");
    	
    	extentlogger.info("Login_Test_Scenario===>:User clicks on 'Create Account!' link");
    	
    	extentlogger.info("Expected_Results===>:User should be redirected to the user registration page");
    	    	
		driver.findElement(By.xpath(OR.getProperty("CreateAccnt_btn_xpath"))).click();
		
		Thread.sleep(1000);
		
		String Url=driver.getCurrentUrl();
		
		WebElement Wlc_msg =driver.findElement(By.xpath(OR.getProperty("reg_header_xpath")));
		
		String wlc_msg_txt=Wlc_msg.getText();
		
		System.out.println(wlc_msg_txt + "," +"sign up page URL is===>:" +Url);
		
		driver.navigate().back();
     } 
    
    //
    @Test(enabled=false,
    		description="If both email ID and Password field kept as blank and user clicks on the login in button || Alert message "
    				+ "should be given as Email ID and Password field can not be empty")
    
    public void TC_L017() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L017");
    	
    	extentlogger.info("Login_Test_Scenario===>:If both email ID and Password field kept as blank and user clicks on the login in button");
    	
    	extentlogger.info("Expected_Results===>:Alert message should be given as Email ID and Password field can not be empty");
    	
    	Thread.sleep(1000);
		
    	WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
    	WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
    	log_email.clear();
		
    	log_email.sendKeys("");
		
    	lg_password.clear();
		
    	lg_password.sendKeys("");	
		
    	Thread.sleep(1000);
		
    	if (driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).isEnabled())
		{
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			
			Thread.sleep(2000);
			
			if (isElementPresent(By.xpath(OR.getProperty("lgfalimsg_xpath")))) 
			{
                WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("lgfalimsg_xpath")));
				
                String lgfail_msg = lgfail_msg_ele.getText();
                
                System.out.println(lgfail_msg );
			}
		else
		{
			System.out.println("Signin button is not enable because you have not enter Email ID and Password value");
		}
       }
       driver.navigate().refresh();
     } 
    
    
    @Test(enabled=false,
    		description="Check whether the placeholder value showing for both Email and Password field or not || It should show")
    
    public void TC_L018() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L018");
    	
    	extentlogger.info("Login_Test_Scenario===>:Check whether the placeholder value showing for both Email and Password field or not");
    	    	
		String lg_placeholder_txt = driver.findElement(By.xpath(OR.getProperty("lg_Email_placehold_xpath"))).getAttribute("placeholder");
		
		String lg_Pass_placehold_txt = driver.findElement(By.xpath(OR.getProperty("lg_Pass_placehold_xpath"))).getAttribute("placeholder");
		
		Thread.sleep(2000);
		
		System.out.println("Email field placeholder value is ==>:" +lg_placeholder_txt);
		
		System.out.println("Password field placeholder value is ==>:" +lg_Pass_placehold_txt);
			       		
     }
    
    
    @Test(enabled=false,
    		description="Check that after the successfull login what is the URL displaying || After successfull login URL can not be "
    				+ "same like before login i.e. https://online.knovva.com/login")
    
    public void TC_L019() throws InterruptedException
    {
    	extentlogger = extentreport.createTest("TC_L019");
    	
    	extentlogger.info("Login_Test_Scenario===>:Check that after the successfull login what is the URL displaying");
    	
    	extentlogger.info("Expected_Results===>:After successfull login URL can not be same like before login "
    			+ "i.e. https://online.knovva.com/login");
    	
		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
		log_email.clear();
		
		//Enter correct mail id
		log_email.sendKeys(config.getProperty("Email"));
		
		lg_password.clear();
		
		//Enter correct password
		lg_password.sendKeys(config.getProperty("Password"));
		
		//click on the sign in button
		driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
		
		Thread.sleep(2000);
		
		String Url=driver.getCurrentUrl();
		
		Assert.assertEquals("https://test.knovva.com/dashboard", Url);
		
		Thread.sleep(2000);
		
		System.out.println("**After successfull login current page URL is**===>:" + Url);
				
		//click on the HamMenue
		TestBase_Knovva.ClickOnHamburgerMenu();
		    
	    //Click on the LogOut Btn
		TestBase_Knovva.ClickOnLogoutBtn();
		   	
     }
    
    
    @Test(enabled=true,
    		description="Check Sign in with google working or not || After Successful Gmail login it should login to the knovaa "
    				+ "application page as per the requirement")
    
    public void TC_L020() throws InterruptedException 
    {   
    	extentlogger = extentreport.createTest("TC_L020");
    	
    	extentlogger.info("Login_Test_Scenario===>:Check Sign in with google working or not");
    	
    	extentlogger.info("Expected_Results===>:After Successful Gmail login it should login to the knovaa application page as per the "
    			+ "requirement");
    	
    	Thread.sleep(1000);
    	
    	WebElement SignWithGoogle = driver.findElement(By.xpath(OR.getProperty("lg_google_btn_xpath")));
    	
    	SignWithGoogle.click();
    	
    	String MainWindow=driver.getWindowHandle();
    		   	
    	ArrayList<String> childWindow = new ArrayList<String> (driver.getWindowHandles());        	
    	
    	childWindow.remove(MainWindow);
    	
    	driver.switchTo().window(childWindow.get(1));
    	
    	Thread.sleep(1000);
    	
    	String s1=driver.getCurrentUrl();
    	
    	String s="https://test.knovva.com/dashboard";
    	
    	System.out.println("****"+s1);
    	  	
    	 if(s1.equals(s))
        	{
    		 
    		 System.out.println("**Successfully Login if user already sign in with gmail account***");
    		 
        	}
    	  else
    	     {
            
                Thread.sleep(1000);
        	    
                WebElement EnterEmail = driver.findElement(By.xpath(OR.getProperty("google_email_xpath")));
        	    
                //Enter google Gmail id
          	    EnterEmail.sendKeys(config.getProperty("GmailUserName_L020"));
          	    
          	    Thread.sleep(1000);
          	    
          	    //click on the nextBtn
            	WebElement ClickOnNextBtn = driver.findElement(By.xpath(OR.getProperty("google_nextBtn_xpath")));
            	
            	ClickOnNextBtn.click();
            	
            	Thread.sleep(3000);
            	
            	WebElement EnterPassword = driver.findElement(By.xpath(OR.getProperty("google_password_xpath")));
            	
            	EnterPassword.sendKeys(config.getProperty("GPass_L020"));
            	
            	Thread.sleep(3000);
            	
            	//click on the nextBtn
            	WebElement ClickOnNextBtn2 = driver.findElement(By.xpath(OR.getProperty("google_nextBtn_xpath")));
            	
            	ClickOnNextBtn2.click();  
            	
            	Thread.sleep(3000);             	 
    	     }   	 
    	 
    	driver.switchTo().window(MainWindow);
    	 
    	Thread.sleep(5000);
      	 
    	String s2=driver.getCurrentUrl();
    	 
    	Assert.assertEquals(s2, s);    	
    	    	
    	Thread.sleep(2000);
    	
    	String title=driver.getTitle();
		
    	System.out.println("**click on the login with google button it is login Successfully to the knovaa application and after login "
    			+ "title is**===>:" +title );
		
    	Log.info("Login module test case Ended !!!");	       		
      }
    
    
	@AfterMethod
	   public void getMethodsUpdates(ITestResult result) throws IOException 
	   {
	 	  if(result.getStatus()==ITestResult.FAILURE) 
	 	  {
	 		  String temp=Utils.getScreenshot(driver);
	 		  //extentlogger.fail("Test Fialed "+result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	 		 extentlogger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	 	  }
	 	  else if(result.getStatus()==ITestResult.SUCCESS)
	 	  {
	 		 // String status="Pass";
	 		// extentlogger.pass(result.getName() +"==>"+status);
	 	  }
	 	  
	 	  else if(result.getStatus()==ITestResult.SKIP)
	 	  {
	 		 log.info("Test skipped " + result.getThrowable());
	 		extentlogger.skip(result.getThrowable().getMessage());	 		 
	 	  }
	 	  
	     }
    
    
    @AfterTest
    public void callTearDown() {
    	
    	Login1.tearDown();
    }
    
    
    @AfterSuite
    public void storeReport() {
    	Login1.captureReport();
    }
    
    
   }

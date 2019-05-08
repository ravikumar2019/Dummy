package com.knovva.TestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import com.knovva.utilities.Log;

public class ForgotPassword extends TestBase_Knovva {
	
	@BeforeSuite
	public void callSetup() {
		
		ForgotPassword.setUp();
	}
	
	
	@BeforeTest
	public void callBrowser() {
		
		ForgotPassword.browserLaunch();
	}
	
		
	@Test(enabled = true,
			description = "Check if the input email ID is valid and user is not activated after registration || An alert message should "
					+ "be shown that the Please activate the user")
	
	public void TC_FP001() throws InterruptedException
	{		
		Log.info("ForgotPassword test case started !!!");
    	
    	extentlogger = extentreport.createTest("TC_FP001");
		
    	extentlogger.info("ForgotPassword_Test_Scenario===>: Check if the input email ID is valid and user is not activated after registration");
		
		extentlogger.info("Expected_Results===>: An alert message should be shown that the Please activate the user");
		
		Log.info("ForgotPassword module test case Started !!!");
		
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();		
		
		WebElement forgot_email = driver.findElement(By.id(OR.getProperty("forgot_email_id")));
		
		forgot_email.sendKeys(config.getProperty("Email_FP001"));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath"))).click();
		
		Thread.sleep(1000);
		
		if (isElementPresent(By.xpath(OR.getProperty("wrong_email_xpath")))) 
		{
            WebElement rgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("wrong_email_xpath")));
			
            String rgfail_msg = rgfail_msg_ele.getText();
            
            System.out.println(rgfail_msg );
		}
	    else 
	      {
	    	WebElement for_new_txt=driver.findElement(By.xpath(OR.getProperty("forPas_Npas_txt_xpath")));
	    	
	    	String newPass_txt=for_new_txt.getText();
	        
	    	System.out.println("input email ID is valid and user is not activated , New Password text is ===>:"+newPass_txt);    	
  	      }	
		
     	}
	
	
	 @Test(enabled = false,
			 description = "Check if the input email ID is valid and user is not activated after registration || Following fields should "
			 		+ "not be shown to user: Email, New Password, Verification Code")
	 
	 public void TC_FP003() throws InterruptedException
	 {		
		extentlogger = extentreport.createTest("TC_FP003");
			
	    extentlogger.info("ForgotPassword_Test_Scenario===>: Check if the input email ID is valid and user is not activated after registration");
			
		extentlogger.info("Expected_Results===>: Following fields should not be shown to user: Email, New Password, Verification Code");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();
		
		WebElement forgot_email = driver.findElement(By.id(OR.getProperty("forgot_email_id")));
		
		Thread.sleep(1000);
		
		forgot_email.sendKeys(config.getProperty("Email_FP003"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath"))).click();		
		
		Thread.sleep(1000);
		
		if (isElementPresent(By.xpath(OR.getProperty("wrong_email_xpath")))) 
	      {
            WebElement rgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("wrong_email_xpath")));
			
            String rgfail_msg = rgfail_msg_ele.getText().toString();
            
            System.out.println(rgfail_msg );
		   }
		
	    else
	    	
	      {
	    	Thread.sleep(1000);
	    	
	    	//Get all value in form and display
	    	List<WebElement> List=driver.findElements(By.xpath(OR.getProperty("Forgot_pass_list_xpath")));
	    	
	    	System.out.println("***Below details is display***");
	    	
	    	for(WebElement option:List)
	    	{
	    		System.out.println(option.getAttribute("innerText"));
	    	}	    		    	   	
  	      }	
		
     	}
	
	
	
	@Test(enabled = false,
			description = "Check if the input email ID is valid and user is also activated after registration || A confirmation message "
					+ "should be displayed that the verification email sent to the user")
	
	public void TC_FP008() throws InterruptedException
	{		
		extentlogger = extentreport.createTest("TC_FP008");
		
    	extentlogger.info("ForgotPassword_Test_Scenario===>: Check if the input email ID is valid and user is also activated after registration");
		
		extentlogger.info("Expected_Results===>: A confirmation message should be displayed that the verification email sent to the user");
		
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();	
		
		WebElement forgot_email = driver.findElement(By.id(OR.getProperty("forgot_email_id")));
		
		forgot_email.sendKeys(config.getProperty("Email_FP008"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath"))).click();
		
		Thread.sleep(1000);
		
		if (isElementPresent(By.xpath(OR.getProperty("wrong_email_xpath")))) 
		{
            WebElement rgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("wrong_email_xpath")));
			
            String rgfail_msg = rgfail_msg_ele.getText();
            
            System.out.println(rgfail_msg );
		}
	    else 
	      {
	        WebElement errorsmg_txt = driver.findElement(By.xpath(OR.getProperty("forpass_err_msgtxt_xpath")));
	        
	        String errtxt=errorsmg_txt.getText().toString();
	        
	        System.out.println("**Error message is display**===>" +errtxt);    	
  	      }	
		
     	}
	
	@Test(enabled = false,
			description = "Check if the input email ID is valid and user is also activated after registration || Following fields should be "
					+ "shown to user: Email, New Password, Verification Code")
	
	public void TC_FP009() throws InterruptedException
	{
		extentlogger = extentreport.createTest("TC_FP009");
		
    	extentlogger.info("ForgotPassword_Test_Scenario===>: Check if the input email ID is valid and user is also activated after registration");
		
		extentlogger.info("Expected_Results===>: Following fields should be shown to user: Email, New Password, Verification Code");
		
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();
		
		WebElement forgot_email = driver.findElement(By.id(OR.getProperty("forgot_email_id")));
		
		forgot_email.sendKeys(config.getProperty("Email_FP008"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath"))).click();
		
		if (isElementPresent(By.xpath(OR.getProperty("wrong_email_xpath")))) 
		{
            WebElement rgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("wrong_email_xpath")));
			
            String rgfail_msg = rgfail_msg_ele.getText().toString();
            
            System.out.println(rgfail_msg );
		}
	    else 
	      {
	    	WebElement email_new_txt=driver.findElement(By.xpath(OR.getProperty("forPas_mail_txt_xpath")));
	    	
	    	WebElement for_new_txt=driver.findElement(By.xpath(OR.getProperty("forPas_Npas_txt_xpath")));
	    	
	    	WebElement for_variCode_txt=driver.findElement(By.xpath(OR.getProperty("forPas_vcode_txt_xpath")));
	    	
	    	String email_txt=email_new_txt.getText();
	    	
	    	String newPass_txt=for_new_txt.getText();
	    	
	    	String varicode_txt=for_variCode_txt.getText();
	        
	    	System.out.println("Below fields should be shown to user :\n" +email_txt+  "\n " + newPass_txt + "\n "  +varicode_txt );    	
  	      }	
		
     	}
	
	
	@Test(enabled = false,
			description = "Check if the input email ID is valid and user is also activated after registration || Email field should be "
					+ "disabled so that user couldn't able to modify that")
	
	public void TC_FP010() throws InterruptedException
	{
		extentlogger = extentreport.createTest("TC_FP010");
		
    	extentlogger.info("ForgotPassword_Test_Scenario===>: Check if the input email ID is valid and user is also activated after registration");
		
		extentlogger.info("Expected_Results===>: Email field should be disabled so that user couldn't able to modify that");
		
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();
		
		WebElement forgot_email = driver.findElement(By.id(OR.getProperty("forgot_email_id")));
		
		forgot_email.sendKeys(config.getProperty("Email_FP008"));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath"))).click();
		
		if (isElementPresent(By.xpath(OR.getProperty("wrong_email_xpath")))) 
		{
            WebElement rgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("wrong_email_xpath")));
			
            String rgfail_msg = rgfail_msg_ele.getText().toString();
            
            System.out.println(rgfail_msg );
		}
	    else 
	      {
	    	WebElement email_new_txt=driver.findElement(By.xpath(OR.getProperty("forpass_email_co_txt_xpath")));
	    	
	    	email_new_txt.clear();
	    	
	    	email_new_txt.sendKeys("ravi@cbnits.com");
	    	
	    	Thread.sleep(1000);
	    	
	        System.out.println("***User is able to modify email field:**");    	
  	      }	
		
     	}
	
	
	@Test(enabled = false,
			description = "Check if the input email ID is valid and user is also activated after registration || It should not be allowed "
					+ "to save new password value entered is not having lower case characters")
	
	public void TC_FP011() throws InterruptedException
	{
		extentlogger = extentreport.createTest("TC_FP011");
		
    	extentlogger.info("ForgotPassword_Test_Scenario===>: Check if the input email ID is valid and user is also activated after registration");
		
		extentlogger.info("Expected_Results===>: It should not be allowed to save new password value entered is not having lower case "
				+ "characters");
		
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();
		
		WebElement forgot_email = driver.findElement(By.id(OR.getProperty("forgot_email_id")));
		
		forgot_email.sendKeys(config.getProperty("Email_FP008"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath"))).click();
		
		if (isElementPresent(By.xpath(OR.getProperty("wrong_email_xpath")))) 
		{
            WebElement rgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("wrong_email_xpath")));
			
            String rgfail_msg = rgfail_msg_ele.getText();
            
            System.out.println(rgfail_msg );
		}
	    else 
	      {
	    	WebElement newPass=driver.findElement(By.xpath(OR.getProperty("ForP_n_p_xpath")));
	    	
	    	newPass.clear();
	    	
	    	newPass.sendKeys("123@123");
	    	
	    	Thread.sleep(1000);
	    	
	        System.out.println("***Submit button is not enable, Because new password value entered is not having lower case characters**");    	
  	      }	
		
     	}
	
	
	@Test(enabled = false,
			description = "Check if the input email ID is valid and user is also activated after registration || It should not be allowed "
					+ "to save new password value entered is not having a number character")
	
	public void TC_FP012() throws InterruptedException
	{
		extentlogger = extentreport.createTest("TC_FP012");
		
    	extentlogger.info("ForgotPassword_Test_Scenario===>: Check if the input email ID is valid and user is also activated after registration");
		
		extentlogger.info("Expected_Results===>: It should not be allowed to save new password value entered is not having a number "
				+ "character");
		
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();
		
		WebElement forgot_email = driver.findElement(By.id(OR.getProperty("forgot_email_id")));
		
		forgot_email.sendKeys(config.getProperty("Email_FP008"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath"))).click();
		
		if (isElementPresent(By.xpath(OR.getProperty("wrong_email_xpath")))) 
		{
            WebElement rgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("wrong_email_xpath")));
			
            String rgfail_msg = rgfail_msg_ele.getText().toString();
            
            System.out.println(rgfail_msg );
		}
	    else 
	      {
	    	WebElement newPass=driver.findElement(By.xpath(OR.getProperty("ForP_n_p_xpath")));
	    	
	    	newPass.clear();
	    	
	    	newPass.sendKeys("ravi@ravi");
	    	
	    	Thread.sleep(2000);
	    	
	        System.out.println("Submit button is not enable, Because new password value entered is not having a number character ");    	
  	      }	
		
     	}
	
	
	@Test(enabled = false,
			description = "Check if the input email ID is valid and user is also activated after registration || It should not be allowed "
					+ "to save new password value entered is less than 6 character")
	
	public void TC_FP013() throws InterruptedException
	{
		extentlogger = extentreport.createTest("TC_FP013");
		
    	extentlogger.info("ForgotPassword_Test_Scenario===>: Check if the input email ID is valid and user is also activated after registration");
		
		extentlogger.info("Expected_Results===>: It should not be allowed to save new password value entered is less than 6 character");
		
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();
		
		WebElement forgot_email = driver.findElement(By.id(OR.getProperty("forgot_email_id")));
		
		forgot_email.sendKeys(config.getProperty("Email_FP008"));
        
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath"))).click();
		
		if (isElementPresent(By.xpath(OR.getProperty("wrong_email_xpath")))) 
		{
            WebElement rgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("wrong_email_xpath")));
			
            String rgfail_msg = rgfail_msg_ele.getText().toString();
            
            System.out.println(rgfail_msg );
		}
	    else 
	      {
	    	WebElement newPass=driver.findElement(By.xpath(OR.getProperty("ForP_n_p_xpath")));
	    	
	    	newPass.clear();
	    	
	    	newPass.sendKeys("RV@1");
	    	
	    	Thread.sleep(2000);
	    	
	        System.out.println("Submit button is not enable, Because new password value entered is less than 6 character ");    	
  	      }	
		
     	}
	
	
	@Test(enabled = false,
			description = "Check if the input email ID is valid and activated then whether old used password values are accepted and saved "
					+ "as input or not || For change password for an existing valid user old used password values should not be accepted.")
	
	public void TC_FP014() throws InterruptedException
	{
		extentlogger = extentreport.createTest("TC_FP014");
		
    	extentlogger.info("ForgotPassword_Test_Scenario===>: Check if the input email ID is valid and activated then whether old used password values "
    			+ "are accepted and saved as input or not");
		
		extentlogger.info("Expected_Results===>: For change password for an existing valid user old used password values should not be "
				+ "accepted");
		
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();
		
		WebElement forgot_email = driver.findElement(By.id(OR.getProperty("forgot_email_id")));
		
		forgot_email.sendKeys(config.getProperty("Email_FP003"));
		
		driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath"))).click();
		
		Thread.sleep(1000);
		
		if (isElementPresent(By.xpath(OR.getProperty("wrong_email_xpath")))) 
		{
            WebElement rgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("wrong_email_xpath")));
			
            String rgfail_msg = rgfail_msg_ele.getText().toString();
            
            System.out.println(rgfail_msg );
		}
	    else 
	      {
	    	WebElement newPass=driver.findElement(By.xpath(OR.getProperty("ForP_n_p_xpath")));
	    	
	    	newPass.clear();
	    	
	    	//USING Current ACTIVE password
	    	newPass.sendKeys("ravi@123");
	    	
	    	Thread.sleep(2000);
	    	
	        System.out.println("***Submit button is enable, and old used password values is accepted**");    	
  	      }	
		
     	}
      
	 
	@Test(enabled = false,
			description = "Check if the input email ID is valid and activated then what happens if user gives wrong activation "
					+ "code || An alert message should be given like \" Please give correct activation code")
	
	public void TC_FP015() throws InterruptedException
	{
		extentlogger = extentreport.createTest("TC_FP015");
		
    	extentlogger.info("Test_Scenario===>: Check if the input email ID is valid and activated then what happens if user gives wrong "
    			+ "activation code");
		
		extentlogger.info("Expected_Results===>: An alert message should be given like Please give correct activation code");
		
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();
		
		WebElement forgot_email = driver.findElement(By.id(OR.getProperty("forgot_email_id")));
		
		forgot_email.sendKeys(config.getProperty("Email_FP003"));
		
		driver.findElement(By.xpath(OR.getProperty("Forgot_pass_send_xpath"))).click();
		
		Thread.sleep(2000);
		
		if (isElementPresent(By.xpath(OR.getProperty("wrong_email_xpath")))) 
		{
            WebElement rgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("wrong_email_xpath")));
			
            String rgfail_msg = rgfail_msg_ele.getText().toString();
            
            System.out.println(rgfail_msg );
		}
	    else 
	      {
	    	WebElement newPass=driver.findElement(By.xpath(OR.getProperty("ForP_n_p_xpath")));
	    	
	    	newPass.clear();
	    	
	    	//USING Current ACTIVE password
	    	newPass.sendKeys("ravi@123");
	    	
	    	WebElement vari_code_txtbox =driver.findElement(By.xpath(OR.getProperty("forP_Vari_co_tbox_xpath")));
	    	
	    	//Giving wrong verification code
	    	vari_code_txtbox.sendKeys("RV123");
	    	
	    	WebElement submit_btntxtbox =driver.findElement(By.xpath(OR.getProperty("forP_N_pass_sub_btn_xpath")));
	    	
	    	submit_btntxtbox.click();
	    	
	    	Thread.sleep(2000);
	    	if (isElementPresent(By.xpath(OR.getProperty("for_invalid_v_code_errortxt_xpath")))) 
			{
	            WebElement invalid_varicode_msg_ele = driver.findElement(By.xpath(OR.getProperty("for_invalid_v_code_errortxt_xpath")));
				
	            String pass_chngfail_msg = invalid_varicode_msg_ele.getText();
	            
	            System.out.println("**Alert message is display**===>:"+pass_chngfail_msg );
			}	    	
	    	  	
  	      }		
		
     	}
	
     
	@Test(enabled = false,
			description = "Check that forgot password page URL || Forgot password page URL shouldn't have text login")
	
	public void TC_FP016() throws InterruptedException
	{
		extentlogger = extentreport.createTest("TC_FP016");
		
    	extentlogger.info("Test_Scenario===>: Check that forgot password page URL");
		
		extentlogger.info("Expected_Results===>: Forgot password page URL shouldn't have text login");
		
		Log.info("ForgotPassword module test case Ended !!!");
		
		driver.findElement(By.xpath(OR.getProperty("forgot_p_link_xpath"))).click();		
		
		String Forg_current_url=driver.getCurrentUrl();
		
		Thread.sleep(2000);
        
		Assert.assertEquals("https://test.knovva.com/forgotpassword/", Forg_current_url);
        
		Thread.sleep(2000);
	    
		System.out.println("Forgot password currnet page URL is===>:"  +Forg_current_url);    
	    
		driver.navigate().refresh();
	    
		driver.navigate().back();
		
		Log.info("ForgotPassword module test case Ended !!!");
     } 
	
	
	@AfterTest
    public void callTearDown() {
    	
		ForgotPassword.tearDown();
    }
    
    
    @AfterSuite
    public void storeReport() {
    	ForgotPassword.captureReport();
    }
}

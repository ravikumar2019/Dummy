package com.knovva.TestCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.knovva.utilities.Log;
import com.knovva.utilities.Utils;

public class CreateAccount extends TestBase_Knovva  
  {		
	
	@BeforeSuite
	public void callSetup() {
		
		CreateAccount.setUp();
	}
	
	@BeforeTest
	public void callBrowser() {
		
		CreateAccount.browserLaunch();
	}

	
	@Test(enabled = true,
			description = "Check whether the placeholder value showing correct or not || Below Placeholder value should be present\n" + 
					" \n" + 
					" 1) First Name\n" + 
					" 2) Lastname\n" + 
					" 3) Email\n" + 
					" 4) Password\n" + 
					" 5) Confirm Password\n" + 
					" 6) Optional Class Code")
    
	public void TC_R002() throws InterruptedException
    {
		Log.info("CreateAccount test case started !!!");
    	
    	extentlogger = extentreport.createTest("TC_R002");
		
    	extentlogger.info("CreateAccount_Test_Scenario===>: Check whether the placeholder value showing correct or not");
		
		extentlogger.info("Expected_Results===>:Below Placeholder value should be present\n" + 
				" \n" + 
				" 1) First Name\n" + 
				" 2) Lastname\n" + 
				" 3) Email\n" + 
				" 4) Password\n" + 
				" 5) Confirm Password\n" + 
				" 6) Optional Class Code");
		
		
		driver.findElement(By.xpath(OR.getProperty("CreateAccnt_btn_xpath"))).click();
		
		Thread.sleep(1000);
		
		String F_N_plholder_txt = driver.findElement(By.id(OR.getProperty("regi_fname_id"))).getAttribute("placeholder");
		
		String L_N_plholder_txt = driver.findElement(By.id(OR.getProperty("regi_lname_id"))).getAttribute("placeholder");
		
		String Email_plholder_txt = driver.findElement(By.id(OR.getProperty("regi_email_id"))).getAttribute("placeholder");
		
		String Pass_plholder_txt = driver.findElement(By.id(OR.getProperty("regi_pass_id"))).getAttribute("placeholder");
		
		String C_pass_plholder_txt = driver.findElement(By.id(OR.getProperty("regi_conpass_id"))).getAttribute("placeholder");
		
		String Class_co_plholder_txt = driver.findElement(By.id(OR.getProperty("regi_classcode_id"))).getAttribute("placeholder");
		
		System.out.print("*** Below Placeholder value should be present***\n" );
		
		System.out.println("First name field placeholder value is==>:" +F_N_plholder_txt);
		
		System.out.println("Last name field placeholder value is==>:"+L_N_plholder_txt);
		
		System.out.println("Email field placeholder value is==>:"+Email_plholder_txt);
		
		System.out.println("Password field placeholder value is==>:"+Pass_plholder_txt);
		
		System.out.println("Confirm Password field placeholder value is==>:"+C_pass_plholder_txt);
		
		System.out.println("Email field placeholder value is:===>:"+Class_co_plholder_txt);
		
	}
	
	  @Test(enabled = false,
			  description = "Provide number value in the first name field || Alert message should be given as number value not allowed "
			  		+ "and only character value is required")
	  
	  public void TC_R003() throws InterruptedException
	  {					
		  extentlogger = extentreport.createTest("TC_R003");
			
		  extentlogger.info("CreateAccount_Test_Scenario===>: Provide number value in the first name field");
			
		  extentlogger.info("Expected_Results===>:Alert message should be given as number value not allowed and only character value "
		  		+ "is required");
			
          WebElement F_name = driver.findElement(By.id(OR.getProperty("regi_fname_id")));
          
          F_name.sendKeys(config.getProperty("FirstName_R003"));
          
          if (driver.findElement(By.className(OR.getProperty("regi_error_Class"))).isDisplayed()) 
            {
				
        	  WebElement err_msg = driver.findElement(By.className(OR.getProperty("regi_error_Class")));
				
        	  String err_msg_txt = err_msg.getText();
				
        	  System.out.println (err_msg_txt);
			}
        	else
        	{
        		System.out.println("Error message is not display");    		
        	}
          
            driver.navigate().refresh();
		 }

	  @Test(enabled = false,
			  description = "Provide special character value other than space in the First name field || Alert message should show "
			  		+ "that please type a valid name and no special character allowed other than space")
	  
	  public void TC_R004() throws InterruptedException
	  {		   
		  extentlogger = extentreport.createTest("TC_R004");
			
	    	extentlogger.info("CreateAccount_Test_Scenario===>: Provide special character value other than space in the First name field");
			
			extentlogger.info("Expected_Results===>:Alert message should show that please type a valid name and no special character "
					+ "allowed other than space");
		  
		  WebElement F_name=driver.findElement(By.id(OR.getProperty("regi_fname_id")));
          
		  F_name.sendKeys(config.getProperty("FirstName_R004"));
         
		  if(driver.findElement(By.className(OR.getProperty("regi_error_Class"))).isDisplayed()) 
		  	{
				WebElement err_msg=driver.findElement(By.className(OR.getProperty("regi_error_Class")));
				
				String err_msg_txt =err_msg.getText().toString();
				
				System.out.println (err_msg_txt);
			}
        	else
        	{
      		System.out.println("Error message is not display");    		
      	    }
		 }
	  
	  @Test(enabled = false,
			  description = "Provide number value in the Last name field || Alert message should be given as number value not allowed "
			  		+ "and only character value is required.")
	  
	  public void TC_R005() throws InterruptedException
	  {
		  extentlogger = extentreport.createTest("TC_R005");
			
	    	extentlogger.info("CreateAccount_Test_Scenario===>: Provide number value in the Last name field");
			
			extentlogger.info("Expected_Results===>:Alert message should be given as number value not allowed and only character value "
					+ "is required."); 
		  
		    WebElement L_name = driver.findElement(By.id(OR.getProperty("regi_lname_id")));
            
		    L_name.sendKeys(config.getProperty("LastName_R005"));
            
		    if (driver.findElement(By.className(OR.getProperty("regi_error_Class"))).isDisplayed())
            {
				WebElement err_msg = driver.findElement(By.className(OR.getProperty("regi_error_Class")));
				
				String err_msg_txt = err_msg.getText().toString();
				
				System.out.println (err_msg_txt);
		    }
            	else
            	{
            		
      	    	System.out.println("Error message is not display");
      	    	
      	        }
	  }
	  
	  @Test(enabled = false,
			  description = "Provide special character value other than space in the Last name field || Alert message should show "
			  		+ "that please type a valid name and no special character allowed other than space")
	  
	  public void TC_R006() throws InterruptedException
	  {
		  extentlogger = extentreport.createTest("TC_R006");
			
	    	extentlogger.info("CreateAccount_Test_Scenario===>: Provide special character value other than space in the Last name field");
			
			extentlogger.info("Expected_Results===>:Alert message should show that please type a valid name and no special character "
					+ "allowed other than space"); 
		  
			WebElement L_name = driver.findElement(By.id(OR.getProperty("regi_lname_id")));
            
			L_name.sendKeys(config.getProperty("LastName_R006"));
            
			if (driver.findElement(By.className(OR.getProperty("regi_error_Class"))).isDisplayed()) 
            {
				
				WebElement err_msg = driver.findElement(By.className(OR.getProperty("regi_error_Class")));
				
				String err_msg_txt = err_msg.getText();
				
				System.out.println(err_msg_txt);
			}
        	else
        	{
        		
      		System.out.println("Last name Error message is not display");
      		
      	    }
		 }
	  
	  @Test(enabled = false,
			  description = "Check In email ID text box, if @ is missing || Alert message should be given as Email ID is invalid, "
			  		+ "Please give a valid email ID with @ and domain name")
	  public void TC_R007() throws InterruptedException
	  {		  
		  extentlogger = extentreport.createTest("TC_R007");
			
	    	extentlogger.info("CreateAccount_Test_Scenario===>: Check In email ID text box, if @ is missing");
			
			extentlogger.info("Expected_Results===>: Alert message should be given as Email ID is invalid, Please give a valid email "
					+ "ID with @ and domain name");  
		  
			WebElement mail_format_chk =driver.findElement(By.id(OR.getProperty("regi_email_id")));
            
			mail_format_chk.sendKeys(config.getProperty("Email_R007"));
            
			if (driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath"))).isDisplayed()) 
            {
				
				WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
				
				String err_msg_txt =err_msg.getText().toString();
				
				System.out.println (err_msg_txt);
			}
        	else
        	{
        		
      		System.out.println("Error message is not display");
      		
      	    }
            
		 }
	  
	  @Test(enabled = false,
			  description = "In email ID text box, given email id domain information is missing after @ sign, password value given "
			  		+ "and click on Signup button || Alert message should be given as Email ID is invalid, Please give a valid email")
	  
	  public void TC_R008() throws InterruptedException
	  {
		  	extentlogger = extentreport.createTest("TC_R008");
			
	    	extentlogger.info("CreateAccount_Test_Scenario===>: In email ID text box, given email id domain information is missing "
	    			+ "after @ sign, password value given and click on Signup button");
			
			extentlogger.info("Expected_Results===>: Alert message should be given as Email ID is invalid, Please give a valid email "
					+ "ID with @ and domain name");  
		  
			WebElement mail_format_chk = driver.findElement(By.id(OR.getProperty("regi_email_id")));
            
			WebElement Pass_format_chk = driver.findElement(By.id(OR.getProperty("regi_pass_id")));
            
			mail_format_chk.clear();
            
			mail_format_chk.sendKeys(config.getProperty("Email_R008"));
            
			Pass_format_chk.sendKeys(config.getProperty("Password_R008"));
            
			Thread.sleep(1000);
            
			if (driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath"))).isDisplayed()) 
            {
				
				WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
				
				String err_msg_txt =err_msg.getText().toString();
				
				System.out.println (err_msg_txt);
			}
        	else
        	{
        		
      		System.out.println("Error message is not display");
      		
      	    }
            
		 }
	  
	  @Test(enabled = false,
			  description = "If the email Id value given as special character value other than @, dot and underscore symbol , "
			  		+ "with password value and click on Signup button || Alert message should be given as Email ID is invalid, "
			  		+ "Please give a valid email ID with @ and domain name")
	  
	  public void TC_R009() throws InterruptedException
	  {
		  	extentlogger = extentreport.createTest("TC_R009");
			
	    	extentlogger.info("CreateAccount_Test_Scenario===>: If the email Id value given as special character value other than @, "
	    			+ "dot and underscore symbol , with password value and click on Signup button");
			
			extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid email "
					+ "ID with @ and domain name");  
		  
			WebElement mail_format_chk = driver.findElement(By.id(OR.getProperty("regi_email_id")));
            
			WebElement Pass_format_chk = driver.findElement(By.id(OR.getProperty("regi_pass_id")));
            
			mail_format_chk.clear();
            
			mail_format_chk.sendKeys("ravi.kumar@123com");
            
			Pass_format_chk.sendKeys("ravi@123");
            
			Thread.sleep(2000);
            
			if (driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath"))).isDisplayed()) 
            {
				
				WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
				
				String err_msg_txt =err_msg.getText().toString();
				
				System.out.println (err_msg_txt);
			}
        	else
        	{
        		
      		System.out.println("Error message is not display");
      		
      	    }
            
		 }
	  
	   @Test(enabled = false,
			   description = "If email ID value start with dot along with password value and click on Signup button || Alert message "
			   		+ "should be given as Email ID is invalid, Please give a valid email ID with @ and domain name")
	   
	  public void TC_R010() throws InterruptedException
	  {
		   	extentlogger = extentreport.createTest("TC_R010");
			
	    	extentlogger.info("CreateAccount_Test_Scenario===>: If email ID value start with dot along with password value and "
	    			+ "click on Signup button");
			
			extentlogger.info("Expected_Results===>: Alert message should be given as Email ID is invalid, Please give a valid "
					+ "email ID with @ and domain name"); 
		   
			WebElement mail_format_chk = driver.findElement(By.id(OR.getProperty("regi_email_id")));
            
			WebElement Pass_format_chk = driver.findElement(By.id(OR.getProperty("regi_pass_id")));
            
			mail_format_chk.clear();
            
			mail_format_chk.sendKeys(".ravi.kumar@cbnits.com");
            
			Pass_format_chk.sendKeys("ravi@123");
            
			Thread.sleep(2000);
            
			if (driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath"))).isDisplayed()) 
            {
				
				WebElement err_msg = driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
				
				String err_msg_txt = err_msg.getText();
				
				System.out.println("Error message is display==>:"+err_msg_txt);
			}
        	else
        	{
        		
      		System.out.println("Error message is not display");
      		
      	    }
			
            driver.navigate().refresh();
		 }
	   
      @Test(enabled = false,
    		  description = "In email ID value kept only as number after @ symbol along with password value and click on Signup "
    		  		+ "button || Alert message should be given as Email ID is invalid, Please give a valid email ID with @ and domain name")
      
	  public void TC_R011() throws InterruptedException
		  {			   
    	  		extentlogger = extentreport.createTest("TC_R011");
  		
    	  		extentlogger.info("CreateAccount_Test_Scenario===>: In email ID value kept only as number after @ symbol along "
    	  				+ "with password value and click on Signup button");
  		
    	  		extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid "
    	  				+ "email ID with @ and domain name");
    	  
    	  		WebElement mail_format_chk = driver.findElement(By.id(OR.getProperty("regi_email_id")));
	            
    	  		WebElement Pass_format_chk = driver.findElement(By.id(OR.getProperty("regi_pass_id")));
	            
    	  		mail_format_chk.clear();
	            
    	  		mail_format_chk.sendKeys("ravi.kumar@123.123");
	            
    	  		Pass_format_chk.sendKeys("ravi@123");
	            
    	  		Thread.sleep(1000);
	            
    	  		if (driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath"))).isDisplayed()) 
	            {
					
    	  			WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
					
    	  			String err_msg_txt =err_msg.getText();
					
    	  			System.out.println (err_msg_txt);
				}
	        	else
	        	{
	        		
	      		System.out.println("Error message is not display");
	      		
	      	    }
	            
			 }
	      
       @Test(enabled = false,
    		   description = "In email ID value kept @ value twice along with the password value and click on the Signup "
    		   		+ "button || Alert message should be given as Email ID is invalid, Please give a valid email ID with @ and domain name")
       
	  public void TC_R012() throws InterruptedException
		  {		
    	   
    	   		extentlogger = extentreport.createTest("TC_R012");
   		
    	   		extentlogger.info("CreateAccount_Test_Scenario===>: In email ID value kept @ value twice along with the password value "
       			+ "and click on the Signup button");
   		
    	   		extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid email "
   				+ "ID with @ and domain name");
    	   
    	   		WebElement mail_format_chk = driver.findElement(By.id(OR.getProperty("regi_email_id")));
	            
    	   		WebElement Pass_format_chk = driver.findElement(By.id(OR.getProperty("regi_pass_id")));
	            
    	   		mail_format_chk.clear();
	            
    	   		mail_format_chk.sendKeys("ravi.kumar@@cbnits.com");
	            
    	   		Pass_format_chk.sendKeys("ravi@123");
	            
    	   		Thread.sleep(2000);
	            
    	   		if (driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath"))).isDisplayed()) 
	            {
					
    	   			WebElement err_msg = driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
					
    	   			String err_msg_txt = err_msg.getText().toString();
					
    	   			System.out.println ("Error message is===>:"+err_msg_txt);
				}
	        	else
	        	{
	        		
	      		System.out.println("Error message is not display");
	      		
	      	    }
	            
			 }
	      
       
	   @Test(enabled=false,description="In email ID multiple dot value without any input in between as input along with password "
	   		+ "and click on Signup button || Alert message should be given as Email ID is invalid, Please give a valid email ID "
	   		+ "with @ and domain name")
	   
	   public void TC_R013() throws InterruptedException
		  {
		   extentlogger = extentreport.createTest("TC_R013");
			
	    	extentlogger.info("CreateAccount_Test_Scenario===>: In email ID multiple dot value without any input in between as "
	    			+ "input along with password and click on Signup button");
			
			extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid "
					+ "email ID with @ and domain name");
		   
		   Thread.sleep(2000);
	            
		   WebElement mail_format_chk = driver.findElement(By.id(OR.getProperty("regi_email_id")));
	            
		   WebElement Pass_format_chk = driver.findElement(By.id(OR.getProperty("regi_pass_id")));
	       
		   Thread.sleep(1000);
	       
		   mail_format_chk.clear();
	       
		   mail_format_chk.sendKeys("....");
	       
		   Pass_format_chk.sendKeys("ravi@123");
	       
		   Thread.sleep(1000);
	       
		   if (driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath"))).isDisplayed()) 
	            {
					
			   		WebElement err_msg = driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
					
			   		String err_msg_txt = err_msg.getText().toString();
					
			   		System.out.println ("Error message when enter email with multiple dot value===>:"+err_msg_txt);
				}
	        	else
	        	{
	        		
	      		System.out.println("Error message is not display");
	      		
	      	    }
	            
			 }
	      
	   
	    @Test(enabled = false,
	    		description = "In email ID field , in case any unicode character value as address used along with password value "
	    				+ "and click on sign up button || Alert message should be given as Email ID is invalid, Please give a "
	    				+ "valid email ID with @ and domain name || Alert message should be given as Email ID is invalid, Please "
	    				+ "give a valid email ID with @ and domain name")
	    
	    public void TC_R014() throws InterruptedException
		  {
			    
	    		extentlogger = extentreport.createTest("TC_R014");
			
	    		extentlogger.info("CreateAccount_Test_Scenario===>: In email ID field , in case any unicode character value as address "
	    			+ "used along with password value and click on sign up button");
			
	    		extentlogger.info("Expected_Results===>:Alert message should be given as Email ID is invalid, Please give a valid email "
					+ "ID with @ and domain name");
	    	
	    		WebElement mail_format_chk = driver.findElement(By.id(OR.getProperty("regi_email_id")));
	           
	    		WebElement Pass_format_chk = driver.findElement(By.id(OR.getProperty("regi_pass_id")));
	            
	    		Thread.sleep(2000);
	            
	    		mail_format_chk.clear();
	            
	    		mail_format_chk.sendKeys("U+0000");
	            
	    		Pass_format_chk.sendKeys("ravi@123");
	            
	    		Thread.sleep(1000);
	            
	    		if (driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath"))).isDisplayed()) 
	            {
					
	    			WebElement err_msg = driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
					
	    			String err_msg_txt = err_msg.getText();
					
	    			System.out.println ("Error message when email field enter unicode character value===>:"+err_msg_txt);
				}
	        	else
	        	{
	        		
	      		System.out.println("***Email ID is invalid, Please give a valid email ID with @ and domain name.***");
	      		
	      	    }
	            
			 }
	      
	   
	   @Test(enabled = false,
			   description = "If the email ID value used is not been activated and along with password value and click on sign up button || It should be give validation error message, That email is already registered")
	   public void TC_R015() throws InterruptedException
		  {
			    
		   		extentlogger = extentreport.createTest("TC_R015");
			
		   		extentlogger.info("CreateAccount_Test_Scenario===>: If the email ID value used is not been activated and along with password value and click on sign up button");
			
		   		extentlogger.info("Expected_Results===>: It should be give validation error message, That email is already registered");
		   
		   		Thread.sleep(2000);
	    		
		   		WebElement FirstName = driver.findElement(By.id(OR.getProperty("regi_fname_id")));
	    		
		   		FirstName.sendKeys("FirstName");
	    		
	    		WebElement LastName = driver.findElement(By.id(OR.getProperty("regi_lname_id")));
	    		
	    		LastName.sendKeys("LastName");
	    		
	    		WebElement Email = driver.findElement(By.id(OR.getProperty("regi_email_id")));
	    		
	    		Email.sendKeys("ravi4@yopmail.com");
	    		
	    		WebElement password = driver.findElement(By.id(OR.getProperty("regi_pass_id")));
	    		
	    		password.sendKeys("ravi@123");
	    		
	    		WebElement Confirmpassword = driver.findElement(By.id(OR.getProperty("regi_conpass_id")));
	    		
	    		Confirmpassword.sendKeys("ravi@123");
	    		
	    		Thread.sleep(2000);
	    		
	    		if (!driver.findElement(By.xpath(OR.getProperty("regi_chk_xpath"))).isSelected());
	    		   {
	    		     
	    			   driver.findElement(By.xpath(OR.getProperty("regi_chk_xpath"))).click();
	    		   }
	    		
	    		if (driver.findElement(By.xpath(OR.getProperty("regi_button_xpath"))).isEnabled()) 
	    		   {
	    				WebElement signup_btn = driver.findElement(By.xpath(OR.getProperty("regi_button_xpath")));
	    			
	    				signup_btn.click();
	    			
	    				Thread.sleep(2000);
	    			
	    			if (isAlertPresents())
	    			  {
	    				
	    				Alert alert = driver.switchTo().alert();
	    				
	    				String alert_msg = alert.getText().toString();
	    			    
	    				System.out.println(alert_msg);
	    				
	    				alert.accept();
	    				
	    			  }
	    			
	    			  else if (isElementPresent(By.xpath(OR.getProperty("regi_error_Em_al_rg_xpath")))) 
	    			  {
	    				  WebElement lgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("regi_error_Em_al_rg_xpath")));
	    				  
	    				  String lgfail_msg = lgfail_msg_ele.getText();
	    				  
	    				  System.out.println("**Validation error message is display**===>:" +lgfail_msg );
	    			  }
	    		   }
	        	   
			 }
	   
        @Test(enabled = false,
        		description = "If password value entered is not having lower characters || It should not be allowed to be saved "
        				+ "and show the alert message")
        
        public void TC_R017() throws InterruptedException
			  {
				    
        			extentlogger = extentreport.createTest("TC_R017");
    		
        			extentlogger.info("CreateAccount_Test_Scenario===>: If password value entered is not having lower characters");
    		
        			extentlogger.info("Expected_Results===>: It should not be allowed to be saved and show the alert message");	
        	
        	        WebElement Pass_format_chk=driver.findElement(By.id(OR.getProperty("regi_pass_id")));
		           
        	        // mail_format_chk.clear();		            
		            Pass_format_chk.sendKeys("1234545@#");
		            
		            Thread.sleep(2000);
		            
		            if(isElementPresent(By.xpath(OR.getProperty("regi_mail_error_xpath")))) 
		            {
						
		            	WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
						
		            	String err_msg_txt = err_msg.getText();
						
		            	System.out.println (err_msg_txt);
					}
		        	else
		        	{
		        		
		      		System.out.println("**Sign up button is not enable because entered password value is not having lower characters** ");
		      		
		      	    }
		            
				 }
	      
     
	   @Test(enabled = false,
			   description = "If password value entered is not having a number character || It should not be allowed to be saved "
			   		+ "and show the alert message")
	   
	   public void TC_R018() throws InterruptedException
			  {
				  
		   			extentlogger = extentreport.createTest("TC_R018");
			
		   			extentlogger.info("CreateAccount_Test_Scenario===>: If password value entered is not having a number character");
			
		   			extentlogger.info("Expected_Results===>:It should not be allowed to be saved and show the alert message");
					
					WebElement Pass_format_chk=driver.findElement(By.id(OR.getProperty("regi_pass_id")));
		           
		            //mail_format_chk.sendKeys("U+0000");
		            Pass_format_chk.sendKeys("ravi@ravi");
		            
		            if (isElementPresent(By.xpath(OR.getProperty("regi_mail_error_xpath")))) 
		            {
						
		            	WebElement err_msg = driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
						
		            	String err_msg_txt = err_msg.getText().toString();
						
		            	System.out.println (err_msg_txt);
					}
		        	else
		        	{
		        		
		      		System.out.println("***Sign up button is not enable beause entered password value is not having a number character***");
		      		
		      	    }
		            
				 }
	      
      @Test(enabled = false,
    		  description = "If password value entered is less than 6 character || It should not be allowed to be saved and show "
    		  		+ "the alert message")
      
	  public void TC_R019() throws InterruptedException
			  {
				   
    	  			extentlogger = extentreport.createTest("TC_R019");
  		
    	  			extentlogger.info("CreateAccount_Test_Scenario===>: If password value entered is less than 6 character");
  		
    	  			extentlogger.info("Expected_Results===>: It should not be allowed to be saved and show the alert message");
    	  
    	  			WebElement Pass_format_chk=driver.findElement(By.id(OR.getProperty("regi_pass_id")));
		           
    	  			// mail_format_chk.clear();
    	  			Pass_format_chk.sendKeys("rv2@");
		            
    	  			if (isElementPresent(By.xpath(OR.getProperty("regi_mail_error_xpath")))) 
		            {
						
    	  				WebElement err_msg = driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
						
    	  				String err_msg_txt = err_msg.getText();
						
    	  				System.out.println (err_msg_txt);
					}
		        	else
		        	{
		        		
		      		System.out.println("Sign up button is not enable because your enter value is less then 6 character ");
		      		
		      	    }
		            
				 }
	      
	   @Test(enabled = false,
			   description = "If Confirm password value provided differ from the Password value || It should not be allowed to be "
			   		+ "saved and show the alert message while typing")
	   
	   public void TC_R020() throws InterruptedException
			  {				    
		           
		   			extentlogger = extentreport.createTest("TC_R020");
			
		   			extentlogger.info("CreateAccount_Test_Scenario===>: If Confirm password value provided differ from the Password value");
			
		   			extentlogger.info("Expected_Results===>: It should not be allowed to be saved and show the alert message while typing");
		   
		            WebElement Pass_format_chk=driver.findElement(By.id(OR.getProperty("regi_pass_id")));
		           
		            // mail_format_chk.clear();
		            Pass_format_chk.sendKeys("ravi@123");
		            
		            driver.findElement(By.id(OR.getProperty("regi_conpass_id"))).sendKeys("ravi@12");
		            
		            if (isElementPresent(By.xpath(OR.getProperty("regi_mail_error_xpath")))) 
		            {
						
		            	WebElement err_msg = driver.findElement(By.xpath(OR.getProperty("regi_mail_error_xpath")));
						
		            	String err_msg_txt = err_msg.getText().toString();
						
		            	System.out.println (err_msg_txt);
					}
		        	else
		        	{
		        		
		      		System.out.println("Sign up button is not enable because your Confirm password value is differ from the Password value");
		      		
		      	    }
		            
				 }
	   
	   @Test(enabled = false,
			   description = "If invalid optional class code value provided || It should not be allowed to be saved and show "
			   		+ "the alert message while saving")
	   
	   public void TC_R021() throws InterruptedException
		  {		    
					
		   		extentlogger = extentreport.createTest("TC_R021");
			
		   		extentlogger.info("CreateAccount_Test_Scenario===>: If invalid optional class code value provided");
			
		   		extentlogger.info("Expected_Results===>: It should not be allowed to be saved and show the alert message while saving");
		   
		   		driver.findElement(By.id(OR.getProperty("regi_fname_id"))).sendKeys("FirstName");
	  		
		   		driver.findElement(By.id(OR.getProperty("regi_lname_id"))).sendKeys("LastName");
	   		
		   		driver.findElement(By.id(OR.getProperty("regi_email_id"))).sendKeys("ravi4@yopmail.com");
		   	
		   		driver.findElement(By.id(OR.getProperty("regi_pass_id"))).sendKeys("ravi@123");;
			
		   		driver.findElement(By.id(OR.getProperty("regi_conpass_id"))).sendKeys("ravi@123");
		    
		   		driver.findElement(By.id(OR.getProperty("regi_classcode_id"))).sendKeys("ravi1");
		   	
		   		if (!driver.findElement(By.xpath(OR.getProperty("regi_chk_xpath"))).isSelected());
		    	  {
		    	     
		    		  driver.findElement(By.xpath(OR.getProperty("regi_chk_xpath"))).click();
		   		  }		
		    	  
		    	  if(driver.findElement(By.xpath(OR.getProperty("regi_button_xpath"))).isEnabled()) 
		    	   {
		       			WebElement signup_btn = driver.findElement(By.xpath(OR.getProperty("regi_button_xpath")));
		    		
		       			signup_btn.click();
		   			
		       			Thread.sleep(4000);		    
		   					   			
		    		 if (isElementPresent(By.xpath(OR.getProperty("regi_error_Inva_classCo_xpath")))) 
		    			{
		                    
		    			 	WebElement rgfail_msg_ele = driver.findElement(By.xpath(OR.getProperty("regi_error_Inva_classCo_xpath")));
		    				
		    			 	String rgfail_msg = rgfail_msg_ele.getText().toString();
		                    
		    			 	System.out.println("Invalid class code vaidation message is===>:"+rgfail_msg );
		    			}
		    		 else 
		    		 {
		    			 
		    		 System.out.println("Invalid class code vaidation message is not display");
		    		 
			      	 }
		    	   }
		    	  
				 }
	   
	   @Test(enabled = false,
			   description = "Check when Sign up button is enabled")
	   public void TC_R022() throws InterruptedException
		  {		    
	 		
		   		extentlogger = extentreport.createTest("TC_R022");
			
		   		extentlogger.info("CreateAccount_Test_Scenario===>: Check when Sign up button is enabled");
			
		   		extentlogger.info("Expected_Results===>:Login button should not be enabled");
		   
		   		driver.findElement(By.id(OR.getProperty("regi_fname_id"))).sendKeys("FirstName");
	  		
		   		driver.findElement(By.id(OR.getProperty("regi_lname_id"))).sendKeys("LastName");
	   		
		   		driver.findElement(By.id(OR.getProperty("regi_email_id"))).sendKeys("ravi4@yopmail.com");
		   
		   		driver.findElement(By.id(OR.getProperty("regi_pass_id"))).sendKeys("ravi@123");;
			
		   		driver.findElement(By.id(OR.getProperty("regi_conpass_id"))).sendKeys("ravi@123");
		   
		   
		   		if (!driver.findElement(By.xpath(OR.getProperty("regi_chk_xpath"))).isSelected());
		    	  {
		    		  
		    	     driver.findElement(By.xpath(OR.getProperty("regi_chk_xpath"))).click();
		    	     
		   		   }
		    	  
		    	  Thread.sleep(3000);
		    	
		    	  if (driver.findElement(By.xpath(OR.getProperty("regi_button_xpath"))).isEnabled()) 
		    	   {
		    		  
		       			WebElement signup_btn = driver.findElement(By.xpath(OR.getProperty("regi_button_xpath")));
		       		
		       			String signup_btn_txt= signup_btn.getText();
		       		
		       			System.out.println("Enable button name is:" +signup_btn_txt);		   				    		 		    		 
		    	   }	
		    	  else 
		    		 {
		    		  
		    		 System.out.println("Sign up button is not enable");    
		    		 
			      	 }
		    	  
				 }
	   
	   
	   @Test(enabled = false,description = "When user clicks on 'Already have an account? Sign in' link || User Should be redirected "
	   		+ "to the Login page")
	   
	   public void TC_R023() throws InterruptedException
		  {		   
            
		   		extentlogger = extentreport.createTest("TC_L001");
			
		   		extentlogger.info("CreateAccount_Test_Scenario===>: When user clicks on 'Already have an account? Sign in' link");
			
		   		extentlogger.info("Expected_Results===>: User Should be redirected to the Login page");
		   
		   		Log.info("CreateAccount test case ended !!!");
           
		   		Thread.sleep(1000);
            
		   		String url= driver.getCurrentUrl();
           
		   		System.out.println("You are in signup page and url is===>:"+url);            
	 		
		   		WebElement signlnk=driver.findElement(By.xpath(OR.getProperty("rg_signin_lnk_xpath")));
	 		
		   		signlnk.click();
	 		
	 		
		   		Thread.sleep(2000);
	 		
		   		String lg_url= driver.getCurrentUrl();
            
		   		System.out.println("You are in login page and url is====>:" +lg_url);	
            
		   		Log.info("CreateAccount module test case Ended !!!");
		  }
   
	   
	   @AfterMethod
	   public void getMethodsUpdates(ITestResult result) throws IOException 
	   {
	 	  if(result.getStatus()==ITestResult.FAILURE) 
	 	  {
	 		  
	 		  String temp=Utils.getScreenshot(driver);
	 		  
	 		  extentlogger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	 		  
	 	  }
	 	  
	 	  else if(result.getStatus()==ITestResult.SUCCESS)
	 	  {
	 		 // String status="Pass";
	 		// extentlogger.pass(result.getName() +"==>"+status);
	 	  }
	 	  
	    }
    
    
    @AfterTest
    public void callTearDown() {
    	
    	CreateAccount.tearDown();
    }
    
    
    @AfterSuite
    public void storeReport() {
    	
    	CreateAccount.captureReport();
    }
    
}

package com.knovva.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import com.knovva.utilities.Log;

public class Events extends TestBase_Knovva {
	
	@BeforeSuite
	public void callSetup() {
		
		Events.setUp();
	}
	
	
	@BeforeTest
	public void callBrowser() {
		
		Events.browserLaunch();
	}
	
	//Mexico_summit page 
	
   @Test(description="Check whether the same name saved in the registration page displaying or not || The same name saved in the registration page should be displaying in this field")
   
  public void TC_EAF001() throws InterruptedException 
  { 
	   	Log.info("Events test case started !!!");
   	
   		extentlogger = extentreport.createTest("TC_EAF001");
		
   		extentlogger.info("Events_Test_Scenario===>: Check whether the same name saved in the registration page displaying or not");
		
		extentlogger.info("Expected_Results===>: The same name saved in the registration page should be displaying in this field");
	   
	    Thread.sleep(2000);
	    	
	    TestBase_Knovva.ClickOnHamburgerMenu();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(OR.getProperty("Events_xpath"))).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(OR.getProperty("Event_mexico_xpath"))).click();		
		
		Thread.sleep(3000);		
	    
		String mex_sum_FN = driver.findElement(By.id(OR.getProperty("event_ms_FN_id"))).getAttribute("value");
	    
		String mex_sum_LN = driver.findElement(By.id(OR.getProperty("event_ms_LN_id"))).getAttribute("value");
	    
		String mex_sum_mail = driver.findElement(By.id(OR.getProperty("event_ms_email_id"))).getAttribute("value");
        
		Thread.sleep(3000);
	    
		if(mex_sum_FN.equals("ravi") && mex_sum_LN.equals("kumar") && mex_sum_mail.equals("ravi.kumar@cbnits.com")) 
	    {
	    	System.out.println("****All the values are same and value is: \n" +mex_sum_FN+ "\n" +mex_sum_LN+ "\n" + mex_sum_mail + "\n");
	    }
	    else
	    {
	    	System.out.println("All the values or partial values are not same");
	    }  
      }
   
         
	    @Test(enabled = false,
	    		description = "Check whether number accepting in this field or not || No numeric number other than alphabet character should accept")
	    
	    public void TC_EAF002() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF002");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether number accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: No numeric number other than alphabet character should accept");
	    	
	    	Thread.sleep(2000);
	  	    
	    	WebElement mex_sum_FN = driver.findElement(By.id(OR.getProperty("event_ms_FN_id")));
	  	    
	    	mex_sum_FN.clear();
	  	    
	    	mex_sum_FN.sendKeys(config.getProperty("FirstName_EAF002"));
	        
	    	Thread.sleep(3000);
	        
	    	if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
					String err_msg_txt =err_msg.getText().toString();
					
					System.out.println (err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("Error message is not display");    		
	      	        }
	          
           }
	    
	    
	    @Test(enabled = false,
	    		description="Check whether special character accepting in this field or not || Nothing other than alphabet character should accept")
	    
	    public void TC_EAF003() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF003");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether special character accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: Nothing other than alphabet character should accept");
	    	
	    	Thread.sleep(2000);
	  	    
	    	WebElement mex_sum_FN = driver.findElement(By.id(OR.getProperty("event_ms_FN_id")));
	  	    
	    	mex_sum_FN.clear();
	  	    
	    	//Enter some value in first name field 
	  	    mex_sum_FN.sendKeys(config.getProperty("FirstName_EAF003"));
	        
	  	    Thread.sleep(3000);
	        
	  	    if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
					String err_msg_txt =err_msg.getText();
					
					System.out.println("Error message is display==>:" +err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("Error message is not display");    		
	      	        }
             }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether the same name saved in the registration page displaying or not || The same name saved in the registration page should be displaying in this field")
	    
	    public void TC_EAF004() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF004");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether the same name saved in the registration page displaying or not");
			
			extentlogger.info("Expected_Results===>: The same name saved in the registration page should be displaying in this field");
	    	
	    	Thread.sleep(2000);
	  	    
	    	String mex_sum_LN = driver.findElement(By.id(OR.getProperty("event_ms_LN_id"))).getAttribute("value");
	        
	    	Thread.sleep(2000);
	        
	    	if(mex_sum_LN.equals("kumar")) 
		    {
		    	System.out.println("***Last name value is same name saved in the registration page and value is===>:" +mex_sum_LN);
		    }
		    else
		    {
		    	System.out.println("Last name value or partial values are not same");
		    }  
	     
        }	    
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether number accepting in this field or not")
	    
	    public void TC_EAF005() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF005");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether number accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: No numeric number other than alphabet character should accept");
	    	
	    	Thread.sleep(2000);
	  	    
	    	WebElement mex_sum_LN = driver.findElement(By.id(OR.getProperty("event_ms_LN_id")));
	  	    
	    	mex_sum_LN.clear();
	  	    
	    	mex_sum_LN.sendKeys(config.getProperty("LastName_EAF005"));
	        
	    	Thread.sleep(2000);
	        
	    	if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
					String err_msg_txt =err_msg.getText().toString();
					
					System.out.println (err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("Error message is not display");    		
	      	        }
           }
   
	    
	    @Test(enabled = false,
	    		description = "Check whether special character accepting in this field or not || Nothing other than alphabet character should accept")
	    
	    public void TC_EAF006() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF006");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether special character accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: Nothing other than alphabet character should accept");
	    	
	    	Thread.sleep(2000);
	  	    
	    	WebElement mex_sum_LN = driver.findElement(By.id(OR.getProperty("event_ms_LN_id")));
	  	    
	    	mex_sum_LN.clear();
	  	    
	    	mex_sum_LN.sendKeys(config.getProperty("LastName_EAF006"));
	        
	    	Thread.sleep(2000);
	        
	    	if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
					String err_msg_txt =err_msg.getText().toString();
					
					System.out.println (err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("Error message is not display");    		
	      	        }
	             
           }
	    
	     
	    @Test(enabled = false,
	    		description = "Check whether number accepting in this field or not || No numeric number other than alphabet character should accept")
	    
	    public void TC_EAF007() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF007");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether number accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: No numeric number other than alphabet character should accept");
	    	
	    	Thread.sleep(2000);
	  	    
	    	WebElement mex_sum_PN = driver.findElement(By.id(OR.getProperty("event_ms_preferredName_id")));
	  	    
	    	mex_sum_PN.clear();
	  	    
	    	mex_sum_PN.sendKeys(config.getProperty("LastName_EAF005"));
	        
	    	Thread.sleep(2000);
	        
	    	if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
					String err_msg_txt =err_msg.getText();
					
					System.out.println (err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("Prefered Name field is accepting number value");    		
	      	        }
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether special character accepting in this field or not || Nothing other than alphabet character should accept")
	    
	    public void TC_EAF008() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF008");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether special character accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: Nothing other than alphabet character should accept");
	    	
	    	Thread.sleep(2000);
	  	    
	    	WebElement mex_sum_PN = driver.findElement(By.id(OR.getProperty("event_ms_preferredName_id")));
	  	    
	    	mex_sum_PN.clear();
	  	    
	    	mex_sum_PN.sendKeys(config.getProperty("LastName_EAF005"));
	        
	    	Thread.sleep(2000);
	        
	    	if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
					String err_msg_txt =err_msg.getText().toString();
					
					System.out.println (err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("Prefered Name field is accepting special character value");    		
	      	        }
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether Male and Female,Other values available in the drop down or not || Male and Female ,other values should only be available in the drop down control")
	    
	    public void TC_EAF009() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF009");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether Male and Female,Other values available in the drop down or not");
			
			extentlogger.info("Expected_Results===>: Male and Female ,other values should only be available in the drop down control");
	    	
	    	Thread.sleep(2000);
	  	    
	    	String genderDP = driver.findElement(By.id(OR.getProperty("event_ms_genderDP_id"))).getText();
	  	    
	    	System.out.println("Dropdown value display is===>:" +genderDP);	  	    	  	    
	        
	    	Thread.sleep(2000);	         
         }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether Male or Female values can be possible to be selected or not || Male or Female values can be possible to be selected from Gender drop down field")
	    
	    public void TC_EAF010() throws InterruptedException 
	    { 	  	    
	    	extentlogger = extentreport.createTest("TC_EAF010");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether Male or Female values can be possible to be selected or not");
			
			extentlogger.info("Expected_Results===>: Male or Female values can be possible to be selected from Gender drop down field");
	    	
	    	WebElement drp=driver.findElement(By.id(OR.getProperty("event_ms_genderDP_id")));
	  	    
	    	drp.click();
	  	    
	    	Select select=new Select(driver.findElement(By.id(OR.getProperty("event_ms_genderDP_id"))));
	  	    
	    	select.selectByVisibleText("Male");
	  	    
	    	Thread.sleep(2000);
	  	    
	    	String dp_value=driver.findElement(By.id(OR.getProperty("event_ms_genderDP_id"))).getAttribute("value");
	  	    
	    	Thread.sleep(2000);
	  	    
	    	drp.click();
	  	    
	    	select.selectByVisibleText("Female");
	  	    
	    	String dp_value2=driver.findElement(By.id(OR.getProperty("event_ms_genderDP_id"))).getAttribute("value");
	  	    
	  	    System.out.println("Male or Female values are possible to select ,one by one Selected value is===>:\n" +dp_value +"\n" +dp_value2);	                
         }
     
	    
	    @Test(enabled = false,
	    		description = "Check whether number accepting in this field or not || No numeric number other than alphabet character should accept")
	    
	    public void TC_EAF011() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF011");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether number accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: No numeric number other than alphabet character should accept");
	    	
	    	WebElement mex_sum_Pp = driver.findElement(By.id(OR.getProperty("event_ms_prefPron_id")));
	  	    
	    	mex_sum_Pp.clear();
	  	    
	    	mex_sum_Pp.sendKeys(config.getProperty("LastName_EAF005"));
	        
	    	Thread.sleep(2000);
	        
	    	if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					
	    			WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
	    			String err_msg_txt =err_msg.getText();
					
	    			System.out.println ("Error message is display ==>:" +err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("preferredPronoun Name field is accepting number value");    		
	      	        }
	          
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether special character accepting in this field or not")
	    
	    public void TC_EAF012() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF012");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether special character accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: Nothing other than alphabet character should accept");
	    	
	  	    WebElement mex_sum_Pp = driver.findElement(By.id(OR.getProperty("event_ms_prefPron_id")));
	  	    
	  	    mex_sum_Pp.clear();
	  	    
	  	    mex_sum_Pp.sendKeys(config.getProperty("preferredPronoun_EAF012"));
	        
	  	    Thread.sleep(2000);
	        
	  	    if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
					String err_msg_txt =err_msg.getText();
					
					System.out.println ("Error message is ===>:"+err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("preferredPronoun Name field is accepting special character value");    		
	      	        }
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether it accepts all types variable input or not || Field should accepts all types variable input  like characters, numeric, alphanumeric")
	    
	    public void TC_EAF013() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF013");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether it accepts all types variable input or not");
			
			extentlogger.info("Expected_Results===>: Field should accepts all types variable input  like characters, numeric, alphanumeric");
	    	
	  	    WebElement mex_sum_STaddress = driver.findElement(By.id(OR.getProperty("event_ms_StAdress_id")));
	  	    
	  	    mex_sum_STaddress.clear();
	        
	  	    mex_sum_STaddress.sendKeys("RAVI123");
	        
	  	    mex_sum_STaddress.sendKeys(Keys.TAB);
	        
	  	    Thread.sleep(2000);
	        
	  	    if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
					String err_msg_txt =err_msg.getText().toString();
					
					System.out.println (err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("Street Address field is accepting characters, numeric, alphanumeric value");    		
	      	        }
           }
	    
	     
	    @Test(enabled = false,
	    		description = "Check that other than the below characters are allowed in the address field or not\n" +"# ' . , - / || Other than the below characters should not be allowed in the address field# ' . , - /")
	    
	    public void TC_EAF014() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF014");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check that other than the below characters are allowed in the address field or not\\n\" +\"# ' . , - /");
			
			extentlogger.info("Expected_Results===>: Other than the below characters should not be allowed in the address field# ' . , - /");
	    	
	  	    WebElement mex_sum_STaddress = driver.findElement(By.id(OR.getProperty("event_ms_StAdress_id")));
	  	    
	  	    mex_sum_STaddress.clear();
	        
	  	    mex_sum_STaddress.sendKeys("#$%^/n");
	        
	  	    mex_sum_STaddress.sendKeys(Keys.TAB);
	        
	  	    Thread.sleep(2000);
	        
	  	    if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
					String err_msg_txt =err_msg.getText();
					
					System.out.println (err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("Street Address field allowed to eneter characters like # ' . , - /");    		
	      	        }
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether it accepts all types variable input or not || Field should accepts all types variable input  like characters, numeric, alphanumeric")
	    public void TC_EAF015() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF015");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether it accepts all types variable input or not");
			
			extentlogger.info("Expected_Results===>: Field should accepts all types variable input  like characters, numeric, alphanumeric");
	    	
	  	    WebElement mex_sum_STaddress2 = driver.findElement(By.id(OR.getProperty("event_ms_SchStAdress2_id")));
	  	    
	  	    mex_sum_STaddress2.clear();
	        
	  	    mex_sum_STaddress2.sendKeys("kolkata123@");
	        
	  	    mex_sum_STaddress2.sendKeys(Keys.TAB);
	        
	  	    Thread.sleep(2000);
	        
	  	    if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
					String err_msg_txt =err_msg.getText().toString();
					
					System.out.println (err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("it is accepted all types variable input like characters,numeric,alphanumeric");    		
	      	        }
           }
	    
	     
	    @Test(enabled = false,
	    		description = "Check that other than the below characters are allowed in the address field or not\n" + "# ' . , - / || Other than the below characters should not be allowed in the address field# ' . , - /")
	    
	    public void TC_EAF016() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF016");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check that other than the below characters are allowed in the address field or not\\n\" + \"# ' . , - /");
			
			extentlogger.info("Expected_Results===>: Other than the below characters should not be allowed in the address field# ' . , - /");
	    	
	  	    WebElement mex_sum_STaddress2 = driver.findElement(By.id(OR.getProperty("event_ms_SchStAdress2_id")));
	  	    
	  	    mex_sum_STaddress2.clear();
	        
	  	    mex_sum_STaddress2.sendKeys("/+-090@");

	  	    Thread.sleep(2000);
	        
	  	    if (driver.findElement(By.className(OR.getProperty("event_ms_error_Class"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.className(OR.getProperty("event_ms_error_Class")));
					
					String err_msg_txt =err_msg.getText();
					
					System.out.println (err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("Street Address2 field allowed to eneter characters like # ' . , - /");    		
	      	        }
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether number accepting in this field or not || No numeric number other than alphabet character should accept")
	    
	    public void TC_EAF017() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF017");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether number accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: No numeric number other than alphabet character should accept");
	    	
	    	((JavascriptExecutor) driver).executeScript("scroll(0,250);");
	  	    
	    	WebElement mex_sum_city = driver.findElement(By.id(OR.getProperty("event_ms_city_id")));
	  	    
	    	mex_sum_city.clear();

	    	Thread.sleep(2000);
	    	
	    	mex_sum_city.sendKeys(config.getProperty("LastName_EAF005"));

	    	Thread.sleep(3000);
	        
	    	if (driver.findElement(By.xpath(OR.getProperty("event_ms_city_errer_xpath"))).isDisplayed())
            {
				WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("event_ms_city_errer_xpath")));
				
				String err_msg_txt =err_msg.getText();
				
				System.out.println (err_msg_txt);
		    }
            	else
            	{
      	    	System.out.println("City field allowed to enter number value");    		
      	        }
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether special character accepting in this field or not || Nothing other than alphabet character should accept")
	    
	    public void TC_EAF018() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF018");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether special character accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: Nothing other than alphabet character should accept");
	    	
	  	    WebElement mex_sum_city = driver.findElement(By.id(OR.getProperty("event_ms_city_id")));
	  	   
	  	    mex_sum_city.clear();
	  	    
	  	    Thread.sleep(2000);
	    	
	  	    mex_sum_city.sendKeys("ravi@");
	        
	  	    Thread.sleep(3000);
	        
	  	    if (driver.findElement(By.xpath(OR.getProperty("event_ms_city_errer_xpath"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("event_ms_city_errer_xpath")));
					
					String err_msg_txt =err_msg.getText();
					
					System.out.println (err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("City field allowed to enter number value");    		
	      	        }
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether special character accepting in this field or not || Nothing other than alphabet character should accept")
	    
	    public void TC_EAF022() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF022");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether special character accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: Nothing other than alphabet character should accept");
	    	
	  	    WebElement mex_sum_state = driver.findElement(By.id(OR.getProperty("event_ms_state_id")));

	  	    mex_sum_state.clear();
	  	    
	  	    Thread.sleep(2000);
	  	    
	  	    mex_sum_state.sendKeys("Delhi@@");
	        
	  	    Thread.sleep(3000);
	        
	  	    if (driver.findElement(By.xpath(OR.getProperty("event_ms_state_errorsmg_xpath"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("event_ms_state_errorsmg_xpath")));
					
					String err_msg_txt =err_msg.getText();
					
					System.out.println (err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("state field allowed not allow to enter special character");    		
	      	        }
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether Country Field is made as drop down or not || Country Field should be made as drop down")
	    
	    public void TC_EAF026() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF026");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether Country Field is made as drop down or not");
			
			extentlogger.info("Expected_Results===>: Country Field should be made as drop down");
	    	
	    	WebElement drp=driver.findElement(By.id(OR.getProperty("event_ms_country_id")));

	    	Select select=new Select(drp);
	  	    
	    	drp.click();
	  	    
	    	select.selectByValue("Andorra");
	  	    
	    	Thread.sleep(2000);
	  	    
	    	WebElement option=select.getFirstSelectedOption();
	  	    
	    	Thread.sleep(3000);
	  	    
	    	String selectedValueInDropDown = option.getText();
	  	    
	    	System.out.println("Country Field is made as drop down and slected dropdown value is===>:" +selectedValueInDropDown);
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether user can select respective coutry from the drop down or not || It should be possible for user to select respective country from the drop down")
	    
	    public void TC_EAF027() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF027");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether user can select respective coutry from the drop down or not");
			
			extentlogger.info("Expected_Results===>: It should be possible for user to select respective country from the drop down");
	    	
	    	WebElement drp=driver.findElement(By.id(OR.getProperty("event_ms_country_id")));

	    	Select select=new Select(driver.findElement(By.id(OR.getProperty("event_ms_country_id"))));
	  	    
	    	drp.click();
	  	    
	    	select.selectByVisibleText("India");
	  	    
	    	Thread.sleep(2000);
	  	    
	    	WebElement option=select.getFirstSelectedOption();
	  	    
	    	String selectedValueInDropDown = option.getText();
	  	    
	    	System.out.println ("User to select respective country from the drop down and slected dropdown value is===>:"+selectedValueInDropDown);
	  	    
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether it accepts any input other than numbers , - , + ,(),or not || It should not accept any input other than numbers , - , + ,(),")
	    
	    public void TC_EAF028() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF028");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether it accepts any input other than numbers , - , + ,(),or not");
			
			extentlogger.info("Expected_Results===>: It should not accept any input other than numbers , - , + ,(),");
	    	
	    	WebElement ph_no=driver.findElement(By.id(OR.getProperty("event_ms_phone_id")));
	    	
	    	ph_no.clear();
	  	    
	    	Thread.sleep(2000);
	  	    
	    	ph_no.sendKeys("+'- ,@#%$");
	        
	    	Thread.sleep(2000);
	        
	    	if (driver.findElement(By.xpath(OR.getProperty("event_ms_phone_error_xpath"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("event_ms_phone_error_xpath")));
					
					String err_msg_txt =err_msg.getText();
					
					System.out.println ("it is not accepted any input other than numbers and error message display is ==>: " +err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("its accepts any input other than numbers ");    		
	      	        }
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether year can be selected or not || Year should be possible to be selected from the calendar control")
	    
	    public void TC_EAF029() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF029");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether year can be selected or not");
			
			extentlogger.info("Expected_Results===>: Year should be possible to be selected from the calendar control");
	    	
	    	WebElement Dob=driver.findElement(By.id(OR.getProperty("event_ms_DOB_id")));
	    	
	    	Dob.clear();
	    	
	    	Dob.click();
	    	
	    	Thread.sleep(2000);
	    	WebElement yearDropdown=driver.findElement(By.className(OR.getProperty("event_ms_Dob_calYear_class")));
	    	
	    	yearDropdown.click();
	    	
	    	Thread.sleep(1000);
	    	
	    	//select one year
	    	WebElement yearDropdownvalue=driver.findElement(By.xpath(OR.getProperty("event_ms_Dob_calYearOption_xpath")));
	    	
	    	Thread.sleep(2000);
	    	
	    	Actions action=new Actions(driver);
	    	
	    	action.moveToElement(yearDropdownvalue).build().perform();
	    	
	    	Thread.sleep(1000);
	    	
	    	String actualval=yearDropdownvalue.getText();
	    	
	    	String expectedvalue="2016";
	    	
	    	Thread.sleep(1000);
	    	
	    	if(actualval.equals(expectedvalue))
	    	{
	    		System.out.println("***Year value is possible to select from the calendar control and Selected value in dropdown is===>:" +actualval);
	    	}
	    	else
	    	{
	    		System.out.println("***Selected value in dropdown is not equals to expacted value***");	
	    	}	    			    
           }
	    
	     
	    @Test(enabled = false,
	    		description = "Check whether Month can be selected or not || Month should be possible to be selected from the calendar control")
	    
	    public void TC_EAF030() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF030");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether Month can be selected or not");
			
			extentlogger.info("Expected_Results===>: Month should be possible to be selected from the calendar control");
	    	
	    	WebElement Dob=driver.findElement(By.id(OR.getProperty("event_ms_DOB_id")));
	    	
	    	Dob.clear();
	    	
	    	Dob.click();
	    	
	    	Thread.sleep(2000);
	    	
	    	WebElement cureentMonth=driver.findElement(By.xpath(OR.getProperty("event_ms_Dob_calYearCurrentMonth_xapth")));
	    	
	    	String cureentMonthText=cureentMonth.getText();

	    	Thread.sleep(1000);
	    	
	    	//select one year
	    	WebElement NextMonthBtn=driver.findElement(By.xpath(OR.getProperty("event_ms_Dob_calYearNextMonthBtn_xpath")));
	    	
	    	//click on the next months btn
	    	NextMonthBtn.click();	    	
	    	
	    	Thread.sleep(2000);
	    	
	    	String cureentMonthTextAfterclick=cureentMonth.getText();

	    	Thread.sleep(1000);
	    	
	    	if(!cureentMonthText.equals(cureentMonthTextAfterclick))
	    	{
	    		System.out.println("***Months is possible to select from the calendar control***");
	    	}
	    	else
	    	{
	    		System.out.println("Months is not possible to select from the calendar control ***");
	    	}
	    	    	    			    
           }
	     
	    
	    @Test(enabled = false,
	    		description = "Check whether a particular day can be selected or not || Day should should be possible to be selected from the calendar control")
	    
	    public void TC_EAF031() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF031");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether a particular day can be selected or not");
			
			extentlogger.info("Expected_Results===>: Day should should be possible to be selected from the calendar control");
	    	
	    	
			WebElement Dob=driver.findElement(By.id(OR.getProperty("event_ms_DOB_id")));
	    	
			Dob.clear();
	    	
			Dob.click();
	    	
			Thread.sleep(2000);
	    	
			WebElement date=driver.findElement(By.xpath(OR.getProperty("event_ms_Dob_date_xpath")));
	    	
			date.click();
	    	
			String Dob1=Dob.getAttribute("value");
	    	
			System.out.println("****User is able to select Possible date and selected particular date is===>:"+ Dob1);
	    	
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether year can be selected or not || Year should be possible to be selected from the calendar control")
	    
	    public void TC_EAF032() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF032");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether year can be selected or not");
			
			extentlogger.info("Expected_Results===>: Year should be possible to be selected from the calendar control");
	    	
	    	//click on the graduation date field
	    	WebElement graduationDate=driver.findElement(By.id(OR.getProperty("event_ms_graduationDate_id")));
	    	
	    	graduationDate.clear();
	    	
	    	graduationDate.click();
	    	
	    	Thread.sleep(2000);
	    	
	    	WebElement yearDropdown=driver.findElement(By.className(OR.getProperty("event_ms_Dob_calYear_class")));
	    	
	    	yearDropdown.click();
	    	
	    	Thread.sleep(1000);
	    	
	    	//select one year
	    	WebElement yearDropdownvalue=driver.findElement(By.xpath(OR.getProperty("event_ms_Dob_calYearOption_xpath")));
	    	
	    	Thread.sleep(2000);

	    	Actions action=new Actions(driver);
	    	
	    	action.moveToElement(yearDropdownvalue).build().perform();
	    	
	    	Thread.sleep(1000);
	    	
	    	String actualval=yearDropdownvalue.getText();
	    	
	    	String expectedvalue="2016";

	    	Thread.sleep(1000);
	    	
	    	if(actualval.equals(expectedvalue))
	    	{
	    		System.out.println("***Anticipated GraduationDate Year value is possible to select from the calendar control and Selected value in dropdown is===>:" +actualval);
	    	}
	    	else
	    	{
	    		System.out.println("***Anticipated GraduationDate Selected value in dropdown is not equals to expacted value****");	
	    	}	    			    	    	   	
           }
	    
	     
	    @Test(enabled = false,
	    		description = "Check whether Month can be selected or not || Month should be possible to be selected from the calendar control")
	    
	    public void TC_EAF033() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF033");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether Month can be selected or not");
			
			extentlogger.info("Expected_Results===>: Month should be possible to be selected from the calendar control");
	    	
	    	//click on the graduation date field
	    	WebElement graduationDate=driver.findElement(By.id(OR.getProperty("event_ms_graduationDate_id")));
	    	
	    	graduationDate.clear();
	    	
	    	graduationDate.click();
	    	
	    	Thread.sleep(2000);
	    	
	    	WebElement cureentMonth=driver.findElement(By.xpath(OR.getProperty("event_ms_Dob_calYearCurrentMonth_xapth")));
	    	
	    	String cureentMonthText=cureentMonth.getText();

	    	Thread.sleep(1000);
	    	
	    	//select one year
	    	WebElement NextMonthBtn=driver.findElement(By.xpath(OR.getProperty("event_ms_Dob_calYearNextMonthBtn_xpath")));
	    	
	    	//click on the next months btn
	    	NextMonthBtn.click();	    	
	    	
	    	Thread.sleep(2000);
	    	
	    	String cureentMonthTextAfterclick=cureentMonth.getText();

	    	Thread.sleep(1000);
	    	
	    	if(!cureentMonthText.equals(cureentMonthTextAfterclick))
	    	{
	    		System.out.println("***Anticipated GraduationDate Months is possible to select from the calendar control***");
	    	}
	    	else
	    	{
	    		System.out.println("Anticipated GraduationDate Months is not possible to select from the calendar control***");
	    	}
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether a particular day can be selected or not || Day should should be possible to be selected from the calendar control")
	    
	    public void TC_EAF034() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF034");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether a particular day can be selected or not");
			
			extentlogger.info("Expected_Results===>: Day should should be possible to be selected from the calendar control");
	    	
	    	//click on the graduation date field
	    	WebElement graduationDate=driver.findElement(By.id(OR.getProperty("event_ms_graduationDate_id")));
	    	
	    	graduationDate.clear();
	    	
	    	graduationDate.click();
	    	
	    	Thread.sleep(2000);
	    	
	    	WebElement date=driver.findElement(By.xpath(OR.getProperty("event_ms_Dob_date_xpath")));
	    	
	    	date.click();
	    	
	    	String gradDate=graduationDate.getAttribute("value");
	    	
	    	System.out.println("***User is able to select Possible date and selected particular date is===>:"+ gradDate);
	    	
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether number accepting in this field or not || No numeric number other than alphabet character should accept")
	    
	    public void TC_EAF035() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF035");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether number accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: No numeric number other than alphabet character should accept");
	    	
	    	WebElement schoolname=driver.findElement(By.id(OR.getProperty("event_ms_schoolN_id")));
	    	
	    	schoolname.clear();
	  	    
	    	Thread.sleep(2000);
	  	    
	    	schoolname.sendKeys("123",Keys.TAB);

	    	String schoolname_val=driver.findElement(By.id(OR.getProperty("event_ms_schoolN_id"))).getAttribute("value");
	  		
	    	System.out.println("it is accepting number value, accepted value is===>:" +schoolname_val); 
	          
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether special character accepting in this field or not || Nothing other than alphabet character should accept")
	    public void TC_EAF036() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF036");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether special character accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: Nothing other than alphabet character should accept");
	    	
	    	WebElement schoolname=driver.findElement(By.id(OR.getProperty("event_ms_schoolN_id")));
	    	
	    	schoolname.clear();
	  	    
	    	Thread.sleep(2000);
	  	    
	    	schoolname.sendKeys("ravi@#$1",Keys.TAB);
	  	    
	    	Thread.sleep(2000);
	  	    
	    	String schoolname_val=driver.findElement(By.id(OR.getProperty("event_ms_schoolN_id"))).getAttribute("value");
	  		
	    	System.out.println("it is accepting special character value, accepted special character school name is===>:" +schoolname_val); 
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether it accepts all types variable input or not || Field should accepts all types variable input  like characters, numeric, alphanumeric")
	    
	    public void TC_EAF037() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF037");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether it accepts all types variable input or not");
			
			extentlogger.info("Expected_Results===>: Field should accepts all types variable input  like characters, numeric, alphanumeric");
	    	
	    	WebElement schooladdress=driver.findElement(By.id(OR.getProperty("event_ms_schooladdress_id")));
	    	
	    	schooladdress.clear();
	  	    
	    	Thread.sleep(2000);
	  	    
	    	schooladdress.sendKeys("Delhi1233",Keys.TAB);
	  	    
	    	Thread.sleep(2000);
	  	    
	    	String schooladdress_val=driver.findElement(By.id(OR.getProperty("event_ms_schooladdress_id"))).getAttribute("value");
	  		
	    	System.out.println("it is accepts all types variable input like characters, numeric, alphanumeric and accepted value is===>:" +schooladdress_val); 
           }
	    
	     
	    @Test(enabled = false,
	    		description = "Check that other than the below characters are allowed in the address field or not\n" + "# ' . , - / || Other than the below characters should not be allowed in the address field# ' . , - /")
	    public void TC_EAF038() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF038");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check that other than the below characters are allowed in the address field or not\\n\" + \"# ' . , - / ");
			
			extentlogger.info("Expected_Results===>: Other than the below characters should not be allowed in the address field# ' . , - /");
	    	
	    	WebElement schooladdress=driver.findElement(By.id(OR.getProperty("event_ms_schooladdress_id")));
	    	
	    	schooladdress.clear();
	  	    
	    	Thread.sleep(2000);
	  	    
	    	schooladdress.sendKeys("@##$%_+",Keys.TAB);
	  	    
	    	Thread.sleep(2000);
	  	    
	    	String schooladdress_val=driver.findElement(By.id(OR.getProperty("event_ms_schooladdress_id"))).getAttribute("value");
	  		
	    	System.out.println("*** Accepted value is===>:" +schooladdress_val); 
           }
	    
	     
	    @Test(enabled = false,
	    		description = "Check whether it accepts all types variable input or not || Field should accepts all types variable input  like characters, numeric, alphanumeric")
	    
	    public void TC_EAF039() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF039");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether it accepts all types variable input or not");
			
			extentlogger.info("Expected_Results===>: Field should accepts all types variable input  like characters, numeric, alphanumeric");
	    	
	    	WebElement schooladdress2=driver.findElement(By.id(OR.getProperty("event_ms_school_st_address2_id")));
	    	
	    	schooladdress2.clear();
	  	    
	    	Thread.sleep(2000);
	  	    
	    	schooladdress2.sendKeys("Delhi12_n",Keys.TAB);
	  	    
	    	Thread.sleep(2000);
	  	    
	    	String schooladdress2_val=driver.findElement(By.id(OR.getProperty("event_ms_school_st_address2_id"))).getAttribute("value");
	  		
	    	System.out.println("it is accepts all types variable input and accepted value is==>: " +schooladdress2_val); 
           }
	    
	     
	    @Test(enabled = false,
	    		description = "Check that other than the below characters are allowed in the address field or not\n" + "# ' . , - / || Other than the below characters should not be allowed in the address field# ' . , - /")
	    
	    public void TC_EAF040() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF040");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check that other than the below characters are allowed in the address field or not\\n\" + \"# ' . , - / ");
			
			extentlogger.info("Expected_Results===>: Other than the below characters should not be allowed in the address field# ' . , - /");
	    	
	    	WebElement schooladdress2=driver.findElement(By.id(OR.getProperty("event_ms_school_st_address2_id")));
	    	
	    	schooladdress2.clear();
	  	    
	    	Thread.sleep(2000);
	  	    
	    	schooladdress2.sendKeys("Noida@#?3",Keys.TAB);
	  	    
	    	Thread.sleep(2000);
	  	    
	    	String schooladdress2_val=driver.findElement(By.id(OR.getProperty("event_ms_school_st_address2_id"))).getAttribute("value");
	  		
	    	System.out.println("it is all types variable input like characters, numeric, alphanumeric and accepted value is===>: " +schooladdress2_val); 
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether number accepting in this field or not || No numeric number other than alphabet character should accept")
	    
	    public void TC_EAF041() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF041");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether number accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: No numeric number other than alphabet character should accept");
	    	
	  	    WebElement sch_city = driver.findElement(By.id(OR.getProperty("event_ms_schoolcity_id")));
	  	    
	  	    sch_city.clear();
	  	    
	  	    Thread.sleep(2000);
	    	
	  	    sch_city.sendKeys("123");
	        
	  	    Thread.sleep(2000);
	        
	  	    if (driver.findElement(By.xpath(OR.getProperty("event_ms_schoolcity_error_xpath"))).isDisplayed())
            {
				WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("event_ms_schoolcity_error_xpath")));
				
				String err_msg_txt =err_msg.getText();
				
				System.out.println (err_msg_txt);
		    }
            	else
            	{
      	    	System.out.println("School City field allowed to enter number value");    		
      	        }
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether special character accepting in this field or not || Nothing other than alphabet character should accept")
	    
	    public void TC_EAF042() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF042");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether special character accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: Nothing other than alphabet character should accept");
	    	
	  	    WebElement sch_city = driver.findElement(By.id(OR.getProperty("event_ms_schoolcity_id")));
	  	    
	  	    sch_city.clear();
	  	    
	  	    Thread.sleep(2000);
	    	
	  	    sch_city.sendKeys("schoolcity_delhi@");
	        
	  	    Thread.sleep(2000);
	        
	  	    if (driver.findElement(By.xpath(OR.getProperty("event_ms_schoolcity_error_xpath"))).isDisplayed())
            {
				WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("event_ms_schoolcity_error_xpath")));
				
				String err_msg_txt =err_msg.getText();
				
				System.out.println (err_msg_txt);
		    }
            	else
            	{
      	    	System.out.println("School City field allowed to enter special character value");    		
      	        }
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether special character accepting in this field or not || Nothing other than alphabet character should accept")
	    
	    public void TC_EAF046() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF046");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether special character accepting in this field or not");
			
			extentlogger.info("Expected_Results===>: Nothing other than alphabet character should accept");
	    	
	  	    WebElement mex_sum_schoolstate = driver.findElement(By.id(OR.getProperty("event_ms_schoolstate_id")));
	  	    
	  	    mex_sum_schoolstate.clear();
	  	    
	  	    Thread.sleep(2000);
	  	    
	  	    mex_sum_schoolstate.sendKeys("Delhi#%$$%6@");
	        
	  	    Thread.sleep(3000);
	        
	  	    if (driver.findElement(By.xpath(OR.getProperty("event_ms_schoolstate_error_xpath"))).isDisplayed())
	            {
					WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("event_ms_schoolstate_error_xpath")));
					
					String err_msg_txt =err_msg.getText();
					
					System.out.println ("Error message display is: " +err_msg_txt);
			    }
	            	else
	            	{
	      	    	System.out.println("school state field allowed allow to enter special character");    		
	      	        }
           }
	    
	     
	    @Test(enabled = false,
	    		description = "Check whether Country Field is made as drop down or not || Country Field should be made as drop down")
	    
	    public void TC_EAF050() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF050");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether Country Field is made as drop down or not");
			
			extentlogger.info("Expected_Results===>: Country Field should be made as drop down");
	    	
	    	WebElement drp=driver.findElement(By.id(OR.getProperty("event_ms_schoolCountry_id")));

	    	Select select=new Select(drp);
	  	    
	    	drp.click();
	  	    
	    	select.selectByValue("Andorra");
	  	    
	    	Thread.sleep(3000);
	  	    
	    	WebElement option=select.getFirstSelectedOption();
	  	    
	    	String selectedValueInDropDown = option.getText();
	  	    
	    	System.out.println ("SchoolCountry Field is made as drop down and slected dropdown value is:"+selectedValueInDropDown);
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether user can select respective country from the drop down or not || It should be possible for user to select respective country from the drop down")
	    
	    public void TC_EAF051() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF051");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether user can select respective country from the drop down or not");
			
			extentlogger.info("Expected_Results===>: It should be possible for user to select respective country from the drop down");
	    	
	    	WebElement drp=driver.findElement(By.id(OR.getProperty("event_ms_schoolCountry_id")));
	    	
	    	Select select=new Select(drp);
	  	    
	    	drp.click();
	  	    select.selectByValue("India");
	  	    
	  	    Thread.sleep(3000);
	  	    
	  	    WebElement option=select.getFirstSelectedOption();
	  	    
	  	    String selectedValueInDropDown = option.getText();
	  	    
	  	    System.out.println ("User is able to select respective country and selected country is :"+selectedValueInDropDown);
           }
	    
	    
	     //-==========Pending 54 below test case  
	    @Test(enabled = true,
	    		description = "Check whether other than word or PDF doc can be possible to be uploaded or not || Other than word or PDF doc should not be possible to be uploaded")
	    
	    public void TC_EAF054() throws InterruptedException, IOException 
	    { 	    	
	    	extentlogger = extentreport.createTest("TC_EAF054");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether other than word or PDF doc can be possible to be uploaded or not");
			
			extentlogger.info("Expected_Results===>: Other than word or PDF doc should not be possible to be uploaded");
	    	
	    	try {
	    	    Robot robot = new Robot();

	    	    for(int i=0; i<30; i++) {
	    	        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	    	    }

	    	} catch (AWTException e1) {
	    	  
	    	   e1.printStackTrace();
	    	}
	    	
	    	WebElement scholarshchk = driver.findElement(By.xpath(OR.getProperty("event_ms_scholarship_chk_xpath")));

	    	Thread.sleep(5000);
	    	
	    	scholarshchk.click();
		    
	    	Thread.sleep(4000);
		    
	    	WebElement fileuplodlink=driver.findElement(By.id(OR.getProperty("event_ms_Transcript_fileupld_id")));
		    
	    	fileuplodlink.click();
		    
	    	Thread.sleep(1000);
		    	
		    Runtime.getRuntime().exec("C:\\Users\\user\\Downloads\\AutoIt\\EventSchFile.exe");
		    
		    Thread.sleep(1000);
		    
		    System.out.println("**User can able to upload file Word or PDF format");		     	
	    	
			// Added sleep to make you see the difference.
			Thread.sleep(1000);

	  	     driver.navigate().refresh();
	  	     
	  	     Alert alert = driver.switchTo().alert();
	  	     
	  	     alert.accept();
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether number of students and number adults field implemented as drop down or not || Number of students and number adults field should be implemented as drop down and not as text box")
	    
	    public void TC_EAF055() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF055");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether number of students and number adults field implemented as drop down or not");
			
			extentlogger.info("Expected_Results===>: Number of students and number adults field should be implemented as drop down and not as text box");
	    	
	    	WebElement financialaid_chk=driver.findElement(By.xpath(OR.getProperty("event_ms_financialaid_chk_xpath")));
	    	
	    	Thread.sleep(2000);	    	
	    	
	    	if(financialaid_chk.isSelected());
	    	{
	    		financialaid_chk.click();  
	    		
	    		WebElement financialaid_NoOfchild_drpdown=driver.findElement(By.xpath(OR.getProperty("event_ms_financialaid_numOfChild_dropd_xpath")));
	    		
	    		financialaid_NoOfchild_drpdown.click();
	    		
	    		Thread.sleep(2000);
	    		
	    		WebElement financialaid_NoOfadult_drpdown=driver.findElement(By.xpath(OR.getProperty("event_ms_financialaid_dropd_numOfAdult_xpath")));
	    		
	    		financialaid_NoOfadult_drpdown.click();
	    		
	    		Thread.sleep(2000);
	    		
	    		System.out.println("***Number of students and number of adults field implemented as drop down***");
	    	}	
	    	
	        driver.navigate().refresh();
	  	    
	        Alert alert = driver.switchTo().alert();
	  	    
	        alert.accept();
	  	   
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check whether Financial Aid checkbox functionality working or not || user should able to select Financial Aid check box.")
	    
	    public void TC_EAF056() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF056");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check whether Financial Aid checkbox functionality working or not");
			
			extentlogger.info("Expected_Results===>: User should able to select Financial Aid check box.");
	    	
	    	WebElement financialaid_chk=driver.findElement(By.xpath(OR.getProperty("event_ms_financialaid_chk_xpath")));
	    	
	    	financialaid_chk.click();
	    	
	    	Thread.sleep(1000);	    	
	    	
	    	if(financialaid_chk.isSelected());
	    	{
	    		System.out.println("user is able to select financialaid checkbox");
	    	}
	    	
           }
	    
	    
	    @Test(enabled = false,
	    		description = "Check that Privacy Policy checkbox button functionality working or not || After clicking on the checkbox ,It should be possible for user to select checkBox")
	    
	    public void TC_EAF057() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF057");
			
	   		extentlogger.info("Events_Test_Scenario===>: Check that Privacy Policy checkbox button functionality working or not");
			
			extentlogger.info("Expected_Results===>: After clicking on the checkbox ,It should be possible for user to select checkBox");
	    	
	    	WebElement PrivacyPolicyid_chk=driver.findElement(By.id(OR.getProperty("event_ms_privacypolicy_chk_id")));
	    	
	    	PrivacyPolicyid_chk.click();
	    	
	    	Thread.sleep(1000);	    	
	    	
	    	if(PrivacyPolicyid_chk.isSelected());
	    	{
	    		System.out.println("user is able to select Privacy Policy checkbox");
	    	}	    		  	    
           }
	    
	     
	    @Test(enabled = false,
	    		description = "Checking the Terms of Service checkbox functionality working or not || After click on the Terms of Service checkbox ,Selected checkbox should be successfully checked.")
	    
	    public void TC_EAF058() throws InterruptedException 
	    { 
	    	extentlogger = extentreport.createTest("TC_EAF058");
			
	   		extentlogger.info("Events_Test_Scenario===>: Checking the Terms of Service checkbox functionality working or not");
			
			extentlogger.info("Expected_Results===>: After click on the Terms of Service checkbox ,Selected checkbox should be successfully checked.");
	    	
	    	WebElement term_of_service_chk=driver.findElement(By.id(OR.getProperty("event_ms_term-of-service_chk_id")));
	    	
	    	term_of_service_chk.click();
	    	
	    	Thread.sleep(1000);	    	
	    	
	    	if(term_of_service_chk.isSelected());
	    	{
	    		System.out.println("user is able to select term-of-service checkbox");
	    	}	    		  	    
	  	    
	  	  Log.info("Events module test case Ended !!!");
           }
	    
  
  
	    @AfterTest
	    public void callTearDown() {
	    	
	    	Events.tearDown();
	    }
	    
	    
	    @AfterSuite
	    public void storeReport() {
	    	Events.captureReport();
	    }
}

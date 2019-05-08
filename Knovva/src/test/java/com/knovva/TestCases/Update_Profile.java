package com.knovva.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import com.knovva.utilities.Log;

public class Update_Profile extends TestBase_Knovva
{
	
	@BeforeSuite
	public void callSetup() {
		
		Update_Profile.setUp();
	}
	
	
	@BeforeTest
	public void callBrowser() {
		
		Update_Profile.browserLaunch();
	}
	  
	
	
   @Test(enabled = false,
		   description = "Check whether the information saved same as provided by the time of registration or not || All the same values should be saved and displayed")
   
  public void TC_UP001() throws InterruptedException 
  {
	   	Log.info("Login test case started !!!");
   	
   		extentlogger = extentreport.createTest("TC_UP001");
		
   		extentlogger.info("UpdateProfile_Test_Scenario===>: Check whether the information saved same as provided by the time of registration or not");
		
		extentlogger.info("Expected_Results===>: All the same values should be saved and displayed");
	   
		Thread.sleep(1000);
	    
		WebElement profile=driver.findElement(By.xpath(OR.getProperty("profile_xpath"))); 		
	    
		Actions action = new Actions(driver);
        
		action.moveToElement(profile).build().perform();
        
		Thread.sleep(5000);
        
		profile.click();
		
		Thread.sleep(2000);
	    
		String Ed_profile_FN = driver.findElement(By.xpath(OR.getProperty("ep_fname_xpath"))).getAttribute("value");
	    
		String Ed_profile_LN = driver.findElement(By.xpath(OR.getProperty("ep_lname_xpath"))).getAttribute("value");
	    
		String Ed_profile_mail = driver.findElement(By.xpath(OR.getProperty("ep_email_xpath"))).getAttribute("value");
        
		Thread.sleep(2000);
	    
		if(Ed_profile_FN.equals("ravi") && Ed_profile_LN.equals("kumar") && Ed_profile_mail.equals("ravi.kumar@cbnits.com")) 
	    {
	    	System.out.println("**All the values are same and value is==>: \n" +Ed_profile_FN+ "\n" +Ed_profile_LN+ "\n" + Ed_profile_mail + "\n");
	    }
		
	    else
	    {
	    	System.out.println("All the values or partial values are not same");
	    }
   }
   
  
   @Test(enabled = false,
		   description = "Check whether email field is enabled or disabled || Email field should be disabled")
   
   public void TC_UP002() throws InterruptedException, AWTException 
   {
	   	extentlogger = extentreport.createTest("TC_UP002");
		
  		extentlogger.info("UpdateProfile_Test_Scenario===>: Check whether email field is enabled or disabled");
		
		extentlogger.info("Expected_Results===>: Email field should be disabled");
	   
 		Thread.sleep(2000);
 		
 		Robot robot=new Robot();
 		
 		robot.keyPress(KeyEvent.VK_DOWN);
 		
 		robot.keyRelease(KeyEvent.VK_DOWN);
 		
 		WebElement Ed_profileEmail=driver.findElement(By.xpath(OR.getProperty("ep_email_xpath")));
 	    
 		Thread.sleep(2000);
		
 		if(Ed_profileEmail.isEnabled())
		{
			System.out.println("Email field is enable");
		}
 		
		else 
		{
			System.out.println("Email field is not enable");
		}
   }
   
    
   @Test(enabled = false,
		   description = "Check whether first name field is enabled or disabled || First Name field should be enabled")
   
   public void TC_UP003() throws InterruptedException 
   {	    	    
	   	extentlogger = extentreport.createTest("TC_UP003");
		
  		extentlogger.info("UpdateProfile_Test_Scenario===>: Check whether first name field is enabled or disabled");
		
		extentlogger.info("Expected_Results===>: First Name field should be enabled");
	   
 		Thread.sleep(1000);
 		
 		driver.findElement(By.xpath(OR.getProperty("ep_fname_xpath"))).isEnabled();
 		
 		System.out.println("First name field is enable");
 		
   }
   
    
   @Test(enabled = false,
		   description = "Check whether last name field is enabled or disabled || Last Name field should be enabled")
   
   public void TC_UP004() throws InterruptedException 
   { 	    
	  	extentlogger = extentreport.createTest("TC_UP004");
		
  		extentlogger.info("UpdateProfile_Test_Scenario===>: Check whether last name field is enabled or disabled");
		
		extentlogger.info("Expected_Results===>: Last Name field should be enabled");
	   
 		Thread.sleep(1000);
 		
 		driver.findElement(By.xpath(OR.getProperty("ep_lname_xpath"))).isEnabled();
 		
 		System.out.println("Last name field is enable");
 		
   }
   
      
   @Test(enabled = false,
		   description = "Check whether age field is enabled or disabled || Age field should be enabled")
   public void TC_UP005() throws InterruptedException 
   {
	   	extentlogger = extentreport.createTest("TC_UP005");
		
  		extentlogger.info("UpdateProfile_Test_Scenario===>: Check whether age field is enabled or disabled");
		
		extentlogger.info("Expected_Results===>: Age field should be enabled");
	   
		Thread.sleep(1000);
 		
		WebElement age=driver.findElement(By.xpath(OR.getProperty("ep_age_xpath")));
 		
		//click on the age field 
 		age.click();
 		
 		//check age field enabled or not
 		if(age.isEnabled())
 		{ 			
 		   System.out.println("**Age field is enabled**"); 	
 		}
 		
 		else
 		{
 		 System.out.println("Age field is not enabled "); 
 		}
   }
   
    
   @Test(enabled = false,
		   description = "Check whether School field is enabled or disabled || School field should be enabled")
   
   public void TC_UP006() throws InterruptedException 
   {
	   	extentlogger = extentreport.createTest("TC_UP006");
		
  		extentlogger.info("UpdateProfile_Test_Scenario===>: Check whether School field is enabled or disabled");
		
		extentlogger.info("Expected_Results===>: School field should be enabled");
	   
	   //click on school tag link
 		driver.findElement(By.xpath(OR.getProperty("ep_schooltext_xpath"))).click(); 		
 		
 		Thread.sleep(1000);
 		
 		driver.findElement(By.xpath(OR.getProperty("ep_school_textbox_xpath"))).isEnabled();
 		
 		System.out.println("**School name field is enabled**"); 
   }
   
    
   @Test(enabled = false,
		   description = "Check whether Country field is enabled or disabled || Country field should be enabled")
   
   public void TC_UP007() throws InterruptedException 
   {
	   extentlogger = extentreport.createTest("TC_UP007");
		
  		extentlogger.info("UpdateProfile_Test_Scenario===>: Check whether Country field is enabled or disabled");
		
		extentlogger.info("Expected_Results===>: Country field should be enabled");
	   
	    WebElement gentxt= driver.findElement(By.xpath(OR.getProperty("ep_generaltext_xpath")));
	    
	    gentxt.click();
 		
	    Thread.sleep(1000);
 		
	    WebElement country=driver.findElement(By.xpath(OR.getProperty("ep_country_xpath")));
 		
	    country.click();
 		
	    Thread.sleep(1000);
 		
	    if(country.isEnabled())
 		{
 			System.out.println("**Country field is enabled**");
 		}
	    
 		else
 		{
 			System.out.println("Country field is not enabled");
 		}
   }
   
     
 	@Test(enabled = false,
 			description = "Check whether State field is enabled or disabled || State field should be enabled")
 	
    public void TC_UP008() throws InterruptedException 
 	   {
 			extentlogger = extentreport.createTest("TC_UP008");
		
 			extentlogger.info("UpdateProfile_Test_Scenario===>: Check whether State field is enabled or disabled");
		
 			extentlogger.info("Expected_Results===>: State field should be enabled");	
 			
 			driver.findElement(By.xpath(OR.getProperty("profile_xpath"))).click();
 	 		
 			Thread.sleep(2000);
 	 		
 			WebElement statefield=driver.findElement(By.xpath(OR.getProperty("ep_state_xpath")));
 	 		
 			statefield.click();
 	 		
 	 		Thread.sleep(1000);
 	 		
 	 		if(statefield.isEnabled())
 	 		{
 	 			System.out.println("**State field is enabled**");
 	 		}
 	 		
 	 		else
 	 		{
 	 			System.out.println("State field is not enabled");
 	 		}
 	   }
 	
 	  
 	@Test(enabled = false,
 			description = "Check whether zip field is enabled or disabled")
 	
    public void TC_UP009() throws InterruptedException 
 	   {
 			extentlogger = extentreport.createTest("TC_UP009");
		
 			extentlogger.info("UpdateProfile_Test_Scenario===>: Check whether zip field is enabled or disabled");
		
 			extentlogger.info("Expected_Results===>: Zip field should be enabled");	
 		
 	 		//Thread.sleep(2000);
 	 		WebElement zipcodefield=driver.findElement(By.name(OR.getProperty("ep_zip_name")));
 	 		
 	 		zipcodefield.click();
 	 		
 	 		Thread.sleep(1000);
 	 		
 	 		if(zipcodefield.isEnabled())
 	 		{
 	 			System.out.println("**Zipcode field is enabled");
 	 		}
 	 		
 	 		else
 	 		{
 	 			System.out.println("Zipcode field is not enabled");
 	 		}
 	   }
 	
 	  
 	 @Test(enabled = true,
 			 description = "Check whether user able to select the Valid date(Before current date) || Should be able to select")
 	 
     public void TC_UP010() throws InterruptedException 
 	   {
 		 	extentlogger = extentreport.createTest("TC_UP010");
		
 		 	extentlogger.info("UpdateProfile_Test_Scenario===>: Check whether user able to select the Valid date(Before current date)");
		
 		 	extentlogger.info("Expected_Results===>: Should be able to select");	
 		 
 	 		Thread.sleep(1000);

 	 		WebElement DoBFieldClick=driver.findElement(By.xpath(OR.getProperty("ep_age_xpath")));
 	 		
 	 		DoBFieldClick.click();
 	 		
 	 		Thread.sleep(2000);
 	 		
 	 	    //Get Today's number
 	        DateFormat dateFormat2 = new SimpleDateFormat("dd"); 
            Date date2 = new Date();
            String today = dateFormat2.format(date2); 
            System.out.println("***today date is ====>:" +today);
            
 	        List<WebElement> columns = driver.findElements(By.xpath(OR.getProperty("ep_age_selectDtaeList_xpath")));
 	        
 	        //DatePicker is a table. Thus we can navigate to each cell
 	        //and if a cell matches with the current date then we will click it.
 	        for(WebElement cell: columns) {
 	        	
 	            if (cell.getAttribute("innerText").contains(today)) {
 	                cell.click();
 	                Thread.sleep(4000);
 	               System.out.println("***User is able to select valid date**");
 	                break;
 	            }
 	        }
 	 
 	        //Wait for 2 Seconds to see Today's date selected.
 	        try {
 	            Thread.sleep(2000);
 	            
 	        } catch (InterruptedException e) {
 	        	
 	            e.printStackTrace();
 	        } 	 	
 	   }
 	 
 	 
 	 @Test(enabled = true,
 			 description = "Check whether user able to select the invalid date(Current/future date) || Error message should get appear")
 	 
     public void TC_UP011() throws InterruptedException 
 	   {
 		 	extentlogger = extentreport.createTest("TC_UP011");
		
 		 	extentlogger.info("UpdateProfile_Test_Scenario===>: Check whether user able to select the invalid date(Current/future date)");
		
 		 	extentlogger.info("Expected_Results===>: Error message should get appear");	
 		 
 	 		Thread.sleep(1000);
 	 		
 	 		WebElement DoBFieldClick=driver.findElement(By.xpath(OR.getProperty("ep_age_xpath")));
 	 		
 	 		DoBFieldClick.click();
 	 		
 	 		Thread.sleep(2000);
 	 		
 	 	    //Get Today's number
 	        DateFormat dateFormat2 = new SimpleDateFormat("dd"); 
            
 	        Date date2 = new Date();
            
 	        String today = dateFormat2.format(date2); 
 	         
 	 		//This is the columns of the from date picker table
 	        List<WebElement> columns = driver.findElements(By.xpath(OR.getProperty("ep_age_selectDtaeList_xpath")));
 	        
 	        //System.out.println("All list value is*****" +columns);
 	        //DatePicker is a table. Thus we can navigate to each cell
 	        //and if a cell matches with the current date then we will click it.
 	        for (WebElement cell: columns) {
 	        	
 	            if (cell.getAttribute("innerText").contains(today)) {
 	            	
 	                cell.click();
 	                
 	                Thread.sleep(5000); 	                
 	               if (driver.findElement(By.xpath(OR.getProperty("ep_dob_errer_msg"))).isDisplayed())
 		            {
 						WebElement err_msg=driver.findElement(By.xpath(OR.getProperty("ep_dob_errer_msg")));
 						
 						String err_msg_txt =err_msg.getText();
 						
 						System.out.println ("**When user select invalid date Error message is display***===>:" +err_msg_txt);
 				    } 	                
 	                break;
 	            }
 	        } 	 
 	        //Wait for 4 Seconds to see Today's date selected.
 	        try {
 	        	
 	            Thread.sleep(2000);
 	            
 	        } catch (InterruptedException e) {
 	        	
 	            e.printStackTrace();
 	        } 	 	
 	   }
 	  	
 	
 	@Test(enabled = false,
 			description = "Check that drop field implemented for country field or not")
    public void TC_UP012() throws InterruptedException 
    {
 		extentlogger = extentreport.createTest("TC_UP012");
		
   		extentlogger.info("UpdateProfile_Test_Scenario===>: Check that drop field implemented for country field or not");
		
		extentlogger.info("Expected_Results===>: Country field should have drop down field");
 		
 		WebElement countrydrp=driver.findElement(By.xpath(OR.getProperty("ep_country_xpath")));
    	
 		Select select=new Select(countrydrp);
    	
 		countrydrp.click();
  	    
 		select.selectByValue("Andorra");
  	    
 		Thread.sleep(2000);
  	    
 		WebElement option=select.getFirstSelectedOption();
  	    
 		String selectedValueInDropDown = option.getText();
  	    
 		System.out.println ("Country Field is made as drop down and slected dropdown value is===>:"+selectedValueInDropDown);
  	    
 		driver.navigate().refresh();
    }
 	
 	 	
 	  
 	 @Test(enabled = false,
 			 description = "Check by adding class codes with invalid input || It should display alert message")
 	 
 	  public void TC_UP019() throws InterruptedException 
 	   {
 		 	extentlogger = extentreport.createTest("TC_UP019");
		
 		 	extentlogger.info("UpdateProfile_Test_Scenario===>: Check by adding class codes with invalid input");
		
 		 	extentlogger.info("Expected_Results===>: It should display alert message");	
 		 
 		   //click on school tag link
 	 		driver.findElement(By.xpath(OR.getProperty("ep_schooltext_xpath"))).click(); 		
 	 		
 	 		Thread.sleep(1000);
 	 		
 	 		WebElement addnewCorcode=driver.findElement(By.xpath(OR.getProperty("ep_schooltext_AddNeCorCod_xpath")));
 	 		
 	 		//click on the add new course code
 	 		addnewCorcode.click();  
 	 		
 	 		WebElement KnovCourCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("ep_schtext_KnCourCodTxtbox_xpath")));
 	 		
 	 		KnovCourCodeTxtbox.clear();
 	 		
 	 		KnovCourCodeTxtbox.sendKeys(config.getProperty("WrongCoursecode_TC_UP019"));
 	 		
 	 		Thread.sleep(1000);
 	 		
 	 		WebElement KnovCourCodeSaveBtn=driver.findElement(By.xpath(OR.getProperty("ep_schtext_KnCourCod_savebtn_xpath")));
 	 		
 	 		KnovCourCodeSaveBtn.click();
 	 		
 	 		//click on save button and validate error message display or not
 	 		if(isElementPresent(By.className(OR.getProperty("ep_schtext_errorsmg_class"))))
 	 		{
 	 			Thread.sleep(1000);
 	 			
 	 			WebElement errormsg=driver.findElement(By.className(OR.getProperty("ep_schtext_errorsmg_class")));
 	 			
 	 			String errermsgst=errormsg.getText();
 	 			
 	 			System.out.println("Error message is display===>:" +errermsgst); 	 			
 	 		}
 	 		
 	 		else 
 	 		{
 	 			System.out.println("**Error message is not present**"); 
 	 		} 	 		
 	   }
 	 
 	 
 	@Test(enabled = false,
 			description = "Check by deleting existing class codes available")
 	
   	public void TC_UP020() throws InterruptedException 
	   {
 			extentlogger = extentreport.createTest("TC_UP020");
		
 			extentlogger.info("UpdateProfile_Test_Scenario===>: Check by deleting existing class codes available");
		
 			extentlogger.info("Expected_Results===>: Delete confirmation message should be shown before actual record delete");	
 		
 			//click on school tag link
 			Log.info("Update_Profile module test case Ended !!!");
	 		
 			driver.findElement(By.xpath(OR.getProperty("ep_schooltext_xpath"))).click(); 		
	 		
 			Thread.sleep(1000);	 		
	 		
 			WebElement Corcode_delBtn=driver.findElement(By.xpath(OR.getProperty("ep_schtxt_classcode_DelBtn_xpath")));
	 		
 			Thread.sleep(1000);
	 		
 			//check course code delete btn display or not
	 		if(Corcode_delBtn.isDisplayed()) 
	 		  {
	 			//click on the delete Btn
	 			Corcode_delBtn.click();
	 			
	 			Thread.sleep(1000);
	 			
	 			WebElement Corcode_delBtn_poperrorsmg=driver.findElement(By.xpath(OR.getProperty("ep_classcode_delBtn_popsmg_xpath")));
	 			
	 			String popmsg= Corcode_delBtn_poperrorsmg.getText();
	 			
	 			System.out.println("Delete confirmation message is display before the actual record deleted and message is==>:" +popmsg);	 			
	 	      }
	 		
	 		else 
	 		{
	 			System.out.println("**Course code delete button is not display**"); 
	 		}	
	 		
	 		Log.info("Update_Profile module test case Ended !!!");
	    }
 		
   
 	@AfterTest
    public void callTearDown() {
    	
 		Update_Profile.tearDown();
    }
    
    
    @AfterSuite
    public void storeReport() {
    	Update_Profile.captureReport();
    }
   
}


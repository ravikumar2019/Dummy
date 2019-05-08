package com.knovva.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import com.knovva.utilities.Log;

public class StudentClubsAppForm extends TestBase_Knovva
{  
	@BeforeSuite
	public void callSetup() {
		
		Login1.setUp();
	}
	
	
	@BeforeTest
	public void callBrowser() {
		
		Login1.browserLaunch();
	}
  
      @Test(description="Verify that the Preferred Name field is present or not")
	  public void TC_SC068() throws InterruptedException 
	  {
    	  Log.info("Login test case started !!!");
      	
      	extentlogger = extentreport.createTest("TC_SC068");
  		
      	extentlogger.info("Login_Test_Scenario===>: If email ID field is blank , given input for password field and then click on Signin button");
  		
  		extentlogger.info("Expected_Results===>:Login button should not be enabled");
    	  
    	  Log.info("StudentsClubsAppForm module test case Started !!!");
    	  TestBase_Knovva.ClickOnHamburgerMenu();
  		  Thread.sleep(1000); 
  		  WebElement StudentsClubs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_tab_xpath")));
  		  StudentsClubs.click();
  		  Thread.sleep(1000);
  		  
  		  //click on the student form link
  	   	  WebElement StudentSpotlight_SubApp=driver.findElement(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_SubApplication_xpath")));		
		  Thread.sleep(1000);		  		  		  
		  //StudentSpotlight_SubApp.click();
		  Actions builder = new Actions(driver);
	        builder.moveToElement(StudentSpotlight_SubApp).click(StudentSpotlight_SubApp);
	        builder.perform();
	        Thread.sleep(1000);
	        //WebElement Preferrednametextbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_Preferredname_name")));					  
  		  //Check the condition element present or not
  		if(isElementPresent(By.name(OR.getProperty("St_Clubs_AppForm_Preferredname_name")))) 
		  {
			  Thread.sleep(1000);
			  System.out.println("*Preferred name field is present in the form*");
		  }
		  else
		  {
			  System.out.println("**Preferred name field is not present in the form**");
		  }
	   }
      
      @Test(description="Verify that the Preferred Name field is enable or not")
	  public void TC_SC069() throws InterruptedException 
	  {
    	  Thread.sleep(1000);
    	  WebElement Preferrednametextbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_Preferredname_name")));
    	  if(Preferrednametextbox.isEnabled())
		  {
			  System.out.println("*Preferred name field is enable in the form*");
		  }
    	  else
		  {
			  System.out.println("**Preferred name field is not enable in the form**");
		  }    	  
	  }
      
      @Test(description="Verify that user is able to enter only numbers")
	  public void TC_SC070() throws InterruptedException 
	  {
    	  Thread.sleep(1000);
    	  WebElement Preferrednametextbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_Preferredname_name")));    	 
   		  Preferrednametextbox.sendKeys(config.getProperty("StCode_numOnly_SC008"));
   		  
   		  //click on the submit btn
   		WebElement SubmitBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_AppForm_submitbtn_xpath")));
   		SubmitBtn.click();
   		Thread.sleep(1000);
   		WebElement ErrormsgName=driver.findElement(By.className(OR.getProperty("St_Clubs_AppForm_errorMsg_className")));  
   		if(isElementPresent(By.className(OR.getProperty("St_Clubs_AppForm_errorMsg_className")))) 
		  {
			  Thread.sleep(1000);
			  System.out.println("*Error message display with the name is==>:*" +ErrormsgName.getText());
		  }
   		else
   		{
			  System.out.println("**Error message is not display**");
   		} 	
   		//driver.navigate().refresh();
   		//Thread.sleep(1000);
   		//Alert alert = driver.switchTo().alert();
   		//alert.accept();
	  }
  
      
      @Test(description="Verify that user able to enter only alphabets")
	  public void TC_SC071() throws InterruptedException 
	  {
    	  //click on the link
    	  //WebElement StudentSpotlight_SubAppLink=driver.findElement(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_SubApplication_xpath")));		
		 // Thread.sleep(2000);		  		  		  
		 // StudentSpotlight_SubAppLink.click();
		  
    	  Thread.sleep(1000);
    	  WebElement Preferrednametextbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_Preferredname_name")));
    	  //Preferrednametextbox.clear();
    	  ///for clear previous enter value
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	 // Preferrednametextbox.sendKeys(Keys.);
    	  Thread.sleep(1000);
   		  Preferrednametextbox.sendKeys(del,config.getProperty("StCode_alphabetsOnly_SC009"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only alphabets");	  
	  }
      
      @Test(enabled=false,description="Verify that user able to enter only special characters")
	  public void TC_SC072() throws InterruptedException 
	  {
    	  //click on the link
    	  //WebElement StudentSpotlight_SubAppLink=driver.findElement(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_SubApplication_xpath")));		
		  //Thread.sleep(2000);		  		  		  
		 // StudentSpotlight_SubAppLink.click();
		  
    	  Thread.sleep(1000);
    	  WebElement Preferrednametextbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_Preferredname_name")));
    	  //Preferrednametextbox.clear();
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
   		  Preferrednametextbox.sendKeys(del,config.getProperty("StCode_specialCharOnly_SC010"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only special characters");	  
	  }
      
      
      @Test(enabled=false,description="Verify that user able to enter only numbers and alphabets")
	  public void TC_SC073() throws InterruptedException 
	  {
		  
    	  Thread.sleep(1000);
    	  WebElement Preferrednametextbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_Preferredname_name")));
    	  Preferrednametextbox.clear();
    	  
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
   		  Preferrednametextbox.sendKeys(del,config.getProperty("StCode_num&alphabetsOnly_SC011"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only numbers and alphabets");	  
	  }
      
      @Test(enabled=false,description="Verify that user able to enter only numbers and special characters")
	  public void TC_SC074() throws InterruptedException 
	  {
		  
    	  Thread.sleep(1000);
    	  WebElement Preferrednametextbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_Preferredname_name")));
    	  //Preferrednametextbox.clear();
    	  
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
   		  Preferrednametextbox.sendKeys(del,config.getProperty("StCode_num&specialCharOnly_SC012"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only numbers and special characters");	  
	  }
      
      @Test(enabled=false,description="Verify that user able to enter only alphabets and special characters")
	  public void TC_SC075() throws InterruptedException 
	  {
		  
    	  Thread.sleep(1000);
    	  WebElement Preferrednametextbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_Preferredname_name")));
    	  //Preferrednametextbox.clear();
    	  
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
   		  Preferrednametextbox.sendKeys(del,config.getProperty("StCode_alphabets&specialCharOnly_SC013"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only alphabets and special characters");	  
	  }
      
      @Test(enabled=true,description="Verify that user able to enter numbers, alphabets and special characters")
	  public void TC_SC076() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement Preferrednametextbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_Preferredname_name")));    	 
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
   		  Preferrednametextbox.sendKeys(del,config.getProperty("StCode_NumAlphabets&specialChar_SC014"));
   		  
   	      Preferrednametextbox.sendKeys(del,"Ravi");
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter numbers, alphabets and special characters");	  
	  }
      
      
      @Test(description="Verify that the HomeTown field is present")
	  public void TC_SC077() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  //WebElement HomeTownFields=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_HomeTown_name")));
    	 
    	  if(isElementPresent(By.name(OR.getProperty("St_Clubs_AppForm_HomeTown_name")))) 
		  {
			  Thread.sleep(1000);
			  System.out.println("*HomeTown Field is present in the form*");
		  }
   		    else
   		    {
			  System.out.println("**HomeTown Field is not present in the form*");
   	     	} 
	  }
  
      @Test(description="Verify that the HomeTown field is enable")
	  public void TC_SC078() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement HomeTownField=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_HomeTown_name")));    	 
    	  if(HomeTownField.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  System.out.println("*HomeTown Field is enable in the form*");
		  }
   		    else
   		    {
			  System.out.println("**HomeTown Field is not enable in the form*");
   	     	} 
	  }
      
      @Test(enabled=false,description="Verify that user is able to enter only numbers")
	  public void TC_SC079() throws InterruptedException 
	  {
    	  Thread.sleep(1000);
    	  WebElement HomeTownField=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_HomeTown_name")));   
    	  //HomeTownField.clear();
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  HomeTownField.sendKeys(del,config.getProperty("StCode_numOnly_SC008"));
    	  System.out.println("**user is able to enter only numbers value*");
   		
	  }
        
      @Test(enabled=false,description="Verify that user able to enter only alphabets")
	  public void TC_SC080() throws InterruptedException 
	  {    	  
    	  Thread.sleep(1000);
    	  WebElement HomeTownField=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_HomeTown_name")));   
    	  
    	  ///for clear previous enter value
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  Thread.sleep(1000);
    	  HomeTownField.sendKeys(del,config.getProperty("StCode_alphabetsOnly_SC009"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only alphabets");	  
	  }
      
      @Test(enabled=false,description="Verify that user able to enter only special characters")
	  public void TC_SC081() throws InterruptedException 
	  {
    	  Thread.sleep(1000);
    	  WebElement HomeTownField=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_HomeTown_name")));   
    	  //Preferrednametextbox.clear();
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  HomeTownField.sendKeys(del,config.getProperty("StCode_specialCharOnly_SC010"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only special characters");	  
	  }
      
      
      @Test(enabled=false,description="Verify that user able to enter only numbers and alphabets")
	  public void TC_SC082() throws InterruptedException 
	  {
		  Thread.sleep(1000);
		  WebElement HomeTownField=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_HomeTown_name")));  
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  HomeTownField.sendKeys(del,config.getProperty("StCode_num&alphabetsOnly_SC011"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only numbers and alphabets");	  
	  }
      
      @Test(enabled=false,description="Verify that user able to enter only numbers and special characters")
	  public void TC_SC083() throws InterruptedException 
	  {
		  
    	  Thread.sleep(1000);
    	  WebElement HomeTownField=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_HomeTown_name"))); 
    	  
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  HomeTownField.sendKeys(del,config.getProperty("StCode_num&specialCharOnly_SC012"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only numbers and special characters");	  
	  }
      
      @Test(description="Verify that user able to enter only alphabets and special characters")
	  public void TC_SC084() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement HomeTownField=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_HomeTown_name"))); 
    	  //Preferrednametextbox.clear();
    	  
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  HomeTownField.sendKeys(del,config.getProperty("StCode_alphabets&specialCharOnly_SC013"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only alphabets and special characters");	  
	  }
      
      @Test(description="Verify that user able to enter numbers, alphabets and special characters")
	  public void TC_SC085() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement HomeTownField=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_HomeTown_name")));    	 
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  HomeTownField.sendKeys(del,config.getProperty("StCode_NumAlphabets&specialChar_SC014"));
    	 // HomeTownField.sendKeys(del);
    	  //HomeTownField.clear();
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter numbers, alphabets and special characters");	  
	  }
      
      @Test(description="Verify that the 'Preferred Email Address' field is present")
	  public void TC_SC086() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  //WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")));
    	 
    	  if(isElementPresent(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")))) 
		  {
			  Thread.sleep(1000);
			  System.out.println("*Preferred Email Field is present in the form*");
		  }
   		    else
   		    {
			  System.out.println("**Preferred Email Field is not present in the form*");
   	     	} 
	  }
  
      @Test(description="Verify that the 'Preferred Email Address' field is enable")
	  public void TC_SC087() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")));    	 
    	  if(preferredEmailFields_textbox.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  System.out.println("*Preferred Email Field is enable in the form*");
		  }
   		    else
   		    {
			  System.out.println("**Preferred Email Field is not enable in the form*");
   	     	} 
	  }
      
     
      @Test(description="Verify that user is able to enter only numbers")
	  public void TC_SC088() throws InterruptedException 
	  {
    	  Thread.sleep(1000);
    	  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")));   
    	  //HomeTownField.clear();
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  preferredEmailFields_textbox.sendKeys(del,config.getProperty("StCode_numOnly_SC008"));
    	  System.out.println("**user is able to enter only numbers value*");
   		
	  }
        
      @Test(description="Verify that user able to enter only alphabets")
	  public void TC_SC089() throws InterruptedException 
	  {    	  
    	  Thread.sleep(1000);
    	  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")));   
    	  
    	  ///for clear previous enter value
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  Thread.sleep(1000);
    	  preferredEmailFields_textbox.sendKeys(del,config.getProperty("StCode_alphabetsOnly_SC009"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only alphabets");	  
	  }
      
      @Test(description="Verify that user able to enter only special characters")
	  public void TC_SC090() throws InterruptedException 
	  {
    	  Thread.sleep(1000);
    	  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name"))); 
    	  //Preferrednametextbox.clear();
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  preferredEmailFields_textbox.sendKeys(del,config.getProperty("StCode_specialCharOnly_SC010"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only special characters");	  
	  }
      
      
      @Test(description="Verify that user able to enter only numbers and alphabets")
	  public void TC_SC091() throws InterruptedException 
	  {
		  Thread.sleep(1000);
		  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")));
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  preferredEmailFields_textbox.sendKeys(del,config.getProperty("StCode_num&alphabetsOnly_SC011"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only numbers and alphabets");	  
	  }
      
      @Test(description="Verify that user able to enter only numbers and special characters")
	  public void TC_SC092() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")));
    	  
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  preferredEmailFields_textbox.sendKeys(del,config.getProperty("StCode_num&specialCharOnly_SC012"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only numbers and special characters");	  
	  }
      
      
      @Test(description="Verify that user able to enter only alphabets and special characters")
	  public void TC_SC093() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name"))); 
    	  //Preferrednametextbox.clear();
    	  
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  preferredEmailFields_textbox.sendKeys(del,config.getProperty("StCode_alphabets&specialCharOnly_SC013"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only alphabets and special characters");	  
	  }
      
      @Test(description="Verify that user able to enter numbers, alphabets and special characters")
	  public void TC_SC094() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")));   	 
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  preferredEmailFields_textbox.sendKeys(del,config.getProperty("StCode_NumAlphabets&specialChar_SC014"));
    	  //HomeTownField.clear();
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter numbers, alphabets and special characters");	  
	  }
      
      @Test(description="Verify that the email field is not entering @ symbol")
	  public void TC_SC095() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")));   	 
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  preferredEmailFields_textbox.sendKeys(del,config.getProperty("Email_@symbolMissing_SC095"));
    	  //HomeTownField.clear();
   		  Thread.sleep(1000);
   		//Actions builder=new Actions(driver);
   		//builder.moveToElement(preferredEmailFields_textbox);
   		//String tooltipmsg=preferredEmailFields_textbox.getText();
   		  
   		  //click on the submit btn
   		WebElement SubmitBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_AppForm_submitbtn_xpath")));
   		SubmitBtn.click();
   		Thread.sleep(1000);
   		WebElement ErrormsgName=driver.findElement(By.className(OR.getProperty("St_Clubs_AppForm_errorMsg_className")));  
   		if(isElementPresent(By.className(OR.getProperty("St_Clubs_AppForm_errorMsg_className")))) 
		  {
			  Thread.sleep(1000);
			  System.out.println("*Error message display with the name is==>:*" +ErrormsgName.getText() );
		  }
   		else
   		{
			  System.out.println("**Error message is not display**");
   		} 
   	  }
      
      @Test(description="Verify the field by entering @ symbol 2 times")
	  public void TC_SC096() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")));   	 
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  preferredEmailFields_textbox.sendKeys(del,config.getProperty("Email_@symbolEnter2Times_SC096") ,Keys.ENTER);
    	  //HomeTownField.clear();
   		  Thread.sleep(1000);
   		  
   		  WebElement ErrormsgName=driver.findElement(By.className(OR.getProperty("St_Clubs_AppForm_errorMsg_className")));  
   		  if(isElementPresent(By.className(OR.getProperty("St_Clubs_AppForm_errorMsg_className")))) 
		    {
			  Thread.sleep(1000);
			  System.out.println("*Error message display with the name is==>:*" +ErrormsgName.getText());
		     }
   	    	else
   	        	{
			      System.out.println("**validation Error message is not display**");
   	        	}       
	    }
      
      //Should appear validation error message
      @Test(description="Verify the field by not entering .com")
	  public void TC_SC097() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")));   	 
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  preferredEmailFields_textbox.sendKeys(del,config.getProperty("Email_MissingDomainName_SC097") ,Keys.ENTER);
    	  //HomeTownField.clear();
   		  Thread.sleep(1000);
   		  WebElement SubmitBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_AppForm_submitbtn_xpath")));
   	      SubmitBtn.click();
   	      Thread.sleep(1000);
   		  WebElement ErrormsgName=driver.findElement(By.className(OR.getProperty("St_Clubs_AppForm_errorMsg_className")));  
   		  if(isElementPresent(By.className(OR.getProperty("St_Clubs_AppForm_errorMsg_className")))) 
		    {
			  Thread.sleep(1000);
			  System.out.println("*Error message display with the name is==>:*" +ErrormsgName.getText());
		     }
   	    	else
   	        	{
			      System.out.println("**validation Error message is not display**");
   	        	}       
	    }
      
      
      @Test(description="Verify the field by not entering company name")
	  public void TC_SC098() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement preferredEmailFields_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_preferredEmail_name")));   	 
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  preferredEmailFields_textbox.sendKeys(del,config.getProperty("Email_MissingCompanyNm_SC098") ,Keys.ENTER);
    	  //HomeTownField.clear();
   		  Thread.sleep(1000);
   		  WebElement SubmitBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_AppForm_submitbtn_xpath")));
   	      SubmitBtn.click();
   	      Thread.sleep(1000);
   		  WebElement ErrormsgName=driver.findElement(By.className(OR.getProperty("St_Clubs_AppForm_errorMsg_className")));  
   		  if(isElementPresent(By.className(OR.getProperty("St_Clubs_AppForm_errorMsg_className")))) 
		     {
			  Thread.sleep(1000);
			  System.out.println("*Error message display with the name is==>:*" +ErrormsgName.getText());
		     }
   	    	else
   	        	{
			      System.out.println("**validation Error message is not display**");
   	        	}       
	    }
      
      
      @Test(description="Verify that the 'Knovva Programs' field is present")
	  public void TC_SC099() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  //WebElement KnovvaPrograms_textbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_KnovvaPrograms_name")));
    	 
    	  if(isElementPresent(By.name(OR.getProperty("St_Clubs_AppForm_KnovvaPrograms_name")))) 
		  {
			  Thread.sleep(1000);
			  System.out.println("*Knovva Programs Field is present in the form*");
		  }
   		    else
   		    {
			  System.out.println("**Knovva Programs Field is not present in the form*");
   	     	} 
	  }
  
      @Test(description="Verify that the 'Knovva Programs' field is enable")
	  public void TC_SC100() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement KnovvaPrograms_txtbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_KnovvaPrograms_name")));    	 
    	  if(KnovvaPrograms_txtbox.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  System.out.println("*Knovva Programs Field is enable in the form*");
		  }
   		    else
   		    {
			  System.out.println("**Knovva Programs Field is not enable in the form*");
   	     	} 
	  }
      
      //***KnovvaProgram Text box script start*******
            
      @Test(enabled=true,description="Verify that user is able to enter only numbers")
	  public void TC_SC101() throws InterruptedException 
	  {
    	  Thread.sleep(1000);
    	  WebElement KnovvaPrograms_txtbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_KnovvaPrograms_name")));    
    	  //HomeTownField.clear();
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  KnovvaPrograms_txtbox.sendKeys(del,config.getProperty("StCode_numOnly_SC008"));
    	  System.out.println("**user is able to enter only numbers value*");
   		
	  }
        
      @Test(enabled=true,description="Verify that user able to enter only alphabets")
	  public void TC_SC102() throws InterruptedException 
	  {    	  
    	  Thread.sleep(1000);
    	  WebElement KnovvaPrograms_txtbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_KnovvaPrograms_name")));   
    	  
    	  ///for clear previous enter value
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  Thread.sleep(1000);
    	  KnovvaPrograms_txtbox.sendKeys(del,config.getProperty("StCode_alphabetsOnly_SC009"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only alphabets");	  
	  }
      
      @Test(enabled=true,description="Verify that user able to enter only special characters")
	  public void TC_SC103() throws InterruptedException 
	  {
    	  Thread.sleep(1000);
    	  WebElement KnovvaPrograms_txtbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_KnovvaPrograms_name")));   
    	  //Preferrednametextbox.clear();
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  KnovvaPrograms_txtbox.sendKeys(del,config.getProperty("StCode_specialCharOnly_SC010"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only special characters");	  
	  }
      
      
      @Test(enabled=true,description="Verify that user able to enter only numbers and alphabets")
	  public void TC_SC104() throws InterruptedException 
	  {
		  Thread.sleep(1000);
		  WebElement KnovvaPrograms_txtbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_KnovvaPrograms_name")));   
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  KnovvaPrograms_txtbox.sendKeys(del,config.getProperty("StCode_num&alphabetsOnly_SC011"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only numbers and alphabets");	  
	  }
      
      @Test(enabled=true,description="Verify that user able to enter only numbers and special characters")
	  public void TC_SC105() throws InterruptedException 
	  {
		  
    	  Thread.sleep(1000);
    	  WebElement KnovvaPrograms_txtbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_KnovvaPrograms_name"))); 
    	  
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  KnovvaPrograms_txtbox.sendKeys(del,config.getProperty("StCode_num&specialCharOnly_SC012"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only numbers and special characters");	  
	  }
      
      @Test(description="Verify that user able to enter only alphabets and special characters")
	  public void TC_SC106() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement KnovvaPrograms_txtbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_KnovvaPrograms_name")));  
    	  //Preferrednametextbox.clear();
    	  
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  KnovvaPrograms_txtbox.sendKeys(del,config.getProperty("StCode_alphabets&specialCharOnly_SC013"));
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter only alphabets and special characters");	  
	  }
      
      @Test(description="Verify that user able to enter numbers, alphabets and special characters")
	  public void TC_SC107() throws InterruptedException 
	  {		  
    	  Thread.sleep(1000);
    	  WebElement KnovvaPrograms_txtbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_KnovvaPrograms_name")));    	 
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  KnovvaPrograms_txtbox.sendKeys(del,config.getProperty("StCode_NumAlphabets&specialChar_SC014"));
    	 // HomeTownField.sendKeys(del);
    	  //HomeTownField.clear();
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter numbers, alphabets and special characters");	  
	  }
      
      @Test(description="Verify the field by entering invalid program name")
	  public void TC_SC108() throws InterruptedException 
	  {		  
    	  Log.info("StudentsClubsAppForm module test case Ended !!!");
    	  Thread.sleep(1000);
    	  WebElement KnovvaPrograms_txtbox=driver.findElement(By.name(OR.getProperty("St_Clubs_AppForm_KnovvaPrograms_name")));    	 
    	 
    	  String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
    	  KnovvaPrograms_txtbox.sendKeys(del,config.getProperty("StCode_NumAlphabets&specialChar_SC014"));
    	 // HomeTownField.sendKeys(del);
    	  //HomeTownField.clear();
   		  Thread.sleep(1000);
   		  System.out.println("User is able to enter invalid program name");	  
   		  
   		Log.info("StudentClubsAppForm module test case Ended !!!");
	  }
      
      
/*    @DataProvider
  	public Object[][] getData() 
    {
  		String sheetName = "St_Spotlight_AppForm";
  		int rows = excel_reg.getRowCount(sheetName);
  		int cols = excel_reg.getColumnCount(sheetName);

  		Object[][] data = new Object[rows - 1][cols];

  		for (int rowNum = 2; rowNum <= rows; rowNum++) {
  			for (int colNum = 0; colNum < cols; colNum++) {

  				data[rowNum - 2][colNum] = excel_StClubAppForm.getCellData(sheetName, colNum, rowNum);
  			}
  		}

  		return data;
  	}*/

  
      @AfterTest
      public void callTearDown() {
      	
      	Login1.tearDown();
      }
      
      
      @AfterSuite
      public void storeReport() {
      	Login1.captureReport();
      }
}

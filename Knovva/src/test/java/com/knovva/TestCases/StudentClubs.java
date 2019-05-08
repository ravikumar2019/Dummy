package com.knovva.TestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import com.knovva.utilities.Log;

public class StudentClubs extends TestBase_Knovva 
  {
	
	@BeforeSuite
	public void callSetup() {
		
		Login1.setUp();
	}
	
	
	@BeforeTest
	public void callBrowser() {
		
		Login1.browserLaunch();
	}
	
	  @Test(description="Verify the 'Student Clubs' option is present in the menu")
	  public void TC_SC001() throws InterruptedException 
	  {
		  Log.info("StudentClubs test case started !!!");
	    	
	    	extentlogger = extentreport.createTest("TC_SC001");
			
	    	extentlogger.info("StudentClubs_Test_Scenario===>: If email ID field is blank , given input for password field and then click on Signin button");
			
			extentlogger.info("Expected_Results===>:Login button should not be enabled");
		  
		  Log.info("StudentClubs module test case started !!!");
		  TestBase_Knovva.ClickOnHamburgerMenu();
		 //WebElement StudentsClubs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_tab_xpath")));
		  WebElement ul=driver.findElement(By.xpath(OR.getProperty("St_MenueUL_xpath")));
		  Thread.sleep(1000);
		  List<WebElement> allOptions=ul.findElements(By.tagName(OR.getProperty("St_menueTagNameLi_tagname")));
		  String st="STUDENT CLUBS" ;
		  for(WebElement selectLi: allOptions)
		  {
		   if(selectLi.getAttribute("innerText").equals(st))
			  {
				  // selectLi.click(); 					
				  System.out.println("**Student Clubs option is present in the menu===>:" +selectLi.getAttribute("innerText"));
			  }
		   }		
		  driver.navigate().refresh();
	   }
	  
	  @Test(enabled=false,description="Verify that 'Student Clubs' option is enable")
	  public void TC_SC002() throws InterruptedException 
	  {
		  TestBase_Knovva.ClickOnHamburgerMenu();
		  Thread.sleep(1000);
		  WebElement StudentsClubs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_tab_xpath")));
		  if(StudentsClubs.isEnabled())
		  {
			  System.out.println("**Student Clubs option is Enabled**");
		  }
		  else
		  {
			  System.out.println("**Student Clubs option is not Enabled**");
		  }
		  driver.navigate().refresh();
	   }
	   
	  //Should redirect to Student Clubs page
	  @Test(description="Click on the 'Student Clubs' option")
	  public void TC_SC003() throws InterruptedException 
	  {
		  TestBase_Knovva.ClickOnHamburgerMenu();
		  Thread.sleep(1000);
		  WebElement StudentsClubs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_tab_xpath")));
		  if(StudentsClubs.isEnabled())
		  {
			  StudentsClubs.click();
			  Thread.sleep(1000);
			  System.out.println("**Student Clubs option is Clickable**");
			  
		  }
		  else
		  {
			  System.out.println("**Student Clubs option is not enable and clickable**");
		  }
		  Thread.sleep(1000);
		  TestBase_Knovva.ClickOnHamburgerMenu();
		  TestBase_Knovva.ClickOnLogoutBtn();
		 // driver.navigate().refresh();
	   }
	  
	  @Test(description="Verify that Welcome window is present")
	  public void TC_SC004() throws InterruptedException 
	  {
		 // Thread.sleep(1000);
		  //WebElement StudentsClubs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_tab_xpath")));
		 // StudentsClubs.click();
		    WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
			WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
			log_email.clear();
			log_email.sendKeys(config.getProperty("Email_SC004"));
			lg_password.clear();
			lg_password.sendKeys(config.getProperty("password_SC004"));
			Thread.sleep(1000); 
			driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
			
			TestBase_Knovva.ClickOnHamburgerMenu();
		  Thread.sleep(1000); 
		  WebElement StudentsClubs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_tab_xpath")));
		  StudentsClubs.click();
		  		  
		  WebElement StClubsWelcomePopupMsg =driver.findElement(By.xpath(OR.getProperty("St_Clubs_WlcPopup_xpath")));
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_WlcPopup_xpath")))) 
		  {
			  Thread.sleep(1000);
			  System.out.println("**After clicking on the Student Clubs option present popup window is===>:" +StClubsWelcomePopupMsg.getText());
		  }
		  else
		  {
			  System.out.println("**Student Clubs welcome window is not present**");
		  }
	   }
	  
	  
	  @Test(description="Verify that the enter student code text box is present")
	  public void TC_SC005() throws InterruptedException 
	  {			
			//TestBase_Knovva.ClickOnHamburgerMenu();
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_text_xpath")));
		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_Entercode_text_xpath")))) 
		  {
			  Thread.sleep(1000);
			  System.out.println("**Enter student code text box is present with name ===>:" +EnterStCodeTxtbox.getText());
		  }
		  else
		  {
			  System.out.println("**Enter student code text box is not present**");
		  }
	   }
	  
	  @Test(enabled=false,description="Verify that the text box is enable")
	  public void TC_SC006() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));		  		  
		  if(EnterStCodeTxtbox.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  System.out.println("**Enter student code text box is enabled**");
		  }
		  else
		  {
			  System.out.println("**Enter student code text box is not enabled*");
		  }
		  driver.navigate().refresh();
	   }
	  
	  
	  @Test(enabled=false,description="Verify that user able to enter input")
	  public void TC_SC007() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));		  		  
		  if(EnterStCodeTxtbox.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  EnterStCodeTxtbox.clear();
			  EnterStCodeTxtbox.sendKeys("Student12");
			  Thread.sleep(1000);
			  System.out.println("**User is able to enter input in student code text box**");
		  }
		  else
		  {
			  System.out.println("**User is not able to enter input in student code text box*");
		  }
		  driver.navigate().refresh();
	   }
	  
	  @Test(enabled=false,description="Verify that user able to enter only numbers")
	  public void TC_SC008() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));		  		  
		  if(EnterStCodeTxtbox.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  EnterStCodeTxtbox.clear();
			  EnterStCodeTxtbox.sendKeys(config.getProperty("StCode_numOnly_SC008"));
			  Thread.sleep(1000);
			  System.out.println("**User is able to enter only number in the student code text box**");
		  }
		  else
		  {
			  System.out.println("**User is not able to enter only number in the student code text box*");
		  }
		  driver.navigate().refresh();
	   }
	
	  @Test(enabled=false,description="Verify that user able to enter only alphabets")
	  public void TC_SC009() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));		  		  
		  if(EnterStCodeTxtbox.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  EnterStCodeTxtbox.clear();
			  EnterStCodeTxtbox.sendKeys(config.getProperty("StCode_alphabetsOnly_SC009"));
			  Thread.sleep(1000);
			  System.out.println("**User is able to enter only alphabets in the student code text box**");
		  }
		  else
		  {
			  System.out.println("**User is not able to enter only alphabets in the student code text box*");
		  }
		  driver.navigate().refresh();
	   }
		  
	  @Test(enabled=false,description="Verify that user able to enter only special characters")
	  public void TC_SC010() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));		  		  
		  if(EnterStCodeTxtbox.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  EnterStCodeTxtbox.clear();
			  EnterStCodeTxtbox.sendKeys(config.getProperty("StCode_specialCharOnly_SC010"));
			  Thread.sleep(1000);
			  System.out.println("**User is able to enter only special characters in the student code text box**");
		  }
		  else
		  {
			  System.out.println("**User is not able to enter only special characters in the student code text box*");
		  }
		  driver.navigate().refresh();
	   }
	
	  
	  @Test(enabled=false,description="Verify that user able to enter only numbers and alphabets")
	  public void TC_SC011() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));		  		  
		  if(EnterStCodeTxtbox.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  EnterStCodeTxtbox.clear();
			  EnterStCodeTxtbox.sendKeys(config.getProperty("StCode_num&alphabetsOnly_SC011"));
			  Thread.sleep(1000);
			  System.out.println("**User is able to enter only numbers and alphabets in the student code text box**");
		  }
		  else
		  {
			  System.out.println("**User is not able to enter only numbers and alphabets in the student code text box*");
		  }
		 // driver.navigate().refresh();
	   }
	  
	  @Test(enabled=false,description="Verify that user able to enter only numbers and special characters")
	  public void TC_SC012() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));		  		  
		  if(EnterStCodeTxtbox.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  EnterStCodeTxtbox.clear();
			  EnterStCodeTxtbox.sendKeys(config.getProperty("StCode_num&specialCharOnly_SC012"));
			  Thread.sleep(1000);
			  System.out.println("**User is able to enter only numbers and special characters in the student code text box**");
		  }
		  else
		  {
			  System.out.println("**User is not able to enter only numbers and special characters in the student code text box*");
		  }
		  driver.navigate().refresh();
	   }
	  
	  @Test(enabled=false,description="Verify that user able to enter only alphabets and special characters")
	  public void TC_SC013() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));		  		  
		  if(EnterStCodeTxtbox.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  EnterStCodeTxtbox.clear();
			  EnterStCodeTxtbox.sendKeys(config.getProperty("StCode_alphabets&specialCharOnly_SC013"));
			  Thread.sleep(1000);
			  System.out.println("**User is able to enter only 'alphabets and special characters' in the student code text box**");
		  }
		  else
		  {
			  System.out.println("**User is not able to enter only 'alphabets and special characters' in the student code text box*");
		  }
	   }
	  
	  @Test(enabled=false,description="Verify that user able to enter numbers, alphabets and special characters")
	  public void TC_SC014() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));		  		  
		  if(EnterStCodeTxtbox.isEnabled()) 
		  {
			  Thread.sleep(1000);
			  EnterStCodeTxtbox.clear();
			  EnterStCodeTxtbox.sendKeys(config.getProperty("StCode_NumAlphabets&specialChar_SC014"));
			  Thread.sleep(1000);
			  System.out.println("**User is able to 'enter numbers, alphabets and special characters' in the student code text box**");
		  }
		  else
		  {
			  System.out.println("**User is not able to 'enter numbers, alphabets and special characters' in the student code text box*");
		  }
		  driver.navigate().refresh();
	   }
	  
	  @Test(enabled=false,description="Verify that the accept button is present or not")
	  public void TC_SC015() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement AcceptBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_AcceptBtn_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_AcceptBtn_xpath")))) 
		  {
			 // Thread.sleep(1000);
			  System.out.println("**Accept button is present with the name of like==> :" +AcceptBtn.getText());
		  }
		  else
		  {
			  System.out.println("**Accept button is not present**");
		  }
	   }
	  
	  @Test(enabled=false,description="Verify that the accept button is enable or not")
	  public void TC_SC016() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement AcceptBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_AcceptBtn_xpath")));		  		  
		  if(AcceptBtn.isEnabled()) 
		  {
			  //Thread.sleep(1000);
			  System.out.println("**Accept button is enable**" );
		  }
		  else
		  {
			  System.out.println("**Accept button is not enable**");
		  }
	   }
	  
	  @Test(enabled=false,description="Left blank in code box textbox and click on Accept button")
	  public void TC_SC017() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));	
		 // EnterStCodeTxtbox.click();
		  EnterStCodeTxtbox.clear();
		  EnterStCodeTxtbox.sendKeys("");
		  
		  WebElement AcceptBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_AcceptBtn_xpath")));			  
		  if(AcceptBtn.isEnabled()) 
		  {
			  //Thread.sleep(1000);
			  AcceptBtn.click();
			  Thread.sleep(1000);
			  System.out.println("**No any Error message is appear when we left blank code box textbox and click on the accept btn**" );
		  }
		  else
		  {
			  System.out.println("**Accept button is not enable**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  @Test(enabled=false,description="Enter invalid code and click on Accept button")
	  public void TC_SC018() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));	
		 // EnterStCodeTxtbox.click();
		  EnterStCodeTxtbox.clear();
		  EnterStCodeTxtbox.sendKeys("STu123");
		  
		  WebElement AcceptBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_AcceptBtn_xpath")));	
		  AcceptBtn.click();
		  Thread.sleep(1000);
		  WebElement Toastmsg=driver.findElement(By.className(OR.getProperty("St_Clubs_toastmsg_class")));
		  
		  if(isElementPresent(By.className(OR.getProperty("St_Clubs_toastmsg_class")))) 
		  {
			  System.out.println("**Enter invalid code and click on Accept button Error message is===> :" +Toastmsg.getText());
		  }
		  else
		  {
			  System.out.println("**Error message is not display**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  //******Enter valid students code
	  @Test(enabled=false,description="Enter valid code and click on the Accept button")
	  public void TC_SC019() throws InterruptedException 
	  {			
		  Thread.sleep(1000); 
		  WebElement EnterStCodeTxtbox=driver.findElement(By.xpath(OR.getProperty("St_Clubs_Entercode_textbox_xpath")));	
		 // EnterStCodeTxtbox.click();
		  EnterStCodeTxtbox.clear();
		  EnterStCodeTxtbox.sendKeys("Ravi12"); //MWmLHHe
		  
		  WebElement AcceptBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_AcceptBtn_xpath")));	
		  AcceptBtn.click();
		  Thread.sleep(1000);
		  WebElement Toastmsg=driver.findElement(By.className(OR.getProperty("St_Clubs_toastmsg_class")));
		  
		  if(isElementPresent(By.className(OR.getProperty("St_Clubs_toastmsg_class")))) 
		  {
			  System.out.println("** Success message is display with the name===> :" +Toastmsg.getText());
		  }
		  else
		  {
			  System.out.println("**Success message is not display**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  @Test(enabled=false,description="Verify that the request access button is present or not")
	  public void TC_SC020() throws InterruptedException 
	  {			
		  WebElement RequestAccessBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_RequestAccesBtn_xpath")));	
		  Thread.sleep(1000);
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_RequestAccesBtn_xpath")))) 
		  {
			  System.out.println("**Request Access button is present with name like===>:" +RequestAccessBtn.getText());
		  }
		  else
		  {
			  System.out.println("**Request Access button is not present**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  @Test(description="Verify that the request access button is enable or not")
	  public void TC_SC021() throws InterruptedException 
	  {			
		  WebElement RequestAccessBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_RequestAccesBtn_xpath")));	
		  Thread.sleep(1000);
		  if(RequestAccessBtn.isEnabled()) 
		  {
			  System.out.println("**Request Access button is enable**");
		  }
		  else
		  {
			  System.out.println("**Request Access button is not enable**");
		  }
	   }
	  
	  @Test(description="Verify that the 'X' is present or not")
	  public void TC_SC023() throws InterruptedException 
	  {			
		  WebElement CrossCloseBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_CrossCloseBtn_xpath")));	
		  Thread.sleep(1000);
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_CrossCloseBtn_xpath")))) 
		  {
			  System.out.println("**Close 'X' symbol is present**" +CrossCloseBtn.getText());
		  }
		  else
		  {
			  System.out.println("**Close 'X' symbol is not present**");
		  }
	   }
	  
	  @Test(description="Verify that the 'X' symbol is enable or not")
	  public void TC_SC024() throws InterruptedException 
	  {			
		  WebElement CrossCloseBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_CrossCloseBtn_xpath")));	
		  Thread.sleep(1000);
		  if(CrossCloseBtn.isEnabled()) 
		  {
			  System.out.println("**Close 'X' symbol is enable**");
		  }
		  else
		  {
			  System.out.println("**Close 'X' symbol is not enable**");
		  }
	   }
	  
	  @Test(description="Click on the 'X' symbol")
	  public void TC_SC025() throws InterruptedException 
	  {			
		  WebElement CrossCloseBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_CrossCloseBtn_xpath")));	
		  Thread.sleep(1000);
		  if(CrossCloseBtn.isEnabled()) 
		  {
			  CrossCloseBtn.click();
			  Thread.sleep(1000);
			  System.out.println("**After clicking on the 'X' symbol popup will be closed**");
		  }
		  else
		  {
			  System.out.println("**Close 'X' symbol is not working**");
		  }
		  TestBase_Knovva.ClickOnHamburgerMenu();
		  TestBase_Knovva.ClickOnLogoutBtn();
		  TestBase_Knovva.validLogin();
		  TestBase_Knovva.ClickOnHamburgerMenu();
		  
	   }
	  
	  @Test(description="Verify that the 'join the discussion' section is present")
	  public void TC_SC026() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  WebElement StudentsClubs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_tab_xpath")));
		  StudentsClubs.click();		  		  
		  //WebElement JoinTheDiscussion=driver.findElement(By.xpath(OR.getProperty("St_Clubs_JoinTheDiscussion_xpath")));	
		  Thread.sleep(1000);
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_JoinTheDiscussion_xpath")))) 
		  {
			  System.out.println("**join the discussion section is present**");
		  }
		  else
		  {
			  System.out.println("**join the discussion section is not present**");
		  }
	   }

	  @Test(description="Verify that the 'join the discussion' section is enable")
	  public void TC_SC027() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  WebElement JoinTheDiscussion=driver.findElement(By.xpath(OR.getProperty("St_Clubs_JoinTheDiscussion_xpath")));	
		  Thread.sleep(1000);
		  if(JoinTheDiscussion.isEnabled()) 
		  {
			  System.out.println("**join the discussion section is Enable**");
		  }
		  else
		  {
			  System.out.println("**join the discussion section is not Enable**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  @Test(description="Click on the 'join the discussion' section")
	  public void TC_SC028() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  WebElement JoinTheDiscussion=driver.findElement(By.xpath(OR.getProperty("St_Clubs_JoinTheDiscussion_xpath")));	
		  Thread.sleep(1000);
		  if(JoinTheDiscussion.isEnabled()) 
		  {
			  JoinTheDiscussion.click();
			  Thread.sleep(2000);
			  
			  System.out.println("**After clicking on the 'join the discussion' section page is redirected to community page and url is ===>:" +driver.getCurrentUrl());
		  }
		  else
		  {
			  System.out.println("**join the discussion section is not Enable**");
		  }
		  driver.navigate().back();
		  Thread.sleep(1000);
	   }
	  
	  
	  @Test(description="Verify that the 'Submit Projects' section is present or not")
	  public void TC_SC029() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  //WebElement SubmitProjects=driver.findElement(By.xpath(OR.getProperty("St_Clubs_SubmitProjects_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_SubmitProjects_xpath")))) 
		  {
			  System.out.println("**Submit Projects section is present**");
		  }
		  else
		  {
			  System.out.println("**Submit Projects section is not present**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  @Test(description="Verify that the 'Submit Projects' section is enable")
	  public void TC_SC030() throws InterruptedException 
	  {			
		  //Thread.sleep(1000);
		  WebElement SubmitProjects=driver.findElement(By.xpath(OR.getProperty("St_Clubs_SubmitProjects_xpath")));	
		  Thread.sleep(1000);
		  if(SubmitProjects.isEnabled()) 
		  {
			  System.out.println("**Submit Projects section is Enable**");
		  }
		  else
		  {
			  System.out.println("**Submit Projects section is not Enable**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  
	  @Test(description="Click on the 'Submit Projects' section")
	  public void TC_SC031() throws InterruptedException 
	  {			
		  //Thread.sleep(1000);
		  WebElement SubmitProjects=driver.findElement(By.xpath(OR.getProperty("St_Clubs_SubmitProjects_xpath")));	
		  Thread.sleep(1000);
		  if(SubmitProjects.isEnabled()) 
		  {
			  //click on the SubmitProjects section
			  SubmitProjects.click();
			  Thread.sleep(1000);
			  System.out.println("**After clicking on the 'Submit Projects' section page is redirected to community page and url is ===>:" +driver.getCurrentUrl());
		  }
		  else
		  {
			  System.out.println("**Submit Projects section is not Enable**");
		  }
		  driver.navigate().back();
		  Thread.sleep(1000);
	   }
	  
	  @Test(description="Verify that the 'Contact Us' section is present or not")
	  public void TC_SC032() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ContactUs_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_ContactUs_xpath")))) 
		  {
			  System.out.println("**ContactUs section is present**");
		  }
		  else
		  {
			  System.out.println("**ContactUs section is not present**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  
	  @Test(description="Verify that the 'Contact Us' section is Enable or not")
	  public void TC_SC033() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ContactUs_xpath")));		  		  
		  if(ContactUs.isEnabled()) 
		  {
			  System.out.println("**ContactUs section is Enable**");
		  }
		  else
		  {
			  System.out.println("**ContactUs section is not Enable**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  
	  @Test(description="Verify that the 'Read More' link is present or not")
	  public void TC_SC035() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  //WebElement ReadMore=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ReadMore_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_ReadMore_xpath")))) 
		  {
			  System.out.println("**Read more link is present**");
		  }
		  else
		  {
			  System.out.println("**Read more link is not present**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  
	  @Test(description="Verify that the 'Read More' link is enable or not")
	  public void TC_SC036() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  WebElement ReadMore=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ReadMore_xpath")));		  		  
		  if(ReadMore.isEnabled()) 
		  {
			  System.out.println("**Read more link is Enable**");
		  }
		  else
		  {
			  System.out.println("**Read more link is not Enable**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  
	  @Test(description="Click on the 'Read More' link")
	  public void TC_SC037() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  WebElement ReadMore=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ReadMore_xpath")));		  		  
		  if(ReadMore.isEnabled()) 
		  {
			  ReadMore.click();
			  System.out.println("**Welcome message window is display**");
		  }
		  else
		  {
			  System.out.println("**Read more link is not Enable**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  
	  @Test(description="Verify that the 'join the discussion' Link is present or not")
	  public void TC_SC038() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  WebElement ReadMore=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ReadMore_xpath")));		
		  ReadMore.click();
		  Thread.sleep(1000);
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_popup_JoinTheDiscussion_xpath")))) 
		  {
			  System.out.println("**join the discussion Link is present**");
		  }
		  else
		  {
			  System.out.println("**join the discussion Link is not present**");
		  }
	   }

	  @Test(description="Verify that the 'join the discussion' Link is enable")
	  public void TC_SC039() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  WebElement JoinTheDiscussion=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_JoinTheDiscussion_xpath")));	
		  Thread.sleep(1000);
		  if(JoinTheDiscussion.isEnabled()) 
		  {
			  System.out.println("**join the discussion Link is Enable**");
		  }
		  else
		  {
			  System.out.println("**join the discussion Link is not Enable**");
		  }
		 // driver.navigate().refresh();
	   }
	  
	  @Test(description="Click on the 'join the discussion' Link")
	  public void TC_SC040() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  WebElement JoinTheDiscussion=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_JoinTheDiscussion_xpath")));	
		  Thread.sleep(1000);
		  if(JoinTheDiscussion.isEnabled()) 
		  {
			  JoinTheDiscussion.click();
			  Thread.sleep(2000);			  
			  System.out.println("**After clicking on the 'join the discussion' Link page is redirected to community page and url is ===>:" +driver.getCurrentUrl());
		  }
		  else
		  {
			  System.out.println("**join the discussion Link is not Enable**");
		  }
		  driver.navigate().back();
		  Thread.sleep(1000);
	   }

	  
	  @Test(description="Verify that the 'Submit projects' link is present or not")
	  public void TC_SC041() throws InterruptedException 
	  {					  
		  WebElement ReadMore=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ReadMore_xpath")));		
		  ReadMore.click();
		  Thread.sleep(1000);
		  //WebElement SubmitProjects=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_SubmitProjects_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_popup_SubmitProjects_xpath")))) 
		  {
			  System.out.println("**Submit Projects link is present**");
		  }
		  else
		  {
			  System.out.println("**Submit Projects link is not present**");
		  }
	   }
	  
	  @Test(description="Verify that the 'Submit Projects' link is enable")
	  public void TC_SC042() throws InterruptedException 
	  {			
		  //Thread.sleep(1000);
		  WebElement SubmitProjects=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_SubmitProjects_xpath")));	
		  Thread.sleep(1000);
		  if(SubmitProjects.isEnabled()) 
		  {
			  System.out.println("**Submit Projects link is Enable**");
		  }
		  else
		  {
			  System.out.println("**Submit Projects link is not Enable**");
		  }
	   }
	  
	  
	  @Test(description="Click on the 'Submit Projects' Link")
	  public void TC_SC043() throws InterruptedException 
	  {			
		  //Thread.sleep(1000);
		  WebElement SubmitProjects=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_SubmitProjects_xpath")));	
		  Thread.sleep(1000);
		  if(SubmitProjects.isEnabled()) 
		  {
			  //click on the SubmitProjects section
			  SubmitProjects.click();
			  Thread.sleep(1000);
			  System.out.println("**After clicking on the 'Submit Projects' link page is redirected to community page and url is ===>:" +driver.getCurrentUrl());
		  }
		  else
		  {
			  System.out.println("**Submit Projects link is not Enable**");
		  }
		  driver.navigate().back();
		  Thread.sleep(1000);
	   }
	  //************
	  
	  @Test(description="Verify that the 'Contact Us' Link is present or not")
	  public void TC_SC044() throws InterruptedException 
	  {			
		  WebElement ReadMore=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ReadMore_xpath")));		
		  ReadMore.click();
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")))) 
		  {
			  System.out.println("**ContactUs Link is present**");
		  }
		  else
		  {
			  System.out.println("**ContactUs Link is not present**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  
	  @Test(description="Verify that the 'Contact Us' Link is Enable or not")
	  public void TC_SC045() throws InterruptedException 
	  {			
		  Thread.sleep(1000);
		  WebElement ReadMore=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ReadMore_xpath")));	
		  ReadMore.click();
		  WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(ContactUs.isEnabled()) 
		  {
			  System.out.println("**ContactUs Link is Enable**");
		  }
		  else
		  {
			  System.out.println("**ContactUs link is not Enable**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  
	  @Test(description="Verify that the 'Getting Started' section is present or not")
	  public void TC_SC047() throws InterruptedException 
	  {			
		  WebElement GettingStarted=driver.findElement(By.xpath(OR.getProperty("St_Clubs_GettingStarted_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_GettingStarted_xpath")))) 
		  {
			  System.out.println("**Getting Started section present present name is====>:" +GettingStarted.getText());
		  }
		  else
		  {
			  System.out.println("**Getting Started section is not present**");
		  }
	   }
	  
	  @Test(description="Verify that user able to minimize the section")
	  public void TC_SC048() throws InterruptedException 
	  {			
		  WebElement Minimize=driver.findElement(By.xpath(OR.getProperty("St_Clubs_GetStar_Minimize_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(Minimize.isEnabled()) 
		  {
			  Minimize.click();
			  Thread.sleep(2000);
			  System.out.println("*User is able to minimize getting started section*");
		  }
		  else
		  {
			  System.out.println("**Getting Started section is not enable**");
		  }
	   }
	  
	  @Test(description="Verify that user able to Mximize the section")
	  public void TC_SC049() throws InterruptedException 
	  {			
		  WebElement maximize=driver.findElement(By.xpath(OR.getProperty("St_Clubs_GetStar_Minimize_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(maximize.isEnabled()) 
		  {
			  maximize.click();
			  Thread.sleep(2000);
			  System.out.println("*User is able to maximize getting started section*");
		  }
		  else
		  {
			  System.out.println("**Getting Started section is not enable**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  
	  @Test(description="Verify that the 'Download' button is present or not")
	  public void TC_SC051() throws InterruptedException 
	  {			
		  WebElement DownloadBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_GetStar_DownloadBtn_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_GetStar_DownloadBtn_xpath")))) 
		  {
			  System.out.println("**Download button present with the name is====>:" +DownloadBtn.getText());
		  }
		  else
		  {
			  System.out.println("**Download button is not present**");
		  }
	   }
	  
	  @Test(description="Verify that the 'Download' button is enable or not")
	  public void TC_SC052() throws InterruptedException 
	  {			
		  WebElement DownloadBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_GetStar_DownloadBtn_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(DownloadBtn.isEnabled()) 
		  {
			  System.out.println("**Download button is Enable**");
		  }
		  else
		  {
			  System.out.println("**Download button is not enable**");
		  }
	   }
	  
	  
	  @Test(description="Click on the download button")
	  public void TC_SC053() throws InterruptedException 
	  {			
		  WebElement DownloadBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_GetStar_DownloadBtn_xpath")));	
		  DownloadBtn.click();
		  Thread.sleep(1000);
		  
		  WebElement TopicName=driver.findElement(By.xpath(OR.getProperty("St_Clubs_GetStar_DownloadBtnTopicName_xpath")));	
		  Actions action =new Actions(driver);
		  action.moveToElement(TopicName);
		  System.out.println("**After clicking on the download button new popup open with file name like===>:" +TopicName.getText());		  
		  driver.navigate().refresh();
	   }
	  
	  @Test(description="Verify that the 'Club Curriculum' section is present or not")
	  public void TC_SC054() throws InterruptedException 
	  {			
		  WebElement ClubCurriculum=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ClubCurriculum_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_ClubCurriculum_xpath")))) 
		  {
			  System.out.println("**Club Curriculum section present with the name is====>:" +ClubCurriculum.getText());
		  }
		  else
		  {
			  System.out.println("**Club Curriculum section is not present**");
		  }
	   }
	  
	  @Test(description="Verify that user able to minimize the section")
	  public void TC_SC055() throws InterruptedException 
	  {			
		  WebElement Minimize=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ClubCurriculum_Minimize_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(Minimize.isEnabled()) 
		  {
			  Minimize.click();
			  Thread.sleep(2000);
			  System.out.println("*User is able to minimize Club Curriculum section*");
		  }
		  else
		  {
			  System.out.println("**Club Curriculum section is not enable**");
		  }
	   }
	  
	  @Test(description="Verify that user able to Mximize the section")
	  public void TC_SC056() throws InterruptedException 
	  {			
		  WebElement maximize=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ClubCurriculum_Minimize_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(maximize.isEnabled()) 
		  {
			  maximize.click();
			  Thread.sleep(2000);
			  System.out.println("*User is able to maximize Club Curriculum section*");
		  }
		  else
		  {
			  System.out.println("**Club Curriculum section is not enable**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  
	  @Test(description="Verify that the 'Download' button is present or not")
	  public void TC_SC058() throws InterruptedException 
	  {			
		  WebElement DownloadBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ClubCurriculum_DownloadBtn_xpath")));		
		  Thread.sleep(1000);
		  	  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_ClubCurriculum_DownloadBtn_xpath")))) 
		  {
			  System.out.println("**In Club Curriculum Download button present with the name is====>:" +DownloadBtn.getText());
		  }
		  else
		  {
			  System.out.println("**In Club Curriculum Download button is not present**");
		  }
	   }
	  
	  @Test(description="Verify that the 'Download' button is enable or not")
	  public void TC_SC059() throws InterruptedException 
	  {			
		  WebElement DownloadBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ClubCurriculum_DownloadBtn_xpath")));		
		  Thread.sleep(1000);
		  	  		  
		  if(DownloadBtn.isEnabled()) 
		  {
			  System.out.println("**In Club Curriculum Download button is Enable");
		  }
		  else
		  {
			  System.out.println("**In Club Curriculum Download button is not Enable**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  @Test(description="Click on the download button")
	  public void TC_SC060() throws InterruptedException 
	  {			
		  WebElement DownloadBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ClubCurriculum_DownloadBtn_xpath")));	
		  DownloadBtn.click();
		  Thread.sleep(1000);
		  WebElement TopicName=driver.findElement(By.xpath(OR.getProperty("St_Clubs_ClubCurriculum_DownloadBtnTopicName_xpath")));		  		  
		   Actions action =new Actions(driver);
		   action.moveToElement(TopicName);
		   Thread.sleep(1000);
		   System.out.println("**After clicking on the download button new popup open with file name ===>:"+TopicName.getText());
		 
		  driver.navigate().refresh();
	   }
	  
	  @Test(description="Verify that the 'Student Spotlight' section is present")
	  public void TC_SC061() throws InterruptedException 
	  {			
		  WebElement StudentSpotlight=driver.findElement(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_xpath")))) 
		  {
			  System.out.println("**Student Spotlight section present with the name is====>:" +StudentSpotlight.getText());
		  }
		  else
		  {
			  System.out.println("**Student Spotlight section is not present**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  @Test(description="Verify that the 'Read more' button is present or not")
	  public void TC_SC062() throws InterruptedException 
	  {			
		  WebElement StudentSpotlight_ReadMoreBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_ReadMore_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_ReadMore_xpath")))) 
		  {
			  System.out.println("**In Student Spotlight section Read More button is present with the name ===>>:" +StudentSpotlight_ReadMoreBtn.getText());
		  }
		  else
		  {
			  System.out.println("**Student Spotlight section read more button is not present**");
		  }
	   }
	  
	  @Test(description="Verify that the 'Read more' button is Enable or not")
	  public void TC_SC063() throws InterruptedException 
	  {			
		  WebElement StudentSpotlight_ReadMoreBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_ReadMore_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(StudentSpotlight_ReadMoreBtn.isEnabled()) 
		  {
			  System.out.println("**In Student Spotlight section Read More button is Enable**");
		  }
		  else
		  {
			  System.out.println("**Student Spotlight section read more button is not enable**");
		  }
	   }
	  
	  //breakkkkkkkk 
	  @Test(enabled=false,description="Click on the 'Read more' button")
	  public void TC_SC064() throws InterruptedException 
	  {			
		  WebElement StudentSpotlight_ReadMoreBtn=driver.findElement(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_ReadMore_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(StudentSpotlight_ReadMoreBtn.isEnabled()) 
		  {
			  StudentSpotlight_ReadMoreBtn.click();
			  Thread.sleep(1000);
			  System.out.println("**After clicking on the read more button in Student Spotlight section New poup open up with details**");
		  }
		  else
		  {
			  System.out.println("**Student Spotlight section read more button is not enable**");
		  }
		  driver.navigate().back();
	   }
	  
	  @Test(description="Verify that the 'Click here to learn more and submit an application!'Link is present or not")
	  public void TC_SC065() throws InterruptedException 
	  {			
		  WebElement StudentSpotlight_SubApp=driver.findElement(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_SubApplication_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(isElementPresent(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_ReadMore_xpath")))) 
		  {
			  System.out.println("**In Student Spotlight section 'Click here to learn more and submit an application!' Link is present with the name ===>>:" +StudentSpotlight_SubApp.getText());
		  }
		  else
		  {
			  System.out.println("**Student Spotlight section 'Click here to learn more and submit an application!' Link is not present**");
		  }
	   }
	  
	  @Test(description="Verify that the 'Click here to learn more and submit an application!'Link is Enable or not")
	  public void TC_SC066() throws InterruptedException 
	  {			
		  WebElement StudentSpotlight_SubApp=driver.findElement(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_SubApplication_xpath")));		
		  Thread.sleep(1000);
		  //WebElement ContactUs=driver.findElement(By.xpath(OR.getProperty("St_Clubs_popup_ContactUs_xpath")));		  		  
		  if(StudentSpotlight_SubApp.isEnabled()) 
		  {
			  System.out.println("**In Student Spotlight section 'Click here to learn more and submit an application!' Link is Enable**");
		  }
		  else
		  {
			  System.out.println("**Student Spotlight section 'Click here to learn more and submit an application!' Link is not enable**");
		  }
		  driver.navigate().refresh();
	   }
	  
	  @Test(description="**Click on the link like 'Click here to learn more and submit an application!'**")
	  public void TC_SC067() throws InterruptedException 
	  {			
		  Log.info("StudentsClubs module test case Ended !!!");
		  WebElement StudentSpotlight_SubApp=driver.findElement(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_SubApplication_xpath")));		
		  Thread.sleep(1000);		  		  		  
		  //StudentSpotlight_SubApp.click();
		  Actions builder = new Actions(driver);
	        builder.moveToElement(StudentSpotlight_SubApp).click(StudentSpotlight_SubApp);
	        builder.perform();		  
		  Thread.sleep(1000);
		  //WebElement Student_Spotlight_Application=driver.findElement(By.xpath(OR.getProperty("St_Clubs_StudentSpotlight_AppFormTxt_xpath")));
		  System.out.println("**After clicking on the Link New window openup with details**");		 
		  driver.navigate().refresh();
		  
		  Log.info("StudentClubs module test case Ended !!!");
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

package com.knovva.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import com.knovva.utilities.Log;

public class Notification extends TestBase_Knovva {
  
	
	@BeforeSuite
	public void callSetup() {
		
		Notification.setUp();
	}
	
	
	@BeforeTest
	public void callBrowser() {
		
		Notification.browserLaunch();
	}
	
	  
	  @Test(enabled = false,
			  description = "Check whether notification bell Icon Present or not in the header after login || Bell Icon should be present in the header after login")
	  
	  public void TC_N001() throws InterruptedException 
	  {
		  	Log.info("Notification test case started !!!");
	    	
	    	extentlogger = extentreport.createTest("TC_N001");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check whether notification bell Icon Present or not in the header after login");
			
			extentlogger.info("Expected_Results===>: Bell Icon should be present in the header after login");
		  
			Thread.sleep(3000);
		  
			WebElement Notificationicon=driver.findElement(By.xpath(OR.getProperty("Com_Notifin_icon_xpath")));
	      
			Thread.sleep(1000);	      
	     
			if(Notificationicon.isDisplayed())
			{
	    	  Notificationicon.click();
	    	  
	    	  Thread.sleep(2000);
	    	  
	    	  System.out.println("****Notification icon is display in header section****" );
			}
			else 
			{
	    	  System.out.println("****Notification icon is not display in header section***:" );
			}		
	  }
	  
	  
	  @Test(enabled = false,
			  description = "Check that after clicking on the bell icon whether a menu opens or not || After clicking on the bell icon a menu should open up")
	  
	  public void TC_N002() throws InterruptedException 
	  {
		  	extentlogger = extentreport.createTest("TC_N002");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check that after clicking on the bell icon whether a menu opens or not");
			
			extentlogger.info("Expected_Results===>: After clicking on the bell icon a menu should open up");
		  
			Thread.sleep(2000);
		  
			WebElement Notificationicon=driver.findElement(By.xpath(OR.getProperty("Com_Notifin_icon_xpath")));
		  
			Notificationicon.click();
	      
			Thread.sleep(1000);
	      
	      
			WebElement Notification=driver.findElement(By.className(OR.getProperty("NotificationBell_icon_Class")));
	      
			String Notificationtxt=Notification.getText();
	      
			System.out.println("****After clicking on the Notification icon ,Notification text is display ===>:" +Notificationtxt );
	  }
	  
	  
	  @Test(enabled = false,
			  description = "Check that after opening a bell menu in the header whether 'New Notification' display or not || After opening a bell menu in the header 'New notification' message should be present")
	  
	  public void TC_N003() throws InterruptedException 
	  {
		  	extentlogger = extentreport.createTest("TC_N003");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check that after opening a bell menu in the header whether 'New Notification' display or not");
			
			extentlogger.info("Expected_Results===>: After opening a bell menu in the header \"New notification\" message should be present");
		  
			Thread.sleep(2000);
		 
			WebElement Notificationicon=driver.findElement(By.xpath(OR.getProperty("Com_Notifin_icon_xpath")));
		  
			Notificationicon.click();
	      
			Thread.sleep(1000);
	      
	     
			WebElement Notification=driver.findElement(By.className(OR.getProperty("NotificationBell_icon_Class")));
	      
			String Notificationtxt=Notification.getText();	      
	      
			System.out.println("****Opening a bell menu new Notification text is present===>:" +Notificationtxt);
	  }
	  
	  
	  @Test(enabled = false,
			  description = "Check that after opening a bell menu in the header and click on the new notification message ,check  whether ' New Notification' readable or not || After opening a bell menu in the header \"New notification\" message should be readable")
	  
	  public void TC_N004() throws InterruptedException 
	  {
		  	extentlogger = extentreport.createTest("TC_N004");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check that after opening a bell menu in the header and click on the new notification message ,check  whether ' New Notification' readable or not");
			
			extentlogger.info("Expected_Results===>: After opening a bell menu in the header \"New notification\" message should be readable");
		  
			Thread.sleep(2000);
		  
			WebElement Notificationicon=driver.findElement(By.xpath(OR.getProperty("Com_Notifin_icon_xpath")));
		  
			Notificationicon.click();
	      
			Thread.sleep(1000);
	      
	     	WebElement Notification=driver.findElement(By.xpath(OR.getProperty("NotificationChat_innertext_xpath")));
	      
	     	String Notificationtxt=Notification.getText();	
	      
	     	Notification.click();
	      
	     	driver.navigate().refresh();
	      
	     	System.out.println("****New notification message is readable ===>:" +Notificationtxt);
	  }
	  
	  
	  @Test(enabled = false,
			  description = "Check whether notification delete Icon Present or not in the notification section || Notification delete icon should be present")
	  
	  public void TC_N005() throws InterruptedException 
	  {
		  	extentlogger = extentreport.createTest("TC_N005");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check whether notification delete Icon Present or not in the notification section");
			
			extentlogger.info("Expected_Results===>: Notification delete icon should be present");
		  
		 	Thread.sleep(2000);
		  
		 	WebElement Notificationicon=driver.findElement(By.xpath(OR.getProperty("Com_Notifin_icon_xpath")));
		  
		 	Notificationicon.click();
	     
		 	Thread.sleep(2000);
	      
		 	List<WebElement> allOptions=driver.findElements(By.xpath(OR.getProperty("NotificationChat_innertext_xpath")));	
	     	      
		 	if(allOptions.equals("Delete"))
	    	{
	    		System.out.println("***Notification delete Icon is display***" );	    		
	    	} 
		 	
	    	else {
	    		System.out.println("***Notification delete Icon is not display***");
	    	}	      
	  }
	  
	  
	  
	  @Test(enabled = false,
			  description = "Check whether Chat Icon Present or not in the header after login || Chat Icon should be present in the header after login")
	  
	  public void TC_C001() throws Exception 
	  {
		  	extentlogger = extentreport.createTest("TC_C001");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check whether Chat Icon Present or not in the header after login");
			
			extentlogger.info("Expected_Results===>: Chat Icon should be present in the header after login");
		  
			WebElement NotificationChaticon=driver.findElement(By.xpath(OR.getProperty("NotificationChat_icon_xpath")));
	      
			Thread.sleep(2000);	      
	      
			if(NotificationChaticon.isDisplayed())
			{
	    	  NotificationChaticon.click();
	    	  
	    	  Thread.sleep(2000);
	    	  
	    	  System.out.println("****Notification chat icon is display in header section****");
	      }
			
	      else 
	      {
	    	  System.out.println("****Notification chat icon is not display in header section***");
	      }		
	  }
	 
	  
	  @Test(enabled = false,
			  description = "Check that after clicking on the chat icon whether a menu opens or not || After clicking on the chat icon a menu should open up")
	  
	  public void TC_C002() throws Exception 
	  {
		  	extentlogger = extentreport.createTest("TC_C002");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check that after clicking on the chat icon whether a menu opens or not");
			
			extentlogger.info("Expected_Results===>: After clicking on the chat icon a menu should open up");
		  
			Thread.sleep(1000);
		  
			WebElement NotificationChaticon=driver.findElement(By.xpath(OR.getProperty("NotificationChat_icon_xpath")));	            
	      
			NotificationChaticon.click();
	      
			Thread.sleep(1000);	
	      
			WebElement NotificationChat_crNewMsg=driver.findElement(By.xpath(OR.getProperty("NotificationChat_CrNewMsg_xpath")));
	      
			Thread.sleep(1000);	
	      
			System.out.println("****clicking on the chat icon a menu open up with the name is===>:" +NotificationChat_crNewMsg.getText());
	       	      		
	  }
	  
	  
	  @Test(enabled = false,
			  description = "Check that after opening a chat menu in the header whether 'Create New Message' add button present or not || After opening a chat menu in the header 'Create New Message' add button should be present")
	  
	  public void TC_C003() throws Exception 
	  {
		  	extentlogger = extentreport.createTest("TC_C003");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check that after opening a chat menu in the header whether 'Create New Message' add button present or not");
			
			extentlogger.info("Expected_Results===>: After opening a chat menu in the header \"Create New Message\" add button should be present");
		  
			Thread.sleep(1000);
		 
			WebElement NotificationChaticon2=driver.findElement(By.xpath(OR.getProperty("NotificationChat_icon_xpath")));	            
	     
			NotificationChaticon2.click();
	    
			Thread.sleep(2000);	
	    
			WebElement NotificationChat_crNewMsg=driver.findElement(By.xpath(OR.getProperty("Notification_CrNewMsg_xpath")));
	     
			Thread.sleep(2000);	
	      
			String ss=NotificationChat_crNewMsg.getText();
	      
			System.out.println("****clicking on the chat icon Create New Message button is present*===>:" +ss);
	  }
	  	  
	  
	  @Test(enabled = false,
			  description = "Check that after clicking on create new message button whether a message pop up opening or not || After clicking on create new message button a message pop up should open in the bottom and focus on the text box")
	  
	  public void TC_C004() throws Exception 
	  {
		  	extentlogger = extentreport.createTest("TC_C004");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check that after clicking on create new message button whether a message pop up opening or not");
			
			extentlogger.info("Expected_Results===>: After clicking on create new message button a message pop up should open in the bottom and focus on the text box");
		  
			Thread.sleep(1000);
		  
			WebElement NotificationChaticon2=driver.findElement(By.xpath(OR.getProperty("NotificationChat_icon_xpath")));	            
	      
			NotificationChaticon2.click();
	      
			Thread.sleep(1000);	
	      
			WebElement NotificationChat_crNewMsg=driver.findElement(By.xpath(OR.getProperty("NotificationChat_CrNewMsg_xpath")));
	     
			//click on the + icon create new message text
			NotificationChat_crNewMsg.click();
	      
			Thread.sleep(2000);
	      
			WebElement NotificationChat_searchUserN=driver.findElement(By.id(OR.getProperty("NotificationChat_searchUserN_id")));
	      
			System.out.println("****After clicking on the create new message(+) button chat interface pop open up with the name is===>:" + NotificationChat_searchUserN.getAttribute("placeholder"));
	  }
	  
	  
	  @Test(enabled = false,
			  description = "Check whether field validator text 'Search a user's name or email' showing or not || Field validator text \"Search a user's name or email\" should be showing")
	  
	  public void TC_C005() throws Exception 
	  {
		  	extentlogger = extentreport.createTest("TC_C005");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check whether field validator text 'Search a user's name or email' showing or not");
			
			extentlogger.info("Expected_Results===>: Field validator text 'Search a user's name or email' should be showing");
		  
			Thread.sleep(1000);
		  
			WebElement NotificationChaticon2=driver.findElement(By.xpath(OR.getProperty("NotificationChat_icon_xpath")));	            
	      
			NotificationChaticon2.click();
	     
			Thread.sleep(1000);	
	     
			WebElement NotificationChat_crNewMsg=driver.findElement(By.xpath(OR.getProperty("NotificationChat_CrNewMsg_xpath")));
	      
			//click on the + icon create new message text
			NotificationChat_crNewMsg.click();
	     
			Thread.sleep(2000);
	     
			WebElement NotificationChat_searchUserN=driver.findElement(By.id(OR.getProperty("NotificationChat_searchUserN_id")));
	     
			System.out.println("****Field validator text 'Search a user's name or email' is showing with the name of===>:" + NotificationChat_searchUserN.getAttribute("placeholder"));
	   }
	  
	  
	  @Test(enabled = false,
			  description = "Check in the search box searching with part of the name if matches with the existing user then whether name list showing or not in the drop down to select || In the search box searching with part of the name if matches with the existing user then name list should be showing in the drop down to select")
	  
	  public void TC_C006() throws Exception 
	  {
		  	extentlogger = extentreport.createTest("TC_C006");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check in the search box searching with part of the name if matches with the existing user then whether name list showing or not in the drop down to select");
			
			extentlogger.info("Expected_Results===>: In the search box searching with part of the name if matches with the existing user then name list should be showing in the drop down to select");
		  
			Thread.sleep(1000);
		  
			WebElement NotificationChaticon2=driver.findElement(By.xpath(OR.getProperty("NotificationChat_icon_xpath")));	            
	      
			NotificationChaticon2.click();
	      
			Thread.sleep(1000);	
	      
			WebElement NotificationChat_crNewMsg=driver.findElement(By.xpath(OR.getProperty("NotificationChat_CrNewMsg_xpath")));
	     
			//click on the + icon create new message text
			NotificationChat_crNewMsg.click();
	      
			Thread.sleep(2000);
	      
			WebElement NotificationChat_searchUserN=driver.findElement(By.id(OR.getProperty("NotificationChat_searchUserN_id")));
	      
			NotificationChat_searchUserN.sendKeys("ra");
	      
			List<WebElement> list = driver.findElements(By.xpath(OR.getProperty("NotificationChat_suggestionlist_xpath")));
			
			System.out.println("***Auto Suggest List ::" + list.size());
			
			Thread.sleep(1000);
			
			for(int i = 0 ;i< list.size();i++)
			{
				System.out.println(list.get(i).getAttribute("innerText"));
				
				if(list.get(i).getAttribute("innerText").equals("Ranjan"))
				{
					list.get(i).click();
					
					break;
				}
			}	      
	      System.out.println("****Search box searching with part of the name if matches with the existing user***");
	   }
	
	  @Test(enabled = false,
			  description = "Check after selecting an user if earlier friend request not sent then after selecting the user whether 'message You are not currently friends with <user name>. You may friend request them below:' showing or not || After selecting an user if earlier friend request not sent then after selecting the user below message should be shown You are not currently friends with User. You may friend request them below:")
	  
	  public void TC_C007() throws Exception 
	  {
		  	extentlogger = extentreport.createTest("TC_C007");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check after selecting an user if earlier friend request not sent then after selecting the user whether 'message You are not currently friends with <user name>. You may friend request them below:' showing or not");
			
			extentlogger.info("Expected_Results===>: After selecting an user if earlier friend request not sent then after selecting the user below message should be shown You are not currently friends with User. You may friend request them below:");
		  
			Thread.sleep(1000);
		  
			WebElement NotificationChaticon2=driver.findElement(By.xpath(OR.getProperty("NotificationChat_icon_xpath")));	            
	     
			NotificationChaticon2.click();
	      
			Thread.sleep(1000);	
	      
			WebElement NotificationChat_crNewMsg=driver.findElement(By.xpath(OR.getProperty("NotificationChat_CrNewMsg_xpath")));
	      
			//click on the + icon create new message text
			NotificationChat_crNewMsg.click();
	      
			Thread.sleep(2000);
	      
			//put some value in search filed
			WebElement NotificationChat_searchUserN=driver.findElement(By.id(OR.getProperty("NotificationChat_searchUserN_id")));
	      
			NotificationChat_searchUserN.sendKeys("Ranjan Roy" ,Keys.ENTER);
	      
	        WebElement aftersearchRnROY=driver.findElement(By.xpath(OR.getProperty("Com_Notifin_CrNeMsgTxtbox_ranjanroy_xpath")));
	      
	        Actions action = new Actions(driver);
	      
	      
	        action.moveToElement(aftersearchRnROY).perform();
	      
	        Thread.sleep(2000);
	      
	        aftersearchRnROY.click();
	      
	        Thread.sleep(2000);
	      
	        WebElement after_selecting_user_msg=driver.findElement(By.xpath(OR.getProperty("NotificationChat_text_xpath")));
	     
	        System.out.println("****After slecting the user msg is display like ===>:" + after_selecting_user_msg.getText());
		 
	   }
	  
	  
	  @Test(enabled = false,
			  description = "Check after selecting an user if earlier friend request sent then after selecting the user whethe message 'A friend request has been sent to <user name>. You will be able to message them once they accept:' showing or not || After selecting an user if earlier friend request sent then after selecting the user below message should be shown 'A friend request has been sent to <user name>. You will be able to message them once they accept:'")
	  
	  public void TC_C008() throws Exception 
	  {
		  	extentlogger = extentreport.createTest("TC_C008");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check after selecting an user if earlier friend request sent then after selecting the user whethe message 'A friend request has been sent to <user name>. You will be able to message them once they accept:' showing or not");
			
			extentlogger.info("Expected_Results===>: After selecting an user if earlier friend request sent then after selecting the user below message should be shown 'A friend request has been sent to <user name>. You will be able to message them once they accept:'");
		  
			Thread.sleep(1000);
		 
			WebElement NotificationChaticon2=driver.findElement(By.xpath(OR.getProperty("NotificationChat_icon_xpath")));	            
	     
			NotificationChaticon2.click();
	     
			Thread.sleep(1000);	
	      
			WebElement NotificationChat_crNewMsg=driver.findElement(By.xpath(OR.getProperty("NotificationChat_CrNewMsg_xpath")));
	      
			//click on the + icon create new message text
			NotificationChat_crNewMsg.click();
	      
			Thread.sleep(2000);
	      
			//put some value in search filed
			WebElement NotificationChat_searchUserN=driver.findElement(By.id(OR.getProperty("NotificationChat_searchUserN_id")));
	     
			NotificationChat_searchUserN.sendKeys("Abhishek Meher" ,Keys.ENTER);
	      
			Thread.sleep(2000);	      
	      
			WebElement aftersearchAbhiMeher=driver.findElement(By.xpath(OR.getProperty("Notifin_CrNeMsgTxtbox_AbhishekMeher_xpath")));
	      
			Actions action = new Actions(driver);
	      
			action.moveToElement(aftersearchAbhiMeher).perform();
	      
			Thread.sleep(2000);
	      
			aftersearchAbhiMeher.click();
	      
			Thread.sleep(2000);
	     
			WebElement RequestSentText_user_msg=driver.findElement(By.xpath(OR.getProperty("NotificationChat_RequestSentText_xpath")));
	     
			System.out.println("****If user is already send a friend request then slecting the user message is display ===>:" +RequestSentText_user_msg.getText());		 
	   }
	  
	  
	  @Test(enabled = false,
			  description = "Check whether message box heading present or not || Message box heading or title should be present and cannot be empty")
	  
	  public void TC_C009() throws Exception 
	  {
		  	extentlogger = extentreport.createTest("TC_C009");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check whether message box heading present or not");
			
			extentlogger.info("Expected_Results===>: Message box heading or title should be present and cannot be empty");
		  
			Thread.sleep(1000);
		  
			WebElement NotificationChaticon2=driver.findElement(By.xpath(OR.getProperty("NotificationChat_icon_xpath")));	            
	      
			NotificationChaticon2.click();
	      
			Thread.sleep(1000);	
	     
			WebElement NotificationChat_crNewMsg=driver.findElement(By.xpath(OR.getProperty("NotificationChat_CrNewMsg_xpath")));
	      
			//click on the + icon create new message text
			NotificationChat_crNewMsg.click();
	      
			Thread.sleep(2000);
	      
			//put some value in search filed
			WebElement NotificationChat_searchUserN=driver.findElement(By.id(OR.getProperty("NotificationChat_searchUserN_id")));
	      
			NotificationChat_searchUserN.sendKeys("Abhishek Meher" ,Keys.ENTER);
	      
			Thread.sleep(2000);	      
	      
			WebElement aftersearchAbhiMeherMsgBoxHe=driver.findElement(By.xpath(OR.getProperty("Notifin_CrNeMsgTxtbox_msgBoxHead_AbhishekMeher_xpath")));
	     
			Actions action = new Actions(driver);
	      
			action.moveToElement(aftersearchAbhiMeherMsgBoxHe).perform();
	     
			Thread.sleep(2000);
	      
			aftersearchAbhiMeherMsgBoxHe.click();
	      
			Thread.sleep(2000);
	     
			WebElement MsgBoxHeading=driver.findElement(By.xpath(OR.getProperty("NotificationChat_MsgBoxHead_xpath")));
	      
			System.out.println("****Message box heading or title present with the name of===>:" +MsgBoxHeading.getText());		 
	   }
	  
	   
	  @Test(enabled = true,
			  description = "Check that whether cross button for closing the message box present or not || Cross button for closing the message box should be present")
	  
	  public void TC_C010() throws Exception 
	  {
		  	extentlogger = extentreport.createTest("TC_C010");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Check that whether cross button for closing the message box present or not");
			
			extentlogger.info("Expected_Results===>: Cross button for closing the message box should be present");
		  
			Thread.sleep(1000);
		  
			WebElement NotificationChaticon2=driver.findElement(By.xpath(OR.getProperty("NotificationChat_icon_xpath")));	            
	      
			NotificationChaticon2.click();
	      
			Thread.sleep(1000);	
	     
			WebElement NotificationChat_crNewMsg=driver.findElement(By.xpath(OR.getProperty("NotificationChat_CrNewMsg_xpath")));
	      
			//click on the + icon create new message text
			NotificationChat_crNewMsg.click();	      
	     
			Thread.sleep(2000);	      
	      
			WebElement MsgBoxCloseBtn=driver.findElement(By.xpath(OR.getProperty("NotificationChat_MsgBoxCloseBtn_xpath")));
	      
			//check the condition msg box cross btn is display or not
			if(MsgBoxCloseBtn.isDisplayed())
			{	    	 
	    	  Thread.sleep(1000);
	    	  
	    	  System.out.println("***Cross button for closing the message box is display in message box section***");	
	      }
			
	      else
	      {
	    	  System.out.println("***Cross button for closing the message box is not display in message box section***");	 
	      }
	   }
	  
	  
	  @Test(enabled = true,
			  description = "Clicking whether on clicking cross button, message box closed or not || Clicking on the cross button, message box should be closed")
	  
	  public void TC_C011() throws Exception 
	  {
		  	extentlogger = extentreport.createTest("TC_C011");
			
	    	extentlogger.info("Notification_Test_Scenario===>: Clicking whether on clicking cross button, message box closed or not");
			
			extentlogger.info("Expected_Results===>: Clicking on the cross button, message box should be closed");
		  
			Thread.sleep(1000);
		 
			WebElement NotificationChaticon2=driver.findElement(By.xpath(OR.getProperty("NotificationChat_icon_xpath")));	            
	      
			NotificationChaticon2.click();
	      
			Thread.sleep(1000);	
	     
			WebElement NotificationChat_crNewMsg=driver.findElement(By.xpath(OR.getProperty("NotificationChat_CrNewMsg_xpath")));
	      
			//click on the + icon create new message text
			NotificationChat_crNewMsg.click();	      
	     
			Thread.sleep(2000);	      
	     
			WebElement MsgBoxCloseBtn=driver.findElement(By.xpath(OR.getProperty("NotificationChat_MsgBoxCloseBtn_xpath")));
	      
			//check the condition msg box cross btn is display or not
			if(MsgBoxCloseBtn.isDisplayed())
			{	    	 
	    	  Thread.sleep(1000);
	    	  
	    	  MsgBoxCloseBtn.click();
	    	  
	    	  System.out.println("***Clicking on the cross button, message box is closed successfully***");	
	      }
			
	      else
	      {
	    	  System.out.println("***Cross button for closing the message box is not display in message box section***");	 
	      }
			
		  Log.info("Notification module test case Ended !!!");
	   }
	   
	
	  @AfterTest
	    public void callTearDown() {
	    	
		  Notification.tearDown();
	    }
	    
	    
	    @AfterSuite
	    public void storeReport() {
	    	Notification.captureReport();
	    }
}

package com.knovva.TestCases;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import com.knovva.utilities.Log;

public class Notes extends TestBase_Knovva
{
	@BeforeSuite
	public void callSetup() {
		
		Notes.setUp();
	}
	
	
	@BeforeTest
	public void callBrowser() {
		
		Notes.browserLaunch();
	}
	
	
  @Test(enabled = false,
		  description = "Check whether there is an option for file upload,create a file || There should be a button for Creating a document ,uploading a file.")
  
  public void TC_NB001() throws InterruptedException 
  {	
	  	Log.info("Notes test case started !!!");
  	
  		extentlogger = extentreport.createTest("TC_NB001");
		
  		extentlogger.info("Notes_Test_Scenario===>: Check whether there is an option for file upload,create a file");
		
		extentlogger.info("Expected_Results===>: There should be a button for Creating a document ,uploading a file.");  
	  
	    TestBase_Knovva.ClickOnHamburgerMenu();
		
	    Thread.sleep(1000);
		
	    //Click on the notebook section.
		driver.findElement(By.xpath(OR.getProperty("ntbk_xpath"))).click();
		
		Thread.sleep(1000);
		
		WebElement create_doc=driver.findElement(By.xpath(OR.getProperty("ntbk_createDoc_xpath")));
		
		String cr_doc=create_doc.getText();
		
		WebElement fileUpl_txt =driver.findElement(By.xpath(OR.getProperty("ntbk_fileupl_xpath")));
		
		String fileup=fileUpl_txt.getText();
	    
		if(cr_doc.equals("Create Document") && fileup.equals("Upload File"))
	    {
	     System.out.println("****Button present for 'Creating a document' ,'uploading a file' ****");
	    }		
  }
  
 /* @Test(enabled = false,
		  description = "Check that after clicking on Create document button whether a new popup window opening or not")
  
  public void TC_NB003() throws InterruptedException, IOException 
  {	
	  extentlogger = extentreport.createTest("TC_NB003");
		
		extentlogger.info("Notes_Test_Scenario===>: Check that after clicking on Create document button whether a new popup window opening or not");
		
		extentlogger.info("Expected_Results===>: "); 
	  
	  Thread.sleep(2000);
		WebElement upload_file=driver.findElement(By.className(OR.getProperty("ntbk_fileupl_class")));
		upload_file.click();
		//local file path
		Thread.sleep(1000);
		
		Runtime.getRuntime().exec("C:\\Users\\user\\Downloads\\AutoIt\\Fileupload.exe");
				
		Thread.sleep(2000);
		//driver.switchTo().activeElement().sendKeys("C:\\Users\\user\\Downloads\\Getting.docx"  +Keys.TAB +Keys.ENTER);
		
		//String crbuttonname= createBtn.getText();
		
		if(isElementPresent(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class"))))
		{
			WebElement geterrosmg =driver.findElement(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class")));
			Thread.sleep(2000);
			String succ_msg= geterrosmg.getText();
			System.out.println("file uploaded Success message is**===>:"+succ_msg);
		}
		else
		{
			System.out.println("File uploaded Success message is display");
		}		
		driver.navigate().refresh();
    } */
  
  
  
  @Test(enabled = false,
		  description = "Check that uploaded file display in 'my documents' section or not || After uploaded new file it should be display in my document section")
  
  public void TC_NB004() throws InterruptedException, IOException 
  {	
	  	extentlogger = extentreport.createTest("TC_NB004");
		
		extentlogger.info("Notes_Test_Scenario===>: Check that uploaded file display in 'my documents' section or not");
		
		extentlogger.info("Expected_Results===>: After uploaded new file it should be display in my document section."); 
	  
		Thread.sleep(2000);
		
		WebElement upload_file=driver.findElement(By.className(OR.getProperty("ntbk_fileupl_class")));
		
		upload_file.click();
		
		//local file path
		Thread.sleep(1000);		
		
		Runtime.getRuntime().exec("C:\\Users\\user\\Downloads\\AutoIt\\Fileupload.exe");
				
		Thread.sleep(2000);
		
		if(isElementPresent(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class"))))
		{
			WebElement geterrosmg =driver.findElement(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class")));
			
			Thread.sleep(2000);
			
			String succ_msg= geterrosmg.getText();
			
			System.out.println("file uploaded Success message is**===>:"+succ_msg);
		}
	    	else
	     	{
			  System.out.println("File uploaded Success message is not display");
		    }		
		
		List<WebElement> allOptions=driver.findElements(By.xpath(OR.getProperty("ntbk_createdoc_MyDocument_list_xpath")));
		 
		  for(WebElement selectLi: allOptions)
	        { 	    			
	        	String ss=selectLi.getAttribute("innerText");
	        	
	        	if(ss.contentEquals("Getting.docx"))
	    	    {
	    		System.out.println("**Uploaded File is display in Mydocument section***" +ss);
	    	   }		    	
	       }
				
    } 
   
   
  @Test(enabled = false,
		  description = "Check that after clicking on Create document button whether a new popup window opening or not || New popup should be open up with blank details")
  
  public void TC_NB005() throws InterruptedException 
  {	
	  extentlogger = extentreport.createTest("TC_NB005");
		
		extentlogger.info("Notes_Test_Scenario===>: Check that after clicking on Create document button whether a new popup window opening or not");
		
		extentlogger.info("Expected_Results===>: New popup should be open up with blank details"); 
	  
		Thread.sleep(1000);
		
		WebElement create_doc=driver.findElement(By.xpath(OR.getProperty("ntbk_createDoc_xpath")));
		
		create_doc.click();
		
		WebElement createBtn=driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_create_btn_xpath")));
		
		Thread.sleep(1000);

		if(createBtn.isDisplayed())
		{			
	      System.out.println("New popup window open up with blank details");
		}		
		else 
			{
			System.out.println("New popup window is not display");				
			}
  }
  
  
  @Test(enabled = false,
		  description = "Check whether the placeholder value showing for 'file name' field or not || It should be display placeholder name in file name field")
  
  public void TC_NB006() throws InterruptedException 
  {	
	  	extentlogger = extentreport.createTest("TC_NB006");
		
		extentlogger.info("Notes_Test_Scenario===>: Check whether the placeholder value showing for 'file name' field or not");
		
		extentlogger.info("Expected_Results===>: It should be display placeholder name in file name field"); 
	  
		Thread.sleep(1000);
		
		WebElement create_doc=driver.findElement(By.xpath(OR.getProperty("ntbk_createDoc_xpath")));
		
		create_doc.click();
		
		WebElement file_na_txtbox=driver.findElement(By.xpath(OR.getProperty("ntbk_alert_txtbx_xpath")));
		
		Thread.sleep(2000);
		
		String plcahol_val_txt= file_na_txtbox.getAttribute("placeholder");
		
		if(plcahol_val_txt.isEmpty())
		{
	      System.out.println("Placeholder value is not display");
		}		
		else 
			{
			System.out.println("Placeholder value is==>:" + plcahol_val_txt);				
			}
  }
  
 
  @Test(enabled = false,
		  description = "Provide number value in the file name field || It should be display success message")
  
  public void TC_NB007() throws InterruptedException 
  {	
	  	extentlogger = extentreport.createTest("TC_NB007");
		
		extentlogger.info("Notes_Test_Scenario===>: Provide number value in the file name field");
		
		extentlogger.info("Expected_Results===>: It should be display success message"); 
	  
		Thread.sleep(1000);
		
		WebElement create_doc=driver.findElement(By.xpath(OR.getProperty("ntbk_createDoc_xpath")));
		
		create_doc.click();
		
		WebElement file_na_txtbox=driver.findElement(By.xpath(OR.getProperty("ntbk_alert_txtbx_xpath")));
		
		Thread.sleep(2000);
		
		file_na_txtbox.sendKeys(config.getProperty("filename_TC_NB007"));
		
		Thread.sleep(2000);
		
		String txtbox_val= file_na_txtbox.getAttribute("value");
		
		System.out.println("File name field accepted number value and enter value is==>:" +txtbox_val);
  }
  
   
  @Test(enabled = false,
		  description = "Provide special character value other than space in the File name field || Alert message should show that please type a valid name and no special character allowed other than space")
  
  public void TC_NB008() throws InterruptedException 
  {	
	  	extentlogger = extentreport.createTest("TC_NB008");
		
		extentlogger.info("Notes_Test_Scenario===>: Provide special character value other than space in the File name field");
		
		extentlogger.info("Expected_Results===>: Alert message should show that please type a valid name and no special character allowed other than space"); 
	  
		Thread.sleep(1000);
		
		WebElement create_doc=driver.findElement(By.xpath(OR.getProperty("ntbk_createDoc_xpath")));
		
		create_doc.click();
		
		WebElement file_na_txtbox=driver.findElement(By.xpath(OR.getProperty("ntbk_alert_txtbx_xpath")));
		
		Thread.sleep(2000);
		
		file_na_txtbox.clear();
		
		file_na_txtbox.sendKeys(config.getProperty("filename_TC_NB008"));
		
		WebElement createfile_btn=driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_create_btn_xpath")));
		
		createfile_btn.click();
		
		Thread.sleep(1000);
		
		if(isElementPresent(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class"))))
		{
			WebElement geterrosmg =driver.findElement(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class")));
			
			Thread.sleep(2000);
			
			String errosmg= geterrosmg.getText();
			
			System.out.println("Error msg display ==>:" +errosmg);
		}
		else
		{
			System.out.println("Error message is not display");
		}
  }
  
  
  @Test(enabled = false,
		  description = "Check that without enter any details and click on the create button || It should give success message")
  
  public void TC_NB009() throws InterruptedException 
  {	
	  	extentlogger = extentreport.createTest("TC_NB009");
		
		extentlogger.info("Notes_Test_Scenario===>: Check that without enter any details and click on the create button");
		
		extentlogger.info("Expected_Results===>: It should give success message"); 
	  
		Thread.sleep(1000);
		
		WebElement create_doc=driver.findElement(By.xpath(OR.getProperty("ntbk_createDoc_xpath")));
		
		create_doc.click();
		
		WebElement file_na_txtbox=driver.findElement(By.xpath(OR.getProperty("ntbk_alert_txtbx_xpath")));
		
		Thread.sleep(2000);
		
		file_na_txtbox.clear();
		
		WebElement createfile_btn=driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_create_btn_xpath")));
		
		createfile_btn.click();
		
		Thread.sleep(1000);
		
		if(isElementPresent(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class"))))
		{
			WebElement geterrosmg =driver.findElement(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class")));
			
			Thread.sleep(2000);
			
			String succ_msg= geterrosmg.getText();
			
			System.out.println("Success message is ==>:" +succ_msg);
		}
		else
		{
			System.out.println("Success message is not display");
		}
     }
  
            
	  @Test(enabled = false,
			  description = "Check that enter details and click on the create button || Alert message should show that your file is created successfully")
	  
	  public void TC_NB010() throws InterruptedException 
		  {	
		  		extentlogger = extentreport.createTest("TC_NB010");
			
		  		extentlogger.info("Notes_Test_Scenario===>: Check that enter details and click on the create button");
			
		  		extentlogger.info("Expected_Results===>: Alert message should show that your file is created successfully"); 	
		  
		  		Thread.sleep(1000);
				
		  		WebElement create_doc=driver.findElement(By.xpath(OR.getProperty("ntbk_createDoc_xpath")));
				
		  		create_doc.click();
				
		  		WebElement file_na_txtbox=driver.findElement(By.xpath(OR.getProperty("ntbk_alert_txtbx_xpath")));
				
		  		Thread.sleep(2000);
				
		  		file_na_txtbox.clear();
				
		  		file_na_txtbox.sendKeys(config.getProperty("filename_TC_NB010"));
				
		  		WebElement createfile_btn=driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_create_btn_xpath")));
				
		  		createfile_btn.click();
				
		  		Thread.sleep(1000);
				
		  		if(isElementPresent(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class"))))
				{
					WebElement geterrosmg =driver.findElement(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class")));
					
					Thread.sleep(2000);
					
					String succ_msg= geterrosmg.getText();
					
					System.out.println("Alert message display ==>:" +succ_msg);
				}
				else
				{
					System.out.println("Alert message is not display");
				}
         }
	 
	 
	 @Test(enabled = false,
			 description = "Check that enter details and click on the create button || Clicking on the close button it should close active popup")
	 
	  public void TC_NB011() throws InterruptedException 
		  {	
		 		extentlogger = extentreport.createTest("TC_NB011");
			
		 		extentlogger.info("Notes_Test_Scenario===>: Check that enter details and click on the create button");
			
		 		extentlogger.info("Expected_Results===>: Clicking on the close button it should close active popup"); 	
		 
		 		Thread.sleep(1000);
		 		
		 		WebElement create_doc=driver.findElement(By.xpath(OR.getProperty("ntbk_createDoc_xpath")));
			
		 		create_doc.click();
			
		 		WebElement Createfile_cancel_btn=driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_cancel_btn_xpath")));
			
		 		Thread.sleep(1000);
				
		 		if(Createfile_cancel_btn.isDisplayed())
				{
					Thread.sleep(1000);
					
					Createfile_cancel_btn.click();
					
					System.out.println("Active popup close successfully");
				}
				else
				{
					System.out.println("Cancel button is not display");
				}
        }
	 
	
	 @Test(enabled = false,
			 description = "Check that created document ,uploaded file  showing in My document section or not || Created file , uploaded file  should be show in My document section")
	 
	 public void TC_NB012() throws InterruptedException 
		  {	
		 		extentlogger = extentreport.createTest("TC_NB012");
			
		 		extentlogger.info("Notes_Test_Scenario===>: Check that created document ,uploaded file  showing in My document section or not");
			
		 		extentlogger.info("Expected_Results===>: Created file , uploaded file  should be show in My document section"); 	
		 
		 		Thread.sleep(1000);
			
		 		WebElement create_doc=driver.findElement(By.xpath(OR.getProperty("ntbk_createDoc_xpath")));
			
		 		create_doc.click();
			
		 		WebElement file_na_txtbox=driver.findElement(By.xpath(OR.getProperty("ntbk_alert_txtbx_xpath")));
			
		 		Thread.sleep(2000);
			
		 		file_na_txtbox.clear();
			
		 		file_na_txtbox.sendKeys(config.getProperty("filename_TC_NB012"));
			
		 		WebElement createfile_btn=driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_create_btn_xpath")));
			
		 		createfile_btn.click();
			
		 		Thread.sleep(4000);
		   
			
		 		List<WebElement> allOptions=driver.findElements(By.xpath(OR.getProperty("ntbk_createdoc_MyDocument_list_xpath")));
			 
		 		for(WebElement selectLi: allOptions)
		 		{ 
		 			String ss=selectLi.getAttribute("innerText");
		 			
		 			if(ss.contentEquals("general.docx"))
		    	{
		    		System.out.println("**Created document,uploaded File name match successfully===>:" +ss);
		    	}		    	
		       }
							 
			}
	 
	 @Test(enabled = false,
			 description = "Check that Action section button(like download ,edit ,delete ,share) display or not || Should be display")
	 
	 public void TC_NB013() throws InterruptedException 
		  {	
		 		extentlogger = extentreport.createTest("TC_NB013");
			
		 		extentlogger.info("Notes_Test_Scenario===>: Check that Action section button(like download ,edit ,delete ,share) display or not");
			
		 		extentlogger.info("Expected_Results===>: Should be display"); 	
		 
		 		Thread.sleep(1000);
		 		
		 		Actions ToolTipDownload = new Actions(driver);
			    
		 		WebElement downloadtooltip_val = driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_download_btn_xpath")));
			    
		 		Thread.sleep(1000);
			    
		 		ToolTipDownload.clickAndHold(downloadtooltip_val).perform();
			    
		 		String download=downloadtooltip_val.getAttribute("title");
			    
		 		Actions ToolTipEditfName = new Actions(driver);
			    
		 		WebElement Editname_tl_value = driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_editname_btn_xpath")));
			    
		 		Thread.sleep(1000);
			    
		 		ToolTipEditfName.clickAndHold(Editname_tl_value).perform();
			    
		 		String delete=Editname_tl_value.getAttribute("title");
			    
		 		Actions ToolTipDeletefName = new Actions(driver);
		         
		 		WebElement delete_tl_value = driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_delete_btn_xpath")));
			    
		        Thread.sleep(1000);
			     
		        ToolTipDeletefName.clickAndHold(delete_tl_value).perform();
			     
		        String Edit=delete_tl_value.getAttribute("title");
			     
		        Actions ToolTipSharefName = new Actions(driver);
		        
		        WebElement share_tl_value = driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_share_btn_xpath")));
			    
		        Thread.sleep(1000);
			    
		        ToolTipSharefName.clickAndHold(share_tl_value).perform();
			    
		        String share=share_tl_value.getAttribute("title");
			    
		        System.out.println("Action section button is present ==>:\n" +download+ "\n"+ delete + "\n" + Edit+ "\n"  + share+ "\n");
		  }
	 
	  
	  @Test(enabled = false,
			  description = "Checking the functionality of delete button || After clicking on the delete symbol warning popup should be display after that click on the ok button, file should be dleted successfully")
	  
	  public void TC_NB014() throws InterruptedException 
		  {	
		  		extentlogger = extentreport.createTest("TC_NB014");
			
		  		extentlogger.info("Notes_Test_Scenario===>: Checking the functionality of delete button");
			
		  		extentlogger.info("Expected_Results===>: After clicking on the delete symbol warning popup should be display after that click on the ok button, file should be dleted successfully"); 	
		  
		  		Thread.sleep(1000);
				
		  		WebElement deletebtn = driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_delete_btn_xpath")));
				
		  		if(deletebtn.isDisplayed())
				{
					deletebtn.click();
				}	
				
		  		Thread.sleep(1000);
				
		  		if(isElementPresent(By.className(OR.getProperty("ntbk_createdoc_del_warning_class"))))
				{
					WebElement warning_smg =driver.findElement(By.className(OR.getProperty("ntbk_createdoc_del_warning_class")));
					
					Thread.sleep(1000);
					
					String succ_msg= warning_smg.getText();
					
					System.out.println("Alert message display===>:" +succ_msg);
					
					driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_del_warning_yesbtn_xpath"))).click();
					
					System.out.println("File is deleted successfully");
				}
				else
				{
					System.out.println("Element is not present");
				}
        }
	  	  
	  
	  @Test(enabled = false,
			  description = "Check whether deleted file display in my document or not || Deleted file should not display in my document list")
	  
	  public void TC_NB015() throws InterruptedException 
		  {	
		  		extentlogger = extentreport.createTest("TC_NB015");
			
		  		extentlogger.info("Notes_Test_Scenario===>: Check whether deleted file display in my document or not");
			
		  		extentlogger.info("Expected_Results===>: Deleted file should not display in my document list"); 	
		  
		  		Thread.sleep(1000);
				
		  		WebElement deletebtn = driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_delete_btn_xpath")));
				
		  		if(deletebtn.isDisplayed())
				{
					deletebtn.click();
				}	
				
		  		Thread.sleep(1000);
				
		  		if(isElementPresent(By.className(OR.getProperty("ntbk_createdoc_del_warning_class"))))
				{
					WebElement warning_smg =driver.findElement(By.className(OR.getProperty("ntbk_createdoc_del_warning_class")));
					
					Thread.sleep(1000);
					
					String succ_msg= warning_smg.getText();
					
					System.out.println("Alert message display ===>:"+succ_msg);
					
					driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_del_warning_yesbtn_xpath"))).click();
					
					Thread.sleep(2000);
					
					WebElement geterrosmg =driver.findElement(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class")));
					
					Thread.sleep(2000);
					
					String Deletesucc_msg= geterrosmg.getText();
					
					System.out.println("**Success message is display*===>:"+Deletesucc_msg);					
				}
				else
				{
					System.out.println("Element is not present");
				}
				
				//verify deleted file display in my document or not
				List<WebElement> allOptions=driver.findElements(By.xpath(OR.getProperty("ntbk_createdoc_MyDocument_list_xpath")));				 
				
				for(WebElement selectLi: allOptions)
			      { 
			    	String ss=selectLi.getAttribute("innerText");
			    	
			    	if(ss.contentEquals("Automations.docx"))
			    	{
			    		System.out.println(ss);
			    	}
			    	
			    	System.out.println(ss); 
			       }
				  
				System.out.println("**Deleted file is not display in my document section**");
        }
	  
	  
	  @Test(enabled = false,
			  description = "Check that after clicking on download button file is downloaded or not || File should be download in our local system")
	  
	  public void TC_NB016() throws InterruptedException 
		  {	
		  		extentlogger = extentreport.createTest("TC_NB016");
			
		  		extentlogger.info("Notes_Test_Scenario===>: Check that after clicking on download button file is downloaded or not");
			
		  		extentlogger.info("Expected_Results===>: File should be download in our local system"); 	
		  
		  		Thread.sleep(1000);
				WebElement download = driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_download_btn_xpath")));
				if(download.isDisplayed())
				{
					download.click();
					Thread.sleep(1000);
					System.out.println("File is downloaded successfully in our local system.");
				}	
				else
				{
					System.out.println("Download button is not display and not downloaded");
				}
        }
	  
	  
	  @Test(enabled = false,
			  description = "Check that shareable file display in Shared Documents or not || It should be display in Shared Documents section")
	  
	  public void TC_NB018() throws InterruptedException 
		  {	
		  		extentlogger = extentreport.createTest("TC_NB018");
			
		  		extentlogger.info("Notes_Test_Scenario===>: Check that shareable file display in Shared Documents or not");
			
		  		extentlogger.info("Expected_Results===>: It should be display in Shared Documents section"); 	
		  
		  		Thread.sleep(1000);				
				
		  		WebElement DocumentTab=driver.findElement(By.xpath(OR.getProperty("ntbk_createdoc_MyDocument_list_xpath")));
				
		  		//My document first element inner text
				String document=DocumentTab.getAttribute("innerText");
				
				System.out.println("**Before clicking shareLink File name is===>" +document );
				
				WebElement Sherebtn=driver.findElement(By.xpath(OR.getProperty("ntbk_myDoc_share_Btn_xpath")));				
				
				Sherebtn.click();
				
				Thread.sleep(1000);
				
				//select one options 
				WebElement Share_this_Document=driver.findElement(By.xpath(OR.getProperty("ntbk_myDoc_shareDoc_slectone_xpath")));
				
				Share_this_Document.click();
				
				Thread.sleep(1000);
				
				WebElement Popup_Sharebtn=driver.findElement(By.xpath(OR.getProperty("ntbk_myDoc_shareDoc_sharepop_btn_xpath")));
				
				//click on the popup share Btn
				Popup_Sharebtn.click();
				
				Thread.sleep(2000);
				
				if(isElementPresent(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class"))))
				{
					WebElement geterrosmg =driver.findElement(By.className(OR.getProperty("ntbk_createdoc_totesmsg_class")));
					
					Thread.sleep(2000);
					
					String succ_msg= geterrosmg.getText();
					
					System.out.println("Share file Success message is**===>:"+succ_msg + "***And file name is===>:"+document);
				}
				else
				{
					System.out.println("Share file Success message is not display");
				}	
				
				Thread.sleep(2000);
				
				TestBase_Knovva.ClickOnHamburgerMenu();
				
				Thread.sleep(2000);
				
				TestBase_Knovva.ClickOnLogoutBtn();
				
				//Login as a different credentials 
				WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
				
				WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
				
				log_email.clear();
				
				log_email.sendKeys(config.getProperty("usernameTC_NB018"));
				
				lg_password.clear();
				
				lg_password.sendKeys(config.getProperty("passwordTC_NB018"));
				
				Thread.sleep(2000);

				driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
				
				Thread.sleep(2000);
				
				TestBase_Knovva.ClickOnHamburgerMenu();
			    
				//click on the notebook 
				Thread.sleep(1000);
				
				driver.findElement(By.xpath(OR.getProperty("ntbk_xpath"))).click();
				
				Thread.sleep(1000);
				
				//click on the shareDocument Tab
				WebElement ShareDocument_Tab = driver.findElement(By.id(OR.getProperty("SharedDoc_tab_id")));
				
				ShareDocument_Tab.click();
				
				Thread.sleep(1000);
				
				//Verify shared file is display or not
				List<WebElement> allOptions=driver.findElements(By.xpath(OR.getProperty("ntbk_ShareFile_list_xpath")));
				
				Thread.sleep(2000);
				
				for(WebElement selectLi: allOptions)
			      { 
			    	String ss=selectLi.getAttribute("innerText");
			    	
			    	if(ss.contentEquals(document))
			    	{
			    		System.out.println("**Shareable file is display in Shared Documents**==>:" +ss);
			    	}		    	
			       }
				
				TestBase_Knovva.ClickOnHamburgerMenu();
				
				Thread.sleep(1000);
				
				TestBase_Knovva.ClickOnLogoutBtn();
				
				Thread.sleep(1000);
				
				TestBase_Knovva.validLogin();
				
				Thread.sleep(1000);
				
				TestBase_Knovva.ClickOnHamburgerMenu();
				
				//click on the notebook tab
				driver.findElement(By.xpath(OR.getProperty("ntbk_xpath"))).click();
				
        }
	  
	  
	  @Test(enabled = false,
			  description = "Check that Download Link display or not")
	  public void TC_NB019() throws InterruptedException 
		  {	
		  		extentlogger = extentreport.createTest("TC_NB019");
			
		  		extentlogger.info("Notes_Test_Scenario===>: Check that Download Link display or not");
			
		  		extentlogger.info("Expected_Results===>: It should be display Download Link in Supplemental Documents section"); 	
		  
		  		Thread.sleep(1000);
				
		  		WebElement SupplementalDocuments = driver.findElement(By.xpath(OR.getProperty("ntbk_SupplementalDoc_txt_xpath")));
				
		  		//check that SupplementalDocuments tab is enable or not
		  		if(SupplementalDocuments.isEnabled())
				{
					SupplementalDocuments.click(); 
					
					Thread.sleep(1000);
					
					WebElement DownloadLink = driver.findElement(By.xpath(OR.getProperty("ntbk_SupplementalDoc_downLink_txt_xpath")));
					
					String Dnl=DownloadLink.getText();
					
					System.out.println("***Download link display with the name===>:" +Dnl);
				}	
		  		
				else
				{
					System.out.println("Supplemental Documents tag is not enabled");
				}
        }
	  
	   
	  @Test(enabled = false,
			  description = "Check that after clicking on download link file is downloaded or not || File should be download in our local system")
	  
	  public void TC_NB020() throws InterruptedException 
		  {	
		  		extentlogger = extentreport.createTest("TC_NB020");
			
		  		extentlogger.info("Notes_Test_Scenario===>: Check that after clicking on download link file is downloaded or not");
			
		  		extentlogger.info("Expected_Results===>: File should be download in our local system"); 	 
		  
				Thread.sleep(1000);
				
				WebElement SupplementalDocuments = driver.findElement(By.xpath(OR.getProperty("ntbk_SupplementalDoc_txt_xpath")));
				
				//check that SupplementalDocuments tab is enable or not
				
				if(SupplementalDocuments.isEnabled())
				{
					SupplementalDocuments.click(); 
					
					Thread.sleep(1000);
					
					WebElement DownloadLink = driver.findElement(By.xpath(OR.getProperty("ntbk_SupplementalDoc_downLink_txt_xpath")));
					
					//check that DownloadLink display or not
					
					if(DownloadLink.isDisplayed())
					{
						DownloadLink.click();
						
						System.out.println("Supplemental Documents file is downloaded successfully in our local system.");
					}
					else
					{
						System.out.println("Supplemental Documents file is not display");
					}
				}	
				else
				{
					System.out.println("Supplemental Documents tag is not enabled");
				}
				  Log.info("Notes module test case Ended !!!");
        }
  
  
	  @AfterTest
	    public void callTearDown() {
	    	
		  Notes.tearDown();
	    }
	    
	    
	    @AfterSuite
	    public void storeReport() {
	    	Notes.captureReport();
	    }
}

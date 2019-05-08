package com.knovva.TestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import com.knovva.utilities.Log;

public class Community extends TestBase_Knovva
{
	
	@BeforeSuite
	public void callSetup() {
		
		Community.setUp();
	}
	
	
	@BeforeTest
	public void callBrowser() {
		
		Community.browserLaunch();
	}
	
	 
	 @Test(enabled = true,
			 description="Check whether there is an option for Create Thread for Event/Course or not || There is a Submit New Post "
			 		+ "button for creating a Thread")
	 
	  public void TC_C001() throws InterruptedException 
	  {
		 	Log.info("Community test case started !!!");
	    	
	    	extentlogger = extentreport.createTest("TC_C001");
			
	    	extentlogger.info("Community_Test_Scenario===>: Check whether there is an option for Create Thread for Event/Course or not");
			
			extentlogger.info("Expected_Results===>:There is a Submit New Post button for creating a Thread");
		 
			TestBase_Knovva.ClickOnHamburgerMenu();		  
	    	
			Thread.sleep(2000);
		    
			//click on the community section
		     driver.findElement(By.xpath(OR.getProperty("Com_tag_xpath"))).click();
		     
		     Thread.sleep(1000);
		     
		     WebElement SubNewPostBtn=driver.findElement(By.xpath(OR.getProperty("Com_SubNewPostBtn_xpath")));
		     
		     Thread.sleep(1000);
		     
		     //check SubNewPostBtn display or not
		     if(SubNewPostBtn.isDisplayed()) 
		     {
		    	 Thread.sleep(1000);
		    	 
		    	 String getSubNewpostTxt=SubNewPostBtn.getText();
		    	 
		    	 System.out.println("****Submit new post button is present with the name of===>:" +getSubNewpostTxt);
		     }
		     else
		     {
		    	 System.out.println("***Submit new post button is not display***");
		     }	
		     
	  }
	 
	 
	  @Test(enabled=true,
			  description="Check whether there is an option for Edit Thread for Event/ Course or not || There is no button for Editing "
			  		+ "Thread")
	  
	  public void TC_C003() throws InterruptedException 
	  {		 
		   	extentlogger = extentreport.createTest("TC_C003");
			
	    	extentlogger.info("Community_Test_Scenario===>: Check whether there is an option for Edit Thread for Event/ Course or not");
			
			extentlogger.info("Expected_Results===>:There is no button for Editing Thread");    
		  
			Thread.sleep(1000);		     
		    
			WebElement searchbox=driver.findElement(By.id(OR.getProperty("Com_SearchBox_id")));
		    
			searchbox.clear();
		    
			//put some value in search field
		    searchbox.sendKeys(config.getProperty("CommunitySearch_TC_C003"));
		      
		    // String EnterValue= searchbox.getText();
		    WebElement searchBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchBtn_xpath")));
		    
		    //click on the searchBtn
		    searchBtn.click();
		    
		    Thread.sleep(1000);
		      
		    WebElement SearchFavorite=driver.findElement(By.xpath(OR.getProperty("Com_SearchFavorite_xpath")));
		    
		    Thread.sleep(1000);
		    
		    String FavoriteTxtvalue=SearchFavorite.getText();
		      
		    WebElement ReportBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchReport_xpath")));
		    
		    String ReportBtntxtValue= ReportBtn.getText();
		      
		    String actualvalue="Edit" ;
		    
		    Thread.sleep(3000);
		    
		    //check the condition for edit button present or not
		     if(FavoriteTxtvalue.equals(actualvalue) || ReportBtntxtValue.equals(actualvalue))
		      {
		    	  Thread.sleep(1000);
		    	  
		    	  System.out.println("***Edit Thread button is present***");
		      }
		      else
		      {
		    	  System.out.println("**Edit Thread button is not present*** ");
		      }		
		     
		      driver.navigate().refresh();     	     
	     }
	  
	  
	  @Test(enabled=true,
			  description="Check whether Reply (edit if yours), Report, Like, Quote, these options are present or not || Following should "
			  		+ "be present: "
			  		+ "i. Reply to comments button is present.\n" + 
			  		" ii. Edit if it's my own comment- Done in Online, unable to test in Dev as unable to reply to a comment in Dev.\n" + 
			  		" iii. Report button is there.\n" + 
			  		" iv. Like icon is there as \"Applause\" button here.\n" + 
			  		" v. Quote option is there")
	  
	  public void TC_C004() throws InterruptedException 
	  {		 
		  extentlogger = extentreport.createTest("TC_C004");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether Reply (edit if yours), Report, Like, Quote, these options are present or not");
			
		  extentlogger.info("Expected_Results===>:Following should be present: "
		  		+ "i. Reply to comments button is present."
		  		+ "ii. Edit if it's my own comment- Done in Online, unable to test in Dev as unable to reply to a comment in Dev."
		  		+ "iii. Report button is there."
		  		+ "iv. Like icon is there as Applause button here."
		  		+ "v. Quote option is there");    
		  
		  Thread.sleep(2000);		     
		  
		  WebElement searchbox=driver.findElement(By.id(OR.getProperty("Com_SearchBox_id")));
		  
		  searchbox.clear();
		  
		  //put some value in search field
		  searchbox.sendKeys(config.getProperty("CommunitySearch_TC_C003"));
		      
		  // String EnterValue= searchbox.getText();
		  WebElement searchBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchBtn_xpath")));
		  
		  //click on the searchBtn
		  searchBtn.click();
		  
		  Thread.sleep(1000);
		  
		  //click on search result
		  WebElement clkonSerchRlt=driver.findElement(By.xpath(OR.getProperty("Com_Search_clkOn_searRlt_xpath")));
		  
		  clkonSerchRlt.click();
		      
		  Thread.sleep(2000);
		  
		  WebElement applauseBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchRplyEdit_applause_xpath")));
		  
		  String applauseBtntxt=applauseBtn.getText();
		      
		  WebElement replyBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchRplyEdit_reply_xpath")));
		  
		  String replyBtntxt=replyBtn.getText();
		      
		  WebElement reportBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchRplyEdit_report_xpath")));
		  
		  String reportBtntxt=reportBtn.getText();
		      
		  WebElement editBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchRplyEdit_edit_xpath")));
		  
		  String editBtntxt=editBtn.getText();
		      
		  WebElement deleteBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchRplyEdit_delete_xpath")));
		  
		  String deleteBtntxt=deleteBtn.getText();
		      
		  System.out.println("***Matches options are===>:"  +applauseBtntxt+ "," +replyBtntxt+ "," +reportBtntxt+"," +editBtntxt + ',' +deleteBtntxt);
		  
		  driver.navigate().back();
		      		           		      
		  driver.navigate().refresh();     	     
	     }
	 
	  
	  @Test(enabled=true,
			  description="Check whether these options are functioning or not ,like Reply (edit if yours) || All the functions should "
			  		+ "be working")
	  
	  public void TC_C005() throws InterruptedException 
	  {		 
		  extentlogger = extentreport.createTest("TC_C005");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether these options are functioning or not ,like Reply (edit if yours)");
			
		  extentlogger.info("Expected_Results===>:All the functions should be working");    
		  
		  Thread.sleep(1000);		     
		      
		  WebElement searchbox=driver.findElement(By.id(OR.getProperty("Com_SearchBox_id")));
		  
		  searchbox.clear();
		  
		  searchbox.sendKeys(config.getProperty("CommunitySearch_TC_C003"));
		  
		  // String EnterValue= searchbox.getText();
		  WebElement searchBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchBtn_xpath")));
		  
		  //click on the searchBtn
		  searchBtn.click();
		  
		  Thread.sleep(1000);
		      
		  WebElement SearchResultClick=driver.findElement(By.xpath(OR.getProperty("Com_Search_clkOn_searRlt_xpath")));
		  
		  Thread.sleep(1000);
		  
		  SearchResultClick.click();
		  
		  Thread.sleep(1000);
		  
		  WebElement RplyComEditBtn=driver.findElement(By.xpath(OR.getProperty("Com_Search_rplyCom_edit_xpath")));
		  
		  WebElement EditEnterDesc=driver.findElement(By.xpath(OR.getProperty("Com_EditCom_EnterDescription_xpath")));
		  
		  if(RplyComEditBtn.isEnabled())
		      {
		    	  RplyComEditBtn.click();
		    	  
		    	  Thread.sleep(1000);
		    	  
		    	  EditEnterDesc.clear();
		    	  
		    	  EditEnterDesc.sendKeys("*****automation for testing desc");	    	  
		    	  
		    	  System.out.println("enter desc working fine");
		      }
		           	     
	     }	  
	   
	  
	@Test(enabled = true,
			  description = "Check whether these options are there or not || All the following functions "
			  		+ "should be there: Like, Report, Save to favourite function on Post page")
	
	  public void TC_C006() throws InterruptedException 
	  {		 
		  	extentlogger = extentreport.createTest("TC_C006");
			
	    	extentlogger.info("Community_Test_Scenario===>: Check whether these options are there or not");
			
			extentlogger.info("Expected_Results===>: All the following functions should be there: Like, Report, "
					+ "Save to favourite function on Post page");
		  
			Thread.sleep(2000);		     
	      
			WebElement searchbox=driver.findElement(By.id(OR.getProperty("Com_SearchBox_id")));
	      
			searchbox.clear();
	      
			//put some value in search field
			searchbox.sendKeys(config.getProperty("CommunitySearch_TC_C003"));
	      
			WebElement searchBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchBtn_xpath")));
	      
			//click on the searchBtn
			searchBtn.click();
	    
		    Thread.sleep(2000);		     
		    
		    WebElement favrouteBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchFavorite_xpath")));
		    
		    String  favrouteBtntxt=favrouteBtn.getText();
		      
		    WebElement Report=driver.findElement(By.xpath(OR.getProperty("Com_SearchReport_xpath")));   
		    
		    String  Reporttxt=Report.getText();
		      
		    WebElement Applause=driver.findElement(By.xpath(OR.getProperty("Com_SearchApplauses_xpath")));
		    
		    String  Applausetxt=Applause.getText();
		      
		    WebElement Posts=driver.findElement(By.xpath(OR.getProperty("Com_SearchPosts_xpath")));
		    
		    String  Poststxt=Posts.getText();
		      
		    System.out.println("****All options present are ==>:"  +favrouteBtntxt +',' +Reporttxt + ',' + Applausetxt+ ',' +Poststxt);
		      
	  }
	  
	  
	  @Test(enabled = true,
			  description = "Check whether these options are functioning or not || All the following "
	  		+ "functions should be working: Like, Report, Save to favourite function on Post page")
	  
	  public void TC_C007() throws InterruptedException 
	  {		 
		  extentlogger = extentreport.createTest("TC_C007");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether these options are functioning or not");
			
		  extentlogger.info("Expected_Results===>: All the following functions should be working: Like, "
					+ "Report, Save to favourite function on Post page");
		  
		  Thread.sleep(2000);		     
	      
		  WebElement searchbox=driver.findElement(By.id(OR.getProperty("Com_SearchBox_id")));
	      
		  searchbox.clear();
	      
		  //put some value in search field
	      searchbox.sendKeys(config.getProperty("CommunitySearch_TC_C003"));
	      
	       WebElement searchBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchBtn_xpath")));
	      
	       //click on the searchBtn
	       searchBtn.click();
	    
		   Thread.sleep(2000);		     
		   
		   WebElement favrouteBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchFavorite_xpath")));
		   
		   // String  favrouteBtntxt=favrouteBtn.getText();
		   favrouteBtn.click();
		   
		   Thread.sleep(1000);
		      
		   //count claps before click claps btn
		   WebElement countClaps =driver.findElement(By.xpath(OR.getProperty("Com_clapsCount_xpath")));
		   
		   Thread.sleep(2000);
		   
		   String totalCountBeforeclick=countClaps.getAttribute("innerText");
		   		      
		   //count claps after click claps btn
		   WebElement clickClaps =driver.findElement(By.xpath(OR.getProperty("Com_clapsbtn_xpath")));
		   
		   clickClaps.click();
		   
		   Thread.sleep(2000);
		   
		   //total count claps
		   
		   String totalCountAfterclick=clickClaps.getAttribute("innerText");
		   
		   if(!totalCountBeforeclick.equals(totalCountAfterclick))
		      {
		    	  Thread.sleep(2000);
		    	  
		    	  System.out.println("***Claps functionality is working**===>" +"Before click claps total count ==>" +totalCountBeforeclick + "***After click claps total count==>" +totalCountAfterclick);
		      }
		      else
		      {
		    	  System.out.println("***Claps functionality is not working***===>");
		      }
		     
		     //click on the FavoritesTab
		      WebElement FavoritesTab =driver.findElement(By.xpath(OR.getProperty("Com_FavoritesTab_xpath")));
		      
		      //String  Poststxt=FavoritesTab.getText();
		      FavoritesTab.click();
		      
		      Thread.sleep(1000);
		      
		      //go to event name and get
		      WebElement FavEventNmae =driver.findElement(By.xpath(OR.getProperty("Com_FavoritesTab_getEventName_xpath")));
		      
		      Thread.sleep(2000);
		      
		      if (isElementPresent(By.xpath(OR.getProperty("Com_FavoritesTab_getEventName_xpath")))) 
				{
		    	  System.out.println("**After clicking on the favourite btn item added to favourite tab added team is**====> " +FavEventNmae.getText());	              
				}
			   else
			   {
				System.out.println("***Added item is not display in favourite tab*** ");
			   }			      
		      
	     }
	  
	 	  
	  @Test(enabled = false,
			  description = "Check whether these options are present or not || Following options should be present\n" + 
			  		" i. Newest\n" + 
			  		" ii. Latest\n" + 
			  		" iii. Popular")
	  
	  public void TC_C010() throws InterruptedException 
	  {
		  extentlogger = extentreport.createTest("TC_C010");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether these options are present or not");
			
		  extentlogger.info("Expected_Results===>:Following options should be present\n" + 
					" i. Newest\n" + 
					" ii. Latest\n" + 
					" iii. Popular");    
		  
		  WebElement AllTab=driver.findElement(By.id(OR.getProperty("Com_Events_AllTab_id")));
		  
		  //click on the all tab options
		  AllTab.click();
		  
		  Thread.sleep(1000);		     
		  
		  WebElement ele=driver.findElement(By.id(OR.getProperty("Com_sortBy_dropdn_id")));
		  
		  ele.click();
		  
		  Thread.sleep(1000);
		  
		  Select select = new Select(ele);
		  
		  List<WebElement> alloption = select.getOptions();
		  
		  for (WebElement suggestion : alloption)
		        {
		           System.out.println(suggestion.getText());
		        }	     
		  
	     }
	   
	 
	  @Test(enabled = false,
			  description = "Check whether search text box is present in Community page or not || There "
	  		+ "is a Search text box in Community page")
	  
	  public void TC_C012() throws InterruptedException 
	  {		 
		  extentlogger = extentreport.createTest("TC_C012");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether search text box is present in Community page or not");
			
		  extentlogger.info("Expected_Results===>: There is a Search text box in Community page");    
		  
		  Thread.sleep(1000);		     
		  
		  WebElement searchbox=driver.findElement(By.id(OR.getProperty("Com_SearchBox_id")));
		  
		  String placceholderNM= searchbox.getAttribute("placeholder");
		  
		  Thread.sleep(1000);	
		  
		  if(placceholderNM.equals("Search:"))
		      {
		    	  System.out.println("***Search text box is present in Community page and placeholder name is:*** " +placceholderNM);
		      }
		      else
		      {
		    	  System.out.println("Search field placeholder name is not match");
		      }
     	     
	     }
	  
	 
	  @Test(enabled = false,
			  description = "Check whether search is functioning or not by searching with key words for any "
			  		+ "Post || User is able to search any post by inputting key words in Search text box")
	  
	  public void TC_C013() throws InterruptedException 
	  {		 
		  extentlogger = extentreport.createTest("TC_C013");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether search is functioning or not by searching "
		  		+ "with key words for any Post");
			
		  extentlogger.info("Expected_Results===>: User is able to search any post by inputting key words in Search text box");   
		  
		  Thread.sleep(1000);		     
		  
		  WebElement searchbox=driver.findElement(By.id(OR.getProperty("Com_SearchBox_id")));
		  
		  searchbox.clear();
		  
		  searchbox.sendKeys(config.getProperty("CommunitySearch_TC_C013"));
		  
		  String EnterValue= searchbox.getText();
		  
		  WebElement searchBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchBtn_xpath")));
		  
		  //click on the searchBtn
		  searchBtn.click();
		  
		  Thread.sleep(1000);
		  
		  WebElement SearchResult=driver.findElement(By.xpath(OR.getProperty("Com_SearchBtn_xpath")));
		  
		  Thread.sleep(1000);
		  
		  String SearchResultvalue=SearchResult.getText();
		  
		  Thread.sleep(1000);
		  
		  if(EnterValue.equals(SearchResultvalue))
		      {
		    	  Thread.sleep(1000);
		    	  
		    	  System.out.println("****Search functionality is working *** " +SearchResultvalue );
		      }
		      else
		      {
		    	  System.out.println("**Enter value and search value is not equals *** ");
		      }		      		      
		           	     
	     }
	  
	 
	  @Test(enabled = false,
			  description = "Check whether any alert message is getting displayed or not when no search "
			  		+ "results are found || No Alert message is getting displayed, only text 'Search "
			  		+ "Results:' is getting displayed")
	  
	  public void TC_C014() throws InterruptedException 
	  {		 
		  extentlogger = extentreport.createTest("TC_C014");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether any alert message is getting "
	    			+ "displayed or not when no search results are found");
			
		  extentlogger.info("Expected_Results===>: No Alert message is getting displayed, only text "
					+ "'Search Results:' is getting displayed");    
		  
		  Thread.sleep(1000);		     
		  
		  WebElement searchbox=driver.findElement(By.id(OR.getProperty("Com_SearchBox_id")));
		  
		  searchbox.clear();
		  
		  searchbox.sendKeys(config.getProperty("CommunitySearch_wrongN_TC_C014"));
		  
		  //String EnterValue= searchbox.getText();
		  WebElement searchBtn=driver.findElement(By.xpath(OR.getProperty("Com_SearchBtn_xpath")));
		  
		  //click on the searchBtn
		  searchBtn.click();
		  
		  Thread.sleep(1000);		  
		  
		  WebElement ReltNotfo_searchResult=driver.findElement(By.xpath(OR.getProperty("Com_WrongSearchResult_xpath")));
		  
		  System.out.println("****No any alert message is displayed only display with the "
		  		+ "text name *** :" + ReltNotfo_searchResult.getText());	      		          		      
		  
	}
	  
	 
	  @Test(enabled = false,
			  description = "Check whether notification icon is present or not || Notification icon is there as header")
	  
	  public void TC_C016() throws InterruptedException 
	  {		 
		  extentlogger = extentreport.createTest("TC_C016");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether notification icon is present or not");
			
		  extentlogger.info("Expected_Results===>: Notification icon is there as header");    
		  
		  Thread.sleep(1000);		     
		  
		  WebElement Notificationicon=driver.findElement(By.xpath(OR.getProperty("Com_Notifin_icon_xpath")));
		  
		  Thread.sleep(1000);
		  
		  if(Notificationicon.isDisplayed())
		      {
		    	  Notificationicon.click();
		    	  
		    	  Thread.sleep(2000);
		    	  
		    	  System.out.println("****Notification icon is display in header section ***:" );
		      }
		      else 
		      {
		    	  System.out.println("****Notification icon is not display in header section***:" );
		      }		      	      		          		      
		           
	     }
	  
	 
	  @Test(enabled=false,description="Check whether user is receiving notification when any other user likes their post/thread || Notification working")
	  public void TC_C017() throws InterruptedException 
	  {		 
		  extentlogger = extentreport.createTest("TC_C017");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether user is receiving notification when any other user likes their post/thread");
			
		  extentlogger.info("Expected_Results===>: Notification working");    
		  
		  Thread.sleep(1000);		     
		  
		  //Click on the notification bell icon		
		  WebElement Notificationicon=driver.findElement(By.xpath(OR.getProperty("Com_Notifin_icon_xpath")));
		  
		  Thread.sleep(1000);	      
			
		  Notificationicon.click();
			
		  Thread.sleep(2000);
			
		  WebElement NotificationiconFirsttext=driver.findElement(By.xpath(OR.getProperty("Com_Notifin_icon_firsttext_xpath")));
			
		  String ss= NotificationiconFirsttext.getText();
			   	 
		  System.out.println("****User is receiving notification when any other user likes/comments their post/thread**===>:" +ss );     		          		      
		     	     
	     }
	  
	  
	  @Test(enabled = false,
			  description = "Check whether these modules are present or not || Below option should be present \n" + 
			  		" i.All\n" + 
			  		" ii.Courses\n" + 
			  		" iii.Events\n" + 
			  		" iv.Students Club\n" + 
			  		" v.General\n" + 
			  		" vi.Favorites")
	  
	  public void TC_C018() throws InterruptedException 
	  {		 
		  extentlogger = extentreport.createTest("TC_C018");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether these modules are present or not");
			
		  extentlogger.info("Expected_Results===>: Below option should be present \n" + 
					" i.All\n" + 
					" ii.Courses\n" + 
					" iii.Events\n" + 
					" iv.Students Club\n" + 
					" v.General\n" + 
					" vi.Favorites");   
		  
		 TestBase_Knovva.validLogin();
		  
		 Thread.sleep(3000);		      
		 
		 List<WebElement> allOptions= driver.findElements(By.xpath(OR.getProperty("Com_Search_Ul_txt_xpath"))); //xpath of ul
		 
		 System.out.println("***Present tag is***:-");
		 
		 for(WebElement selectLi: allOptions)
		      {
		    	  System.out.println(selectLi.getAttribute("innerText")); 		    	  
		    	 
		    	}		      
		       	     
	     }
	  
	 
	  @Test(enabled = false,
			  description = "Check whether these icons are present or not")
	  public void TC_C019() throws InterruptedException 
	  {		 
		  extentlogger = extentreport.createTest("TC_C019");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether these icons are present or not");
			
		  extentlogger.info("Expected_Results===>: Submit, Cancel, buttons are present");    
		  
		  Thread.sleep(1000);		     
		  
		  WebElement SubNewPostBtn=driver.findElement(By.xpath(OR.getProperty("Com_SubNewPostBtn_xpath")));
		  
		  SubNewPostBtn.click();
		  
		  WebElement SubNew_subBtn=driver.findElement(By.xpath(OR.getProperty("Com_SubNew_SubBtn_xpath")));
		  
		  String subBtn=SubNew_subBtn.getText();
		  
		  WebElement SubNew_CanBtn=driver.findElement(By.xpath(OR.getProperty("Com_SubNew_CanBtn_xpath")));
		  
		  String can_btn= SubNew_CanBtn.getText();
		  
		  Thread.sleep(1000);		  
		  
		  System.out.println("****Available button are *** :" +subBtn + ","  +can_btn );	      		          		      
		       	     
	     }
	  
	  
	  @Test(enabled = false,
			  description = "Check whether Submit , Cancel options are enable or not || Submit button enable after putting all value, cancel button should be enable without putting any value")
	  
	  public void TC_C020() throws InterruptedException, Exception
	  {		 
		  extentlogger = extentreport.createTest("TC_C003");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether Submit , Cancel options are enable or not");
			
		  extentlogger.info("Expected_Results===>: Submit button enable after putting all value, cancel button should be enable without putting any value");    
		  
		  Thread.sleep(2000);		     
		  
		  WebElement SubNewPostBtn=driver.findElement(By.xpath(OR.getProperty("Com_SubNewPostBtn_xpath")));
		  
		  SubNewPostBtn.click();
		      
		  WebElement Topicdropdown =driver.findElement(By.xpath(OR.getProperty("Com_SubNew_TopicDrp_xpath")));
		  
		  Topicdropdown.click();
		  
		  Thread.sleep(1000);
		  
		  Select dropdown=new Select(Topicdropdown);
		  
		  dropdown.selectByVisibleText("Event");
		      
		  WebElement SubTopicdropdown =driver.findElement(By.xpath(OR.getProperty("Com_SubNew_subTopicDrp_xpath")));
		  
		  SubTopicdropdown.click();
		  
		  Thread.sleep(1000);
		  
		  Select subdropdown=new Select(SubTopicdropdown);
		  
		  subdropdown.selectByVisibleText("Sydney Summit");
		  
		  Thread.sleep(1000); 
		  
		  WebElement EnterTitle =driver.findElement(By.id(OR.getProperty("Com_SubNew_Entertitle_id")));
		  
		  EnterTitle.clear();
		  
		  EnterTitle.sendKeys("title for automation");
		        		      
		  Thread.sleep(2000);      
		    
		  Thread.sleep(5000);  
		  		      
		  WebElement SubNew_CanBtn=driver.findElement(By.xpath(OR.getProperty("Com_SubNew_CanBtn_xpath")));
		  
		  Thread.sleep(2000);
		   
		  if(SubNew_CanBtn.isEnabled())
		      {
		    	   SubNew_CanBtn.click();
		    	   
		    	   Thread.sleep(2000);
		    	  
		    	   System.out.println("****Submit and cancel both buttons are enable****");
		      }
		      else
		      {
		    	  System.out.println("****Submit and cancel both buttons are not enable****");
		      }		     		      
		          	     
	     }
	  
	  
      @Test(enabled = false,
    		  description = "Check whether Attach video media option is present or not || Attach Video media option is not present")
      
	  public void TC_C021() throws InterruptedException 
	  {		 
    	  extentlogger = extentreport.createTest("TC_C021");
			
    	  extentlogger.info("Community_Test_Scenario===>: Check whether Attach video media option is present or not");
			
    	  extentlogger.info("Expected_Results===>: Attach Video media option is not present");    
    	  
    	  Thread.sleep(1000);		     
		  
    	  WebElement SubNewPostBtn=driver.findElement(By.xpath(OR.getProperty("Com_SubNewPostBtn_xpath")));
		  
    	  if(SubNewPostBtn.isDisplayed()) 
		      {
		    	  SubNewPostBtn.click();
		    	  
		    	  Thread.sleep(3000);		 
		    	  
		    	  //store all value in list 
			      List<WebElement> allOptions= driver.findElements(By.xpath(OR.getProperty("Com_Search_desc_xpath"))); //xpath of ul
			      
			      System.out.println("***No any Attach video media option is present here only thease option available***");
			      
			      for(WebElement selectLi: allOptions)
			      { 
			    	System.out.println(selectLi.getAttribute("innerText")); 			    	  
			       }
			      
			      System.out.println("************************************************");
		      }
		      else 
		      {
		    	  System.out.println("**Submit new post button is not display***");
		      }
		           	     
	     }
	 
	  
	  @Test(enabled = false,
			  description = "Check whether these options are present or not || Create new thread Description")
	  
	  public void TC_C022() throws InterruptedException 
	  {		 
		  extentlogger = extentreport.createTest("TC_C022");
			
		  extentlogger.info("Community_Test_Scenario===>: Check whether these options are present or not");
			
		  extentlogger.info("Expected_Results===>: Create new thread Description");     
		  
		  Thread.sleep(1000);		     
		  
		  WebElement SubNewPostBtn=driver.findElement(By.xpath(OR.getProperty("Com_SubNewPostBtn_xpath")));
		  
		  if(SubNewPostBtn.isDisplayed()) 
		      {
		    	  SubNewPostBtn.click();
		    	  
		    	  Thread.sleep(3000);		 
		    	  
		    	  //store all value in list 
			      List<WebElement> allOptions= driver.findElements(By.xpath(OR.getProperty("Com_Search_desc_xpath"))); //xpath of ul
			      
			      System.out.println("***Present description tag option is***");
			      
			      for(WebElement selectLi: allOptions)
			      { 
			    	  System.out.println(selectLi.getAttribute("innerText")); 			    	  
			       }			    	  
		      }
		      else 
		      {
		    	  System.out.println("**Submit new post button is not display***");
		      }
		         
		      
		      Log.info("Community module test case Ended !!!");
	     }
	  
	  @AfterTest
	    public void callTearDown() {
	    	
	    	Community.tearDown();
	    }
	    
	    
	    @AfterSuite
	    public void storeReport() {
	    	Community.captureReport();
	    }
	
}

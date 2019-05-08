package com.knovva.TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.knovva.utilities.ExcelReader;
import com.knovva.utilities.Utils;

public class TestBase_Knovva {

	/*
	 * Webdriver Properties Logs ExtentReports DB Excel Mail
	 * 
	 */
	public static long PAGE_LOAD_TIMEOUT= 20;
	
	public static long IMPLICIT_WAIT = 10;
	
	public ExtentReports extent;
	
	public static WebDriver driver;
	
	public static Properties config = new Properties();
	
	public static Properties OR = new Properties();
	
	public static FileInputStream fis;
	
	public static FileInputStream fis_OR;
	
	public static Logger log = Logger.getLogger("devpinoylogger");
	
	public static ExtentReports extentreport;
	
	public static ExtentTest extentlogger;
	
	public static ExtentHtmlReporter extentHTMLReport;
	
	public static ExcelReader excel = new ExcelReader("./src/main/resources/TestData/testdata.xlsx");
	
	public static com.knovva.utilities.ExcelReader excel_forgot = new com.knovva.utilities.ExcelReader(
			System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\testdata.xlsx");
	
	public static com.knovva.utilities.ExcelReader excel_reg = new com.knovva.utilities.ExcelReader(
			System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\regdata.xlsx");
	
	public static com.knovva.utilities.ExcelReader excel_StClubAppForm = new com.knovva.utilities.ExcelReader(
			System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\StudentClubsAppFormData.xlsx");
	
	public static WebDriverWait wait;

		
	public static void setUp() 
	{
        if (driver == null) {

			try {
				
				fis = new FileInputStream(System.getProperty("user.dir")+"\\PropertiesFile\\config.properties");

			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}

			try {
				
				config.load(fis);
				
				log.debug("Config file loaded !!!");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			try {
				
				fis_OR = new FileInputStream(System.getProperty("user.dir") + "\\PropertiesFile\\OR.properties");
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}

			try {
				
				OR.load(fis_OR);
				
				log.debug("OR file loaded !!!");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			  extentHTMLReport = new ExtentHtmlReporter("./Report/Knovva_"+Utils.getCurrentDateTime()+".html");
				
			  extentreport = new ExtentReports();
				
			  extentreport.attachReporter(extentHTMLReport);

		}
	}
			
	
	public static void browserLaunch(){
		
		if (config.getProperty("browser").equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		log.debug("Chrome Launched !!!");
				
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
						TimeUnit.SECONDS);
		
		driver.get(config.getProperty("testsiteurl"));
				
	 }		
				
}

		  
	public static void validLogin() throws InterruptedException 
	{

		WebElement log_email = driver.findElement(By.id(OR.getProperty("lgnmail_ID")));
		
		WebElement lg_password = driver.findElement(By.id(OR.getProperty("lgnpass_ID")));
		
		log_email.clear();
		
		log_email.sendKeys(config.getProperty("Email"));
		
		lg_password.clear();
		
		lg_password.sendKeys(config.getProperty("Password"));
		
		driver.findElement(By.xpath(OR.getProperty("signin_xpath"))).click();
		
		Thread.sleep(2000);
	}
	
	public static void ClickOnHamburgerMenu() throws InterruptedException 
	{
		
		WebElement clickhmbtn= driver.findElement(By.xpath(OR.getProperty("ham_button_xpath")));
	    
		Actions action = new Actions(driver);
        
		action.moveToElement(clickhmbtn).build().perform();
        
		Thread.sleep(1000);
	    
		clickhmbtn.click();
		
		Thread.sleep(1000);
	}
	
	public static void ClickOnLogoutBtn() throws InterruptedException 
	{
		WebElement logout= driver.findElement(By.xpath(OR.getProperty("Logout_xpath")));
		 logout.click();
		 Thread.sleep(1000);
	    WebElement LogoutPopupBtn= driver.findElement(By.xpath(OR.getProperty("Logout_popupBtn_xpath")));
	    LogoutPopupBtn.click();
	    Thread.sleep(2000);
	}
	
	//-----Cross browser testing ---start
	
	public static void CrossBrowser(String browser) throws Exception
	{
		log.debug("Cross Browser method start!!!");
		
		//Check if parameter passed as 'chrome'
		
		if(config.getProperty("browser").equalsIgnoreCase("chrome"))
		
		{
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\chromedriver.exe");
			
			log.debug("set property!!!");
			
			driver = new ChromeDriver();

		  }
		 
		   //Check if parameter passed as 'Edge'
		 /*  else if(config.getProperty("browser").equalsIgnoreCase("Edge"))
				{
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver",
					
					System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\MicrosoftWebDriver.exe");
					
					//create Edge instance
					driver = new EdgeDriver();
				}*/
		 
		     //Check if parameter passed from TestNG is 'firefox'
					else if(config.getProperty("browser").equalsIgnoreCase("Firefox"))
		       	{
			    //create firefox instance
				  System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\geckodriver.exe");
			     
				  driver = new FirefoxDriver();
			     } 
		 
		  else
		    {
			
			  //If no browser passed throw exception
			throw new Exception("Browser is not correct");
			
		    }
		
		 log.debug("invoke chrome!!!");
		
	}
	
	//-----Cross browser testing ---end
	
	
	public boolean isElementPresent(By by) {
		try {
			
			driver.findElement(by);
			
			return true;
		}

		catch (NoSuchElementException e) {

			return false;
		}
	}

	public boolean isAlertPresents() {
		try {
			
			driver.switchTo().alert();
			
			return true;
		}

		catch (NoAlertPresentException e) {
			
			return false;
		}
	}
	
	   
	public static void captureReport() {
		
		extentreport.flush();
		
		driver.quit();
		
	}
	
	
	public static void tearDown() 
	{
		
       driver.quit();
       
       log.debug("Test Execution Successfully !!!");
				
	}
	
}

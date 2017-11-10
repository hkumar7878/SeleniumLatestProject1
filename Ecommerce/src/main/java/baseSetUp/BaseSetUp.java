package baseSetUp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.Configurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilLibrary.ExcelReader;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.DisplayOrder;


public class BaseSetUp {

   public static RemoteWebDriver driver;
   public static final Logger logger=Logger.getLogger(Test.class.getName());
    //public static ExtentTest logger;
    public static ExtentReports report;
    public static ExtentReports report1;
    public static ExtentTest FF_logger;
    public static ExtentTest CH_logger;
    public static ExcelReader Application_Test_Suite_Firefox=null;
    public static ExcelReader Application_Test_Suite_Chrome=null;
    public static ExcelReader Application_Test_Suite_IE=null;
    public static String strErrMsg_GenLib="";
    public static String browserName=null;
    DesiredCapabilities cap=null;
    String testName = "";
    public String browserID=null;
    public String XMLtestCaseName=null;
    public String XMLtestCaseID=null;
    public static int suiteRow_FF=0;
    public static int suiteRow_CH=0;
    String currentDir=null;
    String localNodeURL;
    DesiredCapabilities capability=null;
    int i=0;
    String [][] excelData=null;
    public static ExcelReader excelReader = null;

    public void init() throws IOException
    {
    	// Test Change to GIT central repository
        
    	Application_Test_Suite_Firefox=new ExcelReader(System.getProperty("user.dir")+"\\ExcelFiles\\Application_Test_Suite_Firefox.xlsx");
        Application_Test_Suite_Chrome=new ExcelReader(System.getProperty("user.dir")+"\\ExcelFiles\\Application_Test_Suite_Chrome.xlsx");
        Application_Test_Suite_IE=new ExcelReader(System.getProperty("user.dir")+"\\ExcelFiles\\Application_Test_Suite_IE.xlsx");
    }
    
    
    // This method will also fetch the from excel
    
    public String [][] getExcelData1(String ExcelName,String SheetName)
    {
    	String path= System.getProperty("user.dir")+"\\ExcelFiles\\" + ExcelName;
    	excelReader=new ExcelReader(path);
    	String[][] excelData = excelReader.getDatafromExcel(SheetName, ExcelName);
    	return excelData;
    }

    @BeforeTest
    @Parameters({"browserType"})
    public void onBeforeTest(String browserType,ITestContext testContext)
    {
    	String log4jConfigPath=System.getProperty("user.dir")+"\\"+ "log4j.properties";
        PropertyConfigurator.configure(log4jConfigPath);
        browserID=browserType;
        XMLtestCaseName=testContext.getName();
        try
        {
            if(XMLtestCaseName.contains("firefox"))
            {
                System.out.println("Inside Before Test class of BASE CLASS: FIREFOX");
                String filePath=System.getProperty("user.dir")+"\\"+ "TestReportsFirefox.html";
                report=new ExtentReports(filePath,true, DisplayOrder.OLDEST_FIRST);
                System.out.println("Inside Before Test class: FIREFOX & Extent Report for" + browserID + "is Initilized");
            }
            else if(XMLtestCaseName.contains("chrome"))
            {
                System.out.println("Inside Before Test class for CHROME");
                String filePath=System.getProperty("user.dir")+"\\"+ "TestReportsChrome.html";
                report1=new ExtentReports(filePath,true, DisplayOrder.OLDEST_FIRST);
                System.out.println("Inside Before Test class for CHROME & Extent Report for" + browserID + "is Initilized");
				/*currentDir = System.getProperty("user.dir");
	    		String chromeDriverLocation = currentDir + "/Browser Exes/chromedriver.exe";
	    		System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
	    		cap=DesiredCapabilities.chrome();
	    		cap.setBrowserName("chrome");
	    		cap.setPlatform(Platform.WINDOWS);
	    		System.out.println("Launching Chrome browser......");
	    		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);*/
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    /*public void getScreenShot(String name)
    {
    	Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

    	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	try {
    		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/selenium/ui/screenShot/";
    		File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
    		FileUtils.copyFile(scrFile, destFile);
    		Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
    	} 
    	
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }*/

    public void initializeTestBaseSetup(String browserType, String appURL)
    {
        try
        {

            if(browserType.contains("Firefox"))
            {
            	//System.setProperty("webdriver.gecko.driver", "D:\\Selenium Server\\geckodriver.exe");
            	//currentDir = System.getProperty("user.dir");
               // String chromeDriverLocation = currentDir + "/Browser Exes/chromedriver.exe";
            	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\"+ "Browser Exes/geckodriver.exe");
            	logger.info("Creating a object of Firefox Browser");
             
				capability = DesiredCapabilities.firefox();
				FirefoxOptions options = new FirefoxOptions();
				options.addPreference("log", "{level: trace}");
				capability.setCapability("marionette", true);
				capability.setCapability("moz:firefoxOptions", options);
                System.out.println("Launching Firefox browser......");
                localNodeURL="http://localhost:4444/wd/hub";
                driver = new RemoteWebDriver(new URL(localNodeURL), capability);
                logger.info("Navigating to " + appURL + "for Firefox browser");
                driver.get(appURL);
                driver.manage().window().maximize();
              
            }

            else if(browserType.contains("Chrome"))
            {
                currentDir = System.getProperty("user.dir");
                String chromeDriverLocation = currentDir + "/Browser Exes/chromedriver.exe";
                logger.info("Creating a object of Chrome Browser");
                cap=DesiredCapabilities.chrome();
                cap.setBrowserName("chrome");
                cap.setPlatform(Platform.WINDOWS);
                System.out.println("Launching Chrome browser......");
                System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                logger.info("Navigating to " + appURL + "for Chrome browser");
                driver.get(appURL);
                driver.manage().window().maximize();
               
            }

            
            
        }
        catch(Exception e)
        {
            System.out.println("Error....." + e.getMessage());
        }
        
        
    }

 



    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    /*@Parameters({"browserType"})
    @BeforeClass
    public void beforeClass(String browserType)
    {

    	if(browserType.contains("Firefox"))
    	{
    		System.out.println("Into before class for firefox browser" );
    	}
    	else if (browserType.contains("Chrome"))
    	{
    		System.out.println("Into before class for chrome browser" );
    	}
        getDriver().quit();
        dr.set(null);

    }*/
    /*@Parameters({"browserType"})
    @AfterClass
    public void afterClass(String browserType)
    {

    	if(browserType.contains("Firefox"))
    	{
    		System.out.println("Starting to quit browser for firefox " );
    	}
    	else if (browserType.contains("Chrome"))
    	{
    		System.out.println("Starting to quit browser for Chrome " );
    	}
        getDriver().quit();
        dr.set(null);

    }
*/




















































 /*   @AfterClass
    public void quitBrowser()
    {
    	System.out.println("Inside AFter class in base class to test");
    	for (WebDriver driver : this.webDriverPool)
		{
		      driver.quit();
		}
    }
    */



	/*public void initializeTestBaseSetup(String browserType, String appURL)
	{
		try
		{

			System.out.println("Inside Initlization Test:Base Class");
			this.driverThread   = new ThreadLocal<WebDriver>();
			// WebDriver webDriver = new RemoteWebDriver(...);
			browserName=browserType;
			setDriver_Grid(appURL);
		}
		catch(Exception e)
		{
			System.out.println("Error....." + e.getMessage());
		}
	}*/



	/*private void setDriver_Grid(String app_URL) throws InterruptedException, IOException
	{

    	try
    	{
    		switch(browserName)
    		{
    			case "Chrome":
    				currentDir = System.getProperty("user.dir");
    				String chromeDriverLocation = currentDir + "/Browser Exes/chromedriver.exe";
    				System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
    				cap=DesiredCapabilities.chrome();
    				cap.setBrowserName("chrome");
    				cap.setPlatform(Platform.WINDOWS);
    				System.out.println("Launching Chrome browser......");
    				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
    				webDriverPool.add(driver);
    				initChrome_Driver(app_URL,driver);
    				break;

    			case "IE":

    				cap=DesiredCapabilities.internetExplorer();
    				cap.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
    				cap.setPlatform(Platform.WINDOWS);
    				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
    				initIE_driver(app_URL,driver);
    				break;

    			case "Firefox":

    				Thread.sleep(2000);
    				currentDir = System.getProperty("user.dir");
    				String geckodriverDriverLocation = currentDir + "/Ecommere_Grid/Browser Exes/geckodriver.exe";
    				//System.setProperty("webdriver.gecko.driver","D:\\Ecommer_Grid\\Ecommere_Grid\\Browser Exes\\geckodriver.exe");
    				System.setProperty("webdriver.gecko.driver",geckodriverDriverLocation);
    				cap=DesiredCapabilities.firefox();
    				cap.setCapability("marionette", true);
    				cap.setPlatform(Platform.WINDOWS);
    				System.out.println("Launching Firefox browser..");
    				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
    				webDriverPool.add(driver);
    				initFirefoxDriver1(app_URL,driver);
    				break;
		}
		}
    	catch(Exception e)
		{
			System.out.println("Error....." + e.getMessage());
		}
	}*/

	/*private WebDriver initChrome_Driver(String appURL,WebDriver driver) throws InterruptedException, IOException
	{
		try
		{

			//System.setProperty("webdriver.chrome.driver", "D:\\ONDECK\\Drivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(2000);

			//Runtime.getRuntime().exec("D:\\ONDECK\\AutoITScripts\\HandleAuthenticationWindow1.exe");

			driver.navigate().to(appURL);
			Thread.sleep(20000);

		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return driver;
	}*/
    /*private static void initFirefoxDriver1(String appURL, WebDriver driver) throws InterruptedException, IOException
	{
		try
		{

			Thread.sleep(1000);
			driver.manage().window().maximize();
			//driver.manage().deleteAllCookies();
			//Runtime.getRuntime().exec("D:\\ONDECK\\AutoITScripts\\HandleAuthenticationWindow1.exe");
			//System.setProperty("webdriver.firefox.marionette",("user.dir")+"//"+ "Browser Exes//geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver","D:\\Ecommer_Grid\\Ecommere_Grid\\Browser Exes\\geckodriver.exe");
			//driver = new FirefoxDriver();
			//Test_Results_Firefox=new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\java\\ExcelFiles\\Application Test Results Files\\Test_Results-FireFox.xlsx");
			//report1=new ExtentReports(System.getProperty("user.dir")+"//"+ "TestReportsChrome.html");
			driver.navigate().to(appURL);


			 You can set the path to the actual file location of the driver
	        // String currentDir = System.getProperty("user.dir");
	        // String marionetteDriverLocation = currentDir + "/tools/marionette/wires.exe";
	        // System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);

	        //If you add the folder with geckodriver.exe (wires.exe) to the path then you only need the following line
	        // and you don't need to set the property as listed in the 3 lines above
	        // e.g. D:\Users\Alan\Documents\github\startUsingSeleniumWebDriver\tools\marionette
	       // WebDriver driver = new MarionetteDriver();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}


	}
    */
    /*private static void initIE_driver(String appURL, WebDriver driver) throws InterruptedException, IOException
	{
		try
		{
			System.out.println("Launching IE browser..");
			Thread.sleep(1000);
			//File file = new File("D:\\selenium\\IEDriverServer.exe");
	      //  System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver.manage().window().maximize();

			//driver.manage().deleteAllCookies();
			//Runtime.getRuntime().exec("D:\\ONDECK\\AutoITScripts\\HandleAuthenticationWindow1.exe");
			driver.navigate().to(appURL);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}


	}*/
}


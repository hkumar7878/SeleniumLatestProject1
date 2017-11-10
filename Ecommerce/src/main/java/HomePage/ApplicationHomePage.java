package HomePage;

import junit.framework.Assert;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilLibrary.GenericUtilLib;

import com.relevantcodes.extentreports.LogStatus;

import ErrorCollectors.ErrorCollector;
import baseSetUp.BaseSetUp;

public class ApplicationHomePage extends BaseSetUp{

    static boolean isEventSuccessful=false;

    // Home page log xpth
    // Xpath for Login PyramidCore Tab
    
    @FindBy(xpath="//a[@id='tab1']")
    public static WebElement tab_PydCore;
    
    // User id field
    
    @FindBy(id="pydLogin_txtUserid")
    public static WebElement txt_Userid;
    
    // Password field
    
    @FindBy(id="pydLogin_txtUserPwd")
    public static WebElement tx_Pswd;
    
    @FindBy(xpath="//input[@id='pydLogin_btnLogin']")
    public static WebElement btn_Login;

    // WebElement for Home link
	
 	@FindBy(xpath="//a[@href='../Home/PCIhome.aspx']")
 	public static WebElement link_Home;
    
    public ApplicationHomePage(RemoteWebDriver driver)
    {
    	this.driver = driver;
    	PageFactory.initElements(driver,this);
    }

    
    
    public void verify_Tab_Display(String browser)
    {

        try
        {
            Thread.sleep(1000);
            isEventSuccessful=GenericUtilLib.verifyTabDisplay(tab_PydCore,"Login Pyramidcore");
            Assert.assertTrue(isEventSuccessful);
            System.out.println("Login Pyramid tab is displayed");
            if(browser.contains("Firefox"))
            {
                FF_logger.log(LogStatus.PASS, "Login Pyramid tab is displayed");
                logger.info("#########Login Pyramid Tab is displayed###########");
            }
            else if (browser.contains("Chrome"))
            {
                CH_logger.log(LogStatus.PASS, "Login Pyramid tab is displayed");
                logger.info("#########Login Pyramid Tab is displayed###########");
            }
        }

        catch(Throwable t)
        {
            ErrorCollector.addVerificationFailure(t);
            logger.info("#########Login Pyramid Tab is NOT displayed###########");
            //logger.(LogStatus.FAIL, "Login Pyramid tab is NOT displayed");
        }
    }
    
    public void enterText(String browser, String fieldType, String fieldtext)
    {

        try
        {
            if(fieldtext.equals("User ID"))
            {
            	Thread.sleep(1000);
            	isEventSuccessful=GenericUtilLib.EnterText(txt_Userid,fieldType,fieldtext);
            	Assert.assertTrue(isEventSuccessful);
            	System.out.println("User id entered successfully");
            		if(browser.contains("Firefox"))
            		{
            			FF_logger.log(LogStatus.PASS, "Pass","User id entered successfully");
            			logger.info("Login Pyramid Tab is displayed and object is:-" +txt_Userid.toString());
            		}
            		else if (browser.contains("Chrome"))
            		{
            			CH_logger.log(LogStatus.PASS, "User id not entered successfully");
            			logger.info("Login Pyramid Tab is displayed and object is:-" +txt_Userid.toString());
            		}
            }
            
            if(fieldtext.equals("Password"))
            {
            	Thread.sleep(1000);
            	isEventSuccessful=GenericUtilLib.EnterText(tx_Pswd,fieldType,fieldtext);
            	Assert.assertTrue(isEventSuccessful);
            	System.out.println("User id entered successfully");
            	if(browser.contains("Firefox"))
            	{
            		FF_logger.log(LogStatus.PASS, "User id entered successfully");
            		logger.info("User id is displayed and object is :-" +tx_Pswd.toString());
            	}
            	else if (browser.contains("Chrome"))
            	{
            		CH_logger.log(LogStatus.PASS, "User id not entered successfully");
            		logger.info("User id is displayed and object is:-" +tx_Pswd.toString());
            	}
            }
        }

        catch(Throwable t)
        {
        	ErrorCollector.addVerificationFailure(t);
        	logger.info("Error message is" +tx_Pswd.toString());
        	String screenshot_path=GenericUtilLib.captureScreenShot3(driver, fieldtext,"Home Page",browser);
        	if(browser.contains("Firefox"))
        	{
        		String fail_image=FF_logger.addScreenCapture(screenshot_path);
        		FF_logger.log(LogStatus.FAIL,fieldtext + "is not entererd successfully: Refer below screen shot");
        		FF_logger.log(LogStatus.FAIL, fieldtext + "is not entererd successfully",fail_image);
        	}
        	else if(browser.contains("Chrome"))
        	{
        		String fail_image=CH_logger.addScreenCapture(screenshot_path);
        		CH_logger.log(LogStatus.FAIL,fieldtext + "is not entererd successfully: Refer below screen shot");
        		CH_logger.log(LogStatus.FAIL, fieldtext + "is not entererd successfully",fail_image);
        	}   	
        }
    }
    
    
    public void clickLoginBtn(String browser)
    {
    	
    	try 
    	{
    		isEventSuccessful=verify_btnDisplayed(browser);
    		Assert.assertTrue(isEventSuccessful);
    		GenericUtilLib.click_Element(btn_Login, "Login");
    		Assert.assertTrue(isEventSuccessful);
    		
    		if(browser.contains("Firefox"))
    			FF_logger.log(LogStatus.PASS, "Login Button is clicked successfully");
    		else if (browser.contains("Chrome"))
    			CH_logger.log(LogStatus.PASS, "Login Button is clicked successfully");
    	}
    	 catch(Throwable t)
        {
            ErrorCollector.addVerificationFailure(t);
           // logger.log(LogStatus.FAIL, "Login Button is Not clicked successfully");
           
        }
    }
    public boolean verify_btnDisplayed(String browser)
    {
    	boolean flag;
        try
        {
            
        	Thread.sleep(1000);
          
            isEventSuccessful=GenericUtilLib.verifyBtnDisplayed(btn_Login);
            Assert.assertTrue(isEventSuccessful);
            flag=true;
            
            System.out.println("Login Button is displayed successfully");
            
            if(browser.contains("Firefox"))
                FF_logger.log(LogStatus.PASS, "Login Button is displayed successfully");
            else if (browser.contains("Chrome"))
                CH_logger.log(LogStatus.PASS, "Login Button is displayed successfully");
        }

        catch(Throwable t)
        {
            ErrorCollector.addVerificationFailure(t);
           // logger.log(LogStatus.FAIL, "Login Button is Not displayed");
            flag=false;
        }
        return flag;
    }

    
public void clickLink(String browser, String LinkName)
	
	{
		try
		{
			GenericUtilLib.checkPageIsReady();
			if(LinkName.equalsIgnoreCase("Home"))
			{
				isEventSuccessful=GenericUtilLib.click_Element(link_Home, LinkName);
				Assert.assertTrue(isEventSuccessful);
				System.out.println(LinkName + "clicked successfully");
				if(browser.contains("Firefox"))
					FF_logger.log(LogStatus.PASS, LinkName + "clicked successfully");
				else if (browser.contains("Chrome"))
					CH_logger.log(LogStatus.PASS, LinkName + "clicked successfully");
			}			
		}
		
		catch(Exception t)
		{
			 ErrorCollector.addVerificationFailure(t);
	        // logger.log(LogStatus.FAIL, LinkName + "is not clicked successfully");
		}
	}
    public void verify_txt(String browser)
    {

        try
        {
            Thread.sleep(1000);
            Assert.assertTrue(isEventSuccessful);
            System.out.println("User ID Text displayed successfully");
            if(browser.contains("Firefox"))
                FF_logger.log(LogStatus.PASS, "User ID Text displayed successfully");
            else if (browser.contains("Chrome"))
                CH_logger.log(LogStatus.PASS, "User ID Text displayed successfully");
        }

        catch(Throwable t)
        {
            ErrorCollector.addVerificationFailure(t);
           // logger.log(LogStatus.FAIL, "User ID Text NOT displayed successfully");
        }
    }

}

package Dashboard;
import junit.framework.Assert;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilLibrary.GenericUtilLib;

import com.relevantcodes.extentreports.LogStatus;

import ErrorCollectors.ErrorCollector;
import baseSetUp.BaseSetUp;


public class DashboardPage extends BaseSetUp{
	
	 static boolean isEventSuccessful=false;
	 
	 @FindBy(xpath="//a[contains(.,'Dashboard')]")
	 public static WebElement link_Dashboard;
	 
	 
	 @FindBy(xpath="//span[@id='lblLeaveBalance']")
	 public static WebElement txt_Leave;
	 
	 @FindBy(xpath="//a[contains(.,'Leave Application')]")
	 public static WebElement link_LeaveApplication;
	 
	 @FindBy(xpath="//label[contains(.,'Self')]")
	 public static WebElement lbl_Self;
	 
	 
	 String leaveText;
	 
	 public DashboardPage(RemoteWebDriver driver)
	    {
	    	this.driver = driver;
	    	PageFactory.initElements(driver,this);
	    }
	 
	 public String fetchData(String browser, String LinkName)
	 {
		 try
		 {
			 driver.switchTo().frame("contents");
			 GenericUtilLib.checkElementClickable(link_Dashboard);
				if(LinkName.equalsIgnoreCase("Dashboard"))
				{
					isEventSuccessful=GenericUtilLib.click_Element(link_Dashboard, LinkName);
					Assert.assertTrue(isEventSuccessful);
					System.out.println(LinkName + "clicked successfully");
					 Thread.sleep(3000);
					 driver.switchTo().defaultContent();
					 
					 driver.switchTo().frame("main");
					 GenericUtilLib.checkElementVisiblity(lbl_Self);
					leaveText=GenericUtilLib.GetText(txt_Leave);
					if(browser.contains("Firefox"))
		                FF_logger.log(LogStatus.PASS, LinkName + "clicked successfully");
		            else if (browser.contains("Chrome"))
		                CH_logger.log(LogStatus.PASS, LinkName + "clicked successfully");		
				}
				
				
		 }
		 
		 catch (Exception t)
		 {
			 ErrorCollector.addVerificationFailure(t);
			 FF_logger.log(LogStatus.FAIL, " Could not fetch the data");
		 }
		 //driver.switchTo().defaultContent();
		return leaveText;
	 }

}

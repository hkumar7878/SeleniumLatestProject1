package LeaveApplicationPage;
 
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilLibrary.ApplicationUtilLib;
import utilLibrary.GenericUtilLib;

import com.relevantcodes.extentreports.LogStatus;

import ErrorCollectors.ErrorCollector;
import baseSetUp.BaseSetUp;

public class LeaveApplicationPage extends BaseSetUp{

	static boolean isEventSuccessful=false;
	  static String  mainWindowHandle;
	   String popupHandle;
	  
	// WebElement for Attendance Report link
    
    @FindBy(xpath="//a[contains(.,'Leave Application')]")
    public static WebElement link_LeaveApplication;
    
    @FindBy(xpath="//a[contains(.,'Leave Transaction')]")
    public static WebElement link_LeaveTranx;
    
    @FindBy(xpath="//a[contains(.,'Leave View')]")
    public static WebElement link_Leaveview;
    
    @FindBy(xpath="//a[contains(.,'1')]")
    public static WebElement link_day;
    
    @FindBy(xpath="//select[@id='ddlEmpName']")
    public static WebElement dropDown_emp;
    
    @FindBy(xpath="//select[@id='ddlLeaveType']")
    public static WebElement dropDown_leaveType;
    
    @FindBy(xpath="//select[@name='Yr']")
    public static WebElement dropDown_FromcalYear;
    
    @FindBy(xpath="//select[@name='Yr']/following::select")
    public static WebElement dropDown_FromcalMonth;
    
    @FindBy(xpath="//img[@src='../Images/calender.gif']")
    public static WebElement btn_CalFromDate;
    
    @FindBy(name="btnFilter")
    public static WebElement btn_Filter;
    
    @FindBy(xpath="//a[contains(.,'Leave Transaction')]")
    public static WebElement lbl_LeaveTrsxHdLbl;
    
    @FindBy(xpath="//a[contains(.,'Leave View')]")
    public static WebElement lbl_LeaveViewHdLbl;
    
    @FindBy(xpath="//div[@id='dvnonoms']")
	 public static WebElement txt_Leave;
    
    @FindBy(xpath="//td[contains(.,'Leave Transaction')]")
	 public static WebElement hd_LeaveTrns;
    
    @FindBy(xpath="//td[contains(.,'Department Name')]")
	 public static WebElement hdCol_LeaveViewTable;
    
  //td[contains(.,'Department Name')]
    
    @FindBy(xpath="//table[@id='dgSummary']")
	 public static WebElement table_LeaveView;
    
    
    String leaveText;
	
	public LeaveApplicationPage(RemoteWebDriver driver)
    {
    	this.driver = driver;
    	PageFactory.initElements(driver,this);
    }
	
	
	
	
	public void clickLink(String browser, String LinkName)
	
	{
		try
		{
			if(LinkName.equalsIgnoreCase("Leave Application"))
			{
				Thread.sleep(1000);
				GenericUtilLib.checkFrameAvailablity("contents");
				//Thread.sleep(1000);
				isEventSuccessful=GenericUtilLib.click_Element(link_LeaveApplication, LinkName);
				Assert.assertTrue(isEventSuccessful);
				System.out.println(LinkName + "clicked successfully");
				if(browser.contains("Firefox"))
	                FF_logger.log(LogStatus.PASS, LinkName + "clicked successfully");
	            else if (browser.contains("Chrome"))
	                CH_logger.log(LogStatus.PASS, LinkName + "clicked successfully");
			}
			
			else if(LinkName.equalsIgnoreCase("Leave Transaction"))
			{
				GenericUtilLib.checkElementVisiblity(link_LeaveTranx);
				isEventSuccessful=GenericUtilLib.click_Element(link_LeaveTranx, LinkName);
				GenericUtilLib.checkElementVisiblity(lbl_LeaveTrsxHdLbl);
				Assert.assertTrue(isEventSuccessful);
				System.out.println(LinkName + "clicked successfully");
				if(browser.contains("Firefox"))
	                FF_logger.log(LogStatus.PASS, LinkName + "clicked successfully");
	            else if (browser.contains("Chrome"))
	                CH_logger.log(LogStatus.PASS, LinkName + "clicked successfully");
			}
			
			else if(LinkName.equalsIgnoreCase("Leave View"))
			{
				GenericUtilLib.checkElementVisiblity(link_Leaveview);
				isEventSuccessful=GenericUtilLib.click_Element(link_Leaveview, LinkName);
				GenericUtilLib.checkElementVisiblity(lbl_LeaveViewHdLbl);
				Assert.assertTrue(isEventSuccessful);
				System.out.println(LinkName + "clicked successfully");
				if(browser.contains("Firefox"))
	                FF_logger.log(LogStatus.PASS, LinkName + "clicked successfully");
	            else if (browser.contains("Chrome"))
	                CH_logger.log(LogStatus.PASS, LinkName + "clicked successfully");
			}
			
			else if(LinkName.equalsIgnoreCase("Day"))
			{
				
				
				isEventSuccessful=GenericUtilLib.click_ElementCal(link_day, LinkName);
				Assert.assertTrue(isEventSuccessful);
				driver.switchTo().window(mainWindowHandle);
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
	         //logger.log(LogStatus.FAIL, LinkName + "is not clicked successfully");
		}
	}
	
	public void selectFromDropDown(String browser, String dropDownName, String inputValue)
	{
		try
		{
			if(dropDownName.equalsIgnoreCase("Employee"))
			{
				
				GenericUtilLib.checkFrameAvailablity("main");
			
				isEventSuccessful=GenericUtilLib.selectFromDropdown(dropDown_emp, inputValue, dropDownName);
				Assert.assertTrue(isEventSuccessful);
				System.out.println(dropDownName + "clicked successfully");
				if(browser.contains("Firefox"))
	                FF_logger.log(LogStatus.PASS, dropDownName + "clicked successfully");
	            else if (browser.contains("Chrome"))
	                CH_logger.log(LogStatus.PASS, dropDownName + "clicked successfully");
			}
			
			else if(dropDownName.equalsIgnoreCase("Leave Type"))
			{
				isEventSuccessful=GenericUtilLib.selectFromDropdown(dropDown_leaveType, inputValue, dropDownName);
				Assert.assertTrue(isEventSuccessful);
				System.out.println(dropDownName + "clicked successfully");
				if(browser.contains("Firefox"))
	                FF_logger.log(LogStatus.PASS, dropDownName + "clicked successfully");
	            else if (browser.contains("Chrome"))
	                CH_logger.log(LogStatus.PASS, dropDownName + "clicked successfully");
			}
			
			else if(dropDownName.equalsIgnoreCase("Year"))			
			{	
				Set s = driver.getWindowHandles();
	            Iterator ite = s.iterator();
	            while(ite.hasNext())
	            {
	                 popupHandle=ite.next().toString();
	                 if(!popupHandle.contains(mainWindowHandle))
	                 {
	                       driver.switchTo().window(popupHandle);
	                 }
	            }
				isEventSuccessful=GenericUtilLib.selectFromDropdown(dropDown_FromcalYear, inputValue, dropDownName);
				Assert.assertTrue(isEventSuccessful);
				System.out.println(dropDownName + "clicked successfully");
				if(browser.contains("Firefox"))
	                FF_logger.log(LogStatus.PASS, dropDownName + "clicked successfully");
	            else if (browser.contains("Chrome"))
	                CH_logger.log(LogStatus.PASS, dropDownName + "clicked successfully");
			}	
			
			else if(dropDownName.equalsIgnoreCase("Month"))			
			{
				
				isEventSuccessful=GenericUtilLib.selectFromDropdown(dropDown_FromcalMonth, inputValue, dropDownName);
				Assert.assertTrue(isEventSuccessful);
				System.out.println(dropDownName + "clicked successfully");
				if(browser.contains("Firefox"))
	                FF_logger.log(LogStatus.PASS, dropDownName + "clicked successfully");
	            else if (browser.contains("Chrome"))
	                CH_logger.log(LogStatus.PASS, dropDownName + "clicked successfully");
			}	
		}
		
		catch(Exception t)
		{
			 ErrorCollector.addVerificationFailure(t);
	         //logger.log(LogStatus.FAIL, dropDownName + "is not clicked successfully");
		}

	}
	
	public void clickBtn(String browser, String dateBtn)
    {
    	
    	try 
    	{
    		if(dateBtn.equalsIgnoreCase("fromDate"))
    		{
    			
    			mainWindowHandle=driver.getWindowHandle();
    			isEventSuccessful=verify_btnDisplayed(browser,btn_CalFromDate);
    			Assert.assertTrue(isEventSuccessful);
    			GenericUtilLib.click_Element(btn_CalFromDate, "From Date");
    			Assert.assertTrue(isEventSuccessful);
    			if(browser.contains("Firefox"))
    				FF_logger.log(LogStatus.PASS, "Login Button is clicked successfully");
    			else if (browser.contains("Chrome"))
    				CH_logger.log(LogStatus.PASS, "Login Button is clicked successfully");
    		}
    		
    		else if(dateBtn.equalsIgnoreCase("Filter"))
    		{
    			
    			Assert.assertTrue(isEventSuccessful);
    			GenericUtilLib.click_Element(btn_Filter, "Filter");
    			Assert.assertTrue(isEventSuccessful);
    			if(browser.contains("Firefox"))
    				FF_logger.log(LogStatus.PASS, "Filter Button is clicked successfully");
    			else if (browser.contains("Chrome"))
    				CH_logger.log(LogStatus.PASS, "Filter Button is clicked successfully");
    		}
    	}
    	 catch(Throwable t)
        {
            ErrorCollector.addVerificationFailure(t);
          
           
        }
    }
    public boolean verify_btnDisplayed(String browser, WebElement we)
    {
    	boolean flag;
        try
        {
            
        	Thread.sleep(1000);
          
            isEventSuccessful=GenericUtilLib.verifyBtnDisplayed(we);
            Assert.assertTrue(isEventSuccessful);
           flag=true;
            
            System.out.println(we + "button is displayed successfully");
            
            if(browser.contains("Firefox"))
                FF_logger.log(LogStatus.PASS, we + "button is displayed successfully");
            else if (browser.contains("Chrome"))
                CH_logger.log(LogStatus.PASS, we + "button is displayed successfully");
        }

        catch(Throwable t)
        {
            ErrorCollector.addVerificationFailure(t);
            //logger.log(LogStatus.FAIL, "Login Button is Not displayed");
            if(browser.contains("Firefox"))
            	 FF_logger.log(LogStatus.PASS, we.getText() + "button is NOT displayed successfully");
			else if (browser.contains("Chrome"))
				CH_logger.log(LogStatus.PASS, we.getText() + "button is NOT displayed successfully");
            flag=false;
        }
        return flag;
    }
	
	
	public String fetchData(String browser, String LinkName)
	 {
		 try
		 {
			 driver.switchTo().frame("main");
		
				if(LinkName.equalsIgnoreCase("Leave Transaction"))
				{
					 GenericUtilLib.checkElementVisiblity(hd_LeaveTrns);
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
	         //logger.log(LogStatus.FAIL, " Could not fetch the data");
		 }
		 
		return leaveText;
	 }
	
	public void verifyLeaveViewTableData(String browser, String expLeaveItem)
	{
		try
		{
			boolean flag=false;
			if(expLeaveItem.equalsIgnoreCase("Software"))
			{
				GenericUtilLib.checkElementVisiblity(hdCol_LeaveViewTable);
				List<String> leaveViewDetails=ApplicationUtilLib.fetchTableData(table_LeaveView);
				if(browser.contains("Firefox"))
				{
					for (String leaveView : leaveViewDetails )
					{
						if(leaveView.equalsIgnoreCase("SOFTWARE"))
						{
							FF_logger.log(LogStatus.PASS, expLeaveItem + " is matching ");
							flag=true;
							break;
						}						
					}
					if(!flag)
					{
						FF_logger.log(LogStatus.FAIL, expLeaveItem + " is not matching ");
					}
				}
				else if (browser.contains("Chrome"))
				{
					for (String leaveView : leaveViewDetails )
					{
						if(leaveView.equalsIgnoreCase("SOFTWARE"))
						{
							CH_logger.log(LogStatus.PASS, expLeaveItem + " is matching ");
							flag=true;
							break;
						}						
					}
					if(!flag)
					{
						CH_logger.log(LogStatus.FAIL, expLeaveItem + " is not matching ");
					}
				}
			}
			else if(expLeaveItem.equalsIgnoreCase("EmpName"))
			{
				GenericUtilLib.checkElementVisiblity(hd_LeaveTrns);
				leaveText=GenericUtilLib.GetText(txt_Leave);
				if(browser.contains("Firefox"))
					FF_logger.log(LogStatus.PASS, expLeaveItem + "clicked successfully");
				else if (browser.contains("Chrome"))
					CH_logger.log(LogStatus.PASS, expLeaveItem + "clicked successfully");		
			}
		}

		catch (Exception t)
		{
			ErrorCollector.addVerificationFailure(t);
			//logger.log(LogStatus.FAIL, " Could not fetch the data");
		}


	}


}

package Leave_Application_TestCases;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import baseSetUp.BaseSetUp;
import Dashboard.DashboardPage;
import ErrorCollectors.ErrorCollector;
import HomePage.ApplicationHomePage;
import LeaveApplicationPage.LeaveApplicationPage;
import utilLibrary.ActionBeforeTest;
import utilLibrary.ExcelReader;
import utilLibrary.ActionAfterTest;
public class TC_01_Verify_Self_Leave_View extends BaseSetUp{
	
	
	public static final Logger logger=Logger.getLogger(TC_01_Verify_Self_Leave_View.class.getName());
	ApplicationHomePage obj_App_Home_Pg;
    LeaveApplicationPage obj_Leave_App_Pg;
    DashboardPage obj_Dashboard_pg;
    ActionAfterTest actionAfterTest=new ActionAfterTest();
    ActionBeforeTest actionBeforeTest=new ActionBeforeTest();
    BaseSetUp baseSetup;
    public static ExcelReader TEST_SUITE_firefox = null;
    public static ExcelReader TEST_SUITE_chrome = null;
    public static String TestCaseName = null;
    String SheetName=null;
    String ToRunColumnNameTestCase = null;
    String methodName=null;
    public static int DataSet=-1;
    public static ExcelReader xls = null;
    String userID;
    String pswd;
    String browserID=null;
    String tcDesc=null;
    
    @DataProvider(name="loginData")
    public String[][] getTestData()
    {
    	String[][] loginData = getExcelData1("Login_Data.xlsx", "LoginDetails");
    	return loginData;
    }
    
    @Parameters({"browserType","appURL"})
    @BeforeMethod()
    public void getMethodName(Method method,String browserType, String appURL) throws IOException, InterruptedException
    {

        //String log4jConfigPath=System.getProperty("user.dir")+"log4j.properties";
        //PropertyConfigurator.configure(log4jConfigPath);
    	
    	logger.info("###############Starting Leave Verification Test ################");
    	browserID=browserType;
        obj_App_Home_Pg=new ApplicationHomePage(driver);
        
        obj_Dashboard_pg = new DashboardPage(driver);
        obj_Leave_App_Pg = new LeaveApplicationPage(driver);
        init();
        TEST_SUITE_firefox=Application_Test_Suite_Firefox;
        TEST_SUITE_chrome=Application_Test_Suite_Chrome;
        System.out.println("Inside Before Method & FilePath Is : "+Application_Test_Suite_Firefox + browserID );

        TestCaseName = this.getClass().getSimpleName();
        System.out.println("Inside Before Method & TestCaseName Is : "+TestCaseName);
        methodName=method.getName();
        SheetName = "Leave Application";
        ToRunColumnNameTestCase = "CaseToRun";
        tcDesc="Verify Application View Self Details";
        actionBeforeTest.beforeTestAction(browserType,appURL,TestCaseName,methodName,SheetName,tcDesc);
      

    }

  
    //@Test(dataProvider="loginData")
    
    
    // Below signature method is an example to show how to fetch the data from dataprovider on the basis of specific
    // excel and sheet
    ////@Test(dataProviderClass=dataProvider_Repository.class,dataProvider="newproductTestData")
    //public void TC_01_Add_State_Availablity(String productName, String productDesc,String grpSeriesName,String Type,String StartDate,String EndDate)
    @Parameters({"userid","password"})
    @Test()
    public void TC_01_Verify_Application_View_Self_Details(String userid, String password) throws InterruptedException
    {
    	try{
        	// Below is an just an example of how to fetch product name. Not related to this project. It's an reference
    		//obj_manage_state_availablity.selectProductFromDropDown(productName);
    		userID=userid;
    		pswd=password;
    		obj_App_Home_Pg=new ApplicationHomePage(driver);
    		obj_Dashboard_pg = new DashboardPage(driver);
    		obj_Leave_App_Pg=new LeaveApplicationPage(driver);

    		logger.info("Before opening the App home page");

    		// Step 1: Verify whether user lands on home page by checking 'Login Pyramid Core' tab.

    		obj_App_Home_Pg.verify_Tab_Display(browserID);

    		// Step 2: Enter User id

    		obj_App_Home_Pg.enterText(browserID, userid, "User ID");

    		// Step 3: Enter Password

    		obj_App_Home_Pg.enterText(browserID, password, "Password");

    		// Step 4: Click on Login button

    		obj_App_Home_Pg.clickLoginBtn(browserID);

    		// Step 5: Click on Home link

    		obj_App_Home_Pg.clickLink(browserID, "Home");

    		// Step 6: Click on 'Leave Application' link inside frame

    		obj_Leave_App_Pg.clickLink(browserID, "Leave Application");     

    		// Step 9 : Click on Leave Transaction Link under Leave Application module

    		obj_Leave_App_Pg.clickLink(browserID, "Leave View");

    		Thread.sleep(1000);

    		driver.switchTo().defaultContent();
    		
    		// Step 10: Select first value Hitesh Ghai from drop down:

    		obj_Leave_App_Pg.selectFromDropDown(browserID, "Employee", "Hitesh Ghai");

    		// Step 11: Select Leave type from Leave Type drop down

    		obj_Leave_App_Pg.selectFromDropDown(browserID, "Leave Type", "Casual Leave");


    		// Step 11: Click on From Date calender button.


    		obj_Leave_App_Pg.clickBtn(browserID, "fromDate");

    		// Step 12: Select year from year drop down

    		obj_Leave_App_Pg.selectFromDropDown(browserID, "Year", "2017");

    		// Step 13: Select Month from Month drop down

    		obj_Leave_App_Pg.selectFromDropDown(browserID, "Month", "January");

    		//driver.switchTo().window(mainWindowHandle);

    		// Step 14: Select Day 1 

    		obj_Leave_App_Pg.clickLink(browserID, "Day");

    		// driver.switchTo().window(mainWindowHandle);

    		System.out.println("");
    		//    driver.switchTo().defaultContent();
    		// Step 15: Click on Filter button

    		obj_Leave_App_Pg.clickBtn(browserID, "Filter");
    		
    		// Step 16: Verify the employee department name
    		
    		obj_Leave_App_Pg.verifyLeaveViewTableData(browserID, "Software");
          
          
            
           
        }
        	
        	catch(Exception t)
    		{
    			 ErrorCollector.addVerificationFailure(t);
    			 if(browserID.contains("Firefox"))
    		            FF_logger.log(LogStatus.FAIL, "Causal leaves are matching");
    			 else if (browserID.contains("Chrome"))
    		            CH_logger.log(LogStatus.FAIL, "Causal leaves are matching");
    	        
    		}

    }
    
    @AfterMethod
    public void afterEachTest(ITestResult result) throws InterruptedException {

        try
        {

            System.out.println("Inside After Method of test case");
            actionAfterTest.afterTestAction(result, SheetName, methodName, browserID);
            logger.info("###############Finished Leave Verification Test ################");
        }

        catch (Exception e)
        {
            System.out.println("Excpetion is " + e.getMessage());
        }
    }

}

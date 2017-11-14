package Application_HomePage_TestCases;

import java.io.IOException;
import java.lang.reflect.Method;



import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baseSetUp.BaseSetUp;
import Dashboard.DashboardPage;
import ErrorCollectors.ErrorCollector;
import HomePage.ApplicationHomePage;
import LeaveApplicationPage.LeaveApplicationPage;
import utilLibrary.ActionBeforeTest;
import utilLibrary.ApplicationUtilLib;
import utilLibrary.ExcelReader;
import utilLibrary.ActionAfterTest;


public class TC_01_Verify_Logo_On_Application_Home_Page extends BaseSetUp{


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
    String leave_Dts_Text_Dashboard;
    String leave_Dts_Text_LTrans;
    boolean isEventSuccessful = false;

    String browserID=null;
    String tcDesc=null;

    
    public TC_01_Verify_Logo_On_Application_Home_Page()
    {
    	
    	// The purpose of this constructor is to call the contructor of parent class i.e BaseSetup where 
    	// contrscutor is defined to load the properties file. This can be acheived by calling the below super() keyword.So
    	// it will initilize the properties file to user it's value.
    	super();
    }
    
    /*@Parameters({"browserType","appURL"})
    @BeforeMethod()
   // @BeforeTest()
   //@BeforeSuite()
    public void getMethodName(Method method,String browserType, String appURL) throws IOException, InterruptedException
    {

    	tcDesc="To Verify that correct number of leaves are displayed under Leave Application module";
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
        SheetName = "Application_Home_Pg_Pol_Bazzar";
        ToRunColumnNameTestCase = "CaseToRun";
        actionBeforeTest.beforeTestAction(browserType,appURL,TestCaseName,methodName,SheetName,tcDesc);
      

    }*/
    
    @Parameters({"browserType","appURL"})
    @BeforeMethod()
    public void getMethodName(Method method,String browserType, String appURL) throws IOException, InterruptedException
    {

    	
    	// String url=prop.getProperty("url"); This is other ALTERNATIVE WAY to get url or any config value from properties file
    	//which is being initilized in this class constructor. Similary other values can also be fetched from properties file.
    	tcDesc="To Verify that correct number of leaves are displayed under Leave Application module";
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
        SheetName = "Application_Home_Pg_Pol_Bazzar";
        ToRunColumnNameTestCase = "CaseToRun";
        actionBeforeTest.beforeTestAction(browserType,appURL,TestCaseName,methodName,SheetName,tcDesc);
      

    }

    // Test Case Description: To Verify that correct number of leaves are displayed under Leave Application module

    //@Test(dataProviderClass=dataProvider_Repository.class,dataProvider="newproductTestData")
    @Parameters({"userid","password"})
    @Test()
    public void TC_01_Verify_HomePage_Logo(String userid, String password) throws InterruptedException
    {

        
    	try{
    	
    	userID=userid;
        pswd=password;
    	obj_App_Home_Pg=new ApplicationHomePage(driver);
    	obj_Dashboard_pg = new DashboardPage(driver);
    	obj_Leave_App_Pg=new LeaveApplicationPage(driver);
    	
        System.out.println("Before opening the App home page");

        // Step 1: Verify whether user lands on home page by checking 'Login Pyramid Core' tab.
        
        obj_App_Home_Pg.verify_Tab_Display(browserID);
        
        // Step 2: Enter User id
        
        obj_App_Home_Pg.enterText(browserID, userid, "User ID");
        
        // Step 3: Enter Password
        
        obj_App_Home_Pg.enterText(browserID, password, "Password");
        
        // Step 4: Click on Login button
        
        /*obj_App_Home_Pg.clickLoginBtn(browserID);
        
        // Step 5: Click on Home link
        
        obj_App_Home_Pg.clickLink(browserID, "Home");
        
        // Step 6: Click on 'Leave Application' link inside frame
        
      //  obj_Leave_App_Pg.clickLink(browserID, "Leave Application");
        
        // Step 7: Fetch Leave details from Dashboard page
        
        leave_Dts_Text_Dashboard=  obj_Dashboard_pg.fetchData(browserID, "Dashboard");
        
        String [] leaveSplitDashboard = leave_Dts_Text_Dashboard.split(",");
        
        String casualLeaveDB=leaveSplitDashboard[0];
        String earnedLeaveDB=leaveSplitDashboard[1];
        String floaterDB=leaveSplitDashboard[2];
        
        System.out.println("Casual Leaves from dashboard page are  " + casualLeaveDB);
        System.out.println("Earned Leaves from dashboard page are  " + earnedLeaveDB);
        System.out.println("Floaters from dashboard page are  " + floaterDB);
        
        driver.switchTo().defaultContent();
        // Step 8 : Click on Leave Application Link
        
        obj_Leave_App_Pg.clickLink(browserID, "Leave Application");
        
        // Step 9 : Click on Leave Transaction Link under Leave Application module
        
        obj_Leave_App_Pg.clickLink(browserID, "Leave Transaction");
        //
        driver.switchTo().defaultContent();
        
        // Step 10: Fetch leaves data from Leave Transaction page
        
        leave_Dts_Text_LTrans=obj_Leave_App_Pg.fetchData(browserID, "Leave Transaction");
        
        String [] leaveSplit_LeaveAppPg = leave_Dts_Text_Dashboard.split(",");
        
        String casualLeaveLvPg=leaveSplit_LeaveAppPg[0];
        String earnedLeaveLvPg=leaveSplit_LeaveAppPg[1];
        String floaterLeaveLvPg=leaveSplit_LeaveAppPg[2];
        
        System.out.println("Casual Leaves from Leave App page are  " + casualLeaveLvPg);
        System.out.println("Earned Leaves from Leave App page are  " + earnedLeaveLvPg);
        System.out.println("Floaters from Leave App page are  " + floaterLeaveLvPg);
        
        ApplicationUtilLib.compareValues(casualLeaveDB, casualLeaveLvPg, "casualLeave",browserID);
        
    */    
    }
    	
    	catch(Exception t)
		{
			 ErrorCollector.addVerificationFailure(t);
			 if(browserID.contains("Firefox"))
		            FF_logger.log(LogStatus.FAIL, "Causal leaves are matching");
			 else if (browserID.contains("Chrome"))
		            CH_logger.log(LogStatus.FAIL, "Causal leaves are matching");
	         //logger.log(LogStatus.FAIL, LinkName + "is not clicked successfully");
		}

    }

    @AfterMethod
    public void afterEachTest(ITestResult result) throws InterruptedException {

        try
        {

            System.out.println("Inside After Method of test case");
            actionAfterTest.afterTestAction(result, SheetName, methodName, browserID);
        }

        catch (Exception e)
        {
            System.out.println("Excpetion is " + e.getMessage());
        }


















































     /*   try {
            System.out.println("After Method Execution");
            int status = result.getStatus();
            int tcRowNum = SuiteUtility.readRowUtility(BaseSetUp.Application_Test_Suite_Firefox, SheetName, "TestCaseName", methodName);
            switch (status) {
                case ITestResult.SUCCESS:
                    if (browserID.equals("Firefox")) {

                        SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Firefox, SheetName, "Pass/Fail/Skip", tcRowNum, "Passed", browserID);
                        report.endTest(FF_logger);
                        Thread.sleep(1000);
                        report.flush();
                        System.out.println("Extent report is flushed for Firefox");
                    }
                    if (browserID.equals("Chrome")) {
                        SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Chrome, SheetName, "Pass/Fail/Skip", tcRowNum, "Passed", browserID);
                        report1.endTest(CH_logger);
                        Thread.sleep(1000);
                        report1.flush();
                        System.out.println("Extent report is flushed for CHROME");
                    }

                    if (browserID.equals("IE")) {
                        //SuiteUtility.WriteResultUtility(BaseSetUp.Application_Test_Suite, SheetName, "Pass/Fail/Skip", homePageRow+1, "Passed");
                    }
                    break;
                case ITestResult.FAILURE:
                    if (browserID.equals("Firefox")) {
                        SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Firefox, SheetName, "Pass/Fail/Skip", tcRowNum, "Failed", browserID);
                        report.endTest(FF_logger);
                        Thread.sleep(1000);
                        report.flush();
                        System.out.println("Extent report is flushed for Firefox");
                    }
                    if (browserID.equals("Chrome")) {
                        SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Chrome, SheetName, "Pass/Fail/Skip", tcRowNum, "Failed", browserID);
                        report1.endTest(CH_logger);
                        Thread.sleep(1000);
                        report1.flush();
                        System.out.println("Extent report is flushed for CHROME");
                    }

                    if (browserID.equals("IE")) {
                        //SuiteUtility.WriteResultUtility(BaseSetUp.Application_Test_Suite, SheetName, "Pass/Fail/Skip", homePageRow+1, "Passed");
                    }
                    break;

                default:
                    throw new RuntimeException("Invalid status");
            }
            getDriver().quit();
            dr.set(null);
        }

        catch (Exception e)
        {
            System.out.println("Exception " + e);
        }*/
    }


}

package utilLibrary;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import baseSetUp.BaseSetUp;

import org.openqa.selenium.WebDriverException;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

public class ActionBeforeTest extends BaseSetUp{
    String browserID=null;
    String TestCaseName=null;
    String mtdName=null;
    String ToRunColumnNameTestCase = null;
    String sheetName;
    String appURL=null;
    public static ExcelReader TEST_SUITE_firefox = null;
    public static ExcelReader TEST_SUITE_chrome = null;
    BaseSetUp baseSetUp;

    public void beforeTestAction(String browserType,String appURL,String testCaseName,String methodName, String shName,String tcDesc) throws InterruptedException, IOException
    {
        try
        {
            browserID=browserType;
            init();
            TEST_SUITE_firefox=Application_Test_Suite_Firefox;
            TEST_SUITE_chrome=Application_Test_Suite_Chrome;
            TestCaseName = testCaseName;
            System.out.println("Inside Before Method & TestCaseName Is : "+TestCaseName);
            mtdName=methodName;
            sheetName = shName;
            ToRunColumnNameTestCase = "CaseToRun";
            
            if(browserID.contains("Firefox") && !SuiteUtility.checkToRunUtility(TEST_SUITE_firefox, sheetName,ToRunColumnNameTestCase,mtdName))
            {
                SuiteUtility.WriteResultUtility(BaseSetUp.Application_Test_Suite_Firefox, sheetName,"Pass/Fail/Skip", suiteRow_FF+1, "Skipped");
                FF_logger=report.startTest(mtdName, tcDesc);
                if (browserID.equals("Firefox")) {
                	FF_logger.log(LogStatus.SKIP, mtdName + "is skipped" );
                    BaseSetUp.report.endTest(BaseSetUp.FF_logger);
                    Thread.sleep(1000);
                    BaseSetUp.report.flush();
                    Thread.sleep(1000);
                    System.out.println("Extent report is flushed for Firefox");
                    //throw new SkipException(TestCaseName+"'s CaseToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+TestCaseName);
                }
                throw new SkipException(TestCaseName+"'s CaseToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+TestCaseName);
            }
            
            else if(browserID.contains("Chrome") && !SuiteUtility.checkToRunUtility(TEST_SUITE_chrome, sheetName,ToRunColumnNameTestCase,methodName))
            {
                SuiteUtility.WriteResultUtility(BaseSetUp.Application_Test_Suite_Chrome, sheetName, "Pass/Fail/Skip", suiteRow_CH+1, "Skipped");
                CH_logger=report1.startTest(mtdName, tcDesc);
                if (browserID.equals("Chrome")) {
                	CH_logger.log(LogStatus.SKIP, mtdName + "is skipped" );
                    BaseSetUp.report1.endTest(BaseSetUp.CH_logger);
                    Thread.sleep(1000);
                    BaseSetUp.report1.flush();
                    Thread.sleep(1000);
                    System.out.println("Extent report is flushed for Chrome");
                }
                //throw new SkipException(TestCaseName+"'s CaseToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+TestCaseName);
                throw new SkipException("Testing skipping");
            }
            else
            {
                if(browserID.contains("Firefox"))
                {
                    FF_logger=report.startTest(mtdName, tcDesc);
                    
                }

                else if(browserID.contains("Chrome"))
                {
                    CH_logger=report1.startTest(mtdName, tcDesc);
                }

                initializeTestBaseSetup(browserType,appURL);
            }
        }
        
        

        catch (WebDriverException e) 
        {
            System.out.println("Exception " + e);
        }
        
      
        
        
    }

}


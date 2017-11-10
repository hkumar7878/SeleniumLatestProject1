package utilLibrary;

import baseSetUp.BaseSetUp;
import org.testng.ITestResult;

public class ActionAfterTest {

    BaseSetUp baseSetUp;

    public void afterTestAction(ITestResult result, String SheetName, String methodName, String browserID) throws InterruptedException {
    	try {
    		System.out.println("After Method Execution");
    		int status = result.getStatus();
    		int tcRowNum = SuiteUtility.readRowUtility(BaseSetUp.Application_Test_Suite_Firefox, SheetName, "TestCaseName", methodName);
    		switch (status) {
    		case ITestResult.SUCCESS:
    			if (browserID.equals("Firefox")) {
    				SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Firefox, SheetName, "Pass/Fail/Skip", tcRowNum, "Passed", browserID);
    				BaseSetUp.report.endTest(baseSetUp.FF_logger);
    				//   Thread.sleep(1000);
    				BaseSetUp.report.flush();
    				System.out.println("Extent report is flushed for Firefox");
    			}
    			else if (browserID.equals("Chrome")) {
    				SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Chrome, SheetName, "Pass/Fail/Skip", tcRowNum, "Passed", browserID);
    				//  report1.endTest(CH_logger);
    				BaseSetUp.report1.endTest(baseSetUp.CH_logger);
    				//  Thread.sleep(1000);
    				BaseSetUp.report1.flush();
    				System.out.println("Extent report is flushed for CHROME");
    			}

    			if (browserID.equals("IE")) {
    				//SuiteUtility.WriteResultUtility(BaseSetUp.Application_Test_Suite, SheetName, "Pass/Fail/Skip", homePageRow+1, "Passed");
    			}
    			break;
    		case ITestResult.FAILURE:
    			if (browserID.equals("Firefox")) {
    				SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Firefox, SheetName, "Pass/Fail/Skip", tcRowNum, "Failed", browserID);
    				baseSetUp.report.endTest(baseSetUp.FF_logger);
    				Thread.sleep(1000);
    				baseSetUp.report.flush();
    				// Thread.sleep(3000);
    				System.out.println("Extent report is flushed for Chorme");
    			}
    			else if (browserID.equals("Chrome")) {
    				SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Chrome, SheetName, "Pass/Fail/Skip", tcRowNum, "Passed", browserID);
    				baseSetUp.report.endTest(baseSetUp.CH_logger);
    				Thread.sleep(1000);
    				baseSetUp.report1.flush();
    				Thread.sleep(3000);//
    				System.out.println("Extent report is flushed for Chorme");


    				/*if (browserID.equals("Chrome")) {
                        SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Chrome, SheetName, "Pass/Fail/Skip", tcRowNum, "Failed", browserID);
                        report1.endTest(CH_logger);
                        Thread.sleep(1000);
                        report1.flush();
                        System.out.println("Extent report is flushed for CHROME");
                    }*/

    				if (browserID.equals("IE")) {
    					//SuiteUtility.WriteResultUtility(BaseSetUp.Application_Test_Suite, SheetName, "Pass/Fail/Skip", homePageRow+1, "Passed");
    				}
    				break;
    			}

    		default:
    			throw new RuntimeException("Invalid status");
    		}

    		if(baseSetUp.driver!=null)
    		{
    			baseSetUp.driver.quit();
    		}

    	} catch (Exception e) {
    		System.out.println("Exception " + e);
    	}
    }

}
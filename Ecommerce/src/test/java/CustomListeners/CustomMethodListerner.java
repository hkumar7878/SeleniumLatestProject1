package CustomListeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import baseSetUp.BaseSetUp;
import utilLibrary.SuiteUtility;

public class CustomMethodListerner implements IInvokedMethodListener{
    String browerName=null;
    BaseSetUp baseSetup=new BaseSetUp();
    String SheetName=null;
    String browserID=null;

    @Parameters({"browserType","appURL"})
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }
    @Parameters({"browserType","appURL"})
    public void afterInvocation(IInvokedMethod methodName, ITestResult testResult) {
        /*try {
            System.out.println("After Method Execution");
            //String methodNm=methodName;
            int status = testResult.getStatus();
           String method=IInvokedMethod.class.getName();
            int tcRowNum = SuiteUtility.readRowUtility(baseSetup.Application_Test_Suite_Firefox, SheetName, "TestCaseName", method);
            switch (status) {
                case ITestResult.SUCCESS:
                    if (browserID.equals("Firefox")) {

                        SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Firefox, SheetName, "Pass/Fail/Skip", tcRowNum, "Passed", browserID);
                        baseSetup.report.endTest(baseSetup.FF_logger);
                        Thread.sleep(1000);
                        baseSetup.report.flush();
                        System.out.println("Extent report is flushed for Firefox");
                    }
                    *//*if (browserID.equals("Chrome")) {
                        SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Chrome, SheetName, "Pass/Fail/Skip", tcRowNum, "Passed", browserID);
                        baseSetup.report1.endTest(CH_logger);
                        Thread.sleep(1000);
                        baseSetup.report1.flush();
                        System.out.println("Extent report is flushed for CHROME");
                    }*//*

                    if (browserID.equals("IE")) {
                        //SuiteUtility.WriteResultUtility(BaseSetUp.Application_Test_Suite, SheetName, "Pass/Fail/Skip", homePageRow+1, "Passed");
                    }
                    break;
                case ITestResult.FAILURE:
                    if (browserID.equals("Firefox")) {
                        SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Firefox, SheetName, "Pass/Fail/Skip", tcRowNum, "Failed", browserID);
                        baseSetup.report.endTest(baseSetup.FF_logger);
                        Thread.sleep(1000);
                        baseSetup.report.flush();
                        System.out.println("Extent report is flushed for Firefox");
                    }
                    *//*if (browserID.equals("Chrome")) {
                        SuiteUtility.WriteResultUtility_Grid(BaseSetUp.Application_Test_Suite_Chrome, SheetName, "Pass/Fail/Skip", tcRowNum, "Failed", browserID);
                        baseSetup.report1.endTest(CH_logger);
                        Thread.sleep(1000);
                        baseSetup.report1.flush();
                        System.out.println("Extent report is flushed for CHROME");
                    }*//*

                    if (browserID.equals("IE")) {
                        //SuiteUtility.WriteResultUtility(BaseSetUp.Application_Test_Suite, SheetName, "Pass/Fail/Skip", homePageRow+1, "Passed");
                    }
                    break;

                default:
                    throw new RuntimeException("Invalid status");
            }
            baseSetup.getDriver().quit();
            baseSetup.dr.set(null);
        }

        catch (Exception e)
        {
            System.out.println("Exception " + e);
        }*/
    }

    }





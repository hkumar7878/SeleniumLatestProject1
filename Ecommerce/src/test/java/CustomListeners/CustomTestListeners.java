package CustomListeners;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import baseSetUp.BaseSetUp;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CustomTestListeners extends org.testng.TestListenerAdapter
{

    BaseSetUp baseSetup=new BaseSetUp();

    public static int DataSet=-1;
    String browerName=null;
    public String XMLtestCaseName=null;
    public static ExtentTest logger;
    public static ExtentReports report;
    public static ExtentReports report1;
    public static ExtentTest FF_logger;
    public static ExtentTest CH_logger;
    private List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
    private ThreadLocal<WebDriver> driverThread;

	/*@Parameters({"browserType"})
	 public void OnTestFinish(ITestContext testContext)
		{

			try
	    	{

				for (WebDriver driver : this.webDriverPool)
				{
				      driver.quit();
				}
				if(XMLtestCaseName.contains("firefox"))
					{
	    				System.out.println("Inside onTestFinish for FIREFOX for extent report");
	    				report.endTest(FF_logger);
	    				Thread.sleep(2000);
	    				report.flush();
	    				System.out.println("Extent report is flushed for FIREFOX");
					}
	    		else if(XMLtestCaseName.contains("chrome"))
		    	{
		    			System.out.println("Inside onTestFinish for FIREFOX for extent report");
		    			report1.endTest(CH_logger);
		    			Thread.sleep(2000);
		    			report1.flush();
		    			System.out.println("Extent report is flushed for CHROME");
		    	}

	    	}


	    	catch (Exception e)
	    	{
	    		System.out.println(e.getMessage());
	    	}


	    }*/

    @Override
    public void onTestSuccess(ITestResult tr) {
		/*DataSet++;

		try
		{
			String className = tr.getMethod().getTestClass().getName();
			System.out.println("Test Listner Class : Passed : onTestSuccess");
			System.out.println("Class name  " +className );
		}
		catch(Exception e)

			{
				System.out.println(e);
				System.out.println(tr.getThrowable().getMessage());
			}*/

    }
    //@Parameters("browserType")
		/*public void onTestStart(ITestContext testContext,String browserType)
		{
			System.out.println("Inside custom test");
			browerName=baseSetup.browserName;
			if(browerName.equalsIgnoreCase("Firefox"))
			{

				BaseSetUp.report=new ExtentReports(System.getProperty("user.dir")+"//"+ "TestReportsFirefox.html");
			}

			else if(browerName.equalsIgnoreCase("chrome"))
			{

				BaseSetUp.report1=new ExtentReports(System.getProperty("user.dir")+"//"+ "TestReportsChrome.html");
			}
		}*/

    @Override
    public void onTestSkipped(ITestResult tr) {
        //DataSet++;

        try
        {
            System.out.println("Customer listner test skipped");
            System.out.println("Check the skipping of test");


            if(baseSetup.browserName.toLowerCase().contains("firefox"))
            {
                BaseSetUp.FF_logger=baseSetup.report.startTest(tr.getName(),"TC_VeifyCaseManger");
            }
            else if(baseSetup.browserName.toLowerCase().contains("chrome"))
            {
                BaseSetUp.CH_logger=BaseSetUp.report1.startTest(tr.getName(),"TC_VeifyCaseManger");
            }
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void onTestFailure(ITestResult tr) {
			/*DataSet++;
			try
			{
				System.out.println("Custom listener test is failed");
				String className = tr.getMethod().getTestClass().getName();
				System.out.println("Class name is " +className );
			//SuiteUtility.WriteResultUtility(TestBaseSetUp.Forms_Suite_OnDeck, "Add_New_Forms_TC_List", "Pass/Fail/Skip", DataSet+1, "Failed");
			}

			catch(Exception e)

			{
				System.out.println(e);
				System.out.println(tr.getThrowable().getMessage());
			}*/

    }








		/*@Parameters({"browserType"})
		 public void onFinish(ITestContext testContext)
			{
		        System.out.println("ON Finish of test method execution");
		         try{

		        	 System.out.println("Occurence 1");

		        	 baseSetup.report.endTest(baseSetup.logger);
		        	 baseSetup.report.flush();

		 	    	System.out.println("Browser is closed successfully and finished the reporting");
		         }
		         catch(Exception e)

		         {

		         }
		    }*/


}


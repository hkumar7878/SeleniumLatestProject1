package CustomListeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//import BaseSetUp.TestBaseSetUp;

//import com.saleslinks.TestSuiteBase.TestBaseSetup;

public class CustomSuiteListener implements ISuiteListener
{

    String browerName=null;
    public String XMLtestCaseName=null;
    public static ExtentTest logger;
    public static ExtentReports report;
    public static ExtentReports report1;
    public static ExtentTest FF_logger;
    public static ExtentTest CH_logger;
    private List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
    private ThreadLocal<WebDriver> driverThread;
    /**
     * This method is invoked before the SuiteRunner starts.
     */
    public synchronized void onStart(ISuite suite)
    {

        //System.out.println("Inside custom suite");
        //TestBaseSetUp.report=new ExtentReports("D:\\ONDECK_GRID\\TestReports.html");

    }

    /**
     * This method is invoked after the SuiteRunner has run all
     * the test suites.
     */

    @Parameters({"browserType"})
    public void onFinish(ISuite suite)
    {

	    	/*{

				try
		    	{
		    		if(XMLtestCaseName.contains("firefox"))
						{
		    				System.out.println("Inside AfterSuite Class for FIREFOX for extent report");
		    				report.endTest(FF_logger);
		    				Thread.sleep(2000);
		    				report.flush();
		    				System.out.println("Extent report is flushed for FIREFOX");
						}
		    		else if(XMLtestCaseName.contains("chrome"))
			    	{
			    			System.out.println("Inside AfterSuite Class for FIREFOX for extent report");
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

				for (WebDriver driver : this.webDriverPool) {
				      driver.quit();
				}
	    }
*/
    }
}


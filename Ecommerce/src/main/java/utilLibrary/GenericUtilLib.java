package utilLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import baseSetUp.BaseSetUp;
import ErrorCollectors.ErrorCollector;

public class GenericUtilLib extends BaseSetUp
{

    BaseSetUp setup=new BaseSetUp();

    //public static boolean verifyPageHeader(WebElement we, String expVerifyText)

    
    public Iterator<String> getAllWindows()
    {
    	Set<String> windows=driver.getWindowHandles();
    	Iterator<String> itr=windows.iterator();
    	return itr;
    }
    public static boolean verifySiteText(WebElement we, String expVerifyText)
    {

        try
        {
            boolean flag=false;
            //checkPageIsReady();
            //GenericUtilLib.checkElementVisiblity(we);
            checkElementVisiblity(we);
            String actual_hd_txt=we.getText();
            if(actual_hd_txt.contains(expVerifyText))
            {
                flag=true;
            }

            Thread.sleep(1000);
            //Assert.assertEquals(actual_hd_txt, expVerifyText);
            Assert.assertTrue(flag);
            System.out.println(expVerifyText + " is displayed successfully");
            //log.debug(expVerifyText + "text is displayed successfully");
            return true;
        }

        catch(Throwable t)
        {
            System.out.println(expVerifyText + "header text is not displayed");
            ErrorCollector.addVerificationFailure(t);
            //log.error(expVerifyText + "element is not present");
            return false;
        }

    }
    
    public static <E1, E2> boolean compareValues(E1 value1, E2 value2)
    {
    	boolean isEventSuccessful = false;
    	
    	try
    	{
    		if(value1.equals(value2))
    			return true;
    		else
    			return false;	
    	}
    	
    	catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	return isEventSuccessful;
    }
    
    
    public static boolean verifyTabDisplay(WebElement we, String expVerifyText)
    {

        try
        {
            boolean flag=false;
            checkElementVisiblity(we);
            String actual_hd_txt=we.getText();
            if(actual_hd_txt.contains(expVerifyText))
            {
                flag=true;
            }

            Thread.sleep(1000);
            Assert.assertTrue(flag);
            System.out.println(expVerifyText + " is displayed successfully");
            //log.debug(expVerifyText + "text is displayed successfully");
            return true;
        }

        catch(Throwable t)
        {
            System.out.println(expVerifyText + "text is not displayed");
            ErrorCollector.addVerificationFailure(t);
            //log.error(expVerifyText + "element is not present");
            return false;
        }

    }
    
    public static boolean verifyBtnDisplayed(WebElement we)
    {

        try
        {
            boolean flag=false;
            //checkPageIsReady();
            //GenericUtilLib.checkElementVisiblity(we);
           // checkElementVisiblity(we);
            //String actual_hd_txt=we.getText();
            if(we.isDisplayed())
            	flag=true;
            else
            	flag=false;
            

            Thread.sleep(1000);
            
            
            return flag;
        }

        catch(Throwable t)
        {
           
            return false;
        }

    }

    public static boolean verifyPageHeader(WebElement we, String expVerifyText)
    {

        try
        {
            //checkPageIsReady();
            //GenericUtilLib.checkElementVisiblity(we);
            checkElementVisiblity(we);
            String actual_hd_txt=we.getText();
            Thread.sleep(1000);
            Assert.assertEquals(actual_hd_txt, expVerifyText);
            System.out.println(expVerifyText + "is displayed successfully");
            //log.debug(expVerifyText + "text is displayed successfully");
            return true;
        }

        catch(Throwable t)
        {
            System.out.println(expVerifyText + "header text is not displayed");
            ErrorCollector.addVerificationFailure(t);
            //log.error(expVerifyText + "element is not present");
            return false;
        }

    }
    public static boolean verifyPageLogo(WebElement we)
    {

        try
        {
            checkElementVisiblity(we);
            Assert.assertTrue(we.isDisplayed());

            Thread.sleep(1000);

            return true;
        }

        catch(Throwable t)
        {
            System.out.println(we + "object is not displayed");
            ErrorCollector.addVerificationFailure(t);
            //log.error(expVerifyText + "element is not present");
            return false;
        }

    }

    public static boolean verifyKendoPopUp(WebElement we,String kendoName)
    {

        try
        {
            //checkPageIsReady();
            //String actual_hd_txt=we.getText();
            Thread.sleep(1000);
            //Assert.assertEquals(actual_hd_txt, expVerifyText);
            Assert.assertTrue(we.isDisplayed());
            System.out.println("Kendo pop up is displayed successfully");
            //log.debug(expVerifyText + "text is displayed successfully");
            return true;
        }

        catch(Throwable t)
        {
            System.out.println("Kendo pop up is not displayed successfully");
            ErrorCollector.addVerificationFailure(t);
            //log.error(expVerifyText + "element is not present");
            return false;
        }

    }

    /*public static boolean selectElement(WebElement we,String selectionType,String dropDownOption)
    {
        boolean flag = false;

        try
        {

            Assert.assertTrue(we.isDisplayed(),"Select Element" + we + "is not visible");
            switch(selectionType)
            {
                case "option":
                    Select select =new Select(we);
                    select.selectByValue(dropDownOption);
                    flag=true;
                    break;
            }
        }

        catch (RuntimeException e)
        {
            flag = false;
            System.out.println(e.getMessage());
            strErrMsg_GenLib = e.getMessage();
        }
        return flag;
    }*/

    public static boolean clickElement(WebElement we)
    {


        try
        {

            Assert.assertTrue(we.isDisplayed(),"Element" + we + "is not visible");
            Thread.sleep(2000);
            we.click();
            //log.debug("Submit button is clicked successfully");
            System.out.println(we + "clicked successfully");
            return true;
        }

        catch(Exception e)
        {

            System.out.println("No such element" + we);
            //gm_WaitVisibility(we,40);
            ErrorCollector.addVerificationFailure(e);
            //log.error("Could not click " + we);
            System.out.println(we + "could not be clicked");
            strErrMsg_GenLib =e.getMessage();
            return false;

        }

    }


    public static boolean arrowClick(WebElement we)
    {
        boolean flag=false;
        try
        {
            if(we.isEnabled())
            {
                we.click();
                flag=true;
            }

            else
            {
                flag=false;
            }
        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public final boolean SelectCheckbox(WebElement element)
    {
        boolean flag = false;
        try
        {
            if (!element.isSelected())
            {
                element.click();
                flag = true;
            }
            else if (element.isSelected())
            {
                flag = true;
            }
            else
            {
                throw new RuntimeException("Could not select Checkbox.");
            }
        }
        catch (RuntimeException e)
        {
            flag = false;
            strErrMsg_GenLib = e.getMessage();
        }
        return flag;
    }
    public boolean isClickable(WebElement we)
    {
        try
        {


			/*WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].parentNode;", we);*/
            WebElement myElement = we;
            WebElement parent = myElement.findElement(By.xpath(".."));
            String attrValue=parent.getAttribute("Class");

            if(!attrValue.contains("disabled"))
            {
                //WebDriverWait wait = new WebDriverWait(setup.driver, 20);
                //wait.until(ExpectedConditions.elementToBeClickable(we));
                //wait.until(ExpectedConditions.visibilityOf(myElement));

                we.click();
                return true;
            }

            else
            {
                System.out.println("Element is not clickable");
                return false;
            }

        }
        catch (Exception e)
        {
            System.out.println("Element is not clickable" + e.getMessage());
            return false;
        }
    }


    public static void isElementPresent(WebElement we)
    {

        try
        {
            //WebDriverWait wait = new WebDriverWait(, 5000);

            //wait.until(ExpectedConditions.visibilityOf(we));
        }

        catch (Exception e)
        {
            System.out.println("Element is not present" + e.getMessage());

        }

    }

    public WebElement handleStaleElement(String elementName) throws InterruptedException {
        int count = 0;
        WebElement staledElement = null;

        while (count < 4)
        {
            try
            {

                Thread.sleep(2000);
                //staledElement = setup.driver.findElement(By.xpath(elementName));
                //return staledElement;

            }
            catch (StaleElementReferenceException e)
            {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                count = count + 1;
            }
            count = count + 4;
        }
        return staledElement;

    }

    public void isElementPresent1(String by)
    {

        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 2000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(by)));
        }

        catch (Exception e)
        {
            System.out.println("Element is not present" + e.getMessage());

        }

    }

    //public static  WebElement getStaleElement(By element) throws InterruptedException {
    /*public boolean getStaleElement(WebElement we) throws InterruptedException {

        boolean flag=false;

        try
        {
            // return driver.findElement(element);
            we.click();
            flag=true;

        }

        catch (StaleElementReferenceException | NoSuchElementException ele)
        {
            System.out.println("Attempting to recover from StaleElementReferenceException ...");
            Thread.sleep(5000);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", we);


            Thread.sleep(5000);

            if(we.isEnabled())

            {
                we.click();
                flag=true;
            }

            else
            {
                flag=false;
            }



        }
        return flag;
    }
*/


    public void checkElementToBeClickable(WebElement we)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(we));

        }

        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
            strErrMsg_GenLib=e.getMessage();
        }
    }

    public void checkElementTextTobePresent(WebElement we)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            //wait.until(ExpectedConditions.textToBePresentInElement(we, "Groups"));
            wait.until(ExpectedConditions.elementToBeClickable(we));

        }

        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static int generateRandomNumber()
    {
        Random r = new Random();
        return r.nextInt();
    }

    public static boolean EnterText(WebElement we, String inputValue,String elementName)
    {

        boolean flag=false;
        try
        {

            Assert.assertTrue(we.isDisplayed() && we.isEnabled(),"Element" + elementName + "is not displayed & visible");
           
            we.clear();
            we.sendKeys(inputValue);
           
            flag=true;

        }
        catch (NoSuchElementException ne )
        {
            //gm_WaitVisibility(we,40);
            //log.error( elementName+ "element is not displayed and enabled.");
            System.out.println("No such element dear");
            ne.getStackTrace();
            ErrorCollector.addVerificationFailure(ne);
            flag=false;
            //write a code for soft assertion

        }
        catch (ElementNotVisibleException nv)
        {
            //gm_WaitVisibility(we,40);
            //log.error( elementName+ "element is not visible");
            System.out.println("No such element dear");
            nv.getStackTrace();
            ErrorCollector.addVerificationFailure(nv);
            flag=false;

        }

        catch(Throwable e)
        {
            //log.error( elementName+ "element is not visible");
            System.out.println("No such element dear");
            e.getStackTrace();
            ErrorCollector.addVerificationFailure(e);
            flag=false;
        }

        return flag;
    }

    public static boolean selectFromDropdown(WebElement we, String inputValue,String elementName)
    {
        try
        {
            Assert.assertTrue(we.isDisplayed() && we.isEnabled(),"Element" + elementName + "is not displayed & visible");
           // we.click();
            Select select=new Select(we);         
            List<WebElement> options=select.getOptions();
            System.out.println(options.size());
            for(WebElement opt: options)
            {
            	if(opt.getText().equals(inputValue))
            	{
            		//opt.sendKeys(Keys.ENTER);
            		Thread.sleep(2000);
            		//opt.click();
            		select.selectByVisibleText(inputValue);
            		//javascriptclick(opt);
            		Thread.sleep(2000);
            		break;
            	}
            }
            return true;
        }
        catch(Throwable e)
        {
            System.out.println("No such element dear");
            ErrorCollector.addVerificationFailure(e);
            return false;
        }
    }

    public static void javascriptclick(WebElement element)
    { 
        //WebElement webElement=driver.findElement(By.xpath(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();",element);   
        System.out.println("javascriptclick"+" "+ element);

    }
    public static boolean click_Element(WebElement we, String elementName)
    {
        try
        {
            Assert.assertTrue(we.isDisplayed() && we.isEnabled(),elementName + "is not visible");
            we.click();
            System.out.println(elementName+ "clicked successfully");
            return true;
        }
        catch(Throwable ne)
        {
            System.out.println("No such element" + we);
           
            ErrorCollector.addVerificationFailure(ne);
           
            System.out.println(we + "could not be clicked");
            return false;
        }

    }
    
    public static boolean click_ElementCal(WebElement we, String elementName)
    {
        try
        {
        	
        	Assert.assertTrue(we.isDisplayed() && we.isEnabled(),elementName + "is not visible");
            we.sendKeys(Keys.ENTER); 
            System.out.println(elementName+ "clicked successfully");
        
            return true;
        }
        catch(Throwable ne)
        {
            System.out.println("No such element" + we);
           
            ErrorCollector.addVerificationFailure(ne);
           
            System.out.println(we + "could not be clicked");
            return false;
        }

    }


    public static boolean ClickRadialBtn(WebElement we,String elementName)

    {

        boolean flag=false;
        try
        {
            Assert.assertTrue(we.isDisplayed() && we.isEnabled(),"Element" + elementName + "is not displayed & visible");
            if(we.isSelected())
                return true;
            else
            {
                we.click();
                flag=true;
            }
        }

        catch(Throwable ne)
        {

            System.out.println("No such element" + elementName);
            //gm_WaitVisibility(we,40);
            ErrorCollector.addVerificationFailure(ne);
            flag=false;
            //log.error("Could not click " + we);
            System.out.println(we + "could not be clicked");
            return false;

        }

        return flag;
    }


    public static boolean setCalenderDate(WebElement we, String inputValue,String elementName)
    {
        try
        {
            Assert.assertTrue(we.isDisplayed() && we.isEnabled(),"Element" + elementName + "is not displayed & visible");

            return true;
        }

        catch(Throwable e)
        {

            System.out.println("No such element dear");
            ErrorCollector.addVerificationFailure(e);
            return false;
        }
    }

    public static void checkPageIsReady()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete"))
        {
            System.out.println("Page Is loaded.");
            return;
        }

        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        for (int i=0; i<25; i++)
        {
            try
            {
                Thread.sleep(1000);
            }

            catch(InterruptedException e)

            {

            }

            if (js.executeScript("return document.readyState").toString().equals("complete"))
            {
                break;
            }

        }

    }

    public static void checkElementClickable(WebElement we)
    {
        WebDriverWait wait =new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(we));

        //wait.until(ExpectedConditions.;
    }

    public static  void checkElementVisiblity(WebElement we) throws InterruptedException
    {
    	
    	try
    	{
    		WebDriverWait wait =new WebDriverWait(driver, 20);
    		wait.until(ExpectedConditions.visibilityOf(we));
    	}
    	
    	catch (StaleElementReferenceException se)
    	{
    		Thread.sleep(4000);
    		System.out.println("Exception occured " + se.getMessage());
    	}
        //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(""));
        //wait.until(ExpectedConditions.;
    }
    
    public static  void checkFrameAvailablity(String frameName) throws InterruptedException
    {
    	try
    	{
    	
    	WebDriverWait wait =new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
        System.out.println(frameName + "Frame displayed successfully");
    	}
    	catch (NoSuchElementException se)
    	{
    		Thread.sleep(4000);
    		System.out.println("Exception occured " + se.getMessage());
    	}
       
    }

    // Below method for page to load will also work

	 /*public static void waitForPageToLoad() {
		 String pageLoadStatus =null;

		    do {

		    	JavascriptExecutor  js = (JavascriptExecutor) driver;

		      pageLoadStatus = (String)js.executeScript("return document.readyState");

		      System.out.print(".");

		    } while ( !pageLoadStatus.equals("complete") );

		    System.out.println();

		    System.out.println("Page Loaded.");

		  }*/

    public final boolean ClickUsingJS(int Timeout)
    {
        boolean flag = false;
        try
        {
            WebElement element = driver.findElement(By.id("gbqfd"));

            JavascriptExecutor executor = (JavascriptExecutor)driver;

            executor.executeScript("arguments[0].click();", element);
        }
        catch (RuntimeException e)
        {
            String strErrMsg_GenLib = e.getMessage();
        }
        return flag;
    }

    public final boolean MouseHover(WebElement element)
    {
        boolean flag = false;
        try
        {
            //if (strErrMsg_GenLib != null)
            //    return false;

            Actions builder = new Actions(driver);
            builder.moveToElement(element).build().perform();
            //genericLibrary.PerformAction("browser", Action.WaitForPageToLoad, "5");
            flag = true;
        }
        catch (RuntimeException e)
        {
            flag = false;
            String strErrMsg_GenLib = e.getMessage();
        }
        return flag;
    }

    private boolean IsElementPresent(WebElement we) {

        boolean flag=false;
        try

        {
            flag=we.isDisplayed();
            return true;

        }

        catch (RuntimeException e)
        {
            flag = false;
            String strErrMsg_GenLib = e.getMessage();
        }
        return flag;

    }

    public static String GetText(WebElement we)
    {
        String strElementText = "";
        String strErrMsg_GenLib = "";
        try
        {
            //if (strErrMsg_GenLib != null)
            //    throw new Exception(strErrMsg_GenLib);

            strElementText = we.getText();

        }
        catch (RuntimeException e)
        {
            strElementText = "";
            strErrMsg_GenLib = e.getMessage();
        }
        return strElementText;
    }

    public final String GetValue(WebElement we)
    {
        String strElementValue = "";
        try
        {
            //if (strErrMsg_GenLib != null)
            //    throw new Exception(strErrMsg_GenLib);

            strElementValue = we.getAttribute("value");

        }
        catch (RuntimeException e)
        {
            strElementValue = "";
            String strErrMsg_GenLib = e.getMessage();
        }
        return strElementValue;
    }

    public final boolean WaitForElement(String strObject, int iTimeout)
    {
        boolean flag = false;
        try
        {
            for (int i = 0; i <= iTimeout; i++)
            {
                if (strObject.contains("something"))
                {

                    flag = true;
                    break;
                }
                else
                {
                    Thread.sleep(1000);
                }
            }
            if (!flag)
            {
                String strErrMsg_GenLib = "OBJECT '" + strObject + "' is not found. Waited for " + (new Integer(iTimeout)).toString() + " seconds.";
            }
        }
        catch (Exception e)
        {
            flag = false;
        }
        return flag;
    }

    public  void gm_WaitVisibility(WebElement we, int timeout_sec)
    {
        WebDriverWait waitObj=new WebDriverWait(driver, timeout_sec);
        waitObj.until(ExpectedConditions.visibilityOf(we));
    }

    public static String captureScreenShot(WebDriver driver, String screenShotName)
    {
        try {
            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            String dest="D:\\SalesLinkAutomation\\ScreenShots\\"+screenShotName+".png";
            //String dest=System.getProperty("user.dir")+"Screenshots\\folderName\\"+screenShotName+".png";
            File destination=new File(dest);
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot take");
            return dest;
        }
        catch (Exception e)
        {
            System.out.println("Exception while taking a screen shot"+ e.getMessage());
            return e.getMessage();
        }
    }

    public static String captureScreenShot1(WebDriver driver, String screenShotName,String folderName,String browserName)
    {
        String dest = null;
        Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
    	
        try 
        {
            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            if(browserName.equalsIgnoreCase("Firefox"))
            {


                //String path;
                //path = this.getClass().getClassLoader().getResource("../../").getPath();
                //String s = currentRelativePath.toAbsolutePath().toString();
                dest=System.getProperty("user.dir")+"\\Screenshots\\"+ folderName +"\\"+browserName +"\\"+screenShotName+".png";
                File destination=new File(dest);
               FileUtils.copyFile(source, destination);
                System.out.println("Screenshot take");

            }

            if(browserName.equalsIgnoreCase("chrome"))
            {


                //String path;
                //path = this.getClass().getClassLoader().getResource("../../").getPath();
                //String s = currentRelativePath.toAbsolutePath().toString();
                dest=System.getProperty("user.dir")+"\\Screenshots\\"+ folderName +"\\"+browserName +"\\"+screenShotName+".png";
                File destination=new File(dest);
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot take");

            }


        }
        catch (Exception e)
        {
            System.out.println("Exception while taking a screen shot"+ e.getMessage());
            return e.getMessage();
        }

        return dest;
    }

    
    public static String captureScreenShot2(WebDriver driver, String screenShotName,String folderName,String browserName)
    {
        String dest = null;
        Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
    	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try 
        {
           
            if(browserName.equalsIgnoreCase("Firefox"))
            {

            	//String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\ScreenShots\\Firefox\\"+folderName;
            	String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\ScreenShots\\Firefox\\Home Page";
            	//dest=System.getProperty("user.dir")+"\\ScreenShots\\"+ folderName +"\\"+browserName +"\\"+screenShotName+".png";
            	//File destFile = new File((String) reportDirectory + screenShotName + "_" + formater.format(calendar.getTime()) + ".png");
            	
            	File destFile = new File((String) reportDirectory + formater.format(calendar.getTime()) + ".png");
                FileUtils.copyFile(scrFile, destFile);
                Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
                System.out.println("Screenshot take");

            }

            if(browserName.equalsIgnoreCase("chrome"))
            {


                //String path;
                //path = this.getClass().getClassLoader().getResource("../../").getPath();
                //String s = currentRelativePath.toAbsolutePath().toString();
                dest=System.getProperty("user.dir")+"\\Screenshots\\"+ folderName +"\\"+browserName +"\\"+screenShotName+".png";
                File destination=new File(dest);
               // FileUtils.copyFile(source, destination);
                System.out.println("Screenshot take");

            }


        }
        catch (Exception e)
        {
            System.out.println("Exception while taking a screen shot"+ e.getMessage());
            return e.getMessage();
        }

        return dest;
    }
    
    public static String captureScreenShot3(WebDriver driver, String screenShotName,String folderName,String browserName)
    {
        String dest = null;
        String timeStamp;
        //Calendar calendar = Calendar.getInstance();
    	//SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        
    	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    	//String dateTime=
        try 
        {
           
            if(browserName.equalsIgnoreCase("Firefox"))
            {

            	dest=System.getProperty("user.dir")+"\\ScreenShots\\"+ browserName +"\\"+folderName+"\\"+timeStamp+"__"+screenShotName+".png";
            	File dest1=new File (System.getProperty("user.dir")+"\\ScreenShots\\"+ browserName +"\\"+folderName +"\\"+timeStamp+"__"+screenShotName+".png");
            	FileUtils.copyFile(scrFile, dest1);
            	//String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\ScreenShots\\Firefox\\"+folderName;
            	//String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\ScreenShots\\Firefox\\Home Page";
            	//dest=System.getProperty("user.dir")+"\\ScreenShots\\"+ folderName +"\\"+browserName +"\\"+screenShotName+".png";
            	//File destFile = new File((String) reportDirectory + screenShotName + "_" + formater.format(calendar.getTime()) + ".png");
            	
            	//File destFile = new File((String) reportDirectory + formater.format(calendar.getTime()) + ".png");
               // FileUtils.copyFile(scrFile, destFile);
            	//String dest1= new File(System.getProperty("user.dir")).getAbsolutePath()+"\\ScreenShots\\Firefox\\Home Page" + getCurrentTimeStamp() + ".png");
            	//FileUtils.copyFile(scrFile, dest);
                //Reporter.log("<a href='" + destFile1.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
                System.out.println("Screenshot take");

            }

            if(browserName.equalsIgnoreCase("chrome"))
            {


                //String path;
                //path = this.getClass().getClassLoader().getResource("../../").getPath();
                //String s = currentRelativePath.toAbsolutePath().toString();
                dest=System.getProperty("user.dir")+"\\Screenshots\\"+ folderName +"\\"+browserName +"\\"+screenShotName+".png";
                File destination=new File(dest);
               // FileUtils.copyFile(source, destination);
                System.out.println("Screenshot take");

            }


        }
        catch (Exception e)
        {
            System.out.println("Exception while taking a screen shot"+ e.getMessage());
            return e.getMessage();
        }

        return dest;
    }
    
    public static String captureScreenShot4(WebDriver driver, String screenShotName,String folderName,String browserName)
    {
        String dest = null;
        String timeStamp;
        //Calendar calendar = Calendar.getInstance();
    	//SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        
    	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    	//String dateTime=
        try 
        {
           
            if(browserName.equalsIgnoreCase("Firefox"))
            {

            	File dest1=new File (System.getProperty("user.dir")+"\\ScreenShots\\"+ browserName +"\\"+folderName +"\\"+timeStamp+"__"+screenShotName+".png");
            	FileUtils.copyFile(scrFile, dest1);
            	dest=System.getProperty("user.dir")+"\\ScreenShots\\"+ browserName +"\\"+folderName +"\\"+timeStamp+"__"+screenShotName+".png";
            	//String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\ScreenShots\\Firefox\\"+folderName;
            	//String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\ScreenShots\\Firefox\\Home Page";
            	//dest=System.getProperty("user.dir")+"\\ScreenShots\\"+ folderName +"\\"+browserName +"\\"+screenShotName+".png";
            	//File destFile = new File((String) reportDirectory + screenShotName + "_" + formater.format(calendar.getTime()) + ".png");
            	
            	//File destFile = new File((String) reportDirectory + formater.format(calendar.getTime()) + ".png");
               // FileUtils.copyFile(scrFile, destFile);
            	//String dest1= new File(System.getProperty("user.dir")).getAbsolutePath()+"\\ScreenShots\\Firefox\\Home Page" + getCurrentTimeStamp() + ".png");
            	//FileUtils.copyFile(scrFile, dest);
                //Reporter.log("<a href='" + destFile1.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
                System.out.println("Screenshot take");

            }

            if(browserName.equalsIgnoreCase("chrome"))
            {


                //String path;
                //path = this.getClass().getClassLoader().getResource("../../").getPath();
                //String s = currentRelativePath.toAbsolutePath().toString();
                dest=System.getProperty("user.dir")+"\\Screenshots\\"+ folderName +"\\"+browserName +"\\"+screenShotName+".png";
                File destination=new File(dest);
               // FileUtils.copyFile(source, destination);
                System.out.println("Screenshot take");

            }


        }
        catch (Exception e)
        {
            System.out.println("Exception while taking a screen shot"+ e.getMessage());
            return e.getMessage();
        }

        return dest;
    }

    public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(new Date());
    }

    public static String getStartDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 5);
        return dateFormat.format(cal.getTime());
    }

    public static String getEndDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return dateFormat.format(cal.getTime());
    }
    
    public static String currentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String cal1 = dateFormat.format(cal.getTime());
        return cal1;
    }
	/*public static Object [][] getTestData(String sheetName)
	{
		int rows=excel1.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);

		Object data [][]=new Object[rows-1][cols];

		for (int rowNum=2;rowNum<=rows;rowNum++)
		{
			for (int colNum=0;colNum<cols;colNum++)
			{
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}

		return data;
	}*/


    public static String getCellValue(String pathOfFile, String sheetName, int rowNum, int cellNum) throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException{
        FileInputStream fis = new FileInputStream(pathOfFile);
        Workbook wb = WorkbookFactory.create(fis);
        int type = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getCellType();
        String value = "";
        if(type==Cell.CELL_TYPE_STRING)
        {
            value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();

        }

        else if(type==Cell.CELL_TYPE_FORMULA)
        {
            value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();

        }
        else if(type==Cell.CELL_TYPE_NUMERIC)
        {
            int numValue = (int) wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
            value = ""+numValue;
        }
        else if(type==Cell.CELL_TYPE_BOOLEAN){
            boolean boolValue =  wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getBooleanCellValue();
            value = ""+boolValue;
        }
        return value;
    }




}


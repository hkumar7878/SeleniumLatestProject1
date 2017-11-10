package utilLibrary;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import baseSetUp.BaseSetUp;

//import baseSetUp.BaseSetUp;
import ErrorCollectors.ErrorCollector;

public class ApplicationUtilLib extends BaseSetUp{

    public static String strErrorDescription=null;


    public static boolean selectDropDownValue(WebElement we,List<WebElement> dropDownlist,String optionName,String elementName)
    {
        boolean flag=false;
        try
        {
            Assert.assertTrue(we.isDisplayed() && we.isEnabled(),"Element" + elementName + "is not displayed & visible");
            List<WebElement> options = dropDownlist;
            if(GenericUtilLib.click_Element(we, "dropdown"))
            {
                Thread.sleep(2000);
                for (WebElement opt : options)
                {
                    //we.click();
                    {
                        if (opt.getText().equals(optionName))
                        {
                            Thread.sleep(2000);
                            opt.click();
                            flag=true;
                            break;
                        }

                    }
                }
            }
            else
            {
                flag=false;
            }
            //  return true;
        }
        catch(Throwable e)
        {

            System.out.println("No such element dear" + optionName);

            System.out.println("Exception" + e.getMessage());
            ErrorCollector.addVerificationFailure(e);
            //throw new NoSuchElementException("Can't find " + option + " in dropdown");
            return false;
        }
        //throw new NoSuchElementException("Can't find " + option + " in dropdown");
        return flag;
    }

    
    public static <E> void compareValues(E value1, E value2, String campareType,String browserType)
    {	
    	try
    	{
    		switch(campareType)
    		{		
    		case "casualLeave":
    			switch(browserType)
    			{
    				case "Firefox":  	
    				if(value1.equals(value2))
    					FF_logger.log(LogStatus.PASS, "Causal leaves matched");
    				else
    					FF_logger.log(LogStatus.PASS, "Causal leaves not matched");
    				break;
    				
    			case "chrome" :
    				if(value1.equals(value2))
        				CH_logger.log(LogStatus.PASS, "Causal leaves matched");
    				else
    					CH_logger.log(LogStatus.PASS, "Causal leaves not matched");
    				break;
    			default: 
    				System.out.println("");
    			}
    			default:
    			System.out.println("");
    		}
    	}
    	
    	catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
    }
    
    public static <E> void compareValues1(E value1, E val, String campareType)
    {
    	
    	
    	
    	
    }

    //public static boolean selectDesiredCheckBoxes(List<WebElement> checkBoxes, String [] checkBoxesNameTobeSelected) throws InterruptedException
    //public static boolean selectDesiredCheckBoxes(WebElement checkBoxes, WebElement table,String [] checkBoxesNameTobeSelected) throws InterruptedException

	/*public static boolean selectDesiredCheckBoxes(String [] checkBoxesNameTobeSelected) throws InterruptedException
	{


		boolean flag=false;

		String [] ShouldBeCheckboxes=checkBoxesNameTobeSelected;
		System.out.println(ShouldBeCheckboxes);
		//WebElement checkBox=driver.findElement(By.xpath("//td[contains(text(),'AK')]/preceding::td/input[@id='chkState-2']"));
		//String checkBoxName="//td[contains(text(),'AK')]/preceding::td/input[@id='chkState-2']";
		int arraySize=ShouldBeCheckboxes.length;
		try
		{
			for(int i=0;i<arraySize;i++)
			{
				Thread.sleep(2000);
				System.out.println(ShouldBeCheckboxes[0]);
				//WebElement checkBox=driver.findElement(By.xpath("//td[contains(text(),'" + ShouldBeCheckboxes[i] + "')]/preceding-sibling::td/input[@id='chkState-2']"));
				System.out.println("testing");
				Thread.sleep(2000);
				if(checkBox.isSelected())
					{
						checkBox.click();
					}

				else
				{
					checkBox.click();
					flag=true;
			}
		}

	}

		catch(Exception e)
		{
			flag=false;
		}


		return flag;
	}
	*/
	/*public static boolean selectDesiredCheckBoxes1(String [] checkBoxesNameTobeSelected,String checkBoxToBeSelectedType) throws InterruptedException
	{


		boolean flag=false;
		String xpathHolder="";

		String [] ShouldBeCheckboxes=checkBoxesNameTobeSelected;
		System.out.println(ShouldBeCheckboxes);

		int arraySize=ShouldBeCheckboxes.length;
		try
		{
			for(int i=0;i<arraySize;i++)
			{
				Thread.sleep(2000);
				System.out.println(ShouldBeCheckboxes[0]);
				if(checkBoxToBeSelectedType.equalsIgnoreCase("variation"))
				{
					xpathHolder="//td[label[contains(text(),'" + ShouldBeCheckboxes[i] + "')]]/preceding-sibling::td";
				}
				if(checkBoxToBeSelectedType.equalsIgnoreCase("states"))
				{
					xpathHolder="//td[contains(text(),'" + ShouldBeCheckboxes[i] + "')]/preceding-sibling::td/input[@id='chkState-2']";
				}

				if(checkBoxToBeSelectedType.equalsIgnoreCase("resCategories"))
				{
					xpathHolder="//div[contains(text(),'" + ShouldBeCheckboxes[i] + "')]/preceding-sibling::div/input[@type='checkbox']";
				}

				WebElement checkBox=driver.findElement(By.xpath(xpathHolder));
				System.out.println("testing");
				//Thread.sleep(2000);
				if(checkBox.isSelected())
					{
						checkBox.click();
					}

				else
				{
					checkBox.click();
					flag=true;
			}
		}

	}

		catch(Exception e)
		{
			flag=false;
		}


		return flag;
	}

*/

	/*public static boolean verifySelected_Items(String [] items) throws InterruptedException
	{


		boolean flag=false;

		String [] items_ToVerify=items;
		System.out.println(items_ToVerify);
		List<String> expitemList = Arrays.asList(items_ToVerify);
		List<String> itemName=new ArrayList<String>();
		int arraySize=items_ToVerify.length;
		try
		{
			for(int i=0;i<arraySize;i++)
			{
				Thread.sleep(2000);
				System.out.println(items_ToVerify[0]);
				String elementText=driver.findElement(By.xpath("//div[@id='gridUpdateStateAvailability']/descendant::td[text()='" + items_ToVerify[i] + "']")).getText();
				System.out.println(items_ToVerify[i]);
				itemName.add(elementText);
			}

			// Campare the actual and expected items

			flag=campareList(expitemList,itemName);


	}

		catch(Exception e)
		{
			strErrorDescription=e.getMessage();
			flag=false;
		}


		return flag;
	}
	*/
	/*public static boolean verify_Table_Col_Static_Value(String colValue) throws InterruptedException
	{


		boolean flag=false;

		String item_ToVerify=colValue;
		System.out.println(colValue);
		WebElement table=driver.findElement(By.xpath("//div[@id='gridUpdateStateAvailability']/descendant::tbody"));
		List <WebElement>rows_table=table.findElements(By.tagName("tr"));
		int rowsSize=rows_table.size();



		try
		{
			for(int i=1;i<=rowsSize;i++)
			{
				WebElement colElement=driver.findElement(By.xpath("//div[@id='gridUpdateStateAvailability']/descendant::tbody/tr['"+ i +"']/td[2]"));
				String colText=colElement.getText();
				if(colText.equals(item_ToVerify))
				{
					System.out.println(colValue + "is correctly matching");
					flag=true;
				}
			}
		}

		catch(Exception e)
		{
			strErrorDescription=e.getMessage();
			flag=false;
		}


		return flag;
	}
	*/


    public static boolean campareList(List<String> actual,List<String> exp)
    {
        boolean flag=false;

        try
        {
            //flag=actual.equals(exp);
            if (actual.size() != exp.size())
            {
                //flag= false;

                return false;
            }

            for(int i=0;i<actual.size();i++)
            {
                String actualItem=(String)actual.get(i);

                for (int j=0;j<exp.size();j++)
                {
                    String expItem=(String)exp.get(j);
                    int result = actualItem.compareTo(expItem);
                    if(result==0)
                    {
                        System.out.println(actualItem + " = " + expItem);
                        flag=true;
                    }

                    else
                    {
                        flag=false;
                    }
                }
            }

        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return flag;


        //return flag;
    }

	/*List<WebElement> allOptions = checkBoxes.findElements(By.tagName("input"));
	//for (WebElement chebox:checkBoxes)

	{
		for (WebElement option : allOptions) {
			   System.out.println("Option value "+option.getText());
			        if (checkBoxesNameTobeSelected.equals(option.getText())) {
			            option.click();
			            break;
			        }
			    }

		Thread.sleep(2000);
	}*/

    public static ArrayList<String> fetchGridData(WebElement table,WebElement btnLastPgNav) throws Exception
    {
        String grpSeriesName="HG Test 16_23 Group Series_2ndFeb";
        boolean flag=false;
        ArrayList<String> rowsData=new ArrayList<String>();
        try
        {
            List <WebElement>rows_table=table.findElements(By.tagName("tr"));
            int rows_count = rows_table.size();
            //

            for(int row=0;row<rows_count;row++)
            {
                List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
                int columns_count = Columns_row.size();
                System.out.println(Columns_row.get(0).getText());
                if(Columns_row.get(0).getText().equals(grpSeriesName))
                {
                    for(int j=0;j<columns_count;j++)
                    {
                        rowsData.add(Columns_row.get(j).getText());
                        flag=true;
                        return rowsData;
                    }
                    break;
                }
            }

            //if(flag==false)
            while(!flag)
            {


                Thread.sleep(3000);
                //checkPageIsReady();
                //WebElement btnLastPageNavigation="//span[@class='k-icon k-i-seek-e']";
                //WebElement we=driver.findElement(By.xpath("//a[@title='Go to the next page']"));
                //WebElement btnLastPageNav=GenericUtilLib.getStaleElement(we);
                //GenericUtilLib.getStaleElement(we);
                //btnLastPageNav.click();
                //driver.findElement(By.xpath("//span[@class='k-icon k-i-seek-e']")).click();
                Thread.sleep(1000);
                List <WebElement>rows_table2=table.findElements(By.tagName("tr"));
                int rows_count2 = rows_table2.size();
                for(int row=0;row<rows_count2;row++)
                {
                    List<WebElement> Columns_row2 = rows_table2.get(row).findElements(By.tagName("td"));
                    int columns_count = Columns_row2.size();
                    System.out.println(Columns_row2.get(0).getText());
                    if(Columns_row2.get(0).getText().equals(grpSeriesName))
                    {
                        for(int j=0;j<columns_count;j++)
                        {
                            rowsData.add(Columns_row2.get(j).getText());
                            //flag=true;
                            //return rowsData;
                        }
                        break;
                    }
                }
            }
        }

        catch (StaleElementReferenceException e)
        {
            System.out.println("Attempting to recover from StaleElementReferenceException ...");
        }
        return rowsData;

    }


    public static ArrayList<String> fetchGridData1(WebElement table,WebElement btnLastPgNav, String grpSeriesName) throws Exception
    {
        String grpSeriesName1="HGZZZZZZZZZ";
        boolean flag=false;
        ArrayList<String> rowsData=new ArrayList<String>();
        try
        {
            List <WebElement>rows_table=table.findElements(By.tagName("tr"));
            int rows_count = rows_table.size();

            for(int row=0;row<rows_count;row++)
            {
                List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
                int columns_count = Columns_row.size();
                System.out.println(Columns_row.get(0).getText());
                //if(Columns_row.get(0).getText().equals(grpSeriesName))
                if(Columns_row.get(0).getText().equals(grpSeriesName1))
                {
                    for(int j=0;j<columns_count;j++)
                    {
                        rowsData.add(Columns_row.get(j).getText());
                        flag=true;
                        return rowsData;
                    }
                    break;
                }
            }

            //if(flag==false)
            while(!flag)
            {


                Thread.sleep(3000);
                //checkPageIsReady();
                //WebElement btnLastPageNavigation="//span[@class='k-icon k-i-seek-e']";
                //WebElement we=driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-e']"));
                //WebElement btnLastPageNav=GenericUtilLib.getStaleElement(we);
                //GenericUtilLib.getStaleElement(we);
                //btnLastPageNav.click();
                //driver.findElement(By.xpath("//span[@class='k-icon k-i-seek-e']")).click();
                Thread.sleep(1000);
                List <WebElement>rows_table2=table.findElements(By.tagName("tr"));
                int rows_count2 = rows_table2.size();
                for(int row=0;row<rows_count2;row++)
                {
                    List<WebElement> Columns_row2 = rows_table2.get(row).findElements(By.tagName("td"));
                    int columns_count = Columns_row2.size();
                    System.out.println(Columns_row2.get(0).getText());
                    //if(Columns_row2.get(0).getText().equals(grpSeriesName))
                    if(Columns_row2.get(0).getText().equals(grpSeriesName1))
                    {
                        for(int j=0;j<columns_count;j++)
                        {
                            rowsData.add(Columns_row2.get(j).getText());
                            flag=true;
                            //return rowsData;
                        }
                        break;
                    }
                }
            }
        }

        catch (StaleElementReferenceException e)
        {
            System.out.println("Attempting to recover from StaleElementReferenceException ...");
        }
        return rowsData;

    }

    public static ArrayList<String> fetchGridData2(WebElement table,WebElement btnLastPgNav, String grpSeriesName) throws Exception
    {
        String grpSeriesName1="HGZZZZZZZZZ";
        boolean flag=false;
        ArrayList<String> rowsData=new ArrayList<String>();
        try
        {
            List <WebElement>rows_table=table.findElements(By.tagName("tr"));
            int rows_count = rows_table.size();

            for(int row=0;row<rows_count;row++)
            {
                List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
                int columns_count = Columns_row.size();
                System.out.println(Columns_row.get(0).getText());
                //if(Columns_row.get(0).getText().equals(grpSeriesName))
                if(Columns_row.get(0).getText().equals(grpSeriesName1))
                {
                    for(int j=0;j<columns_count;j++)
                    {
                        rowsData.add(Columns_row.get(j).getText());
                        flag=true;
                        return rowsData;
                    }
                    break;
                }
            }
            //OUTER:
            while(!flag)
            {

                boolean isEventSuccessful=false;
                Thread.sleep(1000);
                //WebElement we=driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-e']"));
                //isEventSuccessful=GenericUtilLib.getStaleElement(we);
                //isEventSuccessful=GenericUtilLib.arrowClick(we);
                //isEventSuccessful=GenericUtilLib.isClickable(we);
                INNER:
                while(isEventSuccessful)
                {
                    Thread.sleep(1000);
                    List <WebElement>rows_table2=table.findElements(By.tagName("tr"));
                    int rows_count2 = rows_table2.size();
                    for(int row=0;row<rows_count2;row++)
                    {
                        List<WebElement> Columns_row2 = rows_table2.get(row).findElements(By.tagName("td"));
                        int columns_count = Columns_row2.size();
                        System.out.println(Columns_row2.get(0).getText());
                        //if(Columns_row2.get(0).getText().equals(grpSeriesName))
                        if(Columns_row2.get(0).getText().equals(grpSeriesName1))
                        {
                            for(int j=0;j<columns_count;j++)
                            {
                                rowsData.add(Columns_row2.get(j).getText());
                                flag=true;			//return rowsData;
                            }
                            break;
                        }
                    }
                    if(isEventSuccessful==true)
                        break INNER;

                }// End of inner loop

            }
        }
        catch (StaleElementReferenceException e)
        {
            System.out.println("Attempting to recover from StaleElementReferenceException ...");
        }
        return rowsData;

    }

    // This is the only method which is working fine for verification of group series on the group series main page.
    // So use it.Rest of others are not working properly.

	/*public static ArrayList<String> fetchGridData3(WebElement table,WebElement btnLastPgNav, String grpSeriesName) throws Exception
	{
		String grpSeriesName1="FG Guarantee-PlatinumGFASDFASDF";
		boolean flag=false;
		boolean isEventSuccessful=false;
		//List <WebElement>arrowcount=driver.findElements(By.xpath("//div[@class='k-pager-wrap k-grid-pager k-widget']/ul/li"));
		//int arrowCountsize=arrowcount.size();
		ArrayList<String> rowsData=new ArrayList<String>();
		try
		{
			List <WebElement>rows_table=table.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();

			for(int row=0;row<rows_count;row++)
			{
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				int columns_count = Columns_row.size();
				System.out.println(Columns_row.get(0).getText());
				//if(Columns_row.get(0).getText().equals(grpSeriesName))
				if(Columns_row.get(0).getText().equals(grpSeriesName1))
				{
					for(int j=0;j<columns_count;j++)
						{
							rowsData.add(Columns_row.get(j).getText());
							flag=true;
							//return rowsData;
						}
					break;
				}
			}

			Thread.sleep(2000);

			WebElement we=driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-e']"));
			isEventSuccessful=GenericUtilLib.isClickable(we);
			while(isEventSuccessful)
			{
				//WebElement we1=driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-e']"));
				Thread.sleep(2000);
				GenericUtilLib.isElementPresent(table);
				List <WebElement>rows_table2=table.findElements(By.tagName("tr"));
				int rows_count2 = rows_table2.size();
				//INNER:
				for(int row=0;row<rows_count2;row++)
					{
						Thread.sleep(1000);
						List<WebElement> Columns_row2 = rows_table2.get(row).findElements(By.tagName("td"));
						int columns_count = Columns_row2.size();
						System.out.println(Columns_row2.get(0).getText());
						//if(Columns_row2.get(0).getText().equals(grpSeriesName))
						if(Columns_row2.get(0).getText().equals(grpSeriesName1))
							{
								for(int j=0;j<columns_count;j++)
									{
										rowsData.add(Columns_row2.get(j).getText());
										flag=true;
									}
								//
							}
						if(flag==true)
						{
							break;
						}
					}

				if(flag==true)
				{
					break;
				}
				else
				{
					isEventSuccessful=GenericUtilLib.isClickable(we);
				//Thread.sleep(3000);
					GenericUtilLib.isElementPresent(table);
				}
			}



}
		 catch (RuntimeException e)

		 {

			 System.out.println("Attempting to recover from StaleElementReferenceException ..." + e.getMessage());
		 }
		return rowsData;

	}

	*/

    public static ArrayList<String> fetchGridData3(WebElement table,WebElement btnLastPgNav, String grpSeriesName) throws Exception
    {
        //String grpSeriesName1="FG Life-Elite Test New Group";
        String grpSeriesName1=grpSeriesName;
        boolean flag=false;


        ArrayList<String> rowsData=new ArrayList<String>();
        try
        {

            List <WebElement>rows_table=table.findElements(By.tagName("tr"));
            int rows_count = rows_table.size();
            Thread.sleep(10000);
            //GenericUtilLib.isElementPresent(".//*[@id='gridProductGroupSeries']/div[2]/table");
            GenericUtilLib.isElementPresent(table);

            for(int row=0;row<rows_count;row++)
            {
                List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
                int columns_count = Columns_row.size();
                System.out.println(Columns_row.get(0).getText());
                //if(Columns_row.get(0).getText().equals(grpSeriesName))
                if(Columns_row.get(0).getText().equals(grpSeriesName1))
                {
                    for(int j=0;j<columns_count;j++)
                    {
                        rowsData.add(Columns_row.get(j).getText());
                        flag=true;
                        //return rowsData;
                    }
                    break;
                }
            }
        }
        catch (RuntimeException e)

        {

            System.out.println("Attempting to recover from StaleElementReferenceException ..." + e.getMessage());
        }
        return rowsData;

    }


	/*Below function is used to fetch table row data on the basis of single string value.
	 *
	 *
	 *
	 * */

    public static ArrayList<String> fetchGridData4(WebElement table,WebElement btnLastPgNav, String itemName) throws Exception
    //public static ArrayList<String> fetchGridData4(WebElement table,String itemName) throws Exception
    {
        //String itemToBeSearched="Annuity_Product_AUT153";
        String itemToBeSearched=itemName;
        //String grpSeriesName1=grpSeriesName;
        boolean flag=false;
        List <WebElement>rows_table=null;
        int rows_count =0;


        ArrayList<String> rowsData=new ArrayList<String>();
        try
        {


            //WebElement table1=GenericUtilLib.handleStaleElement("//div[@class='k-grid-content']");
            //rows_table=table1.findElements(By.tagName("tr"));
            rows_count = rows_table.size();
            Thread.sleep(2000);
            //GenericUtilLib.isElementPresent(table1);

            //GenericUtilLib.isElementPresent(table1);

            for(int row=0;row<rows_count;row++)
            {
                List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
                int columns_count = Columns_row.size();
                System.out.println(Columns_row.get(0).getText());

                if(Columns_row.get(0).getText().equals(itemToBeSearched))
                {
                    for(int j=0;j<columns_count;j++)
                    {
                        rowsData.add(Columns_row.get(j).getText());
                        flag=true;
                        //return rowsData;
                    }
                    break;
                }
            }
        }
        catch (RuntimeException e)

        {

            System.out.println("Attempting to recover from StaleElementReferenceException ..." + e.getMessage());
        }
        return rowsData;

    }
    
    public static ArrayList<String> fetchTableData(WebElement table) throws Exception
    {
    	ArrayList<String> rowsData=new ArrayList<String>();
    	try
    	{
    		List <WebElement>rows_table=table.findElements(By.tagName("tr"));
    		int rows_count = rows_table.size();
    		Thread.sleep(2000);
    		//GenericUtilLib.isElementPresent(".//*[@id='gridProductGroupSeries']/div[2]/table");
    		//GenericUtilLib.isElementPresent(table);
    		for(int row=1;row<rows_count;row++)
    		{
    			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
    			int columns_count = Columns_row.size();
    			System.out.println(Columns_row.get(row).getText());
    			for(int j=0;j<columns_count;j++) 		
    				rowsData.add(Columns_row.get(j).getText());  			
    			break;
    		}
    	}
    	catch (RuntimeException e)
    	{

    		System.out.println("Attempting to recover from StaleElementReferenceException ..." + e.getMessage());
    	}
    	return rowsData;
    }


	/*Below function can be used to verify table record
	 * data for array of records.
	 *
	 * */

    //public static ArrayList<String> fetchGridData5(WebElement table,String [] items) throws Exception
    public static ArrayList<String> fetchGridDate_After_Filter(WebElement table,WebElement btnLastPgNav, String itemName) throws Exception
    {
        //String itemToBeSearched="Annuity_Product_AUT153";
        String itemToBeSearched=itemName;
        //String grpSeriesName1=grpSeriesName;
        boolean flag=false;
        List <WebElement>rows_table=null;
        int rows_count =0;


        ArrayList<String> rowsData=new ArrayList<String>();
        try
        {


            //WebElement table1=GenericUtilLib.handleStaleElement("//div[@class='k-grid-content']");
            //rows_table=table1.findElements(By.tagName("tr"));
            rows_count = rows_table.size();
            Thread.sleep(2000);


            for(int row=0;row<rows_count;row++)
            {
                List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
                int columns_count = Columns_row.size();
                System.out.println(Columns_row.get(0).getText());

                if(Columns_row.get(0).getText().equals(itemToBeSearched))
                {
                    for(int j=0;j<columns_count;j++)
                    {
                        rowsData.add(Columns_row.get(j).getText());
                        flag=true;
                        //return rowsData;
                    }
                    break;
                }
            }
        }
        catch (RuntimeException e)

        {

            System.out.println("Attempting to recover from StaleElementReferenceException ..." + e.getMessage());
        }
        return rowsData;

    }

    public static boolean fetch_Verify_GridData(WebElement table,String [] items) throws Exception

    {

        String [] itemToBeSearched=items;

        String StartDate="03/22/2016";
        String currentStatus="Available - Standard ";
        String variation="";

        boolean flag=false;
        List <WebElement>rows_table=null;
        int rows_count =0;
        int k=0;


        ArrayList<String> rowsData=new ArrayList<String>();
        try
        {


            //WebElement table1=GenericUtilLib.handleStaleElement("//div[@class='k-grid-content']");
            //rows_table=table1.findElements(By.tagName("tr"));
            rows_count = rows_table.size();
            //Thread.sleep(1000);

            for(int row=0;row<=rows_count;row++)
            {
                List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
                int columns_count = Columns_row.size();
                System.out.println(Columns_row.get(1).getText());
                String item_Name=itemToBeSearched[k];
                //Thread.sleep(2000);
                if(Columns_row.get(1).getText().equals(item_Name))
                {
                    for(int j=0;j<columns_count;j++)
                    {
                        //rowsData.add(Columns_row.get(j).getText());
                        if(Columns_row.get(j).getText().equals("") && Columns_row.get(j+1).getText().equals(item_Name) && Columns_row.get(j+2).getText().equals(StartDate)
                                && Columns_row.get(j+3).getText().equals(currentStatus.trim()) && Columns_row.get(j+4).getText().equals(variation)
                                && Columns_row.get(j+5).getText().equals("EditDelete"));
                        {
                            flag=true;
                        }

                    }

                    k++;

                    if(k==itemToBeSearched.length)
                    {
                        break;
                    }
                }
            }
        }
        catch (RuntimeException e)

        {

            System.out.println("Attempting to recover from StaleElementReferenceException ..." + e.getMessage());
            flag=false;
        }
        //return rowsData;
        return flag;

    }

	/*public static void checkPageIsReady()
	{
		//JavascriptExecutor js = (JavascriptExecutor)driver; //Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete"))
		{
			System.out.println("Page Is loaded.");
			return;
		}
	}*/

    public static boolean VerifyGridRowData(ArrayList<String> gridRow,String col2Value,String col3Value,String col4Value,String col5Value)
    {
        boolean flag=false;

        String [] expected_Values={col2Value,col3Value,col4Value,col5Value};

        gridRow.remove(0);

        try
        {
            String gridRowData []=gridRow.toArray(new String[gridRow.size()]);

            for (int i = 0; i < gridRow.size(); i++)
            {
                System.out.println(gridRowData[i]);
                if(gridRowData[i].equals(expected_Values[i]))
                {
                    flag=true;
                }

                else
                    flag=false;
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            flag=false;
            System.out.println(e.getMessage());
        }

        return flag;
    }
	/*public static ArrayList<String> fetchGridData(WebElement table) throws Exception
	{
		String grpSeriesName="AnnuitySeries_Test_Ketan1";
		ArrayList<String> rowData=new ArrayList<String>();
		try
		{
		List <WebElement>TotalRows=table.findElements(By.tagName("tr"));
		boolean flag=false;
		for(WebElement rowElement:TotalRows)
		//for(int i=0;i<TotalRows.size();i++)
		{
			List<WebElement> columns=rowElement.findElements(By.tagName("td"));

			for(int j=0;j<columns.size();j++)
			{
				//System.out.println("Row "+rowIndex+" Column "+ColumnIndex+" Data "+colElement.getText());
				if(columns.get(0).getText().equals(grpSeriesName))
				{
					rowData.add(rowElement.getText());
					//return rowData;
					flag=true;
					break;

				}

			}

			if(flag=true)
				break;

			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return rowData;
	}*/

    public static ArrayList<String> fetchGridData1(WebElement table) throws Exception
    {
        String grpSeriesName="AnnuitySeries_Test_Ketan1";
        WebElement colElement;
        ArrayList<String> rowData=new ArrayList<String>();
        List <WebElement>TotalRows=table.findElements(By.tagName("tr"));
        System.out.println("Rows count: " + TotalRows.size());
        Iterator<WebElement> i = TotalRows.iterator();
        int colIndex=0;
        try
        {
            while (i.hasNext())
            {

                WebElement row = i.next();
                System.out.println("Row data: " + row.getText());
                //colElement = row.findElement(By.xpath("(.//td)[colIndex]"));
                colElement = row.findElement(By.tagName(".//td[" + colIndex + "]"));
                if(colElement.getText().trim().equals(grpSeriesName))
                {
                    rowData.add(colElement.getText().trim());
                }
                colIndex++;
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return rowData;
    }

    public static boolean selectDropDownValue1(WebElement we,List<WebElement> dropDownlist,String optionName,String elementName)
    {
        boolean flag=false;
        try
        {
            Assert.assertTrue(we.isDisplayed() && we.isEnabled(),"Element" + elementName + "is not displayed & visible");
            List<WebElement> options = dropDownlist;
            // Loop through the options and select the one that matches
            for (WebElement opt : options)
            {
                //we.click();
                if(GenericUtilLib.click_Element(we, "dropdown"))
                {

                    if (opt.getText().equals(optionName))
                    {

                        Thread.sleep(5000);
                        opt.click();
                        //return true;
                        flag=true;
                        break;
                    }
                    else
                        flag=false;
                }

            }
            //  return true;
        }
        catch(Throwable e)
        {

            System.out.println("No such element dear");
            ErrorCollector.addVerificationFailure(e);
            //throw new NoSuchElementException("Can't find " + option + " in dropdown");
            return false;
        }
        //throw new NoSuchElementException("Can't find " + option + " in dropdown");
        return flag;
    }


    public static boolean verifySuccessMsg(WebElement successMsg,WebElement validationMsg,WebElement closeBtn, String productGrpSrsName, WebElement we)
    {
        boolean flag=false;
        try
        {
            if(successMsg.getText().contains("Saved Succesfully"))
            {
                GenericUtilLib.click_Element(closeBtn, "Close button");
                flag=true;

            }

            else if(validationMsg.getText().contains("already exists"))
            {
                GenericUtilLib.click_Element(closeBtn, "Close button");
                flag=false;

            }
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public static boolean clickUnderWebTable(WebElement we,String linkText)
    {

        boolean isEventSuccessful=false;
        try
        {
            //List <WebElement>allRows=Find_Agent_Page.webTable.findElements(By.tagName("tr"));
            List <WebElement>allRows=we.findElements(By.tagName("tr"));
            int row_count=allRows.size();
            for(int row=0;row<row_count;row++)
            {
                List<WebElement> Cols=allRows.get(row).findElements(By.tagName("td"));
                int columns_count=Cols.size();

                for(int col=0;col<columns_count;col++)
                {
                    String celText=Cols.get(col).getText();
                    //if(celText.equalsIgnoreCase(Agent_Search_Page.agentID))
                    if(celText.equalsIgnoreCase(linkText))
                    {
                        Cols.get(col).findElement(By.tagName("a")).click();
                        //System.out.println(Agent_Search_Page.agentID "is clicked");
                        isEventSuccessful=true;
                        break;
                    }
                    else
                    {
                        isEventSuccessful=false;
                    }
                }
            }

        }

        catch(RuntimeException e)
        {
            //log.error("Could not find the required table");
        }
        return isEventSuccessful;
    }

    public static ArrayList<String> GetOptionsInDropdown(WebElement gridTable) throws Exception
    {
        ArrayList<String> rowData=new ArrayList<String>();

        return rowData;

    }


    public static ArrayList<String> GetOptionsInDropdown1(List<WebElement> dropdownlist) throws Exception
    {

        int optionCount=0;
        try
        {
            //optionCount=GetElementCount(dropdownlist);
            ArrayList<String> dropDownValues=new ArrayList<String>();
            //driver.findElement(By.xpath("//span[text()='Select State']")).click();
            Thread.sleep(2000);
            if(optionCount==0)
            {
                throw new Exception("Could not fetch the values");
            }

            else
            {
    			/*for(int i=0;i<=optionCount;i++)
        		{
        			dropDownValues.add(dropdownlist.get(i).getText());
        		}*/

                for(WebElement we:dropdownlist)
                {
                    //String valueText=e1.getText();
                    dropDownValues.add(we.getText());
                    //
                }
                System.out.println("Values selected successfullu");
            }
            return dropDownValues;
        }

        catch (RuntimeException e)
        {
            //throw new Exception("Could not fetch the values");
            //log.error("List is empty" + e.getMessage());
            return null;
        }

    }


	

}


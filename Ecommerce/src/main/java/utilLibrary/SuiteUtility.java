package utilLibrary;



public class SuiteUtility {

    public static boolean checkToRunUtility(ExcelReader xls, String sheetName, String ToRun, String testSuite){

        boolean Flag = false;
        if(xls.retrieveToRunFlag(sheetName,ToRun,testSuite).equalsIgnoreCase("y"))
        {
            Flag = true;
        }
        //if (xls.retrieveToRunFlag(sheetName,ToRun,testSuite).equalsIgnoreCase("N") || (xls.retrieveToRunFlag(sheetName,ToRun,testSuite).equalsIgnoreCase(" ")))
        
        if (xls.retrieveToRunFlag(sheetName,ToRun,testSuite).equalsIgnoreCase("N"))
        
        
        {
            Flag = false;
        }
        return Flag;
    }

	/*public static String[] checkToRunUtilityOfData(ExcelReader xls, String sheetName, String ColName){
		return xls.retrieveToRunFlagTestData(sheetName,ColName);
	}*/

    public static Object[][] GetTestDataUtility1(ExcelReader xls, String sheetName){
        return xls.retrieveTestData(sheetName);
    }

	/*public static Object[][] GetTestDataUtility(ExcelReader xls, String sheetName){
	 	return GenericUtilLib.getTestData(sheetName);
	}*/
	/*public static Object[][] GetTestDataUtility(ExcelReader xls, String sheetName){
	 	return GenericUtilLib.getTestData(sheetName);
	}*/

    public static boolean WriteResultUtility(ExcelReader xls, String sheetName, String ColName, int rowNum, String Result){

        return xls.writeResult(sheetName, ColName, rowNum, Result);
    }


    public static int readRowUtility(ExcelReader xls, String sheetName, String ColName,String tcName){

        int i=0;
        i=xls.getCellRowNum(sheetName, ColName, tcName);
        return i;
    }
    public static boolean WriteResultUtility_Grid(ExcelReader xls, String sheetName, String ColName, int rowNum, String Result,String browserName){
        boolean flag=false;
        if(browserName.equalsIgnoreCase("Firefox"))
        {
            flag=xls.writeResult(sheetName, ColName, rowNum, Result);
        }

        else if(browserName.contains("Chrome"))
        {
            flag=xls.writeResult(sheetName, ColName, rowNum, Result);
        }


        return flag;
    }

    public static boolean WriteResultUtility(ExcelReader xls, String sheetName, String ColName, String rowName, String Result){
        return xls.writeResult(sheetName, ColName, rowName, Result);
    }

}
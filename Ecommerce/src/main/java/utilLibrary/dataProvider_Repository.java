package utilLibrary;

import org.testng.annotations.DataProvider;

import baseSetUp.BaseSetUp;



public class dataProvider_Repository extends BaseSetUp {
    static ExcelReader fileName = null;
    static String SheetName = null;

    //static String filepath="D:\\ONDECK\\src\\main\\java\\ExcelFiles\\ManageProducts\\New_Group_Series_Data.xlsx";
    static String filepath=System.getProperty("user.dir")+"\\src\\main\\java\\ExcelFiles\\ManageProducts\\Data_Product_Group_Series.xlsx";
    static String newProductDataExcelfilepath=System.getProperty("user.dir")+"\\src\\main\\java\\ExcelFiles\\ManageProducts\\New_Product_Details.xlsx";
    static String newResouceDataExcelfilepath=System.getProperty("user.dir")+"\\src\\main\\java\\ExcelFiles\\Resource Libarary\\New_Resource_Details.xlsx";
    static ExcelReader excel1=new ExcelReader(filepath);
    static ExcelReader excel2=new ExcelReader(newProductDataExcelfilepath);

    static ExcelReader newResourceExcel=new ExcelReader(newResouceDataExcelfilepath);



    @DataProvider(name="productGrpSeriesTestData")
    public static Object[][] getTestDataProductGrpSeries(){

        Object[][] arrayObject = getExcelData(filepath,"Data_Add_New_Prod_Group_Series");

        return arrayObject;
    }

    @DataProvider(name="newproductTestData")
    public static Object[][] getTestDataNewProduct(){

        Object[][] arrayObject = getNewProductExcelData(newProductDataExcelfilepath,"Add_New_Product_Details");

        return arrayObject;
    }


    @DataProvider(name="newResourceData")
    public static Object[][] getTestDataNewResource(){

        Object[][] arrayObject = getNewResourceExcelData(newResouceDataExcelfilepath,"New_Resouce_Details");

        return arrayObject;
    }
    public static Object [][] getExcelData(String fileName, String sheetName) {
        int rows=excel1.getRowCount(sheetName);
        int cols=excel1.getColumnCount(sheetName);
        Object data [][]=new Object[rows-1][cols];
        for (int rowNum=1;rowNum<rows;rowNum++)
        {

            for (int colNum=0;colNum<cols;colNum++)
            {
                data [rowNum-1][colNum]=excel1.getCellData(sheetName, colNum, rowNum);
            }
        }
        return data;
    }

    public static Object [][] getNewProductExcelData(String fileName, String sheetName) {
        int rows=excel2.getRowCount(sheetName);
        int cols=excel2.getColumnCount(sheetName);
        Object data [][]=new Object[rows-1][cols];
        for (int rowNum=1;rowNum<rows;rowNum++)
        {

            for (int colNum=0;colNum<cols;colNum++)
            {
                data [rowNum-1][colNum]=excel2.getCellData(sheetName, colNum, rowNum);
            }
        }
        return data;
    }

    public static Object [][] getNewResourceExcelData(String fileName, String sheetName) {
        int rows=newResourceExcel.getRowCount(sheetName);
        int cols=newResourceExcel.getColumnCount(sheetName);
        Object data [][]=new Object[rows-1][cols];
        for (int rowNum=1;rowNum<rows;rowNum++)
        {

            for (int colNum=0;colNum<cols;colNum++)
            {
                data [rowNum-1][colNum]=newResourceExcel.getCellData(sheetName, colNum, rowNum);
            }
        }
        return data;
    }
}


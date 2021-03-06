package TestScript.SPA_Test;

import Pages.SPA_ConsoleActivity.SPA_Menu;
import Pages.ScrunityCell.SC_Menu;
import Pages.ScrunityCell.Scrunity.ConversionPending;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static Utilites.LoginFunction.SC_LogFunction;
import static Utilites.LoginFunction.SPA_LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static jxl.format.Colour.*;
import static jxl.format.Colour.LIGHT_TURQUOISE;

/**
 * Created by akshay.pokley on 9/26/2017.
 */
public class SPAM_Test {

    static WebDriver driver;
    public static WritableCellFormat cellFormat;
    public static WritableCellFormat cellFormat1;
    public static WritableCellFormat cellFormat3;
    public static WritableCellFormat cellFormat4;
    public WritableCellFormat cellFormat2;
    public static WritableCellFormat cellFormat6;
    public static WritableCellFormat cellFormat5;
    public WritableWorkbook writableTempSource;
    public WritableWorkbook copyDocument;
    public WritableSheet sourceSheet;
    public static WritableSheet targetSheet;
    public Workbook sourceDocument;
    public static String WinHandleBefore2;
    public static SPA_Menu spa_menu;
    public static ConversionPending conversionPending;
    private static int n = 2;
    private static int j = 1;
    public static String Result;
    public static String Actual;
    public static String Actual2;
    static int LastRow;
    static int SetBord;
    static final java.util.regex.Pattern String = java.util.regex.Pattern.compile("^[A-Za-z, ]++$");
    static final java.util.regex.Pattern Num = java.util.regex.Pattern.compile("^[0-9]++$");
    static final java.util.regex.Pattern Emailval = java.util.regex.Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    static final java.util.regex.Pattern Alphnu = java.util.regex.Pattern.compile("^[A-Za-z,0-9  ]++$");

    @BeforeTest
    public void OutputExcelCreation() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("ExcelData/InputData/TestCaseDemo.xls"));
        writableTempSource = Workbook.createWorkbook(new File("ExcelData/InputData/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("ExcelData/TestReport/ScrunityCellTestReport.xls"));
        sourceSheet = writableTempSource.getSheet(12);
        targetSheet = copyDocument.createSheet("sheet 1", 2);

        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 11);
        cellFont.setBoldStyle(WritableFont.BOLD);
/************************************************************************************************/
        WritableFont cellFont2 = new WritableFont(WritableFont.COURIER, 10);
        cellFont2.setColour(BLACK);
        //cellFont2.setBoldStyle(WritableFont.BOLD);
        cellFormat1 = new WritableCellFormat(cellFont2);
        cellFormat1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat1.setWrap(true);
/*******************************************************************************************************/
/************************************************************************************************/
        WritableFont cellFont3 = new WritableFont(WritableFont.COURIER, 10);
        cellFont3.setColour(RED);
        // cellFont3.setBoldStyle(WritableFont.BOLD);
        cellFormat3 = new WritableCellFormat(cellFont3);
        cellFormat3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat3.setWrap(true);

        WritableFont cellFont4 = new WritableFont(WritableFont.COURIER, 10);
        cellFont4.setColour(GREEN);
        // cellFont4.setBoldStyle(WritableFont.BOLD);
        cellFormat4 = new WritableCellFormat(cellFont4);
        cellFormat4.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat4.setWrap(true);


        cellFormat = new WritableCellFormat(cellFont);
        cellFormat.setBackground(LIGHT_BLUE);
        cellFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat.setWrap(true);
        cellFormat2 = new WritableCellFormat(cellFont);
        cellFormat2.setBackground(RED);
        //cellFormat.setAlignment(jxl.format.Alignment.getAlignment(20));
        WritableFont cellFont5 = new WritableFont(WritableFont.COURIER, 18);
        cellFont5.setColour(BLACK);
        cellFont5.setBoldStyle(WritableFont.BOLD);
        cellFormat5 = new WritableCellFormat(cellFont5);
        cellFormat5.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat5.setBackground(LIGHT_BLUE);
        cellFormat5.setAlignment(Alignment.CENTRE);


        cellFormat6 = new WritableCellFormat(cellFont2);
        cellFormat6.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
        cellFormat6.setWrap(true);
        cellFormat6.setBackground(LIGHT_TURQUOISE);
        //  sheet.addCell(new Label(col, 1, "CCCCC", cellFormat));

        for (int row = 0; row < sourceSheet.getRows(); row++) {
            for (int col = 0; col < sourceSheet.getColumns(); col++) {
                WritableCell readCell = sourceSheet.getWritableCell(col, row);
                WritableCell newCell = readCell.copyTo(col, row);
                CellFormat readFormat = readCell.getCellFormat();

                WritableCellFormat newFormat = new WritableCellFormat(readFormat);
                newCell.setCellFormat(newFormat);
                targetSheet.addCell(newCell);


                Label l2 = new Label(5, 1, "Actual", cellFormat);

                Label l3 = new Label(6, 1, "Status", cellFormat);
                //Label l4=new Label(4,row,"",cellFormat);
                int widthInChars = 36;
                int widthInChars2 = 18;
                int widthInChars1 = 16;
                targetSheet.setColumnView(2, widthInChars1);
                targetSheet.setColumnView(3, widthInChars1);
                targetSheet.setColumnView(1, widthInChars1);
                targetSheet.setColumnView(4, widthInChars);
                targetSheet.setColumnView(5, widthInChars);

/*-----------------------------------------------------------------------------------------------------------------------*/
                targetSheet.setColumnView(0, widthInChars2);
                targetSheet.setColumnView(2, widthInChars2);

                targetSheet.setColumnView(3, widthInChars2);
                targetSheet.mergeCells(0, 0, 6, 0);
                Label lable = new Label(0, 0,
                        "Forgot Password screen test  report", cellFormat5);
                targetSheet.addCell(lable);
                targetSheet.addCell(l2);
                targetSheet.addCell(l3);
                //targetSheet.addCell(l4);

            }
        }

    }

    @AfterTest
    public void f() throws IOException, WriteException {

        copyDocument.write();
        copyDocument.close();
        writableTempSource.close();
        sourceDocument.close();

    }

    @Test(dataProvider = "hybridData")
    public static void SPA_MTest(String testcaseName, String keyword, String objectName, String value, String Expected) throws Exception {

        if (testcaseName != null && testcaseName.length() != 0) {

            driver = openBrowser("chrome");
            GetUrl("url");
            SPA_LogFunction(driver);
            spa_menu=new SPA_Menu(driver);
            //spa_menu.setDashboardTab();
            spa_menu.setDashboard();
            spa_menu.setSubmissionTab();
            spa_menu.setSubmittedApllication();
            spa_menu.setApplicationTab();
            spa_menu.setRejectedFile();
            spa_menu.setTotal_Files();
            spa_menu.setApproval_Pending();
            spa_menu.setApproved_Files();
            spa_menu.setScrunityTab();
            Thread.sleep(3000);
            spa_menu.setScrunityVerify_Pending();
            spa_menu.setScrunityVerify_Done();
            spa_menu.setDrawingFailin_rules();
            driver.switchTo().frame("ifrmListing");
            driver.close();

            SetBord = j++;
            Label l7 = new Label(5, SetBord, "", cellFormat6);
            targetSheet.addCell(l7);
            Label l8 = new Label(6, SetBord, "", cellFormat6);
            targetSheet.addCell(l8);
        } else {
            SetBord = j++;
        }

        try {
          /*  Thread.sleep(400);
            NewWindow(driver);*/
            switch (keyword.toUpperCase()) {

                case "CLICK":
                    String FilePath = "E:\\Akshay85\\select.pdf";
                   // WinHandleBefore2 = driver.getWindowHandle();
                    switch (objectName) {

                        case "savea&submit":
                            try {
                                /*pending_processing_fees.setSave_Submit();
                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    System.out.println("alert was not present");

                                } else {
                                    Alert alert = driver.switchTo().alert();
                                    Actual = driver.switchTo().alert().getText();
                                    if (Actual.equals(Expected)) {
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                    }
                                    System.out.println(Actual);
                                    //    Thread.sleep(50);
                                    alert.accept();

                                }*/
                            }catch (Throwable k)
                            {
                                System.out.println(k.getMessage());
                            }
                            break;

                        case "Pay Now":
                            try{


                            }catch (Throwable e){
                                System.out.println(e.getMessage());

                            }
                            break;
                        case "Submit":
                            Actual2 = "Alert message should be display.";
                            // if (driver.findElement(By.xpath("./*//*[@id='lblULBName']")).getText().equals("Delhi Development Authority")) {
                            try {
                              /*  if ((ExpectedConditions.alertIsPresent()) == null) {
                                    System.out.println("alert was not present");
                                    if (Actual2.equals(Expected)) {
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                    }
                                } else {
                                    Alert alert = driver.switchTo().alert();
                                    Actual = driver.switchTo().alert().getText();
                                    if (Actual.equals(Expected) || Actual2.equals(Expected)) {
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                    }
                                    System.out.println(Actual);
                                    //    Thread.sleep(50);
                                    alert.accept();

                                }*/

                            } catch (Throwable e) {
                            }
                            break;
                        default:
                            System.out.println("default");
                            break;
                    }

                case "SETTEXT":

                    switch (objectName) {

                        case "Branch_Name":
                        case "Payment Mode_RTGS":
                        case "UTR_No":
                        case "Bank_Name":


                    }
                    break;
                default:
                    break;
            }


            if (testcaseName.isEmpty()) {
                LastRow = n++;
                if (Result.equals("pass")) {
                    Label l5 = new Label(5, LastRow, "As Exptected", cellFormat1);
                    targetSheet.addCell(l5);
                    Label l6 = new Label(6, LastRow, "PASS", cellFormat4);
                    targetSheet.addCell(l6);
                } else {

                    Label l5 = new Label(5, LastRow, Actual, cellFormat1);
                    targetSheet.addCell(l5);
                    Label l6 = new Label(6, LastRow, "FAIL", cellFormat3);
                    targetSheet.addCell(l6);
                }
            } else {
                LastRow = n++;

            }
        } catch (NullPointerException e) {
        }

    }


    @DataProvider(name = "hybridData")
    public Object[][] getDataFromDataprovider() throws IOException {
        Object[][] object = null;
        FileInputStream fis = new FileInputStream("ExcelData/InputData/TestCaseDemo.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheet("PayChallan");
        //  HSSFRow rows = sh.getRow(1);
//Read keyword sheet
//Find number of rows in Expl.excel file
        int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
        System.out.println(rowCount);
        object = new Object[rowCount][5];
        for (int i = 1; i < rowCount; i++) {

            HSSFRow row = sh.getRow(i + 1);


            for (int j = 0; j < row.getLastCellNum(); j++) {
//                System.out.println(row.getCell(j).toString());
                object[i][j] = row.getCell(j).toString();

            }


        }
        return object;
    }




}

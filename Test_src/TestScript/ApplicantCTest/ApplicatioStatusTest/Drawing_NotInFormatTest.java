package TestScript.ApplicantCTest.ApplicatioStatusTest;

import Pages.Applicant_Console.ApplicantMenu;
import Pages.Applicant_Console.ApplicationStatus.Drawing_NotInFormat;
import Pages.Applicant_Console.Application_Submission.Application;
import Pages.Applicant_Console.Payments.Pending_Processing_Fees;

import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static Utilites.AttachFunction.AttachFuntn;
import static Utilites.BeforeWH.BeforeWH;
import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static jxl.format.Colour.*;
import static jxl.format.Colour.LIGHT_TURQUOISE;

/**
 * Created by akshay.pokley on 9/19/2017.
 */
public class Drawing_NotInFormatTest {

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
    /*****************************************************************/
    public static Application application;
    public static ApplicantMenu applicantMenu;
    public static Drawing_NotInFormat drawing_notInFormat;
    public static Pending_Processing_Fees pending_processing_fees;
    private static int n = 2;
    private static int j = 1;
    public static String Result;
    public static String Actual;
    public static String Actual2;
    static int LastRow;
    static int SetBord;



    @BeforeTest
    public void OutputExcelCreation() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("ExcelData/InputData/TestCaseDemo.xls"));
        writableTempSource = Workbook.createWorkbook(new File("ExcelData/InputData/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("ExcelData/TestReport/ScrunityReports/ScrunityCellTestReport.xls"));
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
    public static void DrawingNotInFoTest(String testcaseName, String keyword, String objectName, String value, String Expected) throws Exception {

        if (testcaseName != null && testcaseName.length() != 0) {

            driver = openBrowser("chrome");
            GetUrl("url");
            LogFunction(driver);
            Thread.sleep(200);

            applicantMenu = new ApplicantMenu(driver);
            applicantMenu.setApplicationStatus();
            Thread.sleep(30000);
            applicantMenu.setDrawing_NotInformat();
            drawing_notInFormat=new Drawing_NotInFormat(driver);
            driver.switchTo().frame("ifrmListing");

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
                    String FilePath2 = "E:\\Akshay85\\8.1\\IMP\\13_7\\New folder (3)\\g.dwg";
                    String WinHandleBefore1 = driver.getWindowHandle();
                    WinHandleBefore2 = driver.getWindowHandle();
                    switch (objectName) {

                        case "savea&submit":
                            try {
                                pending_processing_fees.setSave_Submit();
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

                                }
                            }catch (Throwable k)
                            {
                                System.out.println(k.getMessage());
                            }
                            break;
                        case "File Name":

                            driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
                            try {
                                if (driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[6]/td/div/table/tbody/tr/td[3]/div/b")).getText().equals("0")) {
                                    driver.manage().timeouts().implicitlyWait(26, TimeUnit.SECONDS);

                                    WebElement d = driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[3]/td/div/table/tbody/tr/td/div"));
                                    String s = d.getText();
                                    if (s.equals(Expected)&s.equals("Proposal not found")) {
                                        Result = "pass";
                                    } else {
                                        Result = "fail";
                                        Actual = s;
                                    }
                                } else {
                                    driver.manage().timeouts().implicitlyWait(78, TimeUnit.SECONDS);
                                    List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr/td[3]"));

                                    for (WebElement cell : cells) {
                                        String fiels = cell.getText();
                                        System.out.println(fiels);

                                        if (fiels.equals(value)) {
                                            cell.click();
                                            Result = "pass";
                                            break;

                                        } else {
                                            Result = "fails";
                                            Actual = "File not Found";
                                        }
                                    }

                                }

                            } catch (Throwable e) {
                                System.out.println(e.getMessage());
                            }

                            break;

                        case "Attach New Drawing":
                            try
                            {

                                String St = drawing_notInFormat.getDrawing_Data().getText();
                                if (St.equals("No data found")) {
                                    drawing_notInFormat.setselectFile();
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        //  Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                    }
                                    Thread.sleep(300);
                                    BeforeWH(driver);

                                    WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                    ss.click();
                                    Thread.sleep(6000);
                                    AttachFuntn(driver, FilePath2);
                                    Thread.sleep(700);
                                    driver.switchTo().window(WinHandleBefore1);
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        //  Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        driver.switchTo().parentFrame();
                                    }

                                } else {
                                    driver.findElement(By.id("btnAttached")).click();
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        //  Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        driver.switchTo().parentFrame();
                                       // driver.switchTo().frame("ifrmListing");
                                    }
                                }


                            }
                            catch (Throwable t)
                            {

                            }
                            break;
                        case "Filter":
                            try
                            {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='form1']/div[3]/div/div/div[5]/div/div/div/div/div[2]/table/tbody/tr/td/div/button"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value)) {
                                        cell.click();
                                        Result="pass";
                                        break;
                                    }
                                }
                            }
                            catch (Throwable t)
                            {

                            }


                            break;
                        case "Submit":
                            drawing_notInFormat.setSubmit();
                            break;
                        default:
                            System.out.println("default");
                            break;
                    }
                    break;
                case "GET_STATUS":

                    switch (objectName) {

                        case "Proposal Status":
                            System.out.println( drawing_notInFormat.getProposalStatus().getText());

                         if(drawing_notInFormat.getProposalStatus().getText().equals(value))
                         {
                             driver.switchTo().frame("ifrmToolbar");

                        drawing_notInFormat.setResubmit();
                                 if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                     Alert alert = driver.switchTo().alert();
                                     alert.accept();
                                 }
                                    driver.switchTo().frame("ifrmListing");

                                    driver.switchTo().frame("ifrmAttachment");
                                    Result="pass";

                                    }else {
                                    Result="fail";
                                }}break;

                case "SETTEXT":

                    switch (objectName) {

                        case "Remarks detials":
                            driver.switchTo().frame("ifrmListing");
                            drawing_notInFormat.setRemarks(value);
                            Result="pass";

                            break;

                        case "Enter Keyword for search":
                            Thread.sleep(3000);
                             Actions actions = new Actions(driver);
                            actions.moveToElement(drawing_notInFormat.getSeachWithKeyword());
                            actions.click();
                            actions.click();
                            actions.sendKeys(value);
                            actions.build().perform();
                            Result="pass";

                            break;
                        case "Bank_Name":
                            Thread.sleep(344);
                           // pending_processing_fees.setBank_Name(value);Result = "pass";


                    }
                    break;
                default:
                    System.out.println("j");
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
        HSSFSheet sh = wb.getSheet("ScrunityCell");
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

package TestScript.ScrunityCellTest.ApplicationStatusTest;

import Pages.ScrunityCell.ApplicationStatus.DrawingNotInformat;
import Pages.ScrunityCell.SC_Menu;
import Pages.ScrunityCell.Scrunity.ScrunityPending;
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

import static Utilites.BeforeWH.BeforeWH;
import static Utilites.LoginFunction.SC_LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static jxl.format.Colour.*;
import static jxl.format.Colour.LIGHT_TURQUOISE;

/**
 * Created by akshay.pokley on 9/25/2017.
 */
public class DrawingNotInformatTest {
    static WebDriver driver;
    public Label l4;
    public static WritableCellFormat cellFormat;
    public static WritableCellFormat cellFormat1;
    public static WritableCellFormat cellFormat3;
    public static WritableCellFormat cellFormat4;
    public WritableCellFormat cellFormat2; public static WritableCellFormat cellFormat6;
    public static WritableCellFormat cellFormat5;
    public  String TestCase;
    public WritableWorkbook writableTempSource;
    public WritableWorkbook copyDocument;
    public WritableSheet sourceSheet;
    public static WritableSheet targetSheet;
    public Workbook sourceDocument;
    public static DrawingNotInformat drawingNotInformat;
    public static SC_Menu sc_menu;
    public static String WinHandleBefore1;
    public static String WinHandleBefore2;
    /*****************************************************************/
    private static int n = 2;
    private static int j = 1;
    public static  String Result;
    public static  String k;
    public static String ResultPass1="Username";
    public static String ResultFail1="Password";
    public static String Actual;
    public static String Actual2;
    static int LastRow;
    static int SetBord;
    static int RowIncr;
    static final java.util.regex.Pattern String = java.util.regex.Pattern.compile("^[A-Za-z, ]++$");
    static final java.util.regex.Pattern Num = java.util.regex.Pattern.compile("^[0-9]++$");
    static final java.util.regex.Pattern Emailval = java.util.regex.Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    static final java.util.regex.Pattern Alphnu = java.util.regex.Pattern.compile("^[A-Za-z,0-9  ]++$");

    @BeforeTest
    public  void OutputExcelCreation() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("ExcelData/InputData/TestCaseDemo.xls"));
        writableTempSource = Workbook.createWorkbook(new File("ExcelData/InputData/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("ExcelData/TestReport/ScrunityReports/DrawingNotIn_formatTestReport.xls"));
        sourceSheet = writableTempSource.getSheet(13);
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


                Label l2=new Label(5,1,"Actual",cellFormat);

                Label l3=new Label(6,1,"Status",cellFormat);
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
                Label lable = new Label (0, 0,
                        "Drawing Not In format screen test  report",cellFormat5);
                targetSheet.addCell(lable);
                targetSheet.addCell(l2);
                targetSheet.addCell(l3);
                //targetSheet.addCell(l4);

            }
        }

    }
    @AfterTest
    public void f() throws IOException, WriteException
    {

        copyDocument.write();
        copyDocument.close();
        writableTempSource.close();
        sourceDocument.close();

    }
    @Test(dataProvider="hybridData")
    public static void DNF_Test(String testcaseName,String keyword,String objectName,String value,String Expected) throws Exception {

        if (testcaseName != null && testcaseName.length() != 0 ) {

            driver = openBrowser("chrome");
            GetUrl("url");
            SC_LogFunction(driver);
            sc_menu=new SC_Menu(driver);

            //sc_menu.setApplicationTab();
            Thread.sleep(150);
            sc_menu.setDrawing_Not_In_Format();
            drawingNotInformat =new DrawingNotInformat(driver);

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
                    WinHandleBefore2 = driver.getWindowHandle();
                    switch (objectName) {

                        case "File Name":

                            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                            try {
                                if (driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[6]/td/div/table/tbody/tr/td[3]/div/b")).getText().equals("0")) {
                                    driver.manage().timeouts().implicitlyWait(26, TimeUnit.SECONDS);

                                    WebElement d = driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[3]/td/div/table/tbody/tr/td/div"));
                                    String s = d.getText();
                                    if (s.equals(Expected)) {
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
                                System.out.println(t.getMessage());
                            }


                            break;
                        case "Submit1":
                            Actual2 = "Alert message should be display.";
                            // if (driver.findElement(By.xpath("./*//*[@id='lblULBName']")).getText().equals("Delhi Development Authority")) {
                            try {
                                if ((ExpectedConditions.alertIsPresent()) == null) {
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

                                }

                            } catch (Throwable e) {
                            }

                    }
                    break;
                case "SETTEXT":

                    switch (objectName) {



                        case "Enter Keyword for search":
                            Thread.sleep(30000);
                            Actions actions = new Actions(driver);
                            actions.moveToElement(drawingNotInformat.getSeachWithKeyword());
                            actions.click();
                            actions.click();
                            actions.sendKeys(value);
                            actions.build().perform();
                            Result="pass";

                            break;
                        case "Get Proposal Status":

                            try {
                                Thread.sleep(25);
                                if(drawingNotInformat.getProposalStatus().getText().equals(value))
                                {
                                    //driver.switchTo().frame("ifrmToolbar");
                                    Result="pass";
                                    driver.close();
                                }else {
                                    Actual=drawingNotInformat.getProposalStatus().getText();
                                    Result="fail";
                                    driver.close();
                                }


                            }catch (Throwable e)
                            {
                                System.out.println(e.getMessage());
                                driver.close();
                            }
                            break;

                        case "Select Architct":
                            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                            Thread.sleep(2000);
                            sc_menu.setSelect_ArchitectName(value);
                            sc_menu.ClickSeachBtn();
                            Thread.sleep(200);
                            Result = "pass";

                            break;
                        case "Mobile No":


                    }    break;
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
        }catch (NullPointerException e)
        {}

    }


    @DataProvider(name="hybridData")
    public Object[][] getDataFromDataprovider() throws IOException {
        Object[][] object = null;
        FileInputStream fis = new FileInputStream("ExcelData/InputData/TestCaseDemo.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheet("DNIF");
        //  HSSFRow rows = sh.getRow(1);
//Read keyword sheet
//Find number of rows in Expl.excel file
        int rowCount =sh.getLastRowNum()-sh.getFirstRowNum();
        System.out.println(rowCount);
        object = new Object[rowCount][5];
        for (int i = 1; i < rowCount; i++) {

            HSSFRow row = sh.getRow(i+1);


            for (int j = 0; j < row.getLastCellNum(); j++) {
//                System.out.println(row.getCell(j).toString());
                object[i][j] = row.getCell(j).toString();

            }


        }
        return object;
    }





}

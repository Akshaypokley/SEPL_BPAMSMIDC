package TestScript.Fire_consoleATest;

import Pages.Fire_ConsoleActivity.Higherauthoriotyflows;
import Pages.ForgotPasswordConsole;
import Pages.LoginConsole;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Utilites.LoginFunction.DFO_LogFunction;
import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static Utilites.Windowhander.NewWindow;
import static jxl.format.Colour.*;
import static jxl.format.Colour.LIGHT_TURQUOISE;

public class HafflowTest {

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
    static int ToolbarCount=0;
    static final java.util.regex.Pattern String = java.util.regex.Pattern.compile("^[A-Za-z, ]++$");
    static final java.util.regex.Pattern Num = java.util.regex.Pattern.compile("^[0-9]++$");
    static final java.util.regex.Pattern Emailval = java.util.regex.Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    static final java.util.regex.Pattern Alphnu = java.util.regex.Pattern.compile("^[A-Za-z,0-9  ]++$");

    @BeforeTest
    public  void OutputExcelCreation() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("ExcelData/InputData/Demo.xls"));
        writableTempSource = Workbook.createWorkbook(new File("ExcelData/InputData/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("ExcelData/TestReport/FireFlow.xls"));
        sourceSheet = writableTempSource.getSheet(0);
        targetSheet = copyDocument.createSheet("sheet 1", 0);

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
                        "Forgot Password screen test  report",cellFormat5);
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
    public static void FireDepartmetTest(String testcaseName,String keyword,String objectName,String value,String Expected) throws Exception {

        if (testcaseName != null && testcaseName.length() != 0 ) {

            driver = openBrowser("chrome");
            GetUrl("url");
            Thread.sleep(200);
            NewWindow(driver);
            SetBord = j++;
            Label l7 = new Label(5, SetBord, "", cellFormat6);
            targetSheet.addCell(l7);
            Label l8 = new Label(6, SetBord, "", cellFormat6);
            targetSheet.addCell(l8);
        } else {
            SetBord = j++;
        }

        try {
            switch (keyword.toUpperCase()) {

                case "LOGIN":

                    switch (objectName) {

                        case "Architect":
                            LogFunction(driver);
                            break;
                        case"Deputy Chief officer":
                            DFO_LogFunction(driver);
                    }break;
                case "STATUS BAR":

                    switch (objectName) {
                        case "Get Opertional Bar Details ":

                          //  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                            try {
                                driver.switchTo().frame("ifrmToolbar");
                                List<WebElement> d = driver.findElements(By.xpath(".//*[@id='seTbGeneral']/tbody/tr/td/a"));
                                for (WebElement cell : d) {
                                    String fiels = cell.getText();
                                    //   System.out.println("Tool bar Componets are " + fiels);

                                    if (fiels.equals(value)) {
                                        cell.click();
                                   if(fiels.equals(" Print NoteSheet")||fiels.equals(" View Fire NOC")){
                                       NewWindow(driver);
                                       Thread.sleep(2000);
                                       java.awt.Robot robot = new java.awt.Robot();
                                       Thread.sleep(1000);
                                       robot.keyPress(KeyEvent.VK_CONTROL);
                                       robot.keyPress(KeyEvent.VK_S);
                                       robot.keyRelease(KeyEvent.VK_S);
                                       robot.keyRelease(KeyEvent.VK_CONTROL);
                                       Thread.sleep(2000);
                                       robot.keyPress(KeyEvent.VK_ENTER);
                                       Thread.sleep(2000);
                                       robot.keyPress(KeyEvent.VK_TAB);   // file replace move to yes button
                                       Thread.sleep(2000);
                                       robot.keyPress(KeyEvent.VK_ENTER); // hit enter
                                   }else {

                                       if(fiels.equals(" Back"))
                                       {

                                       }else {
                                           if(fiels.equals("  Notesheet"))
                                           {

                                           }
                                       }

                                   }
                                        Result = "pass";
                                        break;
                                    }else {
                                        List<WebElement> d1 = driver.findElements(By.xpath(".//*[@id='SetbReports']/tbody/tr/td[2]/a"));
                                        for (WebElement cell1 : d1) {
                                            String fiels1 = cell1.getText();
                                                     System.out.println("Tool bar Componets are:->"+fiels1);
                                            if (fiels1.equals(value)) {
                                                cell1.click();
                                                System.out.println("Tool bar Componets are "+fiels1);

                                                Result = "pass";
                                                break;
                                            }else {
                                                System.out.println("Componets are not available ");
                                            }
                                        }
                                    }

                                }



                            } catch (Throwable e) {

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    System.out.println("alert was not present");
                                } else {
                                    Alert alert = driver.switchTo().alert();
                                    Actual = driver.switchTo().alert().getText();
                                    alert.accept();
                                }
                                System.out.println(e.getMessage());
                            }
                    }break;



                case "LEFT_MENU":

                    switch (objectName) {

                        case "LeftMenuTab":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*/div/nav/ul/li/a/div/div[2]/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);
                                    int k=1;
                                    if (fiels.equals(value))
                                        if (k != 1)
                                        {cell.click();
                                        }
                                    System.out.println("Value Name is :-***"+value+"***");
                                    Result = "pass";           ++k;
                                    break;
                                }
                            } catch (Throwable e) {

                            }
                            break;

                        case "LeftMenu_SubTab":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*/div/nav/ul/li/ul/li/a/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();

                                    if (fiels.equals(value)) {
                                        cell.click();
                                        driver.switchTo().frame("ifrmListing");
                                        System.out.println("Value Name is :-***" + value + "***");
                                        Result = "pass";

                                        System.out.println("The value of K:-" + k);
                                        break;
                                    }else { driver.switchTo().frame("ifrmListing");}

                                }
                            } catch (Throwable e) {

                                System.out.println(e.getMessage());
                            }
                    }break;


                case "CLICK":
                    String FilePath = "E:\\Akshay85\\select.pdf";
                    WinHandleBefore2 = driver.getWindowHandle();
                    switch (objectName) {

                        case "File Name":
                            try {


                                if (driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[6]/td/div/table/tbody/tr/td[3]/div/b")).getText().equals("0")) {
                                    Thread.sleep(80);
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
                            }break;
                case "SETTEXT":

                    switch (objectName) {

                    }
                            break;
                        case "Mobile No":

                            break;
                        case "Email":

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
        }catch (NullPointerException e)
        {}

    }


    @DataProvider(name="hybridData")
    public Object[][] getDataFromDataprovider() throws IOException {
        Object[][] object = null;
        FileInputStream fis = new FileInputStream("ExcelData/InputData/Demo.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheet("FireFlow");
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

package TestScript.ApplicantConsoleTest;

import Pages.Applicant_Console.ApplicantMenu;
import Pages.Applicant_Console.Application_Submission.Application;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static TestScript.ForgotCTest.WinHandleBefore1;
import static Utilites.AttachFunction.AttachFuntn;
import static Utilites.BeforeWH.BeforeWH;
import static Utilites.DateFunction_pro.DateFunpro;
import static Utilites.LoginFunction.DFO_LogFunction;
import static Utilites.LoginFunction.LogFunction;
import static Utilites.LoginFunction.MIDCPA_LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static Utilites.ReconDate.RecDateFun;
import static Utilites.Windowhander.NewWindow;
import static jxl.format.Colour.*;
import static jxl.format.Colour.LIGHT_TURQUOISE;

/**
 * Created by akshay.pokley on 2/27/2018.
 */
public class ACT_TestNG {

    static WebDriver driver;
    public Label l4;
    public static WritableCellFormat cellFormat;
    public static WritableCellFormat cellFormat1;
    public static WritableCellFormat cellFormat3;
    public static WritableCellFormat cellFormat4;
    public WritableCellFormat cellFormat2;
    public static WritableCellFormat cellFormat6;
    public static WritableCellFormat cellFormat5;
    public String TestCase;
    public WritableWorkbook writableTempSource;
    public WritableWorkbook copyDocument;
    public WritableSheet sourceSheet;
    public static WritableSheet targetSheet;
    public Workbook sourceDocument;
    /*****************************************************************/
    private static int n = 2;
    private static int j = 1;
    public static String Result;
    public static String k;
    public static String ResultPass1 = "Username";
    public static String ResultFail1 = "Password";
    public static String Actual;
    public static String Actual2;
    static int LastRow;
    static int SetBord;
    static int RowIncr;
    static final java.util.regex.Pattern String = java.util.regex.Pattern.compile("^[A-Za-z, ]++$");
    static final java.util.regex.Pattern Num = java.util.regex.Pattern.compile("^[0-9]++$");
    static final java.util.regex.Pattern Emailval = java.util.regex.Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    static final java.util.regex.Pattern Alphnu = java.util.regex.Pattern.compile("^[A-Za-z,0-9  ]++$");
    static final java.util.regex.Pattern Flot = java.util.regex.Pattern.compile("^[+-]?([0-9]*[.])?[0-9]++$");
    public static Application application;
    public static ApplicantMenu applicantMenu;
    public static String subWindowHandler = null;
    public static String Actvalue;
    public static int x = 3;
    public static int u;
    public static int vb = 2;
    public static int k1;
    public static int rr = 1;
    public static int Rec = 2;

    @BeforeMethod
    public void OutputExcelCreation() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("ExcelData/InputData/ApplicantTestData.xls"));
        writableTempSource = Workbook.createWorkbook(new File("ExcelData/InputData/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("ExcelData/TestReport/ApplicantTestReport.xls"));
        sourceSheet = writableTempSource.getSheet(0);
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
                        "Applicant screen test Result", cellFormat5);
                targetSheet.addCell(lable);
                targetSheet.addCell(l2);
                targetSheet.addCell(l3);
                //targetSheet.addCell(l4);

            }
        }

    }

     @AfterMethod
    public void f() throws IOException, WriteException {

        copyDocument.write();
        copyDocument.close();
        writableTempSource.close();
        sourceDocument.close();

    }

    @Test(dataProvider = "hybridData0", priority = 1)
    public static void ApplicationTest0(String testcaseName, String keyword, String objectName, String value, String Expected) throws Exception {

        if (testcaseName != null && testcaseName.length() != 0) {

            driver = openBrowser("chrome");
            GetUrl("url");
            Thread.sleep(200);
            SetBord = j++;
            Label l7 = new Label(5, SetBord, "", cellFormat6);
            targetSheet.addCell(l7);
            Label l8 = new Label(6, SetBord, "", cellFormat6);
            targetSheet.addCell(l8);
            k1 = 1;
        } else {
            SetBord = j++;

        }

        try {
            switch (keyword.toUpperCase()) {

                case "BROWSER CLOSED":
                    switch (objectName) {
                        case "Closed":
                            Thread.sleep(1000);
                            driver.quit();
                            Thread.sleep(1000);
                            Result = "pass";
                    }

                    break;
                case "FRAME":

                    switch (objectName) {
                        case "Parent Frame":
                            try {

                                driver.switchTo().parentFrame();
                                // driver.switchTo().parentFrame();

                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }

                            break;


                        case "Main Frame":
                            try {

                                application = new Application(driver);
                                applicantMenu = new ApplicantMenu(driver);
                                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmListing");

                                Result = "pass";

                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                    }
                    break;
                case "RECONCILIIATION":

                    switch (objectName) {


                        case "Save Reconciliation Status":
                            try {
                                driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
                                Thread.sleep(2315);
                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    System.out.println("alert was not present");
                                } else {
                                    Alert alert = driver.switchTo().alert();
                                    Actual = driver.switchTo().alert().getText();
                                    alert.accept();

                                    Thread.sleep(6000);

                                    Alert alert3 = driver.switchTo().alert();
                                    Actual = driver.switchTo().alert().getText();
                                    alert3.accept();
                                }

                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }


                            break;

                        case "Change Reconciliation Status":
                            Thread.sleep(1000);
                            //  driver.switchTo().frame("ifrmListing");
                            try {
                                WebElement Reco = driver.findElement(By.xpath(".//*//tr[6]/td/div/table/tbody/tr/td[5]/div/b"));
                                String total_payments = Reco.getText();
                                if (total_payments.equals("0")) {
                                    Result = "pass";
                                    Actual = "Payment are pending";
                                } else {

                                    List<WebElement> Rs = driver.findElements(By.xpath(".//*[@id='ListPaymentReconsileGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr/td[15]"));
                                    for (WebElement re : Rs) {
                                        String req = re.getText();
                                        if (req.equals("Reconciled")) {/*
                                            Actual="File already consiloid ";
                                            System.out.println(Actual);
                                            Result="pass"
                                       */
                                            ++Rec;
                                        } else {

                                            Thread.sleep(1000);
                                            RecDateFun(driver, "13/02/2018", Rec);
                                            Thread.sleep(1000);
                                            Actions actions = new Actions(driver);
                                            actions.moveToElement(re);
                                            Thread.sleep(200);
                                            actions.click();
                                            actions.build().perform();
                                            driver.manage().timeouts().implicitlyWait(23, TimeUnit.SECONDS);
                                            actions.moveToElement(driver.findElement(By.xpath(".//*[@id='TGMenu-0-1']/div/div")));
                                            actions.click();
                                            actions.build().perform();
                                            ++Rec;

                                        }
                                    }



                              /*      Actions actions = new Actions(driver);
                                    actions.moveToElement(driver.findElement(By.xpath("./*//*[@id='ListPaymentReconsileGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[12]")));
                                    Thread.sleep(200);
                                    actions.click();
                                    actions.build().perform();
                                    driver.manage().timeouts().implicitlyWait(23,TimeUnit.SECONDS);*/
                                    //   List<WebElement> paynow = driver.findElements(By.xpath(".//*[@id='TreeGridControls']/div/div/div[7]/div/div/div/div/div/div"));
                             /*       actions.moveToElement(driver.findElement(By.xpath("./*//*[@id='TreeGridControls']/div/div/div[7]/div/div//div[2]")));
                                    actions.click(); actions.build().perform();*/
                                   /* for (WebElement paynow1 : paynow) {
                                        String fiels23 = paynow1.getText();
                                        System.out.println(fiels23);
                                        if (fiels23.equals(value)) {
                                            paynow1.click();
                                            break;
                                        } ++Rec;
                                    }
*/
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";


                            }

                    }
                    break;

                case "PAY":

                    switch (objectName) {

                        case "Pending Demand Note":


                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*/tr[2]/td[2]/div/div[1]/table/tbody//td[2]"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);
                                    if (fiels.equals(value)) {

                                        List<WebElement> paynow = driver.findElements(By.xpath(".//*//tr[2]/td[2]/div/div[1]/table/tbody/tr[" + vb + "]/td[6]"));

                                        for (WebElement d : paynow) {

                                            d.click();
                                            BeforeWH(driver);

                                            WebElement dee = driver.findElement(By.xpath(".//*//tbody/tr[8]/td[2]/table/tbody/tr/td[1]"));
                                            String dddd = dee.getText();
                                            System.out.println(dddd);

                                        }


                                    }
                                    ++vb;
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";

                            }

                    }
                    break;

                case "LEFT_MENU":

                    switch (objectName) {
                        case "LeftMenuTab":

                            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*/div/nav/ul/li/a/div/div[2]/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);
                                    if (fiels.equals(value)) {
                                        System.out.println(fiels);
                                        if (k1 != 1) {
                                            cell.click();
                                            System.out.println("Value Name is :-***" + value + "***");
                                            Result = "pass";
                                            break;
                                        }
                                    } else {
                                        Result = "fail";
                                        Actual = "Tab not present.";
                                    }
                                    ++k1;

                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";

                            }
                            break;

                        case "LeftMenu_SubTab":
                            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*/div/nav/ul/li/ul/li/a/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    if (fiels.equals(value)) {
                                        cell.click();
                                        System.out.println("Value Name is :-***" + value + "***");

                                        System.out.println("The value of K:-" + k);
                                        Result = "pass";
                                        break;
                                    }

                                }
                            } catch (Throwable e) {

                                Actual = e.getMessage();
                                Result = "fails";

                            }
                    }
                    break;

                case "LOGIN":

                    switch (objectName) {

                        case "Architect":
                            LogFunction(driver);
                            Result = "pass";
                            break;
                        case "Payment":
                            MIDCPA_LogFunction(driver);
                            Result = "pass";
                            break;
                        case "Deputy Chief officer":
                            DFO_LogFunction(driver);
                            Result = "pass";
                    }
                    break;


                case "STATUS BAR":

                    switch (objectName) {
                        case "Get Opertional Bar Details":
                            driver.switchTo().parentFrame();
                            //  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                            try {
                                driver.switchTo().frame("ifrmToolbar");
                                List<WebElement> d = driver.findElements(By.xpath(".//*[@id='seTbGeneral']/tbody/tr/td/a"));
                                for (WebElement cell : d) {
                                    String fiels = cell.getText();
                                    System.out.println("Tool bar Componets are " + fiels);
                                    Result = "pass";
                                    if (fiels.equals(value)) {
                                        cell.click();

                                        if (fiels.equals(" Upload PDF")) {
                                            NewWindow(driver);
                                            driver.findElement(By.id("btnAttached")).click();
                                            Thread.sleep(300);
                                            BeforeWH(driver);
                                            WebElement ss = driver.findElement(By.id("Radupload1file0"));
                                            ss.click();
                                            Thread.sleep(6000);
                                            AttachFuntn(driver, "E:\\Akshay\\Select-02.pdf");
                                            Thread.sleep(700);
                                            driver.switchTo().window(WinHandleBefore1);
                                            driver.switchTo().window(WinHandleBefore1);

                                            break;
                                            /* // hit enter*/
                                        } else {
                                            if (fiels.equals(" Send for Scrutiny")) {
                                                Thread.sleep(2000);
                                                try {

                                                    if ((ExpectedConditions.alertIsPresent()) == null) {
                                                        System.out.println("alert was not present");
                                                    } else {

                                                        Alert alert = driver.switchTo().alert();
                                                        Actual = driver.switchTo().alert().getText();
                                                        alert.accept();

                                                        if ((ExpectedConditions.alertIsPresent()) == null) {
                                                            System.out.println("alert was not present");
                                                        } else {
                                                            Alert alert2 = driver.switchTo().alert();
                                                            Actual = driver.switchTo().alert().getText();
                                                            alert2.accept();


                                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                                System.out.println("alert was not present");
                                                            } else {
                                                                Alert alert3 = driver.switchTo().alert();
                                                                Actual = driver.switchTo().alert().getText();
                                                                alert3.accept();
                                                            }
                                                        }
                                                    }

                                                } catch (Throwable a) {
                                                    Actual = a.getMessage();
                                                    System.out.println(Actual);
                                                    Result = "pass";
                                                }


                                            } else

                                            {
                                                if (fiels.equals(" Preview Advance Challan")) {
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
                                                    robot.keyPress(KeyEvent.VK_ENTER);
                                                } else {
                                                    if ((ExpectedConditions.alertIsPresent()) == null) {
                                                        System.out.println("alert was not present");
                                                    } else {
                                                        Alert alert = driver.switchTo().alert();
                                                        Actual = driver.switchTo().alert().getText();
                                                        alert.accept();

                                                        if ((ExpectedConditions.alertIsPresent()) == null) {
                                                            System.out.println("alert was not present");
                                                        } else {
                                                            Alert alert2 = driver.switchTo().alert();
                                                            Actual = driver.switchTo().alert().getText();
                                                            alert2.accept();

                                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                                System.out.println("alert was not present");
                                                            } else {
                                                                Alert alert3 = driver.switchTo().alert();
                                                                Actual = driver.switchTo().alert().getText();
                                                                alert3.accept();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        Result = "pass";
                                        break;
                                    } else {
                                        List<WebElement> d1 = driver.findElements(By.xpath("./*//*[@id='SetbReports']/tbody/tr/td[2]/a"));
                                        for (WebElement cell1 : d1) {
                                            String fiels1 = cell1.getText();
                                            System.out.println("Tool bar Componets are:->" + fiels1);
                                            if (fiels1.equals(value)) {
                                                cell1.click();
                                                System.out.println("Tool bar Componets are " + fiels1);

                                                Result = "pass";
                                                break;
                                            } else {
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
                                Actual = e.getMessage();
                                Result = "fails";

                            }
                    }
                    break;


                case "CLICK":
                    String FilePath = "E:\\Akshay\\PWIMS Deployment.pdf";
                    String FilePath2 = "E:\\Akshay\\wew.dwg.dwg";
                    String WinHandleBefore1 = driver.getWindowHandle();
                    switch (objectName) {
/************************************************************************************************/

                        case "Filter":
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='form1']/div[3]/div/div/div[5]/div/div/div/div/div[2]/table/tbody/tr/td/div/button"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value)) {
                                        cell.click();
                                        Result = "pass";
                                        Actual = "Done";
                                        break;
                                    }
                                }
                            } catch (Throwable t) {
                                Actual = t.getMessage();
                                Result = "fails";
                            }
                            break;


                        case "Click On proposal":
                            try {


                                applicantMenu.ClickSelectProposal();
                                driver.switchTo().frame("ifrmProjectInfo");
                                Result = "pass";

                            } catch (Throwable h) {
                                Result = "fails";
                                Actual = h.getMessage();
                            }
                            break;
                        case "Save/Submit challan details":

                            try {
                                driver.findElement(By.xpath(".//*[@id='SetB']/tbody/tr/td[2]/a[1]")).click();
                                Thread.sleep(2333);
                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                } else {
                                    Alert alert = driver.switchTo().alert();
                                    Actual = alert.getText();
                                    alert.accept();

                                    Thread.sleep(2333);
                                    if ((ExpectedConditions.alertIsPresent()) == null) {
                                    } else {
                                        Alert alert2 = driver.switchTo().alert();
                                        Actual = alert2.getText();
                                        alert2.accept();
                                        Thread.sleep(2333);
                                        if ((ExpectedConditions.alertIsPresent()) == null) {
                                        } else {
                                            Alert alert3 = driver.switchTo().alert();
                                            Actual = alert3.getText();
                                            alert3.accept();

                                        }
                                    }

                                }

                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";

                            }
                            Result = "pass";

                        case "Submit":
                            try {
                                Thread.sleep(1000);
                                application.clickSave_Submit();
                                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                WebElement element = driver.findElement(By.xpath("html/body/form/div[1]/table/tbody/tr[2]/td[2]//div/a/span/span"));
                                System.out.println(element.getText());
                                Actions actions = new Actions(driver);
                                actions.moveToElement(element);
                                Thread.sleep(1000);
                                actions.click();
                                actions.build().perform();
                                driver.switchTo().parentFrame();
                                driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmProjectInfo");
                                Result = "pass";
                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }


                               /* driver.close();*/
                            break;

                        case "Submit Risk Details":
                            try {
                                driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr[3]/td[1]/div/input")).click();
                                Thread.sleep(1000);
                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                Thread.sleep(2000);

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                } else {
                                    Alert alert = driver.switchTo().alert();
                                    alert.accept();


                                }

                                driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr[3]/td[2]/input")).click();
                                driver.switchTo().parentFrame();
                                driver.switchTo().parentFrame();
                                Result = "pass";
                                break;
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";

                            }

                            break;


                        case "Double Height FSI":
                            if (value.equals("Yes")) {
                                application.ClickDouble_Height_FSI__Yes();
                                Result = "pass";
                            } else {
                                application.ClickDouble_Height_FSI__NO();
                                Result = "pass";
                            }
                            break;

                        case "Drawing is PreDCR Converted OR Not":
                            if (value.equals("Yes")) {
                                application.ClickDrawing_is_PreDCR_Converted__Yes();
                                Result = "pass";
                            } else {
                                application.clickDrawing_is_PreDCR_Converted__NO();
                                Result = "pass";
                            }
                            break;

                        case "Add For Extra Floor Height":
                            if (value.equals("Yes")) {
                                application.ClickExtra_Floor_Height__Yes();
                                application.setAdditional_FSI_Area(value);
                                Result = "pass";
                            } else {
                                application.clickExtra_Floor_Height__NO();
                                Result = "pass";
                            }
                            break;
/*---------------------------------------------- Risk details --------------------------------------------------------*/
                        case "Risk details":


                            try {
                                if (application.getRiskField().getText().isEmpty()) {
                                    application.ClickRiskFieldMESH();
                                    WebElement frame = driver.findElement(By.xpath("//iframe[@frameborder='0']"));
                                    driver.switchTo().frame(frame);
                                  /*  Thread.sleep(700);
                                    System.out.println(driver.findElement(By.id("frmRiskFactor")).getText());
                                    Thread.sleep(700);*/
                                    Result = "pass";
                                } else {
                                    Result = "pass";
                                }
                                //  System.out.println("done");
                                // driver.close();
                            } catch (Throwable i) {
                                System.out.println(i.getMessage());
                                System.out.println("Not-done");
                                Actual = i.getMessage();
                                Result = "Fails";
                            }
                            break;



/*---------------------------------------------- HeaderTab --------------------------------------------------------*/
                        case "get headers":
                            try {
                                Thread.sleep(30);
                                driver.switchTo().frame("ifrmToolbar");
                                System.out.println(application.getDrawingScunity().getText());
                                System.out.println(application.getRunPreDCR().getText());
                                System.out.println(application.getSendScunity().getText());
                                System.out.println(application.getBack().getText());
                                System.out.println("Done");
                                driver.close();
                            } catch (Throwable p) {
                                System.out.println("Not_Done");
                                System.out.println("************");
                                System.out.println(p.getMessage());
                                driver.close();
                            }
                            break;
                        case "Create Advance Challan":
                            try {
                                // Thread.sleep(30);
                                driver.switchTo().frame("ifrmToolbar");
                                application.ClickAdvancepayment();
                                Thread.sleep(4500);
                                if ((ExpectedConditions.alertIsPresent()) == null) {


                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    //  Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(4500);
                                    alert.accept();
                                    Thread.sleep(4500);
                                    System.out.println("Done");
                                }
                                driver.close();
                            } catch (Throwable p) {
                                System.out.println("Not_Done");
                                System.out.println("************");
                                System.out.println(p.getMessage());
                                Actual = p.getMessage();
                                Result = "Fails";  /* driver.close(); */
                            }
                            break;


/*---------------------------------------------- Building Deatials --------------------------------------------------------*/
                        case "File Name":
                            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                            try {

                                if (driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[6]/td/div/table/tbody/tr/td[3]/div/b")).getText().equals("0")) {
                                    Thread.sleep(15);
                                    WebElement d = driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[3]/td/div/table/tbody/tr/td/div"));
                                    String s = d.getText();
                                    if (s.equals(Expected)) {
                                        Result = "pass";
                                    } else {
                                        Result = "fail";
                                        Actual = s;
                                    }
                                } else {
                                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                                    List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr/td[3]"));

                                    for (WebElement cell : cells) {
                                        String fiels = cell.getText();
                                        System.out.println(fiels);

                                        if (fiels.equals(value)) {
                                            cell.click();
                                            driver.switchTo().frame("ifrmProjectInfo");
                                            Result = "pass";
                                            break;

                                        } else {
                                            Result = "fails";
                                            Actual = "File not Found";
                                        }
                                    }


                                }
                            } catch (Throwable e) {

                                Actual = e.getMessage();
                                Result = "Fails";
                            }


                            break;

                        case "Click on Building Deatils":
                            try {
                                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                application.ClickBuildig_Deatils_Tab();

                                Result = "pass";
                            } catch (Throwable g) {

                                Actual = g.getMessage();
                                Result = "Fails";
                            }


                            break;

                        case "Click on Submit Building":
                            try {
                                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                application.ClickBuilding_Submit();
                                driver.switchTo().parentFrame();
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;
/*---------------------------------------------- Drawing Deatials --------------------------------------------------------*/
                        case "Attach Drawing":

                            try {
                                driver.switchTo().parentFrame();

                                Thread.sleep(1000);
                                application.ClickDrawing_Tab();
                                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmDrawings");
                                String St = application.getDrawing_Data().getText();
                                if (St.equals("No data found")) {
                                    driver.findElement(By.id("btnAttached")).click();
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        //  Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(1000);
                                        alert.accept();
                                    }
                                    Thread.sleep(100);
                                    BeforeWH(driver);

                                    WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                    ss.click();
                                    Thread.sleep(1000);
                                    AttachFuntn(driver, FilePath2);
                                    Thread.sleep(40);
                                    driver.switchTo().window(WinHandleBefore1);
                                    Thread.sleep(1000);
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Thread.sleep(1000);
                                        Alert alert = driver.switchTo().alert();

                                        //  Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(1000);
                                        alert.accept();
                                        Thread.sleep(70);


                                    }

                                } else {
                                    driver.findElement(By.id("btnAttached")).click();
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        //  Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(11000);
                                        alert.accept();
                                        Thread.sleep(01);


                                    }
                                }
                                try {
                                    driver.switchTo().parentFrame();
                                    driver.switchTo().frame("ifrmListing");
                                    driver.findElement(By.xpath(".//*[@id='ProjectTab']/a")).click();
                                    driver.switchTo().frame("ifrmProjectInfo");
                                    Result = "pass";
                                } catch (Throwable g) {
                                    Result = "Fails";
                                    Actual = g.getMessage();
                                }
                            } catch (Throwable d) {
                                Actual = d.getMessage();
                                Result = "fails";
                            }


                            break;
/*---------------------------------------------- Document Deatials --------------------------------------------------------*/
                        case "Click on Document Tab":

                            try {

                                application.ClickDocument_Tab();
                                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmDocuments");
                                Result = "pass";
                                break;
                            } catch (Throwable e) {
                                Result = "fail";
                                Actual = "File not Found";
                                System.out.println(e.getMessage());
                            }
                            break;

                        case "Click On Types Of Document":
                            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='RadTabStrip1']/div/ul/li/a/span/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result = "pass";

                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";
                            }
                            Result = "pass";


                            break;

                        case "Attch medatory doc":
                            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='RadTabStrip1']/div/ul/li/a/span/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();


                                    if (fiels.equals(value)) {
                                        cell.click();
                                        System.out.println(fiels);
                                        if ("Building Plan Primary Documents".equals(value)) {

                                            for (int k = 1; k < 55; k++) {


                                                try {

                                                    if (k == 5) {
                                                        int g = 2 + k;
                                                        k = g;
                                                    } else {

                                                    }
                                                    if (k == 13) {
                                                        int g = 35 + k;
                                                        k = g;
                                                    } else {

                                                    }
                                                    if (k == 49) {
                                                        int g = 5 + k;
                                                        k = g;
                                                    } else {

                                                    }
                                                    Thread.sleep(12);
                                                    driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
                                                    WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[2]"));
                                                    String d = fiels3.getText();
                                                    System.out.println(d);
                                                    driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
                                                    WebElement df = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                    String y = df.getText();
                                                    if (!y.equals("Attach Files")) {
                                                        System.out.println("E");
                                                    } else {
                                                        df.click();
                                                        System.out.println(k);
                                                        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(1000);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");


                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                        System.out.println(k);

                                                    }

                                                } catch (Throwable d) {
                                                    Actual = d.getMessage();
                                                    Result = "fails";
                                                }
                                                Result = "pass";
                                            }
                                            System.out.println("proposal");
                                        } else {
                                            System.out.println("Fire");
                                            for (int l = 35; l < 52; l++) {

                                                if (l == 39) {
                                                    int r = 12 + l;
                                                    l = r;
                                                } else {

                                                }

                                                try {
                                                    Thread.sleep(1000);
                                                    driver.manage().timeouts().implicitlyWait(15l, TimeUnit.SECONDS);
                                                    WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[2]"));
                                                    String d = fiels3.getText();
                                                    System.out.println(d);
                                                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                                                    WebElement ty = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                    String h = ty.getText();
                                                    System.out.println(l);
                                                    if (!h.equals("Attach Files")) {
                                                    } else {
                                                        ty.click();
                                                        driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);

                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();
                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(1000);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");
                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                    }


                                                } catch (Throwable d) {

                                                    Actual = d.getMessage();
                                                    Result = "fails";
                                                }

                                            }

                                        }

                                    } else {
                                        System.out.println("NoCC");
                                    }

                                }
                            } catch (Throwable e) {
                                System.out.println(e.getMessage());

                                Result = "pass";
                            }

                            // driver.switchTo().parentFrame();
                            break;

                        case "Attach Additional Document":


                            try {
                                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                System.out.println(Actvalue);
                                try {
                                    if ("Building Plan Additional Documents".equals(Actvalue)) {
                                        System.out.println("Proposal");
                                        for (int k = 13; k < 54; k++) {

                                            if (k == 18) {
                                                int r = 4 + k;
                                                k = r;
                                            }
                                            if (k == 35) {
                                                int r = 17 + k;
                                                k = r;
                                            }
                                            try {
                                                Thread.sleep(400);
                                                WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[2]"));
                                                String d = fiels3.getText();
                                                System.out.println(d);
                                                if (d.equals(value)) {
                                                    WebElement Chckbox = driver.findElement(By.xpath(".//*[@id='Checkbox" + k + "']"));
                                                    if (!Chckbox.isSelected()) {
                                                        Chckbox.click();
                                                        System.out.println("ch");
                                                        System.out.println(k);
                                                        application.ClickSubmit_Btn();
                                                        Thread.sleep(30);
                                                        driver.findElement(By.xpath(".//*[@id='CloseButtonAlert']")).click();
                                                        Thread.sleep(23);

                                                        driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(700);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");


                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        Thread.sleep(70);
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                    } else {
                                                        WebElement ty = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                        String h = ty.getText();
                                                        System.out.println(k);
                                                        if (h.equals("Attach Files")) {
                                                            driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                            driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                            driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                            BeforeWH(driver);
                                                            WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                            ss.click();
                                                            Thread.sleep(600);
                                                            AttachFuntn(driver, FilePath);
                                                            System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                            driver.switchTo().frame("ifrmListing");


                                                            driver.switchTo().frame("ifrmDocuments");
                                                            System.out.println("pass");
                                                            System.out.println("pass");
                                                            Thread.sleep(70);
                                                            driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                        }

                                                    }

                                                    break;
                                                } else {
                                                    System.out.println("Document not Availble");
                                                }
                                            } catch (Throwable ls) {
                                                Actual = ls.getMessage();
                                                Result = "fails";
                                            }


                                        }
                                    } else {
                                        System.out.println("Fire");
                                        for (int l = 39; l < 51; l++) {

                                            if (l == 43) {
                                                int r = 2 + l;
                                                l = r;
                                            }
                                            if (l == 46) {
                                                int r = 1 + l;
                                                l = r;
                                            }

                                            try {
                                                Thread.sleep(400);
                                                WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[2]"));
                                                String d = fiels3.getText();
                                                System.out.println(d);
                                                if (d.equals(value)) {
                                                    WebElement Chckbox = driver.findElement(By.xpath(".//*[@id='Checkbox" + l + "']"));
                                                    if (!Chckbox.isSelected()) {
                                                        Chckbox.click();
                                                        System.out.println("ch");
                                                        System.out.println(l);
                                                        application.ClickSubmit_Btn();
                                                        Thread.sleep(30);
                                                        driver.findElement(By.xpath(".//*[@id='CloseButtonAlert']")).click();
                                                        Thread.sleep(30);

                                                        driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(600);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");


                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                    } else {
                                                        WebElement ty = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                        String h = ty.getText();
                                                        System.out.println(l);
                                                        if (h.equals("Attach Files")) {
                                                            driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                            driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                            driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                            BeforeWH(driver);
                                                            WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                            ss.click();
                                                            Thread.sleep(600);
                                                            AttachFuntn(driver, FilePath);
                                                            System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                            driver.switchTo().frame("ifrmListing");


                                                            driver.switchTo().frame("ifrmDocuments");
                                                            System.out.println("pass");
                                                            driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                        }

                                                    }
                                                    break;
                                                }

                                            } catch (Throwable d) {
                                                Actual = d.getMessage();
                                                Result = "fails";

                                            }


                                        }
                                        Result = "pass";
                                        driver.switchTo().parentFrame();
                                    }
                                    break;


                                } catch (Throwable e) {
                                    Actual = e.getMessage();
                                    Result = "fails";
                                }
                                Result = "pass";
                            } catch (Throwable m) {
                                Actual = m.getMessage();
                                Result = "fails";
                            }

                            break;


                        case "Click on Additional Document":

                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='RadTabStrip1']/div/ul/li/a/span/span"));

                                for (WebElement cell : cells) {
                                    Actvalue = cell.getText();


                                    if (Actvalue.equals(value)) {
                                        cell.click();
                                        break;
                                    }
                                }
                            } catch (Throwable d) {
                                Actual = d.getMessage();
                                Result = "fails";
                            }
                            Result = "pass";
                            break;

                    }
                    break;
                case "SELECT":

                    switch (objectName) {

                        case "Mode of Payment":
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='trMode']/td[4]/span"));
                                for (WebElement cell : cells) {

                                    String Ra = cell.getText();
                                    if (cell.equals(value)) {
                                        List<WebElement> RADi = driver.findElements(By.xpath(".//*[@id='trMode']/td[4]/input[" + rr + "]"));
                                        for (WebElement RAD1i : RADi) {
                                            RAD1i.click();
                                        }
                                    }

                                }

                                ++rr;
                                //  break;
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";
                            }
                            break;

                        case "Select Bank Name":
                            try {

                                WebElement Bank = driver.findElement(By.xpath(".//*[@id='cboBankName']"));
                                Select combo1 = new Select(Bank);
                                combo1.selectByVisibleText(value);
                                Result = "pass";
                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }

                           /* WebElement Bank = driver.findElement(By.xpath("./*//*[@id='cboBankName']"));
                            Select combo1 = new Select(Bank);
                            combo1.selectByVisibleText(value);*/

                            break;

                       /* case"Challan Type":
                            driver.switchTo().frame("ifrmListing");
                            WebElement d22=driver.findElement(By.xpath("./*//*[@id='cboChallanType']"));
                            String dd222=d22.getText();

                            Select combo1=new Select(d22);
                            combo1.selectByVisibleText(value);
                            System.out.println(dd222);
                            break;*/
                        case "Select Proposal Risk parameter":

                            try {
                                WebElement d = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[" + x + "]/td[5]/select"));
                                Select combo = new Select(d);
                                combo.selectByVisibleText(value);
                                ++x;
                                ++x;
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Risk paramitter":

                            List<WebElement> cell2 = driver.findElements(By.xpath("html/body/form/table[2]/tbody/tr/td[2]/span"));

                            for (WebElement cell12 : cell2) {
                                String fiels = cell12.getText();
                                if (value.equals(fiels)) {
                                    Result = "pass";
                                    break;
                                }
                                break;
                            }
                            break;


                        case "Proposal Type":
                            try {
                                //applicantMenu=new ApplicantMenu(driver);
                                application.selectProposal_Type(value);
                                Result = "pass";

                            } catch (Throwable g) {
                                Actual = g.getMessage();
                                Result = "Fail";
                            }
                            break;

                        case "Company Activity":
                            Thread.sleep(1000);
                            try {
                                driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                                List<WebElement> cells = driver.findElements(By.xpath("./*//*[@id='cboCompanyActivitys']/option"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {

                                Actual = e.getMessage();
                                Result = "Fail";
                            }
                            break;

                        case "Proposal Use":
                            try {
                                application.selectProposal_Use(value);
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Plot Possession / A to L Date":
                            try {
                                DateFunpro(driver, "09/08/2017");
                                Result = "pass";

                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Industrial Area":

                            try {
                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                application.selectIndustrial_Area(value);
                                Result = "pass";

                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }

                          /*  application.selectIndustrial_Area(value);
                            Result = "pass";*/
                            break;

                        case "Concerned SPA":
                            try {
                                application.selectConcerned_SPA(value);
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "MPCB Consent":
                            application.selectMPCB_Consent(value);
                            Result = "pass";
                            break;
/*---------------------------------------------- Building Deatials --------------------------------------------------------*/

                        case "Building Use":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions actions = new Actions(driver);
                            actions.moveToElement(application.getBuilding_Use());
                            actions.click();
                            actions.build().perform();
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("./*//*[@class='GLMenuBody GLEnumMenuBody']/div//div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))

                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fail";
                            }
                            break;
                        case "Building Subuse":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions action = new Actions(driver);
                            action.moveToElement(application.getBuilding_Subuse());
                            action.click();

                            action.build().perform();
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("//div[@class='GLMenuMain GLEnumMenuMain']/div/div/div/div/div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))

                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fail";
                            }
                            break;

                        case "Building Type":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions action1 = new Actions(driver);
                            action1.moveToElement(application.getBuilding_Type());
                            action1.click();

                            action1.build().perform();
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("//div[@class='GLMenuMain GLEnumMenuMain']/div/div/div/div/div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))

                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fail";
                            }
                            break;

                        case "Building Strucher":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions action3 = new Actions(driver);
                            action3.moveToElement(application.getBuilding_Strucher());
                            action3.click();

                            action3.build().perform();
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("//div[@class='GLMenuMain GLEnumMenuMain']/div/div/div/div/div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))

                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fail";
                            }
                            break;


                    }
                    break;

                case "SETTEXT":

                    switch (objectName) {

                        case "Enter Keyword for search":
                            try {
                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                Actions actionsff = new Actions(driver);
                                actionsff.moveToElement(driver.findElement(By.xpath(".//*[@id='form1']/div[3]//div[5]/div//div[2]/table/tbody/tr/td[2]/div")));
                                actionsff.doubleClick();
                                actionsff.sendKeys(value);
                                actionsff.build().perform();
                                Result = "pass";

                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }

                            break;
                        case "SWC File No":

                            try {
                                driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
                                driver.findElement(By.xpath(".//*[@id='txtFile']")).sendKeys(value);
                                driver.findElement(By.xpath(".//*//fieldset/table/tbody/tr[4]/td[4]/table/tbody/tr/td[1]/input")).click();
                                Result = "pass";
                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }

                            break;

                        case "UTR No.":
                            try {
                                driver.findElement(By.xpath(".//*[@id='txtPayOrderNo']")).sendKeys(value);
                                Result = "pass";
                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }

                            break;
                        case "Branch Name":
                            try {

                                driver.findElement(By.xpath(".//*[@id='txtChequeBranch']")).sendKeys(value);
                                Result = "pass";


                            } catch (Throwable j)

                            {
                                Actual = j.getMessage();
                                Result = "fails";
                            }
                            //   driver.findElement(By.xpath(".//*[@id='txtChequeBranch']")).sendKeys(value);
                            //   Result = "pass";
                            break;


                        case "Set proposed value":
                            try {
                                driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
                                driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[" + x + "]/td[4]/input")).sendKeys(value);
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Proposal Title":
                            try {
                                application.setProposal_Title(value);
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Plot No":
                            try {
                                application.setPlot_No(value);
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Applicant Name":
                            application.setApplicant_Name(value);

                            final String fieldValue9 = application.getApplicant_Name().getAttribute("value");
                            if (fieldValue9.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue9.equals(value)) {
                                    if (!String.matcher(fieldValue9).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                        System.out.println(fieldValue9);
                                        System.out.println(Result);
                                    }
                                } else {
                                    if (Actual.equals(Expected)) {
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                    }
                                }
                            }

                            break;

                        case "Other Structure Area":

                            application.getOther_Structure_Area().clear();
                            application.setOther_Structure_Area(value);

                            final String fieldValue7 = application.getOther_Structure_Area().getAttribute("value");
                            if (fieldValue7.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue7.equals(value)) {

                                    System.out.println(fieldValue7);

                                    if (!Flot.matcher(fieldValue7).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Other Structure Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Shed Area":
                            application.getShed_Area().clear();
                            application.setShed_Area(value);

                            final String fieldValue6 = application.getShed_Area().getAttribute("value");
                            if (fieldValue6.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue6.equals(value)) {

                                    System.out.println(fieldValue6);

                                    if (!Flot.matcher(fieldValue6).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Shed Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "RCC Area":
                            application.getRCC_Area().clear();
                            application.setRCC_Area(value);

                            final String fieldValue5 = application.getRCC_Area().getAttribute("value");
                            if (fieldValue5.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue5.equals(value)) {

                                    System.out.println(fieldValue5);

                                    if (!Flot.matcher(fieldValue5).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "RCC Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Gross Built Up Area":
                            application.getGross_Built_Up_Area().clear();
                            application.setGross_Built_Up_Area(value);

                            final String fieldValue4 = application.getGross_Built_Up_Area().getAttribute("value");
                            if (fieldValue4.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue4.equals(value)) {

                                    System.out.println(fieldValue4);

                                    if (!Flot.matcher(fieldValue4).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Gross Built Up Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Basement Area":
                            application.getBasement_Area().clear();
                            application.setBasement_Area(value);

                            final String fieldValue3 = application.getBasement_Area().getAttribute("value");
                            if (fieldValue3.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue3.equals(value)) {

                                    System.out.println(fieldValue3);

                                    if (!Flot.matcher(fieldValue3).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Basement Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Plot Area":
                            application.getPlot_Area().clear();
                            application.setPlot_Area(value);

                            final String fieldValue2 = application.getPlot_Area().getAttribute("value");
                            if (fieldValue2.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue2.equals(value)) {

                                    System.out.println(fieldValue2);

                                    if (!Flot.matcher(fieldValue2).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Plot Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Total Building Height":


                            Thread.sleep(100);
                            application.getTotal_Building_Height().clear();
                            Thread.sleep(2000);
                            application.setTotal_Building_Height(value);

                            final String fieldValue1 = application.getTotal_Building_Height().getAttribute("value");
                            if (fieldValue1.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue1.equals(value)) {

                                    System.out.println(fieldValue1);

                                    if (!Flot.matcher(fieldValue1).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Building Height not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Ready Reckoner Rate":
                            application.getReady_Reckoner_Rate().clear();
                            application.setReady_Reckoner_Rate(value);

                            final String fieldValue = application.getReady_Reckoner_Rate().getAttribute("value");
                            if (fieldValue.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue.equals(value)) {

                                    System.out.println(fieldValue);

                                    if (!Flot.matcher(fieldValue).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Ready Reckoner Rate not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Land_Ready Reckoner Rate":
                            application.getLand_Ready_Reckoner_Rate().clear();
                            application.setLand_Ready_Reckoner_Rate(value);

                            final String fieldValu = application.getLand_Ready_Reckoner_Rate().getAttribute("value");
                            if (fieldValu.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = e.getMessage();
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValu.equals(value)) {

                                    //   System.out.println(fieldValue);

                                    if (!Flot.matcher(fieldValu).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = e.getMessage();
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Ready Reckoner Rate not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;
/*---------------------------------------------- Building Deatials --------------------------------------------------------*/

                        case "Building Name":
                            try {
                                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmBuildingDetails");
                                System.out.println("find");
                                Actions actions = new Actions(driver);
                                actions.moveToElement(application.getBuilding_Name());
                                actions.click();
                                actions.click();
                                actions.sendKeys(value);
                                actions.build().perform();
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;
                        case "Building rows":
                            try {
                                System.out.println("find");
                                Actions actions2 = new Actions(driver);
                                actions2.moveToElement(application.getBuilding_Rows());
                                actions2.click();
                                actions2.click();
                                actions2.sendKeys(value);
                                actions2.build().perform();
                                Result = "pass";


                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Building Height":
                            try {
                                System.out.println("find");
                                Actions actions3 = new Actions(driver);
                                actions3.moveToElement(application.getBuilding_Height());
                                actions3.click();
                                actions3.click();
                                actions3.sendKeys(value);
                                actions3.build().perform();
                                Result = "pass";

                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }

                            System.out.println("find");
                            Actions actions3 = new Actions(driver);
                            actions3.moveToElement(application.getBuilding_Height());
                            actions3.click();
                            actions3.click();
                            actions3.sendKeys(value);
                            actions3.build().perform();
                            break;

                        case "Building Floor":
                            try {
                                System.out.println("find");
                                Actions actions4 = new Actions(driver);
                                actions4.moveToElement(application.getBuilding_Floors());
                                actions4.click();
                                actions4.click();
                                actions4.sendKeys(value);
                                actions4.build().perform();
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;


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

    @Test(dataProvider = "hybridData1", priority = 0)
    public static void ApplicationTest(String testcaseName, String keyword, String objectName, String value, String Expected) throws Exception {

        if (testcaseName != null && testcaseName.length() != 0) {

            driver = openBrowser("chrome");
            GetUrl("url");
            Thread.sleep(200);
            SetBord = j++;
            Label l7 = new Label(5, SetBord, "", cellFormat6);
            targetSheet.addCell(l7);
            Label l8 = new Label(6, SetBord, "", cellFormat6);
            targetSheet.addCell(l8);
            k1 = 1;
        } else {
            SetBord = j++;
        }

        try {
            switch (keyword.toUpperCase()) {

                case "BROWSER CLOSED":
                    switch (objectName) {
                        case "Closed":
                            Thread.sleep(1000);
                            driver.quit();
                            Thread.sleep(1000);
                            Result = "pass";
                    }

                    break;
                case "FRAME":

                    switch (objectName) {
                        case "Parent Frame":
                            try {

                                driver.switchTo().parentFrame();
                                // driver.switchTo().parentFrame();

                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }

                            break;


                        case "Main Frame":
                            try {

                                application = new Application(driver);
                                applicantMenu = new ApplicantMenu(driver);
                                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmListing");

                                Result = "pass";

                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                    }
                    break;
                case "RECONCILIIATION":

                    switch (objectName) {


                        case "Save Reconciliation Status":
                            try {
                                driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
                                Thread.sleep(2315);
                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                    System.out.println("alert was not present");
                                } else {
                                    Alert alert = driver.switchTo().alert();
                                    Actual = driver.switchTo().alert().getText();
                                    alert.accept();

                                    Thread.sleep(6000);

                                    Alert alert3 = driver.switchTo().alert();
                                    Actual = driver.switchTo().alert().getText();
                                    alert3.accept();
                                }

                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }


                            break;

                        case "Change Reconciliation Status":
                            Thread.sleep(1000);
                            //  driver.switchTo().frame("ifrmListing");
                            try {
                                WebElement Reco = driver.findElement(By.xpath(".//*//tr[6]/td/div/table/tbody/tr/td[5]/div/b"));
                                String total_payments = Reco.getText();
                                if (total_payments.equals("0")) {
                                    Result = "pass";
                                    Actual = "Payment are pending";
                                } else {

                                    List<WebElement> Rs = driver.findElements(By.xpath(".//*[@id='ListPaymentReconsileGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr/td[15]"));
                                    for (WebElement re : Rs) {
                                        String req = re.getText();
                                        if (req.equals("Reconciled")) {/*
                                            Actual="File already consiloid ";
                                            System.out.println(Actual);
                                            Result="pass"
                                       */
                                            ++Rec;
                                        } else {

                                            Thread.sleep(1000);
                                            RecDateFun(driver, "13/02/2018", Rec);
                                            Thread.sleep(1000);
                                            Actions actions = new Actions(driver);
                                            actions.moveToElement(re);
                                            Thread.sleep(200);
                                            actions.click();
                                            actions.build().perform();
                                            driver.manage().timeouts().implicitlyWait(23, TimeUnit.SECONDS);
                                            actions.moveToElement(driver.findElement(By.xpath(".//*[@id='TGMenu-0-1']/div/div")));
                                            actions.click();
                                            actions.build().perform();
                                            ++Rec;

                                        }
                                    }



                              /*      Actions actions = new Actions(driver);
                                    actions.moveToElement(driver.findElement(By.xpath("./*//*[@id='ListPaymentReconsileGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[12]")));
                                    Thread.sleep(200);
                                    actions.click();
                                    actions.build().perform();
                                    driver.manage().timeouts().implicitlyWait(23,TimeUnit.SECONDS);*/
                                    //   List<WebElement> paynow = driver.findElements(By.xpath(".//*[@id='TreeGridControls']/div/div/div[7]/div/div/div/div/div/div"));
                             /*       actions.moveToElement(driver.findElement(By.xpath("./*//*[@id='TreeGridControls']/div/div/div[7]/div/div//div[2]")));
                                    actions.click(); actions.build().perform();*/
                                   /* for (WebElement paynow1 : paynow) {
                                        String fiels23 = paynow1.getText();
                                        System.out.println(fiels23);
                                        if (fiels23.equals(value)) {
                                            paynow1.click();
                                            break;
                                        } ++Rec;
                                    }
*/
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";


                            }

                    }
                    break;

                case "PAY":

                    switch (objectName) {

                        case "Pending Demand Note":


                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*/tr[2]/td[2]/div/div[1]/table/tbody//td[2]"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);
                                    if (fiels.equals(value)) {

                                        List<WebElement> paynow = driver.findElements(By.xpath(".//*//tr[2]/td[2]/div/div[1]/table/tbody/tr[" + vb + "]/td[6]"));

                                        for (WebElement d : paynow) {

                                            d.click();
                                            BeforeWH(driver);

                                            WebElement dee = driver.findElement(By.xpath(".//*//tbody/tr[8]/td[2]/table/tbody/tr/td[1]"));
                                            String dddd = dee.getText();
                                            System.out.println(dddd);

                                        }


                                    }
                                    ++vb;
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";

                            }

                    }
                    break;

                case "LEFT_MENU":

                    switch (objectName) {
                        case "LeftMenuTab":

                            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*/div/nav/ul/li/a/div/div[2]/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);
                                    if (fiels.equals(value)) {
                                        System.out.println(fiels);
                                        if (k1 != 1) {
                                            cell.click();
                                            System.out.println("Value Name is :-***" + value + "***");
                                            Result = "pass";
                                            break;
                                        }
                                    } else {
                                        Result = "fail";
                                        Actual = "Tab not present.";
                                    }
                                    ++k1;

                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";

                            }
                            break;

                        case "LeftMenu_SubTab":
                            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*/div/nav/ul/li/ul/li/a/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    if (fiels.equals(value)) {
                                        cell.click();
                                        System.out.println("Value Name is :-***" + value + "***");

                                        System.out.println("The value of K:-" + k);
                                        Result = "pass";
                                        break;
                                    }

                                }
                            } catch (Throwable e) {

                                Actual = e.getMessage();
                                Result = "fails";

                            }
                    }
                    break;

                case "LOGIN":

                    switch (objectName) {

                        case "Architect":
                            LogFunction(driver);
                            Result = "pass";
                            break;
                        case "Payment":
                            MIDCPA_LogFunction(driver);
                            Result = "pass";
                            break;
                        case "Deputy Chief officer":
                            DFO_LogFunction(driver);
                            Result = "pass";
                    }
                    break;


                case "STATUS BAR":

                    switch (objectName) {
                        case "Get Opertional Bar Details":
                            driver.switchTo().parentFrame();
                            //  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                            try {
                                driver.switchTo().frame("ifrmToolbar");
                                List<WebElement> d = driver.findElements(By.xpath(".//*[@id='seTbGeneral']/tbody/tr/td/a"));
                                for (WebElement cell : d) {
                                    String fiels = cell.getText();
                                    System.out.println("Tool bar Componets are " + fiels);
                                    Result = "pass";
                                    if (fiels.equals(value)) {
                                        cell.click();

                                        if (fiels.equals(" Upload PDF")) {
                                            NewWindow(driver);
                                            driver.findElement(By.id("btnAttached")).click();
                                            Thread.sleep(300);
                                            BeforeWH(driver);
                                            WebElement ss = driver.findElement(By.id("Radupload1file0"));
                                            ss.click();
                                            Thread.sleep(6000);
                                            AttachFuntn(driver, "E:\\Akshay\\Select-02.pdf");
                                            Thread.sleep(700);
                                            driver.switchTo().window(WinHandleBefore1);
                                            driver.switchTo().window(WinHandleBefore1);

                                            break;
                                            /* // hit enter*/
                                        } else {
                                            if (fiels.equals(" Send for Scrutiny")) {
                                                Thread.sleep(2000);
                                                try {

                                                    if ((ExpectedConditions.alertIsPresent()) == null) {
                                                        System.out.println("alert was not present");
                                                    } else {

                                                        Alert alert = driver.switchTo().alert();
                                                        Actual = driver.switchTo().alert().getText();
                                                        alert.accept();

                                                        if ((ExpectedConditions.alertIsPresent()) == null) {
                                                            System.out.println("alert was not present");
                                                        } else {
                                                            Alert alert2 = driver.switchTo().alert();
                                                            Actual = driver.switchTo().alert().getText();
                                                            alert2.accept();


                                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                                System.out.println("alert was not present");
                                                            } else {
                                                                Alert alert3 = driver.switchTo().alert();
                                                                Actual = driver.switchTo().alert().getText();
                                                                alert3.accept();
                                                            }
                                                        }
                                                    }

                                                } catch (Throwable a) {
                                                    Actual = a.getMessage();
                                                    System.out.println(Actual);
                                                    Result = "pass";
                                                }


                                            } else

                                            {
                                                if (fiels.equals(" Preview Advance Challan")) {
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
                                                    robot.keyPress(KeyEvent.VK_ENTER);
                                                } else {
                                                    if ((ExpectedConditions.alertIsPresent()) == null) {
                                                        System.out.println("alert was not present");
                                                    } else {
                                                        Alert alert = driver.switchTo().alert();
                                                        Actual = driver.switchTo().alert().getText();
                                                        alert.accept();

                                                        if ((ExpectedConditions.alertIsPresent()) == null) {
                                                            System.out.println("alert was not present");
                                                        } else {
                                                            Alert alert2 = driver.switchTo().alert();
                                                            Actual = driver.switchTo().alert().getText();
                                                            alert2.accept();

                                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                                System.out.println("alert was not present");
                                                            } else {
                                                                Alert alert3 = driver.switchTo().alert();
                                                                Actual = driver.switchTo().alert().getText();
                                                                alert3.accept();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        Result = "pass";
                                        break;
                                    } else {
                                        List<WebElement> d1 = driver.findElements(By.xpath("./*//*[@id='SetbReports']/tbody/tr/td[2]/a"));
                                        for (WebElement cell1 : d1) {
                                            String fiels1 = cell1.getText();
                                            System.out.println("Tool bar Componets are:->" + fiels1);
                                            if (fiels1.equals(value)) {
                                                cell1.click();
                                                System.out.println("Tool bar Componets are " + fiels1);

                                                Result = "pass";
                                                break;
                                            } else {
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
                                Actual = e.getMessage();
                                Result = "fails";

                            }
                    }
                    break;


                case "CLICK":
                    String FilePath = "E:\\Akshay\\PWIMS Deployment.pdf";
                    String FilePath2 = "E:\\Akshay\\wew.dwg.dwg";
                    String WinHandleBefore1 = driver.getWindowHandle();
                    switch (objectName) {
/************************************************************************************************/

                        case "Filter":
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='form1']/div[3]/div/div/div[5]/div/div/div/div/div[2]/table/tbody/tr/td/div/button"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value)) {
                                        cell.click();
                                        Result = "pass";
                                        Actual = "Done";
                                        break;
                                    }
                                }
                            } catch (Throwable t) {
                                Actual = t.getMessage();
                                Result = "fails";
                            }
                            break;


                        case "Click On proposal":
                            try {


                                applicantMenu.ClickSelectProposal();
                                driver.switchTo().frame("ifrmProjectInfo");
                                Result = "pass";

                            } catch (Throwable h) {
                                Result = "fails";
                                Actual = h.getMessage();
                            }
                            break;
                        case "Save/Submit challan details":

                            try {
                                driver.findElement(By.xpath(".//*[@id='SetB']/tbody/tr/td[2]/a[1]")).click();
                                Thread.sleep(2333);
                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                } else {
                                    Alert alert = driver.switchTo().alert();
                                    Actual = alert.getText();
                                    alert.accept();

                                    Thread.sleep(2333);
                                    if ((ExpectedConditions.alertIsPresent()) == null) {
                                    } else {
                                        Alert alert2 = driver.switchTo().alert();
                                        Actual = alert2.getText();
                                        alert2.accept();
                                        Thread.sleep(2333);
                                        if ((ExpectedConditions.alertIsPresent()) == null) {
                                        } else {
                                            Alert alert3 = driver.switchTo().alert();
                                            Actual = alert3.getText();
                                            alert3.accept();

                                        }
                                    }

                                }

                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";

                            }
                            Result = "pass";

                        case "Submit":
                            try {
                                Thread.sleep(1000);
                                application.clickSave_Submit();
                                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                WebElement element = driver.findElement(By.xpath("html/body/form/div[1]/table/tbody/tr[2]/td[2]//div/a/span/span"));
                                System.out.println(element.getText());
                                Actions actions = new Actions(driver);
                                actions.moveToElement(element);
                                Thread.sleep(1000);
                                actions.click();
                                actions.build().perform();
                                driver.switchTo().parentFrame();
                                driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmProjectInfo");
                                Result = "pass";
                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }


                               /* driver.close();*/
                            break;

                        case "Submit Risk Details":
                            try {
                                driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr[3]/td[1]/div/input")).click();
                                Thread.sleep(1000);
                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                Thread.sleep(2000);

                                if ((ExpectedConditions.alertIsPresent()) == null) {
                                } else {
                                    Alert alert = driver.switchTo().alert();
                                    alert.accept();


                                }

                                driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr[3]/td[2]/input")).click();
                                driver.switchTo().parentFrame();
                                driver.switchTo().parentFrame();
                                Result = "pass";
                                break;
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";

                            }

                            break;


                        case "Double Height FSI":
                            if (value.equals("Yes")) {
                                application.ClickDouble_Height_FSI__Yes();
                                Result = "pass";
                            } else {
                                application.ClickDouble_Height_FSI__NO();
                                Result = "pass";
                            }
                            break;

                        case "Drawing is PreDCR Converted OR Not":
                            if (value.equals("Yes")) {
                                application.ClickDrawing_is_PreDCR_Converted__Yes();
                                Result = "pass";
                            } else {
                                application.clickDrawing_is_PreDCR_Converted__NO();
                                Result = "pass";
                            }
                            break;

                        case "Add For Extra Floor Height":
                            if (value.equals("Yes")) {
                                application.ClickExtra_Floor_Height__Yes();
                                application.setAdditional_FSI_Area(value);
                                Result = "pass";
                            } else {
                                application.clickExtra_Floor_Height__NO();
                                Result = "pass";
                            }
                            break;
/*---------------------------------------------- Risk details --------------------------------------------------------*/
                        case "Risk details":


                            try {
                                if (application.getRiskField().getText().isEmpty()) {
                                    application.ClickRiskFieldMESH();
                                    WebElement frame = driver.findElement(By.xpath("//iframe[@frameborder='0']"));
                                    driver.switchTo().frame(frame);
                                  /*  Thread.sleep(700);
                                    System.out.println(driver.findElement(By.id("frmRiskFactor")).getText());
                                    Thread.sleep(700);*/
                                    Result = "pass";
                                } else {
                                    Result = "pass";
                                }
                                //  System.out.println("done");
                                // driver.close();
                            } catch (Throwable i) {
                                System.out.println(i.getMessage());
                                System.out.println("Not-done");
                                Actual = i.getMessage();
                                Result = "Fails";
                            }
                            break;



/*---------------------------------------------- HeaderTab --------------------------------------------------------*/
                        case "get headers":
                            try {
                                Thread.sleep(30);
                                driver.switchTo().frame("ifrmToolbar");
                                System.out.println(application.getDrawingScunity().getText());
                                System.out.println(application.getRunPreDCR().getText());
                                System.out.println(application.getSendScunity().getText());
                                System.out.println(application.getBack().getText());
                                System.out.println("Done");
                                driver.close();
                            } catch (Throwable p) {
                                System.out.println("Not_Done");
                                System.out.println("************");
                                System.out.println(p.getMessage());
                                driver.close();
                            }
                            break;
                        case "Create Advance Challan":
                            try {
                                // Thread.sleep(30);
                                driver.switchTo().frame("ifrmToolbar");
                                application.ClickAdvancepayment();
                                Thread.sleep(4500);
                                if ((ExpectedConditions.alertIsPresent()) == null) {


                                } else {
                                    Alert alert = driver.switchTo().alert();

                                    //  Actual = driver.switchTo().alert().getText();
                                    Thread.sleep(4500);
                                    alert.accept();
                                    Thread.sleep(4500);
                                    System.out.println("Done");
                                }
                                driver.close();
                            } catch (Throwable p) {
                                System.out.println("Not_Done");
                                System.out.println("************");
                                System.out.println(p.getMessage());
                                Actual = p.getMessage();
                                Result = "Fails";  /* driver.close(); */
                            }
                            break;


/*---------------------------------------------- Building Deatials --------------------------------------------------------*/
                        case "File Name":
                            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                            try {

                                if (driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[6]/td/div/table/tbody/tr/td[3]/div/b")).getText().equals("0")) {
                                    Thread.sleep(15);
                                    WebElement d = driver.findElement(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[3]/td/div/table/tbody/tr/td/div"));
                                    String s = d.getText();
                                    if (s.equals(Expected)) {
                                        Result = "pass";
                                    } else {
                                        Result = "fail";
                                        Actual = s;
                                    }
                                } else {
                                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                                    List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr/td[3]"));

                                    for (WebElement cell : cells) {
                                        String fiels = cell.getText();
                                        System.out.println(fiels);

                                        if (fiels.equals(value)) {
                                            cell.click();
                                            driver.switchTo().frame("ifrmProjectInfo");
                                            Result = "pass";
                                            break;

                                        } else {
                                            Result = "fails";
                                            Actual = "File not Found";
                                        }
                                    }


                                }
                            } catch (Throwable e) {

                                Actual = e.getMessage();
                                Result = "Fails";
                            }


                            break;

                        case "Click on Building Deatils":
                            try {
                                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                application.ClickBuildig_Deatils_Tab();

                                Result = "pass";
                            } catch (Throwable g) {

                                Actual = g.getMessage();
                                Result = "Fails";
                            }


                            break;

                        case "Click on Submit Building":
                            try {
                                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                application.ClickBuilding_Submit();
                                driver.switchTo().parentFrame();
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;
/*---------------------------------------------- Drawing Deatials --------------------------------------------------------*/
                        case "Attach Drawing":

                            try {
                                driver.switchTo().parentFrame();

                                Thread.sleep(1000);
                                application.ClickDrawing_Tab();
                                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmDrawings");
                                String St = application.getDrawing_Data().getText();
                                if (St.equals("No data found")) {
                                    driver.findElement(By.id("btnAttached")).click();
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        //  Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(1000);
                                        alert.accept();
                                    }
                                    Thread.sleep(100);
                                    BeforeWH(driver);

                                    WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                    ss.click();
                                    Thread.sleep(1000);
                                    AttachFuntn(driver, FilePath2);
                                    Thread.sleep(40);
                                    driver.switchTo().window(WinHandleBefore1);
                                    Thread.sleep(1000);
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Thread.sleep(1000);
                                        Alert alert = driver.switchTo().alert();

                                        //  Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(1000);
                                        alert.accept();
                                        Thread.sleep(70);


                                    }

                                } else {
                                    driver.findElement(By.id("btnAttached")).click();
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        //  Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(11000);
                                        alert.accept();
                                        Thread.sleep(01);


                                    }
                                }
                                try {
                                    driver.switchTo().parentFrame();
                                    driver.switchTo().frame("ifrmListing");
                                    driver.findElement(By.xpath(".//*[@id='ProjectTab']/a")).click();
                                    driver.switchTo().frame("ifrmProjectInfo");
                                    Result = "pass";
                                } catch (Throwable g) {
                                    Result = "Fails";
                                    Actual = g.getMessage();
                                }
                            } catch (Throwable d) {
                                Actual = d.getMessage();
                                Result = "fails";
                            }


                            break;
/*---------------------------------------------- Document Deatials --------------------------------------------------------*/
                        case "Click on Document Tab":

                            try {

                                application.ClickDocument_Tab();
                                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmDocuments");
                                Result = "pass";
                                break;
                            } catch (Throwable e) {
                                Result = "fail";
                                Actual = "File not Found";
                                System.out.println(e.getMessage());
                            }
                            break;

                        case "Click On Types Of Document":
                            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='RadTabStrip1']/div/ul/li/a/span/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result = "pass";

                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";
                            }
                            Result = "pass";


                            break;

                        case "Attch medatory doc":
                            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='RadTabStrip1']/div/ul/li/a/span/span"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();


                                    if (fiels.equals(value)) {
                                        cell.click();
                                        System.out.println(fiels);
                                        if ("Building Plan Primary Documents".equals(value)) {

                                            for (int k = 1; k < 55; k++) {


                                                try {

                                                    if (k == 5) {
                                                        int g = 2 + k;
                                                        k = g;
                                                    } else {

                                                    }
                                                    if (k == 13) {
                                                        int g = 35 + k;
                                                        k = g;
                                                    } else {

                                                    }
                                                    if (k == 49) {
                                                        int g = 5 + k;
                                                        k = g;
                                                    } else {

                                                    }
                                                    Thread.sleep(12);
                                                    driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
                                                    WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[2]"));
                                                    String d = fiels3.getText();
                                                    System.out.println(d);
                                                    driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
                                                    WebElement df = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                    String y = df.getText();
                                                    if (!y.equals("Attach Files")) {
                                                        System.out.println("E");
                                                    } else {
                                                        df.click();
                                                        System.out.println(k);
                                                        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(1000);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");


                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                        System.out.println(k);

                                                    }

                                                } catch (Throwable d) {
                                                    Actual = d.getMessage();
                                                    Result = "fails";
                                                }
                                                Result = "pass";
                                            }
                                            System.out.println("proposal");
                                        } else {
                                            System.out.println("Fire");
                                            for (int l = 35; l < 52; l++) {

                                                if (l == 39) {
                                                    int r = 12 + l;
                                                    l = r;
                                                } else {

                                                }

                                                try {
                                                    Thread.sleep(1000);
                                                    driver.manage().timeouts().implicitlyWait(15l, TimeUnit.SECONDS);
                                                    WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[2]"));
                                                    String d = fiels3.getText();
                                                    System.out.println(d);
                                                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                                                    WebElement ty = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                    String h = ty.getText();
                                                    System.out.println(l);
                                                    if (!h.equals("Attach Files")) {
                                                    } else {
                                                        ty.click();
                                                        driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);

                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();
                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(1000);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");
                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                    }


                                                } catch (Throwable d) {

                                                    Actual = d.getMessage();
                                                    Result = "fails";
                                                }

                                            }

                                        }

                                    } else {
                                        System.out.println("NoCC");
                                    }

                                }
                            } catch (Throwable e) {
                                System.out.println(e.getMessage());

                                Result = "pass";
                            }

                            // driver.switchTo().parentFrame();
                            break;

                        case "Attach Additional Document":


                            try {
                                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                System.out.println(Actvalue);
                                try {
                                    if ("Building Plan Additional Documents".equals(Actvalue)) {
                                        System.out.println("Proposal");
                                        for (int k = 13; k < 54; k++) {

                                            if (k == 18) {
                                                int r = 4 + k;
                                                k = r;
                                            }
                                            if (k == 35) {
                                                int r = 17 + k;
                                                k = r;
                                            }
                                            try {
                                                Thread.sleep(400);
                                                WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[2]"));
                                                String d = fiels3.getText();
                                                System.out.println(d);
                                                if (d.equals(value)) {
                                                    WebElement Chckbox = driver.findElement(By.xpath(".//*[@id='Checkbox" + k + "']"));
                                                    if (!Chckbox.isSelected()) {
                                                        Chckbox.click();
                                                        System.out.println("ch");
                                                        System.out.println(k);
                                                        application.ClickSubmit_Btn();
                                                        Thread.sleep(30);
                                                        driver.findElement(By.xpath(".//*[@id='CloseButtonAlert']")).click();
                                                        Thread.sleep(23);

                                                        driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(700);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");


                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        Thread.sleep(70);
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                    } else {
                                                        WebElement ty = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                        String h = ty.getText();
                                                        System.out.println(k);
                                                        if (h.equals("Attach Files")) {
                                                            driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                            driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                            driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                            BeforeWH(driver);
                                                            WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                            ss.click();
                                                            Thread.sleep(600);
                                                            AttachFuntn(driver, FilePath);
                                                            System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                            driver.switchTo().frame("ifrmListing");


                                                            driver.switchTo().frame("ifrmDocuments");
                                                            System.out.println("pass");
                                                            System.out.println("pass");
                                                            Thread.sleep(70);
                                                            driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                        }

                                                    }

                                                    break;
                                                } else {
                                                    System.out.println("Document not Availble");
                                                }
                                            } catch (Throwable ls) {
                                                Actual = ls.getMessage();
                                                Result = "fails";
                                            }


                                        }
                                    } else {
                                        System.out.println("Fire");
                                        for (int l = 39; l < 51; l++) {

                                            if (l == 43) {
                                                int r = 2 + l;
                                                l = r;
                                            }
                                            if (l == 46) {
                                                int r = 1 + l;
                                                l = r;
                                            }

                                            try {
                                                Thread.sleep(400);
                                                WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[2]"));
                                                String d = fiels3.getText();
                                                System.out.println(d);
                                                if (d.equals(value)) {
                                                    WebElement Chckbox = driver.findElement(By.xpath(".//*[@id='Checkbox" + l + "']"));
                                                    if (!Chckbox.isSelected()) {
                                                        Chckbox.click();
                                                        System.out.println("ch");
                                                        System.out.println(l);
                                                        application.ClickSubmit_Btn();
                                                        Thread.sleep(30);
                                                        driver.findElement(By.xpath(".//*[@id='CloseButtonAlert']")).click();
                                                        Thread.sleep(30);

                                                        driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                        driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                        driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                        BeforeWH(driver);
                                                        WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                        ss.click();
                                                        Thread.sleep(600);
                                                        AttachFuntn(driver, FilePath);
                                                        System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                        driver.switchTo().frame("ifrmListing");


                                                        driver.switchTo().frame("ifrmDocuments");
                                                        System.out.println("pass");
                                                        driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                    } else {
                                                        WebElement ty = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                        String h = ty.getText();
                                                        System.out.println(l);
                                                        if (h.equals("Attach Files")) {
                                                            driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a")).click();
                                                            driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                            driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                            BeforeWH(driver);
                                                            WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                            ss.click();
                                                            Thread.sleep(600);
                                                            AttachFuntn(driver, FilePath);
                                                            System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                            driver.switchTo().frame("ifrmListing");


                                                            driver.switchTo().frame("ifrmDocuments");
                                                            System.out.println("pass");
                                                            driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                        }

                                                    }
                                                    break;
                                                }

                                            } catch (Throwable d) {
                                                Actual = d.getMessage();
                                                Result = "fails";

                                            }


                                        }
                                        Result = "pass";
                                        driver.switchTo().parentFrame();
                                    }
                                    break;


                                } catch (Throwable e) {
                                    Actual = e.getMessage();
                                    Result = "fails";
                                }
                                Result = "pass";
                            } catch (Throwable m) {
                                Actual = m.getMessage();
                                Result = "fails";
                            }

                            break;


                        case "Click on Additional Document":

                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='RadTabStrip1']/div/ul/li/a/span/span"));

                                for (WebElement cell : cells) {
                                    Actvalue = cell.getText();


                                    if (Actvalue.equals(value)) {
                                        cell.click();
                                        break;
                                    }
                                }
                            } catch (Throwable d) {
                                Actual = d.getMessage();
                                Result = "fails";
                            }
                            Result = "pass";
                            break;

                    }
                    break;
                case "SELECT":

                    switch (objectName) {

                        case "Mode of Payment":
                            try {
                                List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='trMode']/td[4]/span"));
                                for (WebElement cell : cells) {

                                    String Ra = cell.getText();
                                    if (cell.equals(value)) {
                                        List<WebElement> RADi = driver.findElements(By.xpath(".//*[@id='trMode']/td[4]/input[" + rr + "]"));
                                        for (WebElement RAD1i : RADi) {
                                            RAD1i.click();
                                        }
                                    }

                                }

                                ++rr;
                                //  break;
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fails";
                            }
                            break;

                        case "Select Bank Name":
                            try {

                                WebElement Bank = driver.findElement(By.xpath(".//*[@id='cboBankName']"));
                                Select combo1 = new Select(Bank);
                                combo1.selectByVisibleText(value);
                                Result = "pass";
                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }
                            WebElement Bank = driver.findElement(By.xpath(".//*[@id='cboBankName']"));
                            Select combo1 = new Select(Bank);
                            combo1.selectByVisibleText(value);

                            break;

                       /* case"Challan Type":
                            driver.switchTo().frame("ifrmListing");
                            WebElement d22=driver.findElement(By.xpath("./*//*[@id='cboChallanType']"));
                            String dd222=d22.getText();

                            Select combo1=new Select(d22);
                            combo1.selectByVisibleText(value);
                            System.out.println(dd222);
                            break;*/
                        case "Select Proposal Risk parameter":

                            try {
                                WebElement d = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[" + x + "]/td[5]/select"));
                                Select combo = new Select(d);
                                combo.selectByVisibleText(value);
                                ++x;
                                ++x;
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Risk paramitter":

                            List<WebElement> cell2 = driver.findElements(By.xpath("html/body/form/table[2]/tbody/tr/td[2]/span"));

                            for (WebElement cell12 : cell2) {
                                String fiels = cell12.getText();
                                if (value.equals(fiels)) {
                                    Result = "pass";
                                    break;
                                }
                                break;
                            }
                            break;


                        case "Proposal Type":
                            try {
                                //applicantMenu=new ApplicantMenu(driver);
                                application.selectProposal_Type(value);
                                Result = "pass";

                            } catch (Throwable g) {
                                Actual = g.getMessage();
                                Result = "Fail";
                            }
                            break;

                        case "Company Activity":
                            Thread.sleep(1000);
                            try {
                                driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                                List<WebElement> cells = driver.findElements(By.xpath("./*//*[@id='cboCompanyActivitys']/option"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))
                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {

                                Actual = e.getMessage();
                                Result = "Fail";
                            }
                            break;

                        case "Proposal Use":
                            try {
                                application.selectProposal_Use(value);
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Plot Possession / A to L Date":
                            try {
                                DateFunpro(driver, "09/08/2017");
                                Result = "pass";

                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Industrial Area":

                            try {
                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                application.selectIndustrial_Area(value);
                                Result = "pass";

                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }

                          /*  application.selectIndustrial_Area(value);
                            Result = "pass";*/
                            break;

                        case "Concerned SPA":
                            try {
                                application.selectConcerned_SPA(value);
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "MPCB Consent":
                            application.selectMPCB_Consent(value);
                            Result = "pass";
                            break;
/*---------------------------------------------- Building Deatials --------------------------------------------------------*/

                        case "Building Use":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions actions = new Actions(driver);
                            actions.moveToElement(application.getBuilding_Use());
                            actions.click();
                            actions.build().perform();
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("./*//*[@class='GLMenuBody GLEnumMenuBody']/div//div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))

                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fail";
                            }
                            break;
                        case "Building Subuse":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions action = new Actions(driver);
                            action.moveToElement(application.getBuilding_Subuse());
                            action.click();

                            action.build().perform();
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("//div[@class='GLMenuMain GLEnumMenuMain']/div/div/div/div/div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))

                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fail";
                            }
                            break;

                        case "Building Type":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions action1 = new Actions(driver);
                            action1.moveToElement(application.getBuilding_Type());
                            action1.click();

                            action1.build().perform();
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("//div[@class='GLMenuMain GLEnumMenuMain']/div/div/div/div/div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))

                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fail";
                            }
                            break;

                        case "Building Strucher":
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            Actions action3 = new Actions(driver);
                            action3.moveToElement(application.getBuilding_Strucher());
                            action3.click();

                            action3.build().perform();
                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                            try {

                                List<WebElement> cells = driver.findElements(By.xpath("//div[@class='GLMenuMain GLEnumMenuMain']/div/div/div/div/div"));

                                for (WebElement cell : cells) {
                                    String fiels = cell.getText();
                                    System.out.println(fiels);

                                    if (fiels.equals(value))

                                        cell.click();
                                    Result = "pass";
                                }
                            } catch (Throwable e) {
                                Actual = e.getMessage();
                                Result = "fail";
                            }
                            break;


                    }
                    break;

                case "SETTEXT":

                    switch (objectName) {

                        case "Enter Keyword for search":
                            try {
                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                Actions actionsff = new Actions(driver);
                                actionsff.moveToElement(driver.findElement(By.xpath(".//*[@id='form1']/div[3]//div[5]/div//div[2]/table/tbody/tr/td[2]/div")));
                                actionsff.doubleClick();
                                actionsff.sendKeys(value);
                                actionsff.build().perform();
                                Result = "pass";

                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }

                            break;
                        case "SWC File No":

                            try {
                                driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
                                driver.findElement(By.xpath(".//*[@id='txtFile']")).sendKeys(value);
                                driver.findElement(By.xpath(".//*//fieldset/table/tbody/tr[4]/td[4]/table/tbody/tr/td[1]/input")).click();
                                Result = "pass";
                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }

                            break;

                        case "UTR No.":
                            try {
                                driver.findElement(By.xpath(".//*[@id='txtPayOrderNo']")).sendKeys(value);
                                Result = "pass";
                            } catch (Throwable j) {
                                Actual = j.getMessage();
                                Result = "fails";
                            }

                            break;
                        case "Branch Name":
                            try {

                                driver.findElement(By.xpath(".//*[@id='txtChequeBranch']")).sendKeys(value);
                                Result = "pass";


                            } catch (Throwable j)

                            {
                                Actual = j.getMessage();
                                Result = "fails";
                            }
                            //   driver.findElement(By.xpath(".//*[@id='txtChequeBranch']")).sendKeys(value);
                            //   Result = "pass";
                            break;


                        case "Set proposed value":
                            try {
                                driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
                                driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[" + x + "]/td[4]/input")).sendKeys(value);
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Proposal Title":
                            try {
                                application.setProposal_Title(value);
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Plot No":
                            try {
                                application.setPlot_No(value);
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Applicant Name":
                            application.setApplicant_Name(value);

                            final String fieldValue9 = application.getApplicant_Name().getAttribute("value");
                            if (fieldValue9.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue9.equals(value)) {
                                    if (!String.matcher(fieldValue9).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                        System.out.println(fieldValue9);
                                        System.out.println(Result);
                                    }
                                } else {
                                    if (Actual.equals(Expected)) {
                                        Result = "pass";
                                    } else {
                                        Result = "Fail";
                                    }
                                }
                            }

                            break;

                        case "Other Structure Area":

                            application.getOther_Structure_Area().clear();
                            application.setOther_Structure_Area(value);

                            final String fieldValue7 = application.getOther_Structure_Area().getAttribute("value");
                            if (fieldValue7.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue7.equals(value)) {

                                    System.out.println(fieldValue7);

                                    if (!Flot.matcher(fieldValue7).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Other Structure Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Shed Area":
                            application.getShed_Area().clear();
                            application.setShed_Area(value);

                            final String fieldValue6 = application.getShed_Area().getAttribute("value");
                            if (fieldValue6.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue6.equals(value)) {

                                    System.out.println(fieldValue6);

                                    if (!Flot.matcher(fieldValue6).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Shed Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "RCC Area":
                            application.getRCC_Area().clear();
                            application.setRCC_Area(value);

                            final String fieldValue5 = application.getRCC_Area().getAttribute("value");
                            if (fieldValue5.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue5.equals(value)) {

                                    System.out.println(fieldValue5);

                                    if (!Flot.matcher(fieldValue5).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "RCC Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Gross Built Up Area":
                            application.getGross_Built_Up_Area().clear();
                            application.setGross_Built_Up_Area(value);

                            final String fieldValue4 = application.getGross_Built_Up_Area().getAttribute("value");
                            if (fieldValue4.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue4.equals(value)) {

                                    System.out.println(fieldValue4);

                                    if (!Flot.matcher(fieldValue4).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Gross Built Up Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Basement Area":
                            application.getBasement_Area().clear();
                            application.setBasement_Area(value);

                            final String fieldValue3 = application.getBasement_Area().getAttribute("value");
                            if (fieldValue3.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue3.equals(value)) {

                                    System.out.println(fieldValue3);

                                    if (!Flot.matcher(fieldValue3).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Basement Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Plot Area":
                            application.getPlot_Area().clear();
                            application.setPlot_Area(value);

                            final String fieldValue2 = application.getPlot_Area().getAttribute("value");
                            if (fieldValue2.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue2.equals(value)) {

                                    System.out.println(fieldValue2);

                                    if (!Flot.matcher(fieldValue2).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Plot Area not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Total Building Height":


                            Thread.sleep(100);
                            application.getTotal_Building_Height().clear();
                            Thread.sleep(2000);
                            application.setTotal_Building_Height(value);

                            final String fieldValue1 = application.getTotal_Building_Height().getAttribute("value");
                            if (fieldValue1.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue1.equals(value)) {

                                    System.out.println(fieldValue1);

                                    if (!Flot.matcher(fieldValue1).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Building Height not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Ready Reckoner Rate":
                            application.getReady_Reckoner_Rate().clear();
                            application.setReady_Reckoner_Rate(value);

                            final String fieldValue = application.getReady_Reckoner_Rate().getAttribute("value");
                            if (fieldValue.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = "Alert message not display.";
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValue.equals(value)) {

                                    System.out.println(fieldValue);

                                    if (!Flot.matcher(fieldValue).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = "Alert message not display .";
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Ready Reckoner Rate not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;

                        case "Land_Ready Reckoner Rate":
                            application.getLand_Ready_Reckoner_Rate().clear();
                            application.setLand_Ready_Reckoner_Rate(value);

                            final String fieldValu = application.getLand_Ready_Reckoner_Rate().getAttribute("value");
                            if (fieldValu.isEmpty()) {
                                try {
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if (Actual.equals(Expected)) {
                                            Result = "pass";
                                        } else {
                                            Result = "Fail";
                                        }
                                        System.out.println(Actual);
                                        //    Thread.sleep(50);

                                    }

                                } catch (Throwable e) {
                                    Actual = e.getMessage();
                                    Result = "Fail";
                                }


                            } else {
                                if (fieldValu.equals(value)) {

                                    //   System.out.println(fieldValue);

                                    if (!Flot.matcher(fieldValu).matches()) {
                                        try {
                                            if ((ExpectedConditions.alertIsPresent()) == null) {
                                                Actual = "Alert message not display.";
                                                Result = "Fail";
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

                                        } catch (Throwable e) {
                                            Actual = e.getMessage();
                                            Result = "Fail";
                                        }
                                    } else {
                                        Result = "pass";
                                    }
                                } else {
                                    Actual = "Ready Reckoner Rate not be accept other than flot value ";

                                    Result = "fail";
                                }
                            }
                            break;
/*---------------------------------------------- Building Deatials --------------------------------------------------------*/

                        case "Building Name":
                            try {
                                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmBuildingDetails");
                                System.out.println("find");
                                Actions actions = new Actions(driver);
                                actions.moveToElement(application.getBuilding_Name());
                                actions.click();
                                actions.click();
                                actions.sendKeys(value);
                                actions.build().perform();
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;
                        case "Building rows":
                            try {
                                System.out.println("find");
                                Actions actions2 = new Actions(driver);
                                actions2.moveToElement(application.getBuilding_Rows());
                                actions2.click();
                                actions2.click();
                                actions2.sendKeys(value);
                                actions2.build().perform();
                                Result = "pass";


                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;

                        case "Building Height":
                            try {
                                System.out.println("find");
                                Actions actions3 = new Actions(driver);
                                actions3.moveToElement(application.getBuilding_Height());
                                actions3.click();
                                actions3.click();
                                actions3.sendKeys(value);
                                actions3.build().perform();
                                Result = "pass";

                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }

                            System.out.println("find");
                            Actions actions3 = new Actions(driver);
                            actions3.moveToElement(application.getBuilding_Height());
                            actions3.click();
                            actions3.click();
                            actions3.sendKeys(value);
                            actions3.build().perform();
                            break;

                        case "Building Floor":
                            try {
                                System.out.println("find");
                                Actions actions4 = new Actions(driver);
                                actions4.moveToElement(application.getBuilding_Floors());
                                actions4.click();
                                actions4.click();
                                actions4.sendKeys(value);
                                actions4.build().perform();
                                Result = "pass";
                            } catch (Throwable g) {
                                Result = "Fails";
                                Actual = g.getMessage();
                            }


                            break;


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


    @DataProvider(name = "hybridData0")
    public Object[][] getDataFromDataprovider1() throws IOException {
        Object[][] object = null;
        FileInputStream fis = new FileInputStream("ExcelData/InputData/ApplicantTestData1.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheet("Applicant");
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

    @DataProvider(name = "hybridData1")
    public Object[][] getDataFromDataprovider() throws IOException {
        Object[][] object = null;
        FileInputStream fis = new FileInputStream("ExcelData/InputData/ApplicantTestData2.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheet("Applicant");
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
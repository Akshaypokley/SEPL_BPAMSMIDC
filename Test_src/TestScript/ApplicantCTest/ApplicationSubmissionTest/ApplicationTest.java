package TestScript.ApplicantCTest.ApplicationSubmissionTest;

import Pages.Applicant_Console.ApplicantMenu;
import Pages.Applicant_Console.Application_Submission.Application;
import Pages.ForgotPasswordConsole;
import Pages.LoginConsole;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;

import static Utilites.AttachFunction.AttachFuntn;
import static Utilites.BeforeWH.BeforeWH;
import static Utilites.DateFunction.DateFun;
import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;
import static Utilites.Windowhander.NewWindow;
import static jxl.format.Colour.*;
import static jxl.format.Colour.LIGHT_TURQUOISE;

/**
 * Created by akshay.pokley on 8/29/2017.
 */
public class ApplicationTest {

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
    static final java.util.regex.Pattern Flot = java.util.regex.Pattern.compile("^[+-]?([0-9]*[.])?[0-9]++$");
    public static   Application application;
    public static  ApplicantMenu applicantMenu;
    public static   String subWindowHandler = null;
    public static   String Actvalue;
    @BeforeMethod
    public  void OutputExcelCreation() throws IOException, BiffException, WriteException {

        sourceDocument = Workbook.getWorkbook(new File("ExcelData/InputData/TestCaseDemo.xls"));
        writableTempSource = Workbook.createWorkbook(new File("ExcelData/InputData/temp.xls"), sourceDocument);
        copyDocument = Workbook.createWorkbook(new File("ExcelData/TestReport/ApplicantReport14.xls"));
        sourceSheet = writableTempSource.getSheet(5);
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
                        "Applicant screen test  report",cellFormat5);
                targetSheet.addCell(lable);
                targetSheet.addCell(l2);
                targetSheet.addCell(l3);
                //targetSheet.addCell(l4);

            }
        }

    }
    @AfterMethod
    public void Clsoed() throws IOException, WriteException
    {

        copyDocument.write();
        copyDocument.close();
        writableTempSource.close();
        sourceDocument.close();

    }

    @Test(dataProvider="hybridData")
    public static void ApplicationTest(String testcaseName,String keyword,String objectName,String value,String Expected) throws Exception {

            if (testcaseName != null && testcaseName.length() != 0) {

                driver = openBrowser("chrome");
                GetUrl("url");
                LogFunction(driver);
                Thread.sleep(200);
                application = new Application(driver);
               applicantMenu = new ApplicantMenu(driver);
                applicantMenu.ClickApplication();
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


                switch (keyword.toUpperCase()) {

                    case "CLICK":
                        String FilePath = "E:\\Akshay\\PWIMS Deployment.pdf";
                        String FilePath2 = "E:\\Akshay\\wew.dwg.dwg";
                        String WinHandleBefore1 = driver.getWindowHandle();
                        switch (objectName) {
/************************************************************************************************/
                            case "Submit":
                                application.clickSave_Submit();
                                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                                WebElement element = driver.findElement(By.xpath("html/body/form/div[1]/table/tbody/tr[2]/td[2]//div/a/span/span"));
                                System.out.println(element.getText());
                                Actions actions = new Actions(driver);
                                actions.moveToElement(element);
                                Thread.sleep(200);
                                actions.click();
                                Thread.sleep(200);
                                actions.build().perform();
                                driver.switchTo().parentFrame();
                                Result = "pass";
                               /* driver.close();*/
                                break;

                            case "Click On proposal ":
                                applicantMenu.ClickSelectProposal();
                                driver.switchTo().frame("ifrmProjectInfo");
                                Result = "pass";
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

                                driver.switchTo().frame("ifrmProjectInfo");
                                try {
                                           if (application.getRiskField().getText().isEmpty()) {
                                        application.ClickRiskFieldMESH();
                                               Thread.sleep(700);
          System.out.println( driver.findElement(By.id("frmRiskFactor")).getText());
                                               Thread.sleep(700);
                                 Result = "pass";
                                    } else {
                                        Result = "pass";
                                    }
                                    System.out.println("done");
                               driver.close();
                                }catch (Throwable i)
                                {
                                    System.out.println(i.getMessage());
                                    System.out.println("Not-done");

                                    driver.close();
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
                                }catch (Throwable p)
                                { System.out.println("Not_Done");
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
                                    }        driver.close();
                                }catch (Throwable p)
                                { System.out.println("Not_Done");
                                    System.out.println("************");
                                    System.out.println(p.getMessage());
                                    /* driver.close(); */
                                }
                                break;

                            case "Send To Scrunity":
                                try {
                                   // Thread.sleep(30);
                                    driver.switchTo().frame("ifrmToolbar");
                                    application.ClickSendScunity();
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                        Alert alert = driver.switchTo().alert();

                                        //  Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept();
                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert2 = driver.switchTo().alert();

                                            //  Actual = driver.switchTo().alert().getText();
                                            Thread.sleep(300);
                                            alert2.accept();
                                        }

                                        if ((ExpectedConditions.alertIsPresent()) == null) {

                                        } else {
                                            Alert alert3 = driver.switchTo().alert();

                                            //  Actual = driver.switchTo().alert().getText();
                                            Thread.sleep(300);
                                            alert3.accept();
                                        }
                                    }        //driver.close();
                                }catch (Throwable p)
                                { System.out.println("Not_Done");
                                    System.out.println("************");
                                    System.out.println(p.getMessage());
                                    /* driver.close(); */
                                }
                                break;
/*---------------------------------------------- Building Deatials --------------------------------------------------------*/
                            case "File Name":
                                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                                try {

                                    List<WebElement> cells = driver.findElements(By.xpath(".//*[@id='ListProposalGrid']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr/td[3]"));

                                    for (WebElement cell : cells) {
                                        String fiels = cell.getText();
                                        System.out.println(fiels);

                                        if (fiels.equals(value))
                                            cell.click();

                                        Result = "pass";
                                    }
                                } catch (Throwable e) {
                                }
                                break;

                            case "Click on Building Deatils":
                                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                application.ClickBuildig_Deatils_Tab();
                                break;

                            case "Click on Submit Building":
                                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                application.ClickBuilding_Submit();
                                driver.switchTo().parentFrame();

                                break;
/*---------------------------------------------- Drawing Deatials --------------------------------------------------------*/
                            case "Attach Drawing":
                                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                application.ClickDrawing_Tab();
                                driver.switchTo().frame("ifrmDrawings");
                                String St = application.getDrawing_Data().getText();
                                if (St.equals("No data found")) {
                                    driver.findElement(By.id("btnAttached")).click();
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
                                        alert.accept();   Thread.sleep(70);
                                        driver.switchTo().parentFrame();                    }

                                } else {
                                    driver.findElement(By.id("btnAttached")).click();
                                    if ((ExpectedConditions.alertIsPresent()) == null) {

                                    } else {
                                        Alert alert = driver.switchTo().alert();

                                        //  Actual = driver.switchTo().alert().getText();
                                        Thread.sleep(300);
                                        alert.accept(); Thread.sleep(70);
                                        driver.switchTo().parentFrame();

                                    }
                                }

                                Result = "pass";
                                break;
/*---------------------------------------------- Document Deatials --------------------------------------------------------*/
                            case "Click on Document Tab":
                                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                application.ClickDocument_Tab();
                                driver.switchTo().frame("ifrmDocuments");
                                Result = "pass";
                                break;

                            case "Click On Types Of Document":
                                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
                                    System.out.println(e.getMessage());
                                }
                                Result = "pass";
                                break;

                            case "Attch medatory doc":
                                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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
                                                        Thread.sleep(400);
                                                        WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[2]"));
                                                        String d = fiels3.getText();
                                                        System.out.println(d);

                                                        WebElement df = driver.findElement(By.xpath(".//*[@id='category_Doc" + k + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                        String y = df.getText();
                                                        if (!y.equals("Attach Files")) {
                                                            System.out.println("E");
                                                        } else {
                                                            df.click();
                                                            System.out.println(k);
                                                            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                                                            driver.switchTo().frame("RadWindowContentFrameRadWindowManager2_RadPopupWindow");
                                                            driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();


                                                            BeforeWH(driver);
                                                            WebElement ss = driver.findElement(By.id("RadAsyncUpload1file0"));
                                                            ss.click();
                                                            Thread.sleep(600);
                                                            AttachFuntn(driver, FilePath);
                                                            System.out.println(driver.switchTo().window(WinHandleBefore1));
                                                            driver.switchTo().frame("ifrmListing");
                                                            Thread.sleep(70);

                                                            driver.switchTo().frame("ifrmDocuments");
                                                      System.out.println("pass");
                                                            driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                            System.out.println(k);
                                                        }

                                                    } catch (Throwable d) {
                                                        System.out.println(d.getMessage());
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
                                                        Thread.sleep(400);
                                                        WebElement fiels3 = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[2]"));
                                                        String d = fiels3.getText();
                                                        System.out.println(d);

                                                        Thread.sleep(400);
                                                        WebElement ty = driver.findElement(By.xpath(".//*[@id='category_Doc" + l + "']/div/table/tbody/tr[2]/td[3]/a"));
                                                        String h = ty.getText();
                                                        System.out.println(l);
                                                        if (!h.equals("Attach Files")) {
                                                        } else {
                                                            ty.click();
                                                            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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


                                                    } catch (Throwable d) {
                                                        System.out.println(d.getMessage());

                                                    }

                                                }

                                            }

                                        } else {
                                            System.out.println("NoCC");
                                        }

                                    }
                                } catch (Throwable e) {
                                    System.out.println(e.getMessage());
                                }
                                Result = "pass";
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
                                                            System.out.println("pass");   Thread.sleep(70);
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
                                                                System.out.println("pass");        System.out.println("pass");   Thread.sleep(70);
                                                                driver.findElement(By.xpath("html/body/span/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/img")).click();

                                                            }

                                                        }

                                                        break;
                                                    } else {
                                                        System.out.println("Document not Availble");
                                                    }
                                                } catch (Throwable ls) {

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
                                                    System.out.println(d.getMessage());

                                                }


                                            }
                                                Result= "pass";
                                            driver.switchTo().parentFrame();
                                        }
                                        break;


                                    } catch (Throwable e) {
                                        System.out.println(e.getMessage());
                                    }
                                    Result = "pass";
                                } catch (Throwable m) {
                                    System.out.println(m.getMessage());
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
                                    System.out.println(d.getMessage());
                                }
                                Result = "pass";
                                break;

                        }
                        break;
                    case "SELECT":

                        switch (objectName) {
                            case "Proposal Type":
                                application.selectProposal_Type(value);
                                Result = "pass";
                                break;

                            case "Company Activity":
                                Thread.sleep(60);
                                try {
                                    List<WebElement> cells = driver.findElements(By.xpath("./*//*[@id='cboCompanyActivitys']/option"));

                                    for (WebElement cell : cells) {
                                        String fiels = cell.getText();
                                        System.out.println(fiels);

                                        if (fiels.equals(value))
                                            cell.click();
                                        Result = "pass";
                                    }
                                } catch (Throwable e) {
                                }
                                break;

                            case "Proposal Use":
                                application.selectProposal_Use(value);
                                Result = "pass";
                                break;

                            case "Plot Possession / A to L Date":
                                DateFun(driver, "09/08/2017");
                                Result = "pass";
                                break;

                            case "Industrial Area":
                                application.selectIndustrial_Area(value);
                                Result = "pass";
                                break;

                            case "Concerned SPA":
                                application.selectConcerned_SPA(value);
                                Result = "pass";
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
                                    System.out.println(e);
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
                                    System.out.println(e);
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
                                    System.out.println(e);
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
                                    System.out.println(e);
                                }
                                break;


                        }
                        break;
                    case "SETTEXT":

                        switch (objectName) {
                            case "Proposal Title":
                                application.setProposal_Title(value);
                                Result = "pass";
                                break;

                            case "Plot No":
                                application.setPlot_No(value);
                                Result = "pass";
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
                                Thread.sleep(80);
                                application.getTotal_Building_Height().clear();
                                Thread.sleep(80);
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
                                        Actual = "Alert message not display.";
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
/*---------------------------------------------- Building Deatials --------------------------------------------------------*/

                            case "Building Name":

                                // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                driver.switchTo().frame("ifrmBuildingDetails");
                                System.out.println("find");
                                Actions actions = new Actions(driver);
                                actions.moveToElement(application.getBuilding_Name());
                                actions.click();
                                actions.click();
                                actions.sendKeys(value);
                                actions.build().perform();
                                break;
                            case "Building rows":

                                System.out.println("find");
                                Actions actions2 = new Actions(driver);
                                actions2.moveToElement(application.getBuilding_Rows());
                                actions2.click();
                                actions2.click();
                                actions2.sendKeys(value);
                                actions2.build().perform();
                                break;

                            case "Building Height":

                                System.out.println("find");
                                Actions actions3 = new Actions(driver);
                                actions3.moveToElement(application.getBuilding_Height());
                                actions3.click();
                                actions3.click();
                                actions3.sendKeys(value);
                                actions3.build().perform();
                                break;

                            case "Building Floor":

                                System.out.println("find");
                                Actions actions4 = new Actions(driver);
                                actions4.moveToElement(application.getBuilding_Floors());
                                actions4.click();
                                actions4.click();
                                actions4.sendKeys(value);
                                actions4.build().perform();
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

    @DataProvider(name="hybridData")
    public Object[][] getDataFromDataprovider() throws IOException {
        Object[][] object = null;
        FileInputStream fis = new FileInputStream("ExcelData/InputData/ApplicantTestData.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheet("Sheet1");
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
